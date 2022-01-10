package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

/**
 * Methods useful to manage html file about a pokemon.
 */
public interface HtmlPokemon {
    /**
     * Generate the content of a html file according to a {@link Pokemon} object
     *
     * @return html file about the pokemon
     */
    public String generateHtml();
}
