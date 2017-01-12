/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen_shane;

import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author shane
 */
public class FileChooser {

    /**
     * this is the name of the file.
     */
    public static String filename;

    /**
     * this the path to the filename.
     */
    public static String path;

    /**
     * This Method takes gives a pop up for a selector, 
     * this returns a pathfile for the selected file
     */
    public static void Chooser() {
        try {
            JFileChooser Chooser = new JFileChooser();
            int returnValue = Chooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = Chooser.getSelectedFile();
                filename = selectedFile.getName();
                path = selectedFile.getAbsolutePath();
            } 
        } catch (NullPointerException e){
            System.out.println("No file was selected!");
        }
    }

    /**
     * @return Filepath
     */
    public String getPath() {
        return path;
    }

    /**
     * @return Filename
     */
    public String getFileName() {
        return filename;
    }
}
