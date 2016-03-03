package org.csisd.forum



import grails.test.mixin.*
import spock.lang.*

@TestFor(SectionController)
@Mock(Section)
class SectionControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.sectionInstanceList
            model.sectionInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.sectionInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def section = new Section()
            section.validate()
            controller.save(section)

        then:"The create view is rendered again with the correct model"
            model.sectionInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            section = new Section(params)

            controller.save(section)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/section/show/1'
            controller.flash.message != null
            Section.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def section = new Section(params)
            controller.show(section)

        then:"A model is populated containing the domain instance"
            model.sectionInstance == section
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def section = new Section(params)
            controller.edit(section)

        then:"A model is populated containing the domain instance"
            model.sectionInstance == section
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/section/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def section = new Section()
            section.validate()
            controller.update(section)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.sectionInstance == section

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            section = new Section(params).save(flush: true)
            controller.update(section)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/section/show/$section.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/section/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def section = new Section(params).save(flush: true)

        then:"It exists"
            Section.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(section)

        then:"The instance is deleted"
            Section.count() == 0
            response.redirectedUrl == '/section/index'
            flash.message != null
    }
}
