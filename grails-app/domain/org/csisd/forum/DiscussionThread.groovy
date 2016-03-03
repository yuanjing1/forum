package org.csisd.forum

import org.csisd.user.User

class DiscussionThread {
    static belongsTo = Topic
    static hasMany = [comments:Comment]
    Topic topic
    String subject
    User opener
    Date createDate = new Date()

    public long getNumberOfReplies() {
        Comment.countByThread(this)
    }

    static constraints = {
    }
}
