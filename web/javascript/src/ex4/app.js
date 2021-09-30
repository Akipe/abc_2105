document.addEventListener("DOMContentLoaded", function() {
    exercice3();
});

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
