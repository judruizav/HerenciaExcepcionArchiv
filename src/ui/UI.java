/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.LibroException;
import data.Soporte;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.ServicioSoporte;
import Exception.SoporteException;
import Exception.DVDException;
import Exception.LibroException;
import Exception.CDException;

/**
 *
 * @author fabian.giraldo
 */
public class UI {
    private Scanner sc ;
    private ServicioSoporte servicio;
    
    
    public UI(){
      this.sc = new Scanner(System.in);
      this.servicio = new ServicioSoporte();
    }
         
    public void imprimirSoportes(ArrayList<Soporte> soportes){
        if(soportes != null){
          for(Soporte soporte: soportes){
              System.out.println(soporte);
          }
        }else{
            System.out.println("No existen soportes actualmente");
        }
   }
    
    public void menu() {
        int opcion = 0; 
        System.out.println("Bienvenido a la mediateca");
        System.out.println("Opciones. 1. Cargar datos 2. Imprimir. 3. Buscar por titulo");
        opcion = this.sc.nextInt();
        if(opcion == 1){
           System.out.println("Nombre del archivo: ");
           String rutaArchivo =   sc.next();
            try {
                this.servicio.cargarSoportes(rutaArchivo);
            } catch (FileNotFoundException ex) {
                System.out.println("El archivo especificado no existe");
            } catch (LibroException ex) {
                System.out.println(ex.getMessage());
            } catch (DVDException ex){
                System.out.println(ex.getMessage());
            } catch (SoporteException ex){
                System.out.println(ex.getMessage());
            }  catch (CDException ex){
                System.out.println(ex.getMessage());
            }
        }
        else if(opcion == 2){
           ArrayList<Soporte> soportes = this.servicio.getSoportes();
           this.imprimirSoportes(soportes);
        }
        if(opcion == 3){
          System.out.println("Ingrese titulo a buscar");
          String titulo= sc.next();
          Soporte soporte = this.servicio.buscarSoporte(titulo);
          if(soporte != null){
            System.out.println(soporte);
            System.out.println("Desea pedirlo prestado? 1. Si 2. No");
            int opc = this.sc.nextInt();
            if(opc == 1){
            try{
              if(soporte.getPrestado()){
                throw new SoporteException("El material ya esta prestado");    
              }    
            }catch(SoporteException ex){
              System.out.println(ex.getMessage());
            }
              this.servicio.PrestarMaterial(soporte);        
            }
          }else{
            System.out.println("No existe material disponible");
          }
        }
        else if(opcion!=1&&opcion!=2&&opcion!=3){
            System.out.println("Opcion invalida");
        }        
    }   
}