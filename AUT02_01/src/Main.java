/*
1. Creación del proyecto vacío
2. Creación de la clase principal que contiene el método Main
3. Añadir un nuevo estudiante
4. Listar todos los estudiantes registrados
5. Buscar un estudiante por su nombre
6. Calcular la media de todas las notas
7. Mostrar al estudiante con la mejor calificación
8. Permitir salir del programa
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner save = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int opcion = 0;

        do {
            // Marcamos un numero para cada accion
            System.out.println("--- Abriendo el menu de gestor de los Estudiantes ---");
            System.out.println("marca 1: Añadir una nuevo estudiante");
            System.out.println("marca 2: Listar todos los estudiantes");
            System.out.println("marca 3: Buscar un estudiante por nombre");
            System.out.println("marca 4: Calcular la media de notas");
            System.out.println("marca 5: Mostrar un estudiante con mejor nota");
            System.out.println("marca 6: Salir");
            System.out.print("Por favor , elige una opción: ");

            String opcionStr = save.nextLine().trim();
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Introduce un número válido para la opción.");
                continue;
            }


            // Al numero selecionado le hacemos el switch
            switch (opcion) {

                case 1:
                    // añadimos estudiante con nombre , apellido , edad, nota y matriculacion.
                    // validamos de manera segura los campos
                    // usamos try-catch para mostrarle al usuario posibles errores y evitar agregar los datos a estudiante

                    // nombres y apelllidos agregados y validados
                    try {
                        System.out.print("Nombre: ");
                        String nombre = save.nextLine().trim();
                        if (nombre.isEmpty()) {
                            System.out.println("ERROR: El nombre no puede estar vacío.");
                            break;
                        }

                        System.out.print("Apellido: ");
                        String apellido = save.nextLine().trim();
                        if (apellido.isEmpty()) {
                            System.out.println("ERROR: El apellido no puede estar vacío.");
                            break;
                        }

                        // edad agregada y validada
                        int edad;
                        while (true) {
                            System.out.print("Edad: ");
                            String edadStr = save.nextLine().trim();
                            if (edadStr.isEmpty()) {
                                System.out.println("ERROR: La edad no puede estar vacía.");
                                continue;
                            }
                            try {
                                edad = Integer.parseInt(edadStr);
                                if (edad < 0) {
                                    System.out.println("ERROR: La edad no puede ser negativa.");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("ERROR: Introduce un número entero válido para la edad.");
                            }
                        }

                        // nota agregada  y validada
                        double nota;
                        while (true) {
                            System.out.print("Nota (usa punto o coma para decimales): ");
                            String notaStr = save.nextLine().trim().replace(',', '.'); //(se permite coma o punto)
                            if (notaStr.isEmpty()) {
                                System.out.println("ERROR: La nota no puede estar vacía.");
                                continue;
                            }
                            try {
                                nota = Double.parseDouble(notaStr);
                                if (nota < 0.0) {
                                    System.out.println("ERROR: La nota no puede ser negativa.");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("ERROR: Introduce un número válido para la nota (ej. 7.5).");
                            }
                        }

                        // matrícula le damos una lectura más amigable (s/n)
                        boolean matricula;
                        while (true) {
                            System.out.print("¿Está matriculado? (s/n): ");
                            String matStr = save.nextLine().trim().toLowerCase();
                            if (matStr.isEmpty()) {
                                System.out.println("ERROR: Debes responder 's' o 'n'.");
                                continue;
                            }
                            if (matStr.equals("s") || matStr.equals("si") || matStr.equals("true")) {
                                matricula = true;
                                break;
                            } else if (matStr.equals("n") || matStr.equals("no") || matStr.equals("false")) {
                                matricula = false;
                                break;
                            } else {
                                System.out.println("ERROR: Responde 's' (sí) o 'n' (no).");
                            }
                        }

                        // Crear Estudiante y validar usando el método validar()
                        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, nota, matricula);
                        nuevoEstudiante.validar(); // si se puede lanzar illegalArgumentException
                        estudiantes.add(nuevoEstudiante);
                        System.out.println("El estudiante fue añadido correctamente.");

                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:

                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else { // listamos a los estudiantes
                        System.out.println("Lista de estudiantes:");
                            for (Estudiante e : estudiantes) { // usamos un forEach para recorrer la coleccion estudiantes y que podemos procesar por cada estudiante
                            System.out.println(e);
                            }
                    }
                    break;

                case 3:
                    System.out.print("Diga nombre o apellido para buscar: ");
                    String buscar = save.nextLine().toLowerCase();
                    if (buscar.isEmpty()) {
                        System.out.println("ERROR: La búsqueda no puede estar vacía.");
                        break;
                    }

                    boolean encontrado = false;

                    // buscamos nombre de estudiantre dentro de la lista ignorando mayuscula o miniscula
                    for (Estudiante e : estudiantes) {
                        if (e.getNombre().toLowerCase().contains(buscar) || e.getApellido().toLowerCase().contains(buscar)) {
                            System.out.println("Encontrado: " + e);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se pudo encontrar el estudiante.");
                    }
                    break;

                case 4:
                    // Mostramos la funcion que calcula la media de la nota
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");

                    } else {
                        double media = calcularMedia(estudiantes);
                        System.out.println("La media de la nota es: " + media);
                    }
                    break;

                case 5:
                    // Mostramos la funcion del estudiante con la mejor calificacion.
                    if (estudiantes.size() == 0) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        Estudiante mejorNota = mejorEstudiante(estudiantes);
                        System.out.println("El estudiante con mejor nota es: " + mejorNota);
                    }
                    break;

                case 6:
                    // salimos del programa
                    System.out.println("--- Saliendo del programa, vuelva pronto. ---");
                    break;

                default:
                    System.out.println("ERROR: opción no válida, vuelva a intentarlo.");
            }
        }  while (opcion != 6);
        save.close();
    }


    // Funcion para calcular la media de las notas
    public static double calcularMedia(ArrayList<Estudiante> estudiantes) {
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.getNota();
        } // es lo mismo que ( media = sumarTodasLasNotas / numeroDeNotas )
        return suma / estudiantes.size();
    }


    // Funcion para buscar el estudiante con la mejor nota
    public static Estudiante mejorEstudiante(ArrayList<Estudiante> estudiantes) {

        Estudiante mejor = estudiantes.get(0);
        for (Estudiante e : estudiantes) {
            if (e.getNota() > mejor.getNota()) {
                mejor = e;
            }
        }
        return mejor;
    }
}
