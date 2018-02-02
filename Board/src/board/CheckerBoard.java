/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author lukas
 */
public class CheckerBoard {
    private double boardHeight;
    private double boardWidth;
    private double squareHeight;
    private double squareWidth;
    private int numCols;
    private int numRows;
  
    private AnchorPane board = null;
    private Color lightColor;
    private Color darkColor;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        if (boardWidth < boardHeight) {
            squareWidth = boardWidth / numCols;
            squareHeight = boardWidth / numRows;
        }
        else {
            squareWidth = boardHeight / numCols;
            squareHeight = boardHeight / numRows; 
        }
        
        board = new AnchorPane();
                 
        for (int i = 0; i < numRows; i++) {
            for (int x = 0; x < numCols; x++) {
                
                Rectangle square = new Rectangle();
                square.setWidth(squareWidth);
                square.setHeight(squareHeight);
                square.setX(squareWidth * x);
                square.setY(squareHeight * i);
            
                if ((x % 2 == 0 && i % 2 != 0) || (x % 2 != 0 && i % 2 == 0)) {
                    square.setFill(darkColor);
                }
                else {
                    square.setFill(lightColor);
                }
            
                board.getChildren().add(square);
            }
        }            
        return board;
    }
    
    public AnchorPane getBoard() {
        return board;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getSquareWidth() {
        return squareWidth;
    }
    
    public double getSquareHeight() {
        return squareHeight;
    }
}
