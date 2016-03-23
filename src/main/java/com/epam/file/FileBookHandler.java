package com.epam.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by damian on 23.03.16.
 */
public class FileBookHandler {

    private String fileName;
    private File freeBooksTitlesUrl;
    private StringBuilder bookTitles;

    public FileBookHandler(String fileName) {
        this.fileName = fileName;
        this.bookTitles = new StringBuilder();

        freeBooksTitlesUrl = loadFile(fileName);
        readBookTitlesFromFile();
    }

    private File loadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println("File name in class "+fileName);
        File file = classLoader.getResource(fileName).getFile();
        return file;
    }

    public String readBookTitlesFromFile() {
        try (Scanner scanner = new Scanner(new File(freeBooksTitlesUrl.getFile()))) {

            while (scanner.hasNextLine()) {
                bookTitles.append(scanner.nextLine() + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bookTitles.toString();
    }

    private void writeBookTitlesToFile() {
        try (PrintWriter printWriter = new PrintWriter("src/main/resources/" + fileName)) {
            printWriter.println("a");
            printWriter.flush();
        } catch (FileNotFoundException e)

        {
            e.printStackTrace();
        }
    }
}