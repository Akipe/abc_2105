document.addEventListener("DOMContentLoaded", function() {
    let span = document.querySelector(".compteur-secondes p span");

    let compteSeconde = new Compteur(0, 1000);

    span.parentElement.replaceChild(compteSeconde.spanElement, span);


    let animations = new Array();

    setMinutes(".empty");
    animations = setFunkyStyleAnimeted("div", "PageDiv-Animated");

    console.log(animations);

    stopFunkyStyleAnimeted(animations, ".stop");
});

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
        this.animation = setInterval(() => {
            if (this.htmlElement.classList.contains(this.cssClassName)) {
                this.htmlElement.classList.remove(this.cssClassName);
            } else {
                this.htmlElement.classList.add(this.cssClassName);
            }
        }, _miliseconds);
    }
}


function setMinutes(_querySelector) {
    const MILISECONDS_FOR_ONE_MINUTE = 60000;
    let counterMinutes;
    let parentNode;
    let pNode;

    counterMinutes = new Compteur(0, MILISECONDS_FOR_ONE_MINUTE);
    parentNode = document.querySelector(_querySelector);

    parentNode.innerHTML = "<p>Temps passé en minutes = <span>0</span></p>";

    pNode = parentNode.children[0];
    pNode.replaceChild(counterMinutes.spanElement, document.querySelector(_querySelector + " span"))
}

function setFunkyStyleAnimeted(_querySelector, _cssClassName) {
    const TIME_ANIMATION_MILISECONDS = 1000;
    let nodes;
    let styleAnimators = new Array();

    nodes = document.querySelectorAll(_querySelector);

    for (let index = 0; index < nodes.length; index++) {
        styleAnimators.push(new StyleAnimator(TIME_ANIMATION_MILISECONDS, nodes[index], _cssClassName));
    }

    return styleAnimators;
}

function stopFunkyStyleAnimeted(_funkyAnimations, _selectorButton) {
    elementButton = document.querySelector(_selectorButton);

    elementButton.addEventListener("click", stopAnimation.bind(null, _funkyAnimations));
}

function stopAnimation(_funkyAnimations) {
    console.log(_funkyAnimations);
    for (let index = 0; index < _funkyAnimations.length; index++) {
        clearInterval(_funkyAnimations[index].animation);
    }
}