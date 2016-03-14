<%@ page import="org.csisd.forum.DiscussionThread" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Grails Forum</title>
	</head>
	<body>
        <g:each in="${sections}" var="section">
            <div class="section">
                <div class="sectionTitle">
                    <g:link controller="section" action="show" id="${section.id}">${section.title}</g:link>
                </div>
                <g:each in="${section.topics.sort{it.title}}" var="topic">
                    <div class="topic">
                        <g:link controller="forum" action="topic" params="[topicId:topic.id]" >
                            ${topic.title}
                        </g:link>
                        <span class="topicDesc">${topic.description}</span>

                        <div class="rightInfo">
                            <b>threads</b>: ${topic.findNumberOfThreads()}
                            <b>replies</b>: ${topic.findNumberOfReplies()}
                        </div>
                    </div>
                </g:each>
            </div>
        </g:each>
	</body>
</html>
