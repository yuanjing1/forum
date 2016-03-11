package org.csisd.forum

class Section {
    static searchable = true
    static hasMany = [topics:Topic]
    String title
    static constraints = {
    }
    String toString() {title}
}
