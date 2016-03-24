package com.epam.filelinkreader;

import com.epam.file.Link;
import com.epam.file.ResourceFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 21.03.16.
 */
public class FileLinkReader {
    private final ResourceFile resourceFile;
    private List<Link> linkList = new ArrayList<Link>();

    public FileLinkReader() {
        resourceFile = new ResourceFile("FreeBooksAdressSite.txt");
    }


    public List<Link> createLinks() {
        List<String> linesWithLinks = ReadHandeler.readFromFile(resourceFile);

        for (int i = 0; i < linesWithLinks.size(); i++) {
            String line = linesWithLinks.get(i);
            String[] parameters = line.split(" ");
            if (parameters.length == 3) {
                Link link = new Link(parameters);
                linkList.add(link);
            }
        }

        return linkList;
    }

    @Override
    public String toString() {
        return "FileLinkReader{" +
                "resourceFile=" + resourceFile +
                ", linkList=" + linkList +
                '}';
    }
}
