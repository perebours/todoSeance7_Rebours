package com.example.pokedex.controllers;

import com.example.pokedex.controllers.DATAtoPokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescribed;
import com.example.pokedex.services.APIAccess;
import com.example.pokedex.services.PokemonData;
import org.junit.Assert;
import org.junit.Test;


public class PokemonsControllerTest {

    /**
     * Ce test vérifie que la méthode `getPokemon` de la classe {@link DATAtoPokemon}
     * renvoie bien une instance de la classe {@link PokemonDescribed}, dans le cas où le service
     * qui implémente l'interface {@link APIAccess} renvoit bien des données qui comprennent
     * une description de pokémon.
     * (dans le cas contraire, c'est une instance de la classe {@link Pokemon} qui serait renvoyée).
     *
     * Pour celà nous implémentons un service mock, qui implémente l'interface {@link APIAccess}
     * et qui renvoit un jeu de données de test, comprenant une description de pokémon.
     *
     * Le test vérifie ensuite que l'instance PokemonDescribed a bien tous les attributs
     * aux valeurs attendues, compte tenu des données de tests renvoyées par notre mock.
     */
    @Test
    public void getPokemon() {
        DATAtoPokemon pokemonsController = new DATAtoPokemon(new PokemonFetcherMock());
        Pokemon pokemon = null;

        try {
            pokemon = pokemonsController.CreatePokemonfromdata(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * The fetcher returned a description, test that the controller returns an instance
         * of PokemonDescribed
         */
        Assert.assertTrue(pokemon instanceof PokemonDescribed);
        PokemonDescribed PokemonDescribed = (PokemonDescribed) pokemon;

        /**
         * Test that the controller created the pokemon instance with all
         * the correct data
         */
        Assert.assertEquals(2, pokemon.getId());
        Assert.assertEquals("Poketest", pokemon.getName());
        Assert.assertEquals(22, pokemon.getHeight());
        Assert.assertEquals(33, pokemon.getWeight());
        Assert.assertEquals("Poke test description", PokemonDescribed.getDescription());

    }


    /**
     * Class which is a mock API
     */
    class PokemonFetcherMock implements APIAccess {
        public PokemonData Data= new PokemonData();

        public PokemonData Get(int id){
            Data.setId(id);
            Data.setName((String) "Poketest");
            Data.setHeight(22);
            Data.setWeight(33);
            Data.setDescription("Poke test description");


            return Data;
        }
    }
}