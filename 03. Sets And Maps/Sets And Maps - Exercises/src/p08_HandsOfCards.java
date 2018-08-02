import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p08_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, HashSet<String>> playersWithCards = new LinkedHashMap<>();
        String[] input = reader.readLine().split(": ");
        while(!"JOKER".equals(input[0])){
            String playerName = input[0];
            String[] cards = input[1].split(", ");
            if(!playersWithCards.containsKey(playerName)){
                playersWithCards.put(playerName, new HashSet<>());
            }
            Set<String> cardsInSet = new HashSet<>();
            Collections.addAll(cardsInSet, cards);
            playersWithCards.get(playerName).addAll(cardsInSet);
            input = reader.readLine().split(": ");
        }

        for (Map.Entry<String, HashSet<String>> player : playersWithCards.entrySet()) {
         int cardsValue = calculateCardsValue(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), cardsValue);
        }
    }

    private static int calculateCardsValue(HashSet<String> cards) {
        int value = 0;
        for (String card : cards) {
            int cardValue = calculateCard(card);
            value+=cardValue;
        }
        return value;
    }

    private static int calculateCard(String card) {
        int cardValue = 1;
        char[] characters = card.toCharArray();
        try {
            if (characters.length==3){
                cardValue *= Integer.parseInt(characters[0] + "" + characters[1]);
            } else {
                cardValue *= Integer.parseInt(characters[0] + "");
            }
        } catch (Exception ex) {
            switch (characters[0]){
                case 'J':
                    cardValue *= 11;
                    break;
                case 'Q':
                    cardValue *= 12;
                    break;
                case 'K':
                    cardValue *= 13;
                    break;
                case 'A':
                    cardValue *= 14;
                    break;
            }
        }
        char type;
        if (characters.length==2) {
            type = characters[1];
        } else {
            type = characters[2];
        }
            switch (type) {
                case 'S':
                    cardValue *= 4;
                    break;
                case 'H':
                    cardValue *= 3;
                    break;
                case 'D':
                    cardValue *= 2;
                    break;
                case 'C':
                    cardValue *= 1;
                    break;
            }
        return cardValue;
    }
}
