package game;

import gesture.Gesture;
import gesture.GestureOrder;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Runs a simulation game of RPSLZSLHC
 */
public class Game {
    private static final Gesture[] gestures;
    private static final Random rand;
    private static int cpuWins, userWins;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean replay;

        do {
            Gesture userGesture;

            // Continuously ask for input until valid input is received
            while (true) {
                System.out.printf("Please choose your gesture %s: ", Arrays.toString(gestures));
                String gestInput = input.nextLine();
                Optional<Gesture> gestOp = parseGesture(gestInput);

                if (gestOp.isPresent()) {
                    userGesture = gestOp.get();
                    break;
                } else {
                    System.out.println("Sorry, I didn't understand that. Please try again.\n");
                }
            }

            Gesture cpuGesture = getRandomGesture();
            System.out.printf("\nComputer chose %s.\n\n", cpuGesture.getLabel());

            handleOutcome(userGesture, cpuGesture);

            System.out.println("\nDo you want to play again (y/n)? ");
            String again = input.nextLine();
            replay = again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes");

            System.out.println();
        } while (replay);

        System.out.println("Thanks for playing!");

        input.close(); // resource management
    }

    private static void handleOutcome(Gesture user, Gesture cpu) {
        if (user == cpu) {
            System.out.printf("TIE! You both chose '%s'.", user.getLabel());
            return;
        }

        boolean userWon = user.beats(cpu);

        if (userWon)
            userWins++;
        else
            cpuWins++;

        Gesture winner = userWon ? user : cpu, loser = userWon ? cpu : user;

        System.out.printf("%s %s %s.\n", winner.getLabel(), GestureOrder.getHierarchy().get(winner).get(loser), loser.getLabel());
        System.out.printf("You %s\n", userWon ? "WON!" : "lost.");
        System.out.printf("User wins: %d; CPU wins: %d.\n", userWins, cpuWins);
    }

    /**
     * Finds the Gesture that matches the passed string.<br>
     * <br>
     * In the future this will utilize the Levenshtein distance to find the <i>closest</i> match rather than an exact.
     *
     * @param str name of Gesture
     * @return an optional container that contains the gesture if found, empty otherwise
     */
    private static Optional<Gesture> parseGesture(final String str) {
        return Stream.of(gestures)
                .filter(g -> (g.getLabel().equalsIgnoreCase(str) || g.name().equalsIgnoreCase(str)))
                .findFirst();
    }

    private static Gesture getRandomGesture() {
        return gestures[rand.nextInt(gestures.length)];
    }

    static {
        gestures = Gesture.values();
        rand = new Random();
        cpuWins = userWins = 0;
    }

}
