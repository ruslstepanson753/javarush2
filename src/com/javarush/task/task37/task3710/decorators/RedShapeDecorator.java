package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

import java.awt.*;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape decoratedShape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    private void setBorderColor(Shape color) {
        String cl = color.getClass().getSimpleName();
        System.out.println("Setting the border color for "+cl+" to red.");
    }
    @Override
    public void draw() {
        Object setBorderColor;
        setBorderColor(decoratedShape);
        decoratedShape.draw();
    }
}
