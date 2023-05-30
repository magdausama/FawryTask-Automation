package POM;

import Actions.SeleniumActions;
import DTO.ElementDTO;
import utils.ConfigUtils;

public class CheckoutPage extends BasePage{
    ElementDTO fullName = new ElementDTO("address-ui-widgets-enterAddressFullName", SeleniumActions.Locators.XPath),
    addressPhoneNumber = new ElementDTO("address-ui-widgets-enterAddressPhoneNumber", SeleniumActions.Locators.XPath),
    addressLine1= new ElementDTO("address-ui-widgets-enterAddressLine1", SeleniumActions.Locators.XPath),
    addressCity= new ElementDTO("address-ui-widgets-enterAddressCity", SeleniumActions.Locators.XPath),
            buildingName= new ElementDTO("address-ui-widgets-enter-building-name-or-number", SeleniumActions.Locators.XPath),
            landMark = new ElementDTO("address-ui-widgets-landmark", SeleniumActions.Locators.XPath),
    addNewAddressButton= new ElementDTO("add-new-address-popover-link", SeleniumActions.Locators.id),
    addressType= new ElementDTO("address-ui-widgets-addr-details-res-radio-outer", SeleniumActions.Locators.id),
    submitAddress= new ElementDTO("address-ui-widgets-form-submit-button-announce", SeleniumActions.Locators.id),
    useThisAddressButton = new ElementDTO("orderSummaryPrimaryActionBtn-announce", SeleniumActions.Locators.id),
    paymentMethodRadioButton = new ElementDTO("pp-QYJuyh-72", SeleniumActions.Locators.id),
    submitPaymentMethod = new ElementDTO("pp-QYJuyh-73-announce", SeleniumActions.Locators.id),
    totalPrice= new ElementDTO("//td[@class='a-color-price a-size-medium a-text-right a-align-bottom aok-nowrap grand-total-price a-text-bold']", SeleniumActions.Locators.XPath),
    changeAddressButton = new ElementDTO("addressChangeLinkId", SeleniumActions.Locators.XPath);

    public CheckoutPage(String key) {
        super(key);
    }


    public String getTitleofCheckOutPage()
    {
        return seleniumActions.getText(new ElementDTO("//h1", SeleniumActions.Locators.XPath));
    }

//entering data for the new address
    public void addAddress() throws Exception {
        seleniumActions.clickOn(changeAddressButton);
        seleniumActions.setText(fullName, ConfigUtils.getInstance().getfullNameL(), true);
        seleniumActions.setText(addressPhoneNumber, ConfigUtils.getInstance().getPhone(), true);
        seleniumActions.setText(addressLine1, ConfigUtils.getInstance().getStreetName(),true);
        seleniumActions.setText(buildingName, ConfigUtils.getInstance().getBuildingName(), true);
        seleniumActions.setText(addressCity, ConfigUtils.getInstance().getCity(), true);
        seleniumActions.clickOn(new ElementDTO("//li[@class='autoOp' and contains(text(),"+ConfigUtils.getInstance().getCity()+")]", SeleniumActions.Locators.XPath));
        seleniumActions.setText(landMark, ConfigUtils.getInstance().getLandMark(), true);
        seleniumActions.clickOn(addressType);
        seleniumActions.clickOn(submitAddress);
        seleniumActions.clickOn(useThisAddressButton);
    }

    public void addPaymentMethod() throws Exception {
        seleniumActions.clickOn(paymentMethodRadioButton);
        seleniumActions.clickOn(submitPaymentMethod);
    }


    public Double getOrderTotal()
    {
        String totalAsAString =seleniumActions.getText(totalPrice);
        String cleanAmount = totalAsAString.replaceAll("[^\\d.]", ""); // Remove non-numeric characters
        return Double.parseDouble(cleanAmount);
    }
}
