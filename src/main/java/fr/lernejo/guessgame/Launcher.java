package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;

import java.security.SecureRandom;

public class Launcher {

    public static Simulation simulation;
    public static long maxLoop;
    public static Logger logger = new ConsoleLogger();

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 exclus et 100 inclus

        if(args.length > 0 && args[0].equals("-interactive")) {
            simulation = new Simulation(new HumanPlayer());
            maxLoop = Long.MAX_VALUE;
            simulation.initialize(randomNumber);
        } else if (args.length > 1 && args[0].equals("-auto") && args[1].matches("-?\\d+(\\.\\d+)?")) {
            maxLoop = 1000;
            simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(Integer.parseInt(args[1]));
        } else {
            logger.log("Your must write arguments to play :\n - To play with the game, enter '-interactive'; \n - To let the computer play, enter '-auto' and a positiv number that it will try to find.");
            System.exit(-1);
        }

        logger.log("The number to guess is between 0 and 100.");
        simulation.loopUntilPlayerSucceed(maxLoop);

    }
}
