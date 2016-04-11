package gesture;

/**
 * Enum representation of all Gestures within the game
 */
public enum Gesture {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    ZOMBIE,
    SPOCK,
    LHC("Large Hadron Collider");

    private String label;

    Gesture() {
        final String name = this.name();
        this.label = name.charAt(0) + name.toLowerCase().substring(1);
    }

    Gesture(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Uses the Gesture order hierarchy to check if this Gesture beats the passed Gesture
     *
     * @param other the gesture to be compared to
     * @return true if this Gesture beats the passed, false otherwise
     */
    public boolean beats(Gesture other) {
        return GestureOrder.getHierarchy().get(this).containsKey(other);
    }
}
