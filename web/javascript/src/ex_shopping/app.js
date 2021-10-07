const CLASS_SHOP_FORM                       = ".FormShopping";
const CLASS_SHOP_ITEM_LIST                  = ".FormShopping-ItemList";
const CLASS_SHOP_ITEM_LIST_INPUT            = CLASS_SHOP_ITEM_LIST + " input";
const CLASS_SHOP_BUTTON_ADD_ITEM            = ".FromShopping-Button-AddItem";
const CLASS_SHOP_BUTTON_CREATE_PRESENTATION = ".FromShopping-Button-CreatePresentation";
const CLASS_SHOP_PRESENTATION_NO_POINT      = "PresentationShopping";
const CLASS_SHOP_PRESENTATION               = "." + CLASS_SHOP_PRESENTATION_NO_POINT;

let itemList = Array();

document.addEventListener("DOMContentLoaded", function() {
    setShoppingListItemButton();
    defineButtonGetShoppingList();
});

function setShoppingListItemButton() {
    let itemsList;
    let buttonElement;

    itemsList = document.querySelector(CLASS_SHOP_ITEM_LIST);
    buttonElement = document.querySelector(CLASS_SHOP_BUTTON_ADD_ITEM);

    buttonElement.addEventListener('click', () => {
        let newInputItemElement;
        let newDivItemElement;
        let itemsElements = Array();

        itemsElements = document.querySelectorAll(CLASS_SHOP_ITEM_LIST_INPUT);
        
        newDivItemElement = document.createElement("div");
        newDivItemElement.classList.add = CLASS_SHOP_ITEM_LIST;

        newInputItemElement = document.createElement("input");
        newInputItemElement.type = "text";

        newDivItemElement.appendChild(newInputItemElement);

        itemsElements[itemsElements.length - 1].after(newDivItemElement);
    });
}

function defineButtonGetShoppingList() {
    let button;

    button = document.querySelector(CLASS_SHOP_BUTTON_CREATE_PRESENTATION);
    button.addEventListener('click', generateShoppingListPresentation);
}

function generateShoppingListPresentation() {
    let itemsList = Array();

    itemList = getShoppingList();

    createShoppingListElements(itemList);
}

function getShoppingList() {
    let itemsList = Array();
    let itemsListElements;

    itemsListElements = document.querySelectorAll(CLASS_SHOP_ITEM_LIST_INPUT);

    for (let index = 0; index < itemsListElements.length; index++) {
        itemsList.push(itemsListElements[index].value);
    }

    return itemsList;
}

function createShoppingListElements(_itemList) {
    let masterElement;
    let listElement;
    let itemsElement = Array();

    masterElement = document.createElement("div");
    masterElement.classList.add(CLASS_SHOP_PRESENTATION_NO_POINT);

    listElement = document.createElement("ul");

    for (let index = 0; index < _itemList.length; index++) {
        let itemElement =  document.createElement("li");
        itemElement.innerText = _itemList[index];

        if (index == 0) {
            listElement.appendChild(itemElement)
        } else {
            listElement.lastChild.after(itemElement)
        }
    }

    masterElement.appendChild(listElement);

    if (document.querySelector(CLASS_SHOP_PRESENTATION)) {
        document.querySelector(CLASS_SHOP_PRESENTATION).remove();
    }
    
    document.querySelector(CLASS_SHOP_FORM).after(masterElement);
}