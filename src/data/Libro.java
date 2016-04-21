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
public class Libro extends Soporte{
    private String isbn;
    private int numPaginas ;  
    
    public Libro(String isbn, String titulo, int numPaginas) {
        super(titulo);
        this.isbn = isbn;
        this.numPaginas=numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString() {
        
        return "Libro{" + super.toString() +" isbn{" + isbn + "}" +" Numero de paginas{" + numPaginas + '}';
    }
    
    
    
}
