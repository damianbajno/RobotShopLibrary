package com.epam.robot;

import com.epam.file.FileBookHandler;
import com.epam.file.FileLinkHandler;
import com.epam.file.Link;
import com.epam.util.UrlUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by damian on 23.03.16.
 */
public class MainRobot {
    private static Logger logger = Logger.getLogger("MainRobot");

    public static void main(String[] args) {
        FileLinkHandler fileLinkHandler = new FileLinkHandler();
        List<Link> linksList = fileLinkHandler.getLinksList();
        BookTitleSearch bookTitleSearch = new BookTitleSearch();

        logger.info("Started Main Robot");

        for (int i = 0; i < linksList.size(); i++) {
            logger.info("Iterating over links by file");

            final Link link = linksList.get(i);

            if (link.getTypeForSearch().equals("tag")) {
                logger.info("Started Searching titles by Tag");
                String bookTitles = BookTitleSearch.searchTitlesInPageAndSubPagesByTag(link.getLinkAdress(), link.getNameForSearch());
                final String fileName = UrlUtils.getFileName(link.getLinkAdress());

                new FileBookHandler(fileName).writeBookTitlesToFile(bookTitles);
                logger.info("Finished Searching titles by Tag");
            }
            if (link.getTypeForSearch().equals("class")) {

                logger.info("Started Searching titles by Class");
                String bookTitles = BookTitleSearch.searchTitlesInPageAndSubPageByClass(link.getLinkAdress(), link.getNameForSearch());
                final String fileName = UrlUtils.getFileName(link.getLinkAdress());
                new FileBookHandler(fileName).writeBookTitlesToFile(bookTitles);
                logger.info("Finished Searching titles by Tag");
            }
        }
    }

}
