package com.epam.util;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by damian on 21.03.16.
 */
public class UrlUtilsTest {

    @Test
    public void testIfUrlIsUrl(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        boolean url = urlUtils.checkIfUrl("demotywatory.pl");

        //then
        Assertions.assertThat(url).isTrue();
    }

    @Test
    public void testIfUrlIsEmpty(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        boolean url = urlUtils.checkIfUrl(null);

        //then
        Assertions.assertThat(url).isFalse();
    }

    @Test
    public void testIfTextIsNotUrl(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        boolean url = urlUtils.checkIfUrl("de231motywatory.pl");

        //then
        Assertions.assertThat(url).isFalse();
    }


    @Test
    public void testIfEmptyStringIsNotUrl(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        boolean url = urlUtils.checkIfUrl("");

        //then
        Assertions.assertThat(url).isFalse();
    }

    @Test
    public void testIfUrlWithOutHttpHasHttp(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        java.lang.String url = urlUtils.addHttpToBegining("www.facebook.com/");

        //then
        Assertions.assertThat(url).asString().contains("https://", "https://");
        Assertions.assertThat(url).asString().contains("https://", "https://");
    }

    @Test
    public void testIfUrlHttpHasHttp(){
        //given
        UrlUtils urlUtils =new UrlUtils();

        //when
        java.lang.String url = urlUtils.addHttpToBegining("https://www.facebook.com/");

        //then
        Assertions.assertThat(url).asString().contains("https://", "https://");
        Assertions.assertThat(url).asString().contains("https://", "https://");
    }
}
