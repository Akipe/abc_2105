document.addEventListener("DOMContentLoaded", () => {
    const canvas = document.querySelector("#canvas");

    lineDesigner = new CanvasLineDesigner(canvas);
    lineDesigner.generateDesigner();
    lineDesigner.setButtonRemoveLastLine("#CLD-RemoveLastLine");
    lineDesigner.setButtonLineSize("#CLD-LineHeight");
    lineDesigner.setLineSize(1);
    console.log(lineDesigner.getLineSize());
});
