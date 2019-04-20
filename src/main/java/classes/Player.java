package classes;

import java.util.*;

public class Player extends Thread{
    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public int getEdad() {
        return age;
    }

    public void setEdad(int edad) {
        this.age = edad;
    }

    @Override
    public void run() {
        List<Character> alphabet = new ArrayList<Character>();
        alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

        int wordsQuantity = Connect.getWordQuantity();
        String word = Connect.getWord((int)(Math.random()*wordsQuantity)+1);

        System.out.println("-- Jugador: "+this.getNombre()+" --");
        System.out.println("-- Palabra a adivinar: "+word+" --");

        List<Character> arrayWord = new ArrayList<Character>();
        for (Character c : word.toCharArray()){
            arrayWord.add(c);
        }

        List<Character> discardArray = new ArrayList<Character>();
        List<Character> winningArray = new ArrayList<Character>();
        for (int i=0;i<arrayWord.size();i++){
            winningArray.add('_');
        }

        int remaining = 10;
        while(remaining > 0 && !winningArray.equals(arrayWord)){
            char randomCharacter = alphabet.get((int)((Math.random()*alphabet.size())+1)-1);
            if(!discardArray.contains(randomCharacter)){
                if(arrayWord.contains(randomCharacter)){
                    for (int index = 0; index <= arrayWord.size()-1; index++){
                        if(arrayWord.get(index).equals(randomCharacter)){
                            winningArray.set(index, randomCharacter);
                        }
                    }
                }
                else{
                    remaining --;
                }
                discardArray.add(randomCharacter);
            }
            System.out.println("\n** El jugador "+this.getNombre()+" eligio la letra "+randomCharacter+" **");
            System.out.println("Palabra: "+winningArray);
            System.out.println("Letras ya utilizadas: "+discardArray);
            System.out.println("Intentos restantes: "+remaining+"\n");
        }

        if(remaining == 0){
            System.out.println("El jugador "+this.getNombre()+" ha perdido\n");
        }
        else{
            System.out.println("¡El jugador "+this.getNombre()+" ha ganado\n!");
            Connect.setWinner(this.getNombre(), word);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "nombre='" + name + '\'' +
                ", edad=" + age +
                '}';
    }
}
