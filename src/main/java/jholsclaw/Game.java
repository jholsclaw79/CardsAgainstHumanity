package jholsclaw;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import java.io.*;
import java.util.*;

class Game {

    private List<WhiteCard> whiteDeck;
    private List<BlackCard> blackDeck;
    private List<Player> playersList;
    private List<WhiteCard> usedCards;
    private Scanner scanner = new Scanner(System.in);

    Game(){
        whiteDeck = createWhiteDeck();
        blackDeck = createBlackDeck();
        playersList = createPlayers();
        usedCards = new ArrayList<>();
        printPlayers();
    }

    private List<WhiteCard> createWhiteDeck(){
        try {
            List<WhiteCard> list;
            HeaderColumnNameTranslateMappingStrategy<WhiteCard> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
            strategy.setType(WhiteCard.class);
            strategy.setColumnMapping(WhiteCard.getHashMap());
            list = new CsvToBeanBuilder<WhiteCard>(new FileReader(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("WhiteCards.csv")).getFile()))).withMappingStrategy(strategy).withType(WhiteCard.class).build().parse();
            Collections.shuffle(list);
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<BlackCard> createBlackDeck(){
        try {
            List<BlackCard> list;
            HeaderColumnNameTranslateMappingStrategy<BlackCard> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
            strategy.setType(BlackCard.class);
            strategy.setColumnMapping(BlackCard.getHashMap());
            list = new CsvToBean<BlackCard>().parse(strategy, new CSVReader(new FileReader(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("BlackCards.csv")).getFile()))));
            Collections.shuffle(list);
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Player> createPlayers(){
        List<Player> list = new ArrayList<>();
        System.out.println("How many People are playing?");
        int playerCount = scanner.nextInt();
        while(list.size()<playerCount){
            System.out.println("Enter Player Name:");
            Player player = new Player(scanner.next());
            if(list.contains(player))
                System.out.println("A Player already exists with this name!");
            else {
                player.fillHand(whiteDeck);
                list.add(player);
            }
        }
        return list;
    }

    private void printPlayers(){
        for(Player p : playersList){
            System.out.println(p.getName());
            p.printHand();
            System.out.println("----------------");
        }
    }

    int getWhiteDeckSize(){
        return whiteDeck.size();
    }

    int getBlackDeckSize() {
        return blackDeck.size();
    }
}
