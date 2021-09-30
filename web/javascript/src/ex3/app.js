document.addEventListener("DOMContentLoaded", function() {
    exercice1();

    exercice2();

    exercice3();
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

// 3
function exercice3() {
    let number = 0;
    let vectorNumber = 0;

    number = promptInt("Veuillez entrer un nombre pour calculer son vectoriel");
    vectorNumber = vectorOfNumber4(number);

    console.log(`Le vectoriel de ${number} est ${vectorNumber}`);
}

function vectorOfNumber(_number) {
    let numberMinusOne = 0;

    if (_number == 0) {
        return 1;
    } else if (_number == 0) {
        return _number;
    } else {
        numberMinusOne = _number - 1;
        return _number * vectorOfNumber(numberMinusOne);
    }
}

// Helper

function promptInt(_message) {
    let userInput = '';

    do {
        userInput = parseInt(prompt(_message));

        if (Number.isInteger(userInput)) {
            return userInput;
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
