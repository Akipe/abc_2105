document.addEventListener("DOMContentLoaded", function() {
    let mainArticleClass = "article-principal";

    let mainArticle = document.getElementsByClassName(mainArticleClass)[0];
    if (!mainArticle.classList.contains("flex-article")) {
        mainArticle.classList.add("flex-article");
    }
    mainArticle.classList.replace(mainArticleClass, "article-secondaire");
    mainArticle.textContent = "plus du tout intéressant";

    let nextElement = mainArticle.nextElementSibling;
    if(!nextElement.classList.contains(mainArticleClass)) {
        nextElement.classList.add(mainArticleClass);
    }

    let h1Article = document.createElement("h1");
    h1Article.innerText = "Article principal !";
    nextElement.replaceChild(h1Article, nextElement.children[0]);

    let pMain = document.querySelector(`.${mainArticleClass} > p`);
    pMain.innerHTML = "<strong>Plus </strong> intéressant. <a href='#'>Un lien</a>";

    document.querySelectorAll("article:not(.article-principal)")[0].textContent = "Test"


    let monLien = document.getElementsByTagName("a")[0] ;
    monLien.onclick = function () {
        let couleurJaune =  "rgb(255, 255, 0)" ;
        document.body.style.backgroundColor = couleurJaune ;
    }

    addNewMainArticle(
        "Un super article écrit avec une fonction!",
        "Trop stylé B)."
    );
    addNewSecondaryArticle(
        "Un premier article secondaire créer une fonction",
        "Petit article tranquille."
    );
    addNewSecondaryArticle(
        "Un autre article secondaire",
        "Encore moins intéressant."
    );
});

function addNewMainArticle(_title, _content) {
    const SECONDARY_TITLE_LEVEL = 1;

    let listCssClass = Array(
        "article-secondaire"
    );

    constructorNewArticle(
        listCssClass,
        SECONDARY_TITLE_LEVEL,
        _title,
        _content
    );
}

function addNewSecondaryArticle(_title, _content) {
    const SECONDARY_TITLE_LEVEL = 3;

    let listCssClass = Array(
        "article-secondaire",
        "flex-article"
    );

    constructorNewArticle(
        listCssClass,
        SECONDARY_TITLE_LEVEL,
        _title,
        _content
    );
}

function constructorNewArticle(_arrayCssClass, _titleLevel, _title, _content) {
    let newArticleElement;
    let lastArticle;

    newArticleElement = document.createElement("article");
    _arrayCssClass.forEach(cssClass => {
        newArticleElement.classList.add(cssClass);
    });
    newArticleElement.innerHTML = `<h${_titleLevel}>${_title}</h${_titleLevel}>
    <p>${_content}</p>`;

    newArticleElement.appendChild(constructorArticleLinkWithCounter("Lire l'article"))

    lastArticle = document.querySelector("main article:last-of-type");
    lastArticle.after(newArticleElement);
}

function constructorArticleLinkWithCounter(_buttonContent) {
    const CSS_CLASS_COUNTER = "clickCounter";

    let newElement;
    
    newElement = document.createElement("button");
    newElement.innerHTML = _buttonContent + ` (<span class="${CSS_CLASS_COUNTER}">0</span>)`;

    newElement.addEventListener("click", (event) => {
        let counterElement = event.currentTarget.querySelector("." + CSS_CLASS_COUNTER);
        counterElement.textContent++;
    })

    return newElement;
}