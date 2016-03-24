package com.epam.gui;

import com.epam.file.FileBookHandler;
import com.epam.filelinkreader.FileLinkReader;
import com.epam.util.UrlUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by damian on 20.03.16.
 */
public class MainClass extends Application {
    private FileLinkReader fileLinkReader = new FileLinkReader();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Page adress = ");

        final ObservableList<String> observableLinkList = FXCollections.observableArrayList(
//                fileLinkReader.getUrlList()
        );

        final ComboBox<String> linkListComboBox = new ComboBox<String>(observableLinkList);
        linkListComboBox.setPrefWidth(300D);
        linkListComboBox.setVisibleRowCount(7);
        linkListComboBox.setEditable(true);

        final TextArea freeBookTitleTextArea = new TextArea();

        linkListComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String urlName = linkListComboBox.getSelectionModel().getSelectedItem().toString();
                String fileName = UrlUtils.getFileName(urlName);
                FileBookHandler fileBookHandler=new FileBookHandler(fileName);
                freeBookTitleTextArea.appendText(fileBookHandler.readBookTitlesFromFile());
            }
        });

        Button editLinkButton = new Button("Edit Links");
        editLinkButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ListViewStage listViewStage = new ListViewStage(observableLinkList);
            }
        });


        HBox linkToLibraryHBox = new HBox();
        linkToLibraryHBox.getChildren().addAll(label, linkListComboBox, editLinkButton);
        linkToLibraryHBox.setAlignment(Pos.CENTER_LEFT);
        linkToLibraryHBox.setSpacing(10D);


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
