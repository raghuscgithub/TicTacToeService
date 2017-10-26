package com.tictactoe;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.bl.TicTacToeService;

@RestController
public class TicTacToeController {

    TicTacToeService ticTacToeService = new TicTacToeService();
    
    @RequestMapping("/new")
    public String newGame() throws JsonGenerationException, JsonMappingException, IOException {
    	if(ticTacToeService.getStatus() == null) {
    		return getResponseString(ticTacToeService.getNewGame());
    	}
        return null;
    }

    @RequestMapping("/play")
    public String playMove(@RequestParam(value="player") String player, @RequestParam(value="x") String x, @RequestParam(value="y") String y) throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException {
    	if(ticTacToeService.getStatus() != null) {
   		 	return getResponseString(ticTacToeService.playMove(Player.getPlayer(Integer.parseInt(player)), Integer.parseInt(x), Integer.parseInt(y)));
    	}
    	return null;
    }
    
    @RequestMapping("/status")
    public String getStatus() throws JsonGenerationException, JsonMappingException, IOException {
    	if(ticTacToeService.getStatus() != null) {
    		 return getResponseString(ticTacToeService.getStatus());
    	}
        return null;
    }
    
    private String getResponseString(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
    	ObjectMapper objMapper = new ObjectMapper();
    	return objMapper.writeValueAsString(obj);
    }
}
