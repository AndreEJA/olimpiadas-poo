package models;

public class Contacto {
    //Atributos de nuestra clase contacto

    private String nombre;
    private String telefono;
    private String email;

    //Constructor vacio para inicializar el objeto
    public Contacto() {

    }

    //Getter y setter para acceder y modificar los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //override para normalizar la impresion \
    public String toString() {
        return nombre + " - " + telefono + " - " + email;
    }

}
