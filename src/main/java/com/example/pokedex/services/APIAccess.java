package com.example.pokedex.services;


/**
 * Service which gets data from an API.
 */
public interface APIAccess {
    /**
     * Get data about a pokemon regarding its id from an API.
     *
     * @param id ID of the pokemon that the user is looking for
     * @return a {@link PokemonData} object
     */
    public PokemonData Get(int id);
}
