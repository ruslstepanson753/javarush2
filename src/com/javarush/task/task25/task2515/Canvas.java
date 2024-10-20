package com.javarush.task.task25.task2515;

public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public void clear(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                matrix[y][x] = ' ';
            }
        }
    }

    public void print(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
        for (int x = 0; x < width; x++){
            System.out.print(" ");
        }
        System.out.println();
        for (int x = 0; x < width; x++){
            System.out.print(" ");
        }
        System.out.println();
    }

    public void setPoint(double x, double y, char c) {
        int xRounded = (int) Math.round(x);
        int yRounded = (int) Math.round(y);
        if (xRounded >= 0 && xRounded < matrix[0].length && yRounded >= 0 && yRounded < matrix.length) {
            matrix[yRounded][xRounded] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}