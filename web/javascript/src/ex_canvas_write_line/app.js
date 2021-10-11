document.addEventListener("DOMContentLoaded", () => {
    draw();
});

function draw() {
    const canvas = document.querySelector("#canvas");
    const ctx = canvas.getContext('2d');

    let numberUserClick = 0;
    let lineTraced = Array();
    let mousePosition = {
        firstClickX: null,
        firstClickY: null,
        secondClickX: null,
        secondClickY: null
    };

    ctx.strokeStyle = "red";
    ctx.lineWidth = 5;

    canvas.addEventListener("click", (event) => {
        let currentMousePosition;
        
        currentMousePosition = getCanvasMousePosition(canvas, event);
        
        if (numberUserClick % 2 == 0) {
            canvas.addEventListener("mousemove", (event) => {
                if (numberUserClick % 2 == 1) {
                    let updateWhenMouseMovePosition;
    
                    ctx.clearRect(0, 0, canvas.width, canvas.height); // Clear all canvas
                    drawAllLines(ctx, lineTraced);
    
                    updateWhenMouseMovePosition = getCanvasMousePosition(canvas, event);
    
                    ctx.beginPath();
                    if (!Number.isNaN(mousePosition.firstClickX) || !Number.isNaN(mousePosition.firstClickY)) {
                        ctx.moveTo(currentMousePosition.x, currentMousePosition.y);
                    } else {
                        ctx.moveTo(mousePosition.firstClickX, mousePosition.firstClickY );
                    }
                    
                    ctx.lineTo(updateWhenMouseMovePosition.x, updateWhenMouseMovePosition.y);
                    ctx.stroke();
    
                    mousePosition.firstClickX = currentMousePosition.x;
                    mousePosition.firstClickY = currentMousePosition.y;
                }
            });
        } else {
            mousePosition.secondClickX = currentMousePosition.x;
            mousePosition.secondClickY = currentMousePosition.y;

            lineTraced.push(generateLineParameters(
                mousePosition.firstClickX,
                mousePosition.firstClickY,
                mousePosition.secondClickX,
                mousePosition.secondClickY
            ));

            ctx.clearRect(0, 0, canvas.width, canvas.height); // Clear all canvas
            drawAllLines(ctx, lineTraced);
        }

        console.log(getCanvasMousePosition(canvas, event));

        numberUserClick++;
    });
}



function generateLineParameters(_firstPointX, _firstPointY, _secondPointX, _secondPointY) {
    return {
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
    };
}

function drawLinePath(_context, _line) {
    _context.beginPath();
    _context.moveTo(_line.path.firstPoint.x, _line.path.firstPoint.y);
    _context.lineTo(_line.path.secondPoint.x,_line.path.secondPoint.y);
    _context.stroke();
}

function drawAllLines(_context, _arrayLines) {
    _arrayLines.forEach(line => {
        _context.beginPath();
        _context.moveTo(line.path.firstPoint.x, line.path.firstPoint.y);
        _context.lineTo(line.path.secondPoint.x,line.path.secondPoint.y);
        _context.stroke();
    });
}

function canvasInitClickUserDraw() {
    console.log("init draw");
}

function canvasTerminateClickUserDraw() {
    console.log("terminate draw");
}

function getCanvasMousePosition(_canvas, _event) {
    let rectangle = _canvas.getBoundingClientRect();
    return {
        x: _event.clientX - rectangle.left,
        y: _event.clientY - rectangle.top
    }
}
