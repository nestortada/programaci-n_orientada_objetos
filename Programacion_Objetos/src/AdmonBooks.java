import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.Scanner;

public class AdmonBooks {

    public AdmonBooks(){

    }
    private Book book;
    private Autor autor1 = new Autor("Nombre del Autor", "Apellido del Autor", "Nacionalidad", "Biografía del Autor", 35);
    private Autor autor2 = new Autor("Juan", "Pérez", "Mexicana", "Escritor prolífico", 40);
    private Autor autor3 = new Autor("Maria", "Gomez", "Española", "Poeta reconocida", 55);
    private Autor autor4 = new Autor("Carlos", "López", "Argentina", "Novelista famoso", 48);
    private Autor autor5 = new Autor("Laura", "Rodríguez", "Colombiana", "Autora de libros infantiles", 32);
    private Editorial editorial1 = new Editorial("Editorial ABC", "Ciudad Ejemplo", "Calle Principal 123", 123456789);
    private Editorial editorial2 = new Editorial("Editorial XYZ", "Ciudad A", "Calle 456", 987654321);
    private Editorial editorial3 = new Editorial("Libros Innovadores", "Ciudad B", "Avenida Principal 789", 555555555);
    private Editorial editorial4 = new Editorial("Ediciones Modernas", "Ciudad C", "Ruta 101", 333333333);
    private Editorial editorial5 = new Editorial("Libros Clásicos", "Ciudad D", "Avenida Central 567", 444444444);
    private Book libro1 = new Book("Título del Libro 1", autor1, "Sinopsis del Libro 1", 1234567890123L, "Género 1", 2022, editorial1, 300, 29.99, 100, true);
    private Book libro2 = new Book("Título del Libro 2", autor2, "Sinopsis del Libro 2", 2345678901234L, "Género 2", 2023, editorial2, 250, 19.99, 150, true);
    private Book libro3 = new Book("Título del Libro 3", autor3, "Sinopsis del Libro 3", 3456789012345L, "Género 3", 2021, editorial3, 400, 39.99, 120, true);
    private Book libro4 = new Book("Título del Libro 4", autor4, "Sinopsis del Libro 4", 4567890123456L, "Género 4", 2024, editorial4, 350, 24.99, 80, true);
    private Book libro5 = new Book("Título del Libro 5", autor5, "Sinopsis del Libro 5", 5678901234567L, "Género 5", 2020, editorial5, 320, 34.99, 90, true);

    private ArrayList<Book> listaLibros = new ArrayList<>();

    public Book getbook(){
        return book;
    }


