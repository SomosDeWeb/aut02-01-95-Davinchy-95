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



    }
}
