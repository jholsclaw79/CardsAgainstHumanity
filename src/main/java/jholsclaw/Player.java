package jholsclaw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    private String name;
    private int points;
    private ArrayList<WhiteCard> hand;
    private ArrayList<WhiteCard> wonCards;

    public Player(String name){
        this.name = name;
        points = 0;
        hand = new ArrayList<>();
        wonCards = new ArrayList<>();
    }

    public void fillHand(List<WhiteCard> deck){
        for(int i=hand.size();i<=7;i++){
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void printHand(){
        for(WhiteCard wc : hand){
            System.out.println(wc.getText());
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}