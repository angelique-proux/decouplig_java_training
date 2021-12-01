package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    public Logger logger = LoggerFactory.getLogger("computer");
    public long randomNumber;
    public int low = 0;
    public int up = 100;

    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        randomNumber = random.nextInt(low, up); // génère un nombre entre low (inclus) et up (exclus)
        logger.log("Computer's number : " + randomNumber);
        return randomNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            logger.log("Computer's number is lower than the number to find.");
            low = (int) randomNumber;
        } else {
            logger.log("Computer's number is greater than the number to find.");
            up = (int) randomNumber;
        }
    }
}
