package org.csisd.forum

import org.csisd.user.User

class Comment {
    static searchable = true
    static belongsTo = DiscussionThread
    DiscussionThread thread
    User commentBy
    String body
    Date createDate = new Date()
    static constraints = {
        body( maxSize: 8000)
    }
    String toString() {body}
}
