package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.bootcamp.Grid.Square;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 08/06/2018.
 */
public class Main {

    public static void main(String[] args) {

        MapEditor mapEditor = new MapEditor();
        new KeyboardFunction(mapEditor);

    }
}
