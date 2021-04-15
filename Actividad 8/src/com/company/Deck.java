package com.company;
import java.util.*;

public class Deck {
    private ArrayList<Object> deck = new ArrayList<>();

    public static void main(String[] args) {
        //Crear array Deck y llamar los métodos 
        Deck deck = new Deck();
        deck.create();

        //Se imprime el menu de opciones
        Scanner scanner = new Scanner(System.in);
        int value = 5;
        System.out.println("Bienvenido a Poker!");
        System.out.println("Selecciona una opción:");
        System.out.println("1 -> Mezclar deck");
        System.out.println("2 -> Sacar una carta");
        System.out.println("3 -> Carta al azar");
        System.out.println("4 -> Generar una mano de 5 cartas");
        System.out.println("0 -> Salir");

        do {
            value = scanner.nextInt();
            switch (value)
            {
                case 0:
                    System.out.println("Gracias por jugar");
                    break;
                case 1:  deck.shuffle();
                    break;
                case 2:  deck.head();
                    break;
                case 3:  deck.pick();
                    break;
                case 4:  deck.hand();
                    break;
                default: System.out.println("Número no valido");
            }
        } while (value != 0);
    }

    //Llenar deck
    public void create(){
        Card card = new Card();
        int x = 0, y = 0, z = 0;

        for (int i=0; i < 52; i++ ){
            if (i < 13){
                deck.add(card.Palo[0]+", "+card.Color[1]+", "+card.Valor[i]);
            } else if(i > 12 & i < 26){
                deck.add(card.Palo[1]+", "+card.Color[0]+", "+card.Valor[x]);
                x++;
            } else if(i > 25 & i <39){
                deck.add(card.Palo[2]+", "+card.Color[1]+", "+card.Valor[y]);
                y++;
            } else {
                deck.add(card.Palo[3]+", "+card.Color[0]+", "+card.Valor[z]);
                z++;
            }
        }
    }

    //Método Shuffle
    public void shuffle (){
        Collections.shuffle(deck);
        System.out.println("Se mezcló el deck");
    }

    //Método Head
    public void head(){
        System.out.println("Primera carta del deck");
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("Quedan: "+deck.size());
    }

    //Método Pick
    public void pick(){
        int value = (int)((Math.random()*50));
        System.out.println("Elegir una carta del deck");
        System.out.println(deck.get(value));
        deck.remove(value);
        System.out.println("Quedan: "+deck.size());
    }

    //Método Hand
    public void hand(){
        int i = 50;
        for(int x = 0; x < 5; x++){
            int value = (int)((Math.random()*i));
            System.out.println(deck.get(value));
            deck.remove(value);
            i--;
        }
        System.out.println("Quedan: "+deck.size());
    }
}

class Card {
    String[] Palo = new String[]{"Tréboles","Corazones","Picas","Diamantes"};
    String[] Color = new String[]{"Rojo","Negro"};
    String[] Valor = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
}
