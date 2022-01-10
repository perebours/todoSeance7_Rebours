package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

/**
 * Class which contains methods to make a view of a {@link Pokemon} object
 */
public class DisplayPokemon implements TextPokemon, HtmlPokemon {
    /**
     * {@link Pokemon} to display
     */
    public Pokemon pokemon;

    /**
     * Constructor of {@link DisplayPokemon}
     * @param pokemon {@link Pokemon} to display
     */
    public DisplayPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }


    @Override
    public String generateText() {
        String Text = "=============================" + "\n"
                + "Pokemon # " + this.pokemon.id + "\n"
                + "Nom : " + this.pokemon.name + "\n"
                + "Taille : " + this.pokemon.height + "\n"
                + "Poids : " + this.pokemon.weight + "\n"
                + "=============================";
        return Text;
    }

    @Override
    public String generateHtml() {
        String Html = "<h1>" + this.pokemon.name + "</h1>" + "\n"
                + "<ul>" + "\n"
                + "<li>Id : " + this.pokemon.id + "</li>" + "\n"
                + "<li>Taille : " + this.pokemon.height + "</li>" + "\n"
                + "<li>Poids : " + this.pokemon.weight + "</li>" + "\n"
                + "<ul>";
        return Html;
    }
}
