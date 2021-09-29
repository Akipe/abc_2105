document.addEventListener("DOMContentLoaded", function() {
    // exercice1();

    // exercice2();

    // exercice3();

    // exercice4();

    // exercice5();

    exercice6();
});

// 1
function exercice1() {
    const   ageMajeur       = 18;
    let     yearBirthDay    = 0;
    let     currentYear     = 0;
    let     age             = 0;

    yearBirthDay = prompt("Entrez votre année de naissance");

    currentYear = new Date().getFullYear();
    age = currentYear - yearBirthDay;

    if (age >= ageMajeur) {
        console.log(`Vous êtes majeur !`);
    } else {
        console.log("Vous êtes mineur !");
    }
}

// 2
function exercice2() {
    let name1 = "";
    let name2 = "";
    let name3 = "";
    let isAlphabeticalOrder = true;
    let stayCharChecking = true;
    let charNumber = 0;

    name1 = prompt("Veuillez entrer votre premier nom");
    name2 = prompt("Veuillez entrer le deuxième nom");
    name3 = prompt("Veuillez entrer le troisième nom");

    if (isWordsAreAlphabeticOrder(name1, name2, name3)) {
        console.log("Les nom sont dans l'ordre alphabétique.");
    } else {
        console.log("Les nom ne sont pas dans l'ordre alphabétique.")
    }
}

function isWordsAreAlphabeticOrder(_word1, _word2, _word3) {
    if (isWordIsBeforeOrEqual(_word1, _word2)) {
        if (isWordIsBeforeOrEqual(_word2, _word3)) {
            return true;
        }
    }
    return false;
}

function isWordIsBeforeOrEqual(_word1, _word2) {
    if (_word1.localeCompare(_word2, 'en', { sensitivity: 'base' }) <= 0) {
        return true;
    } else {
        return false;
    }
}

