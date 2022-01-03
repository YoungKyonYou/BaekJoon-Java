package Programmers;

public class CardGame {
    public static void main(String[] args) {
        Card[] card = new Card[52];
        int idx = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card c = new Card(i, j + 1);
                card[idx++] = c;
            }
        }
        System.out.println();
    }
}

class Card {
    private int type;
    private int number;

    Card(int type, int number) {
        this.type = type;
        this.number = number;
    }
}
