document.addEventListener("DOMContentLoaded", () => {
    draw();
});

function draw() {
    const canvas = document.querySelector("#canvas");
    let numberUserClick = 0;

    const ctx = canvas.getContext('2d');

    ctx.strokeStyle = "red";
    ctx.lineWidth = 5;

    canvas.addEventListener("click", (event) => {
        let currentMousePosition = getCanvasMousePosition(canvas, event);

        if (numberUserClick % 2 == 0) {
            ctx.beginPath();
            ctx.moveTo(currentMousePosition.x, currentMousePosition.y);
        } else {
            ctx.lineTo(currentMousePosition.x, currentMousePosition.y);
            ctx.stroke();
        }

        console.log(getCanvasMousePosition(canvas, event));

        numberUserClick++;
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