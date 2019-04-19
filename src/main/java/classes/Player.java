package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Thread{
    private String nombre;
    private int edad;

    public Player(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void run() {
        List<Character> alphabet = new ArrayList<Character>();
        alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

        int wordsQuantity = Connect.getWordQuantity();
        char[] arrayWord = Connect.getWord((int)(Math.random()*wordsQuantity)+1).toCharArray();

        List<Character> discardArray = new ArrayList<Character>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
