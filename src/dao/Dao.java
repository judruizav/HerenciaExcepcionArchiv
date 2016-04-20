/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exception.LibroException;
import Exception.DVDException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Autor;
import data.DVD;
import data.Libro;
import data.Soporte;
import data.CD;
import Exception.SoporteException;
import Exception.CDException;
import servicio.ServicioSoporte;

/**
 * @author fabian.giraldo
 * Luego va ser mejorada
 */
public class Dao {
         
    public Autor cargarAutor(Scanner sc) {
	Autor autor = null;
	String nombre = sc.next().trim();
        String apellido = sc.next().trim();
        autor = new Autor(nombre, apellido);
        return autor;
        
    }
        
    public Libro cargarLibro(Scanner sc) throws LibroException, SoporteException{
	Libro libro = null;
	String titulo = sc.next().trim();
        if(titulo.length()>100){
            throw new SoporteException("Se superó el limite estipulado de caracteres");
        }
        
        if(titulo.length()< 5){
           throw new LibroException("Titulo incorrecto" + titulo);
        }
        Autor autor = cargarAutor(sc);
        int numPaginas = sc.nextInt();
        if(numPaginas < 10){
           throw new LibroException("El libro no puede tener menos de 10 paginas");
        }
	String isbn = sc.next().trim();	
        libro = new Libro(isbn, titulo, numPaginas);
        libro.setAutor(autor);
        return libro;
    }
    
    public DVD cargarDVD(Scanner sc) throws DVDException, SoporteException{
      DVD dvd= null;
      ArrayList<Autor> actores= new ArrayList<Autor>();
      ArrayList<Autor> autores= new ArrayList<Autor>();
      String titulo = sc.next().trim();
      int c=0;
      Autor autor = cargarAutor(sc);
      while(sc.hasNextInt()== false){
        autores.add(cargarAutor(sc));
        c++;
        if(c<1){
          throw new DVDException("Se debe ingresar el autor");
        }
        if (c>5){
          throw new DVDException("El DVD no puede tener mas de 5 autores"); 
        }
      }
      if(titulo.length()>100){
          throw new SoporteException("Se superó el limite estipulado de caracteres");
      } 
      int duracion= sc.nextInt();
      if(duracion>20){
          throw new DVDException("El DVD no puede durar mas de 20 min");
      }
      actores.add(autor);
      dvd= new DVD(titulo, autores, actores, duracion);
      return dvd;
    }
    
    public CD cargarCD(Scanner sc) throws SoporteException, CDException{
      CD cd= null;
      ArrayList<Autor> musicos = new ArrayList<Autor>();
      String titulo = sc.next().trim();
      if(titulo.length()>100){
        throw new SoporteException("Se superó el limite estipulado de caracteres");
      }
      while(!sc.hasNextInt()){
        musicos.add(cargarAutor(sc)); 
      }      
      int duracion = sc.nextInt();
      if(duracion<10 || duracion>200){
          throw new CDException("La duracion del video debe ser entre 10 min y 200 min");
      }
      String genero= sc.next();
      cd = new CD(titulo, musicos, duracion, genero);
      return cd;
    }
    
    public Soporte leerSoporte(Scanner sc) throws LibroException, DVDException, SoporteException, CDException{
	String type = sc.next().trim();
	if (type.equals("Libro")) return cargarLibro(sc);
        else if(type.equals("DVD")) return cargarDVD(sc); //Se debe completar
        else if(type.equals("CD")) return cargarCD(sc);
        return null;
    }
    
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, LibroException, SoporteException, DVDException, CDException{
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner sc;
	sc = new Scanner(new File(archivo));
	sc.useDelimiter(",");
	while (sc.hasNext()) { 
            soportes.add(leerSoporte(sc));
	}	
	return soportes;
   }
    
}
