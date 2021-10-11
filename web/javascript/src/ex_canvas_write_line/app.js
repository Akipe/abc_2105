document.addEventListener("DOMContentLoaded", () => {
    const canvas = document.querySelector("#canvas");

    lineDesigner = new CanvasLineDesigner(canvas);
    lineDesigner.generateDesigner();
});
