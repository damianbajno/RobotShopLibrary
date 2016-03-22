package com.epam.file;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by damian on 22.03.16.
 */
public class LinkTest {

    @Test
    public void ifPutUrlItRemoveSlashes(){
        Link link=new Link("dsa///dsadsad/adss");

        String fileNameWithOutSlashes = link.createFileName();

        Assertions.assertThat(fileNameWithOutSlashes).isEqualTo("dsadsadsadadss");
    }
}
