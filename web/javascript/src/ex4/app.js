document.addEventListener("DOMContentLoaded", function() {
    exercice1();

    exercice3();
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
