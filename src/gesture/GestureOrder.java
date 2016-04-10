package gesture;

import java.util.HashMap;
import java.util.Map;

import static gesture.Gesture.*;

public class GestureOrder {
    /**
     * A HashMap that represents the hierarchy of gestures within the game.<br>
     *<br>
     * Key: A Gesture<br>
     * Value: A HashMap of the gestures it beats and the corresponding verb
     */
    private static final Map<Gesture, Map<Gesture, String>> HIERARCHY;

    public static Map<Gesture, Map<Gesture, String>> getHierarchy() {
        return HIERARCHY;
    }

    /**
     * Compares two Gestures for which one beats the other
     *
     * @param a Gesture 1
     * @param b Gesture 2
     * @return the winning gesture
     */
    public static Gesture getSuperior(Gesture a, Gesture b) {
        return a.beats(b) ? a : b;
    }

    static {
        // Initialize the hierarchy using anonymous classes
        HIERARCHY = new HashMap<Gesture, Map<Gesture, String>>() {{
            put(ROCK, new HashMap<Gesture, String>() {{
                put(SCISSORS, "blunts");
                put(LIZARD, "crushes");
                put(ZOMBIE, "trips");
            }});

            put(PAPER, new HashMap<Gesture, String>() {{
                put(SPOCK, "disproves");
                put(LHC, "reprograms");
                put(ROCK, "covers");
            }});

            put(SCISSORS, new HashMap<Gesture, String>() {{
                put(PAPER, "cuts");
                put(ZOMBIE, "stabs");
                put(LIZARD, "decapitates");
            }});

            put(LIZARD, new HashMap<Gesture, String>() {{
                put(PAPER, "eats");
                put(LHC, "evades");
                put(SPOCK, "poisons");
            }});

            put(ZOMBIE, new HashMap<Gesture, String>() {{
                put(SPOCK, "brains");
                put(PAPER, "shreds");
                put(LIZARD, "swallows");
            }});

            put(SPOCK, new HashMap<Gesture, String>() {{
                put(SCISSORS, "bends");
                put(LHC, "deactivates");
                put(ROCK, "vaporizes");
            }});

            put(LHC, new HashMap<Gesture, String>() {{
                put(ROCK, "nukes");
                put(ZOMBIE, "cures");
                put(SCISSORS, "magnetizes");
            }});
        }};
    }
}
