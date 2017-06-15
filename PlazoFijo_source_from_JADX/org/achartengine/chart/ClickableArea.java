package org.achartengine.chart;

import android.graphics.RectF;

public class ClickableArea {
    private RectF rect;
    private double f1x;
    private double f2y;

    public ClickableArea(RectF rect, double x, double y) {
        this.rect = rect;
        this.f1x = x;
        this.f2y = y;
    }

    public RectF getRect() {
        return this.rect;
    }

    public double getX() {
        return this.f1x;
    }

    public double getY() {
        return this.f2y;
    }
}
