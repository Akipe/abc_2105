class CanvasPainter {
    constructor(canvasElement)
    {
        this.canvasElement = canvasElement;
        this.canvasContext = this.canvasElement.getContext('2d');
        this.linesTraced = Array();
        this.buttons = {
            drawLine: null,
            selectLine: null,
            lineColor: null,
            lineSize: null,
            removeLastLine: null
        };
        this.numberUserClick = 0;
        this.mousePositionFirstClick;
        this.mousePositionSecondClick;

        this.setWriteThickness(1);
        this.setWriteColor("#ff0000");

        this.prepareDrawLineAction();
        this.prepareSelectLineAction();
    }

    setButtonDrawLine(_cssElementSelector)
    {
        this.buttons.drawLine = document.querySelector(_cssElementSelector);
        this.buttons.drawLine.addEventListener("click", this.activateDrawLine.bind(this));
    }

    setButtonSelectLine(_cssElementSelector)
    {
        this.buttons.selectLine = document.querySelector(_cssElementSelector);
        this.buttons.selectLine.addEventListener("click", this.activateSelectLine.bind(this));
    }

    activateSelectLine() {
        this.deactivateDrawLine();
        this.canvasElement.addEventListener("click", this.selectLineAction);
    }

    deactivateSelectLine() {
        this.canvasElement.removeEventListener("click", this.selectLineAction);
    }

    prepareSelectLineAction() {
        this.selectLineAction = (event) => {
            // ...
        };
    }

    activateDrawLine() {
        this.deactivateSelectLine();
        this.canvasElement.addEventListener("click", this.drawLineAction);
    }

    deactivateDrawLine()
    {
        this.canvasElement.removeEventListener("click", this.drawLineAction);
    }

    prepareDrawLineAction() {
        this.drawLineAction = (event) => {
            let clickMousePosition;

            clickMousePosition = this.getMousePosition(event);

            this.canvasElement.addEventListener("mousemove", (event) => {
                if (this.numberUserClick % 2 == 1) {
                    let realTimeMousePosition;

                    realTimeMousePosition = this.getMousePosition(event);
                    this.clearAndDrawLinesTraced();
                    this.drawLine(
                        clickMousePosition,
                        realTimeMousePosition,
                        this.getWriteColor(),
                        this.getWriteThickness()
                    );
            
                    this.mousePositionFirstClick = clickMousePosition;
                }
            });
            
            if (this.numberUserClick % 2 == 1) {
                this.mousePositionSecondClick = clickMousePosition;
                this.addLine(
                    this.mousePositionFirstClick,
                    this.mousePositionSecondClick,
                    this.getWriteColor(),
                    this.getWriteThickness()
                );
                this.clearAndDrawLinesTraced();
            }
            this.numberUserClick++;
        };
    }

    setButtonLineColor(_cssElementSelector)
    {
        this.buttons.lineColor = document.querySelector(_cssElementSelector);
        this.buttons.lineColor.value = this.getWriteColor();

        this.buttons.lineColor.addEventListener("change", () => {
            this.setWriteColor(this.buttons.lineColor.value);
        });
    }

    setButtonLineSize(_cssElementSelector)
    {
        this.buttons.lineSize = document.querySelector(_cssElementSelector);
        this.buttons.lineSize.value = this.getWriteThickness();

        this.buttons.lineSize.addEventListener("change", () => {
            this.setWriteThickness(this.buttons.lineSize.value);
        });
    }

    setButtonRemoveLastLine(_cssElementSelector)
    {
        this.buttons.removeLastLine = document.querySelector(_cssElementSelector);

        this.buttons.removeLastLine.addEventListener("click", () => {
            this.linesTraced.pop();
            this.clearAndDrawLinesTraced();
        });
    }

    setWriteColor(_color) {
        this.writeColor = _color;

        this.canvasContext.strokeStyle = _color;

        if (this.buttons.lineColor != null) {
            this.buttons.lineColor.value = _color;
        }
    }

    getWriteColor() {
        return this.writeColor;
    }

    setWriteThickness(_lineSize) {
        this.writeThickness = _lineSize;

        this.canvasContext.lineWidth = _lineSize;

        if (this.buttons.lineSize != null) {
            this.buttons.lineSize.value = _lineSize;
        }
    }

    getWriteThickness() {
        return this.writeThickness;
    }

    addLine(_firstPoint, _secondPoint, _color, _thickness)
    {
        this.linesTraced.push(
            new CanvasLine(
                _firstPoint,
                _secondPoint,
                _color,
                _thickness
            )
        );
    }

    getAllLines() {
        return this.linesTraced;
    }

    drawLineFromObject(_line)
    {
        this.drawLine(
            _line.getFirstPoint(),
            _line.getSecondPoint(),
            _line.getColor(),
            _line.getThickness()
        );
    }

    drawLine(_firstPoint, _secondPoint, _color, _thickeness) {
        this.canvasContext.beginPath();
        this.canvasContext.lineWidth = _thickeness;
        this.canvasContext.strokeStyle = _color;
        this.canvasContext.moveTo(
            _firstPoint.getCoordinateX(),
            _firstPoint.getCoordinateY()
        );
        this.canvasContext.lineTo(
            _secondPoint.getCoordinateX(),
            _secondPoint.getCoordinateY()
        );
        this.canvasContext.stroke();
    }

    drawAllLinesTraced() {
        this.linesTraced.forEach(line => {
            this.drawLineFromObject(line);
        });
    }

    getMousePosition(_event) {
        let rectangle = this.canvasElement.getBoundingClientRect();

        return new CanvasPoint(
            _event.clientX - rectangle.left,
            _event.clientY - rectangle.top
        );
    }

    clearWorkspace() {
        this.canvasContext.clearRect(0, 0, this.canvasElement.width, this.canvasElement.height);
    }

    clearAndDrawLinesTraced() {
        this.clearWorkspace();
        this.drawAllLinesTraced();
    }
}
