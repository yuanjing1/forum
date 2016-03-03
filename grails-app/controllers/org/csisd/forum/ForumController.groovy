package org.csisd.forum

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
@Transactional(readOnly = true)
class ForumController {
    def springSecurityService

    def index() {
        // show ip address of the attempted access
        def ipAdr = request.getHeader("x-forwarded-for")
        if (ipAdr == null) {
            ipAdr = request.getRemoteAddr()
        }
        log.error ipAdr

        [sections:Section.listOrderByTitle()]
    }

    def topic(long topicId) {
        Topic topic = Topic.get(topicId)

        params.max = 10
        params.sort = 'createDate'
        params.order = 'desc'

        [threads:DiscussionThread.findAllByTopic(topic, params),
         numberOfThreads:DiscussionThread.countByTopic(topic), topic:topic]
    }

    def thread(long threadId) {
        DiscussionThread thread = DiscussionThread.get(threadId)

        params.max = 10
        params.sort = 'createDate'
        params.order = 'asc'

        [comments:Comment.findAllByThread(thread, params),
         numberOfComments:Comment.countByThread(thread), thread:thread]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def postReply(long threadId, String body) {
        def offset = params.offset
        if (body != null && body.trim().length() > 0) {
            DiscussionThread thread = DiscussionThread.get(threadId)
            def commentBy = springSecurityService.currentUser
            new Comment(thread:thread, commentBy:commentBy, body:body).save()

            // go to last page so user can view his comment
            def numberOfComments = Comment.countByThread(thread)
            def lastPageCount = numberOfComments % 10 == 0 ? 10 : numberOfComments % 10
            offset = numberOfComments - lastPageCount
        }
        redirect(action:'thread', params:[threadId:threadId, offset:offset])
    }
}

