package org.csisd.forum

class Topic {
    static searchable = true
    static belongsTo = Section
    static hasMany = [threads:DiscussionThread]
    Section section
    String title
    String description

    static constraints = {
        description nullable: true
    }
    public long findNumberOfThreads() {
        DiscussionThread?.countByTopic(this)
    }

    public long findNumberOfReplies() {
        Topic.executeQuery("select count(*) from Topic t join t.threads thr join thr.comments c where t.id = :topicId", [topicId:id])[0]
    }
    String toString() {"$title: $description"}
}
