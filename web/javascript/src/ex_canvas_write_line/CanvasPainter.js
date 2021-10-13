class CanvasPainter {
    constructor(canvasElement)
    {
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
            drawLine: null,
            selectLine: null,
            lineColor: null,
            lineSize: null,
            removeLastLine: null
        };
        this.numberUserClick = 0;

        this.setLineSize(1);
        this.setLineColor("#ff0000");

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
            // let clickMousePosition;
            // let line;

            // console.log(this.canvasContext.getImageData(0, 0, this.canvasElement.width, this.canvasElement.height).data);

            // clickMousePosition = this.getMousePosition(event);

            // for (let index = 0; index < this.getAllLines().length; index++) {
            //     line = this.getAllLines[index];
            //     if (line
            // }
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
                        clickMousePosition.x,
                        clickMousePosition.y,
                        realTimeMousePosition.x,
                        realTimeMousePosition.y,
                        this.getLineColor(),
                        this.getLineSize()
                    );
            
                    this.setMousePositionFirstClick(
                        clickMousePosition.x,
                        clickMousePosition.y
                    );
                }
            });
            
            if (this.numberUserClick % 2 == 1) {
                this.setMousePositionSecondClick(
                    clickMousePosition.x,
                    clickMousePosition.y
                );

                this.addLineFromMousePosition();
                this.clearAndDrawLinesTraced();
            }
            this.numberUserClick++;
        };
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
            this.clearAndDrawLinesTraced();
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
        let firstPoint;
        let secondPoint;

        firstPoint = new CanvasPoint(
            this.mousePositionFirstClick.x,
            this.mousePositionFirstClick.y
        );
        secondPoint = new CanvasPoint(
            this.mousePositionSecondClick.x,
            this.mousePositionSecondClick.y
        );
        this.linesTraced.push(
            new CanvasLine(
                firstPoint,
                secondPoint,
                this.getLineColor(),
                this.getLineSize()
            )
        );
    }

    getAllLines() {
        return this.linesTraced;
    }

    getFirstPointX(_line) {
        return _line.path.firstPoint.x;
    }

    getFirstPointY(_line) {
        return _line.path.firstPoint.y;
    }

    getSecondPointX(_line) {
        return _line.path.secondPoint.x;
    }

    getSecondPointY(_line) {
        return _line.path.secondPoint.y;
    }

    drawLineFromObject(_line)
    {
        this.drawLine(
            _line.getFirstPoint().getCoordinateX(),
            _line.getFirstPoint().getCoordinateY(),
            _line.getSecondPoint().getCoordinateX(),
            _line.getSecondPoint().getCoordinateY(),
            _line.getColor(),
            _line.getThickness()
        );
    }

    drawLine(_lineFirstPtX, _lineFirstPtY, _lineSecondPtX, _lineSecondPtY, _lineColor, _lineThickeness) {
        this.canvasContext.beginPath();
        this.canvasContext.lineWidth = _lineThickeness;
        this.canvasContext.strokeStyle = _lineColor;
        this.canvasContext.moveTo(
            _lineFirstPtX,
            _lineFirstPtY
        );
        this.canvasContext.lineTo(
            _lineSecondPtX,
            _lineSecondPtY
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
        return {
            x: _event.clientX - rectangle.left,
            y: _event.clientY - rectangle.top
        }
    }

    clearCanvas() {
        this.canvasContext.clearRect(0, 0, this.canvasElement.width, this.canvasElement.height);
    }

    clearAndDrawLinesTraced() {
        this.clearCanvas();
        this.drawAllLinesTraced();
    }
}
