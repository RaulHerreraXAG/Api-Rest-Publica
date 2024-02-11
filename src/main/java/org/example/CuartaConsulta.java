package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.ApiConfig.API_KEY;

/**
 * Ejercicio 4:
 * Lugar de nacimiento y el signo del zodiaco del actor que hacía de Goku enla pelicula “Dragonball Evolution”
 */

/**
 * Esta clase proporciona tres funciones para obtener información relacionada con películas y actores:
 * 1. Obtiene el nombre de la película "Dragonball Evolution".
 * 2. Obtiene información sobre el elenco de la película con el título "Dragonball Evolution".
 * 3. Obtiene la fecha de nacimiento y el signo zodiacal de un actor específico.
 */
public class CuartaConsulta {
    public static void main(String[] args) {
        // Llamando a la función para obtener el nombre de la película
        //System.out.println(getNombrePelicula());

        // Llamando a la función para obtener información sobre el elenco de la película
        //System.out.println(getactor());

        // Llamando a la función para obtener la fecha de nacimiento y el signo zodiacal de un actor
        System.out.println(getCumpleSigno());
    }

    // Esta función obtiene el nombre de la película "Dragonball Evolution"
    public static String getNombrePelicula() {
        String moviename = "";
        try {
            // Construir la solicitud HTTP GET para obtener el nombre de la película
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/imdb_id/byTitle/Dragonball%20Evolution/"))
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
        return moviename;
    }

    // Esta función obtiene información sobre el elenco de la película con el título "Dragonball Evolution"
    public static String getactor() {
        String actor = "";
        try {
            // Construir la solicitud HTTP GET para obtener información sobre el elenco de la película
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/id/tt1098327/cast/"))
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
        return actor;
    }

    // Esta función obtiene la fecha de nacimiento y el signo zodiacal de un actor específico
    public static JSONObject getCumpleSigno() {
        JSONObject resultObject = new JSONObject();
        try {
            // Construir la solicitud HTTP GET para obtener información sobre un actor específico
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/actor/id/nm0154226/"))
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            // Realizar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Convertir la respuesta a un objeto JSON
            JSONObject jsonResponse = new JSONObject(response.body());

            // Obtener la fecha de nacimiento y el signo zodiacal del actor
            String cumple = jsonResponse.getJSONObject("results").getString("birth_date");
            String signo = jsonResponse.getJSONObject("results").getString("star_sign");

            // Imprimir la fecha de nacimiento y el signo zodiacal del actor para fines de depuración
            System.out.println("Cumpleaños del Actor: " + cumple);
            System.out.print("Signo del Actor : " + signo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultObject;
    }
}
