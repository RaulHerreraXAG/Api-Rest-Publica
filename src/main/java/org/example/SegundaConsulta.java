package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.ApiConfig.API_KEY;

/**
 * Ejercicio 2 :
 * La url del poster de la primera serie que aparece registrada (del 1995)
 */


/**
 * Esta clase proporciona dos consultas a una API relacionada con la serie "Dragon Ball":
 * 1. Obtiene el ID de la primera serie encontrada con el título "Dragon Ball".
 * 2. Obtiene la URL del póster de la primera serie registrada (del año 1995).
 */
public class SegundaConsulta {
    public static void main(String[] args) {
        // Llamando a la función para obtener la URL de la imagen del póster de la serie
        System.out.println(getURLImagen());
    }

    // Esta función obtiene el ID de la primera serie encontrada con el título "Dragon Ball"
    public static String getFirstSeriesId() {
        String Id = "";
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
            System.out.println(jsonResponse.toString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Id;
    }

    // Esta función obtiene la URL de la imagen del póster de la serie registrada en 1995
    public static JSONObject getURLImagen() {
        JSONObject resultObject = new JSONObject();
        try {
            // Construir la solicitud HTTP GET para obtener la información de la serie
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/"))
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            // Realizar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Convertir la respuesta a un objeto JSON
            JSONObject jsonResponse = new JSONObject(response.body());
            // Obtener el año de inicio de la serie
            int startYear = jsonResponse.getJSONObject("results").getInt("start_year");
            // Obtener la URL del banner (póster) de la serie
            String bannerUrl = jsonResponse.getJSONObject("results").getString("banner");

            // Imprimir el año de inicio y la URL del banner para fines de depuración
            System.out.println("Año: " + startYear);
            System.out.print("Foto: " + bannerUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultObject;
    }
}

