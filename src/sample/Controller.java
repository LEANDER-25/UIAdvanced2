package sample;

import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button menu;

    @FXML
    BorderPane paneHolder;

    @FXML
    JFXDrawer drawer;

    private boolean isOpen = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            this.paneHolder.setCenter(FXMLLoader.load(getClass().getResource("Home.fxml")));
            VBox side = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            drawer.setSidePane(side);
            for (Node node : side.getChildren()){
                if(node.getAccessibleText() != null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
                        try{
                            switch (node.getAccessibleText()){
                                case "home":
                                    Node home = FXMLLoader.load(getClass().getResource("Home.fxml"));
                                    this.paneHolder.setCenter(home);
                                    break;
                                case "record":
                                    Node record = FXMLLoader.load(getClass().getResource("Record.fxml"));
                                    this.paneHolder.getChildren().removeAll();
                                    this.paneHolder.setCenter(record);
                                    break;
                                case "borrow":
                                    Node borrow = FXMLLoader.load(getClass().getResource("Borrow.fxml"));
                                    this.paneHolder.getChildren().removeAll();
                                    this.paneHolder.setCenter(borrow);
                                    break;
                            }
                        }catch (Exception ez){
                            ez.printStackTrace();
                        }
                    });
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openMenu(){
        if(isOpen == false){
            drawer.open();
            isOpen = true;
        }
        else{
            drawer.close();
            isOpen = false;
        }

    }
}
