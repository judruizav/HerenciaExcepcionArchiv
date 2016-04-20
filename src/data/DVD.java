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
    
    public DVD (String titulo, ArrayList<Autor> autores, ArrayList<Autor> actores, int duracion){
      super(titulo);
      this.autores = autores;
      this.actores= actores;
      this.duracion= duracion;
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
    

    
    
    
    
}
