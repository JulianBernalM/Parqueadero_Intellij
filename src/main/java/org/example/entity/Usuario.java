package org.example.entity;

public class Usuario {

    private String nombre = "";
    private Long Cedula = 0L;

    //Metodo constructor de usuarios


    public Usuario(String nombre, Long cedula) {
        this.nombre = nombre;
        Cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", Cedula=" + Cedula +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCedula() {
        return Cedula;
    }

    public void setCedula(Long cedula) {
        Cedula = cedula;
    }
}
