package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Class to make a request to the API pokeapi
 */
public class PokeAPIRequest implements APIAccess {
    /**
     * Data of the pokemon that the user is looking for
     */
    public PokemonData Data = new PokemonData();

    /**
     * Address of the API HTTP
     */
    public String address = "https://pokeapi.co/api/v2/pokemon/";

    /**
     * Convert a http response into a json response
     *
     * @param result Http response that we want to convert
     * @return Object which suppose to be a json response
     */
    public Object HttpToJson(HttpResponse result) {

        //Variable to stock de json response as a string
        String jsonResponse = "";

        //Object which will contain the JSON response
        Object resultObject = null;

        try {
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");
            JSONParser parser = new JSONParser();
            resultObject = parser.parse(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }
        return resultObject;
    }

    /**
     * Set the variables of a PokemonData object (Data) according to a {@link JSONObject}
     *
     * @param resultObject Json object which contains the data
     */
    public void SetPokemonData(JSONObject resultObject) {
        JSONObject obj = (JSONObject) resultObject;
        Data.setId(((Long) obj.get("id")).intValue());
        Data.setName((String) obj.get("name"));
        Data.setWeight(((Long) obj.get("weight")).intValue());
        Data.setHeight(((Long) obj.get("height")).intValue());
    }

    /**
     * @param id ID of the pokemon that the user is looking for
     * @return a {@link PokemonData} object
     * @see PokemonData
     */
    @Override
    public PokemonData Get(int id) {
        Object resultObject;
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(address + id);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            resultObject = HttpToJson(result);
            if (resultObject instanceof JSONObject) {
                SetPokemonData((JSONObject) resultObject);
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Data;
    }
}
