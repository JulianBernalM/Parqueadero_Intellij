package org.example.entity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//Importo LocalDateTime
import java.time.LocalDateTime;

public class Vehiculo {

    private String placa = "";
    private String tipo = "";
    private String color = "";

    //Crear atributo de tipo date que guarda la hora de entrada
    private LocalDateTime horaEntrada;

    //Lista de clientes
    private List<Usuario> listaUsuarios = new ArrayList<>();

    //Metodo constructor de vehiculos
    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
        //Se guarda la hora exacta de ingreso del vehiculo
        this.horaEntrada = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa=' " + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", horaEntrada= " + horaEntrada +
                '}';
    }

    //Metodo para agregar usuarios al vehiculo
    public void agregaUsuario(Usuario usuario) {listaUsuarios.add(usuario);}

    //Metodo para mostrar el usuario del vehiculo
    public void mostrarUsuarios(){
        System.out.println("=== USUARIO DE VEHICULO " + placa + "===");

        for (Usuario objetoUsuario:listaUsuarios){
            System.out.println(objetoUsuario.toString());
        }
    }

    //Metodo del vehiculo que calcula cuanto tiempo lleva parqueado
    public long calcularMinutosParqueado(){
        return Duration.between(
                horaEntrada,
                LocalDateTime.now()
        ).toMinutes();
    }


    public LocalDateTime getHoraEntrada() { return horaEntrada;}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
