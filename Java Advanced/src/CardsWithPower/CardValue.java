package CardsWithPower;


public class CardValue {

    private Card card;
    private Suits suits;

    public CardValue(Card card, Suits suits) {
        this.card = card;
        this.suits = suits;
    }


    private int CardPower(){
        return this.card.getValue() + this.suits.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d"
        ,this.card,this.suits,CardPower());
    }
}
