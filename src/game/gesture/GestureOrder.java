package game.gesture;

import java.util.HashMap;
import java.util.Map;

import static game.gesture.Gesture.*;

public class GestureOrder {
    private static final Map<Gesture, Map<String, Gesture>> HIERARCHY;

    public static Map<Gesture, Map<String, Gesture>> getHierarchy() {
        return HIERARCHY;
    }

    public static Gesture getSuperior(Gesture a, Gesture b) {
        return a.beats(b) ? a : b;
    }

    static {
        HIERARCHY = new HashMap<Gesture, Map<String, Gesture>>() {{
            put(ROCK, new HashMap<String, Gesture>() {{
                put("blunts", SCISSORS);
                put("crushes", LIZARD);
            }});

            put(PAPER, new HashMap<String, Gesture>() {{
                put("disproves", SPOCK);
                put("reprograms", LHC);
            }});

            put(SCISSORS, new HashMap<String, Gesture>() {{
                put("cuts", PAPER);
                put("stabs", ZOMBIE);
            }});

            put(LIZARD, new HashMap<String, Gesture>() {{
                put("eats", PAPER);
                put("evades", LHC);
            }});

            put(ZOMBIE, new HashMap<String, Gesture>() {{
                put("brains", SPOCK);
                put("shreds", PAPER);
            }});

            put(SPOCK, new HashMap<String, Gesture>() {{
                put("bends", SCISSORS);
                put("deactivates", LHC);
            }});

            put(LHC, new HashMap<String, Gesture>() {{
                put("nukes", ROCK);
                put("cures", ZOMBIE);
            }});
        }};
    }
}
