package kz.epam.text.service;

import java.io.*;


public class ReaderAndWriter {
    public static String read(String file) {
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                text.append((char) i);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not a found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Couldn't read a file");
            e.printStackTrace();
        }
        return text.toString();
    }

     public static void write(String str, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 0; i < str.length(); i++) {
                fileWriter.append(str.charAt(i));
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't write a file");
            e.printStackTrace();
        }
    }
}
