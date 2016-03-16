package com.bowerstudios.webflowgame

class GameController {

    def gameFlow = {
    	
    	initialize {
    	   action {  
    	       def winningValue = (Math.random() * 10).intValue()
    	       log.debug "winning value is ${winningValue}"
    	       
    	       [ winningValue: winningValue ] // this model will be used in views
    	   }
    	   on ("success").to "throwDice"
        }

    	throwDice {
    	    on("throwDice"){
    			flow.roll = (Math.random() * 10).intValue()
    			log.debug "Dice Thrown, on to branchIt"
    	    }.to "branchIt"
    	}
    	
    	branchIt {
    		action{
    			if( flow.roll == flow.winningValue ){
    				log.debug ("winner branch")
    				return win()
    			}else{
    				log.debug ("loser branch")
    				return lose()
    			}
    		}
    		on("win").to "win"
    		on("lose").to "lose"
    	}
    	   
    	win {
    		//end the flow
    		//can't put any code in here to run though, it is a view only
    	}
    	   
    	lose {
    		//end the flow
    		//can't put any code in here to run though, it is a view only
    	}
    }
                             
    def index = {
        redirect(action: "game")
    }
}
