package org.csisd.forum

import grails.transaction.Transactional

@Transactional(readOnly = true)
class SectionController {
    static scaffold = Section
}
