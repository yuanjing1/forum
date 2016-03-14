<%@ page import="org.csisd.forum.Section" %>



<div class="fieldcontain ${hasErrors(bean: sectionInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="section.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${sectionInstance?.title}"/>

</div>
