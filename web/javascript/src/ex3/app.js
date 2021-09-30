document.addEventListener("DOMContentLoaded", function() {
    exercice1();

    exercice2();
});

// 1
function exercice1() {
    let tabOfValue = [];
    let userInput = '';

    tabOfValue = promptTab();

    console.log(tabOfValue);

    userInput = prompt("Veuillez entrer une donnée à rechercher");
    if (isInArray(tabOfValue, userInput)) {
        console.log("La donnée recherché est bien dans le tableau :)");
    } else {
        console.log("La donnée recherché n'est pas dans le tableau :(");
    }
}

function isInArray(_array, _dataToSearch) {
    for (let index = 0; index < _array.length; index++) {
        if (_array[index] == _dataToSearch) {
            return true
        }
    }

    return false;
}

// 2
function exercice2() {
    let userInput = "";

    userInput = prompt("Veuillez entrer un mot.");

    if (isPalindrome(userInput)) {
        console.log("C'est un palindrome");
    } else {
        console.log("Ce n'est pas un palindrome");
    }
}

function isPalindrome(_word) {
    for (let index = 0, invertIndex = _word.length - 1; index < _word.length; index++) {
        if (_word[index] != _word[invertIndex]) {
            return false;
        }
        invertIndex--;
    }
    return true;
}

// Helper

function promptInt(_message) {
    let userInput = '';

    do {
        userInput = prompt(_message);

        if (Number.isInteger(userInput)) {
            return parseInt(userInput);
        }

        console.log("Veuillez entrer un nombre entier !");
    } while (true);
}

function promptTab() {
    let userInput = "";
    let tabOfValue = [];

    do {
        userInput = prompt("Veuillez entrer une donnée à stocker dans votre tableau (ou une chaine vide pour arréter");
        if (userInput != "") {
            tabOfValue.push(userInput);
        }
    } while (userInput != "");

    return tabOfValue;
}
