package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.graphics.*;


/**
 * Created by codecadet on 08/06/2018.
 */
public class Square extends Cell {

    public Square() {
        super(0,0);
        cell.setColor(Color.MAGENTA);
        cell.fill();
    }

    public void moveRight() {
        cell.translate(cellSize, 0);
        setCol(getCol() + 1);
    }

    public void moveLeft() {
        cell.translate(-cellSize, 0);
        setCol(getCol() - 1);
    }

    public void moveUp() {
        cell.translate(0, -cellSize);
        setRow(getRow() - 1);
    }

    public void moveDown() {
        cell.translate(0, cellSize);
        setRow(getRow() + 1);
    }

    public void setColorToBlue() {
        cell.setColor(Color.BLUE);
        cell.fill();
    }

    public void setColorToRed() {
        cell.setColor(Color.RED);
        cell.fill();
    }

    public void setColorToYellow() {
        cell.setColor(Color.YELLOW);
        cell.fill();
    }

    public void setColorToGreen() {
        cell.setColor(Color.GREEN);
        cell.fill();
    }
}


