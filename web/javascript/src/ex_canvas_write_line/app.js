document.addEventListener("DOMContentLoaded", () => {
    const canvas = document.querySelector("#canvas");

    lineDesigner = new CanvasPainter(canvas);
    lineDesigner.setButtonDrawLine("#CLD-DrawLine");
    lineDesigner.setButtonSelectLine("#CLD-SelectLine");
    lineDesigner.setButtonRemoveLastLine("#CLD-RemoveLastLine");
    lineDesigner.setButtonLineSize("#CLD-LineHeight");
    lineDesigner.setButtonLineColor("#CLD-ColorLine");
});
