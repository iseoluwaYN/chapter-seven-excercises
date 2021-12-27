package cards;

public class Card {
    private String suits;
    private String face;

    public Card(String suits, String face) {
        this.suits = suits;
        this.face = face;
    }

    @Override
    public String toString() {
        return face + " of "+ suits;
    }
}
