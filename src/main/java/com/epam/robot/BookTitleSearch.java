package com.epam.robot;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by damian on 22.03.16.
 */
public class BookTitleSearch {
    private static Logger logger = Logger.getLogger("BookTitleSearch");
    private static StringBuilder titleBookContainer = new StringBuilder();


    public static void main(String[] args) {


//        System.out.println("http://www.bookrix.com/books.html");
//        BookTitleSearch.searchTitleByClass("http://www.bookrix.com/books.html","item-title");
//
//        System.out.println("https://www.gutenberg.org/ebooks/search/?query=free+book&go=Go");
//        BookTitleSearch.searchTitleByClass("https://www.gutenberg.org/ebooks/search/?query=free+book&go=Go","title");


        System.out.println("http://e-bookshop.pl.txt/362-wyprzedaz");
        BookTitleSearch.searchTitleByTag("http://e-bookshop.pl/362-wyprzedaz?&p=7", "h3");

//        BookTitleSearch.searchSubPagesInPageByNumber("http://e-bookshop.pl/362-wyprzedaz");
    }


    public static String searchTitlesInPageAndSubPagesByTag(String adress, String typeToSearch) {
        logger.info("Started searching Titles");
        resetVariables();
        searchSubPagesInPageByNumber(adress);

        final Iterator<String> iterator = addressHashSet.iterator();

        logger.info("Started iterating over links to search title");
        logger.error("a" + typeToSearch + "a");
        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.println(next);
            BookTitleSearch.searchTitleByTag(next, typeToSearch);
        }

        logger.info("Finished iterating over links to search titles");

        return titleBookContainer.toString();
    }

    public static String searchTitlesInPageAndSubPageByClass(String adress, String typeToSearch) {
        resetVariables();
        addressHashSet.add(adress);
        searchSubPagesInPageByNumber(adress);

        final Iterator<String> iterator = addressHashSet.iterator();


        while (iterator.hasNext()) {
            BookTitleSearch.searchTitleByClass(iterator.next(), typeToSearch);
        }

        return titleBookContainer.toString();
    }

    private static void resetVariables() {
        titleBookContainer = new StringBuilder();
        addressHashSet = new HashSet<>();
    }

    public static void searchTitleByClass(String adress, String classNameToSearch) {
        Document document = createDocument(adress);
        Element body = document.body();

        Elements elementsByClass = body.getElementsByClass(classNameToSearch);
        Iterator<Element> iterator = elementsByClass.iterator();

        while (iterator.hasNext()) {
            titleBookContainer.append(iterator.next().text()+"\n");
        }
    }


    public static void searchTitleByTag(String adress, String tagNameToSearch) {
        Document document = createDocument(adress);

        Elements elementsByTag = document.getElementsByTag(tagNameToSearch);
        Iterator<Element> iterator = elementsByTag.iterator();

        while (iterator.hasNext()) {
            Element next = iterator.next();
            System.out.println(next.text());
            titleBookContainer.append(next.text()+"\n");
        }
    }

    static private HashSet<String> addressHashSet = new HashSet<String>();

    public static void searchSubPagesInPageByNumber(String adress) {
        Document doc = createDocument(adress);

        Elements links = doc.select("a[abs:href]");
        Iterator<Element> iterator = links.iterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (isNumberInTagAndIsLinkWasSearch(element)) {
                addLinkToSetAndSearchInLinkForPages(element.attr("abs:href"));
            }
            ;
        }
    }

    private static boolean isNumberInTagAndIsLinkWasSearch(Element element) {
        return NumberUtils.isNumber(element.text().trim()) && !addressHashSet.contains(element.attr("abs:href"));
    }

    private static void addLinkToSetAndSearchInLinkForPages(String linkToSubPage) {
        System.out.println(linkToSubPage);
        addressHashSet.add(linkToSubPage);
        searchSubPagesInPageByNumber(linkToSubPage);
    }


    private static Document createDocument(String adress) {
        Document document = null;
        try {
            return document = Jsoup.parse(new URL(adress), 100000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

}
