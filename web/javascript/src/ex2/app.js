document.addEventListener("DOMContentLoaded", function() {
    // 1
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


    // 2
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


    // 3
    let hours = 0;
    let minutes = 0;
    let seconds = 0;
    let time;

    hours = parseInt(prompt("Veuillez entrer un nombre d'heures"));
    minutes = parseInt(prompt("Veuillez entrer un nombre de minutes"));
    seconds = parseInt(prompt("Veuillez entrer un nombre de secondes"));
    time = fixTime(hours, minutes, seconds);
    
    console.log(`Le temps rentré par l'utilisateur est : ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);

    console.log("On ajout 1 seconde...")
    seconds++;
    time = fixTime(hours, minutes, seconds);
    console.log(`Le temps rentré par l'utilisateur avec l'ajout d'une seconde est : ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);

    // 4
    exercice4();
});


// 2
function isWordsAreAlphabeticOrder(_word1, _word2, _word3) {
    if (isWordIsBeforeOrEqual(_word1, _word2)) {
        if (isWordIsBeforeOrEqual(_word2, _word3)) {
            return true;
        }
    }
    return false;
}

// 2
function isWordIsBeforeOrEqual(_word1, _word2) {
    if (_word1.localeCompare(_word2, 'en', { sensitivity: 'base' }) <= 0) {
        return true;
    } else {
        return false;
    }
}

// 3
function fixTime(_hours, _minutes, _seconds) {
    let timeCalc;

    timeCalc = fixSeconds(_seconds);
    _seconds = timeCalc.seconds;
    _minutes = _minutes + timeCalc.minutes;

    timeCalc = fixMinutes(_minutes);
    _minutes = timeCalc.minutes;
    _hours = _hours + timeCalc.hours;

    return {
        'hours': _hours,
        'minutes': _minutes,
        'seconds': _seconds
    }
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
        _quantitiesUnitTime = _quantitiesUnitTime % 60;
    }

    return {
        [_nameUnitTime]: _quantitiesUnitTime,
        [_nameSuperiorUnitTime]: superiorUnitTime
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