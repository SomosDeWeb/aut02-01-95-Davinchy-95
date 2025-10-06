public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private double nota;
    private boolean matricula;

    Estudiante(String nombre, String apellido, int edad, double nota, boolean matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nota = nota;
        this.matricula = matricula;
    }

    // usamos getter para obtener los atributos de la clase
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public double getNota(){
        return nota;
    }
    public boolean getMatricula(){
        return matricula;
    }

    // usamos setter para modificar los atributos de la clase
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setEdad( int edad){
        this.edad = edad;
    }
    public void setNota( int nota){
        this.nota = nota;
    }
    public void setMatricula(boolean matricula) {
        this.matricula = matricula;
    }

    // hacemos y usamos validaciones
    public void validar() {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (apellido == null || apellido.isBlank())
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        if (edad < 0)
            throw new IllegalArgumentException("La edad no puede ser negativa");
        if (nota < 0.0)
            throw new IllegalArgumentException("La nota no puede ser negativa");
    } /*
        - throw: es una palabra reservada para lanzar una excepcion
        - new illegalArgumentException: indica que un metodo ha recibido un argumento ilegal o inapropiado
        */

    // usamos cadena toString para mostrar los atributos de la clase
    @Override
    public String toString() {
        return "Nombre: "+nombre+", Apellido: "+apellido+", Edad: "+edad+", Nota: "+nota+", Matricula: "+matricula;
    }
}
