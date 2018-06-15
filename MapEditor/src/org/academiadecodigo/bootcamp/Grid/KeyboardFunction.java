package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;
import java.io.Serializable;
import java.security.Key;

/**
 * Created by codecadet on 11/06/2018.
 */
public class KeyboardFunction implements KeyboardHandler {

    private MapEditor mapEditor;

    public KeyboardFunction(MapEditor mapEditor) {
        this.mapEditor = mapEditor;
        initKeyboard();
    }

    public void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent paintTheCells = new KeyboardEvent();
        paintTheCells.setKey(KeyboardEvent.KEY_SPACE);
        paintTheCells.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent dePaintTheCells = new KeyboardEvent();
        dePaintTheCells.setKey(KeyboardEvent.KEY_SPACE);
        dePaintTheCells.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent setColorToBlue = new KeyboardEvent();
        setColorToBlue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToBlue.setKey(KeyboardEvent.KEY_B);

        KeyboardEvent setColorToYellow = new KeyboardEvent();
        setColorToYellow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToYellow.setKey(KeyboardEvent.KEY_Y);

        KeyboardEvent setColorToRed = new KeyboardEvent();
        setColorToRed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToRed.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent setColorToGreen = new KeyboardEvent();
        setColorToGreen.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToGreen.setKey(KeyboardEvent.KEY_G);

        KeyboardEvent save = new KeyboardEvent();
        setColorToGreen.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToGreen.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent load = new KeyboardEvent();
        setColorToGreen.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setColorToGreen.setKey(KeyboardEvent.KEY_L);

        keyboard.addEventListener(dePaintTheCells);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(setColorToRed);
        keyboard.addEventListener(setColorToGreen);
        keyboard.addEventListener(setColorToBlue);
        keyboard.addEventListener(setColorToYellow);
        keyboard.addEventListener(paintTheCells);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                mapEditor.moveSquare(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                mapEditor.moveSquare(Direction.RIGHT);
                break;

            case KeyboardEvent.KEY_UP:
                mapEditor.moveSquare(Direction.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                mapEditor.moveSquare(Direction.DOWN);
                break;

            case KeyboardEvent.KEY_B:
                mapEditor.changeColor(SquareColor.BLUE);
                break;

            case KeyboardEvent.KEY_G:
                mapEditor.changeColor(SquareColor.GREEN);
                break;

            case KeyboardEvent.KEY_Y:
                mapEditor.changeColor(SquareColor.YELLOW);
                break;

            case KeyboardEvent.KEY_R:
                mapEditor.changeColor(SquareColor.RED);
                break;

            case KeyboardEvent.KEY_SPACE:
                mapEditor.paintGridCell();
                break;

            case KeyboardEvent.KEY_S:
                mapEditor.save();
                break;

            case KeyboardEvent.KEY_L:
                mapEditor.load();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
