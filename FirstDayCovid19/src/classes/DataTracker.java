/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author migu_
 */
public class DataTracker {
    private static String COVID_API_URL = "https://api.covid19api.com/dayone/country/guatemala/status/confirmed";
    private List<Country> datos;

    public DataTracker(String pais_a_buscar){
        COVID_API_URL = "https://api.covid19api.com/dayone/country/"+pais_a_buscar+"/status/confirmed";
    }

    public void descargarDatos() throws IOException, InterruptedException{
        System.out.println("Conectando a la API...");
        // código para conectarse a la API y descargar los datos.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json")
                .uri(URI.create(COVID_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("¡Conexión exitosa! Descargando datos...");
        ObjectMapper mapper = new ObjectMapper();
        // obtener listado de datos del país
        datos = mapper.readValue(response.body(), new TypeReference<List<Country>>() {});
        System.out.println("¡Datos descargados!");
    }

    public List<Country> getCountries() {
        return datos;
    }
}
