<%@ page import="org.csisd.forum.DiscussionThread" %>

<div class="fieldcontain ${hasErrors(bean: discussionThreadInstance, field: 'topic', 'error')} required">
    <label for="topic">
        <g:message code="discussionThread.topic.label" default="Topic" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="topic" name="topic.id" from="${org.csisd.forum.Topic.list()}" optionKey="id" required="" value="${discussionThreadInstance?.topic?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: discussionThreadInstance, field: 'opener', 'error')} required">
	<label for="opener">
		<g:message code="discussionThread.opener.label" default="Opener" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="opener" name="opener.id" from="${org.csisd.user.User.list()}" optionKey="id" required="" value="${discussionThreadInstance?.opener?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: discussionThreadInstance, field: 'subject', 'error')} required">
	<label for="subject">
		<g:message code="discussionThread.subject.label" default="Subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" required="" value="${discussionThreadInstance?.subject}" size="60"/>

</div>


