package DTO;

import Actions.SeleniumActions;

public class ElementDTO {

    public String selector;
    public SeleniumActions.Locators locator;

    public ElementDTO(String selector, SeleniumActions.Locators locators) {
        this.selector = selector;
        this.locator = locators;
    }

}
