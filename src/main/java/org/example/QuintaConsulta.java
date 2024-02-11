package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.ApiConfig.API_KEY;

/**
 * Ejercicio 5:
 * Del año en que nació el anterior actor, ¿cuántas películas hay registradasen la base de datos?
 */

/**
 * Esta clase proporciona una función para obtener el número de películas registradas en la base de datos
 * que fueron lanzadas en un año específico, el mismo año en que nació un actor anterior.
 */
public class QuintaConsulta {

    public static void main(String[] args) throws JSONException, IOException, InterruptedException {
        // Imprimir el resultado de la función peliculasRegistradas()
        System.out.println(peliculasRegistradas());
    }

    // Esta función obtiene el número de películas registradas en la base de datos que fueron lanzadas en un año específico
    public static int peliculasRegistradas() throws JSONException, IOException, InterruptedException {
        int numeroPeliculas = 0;

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
        JSONObject json = new JSONObject(response.body());

        // Imprimir la respuesta JSON para fines de depuración
        System.out.println(json.toString(2));

        // Obtener el número de películas registradas en la base de datos
        // Podrías necesitar ajustar esta parte dependiendo de la estructura de la respuesta JSON
        // En este ejemplo, suponemos que el número de películas se encuentra en el campo "total_results"
        numeroPeliculas = json.getInt("total_results");

        return numeroPeliculas;
    }

}

