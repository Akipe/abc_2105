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

        this.canvasContext.strokeStyle = "red";
        this.canvasContext.lineWidth = 5;
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
                    this.clearCanvas();
                    this.drawAllLines();
                    this.canvasContext.beginPath();
                    this.canvasContext.moveTo(clickMousePosition.x, clickMousePosition.y);
                    this.canvasContext.lineTo(realTimeMousePosition.x, realTimeMousePosition.y);
                    this.canvasContext.stroke();
            
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

                this.clearCanvas();
                this.drawAllLines();
            }
            numberUserClick++;
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

    addLineFromMousePosition() {
        this.addLine(
            this.mousePositionFirstClick.x,
            this.mousePositionFirstClick.y,
            this.mousePositionSecondClick.x,
            this.mousePositionSecondClick.y
        );
    }

    addLine(_firstPointX, _firstPointY, _secondPointX, _secondPointY) {
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
        });
    }

    drawLinePath(_line) {
        this.canvasContext.beginPath();
        this.canvasContext.moveTo(_line.path.firstPoint.x, _line.path.firstPoint.y);
        this.canvasContext.lineTo(_line.path.secondPoint.x,_line.path.secondPoint.y);
        this.canvasContext.stroke();
    }

    drawAllLines() {
        this.linesTraced.forEach(line => {
            this.canvasContext.beginPath();
            this.canvasContext.moveTo(line.path.firstPoint.x, line.path.firstPoint.y);
            this.canvasContext.lineTo(line.path.secondPoint.x,line.path.secondPoint.y);
            this.canvasContext.stroke();
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
}
