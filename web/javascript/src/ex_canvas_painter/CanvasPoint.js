class CanvasPoint {
    constructor(_x, _y)
    {
        this.setCoordinate(_x, _y);
    }

    setCoordinate(_x, _y)
    {
        this.setCoordinateX(_x);
        this.setCoordinateY(_y);
    }

    getCoordinate()
    {
        return Array(this.coordinate_x, this.coordinate_y);
    }

    setCoordinateX(_x)
    {
        this.coordinate_x = _x;
    }

    getCoordinateX()
    {
        return this.coordinate_x;
    }

    setCoordinateY(_y)
    {
        this.coordinate_y = _y;
    }

    getCoordinateY()
    {
        return this.coordinate_y;
    }
}