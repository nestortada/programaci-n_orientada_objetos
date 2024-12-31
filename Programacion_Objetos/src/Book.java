import java.util.ArrayList;

public class Book {

    private String titile;
     private Autor Author;
     private String sypnosis;
     private float ISBN;
     private String genero;
     private int año;
     private Editorial editorial;
     private int N_paginas;
     private double precio;
     private int cantidad;
     private boolean disponble;

    public Book(){

    }

    public Book(String titile){
        this.titile = titile;
    }
    public Book(String titile, Autor Author, String sypnosis, Editorial editorial){
        this.titile = titile;
        this.Author = Author;
        this.sypnosis = sypnosis;
        this.editorial =editorial;
        this.año = año;

    }

    public Book(String titile, Autor author, String sypnosis, float ISBN, String genero, int año, Editorial editorial, int n_paginas, double precio, int cantidad, boolean disponble) {
        this.titile = titile;
        this.Author = author;
        this.sypnosis = sypnosis;
        this.ISBN = ISBN;
        this.genero = genero;
        this.año = año;
        this.editorial = editorial;
        this.N_paginas = n_paginas;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponble = disponble;
    }

    public Book(float ISBN, String genero, double precio, int cantidad) {
        this.ISBN = ISBN;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public Autor getAuthor() {
        return this.Author;
    }

    public String getNameAutor(){
        return this.getAuthor().getNombre() + " "+ this.getAuthor().getApellido();
    }
    public void setAuthor(Autor author) {
        Author = author;
    }

    public String getSypnosis() {
        return sypnosis;
    }

    public void setSypnosis(String sypnosis) {
        this.sypnosis = sypnosis;
    }

    public float getISBN() {
        return ISBN;
    }

    public void setISBN(float ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public String getNombreEditorial(){
        return this.getEditorial().getName();
    }

    public int getN_paginas() {
        return N_paginas;
    }

    public void setN_paginas(int n_paginas) {
        N_paginas = n_paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDisponble() {
        if ( getCantidad() == 0 ){
            return disponble;
        }else{
            return false;
        }
    }

    public void setDisponble(boolean disponble) {
        this.disponble = disponble;
    }



     private String prefixTitle(){
        return  "1. "+this.titile;
     }
     public void  printPrefixTitle(){
        System.out.println(this.prefixTitle());
     }
     public void existeLibro(String libro, ArrayList<Book> listaLibros){
        if (libro == "libro1"){


        }
     }
     public void setArray(){

     }
}
