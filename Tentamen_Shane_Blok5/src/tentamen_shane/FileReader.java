/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen_shane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


/**
 *
 * @author shane
 */
public class FileReader extends FileChooser {
    
    
        private static BufferedReader inFile;

    /**
     *this is the whole placeholder
     */
    public String header;

    /**
     *this is a placeholder so the header can be split into parts.
     */
    public String[] ph1;

    /**
     *
     * @param file
     * @return
     */
    public String FileReader(String file) {
        try{
            String line;
            inFile = new BufferedReader(new java.io.FileReader(file));
            String fileContents = "";
            file = fileContents;
            while ((line = inFile.readLine()) != null) {
                if (line.contains(">")) {
                    System.out.println("regel met > overgeslagen!");
                    header += line;
                    
                    ph1 = header.split(" ", 2);
                    header = ph1[1];
                    System.out.println(header);
                }
                else {
                file += line;
                }
            }
            
            inFile.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Something went wrong with reading a sentence!");
        }
        return file;
    }

    /**
     *
     * @return
     */
    public String getHeader() {
        return header;
    }
}
