package com.tictactoe;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.bl.TicTacToeService;
import com.tictactoe.bl.Error;

@RestController
public class TicTacToeController {

    TicTacToeService ticTacToeService = new TicTacToeService();
    
    @RequestMapping("/new")
    public String newGame() throws JsonGenerationException, JsonMappingException, IOException {
    	if(ticTacToeService.getStatus() == null) {
    		return getResponseString(ticTacToeService.getNewGame());
    	} else {
    		Error err = new Error("Game is Inprogress, Cannot create a new Game");
    		return getResponseString(err);
    	}
    }

    @RequestMapping("/play")
    public String playMove(@RequestParam(value="player") String player, @RequestParam(value="x") String x, @RequestParam(value="y") String y) throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException {
    	if(ticTacToeService.getStatus() != null) {
    		if(ticTacToeService.getStatus().getPlayStatus() != PlayStatus.COMPLETE) {
   		 		return getResponseString(ticTacToeService.playMove(Player.getPlayer(Integer.parseInt(player)), Integer.parseInt(x), Integer.parseInt(y)));
    		} else {
    			Error err = new Error("Game Over..!! Create a new game");
    			return getResponseString(err);
    		}
    	} else {
    		Error err = new Error("No Game In progress");
    		return getResponseString(err);
    	}
    }
    
    @RequestMapping("/status")
    public String getStatus() throws JsonGenerationException, JsonMappingException, IOException {
    	if(ticTacToeService.getStatus() != null) {
    		 return getResponseString(ticTacToeService.getStatus());
    	} else {
    		Error err = new Error("No Game In progress, Create a new game");
    		return getResponseString(err);
    	}
    }
    
    private String getResponseString(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
    	ObjectMapper objMapper = new ObjectMapper();
    	return objMapper.writeValueAsString(obj);
    }
}
