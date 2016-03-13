package org.csisd.forum

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
@Transactional(readOnly = true)
class CommentController {
    static scaffold = Comment
}
