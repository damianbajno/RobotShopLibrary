package com.epam.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by damian on 20.03.16.
 */
public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Page adress = ");

        final ObservableList<String> observableLinkList= FXCollections.observableArrayList(
                "Option a",
                "Option bdfd gasdggggg",
                "Option c"
        );
        final ComboBox<String> linkListComboBox = new ComboBox<String>(observableLinkList);
        linkListComboBox.setPrefWidth(300D);
        linkListComboBox.setVisibleRowCount(7);
        linkListComboBox.setEditable(true);


        Button editLinkButton = new Button("Edit Links");
        editLinkButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                LinkTableStage linkTableStage=new LinkTableStage(observableLinkList);
            }
        });



        HBox linkToLibraryHBox = new HBox();
        linkToLibraryHBox.getChildren().addAll(label, linkListComboBox, editLinkButton);
        linkToLibraryHBox.setAlignment(Pos.CENTER_LEFT);
        linkToLibraryHBox.setSpacing(10D);

        TextArea freeBookTitleTextArea = new TextArea();

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(linkToLibraryHBox);
        borderPane.setCenter(freeBookTitleTextArea);


        Scene scene = new Scene(borderPane, 600D, 600D);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Free Book search");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
