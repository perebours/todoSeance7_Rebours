package com.example.pokedex.models;

import com.example.pokedex.services.PokemonData;


/**
 * This class heritate from {@link Pokemon}
 * It has a new variable: the description of the pokemon
 */
public class PokemonDescribed extends Pokemon {
    /**
     * The pokemon's description
     */
    public String description = null;

    /**
     * Constructor of PokemonDescribed
     *
     * @param Data Data of the pokemon
     */
    public PokemonDescribed(PokemonData Data) {
        //We call the constructor of the parent class
        super(Data);
        // We assign a description only if there is one in Data
        if (Data.getDescription() != null) {
            this.description = Data.description;
        }
    }

    /**
     * Getter for the pokemon's description
     *
     * @return the pokemon's description
     */
    public String getDescription() {
        return this.description;
    }
}
