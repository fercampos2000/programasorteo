/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Metodos.metodossorteo;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FERCAMPOS
 */
public class mainsorteo {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opcion=0;
        do{
        Scanner esc = new Scanner(System.in);
        new metodossorteo().obtiene();
        System.out.println("Desea seguir utilizando el programa?\nIngrese:\n1. Si\n2. No");
        opcion = esc.nextInt();
        }while(opcion!=2);
        
    }
    
}
