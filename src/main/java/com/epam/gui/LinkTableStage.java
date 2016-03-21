package com.epam.gui;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Created by damian on 21.03.16.
 */
public class LinkTableStage {
    private Stage stage;
    private  ObservableList<String> observableLinkList;

    public LinkTableStage(ObservableList<String> observableLinkList) {
        this.observableLinkList=observableLinkList;

        TableView linkTableView=new TableView();
        linkTableView.setEditable(true);

        TableColumn linkColumn = new TableColumn("Links");
        linkColumn.setMinWidth(500D);
        linkColumn.setEditable(true);
//        linkColumn.setCellValueFactory(new PropertyValueFactory<String);


        linkTableView.getColumns().add(linkColumn);
        linkTableView.setItems(observableLinkList);

        Scene scene=new Scene(linkTableView, 500D, 500D);

        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
