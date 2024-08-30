package co.edu.uniquindio;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainTransporte {

    public static void main(String[] args) {
        LinkedList<VehiculoTransporte> vehiculoTransportes = new LinkedList<>();
        LinkedList<VehiculoCarga> vehiculoCargas = new LinkedList<>();
        LinkedList<Propietario> propietarios = new LinkedList<>();
        LinkedList<Usuario> usuarios = new LinkedList<>();
        crearDatosDePrueba(vehiculoTransportes,vehiculoCargas,propietarios,usuarios);
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            mostrarMenu();

            try {
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarDatosDePrueba(vehiculoTransportes,vehiculoCargas,propietarios,usuarios);
                        break;
                    case 2:
                        crearVehiculosTransporte(vehiculoTransportes);
                        break;
                    case 3:
                        calcularPasajerosTransportados(vehiculoTransportes,usuarios);
                        break;
                    case 4:
                        crearPropietarioYVehiculoCarga(propietarios);
                        break;
                    case 5:
                        usuariosConSobrepeso(vehiculoTransportes);
                        break;
                    case 6:
                        contarPropietariosMayoresDe40(propietarios);
                        break;
                    case 7:
                        contarUsuariosEnRangoDeEdad(vehiculoTransportes);
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Mostrar datos de prueba para la clase Empresa de Transporte");
        System.out.println("2. Crear vehiculos de transporte");
        System.out.println("3. Calcular el total de pasajeros transportados en un dia");
        System.out.println("4. Crear un propietario y su vehiculo de carga");
        System.out.println("5. Buscar usuarios con sobrepeso");
        System.out.println("6. Contar propietarios mayores a 40 años");
        System.out.println("7. Contar usuarios en rango de edad");
        System.out.println("8. Salir");
        System.out.println("Escribe una de las opciones: ");
    }

    private static void crearPropietarioYVehiculoCarga(LinkedList<Propietario> propietarios) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opción 4 (Crear un propietario y su vehículo de carga)");
        VehiculoCarga vehiculoCarga = new VehiculoCarga(
                obtenerDato(scanner, "Ingrese la placa del vehículo: "),
                obtenerDato(scanner, "Ingrese el modelo del vehículo: "),
                obtenerDato(scanner, "Ingrese la marca del vehículo: "),
                obtenerDato(scanner, "Ingrese el color del vehículo: "),
                Double.parseDouble(obtenerDato(scanner, "Ingrese la capacidad máxima del vehículo de carga: ")),
                Integer.parseInt(obtenerDato(scanner, "Ingrese el número de ejes del vehículo de carga: "))
        );

        Propietario propietario = Propietario.Builder()
                .nombre(obtenerDato(scanner, "Ingrese el nombre del propietario: "))
                .edad(Integer.parseInt(obtenerDato(scanner, "Ingrese la edad del propietario: ")))
                .cedula(obtenerDato(scanner, "Ingrese la cédula del propietario: "))
                .email(obtenerDato(scanner, "Ingrese el email del propietario: "))
                .celular(obtenerDato(scanner, "Ingrese el celular del propietario: "))
                .vehiculo(vehiculoCarga)  // Suponiendo que `vehiculoCarga` es un objeto Vehiculo
                .build();

        propietarios.add(propietario);

        System.out.println("Se creó con éxito el propietario con los datos: " + propietario);
        System.out.println("Y se creó con éxito el vehículo de carga con los datos: " + vehiculoCarga + vehiculoCarga.toString1());
    }

    private static void crearVehiculosTransporte(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has seleccionado la opción 2 (Crear vehículos de transporte)");
        int numeroVehiculosTransportes = Integer.parseInt(obtenerDato(scanner,"Ingrese el numero de vehículos de transporte que desea crear: "));

        for (int i = 0; i < numeroVehiculosTransportes; i++) {
            VehiculoTransporte vehiculoTransporte = new VehiculoTransporte(
                    obtenerDato(scanner, "Ingrese la placa del vehículo: "),
                    obtenerDato(scanner, "Ingrese el modelo del vehículo: "),
                    obtenerDato(scanner, "Ingrese la marca del vehículo: "),
                    obtenerDato(scanner, "Ingrese el color del vehículo: "),
                    Integer.parseInt(obtenerDato(scanner, "Ingrese el máximo de usuarios del vehículo: "))
            );
            vehiculoTransportes.add(vehiculoTransporte);
        }
    }

    private static void saturar(LinkedList<VehiculoTransporte> vehiculoTransportes, LinkedList<Usuario> usuarios) {
        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            int maxPasajeros = vehiculoTransporte.getMaxPasajeros();
            Usuario[] usuariosVehiculo = vehiculoTransporte.getUsuarios();

            if (usuariosVehiculo != null) {
                for (int j = 0; j < usuarios.size() && j < maxPasajeros; j++) {
                    usuariosVehiculo[j] = usuarios.get(j);
                }
            }
        }
    }

    private static void calcularPasajerosTransportados(LinkedList<VehiculoTransporte> vehiculoTransportes,LinkedList<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opción 3 (Calcular el total de pasajeros transportados en un día)");
        String placa = obtenerDato(scanner, "Ingrese la placa del vehículo a consultar: ");
        saturar(vehiculoTransportes,usuarios);


        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            if (vehiculoTransporte.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("El número de pasajeros del vehículo con la placa " + placa + " es: " + vehiculoTransporte.getUsuarios().length);
                System.out.println("Y los datos de cada pasajero son: " + vehiculoTransporte.datosUsuarios());
            }
        }
    }
    private static void usuariosConSobrepeso(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opcion 5 (Buscar usuarios con sobrepeso)");
        double peso = Double.parseDouble(obtenerDato(scanner, "Ingrese el peso maximo: "));
        LinkedList<Usuario> usuariosConSobrepeso = new LinkedList<>();

        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                if (usuario.getPeso() > peso) {
                    usuariosConSobrepeso.add(usuario);
                }
            }
        }
        if (usuariosConSobrepeso.isEmpty()) {
            System.out.println("No se encontraron usuarios con sobrepeso.");
        } else {
            System.out.println("Los usuarios con sobrepeso son: " + usuariosConSobrepeso);
        }

    }
    private static void contarPropietariosMayoresDe40(LinkedList<Propietario> propietarios) {
        System.out.println("Has seleccionado la opción 6 (Contar propietarios mayores a 40 años)");
        int contador = 0;

        for (Propietario propietario : propietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }

        System.out.println("El número de propietarios mayores de 40 años es: " + contador);
    }
    private static void contarUsuariosEnRangoDeEdad(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        System.out.println("Has seleccionado la opción 7 (Contar usuarios en rango de edad)");
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        int edadMinima = Integer.parseInt(obtenerDato(scanner,"Ingrese la edad minima: "));
        int edadMaxima = Integer.parseInt(obtenerDato(scanner,"Ingrese la edad maxima: "));

        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes){
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                int edad = Integer.parseInt(usuario.getEdad());
                if (edad >= edadMinima && edad <= edadMaxima) {
                    contador++;
                }
            }
        }

        System.out.println("El número de usuarios en el rango de edad [" + edadMinima + ", " + edadMaxima + "] es: " + contador);
    }

    private static String obtenerDato(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }
    //Datos de prueba
    public static void crearDatosDePrueba(LinkedList<VehiculoTransporte> vehiculoTransportes,LinkedList<VehiculoCarga> vehiculoCargas,LinkedList<Propietario> propietarios,LinkedList<Usuario> usuarios) {
        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga("ABC123", "F-150", "Ford", "Rojo", 1500.5, 2);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga("DEF456", "Ram 2500", "Dodge", "Negro", 2000.0, 4);
        VehiculoCarga vehiculoCarga3 = new VehiculoCarga("GHI789", "Tundra", "Toyota", "Blanco", 1800.7, 3);
        VehiculoCarga vehiculoCarga4 = new VehiculoCarga("JKL012", "Silverado", "Chevrolet", "Azul", 2200.2, 4);

        vehiculoCargas.add(vehiculoCarga1);
        vehiculoCargas.add(vehiculoCarga2);
        vehiculoCargas.add(vehiculoCarga3);
        vehiculoCargas.add(vehiculoCarga4);

        // Crear vehículos de transporte
        VehiculoTransporte vehiculoTransporte1 = new VehiculoTransporte("MNO345", "Sprinter", "Mercedes-Benz", "Plata", 4);
        VehiculoTransporte vehiculoTransporte2 = new VehiculoTransporte("PQR678", "Hiace", "Toyota", "Blanco", 3);
        VehiculoTransporte vehiculoTransporte3 = new VehiculoTransporte("STU901", "Transit", "Ford", "Negro", 4);
        VehiculoTransporte vehiculoTransporte4 = new VehiculoTransporte("VWX234", "Ducato", "Fiat", "Gris", 2);

        vehiculoTransportes.add(vehiculoTransporte1);
        vehiculoTransportes.add(vehiculoTransporte2);
        vehiculoTransportes.add(vehiculoTransporte3);
        vehiculoTransportes.add(vehiculoTransporte4);

        // Crear propietarios
        propietarios.add(Propietario.Builder().nombre("Juan Perez").edad(50).cedula("123456789").email("juan@example.com").celular("3001234567").vehiculo(vehiculoCarga1).build());
        propietarios.add(Propietario.Builder().nombre("Maria Gomez").edad(35).cedula("987654321").email("maria@example.com").celular("3009876543").vehiculo(vehiculoCarga2).build());
        propietarios.add(Propietario.Builder().nombre("Carlos Ruiz").edad(22).cedula("112233445").email("carlos@example.com").celular("3001122334").vehiculo(vehiculoCarga3).build());
        propietarios.add(Propietario.Builder().nombre("Ana Martinez").edad(45).cedula("556677889").email("ana@example.com").celular("3005566778").vehiculo(vehiculoCarga4).build());

        // Crear usuarios
        usuarios.add(Usuario.Builder().nombre("Carl").edad("21").peso(70).build());
        usuarios.add(Usuario.Builder().nombre("Camilo").edad("20").peso(75).build());
        usuarios.add(Usuario.Builder().nombre("Cesar").edad("27").peso(80).build());
        usuarios.add(Usuario.Builder().nombre("Daniel").edad("18").peso(75).build());
    }

    private static void mostrarDatosDePrueba(LinkedList<VehiculoTransporte> vehiculoTransportes,LinkedList<VehiculoCarga> vehiculoCargas,LinkedList<Propietario> propietarios,LinkedList<Usuario> usuarios) {
        System.out.println("Has seleccionado la opción 1 (Mostrar datos de prueba para la clase Empresa de Transporte)");

        // Prueba: Mostrar datos de prueba creados
        System.out.println("Propietarios:");
        propietarios.forEach(propietario -> System.out.println(propietario.toString()));

        System.out.println("\nUsuarios:");
        usuarios.forEach(usuario -> System.out.println(usuario.toString()));

        System.out.println("\nVehículos de Carga:");
        vehiculoCargas.forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("\nVehículos de Transporte:");
        vehiculoTransportes.forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }
}
