package run;

import models.Book;
import models.BookManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        String option = "";

        while (!"6".equals(option)) {
            System.out.println("\n*** SISTEMA DE GESTION DE LIBROS ***");
            System.out.print("""
                    1. Agregar un Libro
                    2. Buscar por autor
                    3. Buscar por palabra clave en titulo
                    4. Libros Actuales (+2010)
                    5. Mostrar todos los libros
                    6. Salir
                    -----------------------
                    Ingrese una opción:\s""");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Introduce el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Introduce el autor del libro: ");
                    String author = scanner.nextLine();
                    System.out.print("Introduce el año de publicación: ");

                    try {
                        int year = Integer.parseInt(scanner.nextLine());
                        bookManager.addBook(new Book(title, author, year));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El año debe ser un número. El libro no fue agregado.");
                    }
                    break;

                case "2":
                    System.out.print("Introduce el nombre del autor a buscar: ");
                    String searchAuthor = scanner.nextLine();
                    bookManager.searchByAutor(searchAuthor);
                    break;

                case "3":
                    System.out.print("Introduce la palabra clave a buscar en el título: ");
                    String keyword = scanner.nextLine();
                    bookManager.searchByKeyInTitle(keyword);
                    break;

                case "4":
                    bookManager.showBooksAfter2010();
                    break;

                case "5":
                    bookManager.showAll();
                    break;

                case "6":
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
