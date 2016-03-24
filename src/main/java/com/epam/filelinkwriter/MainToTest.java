package com.epam.filelinkwriter;

import com.epam.file.Link;
import com.epam.file.ResourceFile;

import java.util.List;

/**
 * Created by damian on 24.03.16.
 */
public class MainToTest {

    public static void main(String[] args) {
        ResourceFile resourceFile = new ResourceFile("logging.log");
        FileLinkReader fileLinkReader = new FileLinkReader();
        List<Link> links = fileLinkReader.createLinks();

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).toString());
        }
    }
}
