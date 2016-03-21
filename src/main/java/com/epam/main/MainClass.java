package com.epam.main;


import com.epam.robot.Robot;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by stycz0007 on 18.03.16.
 */
public class MainClass {
    static Logger log = Logger.getLogger(MainClass.class.getName());
    static Robot robot = new Robot();
    static FileHandler fileHandler;


    public static void main(String[] args) {
        robot.start();
        try {
            fileHandler = new FileHandler("/home/stycz0007/Documents/RobotShopLibrary/logging.log");
            log.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            log.info("Robot and main started");
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

       Parser parser = new Parser("audiobooki.biz.pl");
       parser.checkUserChoice();
    }

}
