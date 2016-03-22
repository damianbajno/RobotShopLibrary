package com.epam.robot;

import org.apache.commons.lang3.math.NumberUtils;
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

    public static void main(String[] args) {


//        System.out.println("http://www.bookrix.com/books.html");
//        BookTitleSearch.searchTitleByClass("http://www.bookrix.com/books.html","item-title");
//
//        System.out.println("https://www.gutenberg.org/ebooks/search/?query=free+book&go=Go");
//        BookTitleSearch.searchTitleByClass("https://www.gutenberg.org/ebooks/search/?query=free+book&go=Go","title");


//        System.out.println("http://e-bookshop.pl/362-wyprzedaz");
//        BookTitleSearch.searchTitleByTag("http://e-bookshop.pl/362-wyprzedaz","h3");

        BookTitleSearch.searchSubPagesInPageByNumber("http://e-bookshop.pl/362-wyprzedaz");
        searchInPagesBookTitles();
    }

    public static void searchInPagesBookTitles(){
        final Iterator<String> iterator = addressHashSet.iterator();

        while (iterator.hasNext()){
            BookTitleSearch.searchTitleByTag(iterator.next(), "h3");
        }
    }

    public static void searchTitleByClass(String adress, String classNameToSearch) {
        Document document = createDocument(adress);
        Element body = document.body();

        Elements elementsByClass = body.getElementsByClass(classNameToSearch);
        Iterator<Element> iterator = elementsByClass.iterator();

        while (iterator.hasNext()) {
            System.out.println("Tytuł = " + iterator.next().text());
        }
    }


    public static void searchTitleByTag(String adress, String tagNameToSearch) {
        Document document = createDocument(adress);

        Elements elementsByTag = document.getElementsByTag(tagNameToSearch);
        Iterator<Element> iterator = elementsByTag.iterator();

        while (iterator.hasNext()) {
            System.out.println("Tytuł = " + iterator.next().text());
        }
    }

    static private HashSet<String> addressHashSet = new HashSet<String>();

    public static void searchSubPagesInPageByNumber(String adress) {
        Document doc = createDocument(adress);
        Elements links = doc.select("a[abs:href]");
        Iterator<Element> iterator = links.iterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (isNumberInTagAndisLinkWasSearch(element)) {
                addLinkToSetAndSearchInLinkForPages(element.attr("abs:href"));
            };
        }
    }

    private static boolean isNumberInTagAndisLinkWasSearch(Element element) {
        return NumberUtils.isNumber(element.text()) && !addressHashSet.contains(element.attr("abs:href"));
    }

    private static void addLinkToSetAndSearchInLinkForPages(String linkToSubPage) {
        System.out.println(linkToSubPage);
        addressHashSet.add(linkToSubPage);
        searchSubPagesInPageByNumber(linkToSubPage);
    }


    private static Document createDocument(String adress) {
        Document document=null;
        try {
            return document=Jsoup.parse(new URL(adress), 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

}
