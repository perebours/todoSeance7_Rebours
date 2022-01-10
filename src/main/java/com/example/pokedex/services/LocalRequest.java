package com.example.pokedex.services;


import java.io.File;
import java.sql.*;

/**
 * Class to make a request to a local SQLite database
 */
public class LocalRequest implements APIAccess {
    /**
     * Data of the pokemon that the user is looking for.
     */
    public PokemonData Data = new PokemonData();
    /**
     * Name of the local SQLite database
     */
    public String DatabaseName;

    /**
     * Constructor of LocalRequest
     *
     * @param name name of the local SQLite database
     */
    public LocalRequest(String name) {
        this.DatabaseName = name;
    }

    /**
     * Setter for the name of the database
     *
     * @param name Name that we want to set
     */
    public void setName(String name) {
        this.DatabaseName = name;
    }

    /**
     * Correct the name of the database if the one given by the user does not exist.
     */
    public void CorrectDatabaseName() {
        File file = new File("ressources/" + this.DatabaseName);
        if (!file.isFile()) {
            System.out.println("The database "+this.DatabaseName+" does not exist.");
            System.out.println("Database name is setting to the default one: pokemondatabase.sqlite");
            setName("pokemondatabase.sqlite");
        }
    }

    /**
     * Establish an SQL connection
     *
     * @return a {@link Connection} object.
     */
    public Connection SQLConnection(){
        /* Connect to the database */
        Connection conn = null;
        CorrectDatabaseName();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection("jdbc:sqlite:ressources/" + this.DatabaseName);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return conn;
    }

    /**
     * Give the data in parameter to the PokemonData object
     *
     * @param rs Result of the SQLite request
     */
    public void SetPokemonData(ResultSet rs) {
        try {
            Data.setId(rs.getInt("id"));
            Data.setName(rs.getString("name"));
            Data.setWeight((int) rs.getInt("weight"));
            Data.setHeight((int) rs.getInt("height"));
            Data.setDescription(rs.getString("description"));
        } catch (SQLException e) {
            System.out.println("No data found for the given arguments.");
            System.exit(0);
        }
    }

    /**
     * @param id ID of the pokemon that the user is looking for
     * @return a {@link PokemonData} object
     */
    @Override
    public PokemonData Get(int id) {
        try {
            // create a connection to the database
            Connection conn = SQLConnection();
            //send the request et get the result
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            //Save data of rs into the PokemonData object:
            SetPokemonData(rs);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return Data;
    }
}
