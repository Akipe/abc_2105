document.addEventListener("DOMContentLoaded", function() {
    exercice1();

    exercice2();

    exercice3();

    exercice4();
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
    let userArray = Array(0);

    userArray = promptTab();

    console.log(userArray);
    console.log(`Le nombre le plus petit du tableau est : ${getLowerNumberInArray(userArray)}`);
}

function getLowerNumberInArray(_array) {
    let currentLowerNumber;

    for (let index = 0; index < _array.length; index++) {
        if (!Number.isNaN(_array[index])) {
            if (typeof currentLowerNumber === 'undefined') {
                currentLowerNumber = _array[index];
            } else {
                if (currentLowerNumber > _array[index]) {
                    currentLowerNumber = _array[index];
                }
            }
        }
    }

    return currentLowerNumber;
}

// 4

function exercice4() {
    let arrayUser = Array(0);

    arrayUser = promptTab();

    console.log(arrayInAscending(arrayUser));
}

function arrayInAscending(_array) {
    let temp = 0;
    let needReCheck = false;

    for (let index = 0; index < _array.length; index++) {
        if (parseFloat(_array[index]) > parseFloat(_array[index + 1])) {
            temp = _array[index];
            _array[index] = _array[index + 1];
            _array[index + 1] = temp;
            needReCheck = true;
        }
    }

    if (needReCheck) {
        _array = arrayInAscending(_array);
    }

    return _array;
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
