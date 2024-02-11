package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.ApiConfig.API_KEY;

/**
 * Ejercicio 3:
 * El título y argumento del primer episodio de la 3ª saga (temporada) de la serie: Saga del Ejército de la Patrulla Roja.
 */


/**
 * Esta clase proporciona dos funciones para obtener información sobre la serie "Dragon Ball":
 * 1. Obtiene el ID de la serie "Dragon Ball".
 * 2. Obtiene el número y argumento del primer episodio de la tercera saga (temporada) de la serie.
 */
public class TerceraConsulta {
    public static void main(String[] args) {
        // Imprimir el resultado de obtener la serie
        System.out.println(getSerie());
        // Imprimir el resultado de obtener el episodio
        System.out.println(getEpisodio());
    }

    // Esta función obtiene el ID de la serie "Dragon Ball"
    public static String getSerie() {
        String seriesId = "";
        try {
            // Construir la solicitud HTTP GET para obtener el ID de la serie
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
            // Imprimir la respuesta para fines de depuración
            System.out.println(jsonResponse.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seriesId;
    }

    // Esta función obtiene el número y argumento del primer episodio de la tercera saga (temporada) de la serie
    public static String getEpisodio() {
        String episodio_number = "";
        try {
            // Construir la solicitud HTTP GET para obtener la información del episodio
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/season/3/episode/1/"))
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            // Realizar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Convertir la respuesta a un objeto JSON
            JSONObject jsonResponse = new JSONObject(response.body());
            // Imprimir la respuesta para fines de depuración
            System.out.println(jsonResponse.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return episodio_number;
    }
}
