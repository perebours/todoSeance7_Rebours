package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescribed;

/**
 * Class which contains methods to make a view of a {@link PokemonDescribed} object
 */
public class DisplayPokemonDescribed extends DisplayPokemon {

    public DisplayPokemonDescribed(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public String generateText() {
        String Text = "=============================" + "\n"
                + "Pokemon # " + this.pokemon.id + "\n"
                + "Nom : " + this.pokemon.name + "\n"
                + "Taille : " + this.pokemon.height + "\n"
                + "Poids : " + this.pokemon.weight + "\n"
                + "Description : " + ((PokemonDescribed) this.pokemon).description + "\n"
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
                + "<li>Poids : " + ((PokemonDescribed) this.pokemon).description + "</li>" + "\n"
                + "<ul>";
        return Html;
    }
}
