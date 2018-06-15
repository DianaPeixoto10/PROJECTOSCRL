package org.academiadecodigo.bootcamp.Grid;

import com.sun.corba.se.impl.io.InputStreamHook;

import java.io.*;
import java.util.Map;

/**
 * Created by codecadet on 11/06/2018.
 */

public class FileManager {

    private static final String file = "resources/Paint.txt";

    public static String read() {

        String result = "";
        BufferedReader bufferedReader = null;

        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                result = result + line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void write() {

        BufferedWriter bufferedWriter = null;
        String string = null;
        try {

            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(string);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

