
<%@ page import="org.csisd.forum.Comment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comment.label', default: 'Comment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-comment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-comment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list comment">

                <g:if test="${commentInstance?.thread}">
                    <li class="fieldcontain">
                        <span id="thread-label" class="property-label"><g:message code="comment.thread.label" default="Thread" /></span>

                        <span class="property-value" aria-labelledby="thread-label"><g:link controller="discussionThread" action="show" id="${commentInstance?.thread?.id}">${commentInstance?.thread?.encodeAsHTML()}</g:link></span>

                    </li>
                </g:if>

				<g:if test="${commentInstance?.commentBy}">
				<li class="fieldcontain">
						<span class="property-label" aria-labelledby="commentBy-label">
                            On <g:formatDate format="MMM d, yyyy" date="${commentInstance?.createDate}" />,
                            ${commentInstance?.commentBy?.encodeAsHTML()} commented:
                        </span>

                        <span class="property-value" aria-labelledby="body-label"><g:fieldValue bean="${commentInstance}" field="body"/></span>

                </li>
                </g:if>

            </ol>
			<g:form url="[resource:commentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${commentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

                <sec:ifAllGranted roles='ROLE_ADMIN'>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </sec:ifAllGranted>

                    </fieldset>
			</g:form>
		</div>
	</body>
</html>
