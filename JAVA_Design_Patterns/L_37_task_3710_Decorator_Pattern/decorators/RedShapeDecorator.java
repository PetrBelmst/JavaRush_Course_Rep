package com.company.decorators;

import com.company.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape shape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.shape = decoratedShape;
    }

    private void setBorderColor (Shape shapeDecorator) {
        System.out.println(String.format("Setting the border color for %s to red.", shapeDecorator.getClass().getSimpleName()));

    }

    @Override
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}