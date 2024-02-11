package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.ApiConfig.API_KEY;

/**
 * Ejercicio 6:
 * De ese mismo año es la película Postergeist, el primer gran éxito de Steven Spielberg como productor,que participó en
 * los premios Oscars al año siguientesin ser ganadora. ¿Aquéapartado fue nominada? ¿Que otro premio ganó ese año?
 */
/**
 * Esta clase proporciona dos funciones para obtener información sobre películas:
 * 1. Obtiene el ID de una película lanzada en un año específico (en este caso, 1982).
 * 2. Obtiene información sobre los premios ganados por una película específica.
 */
public class SextaConsulta {
    public static void main(String[] args) {
        // Imprimir el resultado de obtener el ID de la película
        //System.out.println(getPeliculaId());

        // Imprimir el resultado de obtener información sobre los premios ganados por una película
        System.out.println(getGanadorPremio());
    }

    // Esta función obtiene el ID de una película lanzada en un año específico (en este caso, 1982)
    public static String getPeliculaId() {
        String IdPelicula = "";
        try {
            // Construir la solicitud HTTP GET para obtener información sobre las películas lanzadas en un año específico
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/byYear/1982/"))
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
        return IdPelicula;
    }

    // Esta función obtiene información sobre los premios ganados por una película específica
    public static String getGanadorPremio() {
        String ganador = "";
        try {
            // Construir la solicitud HTTP GET para obtener información sobre los premios ganados por una película específica
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/id/tt0084516/awards/"))
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
        return ganador;
    }
}

