package com.epam.file;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 21.03.16.
 */
public class FileLinkHandlerTest {
    private String url="http://demotywatory.pl/";

    @Test
    public void testIfMethodReadsFromFileUrls() {
        //given
        FileLinkHandler fileLinkHandler=new FileLinkHandler();

        //when
        final List<Link> links = fileLinkHandler.readLinksFromFile();

        //then
//        Assertions.assertThat(links).contains(new Link("demotywatory.pl", null, null));

    }

    @Test
    public void testIfMethodWritesToFile() {
        //given
        FileLinkHandler fileLinkHandler=new FileLinkHandler();

        //when
        List<Link> linkList= new ArrayList<Link>();
        linkList.add(new Link(url,null, null));
        linkList.add(new Link("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#inbox", null, null));

        //then

    }


}
