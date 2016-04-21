/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class DVD extends Soporte {
    private ArrayList<Autor> actores;
    private ArrayList<Autor> autores;
    private int duracion;
    private int año;
    
    public DVD (String titulo, ArrayList<Autor> autores, ArrayList<Autor> actores, int duracion, int año){
      super(titulo);
      this.autores = autores;
      this.actores= actores;
      this.duracion= duracion;
      this.año= año;
    }

    public void setActores(ArrayList<Autor> actores) {
        this.actores = actores;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Autor> getActores() {
        return actores;
    }

    public int getDuracion() {
        return duracion;
    }
    
    public String imprimirAutores(ArrayList<Autor> autores){
      String imprimir= "";
      for(int i=0; i<autores.size(); i++){ 
        imprimir= autores.get(i).toString();
      }
      return imprimir;
    }
    
    @Override
    public String toString(){
      return "DVD{ " + super.toString() + imprimirAutores(this.autores) + "Duracion{ " + this.duracion + "}" + imprimirAutores(this.actores) + "Año{" + this.año + "}"; 
    }
    
    
    
}
