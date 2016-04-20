/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class CD extends Soporte{
    private int duracion;
    private ArrayList<Autor> musicos;
    private String genero;
    
    public CD(String titulo, ArrayList<Autor> musicos, int duracion, String genero){
      super(titulo);
      this.duracion = duracion;
      this.musicos = musicos;
      this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public ArrayList<Autor> getArtistas() {
        return musicos;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setArtistas(ArrayList<Autor> musicos) {
        this.musicos = musicos;
    }
    
    
    
    
}
