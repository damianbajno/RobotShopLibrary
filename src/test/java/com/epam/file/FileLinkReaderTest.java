package com.epam.file;

import com.epam.filelinkreader.FileLinkReader;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 21.03.16.
 */
public class FileLinkReaderTest {
    private String url="http://demotywatory.pl/";

    @Test
    public void testIfMethodReadsFromFileUrls() {
        //given
        FileLinkReader fileLinkReader =new FileLinkReader();

        //when
        final List<Link> links = fileLinkReader.createLinks();

        //then
//        Assertions.assertThat(links).contains(new Link("demotywatory.pl", null, null));

    }

    @Test
    public void testIfMethodWritesToFile() {
        //given
        FileLinkReader fileLinkReader =new FileLinkReader();

        //when
        List<Link> linkList= new ArrayList<Link>();
        linkList.add(new Link(url,null, null));
        linkList.add(new Link("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#inbox", null, null));

        //then

    }


}
