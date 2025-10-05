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

class Estudiante { //creacion de la clase estudiante con sus atributos
    String nombre;
    int edad;
    double nota;

    Estudiante(String nombre, int edad, double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String toString() {
        return "Nombre: "+nombre+", Edad: "+edad+", Nota: "+nota;
    }
}

class void main() {

    public static void main(String[] args) {

        Scanner save = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int opcion;

        do {

            // Marcamos un numero para cada accion
            System.out.println("\n--- Abrir menu de gestor de Estudiantes ---");
            System.out.println("marca 1: Añadir una nuevo estudiante");
            System.out.println("marca 2: Listar todos los estudiantes");
            System.out.println("marca 3: Buscar un estudiante por nombre");
            System.out.println("marca 4: Calcular la media de notas");
            System.out.println("marca 5: Mostrar un estudiante con mejor nota");
            System.out.println("marca 6: Salir");
            System.out.print("Por favor , elige una opción: ");
            opcion = Integer.parseInt(save.nextLine());

            // Al numero selecionado le hacemos el switch
            switch (opcion) {

                case 1:
                    // añadimos estudiante con nombre , edad y nota.
                    System.out.print("Nombre: ");
                    String nombre = save.nextLine();

                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(save.nextLine());

                    System.out.print("Nota: ");
                    double nota = Double.parseDouble(save.nextLine());

                    estudiantes.add(new Estudiante(nombre, edad, nota)); // agregamos a la lista

                    System.out.println("Estudiante añadido correctamente.");

                    break;

                case 2:
                    // listamos a los estudiantes
                    System.out.println("Lista de estudiantes: ");

                    // usamos un forEach para recorrer la coleccion estudiantes que podemos procesar por cada estudiante
                    for (Estudiante e : estudiantes) {
                        System.out.println(e);
                    }

                    break;

                case 3:

                    // buscamos el estudiante
                    System.out.print("Nombre a buscar: ");
                    String buscar = save.nextLine();

                    boolean encontrado = false;

                    // buscamos nombre de estudiantre dentro de la lista ignorando mayuscula o miniscula
                    for (Estudiante e : estudiantes) {
                        if (e.nombre.equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado: " + e);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se pudo encontrar el estudiante.");
                    }

                    break;

                case 4:

                    // calculamos media de la nota
                    if (estudiantes.size() == 0) {
                        System.out.println("No hay estudiantes registrados.");

                    } else {
                        double media = calcularMedia(estudiantes);
                        System.out.println("LA media de la nota es: " + media);
                    }

                    break;

                case 5:
                case 6:

                default:
                    System.out.println("Opción no válida.");

            }

        }  while (opcion != 6);

        save.close();
    }

    // Funcion para calcular la media de las notas
    public static double calcularMedia(ArrayList<Estudiante> estudiantes) {
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.nota;
        }
        return suma / estudiantes.size();
    } // es lo mismo que ( media = sumarTodasLasNotas / numeroDeNotas )

}
