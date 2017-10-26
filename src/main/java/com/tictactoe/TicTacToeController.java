package com.tictactoe;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.bl.TicTacToeService;

@RestController
public class TicTacToeController {

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
    TicTacToeService ticTacToeService = new TicTacToeService();

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
    
    @RequestMapping("/new")
    public TicTacToe newGame() {
    	System.out.println("New Game Request");
    	if(ticTacToeService.getStatus() == null) {
    		System.out.println("Game In Progress");
    		 return ticTacToeService.getNewGame();
    	}
        return null;
    }

    @RequestMapping("/play")
    public TicTacToe playMove(@RequestParam(value="player") String player, @RequestParam(value="x") String x, @RequestParam(value="y") String y) {
    	if(ticTacToeService.getStatus() != null) {
   		 	return ticTacToeService.playMove(Player.getPlayer(Integer.parseInt(player)), Integer.parseInt(x), Integer.parseInt(y));
    	}
    	return null;
    }
    
    @RequestMapping("/status")
    public TicTacToe getStatus() {
    	if(ticTacToeService.getStatus() != null) {
    		 return ticTacToeService.getStatus();
    	}
        return null;
    }
}
