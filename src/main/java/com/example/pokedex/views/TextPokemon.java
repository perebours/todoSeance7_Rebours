package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

/**
 * Methods useful to manage a text about a pokemon.
 */
public interface TextPokemon {
    /**
     * Generate a text about a {@link Pokemon}
     *
     * @return Text about the pokemon
     */
    public String generateText();
}
