<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Lose!</title>
    </head>
    <body>
        <div class="body">
            <h1>Lose!</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                         <tr class="prop">
                            <td valign="top" class="name">My Losing Roll</td>
                            <td valign="top" class="value">${roll}</td>
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name">To win you needed</td>
                            <td valign="top" class="value">${winningValue}</td>
                        </tr>
                    
                    </tbody>
                </table>
                
                <g:link controller="game" action="game">Again!</g:link>
            </div>
        </div>
    </body>
</html>
