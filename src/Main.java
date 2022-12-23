import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Ciudad de Mexico");
        cities.add("Lima");

        //Recorrer una lista de forma tradicional
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }

        // Recorrer una lista de forma abrebiada
        for (String city : cities) {
            System.out.println(city);
        }

        //Ejemplo de stream
        cities.stream().forEach(city -> System.out.println(city));

        /*Exprecion lambda 
        ######### city -> System.out.println(city) ###########
        Es tratar de crear una funcion en una sola linea
        (si solo tendara una variable no es nesesario declarar el tipo de la variable 
        y si solo tiene una linea de codigo no es nesesario poner las llaves)
        */

        //Lamar una funcion tradicional e stram (referencia de metodo)
        cities.stream().forEach(Main::printCity);
        /*en ves de ser Main.prinCity, es con doble dos puntos Main::printCity */
        cities.stream().forEach(System.out::println);

        //Tambien se puede usar directo el foreach, pero el stream aunque no este, siempre se esta usando
        cities.forEach(System.out::println);

        //Ejecutar un proceso en paralelo
        cities.stream().parallel().forEach(System.out::println);

        //Al cocatenar metodos con "." estamos usando el patron de diseño Pipeline
        //Ejemplo de pipeline con filter
        /*cities.stream().filter(city -> city.startsWith("B")).forEach(System.out::println);*/
        cities.stream()
        .filter(city -> city.startsWith("B"))
        .forEach(System.out::println);

        //Ejemplo de expresion lambda con varias lineas
        cities.stream().filter(city -> {
            boolean result = city.startsWith("B");
            return result;
        });

        //Agregemos otro filto al metodo
        cities.stream()
        .filter(city -> city.startsWith("B"))
        .filter(city -> city.contains("n"))
        .forEach(System.out::println);

        /*Existen dos tipos de metodos
         * 1.- Metodos terminales
         * foreach
         * 2.- Metodos no terminales (NUNCA VAN A SER TERMINALES)
         * filter
         * 
         */

        /*Ejemplo, no lo podmeos guardar en una lista, porque no tiene metodo terminal
        List <String> filttredCities = cities.stream()
        .filter(city -> city.startsWith("B"))
        .filter(city -> city.contains("n"));*/

        //Usando el metodo terminal collect(collectors.toList()) si se podria hacer
        List <String> filttredCities = cities.stream()
        .filter(city -> city.startsWith("B"))
        .filter(city -> city.contains("n"))
        .collect(Collectors.toList());
        //El metodo collect permite convertir un stream en una lista
    }

    //Metodo filtrar ciudad
    public static boolean filterCity(String city) {
        return city.startsWith("B");
    }

    //Metodo tradicional
    public static void printCity(String city) {
        System.out.println(city);
    }
}
