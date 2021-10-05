document.addEventListener("DOMContentLoaded", function() {
    document.querySelector("#button").addEventListener("click", aimerMoi);
});

function aimerMoi() {
    let howManyExecute = 0;
    let textNode = document.getElementById("amour");
    const textLove = "Tu m'aime fort <3";
    const textNoLove = "Tu ne m'aime pas ?";

    if (howManyExecute % 2 == 0) {
        textNode.innerHTML = textLove;
    } else {
        textNode.innerHTML = textNoLove;
    }
}
