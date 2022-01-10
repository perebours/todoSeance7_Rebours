package com.example.pokedex.models;

import com.example.pokedex.services.PokemonData;


/**
 * Pokemon is the class which represent pokemons
 */
public class Pokemon {
    /**
     * ID of the pokemon
     */
    public int id;
    /**
     * Name of the pokemon
     */
    public String name;
    /**
     * Weight of the pokemon
     */
    public int weight;
    /**
     * Height of the pokemon
     */
    public int height;


    /**
     * Generate a {@link Pokemon} object.
     *
     * @param Data A {@link PokemonData} object
     */
    public Pokemon(PokemonData Data) {
        this.id = Data.getId();
        this.name = Data.getName();
        this.weight = Data.getWeight();
        this.height = Data.getHeight();
    }

    /**
     * Getter for the pokemon's ID
     *
     * @return ID of the Pokemon object
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for the pokemon's name
     *
     * @return Name of the Pokemon object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the pokemon's weight
     *
     * @return Weight of the Pokemon object
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Getter for the pokemon's height
     *
     * @return Height of the Pokemon object
     */
    public int getHeight() {
        return this.height;
    }
}
