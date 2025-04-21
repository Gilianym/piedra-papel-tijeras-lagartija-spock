/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pedrapapertisoresllangardaixspock;

import java.util.Scanner;

/**
 *
 * @author gmmdl
 */
public class PedraPaperTisoresLlangardaixSpock {
    
    static Scanner sc = new Scanner(System.in);
    
        public static void main(String[] args) {
       
        final int PUNTOS_GANADOR = 3;
        int[][] movimiento = {
                              {0, -1, 1, 1, -1},
                              {1, 0, -1, -1, 1}, 
                              {-1, 1, 0, 1, -1}, 
                              {-1, 1, 1, -1, 1}, 
                              {1, -1, 1, -1, 0}
                             };
        
        String[] jugades = {"pedra", "paper", "tisores", "llangardaix", "spock"};
        
        boolean otraPartida = true;
        while(otraPartida){   
            int ronda = 1;
            int puntosHuma = 0;
            int puntosOrde = 0;

            boolean finalPartid = false;
            do{
                System.out.printf("Ronda: %d [Jugador: %d - Ordinador: %d]\n",ronda,puntosHuma,puntosOrde);
                int jugadaHuma      = jugadaHuma();
                int jugadaOrdinador = jugadaOrdinador();
                System.out.print("El jugador ha tret " + jugades[jugadaHuma] + ". ");
                System.out.print("L' ordinador ha tret " + jugades[jugadaOrdinador] + ". ");

                switch (movimiento[jugadaHuma][jugadaOrdinador]){
                    case 0:
                        System.out.println("Empat. ");
                        break;
                    case 1:
                        System.out.println("Guanya el jugador!!");
                        puntosHuma++;
                        break;
                    case -1: 
                        System.out.println("Guanya l'ordinador!!");
                        puntosOrde++;
                        break;
                }
                System.out.println("");
                if(puntosHuma == PUNTOS_GANADOR || puntosOrde == PUNTOS_GANADOR){
                    System.out.println("La partida ha acabat en " + ronda + " rondes. ");
                    System.out.println("El marcador ha estat:");
                    System.out.println("Jugador: " + puntosHuma + " - Ordinador: " + puntosOrde );
                    finalPartid = true;
                }
                ronda++;
            }while(!finalPartid);
            sc.nextLine();
            System.out.print("Vols fer una nova partida? [S/N]: ");
            System.out.println("");
            char opcion = sc.nextLine().toLowerCase().charAt(0);
            if(opcion == 's'){
                otraPartida = true;
            }
            else{
                otraPartida = false;
            }
        }
    }
    static int jugadaHuma(){
        
        System.out.print("pedra(0), paper(1), tisores(2), llangardaix(3), spock(4): ");
        int jugada = sc.nextInt();
        
        return jugada;
    }

    static int jugadaOrdinador(){
        
        int jugada = (int)(Math.random()*(5 - 0)) + 0;
        return jugada;
    } 
}
