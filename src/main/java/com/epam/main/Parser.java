package com.epam.main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by stycz0007 on 21.03.16.
 */
public class Parser {
    private String choice;
    private Document doc;
    public Parser(String choice){
        this.choice=choice;
    }

   public void printResult(Elements elements){
       for (Element e : elements ){
           System.out.print(e.text() + "\n \n");
       }

   }

   public void checkUserChoice(){
       System.out.println("You are looking for free books in: " + choice);

       if (choice.equals("publio.pl")){
           try {
               doc = Jsoup.connect("http://www.publio.pl/szukaj,darmowe.html").get();
               Elements titles = doc.getElementsByClass("product-tile-title");
               Elements insideTitleBooks = titles.select("a");
               printResult(insideTitleBooks);
           }
           catch (IOException e){
               e.printStackTrace();
               System.out.println("Problem with connection");
           }

       }
       else if (choice.equals("nexto.pl")){
           try {
               doc = Jsoup.connect("http://www.nexto.pl/ebooki/darmowe_c1219.xml?_offset=40").get();
               Elements titles = doc.getElementsByClass("title");
               printResult(titles);

           }
           catch (IOException e){
               e.printStackTrace();
               System.out.println("Problem with connection");
           }

       }
       else if (choice.equals("audiobooki.biz.pl")){
           try {
               doc = Jsoup.connect("http://audiobooki.biz.pl/ebooki/darmowe_c1219.xml").get();
               Elements titles = doc.getElementsByClass("title");
               printResult(titles);

           }
           catch (IOException e){
               e.printStackTrace();
               System.out.println("Problem with connection");
           }

       }
       else
           System.out.println("Choosen library does not exist");

   }
}
