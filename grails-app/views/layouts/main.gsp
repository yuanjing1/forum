<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<div id="grailsLogo" role="banner">

      <div id="header">
        <g:form url='[controller: "searchable", action: "index"]' id="searchableForm" name="searchableForm" method="get">
          <g:textField name="q" value="${params.q}" size="50"/> <input type="submit" value="Search" />
        </g:form>
        <div style="clear: both; display: none;" class="hint">See <a href="http://lucene.apache.org/java/docs/queryparsersyntax.html">Lucene query syntax</a> for advanced queries</div>
      </div>

      <g:link uri="/">Home</g:link>
      <div style="float:right;">
        <sec:ifLoggedIn>
          Hi <sec:username/>

          <sec:ifAllGranted roles='ROLE_ADMIN'>
            <g:link controller="user">User</g:link>
            <g:link controller="section">Section</g:link>
            <g:link controller="topic">Topic</g:link>
            <g:link controller="discussionThread">DiscussionThread</g:link>
            <g:link controller="admin">Admin</g:link>
          </sec:ifAllGranted>

          <g:link controller="logout">Logout</g:link>
        </sec:ifLoggedIn>
        <sec:ifNotLoggedIn>
          <g:link controller="login" action="auth">Login</g:link>
        </sec:ifNotLoggedIn>
      </div>
    </div>

<sec:ifAllGranted roles='ROLE_ADMIN'>
    <div class="nav" role="navigation">
        <nav:primary/>
        <nav:secondary/>
    </div>
</sec:ifAllGranted>

    <g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
