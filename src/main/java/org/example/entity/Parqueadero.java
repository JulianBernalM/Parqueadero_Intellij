package org.example.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Importo estas clases para calcular los minutos
import java.time.Duration;
import java.time.LocalDateTime;

public class Parqueadero {

    private String nombre = "";
    private Long nit = 0L;
    private Long telefono = 0L;
    private String direccion = "";
    private int capacidadTotal = 0;

    //Lista de vehiculos
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    //Metodo constructor de parqueaderos
    public Parqueadero(String nombre, Long nit, Long telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", telefono=" + telefono +
                '}';
    }

    //Metodo para agregar vehiculos
    public void agregaVehiculo(Vehiculo vehiculo){ listaVehiculos.add(vehiculo);}


    //Metodo para mostrar los vehiculos
    public void mostrarVehiculos(){
        if (listaVehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados en el parqueadero.");
            return;
        }
        for (Vehiculo objetoVehiculo:listaVehiculos){
            System.out.println(objetoVehiculo.toString());

            long valor = calcularValorAPagar(objetoVehiculo);
            System.out.println("El valor a pagar actual es: " + valor);
        }

    }


    //Metodo que se encarga de buscar un solo vehiculo
    public String buscarVehiculo(String placa){
        for (Vehiculo objetoVehiculo:listaVehiculos) {
            if (objetoVehiculo.getPlaca().equalsIgnoreCase(placa)){
                System.out.println(objetoVehiculo.toString());

                //Calculo el tiempo
                long minutos = Duration.between(
                        objetoVehiculo.getHoraEntrada(),
                        LocalDateTime.now()
                ).toMinutes();
                System.out.println("Minutos en parqueado: " + minutos);
                long valor = calcularValorAPagar(objetoVehiculo);
                System.out.println("El valor a pagar actual es: " + valor);

                return placa;
            }
        }

        System.out.println("No se encontro ningun vehiculo con esa placa");
        return placa;
    }

    //Metodo para quitar vehiculo del parqueadero
    public void quitarVehiculo(String placa){
        Iterator<Vehiculo> iterator = listaVehiculos.iterator();

        while (iterator.hasNext()){
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)){
                long valor = calcularValorAPagar(vehiculo);
                System.out.println("El valor a pagar es " + valor);
                iterator.remove();
                System.out.println("Vehiculo retirado correctamente gracias por su visita.");

                return;
            }
        }
        System.out.println("Vehiculo no encontrado.");
    }

    //Metodo para calcular el valor a pagar
    public long calcularValorAPagar(Vehiculo vehiculo){

        long minutos = vehiculo.calcularMinutosParqueado();

        long horas = (long) Math.ceil(minutos / 60.0);

        return horas * 1000;

    }

    //Metodo que comprueba si la placa ingresada ya existe
    public boolean existeVehiculo(String placa){
        for (Vehiculo objetoVehiculo:listaVehiculos){
            if (objetoVehiculo.getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        return false;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
}
