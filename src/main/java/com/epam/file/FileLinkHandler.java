package com.epam.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by damian on 21.03.16.
 */
public class FileLinkHandler {
    private final String fileName = "FreeBooksAdressSite.txt";
    private List<Link> linkList = new ArrayList<Link>();
    private List<String> urlList = new ArrayList<String>();
    private final URL freeBooksAdressSiteUrl = createUrlToFile();

    public FileLinkHandler() {
        createUrlToFile();
        readLinksFromFile();
    }

    private URL createUrlToFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL freeBooksAdressSiteUrl = classLoader.getResource(fileName);
        return freeBooksAdressSiteUrl;
    }

    public List<Link> readLinksFromFile() {
        try (Scanner scanner = new Scanner(new File(freeBooksAdressSiteUrl.getFile()))) {

            while (scanner.hasNextLine()) {

                String linkS = scanner.nextLine();
                String[] split = linkS.split(" ");

                if (split.length == 3) {
                    Link link = new Link(split[0], split[1], split[1]);
                    linkList.add(link);
                    urlList.add(split[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return linkList;
    }


    public void writeLinksToFile(List<Link> linkList) {
        try (PrintWriter printWriter = new PrintWriter("src/main/resources/" + fileName)) {
            for (int i = 0; i < linkList.size(); i++) {
                printWriter.println(linkList.get(i).toString());
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Link> getLinkList() {
        return linkList;
    }

    public List<String> getUrlList() {
        return urlList;
    }
}
