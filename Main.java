import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            ArrayList<Persona> personasList = new ArrayList<>();

        String linea = " ";
        String delimitador = ":";


            String rutaFile = "src/main/DatosPersona.txt";
            FileReader fileReader = new FileReader(rutaFile);
            BufferedReader reader = new BufferedReader(fileReader);

            while ((linea = reader.readLine()) != null) {
                String[] campo = linea.split(delimitador);


                String Nombre="" ;
                String Ciudad = "";
                String Edad ="";

                Nombre = campo[0];

                if (campo.length > 1){
                    if (campo[1].isEmpty()){
                        Ciudad = "desconocida";
                    }else {
                        Ciudad = campo[1];
                    }
                }

                if (campo.length > 2){
                    if (campo[2].isEmpty() || campo[2] == null){
                        Edad = "Desconocida";
                    }else {
                        Edad = campo[2];
                    }
                }
                Persona persona = new Persona(Nombre,Ciudad,Edad);
                personasList.add(persona);
            }


            List<Persona> ListaFiltrada =  personasList.stream()
                    .filter(p ->!p.getEdad().isEmpty())
                    .filter(p -> Integer.parseInt(p.getEdad()) < 25)
                    .collect(Collectors.toList());
            ListaFiltrada.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
