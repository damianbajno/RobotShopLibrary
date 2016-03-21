package com.epam.gui;

import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

/**
 * Created by damian on 21.03.16.
 */
public class TextCellList extends TextFieldListCell {

    public TextCellList() {
        setConverter(new CellStringConverter());
    }

    public class CellStringConverter extends StringConverter {

        @Override
        public String toString(Object object) {
            return object.toString();
        }

        @Override
        public Object fromString(String string) {
            return (Object) string;
        }
    }
}
