package game.gesture;

public enum Gesture {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors"),
    LIZARD("Lizard"),
    ZOMBIE("Zombie"),
    SPOCK("Spock"),
    LHC("Large Hadron Collider");

    private String label;

    Gesture(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean beats(Gesture other) {
        return GestureOrder.getHierarchy().get(this).containsValue(other);
    }
}
