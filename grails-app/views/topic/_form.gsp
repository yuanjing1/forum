<%@ page import="org.csisd.forum.Topic" %>




<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'section', 'error')} required">
	<label for="section">
		<g:message code="topic.section.label" default="Section" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="section" name="section.id" from="${org.csisd.forum.Section.list()}" optionKey="id" required="" value="${topicInstance?.section?.id}" class="many-to-one"/>

</div>



<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="topic.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${topicInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="topic.description.label" default="Description" />

    </label>
    <g:textField name="description" value="${topicInstance?.description}" size="60"/>

</div>
