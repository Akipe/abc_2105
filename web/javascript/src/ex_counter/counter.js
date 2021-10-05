//Vous n'êtes pas obligés de comprendre la class compteur
class Compteur {
    constructor(début, delaiEnMilisecondes) {
        this.compte = début;
        this.spanElement = document.createElement("span");
        this.spanElement.textContent = début;

        setInterval(() => {
            this.compte++;
            this.spanElement.textContent = this.compte;
        }, delaiEnMilisecondes);
    }
}

class StyleAnimator {
    constructor(_miliseconds, _htmlElement, _cssClassName) {
        this.htmlElement = _htmlElement;
        this.cssClassName = _cssClassName;

        setInterval(() => {
            if (this.htmlElement.classList.contains(this.cssClassName)) {
                this.htmlElement.classList.remove(this.cssClassName);
            } else {
                this.htmlElement.classList.add(this.cssClassName);
            }
        }, _miliseconds);
    }
}


let span = document.querySelector(".compteur-secondes p span");

let compteSeconde = new Compteur(0, 1000);

span.parentElement.replaceChild(compteSeconde.spanElement, span);


console.log(compteSeconde.compte);

setMinutes(".empty");
setFunkyStyleAnimeted("div", "PageDiv-Animated");



function setMinutes(_querySelector) {
    const milisecondesForOneMinute = 60000;
    let counterMinutes;
    let parentNode;
    let pNode;

    counterMinutes = new Compteur(0, milisecondesForOneMinute);
    parentNode = document.querySelector(_querySelector);

    parentNode.innerHTML = "<p>Temps passé en minutes = <span>0</span></p>";

    pNode = parentNode.children[0];
    pNode.replaceChild(counterMinutes.spanElement, document.querySelector(_querySelector + " span"))
}

function setFunkyStyleAnimeted(_querySelector, _cssClassName) {
    const TIME_ANIMATION_MILISECONDS = 20000;
    let nodes;

    nodes = document.querySelectorAll(_querySelector);

    for (let index = 0; index < nodes.length; index++) {
        new StyleAnimator(TIME_ANIMATION_MILISECONDS, nodes[index], _cssClassName);
    }
}