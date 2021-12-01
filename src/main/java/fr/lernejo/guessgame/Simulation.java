package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        logger.log("Enter a number");
        long numberUser = player.askNextGuess();
        if(numberUser == this.numberToGuess) {
            logger.log("You guessed the number ! It was " + numberUser + ".");
            return true;
        } else if(numberUser <= this.numberToGuess) {
            player.respond(true);
        } else {
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        while (!nextRound());
    }
}
