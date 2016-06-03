/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeframetranslationcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Rutger
 */
public class FileReader {
    /**
     * a reader object
     */
    BufferedReader reader;
    /**
     * new variable String
     */
    private String line;
    
    /**
     * creates the reader by giving a path.
     */
    public FileReader(Path filePath) throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        reader = Files.newBufferedReader(filePath, charset);
    }
    /**
     * Checks if there is a next line in the file and returns a boolean based on
     * if there is a line or not.
     * @return a boolean that is true of false based on if there is a next line or not.
     * @throws IOException an exception
     */
    public Boolean nextLine() throws IOException {
        if ((line = reader.readLine()) != null) {
            return true;
        } else {
            reader.close();
            return false;

        }

    }
    /**
     * gets the value of the next line.
     * @return a string with the info of the current line of the file.
     */
    public String getLine() {
        return line;
    }
}