    public void agregar(){
        String libro= JOptionPane.showInputDialog("Que libro vas a agregar a la Administrador de libros");

        switch (libro) {
            case "libro1":
                if (!listaLibros.contains(libro1)){
                    listaLibros.add(libro1);
                    System.out.println("Se ha agregado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("Ese libro ya esta en la lista de libros");
                    agregar();
                }


            case "libro2":
                if (!listaLibros.contains(libro2)){
                    listaLibros.add(libro2);
                    System.out.println("Se ha agregado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("Ese libro ya esta en la lista de libros");
                    agregar();
                }

            case "libro3":
                if (!listaLibros.contains(libro3)){
                    listaLibros.add(libro3);
                    System.out.println("Se ha agregado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("Ese libro ya esta en la lista de libros");
                    agregar();
                }

            case "libro4":
                if (!listaLibros.contains(libro4)){
                    listaLibros.add(libro4);
                    System.out.println("Se ha agregado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("Ese libro ya esta en la lista de libros");
                    agregar();
                }

            case "libro5":
                if (!listaLibros.contains(libro5)){
                    listaLibros.add(libro5);
                    System.out.println("Se ha agregado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("Ese libro ya esta en la lista de libros");
                    agregar();
                }
            default:
                System.out.println("Escribiste el nombre mal");
                execute();
                break;

        }


        execute();
    }
    public void quitar(){
        String libro= JOptionPane.showInputDialog("Que libro vas a quitar a la Administrador de libros");
        switch (libro) {
            case "libro1":
                if (listaLibros.contains(libro1)){
                    listaLibros.remove(libro1);
                    System.out.println("Se ha quitado un libro 1 exitosa mente");
                    break;
                }else{
                    System.out.println("El libro todavia no existe en la lista");
                    quitar();
                }


            case "libro2":
                if (listaLibros.contains(libro2)){
                    listaLibros.remove(libro2);
                    System.out.println("Se ha quitado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("El libro todavia no existe en la lista");
                    quitar();
                }

            case "libro3":
                if (listaLibros.contains(libro3)){
                    listaLibros.remove(libro3);
                    System.out.println("Se ha quitado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("El libro todavia no existe en la lista");
                    quitar();
                }

            case "libro4":
                if (listaLibros.contains(libro4)){
                    listaLibros.remove(libro4);
                    System.out.println("Se ha quitado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("El libro todavia no existe en la lista");
                    quitar();
                }

            case "libro5":
                if (listaLibros.contains(libro5)){
                    listaLibros.remove(libro5);
                    System.out.println("Se ha quitado un libro  exitosa mente");
                    break;
                }else{
                    System.out.println("El libro todavia no existe en la lista");
                    quitar();
                }
            default:
                System.out.println("No existe este libro");
                execute();
                break;

        }
        execute();
    }
    public void menuEditorial1(){
        String[] listaA = new String[4];
        listaA[0] = "Cambiar nombre";
        listaA[1] = "Cambiar ciudad";
        listaA[2] = "Cambair direccion";
        listaA[3] = " Cambiar telefono ";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Cual es el nuevo nombrea de la editorial");
                libro1.getEditorial().setName(nombre);
                break;

            case 2:
                String ciudad = JOptionPane.showInputDialog(" Cual es el nueva ciudad de la editorial ");
                libro1.getEditorial().setCity(ciudad);
                break;

            case 3:
                String direccion = JOptionPane.showInputDialog(" Cual es la nueva direccion de la editorial ");
                libro1.getEditorial().setAddress(direccion);
                break;
            case 4:
                while (true) {
                    try {
                        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo numero de la editorial"));
                        libro1.getEditorial().setPhone(telefono);
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                System.out.println("No existe esta opcion");
                execute();
                break;
        }


    }
    public void menuEditorial2(){
        String[] listaA = new String[4];
        listaA[0] = "Cambiar nombre";
        listaA[1] = "Cambiar ciudad";
        listaA[2] = "Cambair direccion";
        listaA[3] = " Cambiar telefono ";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Cual es la direccion nueva de la editorial");
                libro2.getEditorial().setName(nombre);
                break;

            case 2:
                String ciudad = JOptionPane.showInputDialog(" Cual es el nueva ciudad de la editorial ");
                libro2.getEditorial().setCity(ciudad);
                break;

            case 3:
                String direccion = JOptionPane.showInputDialog(" Cual es la nueca direccion de la editorial ");
                libro2.getEditorial().setAddress(direccion);
                break;
            case 4:
                while (true){
                    try {
                        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo numero de la editorial"));
                        libro2.getEditorial().setPhone(telefono);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No existe esta opcion");
                execute();
                break;
        }


    }
    public void menuEditorial3(){
        String[] listaA = new String[4];
        listaA[0] = "Cambiar nombre";
        listaA[1] = "Cambiar ciudad";
        listaA[2] = "Cambair direccion";
        listaA[3] = " Cambiar telefono ";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Cual es la direccion nueva de la editorial");
                libro3.getEditorial().setName(nombre);
                break;

            case 2:
                String ciudad = JOptionPane.showInputDialog(" Cual es el nueva ciudad de la editorial ");
                libro3.getEditorial().setCity(ciudad);
                break;

            case 3:
                String direccion = JOptionPane.showInputDialog(" Cual es la nueca direccion de la editorial ");
                libro3.getEditorial().setAddress(direccion);
                break;
            case 4:
                while (true) {
                    try {
                        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo numero de la editorial"));
                        libro3.getEditorial().setPhone(telefono);
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No existe esta opcion");
                execute();
                break;
        }



    }
    public void menuEditorial4(){
        String[] listaA = new String[4];
        listaA[0] = "Cambiar nombre";
        listaA[1] = "Cambiar ciudad";
        listaA[2] = "Cambair direccion";
        listaA[3] = " Cambiar telefono ";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Cual es la direccion nueva de la editorial");
                libro4.getEditorial().setName(nombre);
                break;

            case 2:
                String ciudad = JOptionPane.showInputDialog(" Cual es el nueva ciudad de la editorial ");
                libro4.getEditorial().setCity(ciudad);
                break;

            case 3:
                String direccion = JOptionPane.showInputDialog(" Cual es la nueca direccion de la editorial ");
                libro4.getEditorial().setAddress(direccion);
                break;
            case 4:
                while (true){
                    try {
                        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo numero de la editorial"));
                        libro4.getEditorial().setPhone(telefono);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No existe esta opción");
                execute();
                break;
        }


    }
    public void menuEditorial5(){
        String[] listaA = new String[4];
        listaA[0] = "Cambiar nombre";
        listaA[1] = "Cambiar ciudad";
        listaA[2] = "Cambair direccion";
        listaA[3] = " Cambiar telefono ";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Cual es la direccion nueva de la editorial");
                libro5.getEditorial().setName(nombre);
                break;

            case 2:
                String ciudad = JOptionPane.showInputDialog(" Cual es el nueva ciudad de la editorial ");
                libro5.getEditorial().setCity(ciudad);
                break;

            case 3:
                String direccion = JOptionPane.showInputDialog(" Cual es la nueca direccion de la editorial ");
                libro5.getEditorial().setAddress(direccion);
                break;
            case 4:
                while (true){
                    try {
                        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es el nuevo numero de la editorial"));
                        libro5.getEditorial().setPhone(telefono);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                break;
            default:
                System.out.println("No existe esta opción");
                execute();
                break;
        }


    }
    public void menuAutor1(){
        String[] listaA = new String[2];
        listaA[0] = "Cambiar bibliografia";
        listaA[1] = "Cambiar edad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String bibiografia = JOptionPane.showInputDialog("Cual es la bibliografia de este autor");
                libro1.getAuthor().setBiografia(bibiografia);
                break;

            case 2:
                while (true){
                    try {
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro1.getAuthor().setEdad(edad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No existe esta opción");
                execute();
                break;
        }


    }
    public void menuAutor2(){
        String[] listaA = new String[2];
        listaA[0] = "Cambiar bibliografia";
        listaA[1] = "Cambiar edad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String bibiografia = JOptionPane.showInputDialog("Cual es la bibliografia de este autor");
                libro2.getAuthor().setBiografia(bibiografia);
                break;

            case 2:
                while (true){
                    try {
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro2.getAuthor().setEdad(edad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No existe esta opción");
                execute();
                break;
        }


    }
    public void menuAutor3(){
        String[] listaA = new String[2];
        listaA[0] = "Cambiar bibliografia";
        listaA[1] = "Cambiar edad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String bibiografia = JOptionPane.showInputDialog("Cual es la bibliografia de este autor");
                libro3.getAuthor().setBiografia(bibiografia);
                break;

            case 2:
                while (true){
                    try {
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro3.getAuthor().setEdad(edad);
                        break;
                    }catch (NumberFormatException e ){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                break;
            default:
                System.out.println("Esta opcion no existe");
                execute();
                break;
        }


    }
    public void menuAutor4(){
        String[] listaA = new String[2];
        listaA[0] = "Cambiar bibliografia";
        listaA[1] = "Cambiar edad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String bibiografia = JOptionPane.showInputDialog("Cual es la bibliografia de este autor");
                libro4.getAuthor().setBiografia(bibiografia);
                break;

            case 2:
                while (true){
                    try {
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro4.getAuthor().setEdad(edad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            default:
                System.out.println("No esxiste esta opción");
                execute();
                break;
        }


    }
    public void menuAutor5(){
        String[] listaA = new String[2];
        listaA[0] = "Cambiar bibliografia";
        listaA[1] = "Cambiar edad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                String bibiografia = JOptionPane.showInputDialog("Cual es la bibliografia de este autor");
                libro5.getAuthor().setBiografia(bibiografia);
                break;

            case 2:
                while (true){
                    try{
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro5.getAuthor().setEdad(edad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }

                break;
            default:
                System.out.println("No existe esta opción");
                menuAutor5();
                break;
        }


    }
    public void menuLibro1(){
        String[] listaA = new String[3];
        listaA[0] = "Cambiar precio";
        listaA[1] = "Cambiar cantidad";
        listaA[2] = "Cambiar disponibilidad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                while (true){
                    try {
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Cúal es el nuevo precio del libro"));
                        libro1.setPrecio(precio);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 2:
                while (true){
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro1.setCantidad(cantidad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 3:
                while (true) {
                    String disponibilidad = JOptionPane.showInputDialog("Quedan libros");
                    if (disponibilidad.toLowerCase()=="si"|| disponibilidad.toLowerCase()=="no"){
                        if (disponibilidad.toLowerCase()=="si"){
                            libro1.setDisponble(true);
                            break;
                        }else {
                            libro1.setDisponble(false);
                            break;
                        }
                    }else {
                        System.out.println("Debes poner (si) o (no)");
                    }
                }
                break;
            default:
                System.out.println("Esta opción no existe");
                menuLibro1();
                break;
        }


    }
    public void menuLibro2(){
        String[] listaA = new String[3];
        listaA[0] = "Cambiar precio";
        listaA[1] = "Cambiar cantidad";
        listaA[2] = "Cambiar disponibilidad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                while (true){
                    try {
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Cúal es el nuevo precio del libro"));
                        libro2.setPrecio(precio);
                        break;
                    }catch (NumberFormatException e ){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 2:
                while (true){
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro2.setCantidad(cantidad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 3:
                while (true) {
                    String disponibilidad = JOptionPane.showInputDialog("Quedan libros");
                    if (disponibilidad.toLowerCase()=="si"|| disponibilidad.toLowerCase()=="no"){
                        if (disponibilidad.toLowerCase()=="si"){
                            libro2.setDisponble(true);
                            break;
                        }else {
                            libro2.setDisponble(false);
                            break;
                        }
                    }else {
                        System.out.println("Debes poner (si) o (no)");
                    }
                }
                break;
            default:
                System.out.println("Esta opción no existe");
                menuLibro2();
                break;
        }


    }
    public void menuLibro3(){
        String[] listaA = new String[3];
        listaA[0] = "Cambiar precio";
        listaA[1] = "Cambiar cantidad";
        listaA[2] = "Cambiar disponibilidad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                while (true){
                    try {
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Cúal es el nuevo precio del libro"));
                        libro3.setPrecio(precio);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 2:
                while (true){
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro3.setCantidad(cantidad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 3:
                while (true) {
                    String disponibilidad = JOptionPane.showInputDialog("Quedan libros");
                    if (disponibilidad.toLowerCase()=="si"|| disponibilidad.toLowerCase()=="no"){
                        if (disponibilidad.toLowerCase()=="si"){
                            libro3.setDisponble(true);
                            break;
                        }else {
                            libro3.setDisponble(false);
                            break;
                        }
                    }else {
                        System.out.println("Debes poner (si) o (no)");
                    }
                }
                break;
            default:
                System.out.println("Esta opción no existe");
                menuLibro3();
                break;
        }


    }
    public void menuLibro4(){
        String[] listaA = new String[3];
        listaA[0] = "Cambiar precio";
        listaA[1] = "Cambiar cantidad";
        listaA[2] = "Cambiar disponibilidad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                while (true){
                    try {
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Cúal es el nuevo precio del libro"));
                        libro4.setPrecio(precio);
                        break;
                    }catch (NumberFormatException e ){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 2:
                while (true){
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro4.setCantidad(cantidad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 3:
                while (true) {
                    String disponibilidad = JOptionPane.showInputDialog("Quedan libros");
                    if (disponibilidad.toLowerCase()=="si"|| disponibilidad.toLowerCase()=="no"){
                        if (disponibilidad.toLowerCase()=="si"){
                            libro4.setDisponble(true);
                            break;
                        }else {
                            libro4.setDisponble(false);
                            break;
                        }
                    }else {
                        System.out.println("Debes poner (si) o (no)");
                    }
                }
                break;
            default:
                System.out.println("Esta opción no existe");
                menuLibro4();
                break;

        }


    }
    public void menuLibro5(){
        String[] listaA = new String[3];
        listaA[0] = "Cambiar precio";
        listaA[1] = "Cambiar cantidad";
        listaA[2] = "Cambiar disponibilidad";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        switch (option1) {
            case 1:
                while (true){
                    try {
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Cúal es el nuevo precio del libro"));
                        libro5.setPrecio(precio);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 2:
                while (true){
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cúal es la edad de este autor"));
                        libro5.setCantidad(cantidad);
                        break;
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;

            case 3:
                while (true) {
                    String disponibilidad = JOptionPane.showInputDialog("Quedan libros");
                    if (disponibilidad.toLowerCase()=="si"|| disponibilidad.toLowerCase()=="no"){
                        if (disponibilidad.toLowerCase()=="si"){
                            libro5.setDisponble(true);
                            break;
                        }else {
                            libro5.setDisponble(false);
                            break;
                        }
                    }else {
                        System.out.println("Debes poner (si) o (no)");
                    }
                }
                break;
            default:
                System.out.println("Esta opción no existe");
                menuLibro5();
                break;

        }


    }


    public void menuActualizar(){
        String[] listaA = new String[3];
        listaA[0] = "Actualizar Editorial";
        listaA[1] = "Actualizar Autor";
        listaA[2] = "Actualizar Libro";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        String libro = JOptionPane.showInputDialog("Que libro deseas actualizar");
        switch (option1) {
            case 1:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        menuEditorial1();
                        System.out.println("Se ha actualizado el libro");
                    }else{
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        menuEditorial2();
                        System.out.println("Se ha actualizado el libro");
                    }else{
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        menuEditorial3();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();

                    }
                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        menuEditorial4();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro5".equals(libro)) {
                    if (listaLibros.contains(libro5)) {
                        menuEditorial5();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                }
                break;

            case 2:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        menuAutor1();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        menuAutor2();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        menuAutor3();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        menuAutor4();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro5".equals(libro)) {
                    if (listaLibros.contains(libro5)) {
                        menuAutor5();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                }
                break;

            case 3:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        menuLibro1();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        menuLibro2();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        menuLibro3();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        menuLibro4();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }
                } else if ("libro5".equals(libro)) {
                    if (listaLibros.contains(libro5)){
                        menuLibro5();
                        System.out.println("Se ha actualizado el libro");
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuActualizar();
                    }

                }
                break;
            default:
                System.out.println("Esribiste mal el nombre del libro");
                menuActualizar();
                break;
        }
        execute();
    }
    public void menuLista(){
        String[] listaA = new String[4];
        listaA[0] = "Listar Editorial";
        listaA[1] = "Listar Autor";
        listaA[2] = "Listar Libro";
        listaA[3] = "Listar todos los libros";
        for (int i = 0; i < listaA.length; i++) {
            System.out.println((i + 1) + " " + listaA[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner1 =  new Scanner(System.in);
        int option1 = scanner1.nextInt();
        scanner1.nextLine();
        String libro = JOptionPane.showInputDialog("Que libro quieres ( si pusiste la opcion 4 dejalo vacio)");
        switch (option1) {
            case 1:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        System.out.println("El nombre de la editorial es " + libro1.getEditorial().getName());
                        System.out.println("La ciudad de la editorial es " + libro1.getEditorial().getCity());
                        System.out.println("La dirección de la editorial es " + libro1.getEditorial().getAddress());
                        System.out.println(" El telefono de la editorial es " + libro1.getEditorial().getPhone());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        System.out.println("El nombre de la editorial es " + libro2.getEditorial().getName());
                        System.out.println("La ciudad de la editorial es " + libro2.getEditorial().getCity());
                        System.out.println("La dirección de la editorial es " + libro2.getEditorial().getAddress());
                        System.out.println(" El telefono de la editorial es " + libro2.getEditorial().getPhone());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        System.out.println("El nombre de la editorial es " + libro3.getEditorial().getName());
                        System.out.println("La ciudad de la editorial es " + libro3.getEditorial().getCity());
                        System.out.println("La dirección de la editorial es " + libro3.getEditorial().getAddress());
                        System.out.println(" El telefono de la editorial es " + libro3.getEditorial().getPhone());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }

                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        System.out.println("El nombre de la editorial es " + libro4.getEditorial().getName());
                        System.out.println("La ciudad de la editorial es " + libro4.getEditorial().getCity());
                        System.out.println("La dirección de la editorial es " + libro4.getEditorial().getAddress());
                        System.out.println(" El telefono de la editorial es " + libro4.getEditorial().getPhone());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                    if (listaLibros.contains(libro5)) {
                        System.out.println("El nombre de la editorial es " + libro5.getEditorial().getName());
                        System.out.println("La ciudad de la editorial es " + libro5.getEditorial().getCity());
                        System.out.println("La dirección de la editorial es " + libro5.getEditorial().getAddress());
                        System.out.println(" El telefono de la editorial es " + libro5.getEditorial().getPhone());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                }
                break;

            case 2:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        System.out.println("Nombre del Autor: " + libro1.getAuthor().getNombre());
                        System.out.println("Apellido del Autor: " + libro1.getAuthor().getApellido());
                        System.out.println("Nacionalidad del Autor: " + libro1.getAuthor().getNacionalidad());
                        System.out.println("Bibiografia del Autor: " + libro1.getAuthor().getBiografia());
                        System.out.println("edad del Autor: " + libro1.getAuthor().getEdad());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        System.out.println("Nombre del Autor: " + libro2.getAuthor().getNombre());
                        System.out.println("Apellido del Autor: " + libro2.getAuthor().getApellido());
                        System.out.println("Nacionalidad del Autor: " + libro2.getAuthor().getNacionalidad());
                        System.out.println("Bibiografia del Autor: " + libro2.getAuthor().getBiografia());
                        System.out.println("edad del Autor: " + libro2.getAuthor().getEdad());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        System.out.println("Nombre del Autor: " + libro3.getAuthor().getNombre());
                        System.out.println("Apellido del Autor: " + libro3.getAuthor().getApellido());
                        System.out.println("Nacionalidad del Autor: " + libro3.getAuthor().getNacionalidad());
                        System.out.println("Bibiografia del Autor: " + libro3.getAuthor().getBiografia());
                        System.out.println("edad del Autor: " + libro3.getAuthor().getEdad());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }


                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        System.out.println("Nombre del Autor: " + libro4.getAuthor().getNombre());
                        System.out.println("Apellido del Autor: " + libro4.getAuthor().getApellido());
                        System.out.println("Nacionalidad del Autor: " + libro4.getAuthor().getNacionalidad());
                        System.out.println("Bibiografia del Autor: " + libro4.getAuthor().getBiografia());
                        System.out.println("edad del Autor: " + libro4.getAuthor().getEdad());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                } else if ("libro5".equals(libro)) {
                    if (listaLibros.contains(libro5)) {
                        System.out.println("Nombre del Autor: " + libro5.getAuthor().getNombre());
                        System.out.println("Apellido del Autor: " + libro5.getAuthor().getApellido());
                        System.out.println("Nacionalidad del Autor: " + libro5.getAuthor().getNacionalidad());
                        System.out.println("Bibiografia del Autor: " + libro5.getAuthor().getBiografia());
                        System.out.println("edad del Autor: " + libro5.getAuthor().getEdad());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                }
                break;

            case 3:
                if("libro1".equals(libro)) {
                    if (listaLibros.contains(libro1)) {
                        System.out.println("Titulo del libro " + libro1.getTitile());
                        System.out.println("Autor del libro " + libro1.getAuthor().getNombre());
                        System.out.println("sipnosis del libro " + libro1.getSypnosis());
                        System.out.println("ISBN del libro " + libro1.getISBN());
                        System.out.println("Genero del libro " + libro1.getGenero());
                        System.out.println("Año de plublicación del libro " + libro1.getAño());
                        System.out.println("Editorial del libro " + libro1.getNombreEditorial());
                        System.out.println("Numero de paginas del libro " + libro1.getN_paginas());
                        System.out.println("Precio  del libro " + libro1.getPrecio());
                        System.out.println("cantidad del libro " + libro1.getCantidad());
                        System.out.println("Disponibilidad del libro " + libro1.isDisponble());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                } else if ("libro2".equals(libro)) {
                    if (listaLibros.contains(libro2)) {
                        System.out.println("Titulo del libro " + libro2.getTitile());
                        System.out.println("Autor del libro " + libro2.getAuthor().getNombre());
                        System.out.println("sipnosis del libro " + libro2.getSypnosis());
                        System.out.println("ISBN del libro " + libro2.getISBN());
                        System.out.println("Genero del libro " + libro2.getGenero());
                        System.out.println("Año de plublicación del libro " + libro2.getAño());
                        System.out.println("Editorial del libro " + libro2.getNombreEditorial());
                        System.out.println("Numero de paginas del libro " + libro2.getN_paginas());
                        System.out.println("Precio  del libro " + libro2.getPrecio());
                        System.out.println("cantidad del libro " + libro2.getCantidad());
                        System.out.println("Disponibilidad del libro " + libro2.isDisponble());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }

                } else if ("libro3".equals(libro)) {
                    if (listaLibros.contains(libro3)) {
                        System.out.println("Titulo del libro " + libro3.getTitile());
                        System.out.println("Autor del libro " + libro3.getAuthor().getNombre());
                        System.out.println("sipnosis del libro " + libro3.getSypnosis());
                        System.out.println("ISBN del libro " + libro3.getISBN());
                        System.out.println("Genero del libro " + libro3.getGenero());
                        System.out.println("Año de plublicación del libro " + libro3.getAño());
                        System.out.println("Editorial del libro " + libro3.getNombreEditorial());
                        System.out.println("Numero de paginas del libro " + libro3.getN_paginas());
                        System.out.println("Precio  del libro " + libro3.getPrecio());
                        System.out.println("cantidad del libro " + libro3.getCantidad());
                        System.out.println("Disponibilidad del libro " + libro3.isDisponble());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                } else if ("libro4".equals(libro)) {
                    if (listaLibros.contains(libro4)) {
                        System.out.println("Titulo del libro " + libro4.getTitile());
                        System.out.println("Autor del libro " + libro4.getAuthor().getNombre());
                        System.out.println("sipnosis del libro " + libro4.getSypnosis());
                        System.out.println("ISBN del libro " + libro4.getISBN());
                        System.out.println("Genero del libro " + libro4.getGenero());
                        System.out.println("Año de plublicación del libro " + libro4.getAño());
                        System.out.println("Editorial del libro " + libro4.getNombreEditorial());
                        System.out.println("Numero de paginas del libro " + libro4.getN_paginas());
                        System.out.println("Precio  del libro " + libro4.getPrecio());
                        System.out.println("cantidad del libro " + libro4.getCantidad());
                        System.out.println("Disponibilidad del libro " + libro4.isDisponble());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }

                    if (listaLibros.contains(libro5)) {
                        System.out.println("Titulo del libro " + libro5.getTitile());
                        System.out.println("Autor del libro " + libro5.getAuthor().getNombre());
                        System.out.println("sipnosis del libro " + libro5.getSypnosis());
                        System.out.println("ISBN del libro " + libro5.getISBN());
                        System.out.println("Genero del libro " + libro5.getGenero());
                        System.out.println("Año de plublicación del libro " + libro5.getAño());
                        System.out.println("Editorial del libro " + libro5.getNombreEditorial());
                        System.out.println("Numero de paginas del libro " + libro5.getN_paginas());
                        System.out.println("Precio  del libro " + libro5.getPrecio());
                        System.out.println("cantidad del libro " + libro5.getCantidad());
                        System.out.println("Disponibilidad del libro " + libro5.isDisponble());
                    }else {
                        System.out.println("El libro todavia no esta en la lista de libros ");
                        menuLista();
                    }
                }
                break;
            case 4:

                System.out.println("Listado de Libros");
                for (int i = 0; i < listaLibros.size(); i++) {
                    Book book = listaLibros.get(i);
                    System.out.println("Titulo del libro " + book.getTitile() );
                    System.out.println("Autor del libro " + book.getAuthor().getNombre() );
                    System.out.println("sipnosis del libro " + book.getSypnosis() );
                    System.out.println("ISBN del libro " + book.getISBN() );
                    System.out.println("Genero del libro " + book.getGenero() );
                    System.out.println("Año de plublicación del libro " + book.getAño() );
                    System.out.println("Editorial del libro " + book.getNombreEditorial() );
                    System.out.println("Numero de paginas del libro " + book.getN_paginas() );
                    System.out.println("Precio  del libro " + book.getPrecio() );
                    System.out.println("cantidad del libro " + book.getCantidad() );
                    System.out.println("Disponibilidad del libro " + book.isDisponble() );
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            default:
                System.out.println("La opción no es validad");
                execute();
                break;

        }
        execute();
    }
    public void execute() {
        String[] lista = new String[5];
        lista[0] = "Agregar";
        lista[1] = "Quitar";
        lista[2] = "Actualizar";
        lista[3] = "Listar";
        lista[4] = "Salir";
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + " " + lista[i]);
        }
        System.out.println("Por favor ingrese la opción: ");
        Scanner scanner =  new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                agregar();
                break;

            case 2:
                quitar();
                break;

            case 3:
                menuActualizar();

                break;
            case 4:
                menuLista();
                break;

            case 5:
                System.out.println("gracias , vuelva pronto");
                break;

        }
        if (0>= option || option>5){
            System.out.println("Vuelva a introducir el numero no es valido debe ser de 1 a 5");
            execute();
        }
    }

}

