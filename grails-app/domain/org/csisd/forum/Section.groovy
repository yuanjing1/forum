package org.csisd.forum

class Section {
    static hasMany = [topics:Topic]
    String title
    static constraints = {
    }
    String toString() {title}
}
