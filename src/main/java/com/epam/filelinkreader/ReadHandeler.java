package com.epam.filelinkreader;

import com.epam.file.ResourceFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by damian on 24.03.16.
 */
public class ReadHandeler {

    public static List<String> readFromFile(ResourceFile resourceFile) {
        List<String> lineList=new ArrayList<>();

        try (Scanner scanner=new Scanner(resourceFile.getFile())){

        while (scanner.hasNextLine()){
            lineList.add(scanner.nextLine());
        }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lineList;
    }
}
