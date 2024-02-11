package org.example;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static org.example.ApiConfig.API_KEY;

/**
 * Ejericicio 1
 *
 * Cuantas series de "Dragon Ball" hay registradas.
 */


/**
 * Esta clase realiza una consulta a una API para obtener información sobre series de televisión
 * con el título "Dragon Ball" y muestra la cantidad de series encontradas, así como una
 * representación en formato JSON de la respuesta recibida.
 */
public class PrimeraConsulta {
    public static void main(String[] args) throws IOException, InterruptedException, JSONException {
        // Construir la solicitud HTTP GET para la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20Ball/"))
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Realizar la solicitud HTTP y obtener la respuesta
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir la respuesta a un objeto JSON
        JSONObject jsonResponse = new JSONObject(response.body());

        // Obtener el arreglo de resultados de la respuesta JSON
        JSONArray jsonArray = jsonResponse.getJSONArray("results");

        // Imprimir la cantidad de series de "Dragon Ball" encontradas
        System.out.println("Cantidad de series de Dragon Ball: " + jsonArray.length());
        System.out.println(""); // Imprimir una línea en blanco

        // Imprimir una representación JSON formateada de la respuesta completa
        System.out.println(jsonResponse.toString(3));
    }
}
