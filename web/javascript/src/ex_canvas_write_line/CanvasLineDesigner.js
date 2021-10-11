class CanvasLineDesigner {
    constructor(canvasElement) {
        this.canvasElement = canvasElement;
        this.canvasContext = this.canvasElement.getContext('2d');
        this.linesTraced = Array();
        this.mousePositionFirstClick = {
            x: null,
            y: null
        };
        this.mousePositionSecondClick = {
            x: null,
            y: null
        };

        this.buttons = {
            lineColor: null,
            lineSize: null,
            removeLastLine: null
        };

        this.setLineSize(1);
        this.setLineColor("#ff0000");
        // this.canvasContext.strokeStyle = "red";

        this.generateDesigner();
    }

    generateDesigner() {
        let numberUserClick = 0;

        this.canvasElement.addEventListener("click", (event) => {
            let clickMousePosition;
        
            clickMousePosition = this.getMousePosition(event);

            this.canvasElement.addEventListener("mousemove", (event) => {
                if (numberUserClick % 2 == 1) {
                    let realTimeMousePosition;

                    realTimeMousePosition = this.getMousePosition(event);
                    this.clearAndRedrawLines();
                    this.drawLine(
                        clickMousePosition.x,
                        clickMousePosition.y,
                        realTimeMousePosition.x,
                        realTimeMousePosition.y,
                        this.getLineSize(),
                        this.getLineColor()
                    );
            
                    this.setMousePositionFirstClick(
                        clickMousePosition.x,
                        clickMousePosition.y
                    );
                }
            });
            
            if (numberUserClick % 2 == 1) {
                this.setMousePositionSecondClick(
                    clickMousePosition.x,
                    clickMousePosition.y
                );

                this.addLineFromMousePosition();
                this.clearAndRedrawLines();
            }
            numberUserClick++;
        });
    }

    setButtonLineColor(_cssElementSelector)
    {
        this.buttons.lineColor = document.querySelector(_cssElementSelector);
        this.buttons.lineColor.value = this.getLineSize();

        this.buttons.lineColor.addEventListener("change", () => {
            this.setLineColor(this.buttons.lineColor.value);
        });
    }

    setButtonLineSize(_cssElementSelector)
    {
        this.buttons.lineSize = document.querySelector(_cssElementSelector);
        this.buttons.lineSize.value = this.getLineSize();

        this.buttons.lineSize.addEventListener("change", () => {
            this.setLineSize(this.buttons.lineSize.value);
        });
    }

    setButtonRemoveLastLine(_cssElementSelector)
    {
        this.buttons.removeLastLine = document.querySelector(_cssElementSelector);

        this.buttons.removeLastLine.addEventListener("click", () => {
            this.linesTraced.pop();
            this.clearAndRedrawLines();
        });
    }

    setMousePositionFirstClick(_x, _y) {
        this.mousePositionFirstClick.x = _x;
        this.mousePositionFirstClick.y = _y;
    }

    setMousePositionSecondClick(_x, _y) {
        this.mousePositionSecondClick.x = _x;
        this.mousePositionSecondClick.y = _y;
    }

    setLineColor(_lineColor) {
        this.currentLineColor = _lineColor;

        this.canvasContext.strokeStyle = _lineColor;

        if (this.buttons.lineColor != null) {
            this.buttons.lineColor.value = _lineColor;
        }
    }

    getLineColor() {
        return this.currentLineColor;
    }

    setLineSize(_lineSize) {
        this.currentLineSize = _lineSize;

        this.canvasContext.lineWidth = _lineSize;

        if (this.buttons.lineSize != null) {
            this.buttons.lineSize.value = _lineSize;
        }
    }

    getLineSize() {
        return this.currentLineSize;
    }

    addLineFromMousePosition() {
        this.addLine(
            this.mousePositionFirstClick.x,
            this.mousePositionFirstClick.y,
            this.mousePositionSecondClick.x,
            this.mousePositionSecondClick.y,
            this.getLineSize(),
            this.getLineColor(),
        );
    }

    addLine(_firstPointX, _firstPointY, _secondPointX, _secondPointY, _size, _color) {
        this.linesTraced.push({
            path: {
                firstPoint: {
                    x: _firstPointX,
                    y: _firstPointY,
                },
                secondPoint: {
                    x: _secondPointX,
                    y: _secondPointY,
                },
            },
            size: _size,
            color: _color
        });
    }

    drawLine(_firstPointX, _firstPointY, _secondPointX, _secondPointY, _size, _color) {
        this.canvasContext.beginPath();
        this.canvasContext.lineWidth = _size;
        this.canvasContext.strokeStyle = _color;
        this.canvasContext.moveTo(_firstPointX, _firstPointY);
        this.canvasContext.lineTo(_secondPointX, _secondPointY);
        this.canvasContext.stroke();
    }

    drawAllLines() {
        this.linesTraced.forEach(line => {
            this.drawLine(
                line.path.firstPoint.x,
                line.path.firstPoint.y,
                line.path.secondPoint.x,
                line.path.secondPoint.y,
                line.size,
                line.color
            );
        });
    }

    getMousePosition(_event) {
        let rectangle = this.canvasElement.getBoundingClientRect();
        return {
            x: _event.clientX - rectangle.left,
            y: _event.clientY - rectangle.top
        }
    }

    clearCanvas() {
        this.canvasContext.clearRect(0, 0, this.canvasElement.width, this.canvasElement.height);
    }

    clearAndRedrawLines() {
        this.clearCanvas();
        this.drawAllLines();
    }
}
