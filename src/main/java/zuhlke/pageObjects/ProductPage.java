package zuhlke.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import zuhlke.utils.Utils;

public class ProductPage {
    Utils utils;
    WebDriver driver;
    ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        utils = new Utils(driver);
        this.driver=driver;
    }

    @FindBy(how= How.CSS , using="#block_top_menu>ul>li:nth-child(3)>a")
    private WebElement link_TShirt;

    @FindBy(how= How.CSS , using=".product-image-container>a>img")
    private WebElement button_quickView;

    @FindBy(how= How.CSS , using="#our_price_display")
    private WebElement dialog_product_price;

    @FindBy(how= How.CSS , using=".icon-plus")
    private WebElement icon_plus;

    @FindBy(how= How.CSS , using=".selector#uniform-group_1>select")
    private WebElement dropbox_Size;

    @FindBy(how= How.CSS , using="#add_to_cart>button")
    private WebElement add_to_card;

    @FindBy(how= How.CSS , using=".layer_cart_product>h2")
    private WebElement succesful_message_add_to_card;

    @FindBy(how= How.XPATH , using=".//a[contains(@title,'Proceed to checkout')]")
    private WebElement btn_proceesToCheckout;

    @FindBy(how= How.CSS , using=".cart_navigation.clearfix>a:nth-child(1)")
    private WebElement proceedtocheckout_CartSummary;

    @FindBy(how= How.XPATH , using="//*[@id='center_column']/form/p/button")
    private WebElement proceedtocheckout_Address;

    @FindBy(how= How.XPATH , using="//*[@id=\"form\"]/p/button")
    private WebElement proceedtocheckout_Shipping;

    @FindBy(how= How.CSS , using="#cgv")
    private WebElement checkbox_TermsConditions;

    @FindBy(how= How.CSS , using="#HOOK_PAYMENT>div:nth-child(1)>div>p>a")
    private WebElement payment_byBank;

    @FindBy(how= How.XPATH , using="//*[@id=\"cart_navigation\"]/button")
    private WebElement btn_Confirm;

    @FindBy(how= How.CSS , using=".cheque-indent")
    private WebElement txt_YourOrderIsCompleted;

    public  void verifyProductPage(){

        Assert.assertEquals(true,link_TShirt.isDisplayed());
    }

    public void AddProductToCart(){

        link_TShirt.click();

        utils.JS_ScrollToView(button_quickView);

        utils.MovetoElementAndClick(button_quickView);

        driver.switchTo().frame(0);
        //System.out.println(" Price at Cart is = "+dialog_product_price.getText());

        Assert.assertEquals("$16.51",dialog_product_price.getText());

        icon_plus.click(); //Add more products

        add_to_card.click();

        driver.switchTo().defaultContent();
        utils.hardWait(5);
        Assert.assertEquals("Product successfully added to your shopping cart",succesful_message_add_to_card.getText());

        btn_proceesToCheckout.click();

        driver.switchTo().parentFrame();




    }

    public void purchaseWithPayment(){

        utils.JS_ScrollToView(proceedtocheckout_CartSummary);
        proceedtocheckout_CartSummary.click();
        proceedtocheckout_Address.click();
        checkbox_TermsConditions.click();
        proceedtocheckout_Shipping.click();
        payment_byBank.click();
        btn_Confirm.click();

        Assert.assertEquals("Your order on My Store is complete.",txt_YourOrderIsCompleted.getText());

    }





}
