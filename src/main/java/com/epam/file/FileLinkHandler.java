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
    private List<Link> linkList =new ArrayList<Link>();
    private final URL freeBooksAdressSiteUrl = createUrlToFile();

    public FileLinkHandler() {
    }

    private URL createUrlToFile()  {
            ClassLoader classLoader = getClass().getClassLoader();
            URL freeBooksAdressSiteUrl = classLoader.getResource(fileName);
        return freeBooksAdressSiteUrl;
    }

    public List<Link> readLinksFromFile()  {
        try (Scanner scanner = new Scanner(new File(freeBooksAdressSiteUrl.getFile()))) {
            while (scanner.hasNextLine()) {
                String linka = scanner.nextLine();
                linkList.add(new Link(linka));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return linkList;
    }


    public void writeLinksToFile(List<Link> linkList) {
        try (PrintWriter printWriter=new PrintWriter("src/main/resources/"+fileName)) {
            for (int i = 0; i < linkList.size(); i++) {
                printWriter.println(linkList.get(i).getLinkAdress());
            }
            printWriter.flush();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public List<Link> getLinkList(){
        return linkList;
    }



}
