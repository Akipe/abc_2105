document.addEventListener("DOMContentLoaded", function() {
    exercice3();
});

// 3
function exercice3() {
    let days = 0;
    let hours = 0;
    let minutes = 0;
    let seconds = 0;
    let time;

    setButtonTimeFix();
    setButtonIncrementOneSecond();

    // days = parseInt(prompt("Veuillez entrer un nombre de jours"));
    // hours = parseInt(prompt("Veuillez entrer un nombre d'heures"));
    // minutes = parseInt(prompt("Veuillez entrer un nombre de minutes"));
    // seconds = parseInt(prompt("Veuillez entrer un nombre de secondes"));
    // time = fixTime(days, hours, minutes, seconds);
    
    // console.log(`Le temps rentré par l'utilisateur est : ${time.days} jours, ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);

    // console.log("On ajout 1 seconde...")
    // seconds++;
    // time = fixTime(days, hours, minutes, seconds);
    // console.log(`Le temps rentré par l'utilisateur avec l'ajout d'une seconde est : ${time.days} jours, ${time.hours} heures, ${time.minutes} minutes et ${time.seconds} seconds.`);
}

function setButtonTimeFix() {
    const BUTTON_SELECTOR = "#timeFix";

    document.querySelector(BUTTON_SELECTOR).addEventListener("click", fixTimeFromHTML);
}

function setButtonIncrementOneSecond() {
    const BUTTON_SELECTOR = "#timeIncrementOneSecond";

    
    document.querySelector(BUTTON_SELECTOR).addEventListener("click", incrementOneSecondTimeHTML);
}

function incrementOneSecondTimeHTML() {
    const SECONDS_INPUT = "#timeSeconds";

    document.querySelector(SECONDS_INPUT).value = Number.parseInt(document.querySelector(SECONDS_INPUT).value) + 1;

    fixTimeFromHTML();
}

function fixTimeFromHTML() {
    const DAYS_INPUT = "#timeDays"
    const HOURS_INPUT = "#timeHours"
    const MINUTES_INPUT = "#timeMinutes"
    const SECONDS_INPUT = "#timeSeconds"

    let daysInputElement;
    let hoursInputElement;
    let minutesInputElement;
    let secondsInputElement;
    let timeFixed;
    
    daysInputElement = document.querySelector(DAYS_INPUT);
    hoursInputElement = document.querySelector(HOURS_INPUT);
    minutesInputElement = document.querySelector(MINUTES_INPUT);
    secondsInputElement = document.querySelector(SECONDS_INPUT);
    
    timeFixed = fixTime(
        Number.parseInt(daysInputElement.value),
        Number.parseInt(hoursInputElement.value),
        Number.parseInt(minutesInputElement.value),
        Number.parseInt(secondsInputElement.value)
    );

    daysInputElement.value = "";
    hoursInputElement.value = "";
    minutesInputElement.value = "";
    secondsInputElement.value = "";

    daysInputElement.value = timeFixed.days;
    hoursInputElement.value = timeFixed.hours;
    minutesInputElement.value = timeFixed.minutes;
    secondsInputElement.value = timeFixed.seconds;
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
