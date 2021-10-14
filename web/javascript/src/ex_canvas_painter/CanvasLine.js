class CanvasLine {
    constructor(_firstPoint, _secondPoint, _color, _thickness)
    {
        this.setFirstPoint(_firstPoint);
        this.setSecondPoint(_secondPoint);
        this.setColor(_color);
        this.setThickness(_thickness);
    }

    getFirstPoint()
    {
        return this.firstPoint;
    }

    setFirstPoint(_point)
    {
        this.firstPoint = _point;
    }

    getSecondPoint()
    {
        return this.secondPoint;
    }

    setSecondPoint(_point)
    {
        this.secondPoint = _point;
    }

    getSize()
    {
        return Math.hypot(
            this.secondPoint.getCoordinateX() - this.firstPoint.getCoordinateX(),
            this.secondPoint.getCoordinateY() - this.firstPoint.getCoordinateY()
        );
    }

    getColor()
    {
        return this.color;
    }

    setColor(_color)
    {
        this.color = _color;
    }

    getThickness()
    {
        return this.thickness;
    }

    setThickness(_thickness)
    {
        this.thickness = _thickness;
    }
}