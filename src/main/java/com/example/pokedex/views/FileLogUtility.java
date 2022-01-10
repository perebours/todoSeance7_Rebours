package com.example.pokedex.views;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogUtility {
    /**
     * Create a html file about a pokemon.
     *
     * @param filePath      Path of the html file
     * @param htmlGenerator Generator of the content of a html file$
     */
    public static void logHtmlToFile(String filePath, HtmlPokemon htmlGenerator) {
        try {
            Files.createFile(Path.of(System.getProperty("user.dir") + "/output.html"));
        } catch (IOException e) {
        }
        try {
            Files.write(Paths.get(filePath), htmlGenerator.generateHtml().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
