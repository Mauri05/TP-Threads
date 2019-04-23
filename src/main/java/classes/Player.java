package classes;

import java.util.*;

public class Player extends Thread{
    private String name;
    private int age;
    private static boolean jugar = true;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean getJugar() {
        return jugar;
    }

    public void setJugar(boolean jugar) {
        this.jugar = jugar;
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
        while(Game.getRemaining() > 0 && !Game.getWinningArray().equals(Game.getArrayWord())){
            this.play();
        }

        if(Game.getRemaining() == 0){
            System.out.println("El jugador "+this.getNombre()+" ha perdido\n");
        }
        else{
            System.out.println("¡El jugador "+this.getNombre()+" ha ganado\n!");
            Connect.setWinner(this.getNombre(), Game.getWord());
        }
    }

    public synchronized void play(){
        if(this.getJugar()==true){
            char randomCharacter = Game.getAlphabet().get((int)((Math.random()*Game.getAlphabet().size())+1)-1);
            if(!Game.getDiscardArray().contains(randomCharacter)){
                if(Game.getArrayWord().contains(randomCharacter)){
                    for (int index = 0; index <= Game.getArrayWord().size()-1; index++){
                        if(Game.getArrayWord().get(index).equals(randomCharacter)){
                            Game.setWinningArray(index, randomCharacter);
                            System.out.println("\n** El jugador "+this.getNombre()+" eligio la letra "+randomCharacter+" **");
                            System.out.println("Palabra: "+Game.getWinningArray());
                            System.out.println("Letras ya utilizadas: "+Game.getDiscardArray());
                            System.out.println("Intentos restantes: "+Game.getRemaining()+"\n");
                        }
                    }
                }
                else{
                    Game.setRemaining(Game.getRemaining()-1);
                    System.out.println("\n** El jugador "+this.getNombre()+" eligio la letra "+randomCharacter+" **");
                    System.out.println("Palabra: "+Game.getWinningArray());
                    System.out.println("Letras ya utilizadas: "+Game.getDiscardArray());
                    System.out.println("Intentos restantes: "+Game.getRemaining()+"\n");
                    notifyAll();
                    this.setJugar(false);
                }
                Game.setDiscardArray(randomCharacter);
            }
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setJugar(true);
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
