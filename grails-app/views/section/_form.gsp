<%@ page import="org.csisd.forum.Section" %>



<div class="fieldcontain ${hasErrors(bean: sectionInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="section.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${sectionInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sectionInstance, field: 'topics', 'error')} ">
	<label for="topics">
		<g:message code="section.topics.label" default="Topics" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${sectionInstance?.topics?}" var="t">
    <li><g:link controller="topic" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="topic" action="create" params="['section.id': sectionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'topic.label', default: 'Topic')])}</g:link>
</li>
</ul>


</div>