// 3
function exercice3() {
    let days = 0;
    let hours = 0;
    let minutes = 0;
    let seconds = 0;
    let time;

    days = parseInt(prompt("Veuillez entrer un nombre de jours"));
    hours = parseInt(prompt("Veuillez entrer un nombre d'heures"));
    minutes = parseInt(prompt("Veuillez entrer un nombre de minutes"));
    seconds = parseInt(prompt("Veuillez entrer un nombre de secondes"));
    time = fixTime(days, hours, minutes, seconds);
    
    console.log(`Le temps rentré par l'utilisateur est : ${time.days} jours, ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);

    console.log("On ajout 1 seconde...")
    seconds++;
    time = fixTime(days, hours, minutes, seconds);
    console.log(`Le temps rentré par l'utilisateur avec l'ajout d'une seconde est : ${time.days} jours, ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);
}

function fixTime(_days, _hours, _minutes, _seconds) {
    let timeCalc;

    timeCalc = fixSeconds(_seconds);
    _seconds = timeCalc.seconds;
    _minutes = _minutes + timeCalc.minutes;

    timeCalc = fixMinutes(_minutes);
    _minutes = timeCalc.minutes;
    _hours = _hours + timeCalc.hours;

    timeCalc = fixHours(_hours);
    _hours = timeCalc.hours;
    _days = _days + timeCalc.days;

    return {
        'days': _days,
        'hours': _hours,
        'minutes': _minutes,
        'seconds': _seconds
    }
}

function fixHours(_hours) {
    return fixUnitTime(_hours, "hours", 24, "days");
}

function fixMinutes(_minutes) {
    return fixUnitTime(_minutes, "minutes", 60, "hours");
}

function fixSeconds(_seconds) {
    return fixUnitTime(_seconds, "seconds", 60, "minutes");
}

function fixUnitTime(_quantitiesUnitTime, _nameUnitTime, _maxUnitTime, _nameSuperiorUnitTime) {
    let superiorUnitTime = 0;

    if (_quantitiesUnitTime >= _maxUnitTime) {
        superiorUnitTime = Math.floor(_quantitiesUnitTime / _maxUnitTime);
        _quantitiesUnitTime = _quantitiesUnitTime % _maxUnitTime;
    }

    return {
        [_nameUnitTime]: _quantitiesUnitTime,
        [_nameSuperiorUnitTime]: superiorUnitTime
    }
}

function fixMinute(_minutes) {
    let hours = 0;

    if (_minutes >= 60) {
        hours = Math.floor(_minutes / 60);
        _minutes = _minutes % 60;
    }

    return {
        "minutes": _minutes,
        "hours": hours
    }
}

function fixMinute(_minutes) {
    let hours = 0;

    if (_minutes >= 60) {
        hours = Math.floor(_minutes / 60);
        _minutes = _minutes % 60;
    }

    return {
        "minutes": _minutes,
        "hours": hours
    }
}

// 4
function exercice4() {
    let userNumber = 0;
    userNumber = forceAskNumberBetween1900And2021();
    console.log(`L'utilisateur a rentré le nombre ${userNumber}`);
}

function isNumberIsBetween1900And2021(_number) {
    return _number >= 1900 && _number <= 2021;
}

function forceAskNumberBetween1900And2021() {
    let userNumber = 0;

    do {
        userNumber = parseInt(prompt("Veuillez entrer un nombre entre 1900 et 2021."));
    } while (!isNumberIsBetween1900And2021(userNumber));

    return userNumber;
}

// 5
function exercice5() {
    let userNumber = 0;
    let minNumberRandom = 0;
    let maxNumberRandom = 0;
    let numberToFind = 0;
    let askUserInterval;

    askUserInterval = askUserIntervalForRandomNumber();

    minNumberRandom = parseInt(askUserInterval['minNumberRandom']);
    maxNumberRandom = parseInt(askUserInterval['maxNumberRandom']);

    numberToFind = getRandomNumberFrom(minNumberRandom, maxNumberRandom);

    do {
        do {
            userNumber = askUserNumber(minNumberRandom, maxNumberRandom);

            if (userNumber < minNumberRandom || userNumber > maxNumberRandom) {
                console.log(`Le nombre ${userNumber} ne fait pas partie de l'interval entre ${minNumberRandom} et ${maxNumberRandom}.`)
            }
        } while (userNumber < minNumberRandom || userNumber > maxNumberRandom)

        if (userNumber == numberToFind) {
            console.log("Bien joué ! Vous avez trouvé le nombre !");
        } else if (userNumber > numberToFind) {
            console.log(`Le nombre mystère est inférieur à ${userNumber}`);
        } else {
            console.log(`Le nombre mystère est supérieur à ${userNumber}`);
        }
    } while(userNumber != numberToFind);
}

function askUserIntervalForRandomNumber() {
    let isIntervalIsNotValid = false;

    do {
        minNumberRandom = parseInt(prompt("Entrez le nombre le plus petit pour définir l'interval du nombre aléatoire :"));
        maxNumberRandom = parseInt(prompt("Entrez le nombre le plus grand pour définir l'interval du nombre aléatoire :"));

        if (minNumberRandom > maxNumberRandom) {
            console.log("Le nombre le plus petit ne peut être supérieur au nombre le plus grand!");
        } else if (minNumberRandom == maxNumberRandom) {
            console.log("Les deux nombres ne peuvent être égales!");
        } else {
            console.log("Interval valide !");
        }

    } while (minNumberRandom >= maxNumberRandom);

    return {
        'minNumberRandom': minNumberRandom,
        'maxNumberRandom': maxNumberRandom
    };
}

function getRandomNumberFrom(_minNumberRandom, _maxNumberRandom) {
    return Math.floor(Math.random() * (_maxNumberRandom - _minNumberRandom + 1)) + _minNumberRandom;
}

function askUserNumber(_minNumber, _maxNumber) {
    let userInput = 0;

    do {
        userInput = prompt(`Veuillez entrer un nombre entre ${_minNumber} et ${_maxNumber} :`);
    } while (Number.isInteger(userInput));
    
    return parseInt(userInput);
}

// 6
function exercice6() {
    let userNumber = 0;
    let factorNumber = 0;

    userNumber = parseInt(prompt("Veuillez entrer un nombre"));

    if (userNumber == 0) {
        factorNumber = 1;
    } else {
        for (let iterator = userNumber; iterator >= 1; iterator--) {
            if (factorNumber == 0) {
                factorNumber = iterator;
            } else {
                factorNumber = factorNumber * iterator;
            }
        }
    }

    console.log(`Le nombre ${userNumber} a pour factoriel ${factorNumber}`);
} 