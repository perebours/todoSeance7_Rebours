package com.example.pokedex.services;



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
     * url of the local SQLite database
     */
    public String url;

    /**
     * Constructor of LocalRequest
     *
     * @param url url of the local SQLite database
     */
    public LocalRequest(String url) {
        this.url = url;
    }

    /**
     * Setter for the url
     *
     * @param url url that we want to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Establish an SQL connection
     *
     * @return a {@link Connection} object
     * @throws SQLException If there is an SQL error in the catch part of the code.
     */
    public Connection SQLConnection() throws SQLException {
        /* Connect to the database */
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(this.url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            setUrl("jdbc:sqlite:ressources/pokemondatabase.sqlite");
            System.out.println("Connection to " + this.url);
            // create a connection to the database
            conn = DriverManager.getConnection(this.url);
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
