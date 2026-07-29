package org.example;

//Comentario de prueba para el sistema de control de versiones
import org.example.entity.Parqueadero;
import org.example.entity.Usuario;
import org.example.entity.Vehiculo;
import java.util.Scanner;
//Importo exception
import java.util.InputMismatchException;

public class Main {

    static Parqueadero parqueaderoUno = new Parqueadero("Parqueadero del centro", 100001L, 3146545588L);

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        boolean estadoApp = true;

        //Inicio de la aplicacion
        while (estadoApp) {

            System.out.println("\n\n");
            System.out.println("------------ Aplicacion parqueadero iniciada ------------------");
            System.out.println("------------ Bienvenido al parqueadero " + parqueaderoUno.getNombre() + "---------");

            System.out.println("""
                    1. Registrar vehiculo
                    2. Mostrar vehiculos
                    3. Buscar vehiculo (Placa) (Muestre la cantidad de minutos desde la hora de entrada y salida)
                    4. Retirada de vehiculo (Ya sale del parqueadero --Sacar el carro del parqueadero, que muestre el valor a cancelar dependiendo de la hora de salida) El parqueadero cobra 500 pesos el minuto
                    5. Salir de la app                                        
                    """);



            //System.out.println("Seleccione una opcion: ");
            int opcion = leerOpcion(sc);


            switch (opcion){

                case 1:
                    System.out.println("Registro de nuevo vehiculo. ");
                    System.out.println("Ingrese placa");
                    String placa = sc.next();
                    String tipo = leerTipoVehiculo(sc);
                    crearVehiculo(placa, tipo);
                    break;

                case 2:
                    System.out.println("Vehiculos ingresados: ");
                    parqueaderoUno.mostrarVehiculos();
                    Thread.sleep(5000);
                    break;

                case 3:
                    System.out.println("Ingrese la placa. ");
                    String placaABuscar = sc.next();
                    parqueaderoUno.buscarVehiculo(placaABuscar);
                    Thread.sleep(5000);
                    break;
                case 4:
                    System.out.println("Ingrese la placa del vehiculo a eliminar. ");
                    String placaAEliminar = sc.next();
                    parqueaderoUno.quitarVehiculo(placaAEliminar);
                    Thread.sleep(5000);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    Thread.sleep(1000);
                    estadoApp = false;
                    break;

                default:
                    System.out.println("La opcion ingresada no es valida");
                    Thread.sleep(1000);
            }
        }

        sc.close();


        /*
        //Construyo el segundo parqueadero
        Parqueadero parqueaderoDos = new Parqueadero("Parqueadero Mercaldas", 1455596L, 3116559988L);

        //Creo los usuarios
        Usuario usuarioUno = new Usuario("Julian Bernal Marin", 1053786048L);

        Usuario usuarioDos = new Usuario("Evelin Daniela Cardona", 1053828260L);

        //Creo los vehiculos
        Vehiculo vehiculoUno = new Vehiculo("HHT497", "Automovil");

        Vehiculo vehiculoDos = new Vehiculo("WRE39E", "Motocicleta");

        //Agrego los usuarios a los vehiculos
        vehiculoUno.agregaUsuario(usuarioUno);
        vehiculoDos.agregaUsuario(usuarioDos);

        //Agrego los vehiculos al parqueadero y los muestro
        parqueaderoUno.agregaVehiculo(vehiculoUno);
        parqueaderoUno.mostrarVehiculos();

        parqueaderoDos.agregaVehiculo(vehiculoDos);
        parqueaderoDos.mostrarVehiculos();*/
    }

    //Metodo que controla el tipo de dato de ingreso en el menu (solo numeros)
    public static int leerOpcion(Scanner sc){
        while (true){
            try{
                System.out.println("Seleccione una opcion: ");
                return sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero.");
                sc.nextLine();
            }
        }

    }

    //Metodo que controla el ingreso del tipo de vehiculo, solo Carro o Moto
    public static String leerTipoVehiculo(Scanner sc){
        while (true){
            System.out.println("Ingrese tipo de vehiculo (Carro o moto): ");
            String tipo = sc.next();

            if (tipo.equalsIgnoreCase("Carro") || tipo.equalsIgnoreCase("Moto")){
                return tipo;
            }

            System.out.println("Tipo de vehículo no válido. Solo se permite 'Carro' o 'Moto'.");

        }
    }

    //Metodo que controla la placa que ingresa el usuario
    public static String leerPlaca(Scanner sc){
        while (true){
            System.out.println("Ingrese la placa. ");
            String placa = sc.next().trim(); //Elimina espacios al inicio y al final.

            if (!placa.isEmpty()){ //Verifica que la cadena no esté vacía.
                return placa.toUpperCase(); //Guarda todas las placas en mayusculas
            }

            System.out.println("La placa no puede estar vacia. ");
        }
    }


    //Metodo para crear vehiculos
    public static void crearVehiculo(String placa, String tipo){

        if (parqueaderoUno.existeVehiculo(placa)){
            System.out.println("Ya existe un vehiculo con esta placa: " + placa);
            return;
        }
        Vehiculo vehiculo = new Vehiculo(placa, tipo);
        parqueaderoUno.agregaVehiculo(vehiculo);

        System.out.println("Vehiculo ingresado correctamente. ");
    }
}