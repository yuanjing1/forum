package org.csisd.forum

class Topic {
    static belongsTo = Section
    static hasMany = [threads:DiscussionThread]
    Section section
    String title
    String description

    static constraints = {
    }
    public long getNumberOfThreads() {
        DiscussionThread.countByTopic(this)
    }

    public long getNumberOfReplies() {
        Topic.executeQuery("select count(*) from Topic t join t.threads thr join thr.comments c where t.id = :topicId", [topicId:id])[0]
    }
}
