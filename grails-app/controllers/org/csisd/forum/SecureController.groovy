package org.csisd.forum

import grails.plugin.springsecurity.annotation.Secured

class SecureController {

    def index() { render 'secured page' }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def publicPage() { render 'public page' }

    @Secured(['IS_AUTHENTICATED_FULLY'])
    def securePage() { render 'AUTHENTICATED_FULLY page' }

    @Secured(['ROLE_ADMIN'])
    def adminPage() {
        render "admin role page"
    }

    @Secured(['ROLE_USER'])
    def userPage() {
        render "user role page"
    }
}
