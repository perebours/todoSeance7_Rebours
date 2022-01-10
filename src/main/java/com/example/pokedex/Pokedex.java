package com.example.pokedex;


import com.example.pokedex.controllers.DATAtoPokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.APIAccess;
import com.example.pokedex.services.LocalRequest;
import com.example.pokedex.services.PokeAPIRequest;
import com.example.pokedex.views.DisplayPokemon;
import com.example.pokedex.views.DisplayPokemonDescribed;

import static com.example.pokedex.views.ConsoleLogUtility.logTextToConsole;
import static com.example.pokedex.views.FileLogUtility.logHtmlToFile;

/**
 * Main class of the application Pokedex.
 * Pokedex allows to find a pokemon giving its id in the API pokeapi (if no second argument is given)
 * or in a particular local SQLite database (if its path is given as a second argument).
 *
 * @author Pierre-Emmanuel Rebours
 * @version 1.0
 */
public class Pokedex {
    /**
     * main method
     *
     * @param args Parameters given by the user
     */
    public static void main(String[] args) {
        //If the user give no argument:
        if (args.length == 0) {
            System.out.println("Please enter arguments: <pokemonId> (necessary)  and <databaseFile> (optional) ");
            System.exit(0);
        }

        int id = 0;
        //We save into the variable id the ID given by the user (if it is an int).
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("Please give an existing id");
            System.exit(0);
        }
        System.out.println("It's working !");
        //if the user give an argument,the id that he selected is printed on the console.
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        // if the user give more than one argument:
        if (args.length > 1) {
            //Initialisation of a local request
            APIAccess request = new LocalRequest(args[1]);

            //Conversion of Data taken from the API into a pokemon.
            DATAtoPokemon Pokemonscontroller = new DATAtoPokemon(request);

            //Creation of a Pokemon object according to the data taken from the API.
            Pokemon WantedPokemon = Pokemonscontroller.CreatePokemonfromdata(id);

            //Initialisation of the display corresponding to the pokemon
            DisplayPokemon dp = new DisplayPokemonDescribed(WantedPokemon);

            //Creation of a html file about the pokemon in the execution directory
            logHtmlToFile(System.getProperty("user.dir") + "/output.html", dp);

            //Display the pokemon
            logTextToConsole(dp);


        } else {
            //Request to the API pokeapi:
            APIAccess request = new PokeAPIRequest();

            //Initialisation of a Pokemon controllers according to the request made before.
            DATAtoPokemon Pokemonscontroller = new DATAtoPokemon(request);

            //Creation of a Pokemon object according to the data taken from the API.
            Pokemon WantedPokemon = Pokemonscontroller.CreatePokemonfromdata(id);

            //Initialisation of the display corresponding to the pokemon
            DisplayPokemon dp = new DisplayPokemon(WantedPokemon);

            //Creation of a html file about the pokemon in the execution directory
            logHtmlToFile(System.getProperty("user.dir") + "/output.html", dp);

            //Display the pokemon
            logTextToConsole(dp);
        }
    }
}
