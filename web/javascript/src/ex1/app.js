document.addEventListener("DOMContentLoaded", function() {
    // 1
    let value1 = "Toto";
    let value2 = "Tata";

    console.log(`Valeur des variables :`)
    console.log(`value1 = ${value1}`)
    console.log(`value2 = ${value2}`)

    value1 = value1 + "_" + value2;
    value2 = value1;
    value1 = value1.split('_')[1];
    value2 = value2.split('_')[0];
    
    console.log(`Valeur des variables :`)
    console.log(`value1 = ${value1}`)
    console.log(`value2 = ${value2}`)


    // 2
    let firstname   = "";
    let lastname    = "";
    let age         = 0;

    firstname = prompt("Entrez votre prénom");
    lastname = prompt("Entrez votre nom");
    age = prompt("Entrez votre age");

    console.log(`Votre prénom est ${firstname}, votre nom est ${lastname} et vous avez ${age}.`);


    // 3
    let yearBirthDay = 0;
    let currentYear = 0;
    age = 0;

    yearBirthDay = prompt("Entrez votre année de naissance");

    currentYear = new Date().getFullYear();
    age = currentYear - yearBirthDay;

    console.log(`Vous avez ${age} ans.`);


    // 4
    const taxeInPercent = 20.0;
    let priceDutyFree = 0.0;
    let priceWithTaxe = 0.0;
    let howManyProducts = 0.0;

    priceDutyFree = parseFloat(prompt("Entrez le prix hors taxe"));
    howManyProducts = parseFloat(prompt("Entrez la quantité de produits à acheter"));
    priceWithTaxe = (((priceDutyFree / 100.0) * 20) + priceDutyFree) * howManyProducts;

    console.log(`Le prix TTC de ${howManyProducts} produits coutant ${priceDutyFree}€ HT est de ${priceWithTaxe}€`);


    // 5
    console.log("Écrire de plusieurs façons différentes une même phrase. (1)");

    let sentence = "Écrire de plusieurs façons différentes une même phrase.";
    console.log(sentence + " (2)");

    console.log("Écrire" + " " + "de plusieurs façons" + " différentes " + "une même phrase. (3)")

    let sentenceArray = ["Écrire", "de plusieurs façons", "différentes", "une même phrase."];
    console.log(sentenceArray.join(" ") + " (4)");

    let completeSentence = "";
    for (let index = 0; index < sentenceArray.length; index++) {
        completeSentence += sentenceArray[index] + " ";
    }
    console.log(completeSentence + "(5)");
});