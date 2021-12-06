package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("-interactive") && args.length == 1) {
                long MAX_VALUE = 150;
                Simulation simulation = new Simulation(new HumanPlayer());
                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
                simulation.initialize(randomNumber);
                System.out.println(randomNumber);
                simulation.loopUntilPlayerSucceed(MAX_VALUE);
            } else if (args[0].equals("-auto") && args.length == 2) {
                try {
                    long value = Long.parseLong(args[1]);
                    //number
                    long MAX_VALUE = 100;
                    Simulation simulation1 = new Simulation(new ComputerPlayer());
                    simulation1.initialize(value);
                    System.out.println(value);
                    simulation1.loopUntilPlayerSucceed(MAX_VALUE);
                } catch (NumberFormatException e) {
                    // not a number
                }
            } else {
                System.out.println("Veuillez rentrez -interactive ou -auto et un nombre positif");

            }
        } else {
            System.out.println("Veuillez rentrez un argument");
        }

    }
}

