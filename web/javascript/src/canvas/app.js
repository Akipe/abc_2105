document.addEventListener("DOMContentLoaded", function() {
    setCanvasSize("#horloge", 400, 400);

    let canvasHorloge = document.querySelector("#horloge");

    if (canvasHorloge.getContext) {
        let ctx = canvasHorloge.getContext('2d');
        let centerHeight = canvasHorloge.height / 2;
        let centerWidth = canvasHorloge.width / 2;

        // Black background
        ctx.fillStyle = "black";
        ctx.fillRect(0, 0, canvasHorloge.width, canvasHorloge.height);

        // White clock
        let innerClockWhite = figureCircleCenter(canvasHorloge.width, canvasHorloge.height, (canvasHorloge.height - 40) / 2);
        ctx.fillStyle = "white";
        ctx.fill(innerClockWhite);

        // Black point in center
        let pointCenterBlack = figureCircleCenter(canvasHorloge.width, canvasHorloge.height, 10);
        ctx.fillStyle = "black";
        ctx.fill(pointCenterBlack);

        // Hours
        let ang;
        let num;
        let radius = 200
        ctx.font = radius * 0.15 + "px arial";
        ctx.textBaseline = "middle";
        ctx.textAlign = "center";
        for(num = 1; num < 13; num++){
            ang = num * Math.PI / 6;
            ctx.rotate(ang);
            ctx.translate(0, -radius * 0.85);
            ctx.rotate(-ang);
            ctx.fillText(num.toString(), 0, 0);
            ctx.rotate(ang);
            ctx.translate(0, radius * 0.85);
            ctx.rotate(-ang);
        }
    }
});

function setCanvasSize(_canvasCssSelector, _width, _height) {
    let canvasNode;

    canvasNode = document.querySelector(_canvasCssSelector);

    canvasNode.width = Number.parseInt(_width);
    canvasNode.height = Number.parseInt(_height);
    canvasNode.style.border = "1px solid black";
}

function figureCircleCenter(_canvasWidth, _canvasHeight, _radius) {
    let clock = new Path2D();

    clock.arc(_canvasWidth / 2, _canvasHeight / 2, _radius, 0, 2 * Math.PI);
    // clock.arc(_canvasWidth / 2, _canvasHeight / 2, (_canvasHeight - _spaceBetweenLimit) / 2, 0, 2 * Math.PI);
    clock.fillStyle = "white";

    return clock;
}

function figureHoursNumbers(_hour, _radius)
{
    let figureHour = new Path2D();

    angle = _hour * Math.PI / 6;
    figureHour.rotate(angle);
    figureHour.translate(0, -_radius * 0.85);
    figureHour.rotate(-ang);
    figureHour.fillText(_hour.toString(), 0, 0);
    figureHour.rotate(ang);
    figureHour.translate(0, _radius * 0.85);
    figureHour.rotate(-ang);

    return figureHour;
}