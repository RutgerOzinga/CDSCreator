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

    BufferedReader reader;
    private String line;

    public FileReader(Path filePath) throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        reader = Files.newBufferedReader(filePath, charset);
    }

    public Boolean nextLine() throws IOException {
        if ((line = reader.readLine()) != null) {
            return true;
        } else {
            reader.close();
            return false;

        }

    }

    public String getLine() {
        return line;
    }
}
