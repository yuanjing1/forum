<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Win!</title>
    </head>
    <body>
        <div class="body">
            <h1>Win!</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                         <tr class="prop">
                            <td valign="top" class="name">My Winning Roll</td>
                            <td valign="top" class="value">${roll}</td>
                        </tr>
                    
                    </tbody>
                </table>
                
                <g:link controller="game" action="game">Again!</g:link>
            </div>
        </div>
    </body>
</html>
