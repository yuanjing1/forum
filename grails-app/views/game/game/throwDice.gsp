<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Play A Game</title>
    </head>
    <body>
        <div class="body">
            <h1>Play A Game</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            
            <div class="buttons">
	            <g:form action="game">
				    <g:submitButton name="throwDice" value="Throw Dice"></g:submitButton>
				</g:form>
            </div>
        </div>
    </body>
</html>
