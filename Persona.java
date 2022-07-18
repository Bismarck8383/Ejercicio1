import java.util.Optional;

public class Persona {
    public String edad;
    public String nombre;
    public String poblacion;
    public static int Linea = 0;
    public String getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Persona(String nombre, String poblacion, String edad) {
        this.edad = edad;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public Persona() {

    }

    @Override
    public String toString() {
        Linea = Linea + 1;
        final String[] Salida = {""};
        Salida[0] += " Linea:" + Linea + " nombre: " + nombre;

        Optional<String> empCity = Optional.ofNullable(poblacion);
        Salida[0] += empCity.isEmpty() ? " Poblacion Desconocida " : " Poblacion " + poblacion;

        Optional<String> empEdad = Optional.ofNullable(edad);
        Salida[0] += empEdad.isEmpty() ? " Edad Desconocida " : " Edad " + edad;

        return Salida[0];
    }
}
