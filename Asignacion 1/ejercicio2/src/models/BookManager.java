package models;

public class BookManager {
    private Book[] books;
    private int currentBooks;
    private static final int MAX_BOOKS = 100;

    public BookManager() {
        this.books = new Book[MAX_BOOKS];
        this.currentBooks = 0;
    }

    public void addBook(Book book) {
        if (book == null) {
            System.out.println("⚠ Libro nulo. No se agregó.");
            return;
        }
        if (currentBooks >= MAX_BOOKS) {
            System.out.println("⚠ BookManager está lleno.");
            return;
        }
        books[currentBooks] = book;
        currentBooks++;
        String title = book.getTitle() == null ? "(sin título)" : book.getTitle();
        System.out.printf("✔ Libro: '%s' añadido correctamente%n", title);
    }

    public void searchByAutor(String autor) {
        if (isEmpty()) return;
        System.out.printf("--- Libros del autor: %s ---%n", autor);
        if (autor == null || autor.trim().isEmpty()) {
            System.out.println("⚠ Nombre de autor no válido.");
            return;
        }
        boolean isFound = false;
        String search = autor.toLowerCase().trim();
        for (int i = 0; i < currentBooks; i++) {
            Book b = books[i];
            if (b == null) continue;
            String a = b.getAutor();
            if (a != null && a.toLowerCase().contains(search)) {
                System.out.println(b.toString());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.printf("⚠ '%s' no fue encontrado en el BookManager.%n", autor);
        }
    }

    public void searchByKeyInTitle(String keywordInTitle) {
        if (isEmpty()) return;
        System.out.printf("%n--- Buscando '%s' en los títulos ---%n", keywordInTitle);
        if (keywordInTitle == null || keywordInTitle.trim().isEmpty()) {
            System.out.println("Palabra clave no válida.");
            return;
        }
        boolean isFound = false;
        String key = keywordInTitle.toLowerCase().trim();
        for (int i = 0; i < currentBooks; i++) {
            Book b = books[i];
            if (b == null) continue;
            String t = b.getTitle();
            if (t != null && t.toLowerCase().contains(key)) {
                System.out.println(b.toString());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.printf("La palabra clave '%s' no fue encontrada en ningún título.%n", keywordInTitle);
        }
    }

    public void showBooksAfter2010() {
        if (isEmpty()) return;
        System.out.printf("%n--- Libros publicados desde 2010 en adelante ---%n");
        boolean isFound = false;
        for (int i = 0; i < currentBooks; i++) {
            Book b = books[i];
            if (b == null) continue;
            if (b.getYear() >= 2010) {
                System.out.println(b.toString());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No se encontraron libros publicados desde el año 2010 en adelante.");
        }
    }

    public void showAll() {
        if (isEmpty()) return;
        System.out.printf("%n--- Todos los libros ---%n");
        for (int i = 0; i < currentBooks; i++) {
            Book b = books[i];
            if (b != null) {
                System.out.println(b.toString());
            }
        }
    }

    private boolean isEmpty() {
        if (currentBooks == 0) {
            System.out.println("BookManager está vacío.");
            return true;
        }
        return false;
    }
}
