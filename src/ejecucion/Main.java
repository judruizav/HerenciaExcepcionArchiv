/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;
import java.util.InputMismatchException;
import java.util.Scanner;
import ui.UI;
import Exception.DVDException;
import Exception.SoporteException;
import Exception.LibroException;
import Exception.CDException;

/**
 *
 * @author fabian.giraldo
 */
public class Main {

    public static void main(String[] args) throws DVDException, SoporteException, LibroException, CDException{
        //Luego se aplicara el patron arquitectonico Modelo - Vista - Controlador
        UI vista = new UI();
        Scanner scanner = new Scanner(System.in);
        boolean indicador = false;
        int opcion = 0;
        int c=0;
        while(indicador == false){
            
               c= vista.menu(c);
               System.out.println("Desea continuar...1. Si 2. No");
               opcion = scanner.nextInt();
               System.out.println(c);
               if(opcion != 1)
                  indicador = true;
           
             
        }
    }
    
}
