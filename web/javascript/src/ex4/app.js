document.addEventListener("DOMContentLoaded", function() {
    exercice1();

    exercice2();

    exercice3();

    exercice4();
});

// 1

function exercice1() {
    let userArray = Array();

    userArray = promptTab();

    console.log(`Le nombre le plus petit est ${getLowerNumberInArray(userArray)}`);
    console.log(`${arrayInAscending(userArray)}`);
}

function getLowerNumberInArray(_array) {
    let currentLowerNumber;

    for (let index = 0; index < _array.length; index++) {
        if (!Number.isNaN(Number.parseFloat(_array[index]))) {
            if (typeof currentLowerNumber === 'undefined') {
                currentLowerNumber = Number.parseFloat(_array[index]);
            } else {
                if (Number.parseFloat(currentLowerNumber) > Number.parseFloat(_array[index])) {
                    currentLowerNumber = _array[index];
                }
            }
        }
    }

    return currentLowerNumber;
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

// 2
function exercice2() {
    let userInput = "";

    userInput = prompt("Entrez un mot à tester");

    if (isPalindrome(userInput)) {
        console.log("C'est un palindrome !");
    } else {
        console.log("Ce n'est pas un palindrome :(");
    }
}

function isPalindrome(_word) {

    if (_word.length <= 1) {
        return true;
    } else if (_word[0] == _word[_word.length - 1]) {
        _word = _word.slice(1, _word.length - 1);

        return isPalindrome(_word);
    } else {
        return false;
    }
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

// 4
function exercice4() {
    howManyFibonnacci = 0;
    
    howManyFibonnacci = promptInt("Entrez le nombre d'itération pour la suite Fibonnacci.");0

    console.log(`Le résultat de la suite de Fibonnacci pour ${howManyFibonnacci} itérations est : ${fibonnacci(howManyFibonnacci)}`);
}

function fibonnacci(_iteration) {
    if (_iteration == 0) {
        return 0;
    } else if (_iteration == 1 || _iteration == 2) {
        return 1;
    } else {
        return fibonnacci(_iteration - 1) + fibonnacci(_iteration - 2);
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
