/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 *
 * @author lukas
 */
public class FXMLDocumentController implements Initializable {
    
    private double boardH;
    private double boardW;
    private int numCols = 8;
    private int numRows = 8;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private Scene scene;
    
    @FXML private AnchorPane anchorPane;
    @FXML private Menu gridMenu;
    @FXML private Menu colorMenu;
    @FXML private MenuBar menuBar;
    @FXML private MenuItem defaults;
    @FXML private MenuItem blue;
    @FXML private MenuItem size3;
    @FXML private MenuItem size8;
    @FXML private MenuItem size10;
    @FXML private MenuItem size16;
    @FXML private VBox vBox;
    @FXML private VBox displayArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML private void changeColor(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "defaults":
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
            case "blue":
                lightColor = Color.SKYBLUE;
                darkColor = Color.DARKBLUE;
                break;
            default:
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
        }
        
        setBoard();
    }
    
    @FXML private void changeSize(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "size3":
                numRows = 3;
                numCols = 3;
                break;
            case "size8":
                numRows = 8;
                numCols = 8;
                break;
            case "size10":
                numRows = 10;
                numCols = 10;
                break;
            case "size16":
                numRows = 16;
                numCols = 16;
                break;
            default:
                numRows = 8;
                numCols = 8;
                break;
        }
        
        setBoard();
    }
    
    public void ready(Scene scene) {
        this.scene = scene;
        
        ChangeListener<Number> sizeChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            setBoard(); 
        };
        
        scene.widthProperty().addListener(sizeChangeListener);
        scene.heightProperty().addListener(sizeChangeListener);
        
        setBoard();
    }
    
    public void setBoard() {
        boardH = vBox.getHeight() - menuBar.getHeight();
        boardW = vBox.getWidth();
        
        CheckerBoard checkerboard = new CheckerBoard(numRows, numCols, boardW, boardH, lightColor, darkColor);
        AnchorPane board = checkerboard.build();
        
        anchorPane.getChildren().clear();
        
        double verticalPadding = (boardH - (checkerboard.getSquareHeight() * checkerboard.getNumRows())) / 2;
        double horizontalPadding = (boardW - (checkerboard.getSquareWidth() * checkerboard.getNumCols())) / 2;
        
        Insets insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        displayArea.setPadding(insets);
        
        anchorPane.getChildren().addAll(board); 
    } 
    
}
