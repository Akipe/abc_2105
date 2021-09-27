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
    let nom1 = "";
    let nom2 = "";
    let nom3 = "";
    let isAlphabeticalOrder = true;
    let charNumber = 0;
    let nodeText = document.getElementById("Text");

    console.log(nodeText);

    nom1 = prompt("Veuillez entrer votre premier nom");
    nom2 = prompt("Veuillez entrer le deuxième nom");
    nom3 = prompt("Veuillez entrer le troisième nom");


    charNumber = 0;
    // do {
        if (nom1[charNumber] <= nom2[charNumber] && nom2[charNumber] <= nom3[charNumber]) {
            nodeText.textContent = "Les noms sont dans l'ordre alphabétique.";
        } else {
            if (nom1[charNumber] <= nom2[charNumber]) {
                nodeText.textContent = "Les deux premiers nom sont dans l'ordre croissant.";
            } else if (nom2[charNumber] <= nom3[charNumber]) {
                nodeText.textContent = "Les deux derniers nom sont dans l'ordre croissant.";
            }
            nodeText.textContent = "Les noms ne sont pas dans tous dans l'ordre croissant";
        }

    //     charNumber++;
    // } while (isAlphabeticalOrder);

});
