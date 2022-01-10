package com.example.pokedex.services;

/**
 * A class to save the data taken from the result of an API request
 *
 * @see APIAccess
 */
public class PokemonData {
    /**
     * ID taken from the Data
     */
    public int id;
    /**
     * Name taken from the Data
     */
    public String name;
    /**
     * Weight taken from the Data
     */
    public int weight;
    /**
     * Height taken from the Data
     */
    public int height;
    /**
     * Description taken from the Data
     */
    public String description;

    /**
     * Setter for id of {@link PokemonData} object.
     *
     * @param id ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for name of {@link PokemonData} object
     *
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for weight of {@link PokemonData} object
     *
     * @param weight Weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Setter for height of {@link PokemonData} object
     *
     * @param height Height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Setter for description of {@link PokemonData} object
     *
     * @param description Description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for id of {@link PokemonData} object
     *
     * @return Id of the {@link PokemonData} object
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for name of {@link PokemonData} object
     *
     * @return Name of the {@link PokemonData} object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for weight of {@link PokemonData} object
     *
     * @return Weight of the {@link PokemonData} object
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Getter for height of {@link PokemonData} object
     *
     * @return Height of the {@link PokemonData} object
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for description of {@link PokemonData} object
     *
     * @return Description of the {@link PokemonData} object
     */
    public String getDescription() {
        return description;
    }
}
