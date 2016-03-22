package com.epam.gui;

import com.epam.util.UrlUtils;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

/**
 * Created by damian on 21.03.16.
 */
public class TextCellList extends TextFieldListCell {
    final String MESAGE_IF_GIVEN_URL_IS_NOT_URL = "It isn't URL";

    public TextCellList() {
        setConverter(new CellStringConverter());
    }

    @Override
    public void commitEdit(Object newValue) {
        final String url = newValue.toString();


            if (!UrlUtils.checkIfUrl(url)) {
                setItem(MESAGE_IF_GIVEN_URL_IS_NOT_URL);
                setText(MESAGE_IF_GIVEN_URL_IS_NOT_URL);
                super.commitEdit(MESAGE_IF_GIVEN_URL_IS_NOT_URL);
            }

        final String httpUrl = UrlUtils.addHttpToBegining(url);
        super.commitEdit(httpUrl);
    }

    public class CellStringConverter extends StringConverter {

        @Override
        public String toString(Object object) {
            String httpUrl = object.toString();
            return httpUrl;
        }

        @Override
        public Object fromString(String string) {
            return (Object) string;
        }
    }
}
