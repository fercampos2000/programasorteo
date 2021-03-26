/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import BaseConexion.clsConexion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import modelos.Datos;

/**
 *
 * @author FERCAMPOS
 */
public class metodossorteo {
  
    private Datos[] lista = null;
    private int totalFilas = 0;

    //cargamos todos los nombres a un array
    public Datos[] obtiene() throws IOException {
        
        ResultSet rs1 = null;
        // abrimos la conexion
        clsConexion conexion = new clsConexion();
        //despues de abrir la conexion pasamos el queryto de la seleccion de la lista de nombres
        rs1 = conexion.EjecutarSeleccion("SELECT * FROM listanombre");
        int filaActual = 0;
        try {
            //revisamos el numero de filas total que hay 
            while (rs1.next()) {
                ++totalFilas;
            }
            if (totalFilas != 0) {
                rs1.beforeFirst();
                lista = new Datos[totalFilas];
                //agregamos todos los nombres de personas
                while (rs1.next()) {
                    try {
                        lista[filaActual] = new Datos();
                       lista[filaActual].setNombre(rs1.getString("nombres"));
                        filaActual++;
                        //catch por si tenemos errores al agregar los nombres
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }// fin
                //llamamos la ejecucion del metodo sorteo 
                sorteo();
            } //fin
            //catch por si tenemos errores
        } catch (SQLException e) {
            System.out.print("error" + e.getMessage());
        }
        //retornamos la lista de nombres
        return lista;
    }//fin metodo listar
    
    //metodo sorteo
    public void sorteo() throws IOException {
        int contador = 100;
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String nom = "", opcion = "";
        //Igualamos un String a el Array de listar
        for (int i = 0; i < totalFilas; i++) {
            nom += lista[i].getNombre() + ",";
        }
        //Igualamos una variable con la cadena de texto y por medio de un split se separan todos los nombres
        List<String> myList = new ArrayList<>(Arrays.asList(nom.split(",")));
            System.out.println("\n\t\tOPCIONES:\n1. Seleccionar 10 personas entre todos los participantes");
            System.out.println("\n2. Mostrar todas las personas que estan participando");
            System.out.println("\n3. Salir del programa\n\n");
            opcion = br.readLine();
            
            int opcionswitch = Integer.parseInt(opcion);
            
            switch(opcionswitch){
                case 1:
                     //Utilizamos un collections sort para ordenar los nombres aleatoriamente
                    Collections.sort(myList);
                    System.out.println("\nLas 10 personas seleccionadas son:");
                    //Imprimimos en consola los 10 nombres usando un for
                    for (int i = 0; i < 10; i++) {
                        String nn = myList.get(i);
                        System.out.println("\nPuesto " + (i + 1) + ": " + nn);
                        contador--;
                        //Luego vamos eliminando los nombres en esa posición de la lista para que ya no se vuelva a repetir 
                        myList.remove(i);
                    }
                    break;
                    
                case 2:
                    //ordena alfabeticamente
                    Collections.sort(myList);
                    int cuenta = 0;
                    System.out.println("\nTodos los participantes:");
                    //Mostramos la lista de participantes 
                    for (String m : myList) {
                        cuenta++;
                        System.out.print("\n  -"+cuenta+". "+ m);
                    }
                    System.out.println("\n");
                    break;
                    
                case 3:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opcion ingresada no encontrada o no disponible intente de nuevo");
                    break;
            }
    }//fin metodo sorteo
}
