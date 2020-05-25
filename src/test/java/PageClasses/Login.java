package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver ldriver;
	 public Login(WebDriver rdriver)
	 {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	 }
	 
  @FindBy(xpath="//a[contains(text(),\"Insurance Project\")]")
  public static WebElement insurancelink;
  
  @FindBy(xpath="//a[contains(text(),\"Register\")]")
  public static WebElement Registerlink;
  
  public void insurancelnk()
  {
	   insurancelink.click();
  }
  

  public  void RegisterButton()
  {
	   Registerlink.click();
  }
  


}
