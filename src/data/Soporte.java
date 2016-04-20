/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
/**
 *
 * @author fabian.giraldo
 */
public class Soporte {
    private String titulo;
    private Autor autor;
    private boolean prestado;

    public Soporte (String titulo){
      this.titulo = titulo;
      this.prestado = false;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    
    @Override
    public String toString() {
        return "Soporte{" + "titulo=" + titulo + ", autor=" + autor + '}';
    }
}