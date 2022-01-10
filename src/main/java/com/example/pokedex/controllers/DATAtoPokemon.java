package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescribed;
import com.example.pokedex.services.APIAccess;
import com.example.pokedex.services.PokemonData;


/**
 * Class which allows the conversion of Data coming from an APi to {@link Pokemon} object
 */
public class DATAtoPokemon {
    /**
     * Request to an API.
     */
    APIAccess request;

    /**
     * Constructor of DATAtoPokemon
     *
     * @param request A request to an api
     */
    public DATAtoPokemon(APIAccess request) {
        this.request = request;
    }

    /**
     * Create a {@link PokemonDescribed} object.
     *
     * @param id ID of the pokemon that we want
     * @return a {@link PokemonDescribed} object regarding the id that we give and the class variable request.
     */
    public PokemonDescribed CreatePokemonfromdata(int id) {
        // We save the data of the request in a PokemonData object
        PokemonData Data = this.request.Get(id);

        // We create a PokemonDescribed object with the PokemonData Data
        PokemonDescribed pokemon = new PokemonDescribed(Data);

        return pokemon;
    }
}
