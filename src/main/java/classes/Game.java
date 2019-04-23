package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static String word;
    private static List<Character> alphabet = new ArrayList<Character>();
    private static List<Character> arrayWord = new ArrayList<Character>();
    private static List<Character> discardArray = new ArrayList<Character>();
    private static List<Character> winningArray = new ArrayList<Character>();
    private static int remaining;

    public Game() {

    }

    public static void setInitialGame(){
        alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        //int wordsQuantity = Connect.getWordQuantity();
        //word = Connect.getWord((int)(Math.random()*wordsQuantity)+1);
        word = "hipotalamo";
        for (Character c : word.toCharArray()){
            arrayWord.add(c);
        }
        for (int i = 0; i< arrayWord.size(); i++){
            winningArray.add('_');
        }
        remaining = 10;
    }

    public static String getWord() {
        return word;
    }

    public static void setWord(String word) {
        Game.word = word;
    }

    public static List<Character> getAlphabet() {
        return alphabet;
    }

    public static void setAlphabet(List<Character> alphabet) {
        Game.alphabet = alphabet;
    }

    public static List<Character> getArrayWord() {
        return arrayWord;
    }

    public static void setArrayWord(List<Character> arrayWord) {
        Game.arrayWord = arrayWord;
    }

    public static List<Character> getDiscardArray() {
        return discardArray;
    }

    public static void setDiscardArray(Character randomCharacter) {
        discardArray.add(randomCharacter);
    }

    public static List<Character> getWinningArray() {
        return winningArray;
    }

    public static void setWinningArray(int index, Character randomCharacter) {
        winningArray.set(index, randomCharacter);
    }

    public static int getRemaining() {
        return remaining;
    }

    public static void setRemaining(int remaining) {
        Game.remaining = remaining;
    }
}
