package com.example.pokedex.views;


/**
 * Class which contains methods for the console log.
 */
public class ConsoleLogUtility {
    /**
     * Print a text about a pokemon in parameter.
     *
     * @param generator Display related to a pokemon
     * @see TextPokemon
     */
    public static void logTextToConsole(TextPokemon generator) {
        System.out.println(generator.generateText());
    }
}

