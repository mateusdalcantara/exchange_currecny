package br.com.example.entites;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiHandler {

    public String currency(String firstMoney, String secondMoney, Double amount) {

        try {

            //Get the file with api key.
            String apiKey = new String(Files.readAllBytes(Paths.get("apiKey.txt")));

            String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + firstMoney + "/"
                    + secondMoney + "/" + amount;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            try {

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {

                    String stringResponse = response.body();

                    Gson gson = new Gson();
                    JsonDeserializer showTheInputOfApi = gson.fromJson(stringResponse, JsonDeserializer.class);

                    System.out.println(showTheInputOfApi.toString());

                } else {
                    System.err.println("Failed to fetch data. HTTP error code: " + response.statusCode());
                }

            } catch (IOException | InterruptedException e) {
                System.err.println("Request failed: " + e.getMessage());
            }
        } catch (JsonSyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


