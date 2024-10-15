package com.javarush.games.minigames.mini07;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Работа с мышью
*/

public class PaintGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(5, 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                setCellColor(i, j, Color.WHITE);
            }
        }

    }

    @Override
    public void onMouseLeftClick (int x, int y) {
        // Ставим символ "X" в клетку, по которой кликнули левой кнопкой мыши
        setCellColor(x, y, Color.GREEN);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        // Очищаем клетку, по которой кликнули правой кнопкой мыши
        setCellColor(x, y, Color.ORANGE);
    }
}
