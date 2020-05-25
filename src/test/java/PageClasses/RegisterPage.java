package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	WebDriver ldriver;
	 public RegisterPage(WebDriver rdriver)
	 {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	 }
	 
	 @FindBy(name="title")
	 public WebElement selecttitle;
	 
	 @FindBy(id="user_firstname")
	 public WebElement firstname;
	 
	 @FindBy(id="user_surname")
	 public WebElement surname;
	 
	 @FindBy(id="user_phone")
	 public WebElement number;
	 
	 @FindBy(name="year")
	 public WebElement year;
	 
	 @FindBy(name="month")
	 public WebElement month;
	 
	 @FindBy(name="date")
	 public WebElement date;
	 
	 @FindBy(id="licencetype_t")
	 public WebElement radiobutton1;
	 @FindBy(id="licencetype_f")
	 public WebElement radiobutton2;
	 
	 @FindBy(name="licenceperiod")
	 public WebElement period;
	 
	 @FindBy(name="occupation")
	 public WebElement occupation;
	 
	 @FindBy(name="street")
	 public WebElement Address;
	 
	 @FindBy(name="city")
	 public WebElement cityname;
	 
	 @FindBy(name="county")
	 public WebElement countryname;
	 
	 @FindBy(name="post_code")
	 public WebElement postcode;
	 
	 @FindBy(name="email")
	 public WebElement Emailid;
	 
	 @FindBy(id="user_user_detail_attributes_password")
	 public WebElement password;
	 
	 @FindBy(name="c_password")
	 public WebElement confirmpassword;

	 @FindBy(name="submit")
	 public WebElement Submitbutton;
	 
	 @FindBy(id="password")
	 public WebElement password1;


	 
	 public void titledropdown(String value)
	 {
		 Select s=new Select(selecttitle);
			s.selectByValue(value);
		 selecttitle.click();
	 }
	 
	 public void setFirstName(String frstname)
	 {
		 firstname.sendKeys(frstname);
	 }
	 
	 public void setsurName(String lastname)
	 {
		 surname.sendKeys(lastname);
	 }
	 
	 public void setMobileNumber(String MobileNumber)
	 {
		 number.sendKeys(MobileNumber);
	 }
	 
	 public void setDateofBirth(String yr,String m,String d)
	 {
		 year.sendKeys(yr);
		 month.sendKeys(m);
		 date.sendKeys(d);
	 }
	 
	 public void setRadiobtn1()
	 {
		 radiobutton1.click(); 
	 }
	 
	 public void setRadiobtn2()
	 {
		 radiobutton2.click(); 
	 }
	 
	 public void setperiod(String value1)
	 {
		 Select s1=new Select(period);
		s1.selectByValue(value1);
		 period.click();
	 }
	  public void setoccupation(String value2)
	  {
			Select s2=new Select(occupation);
			s2.selectByValue(value2);
		  occupation.click();
	  }
	  
	  public void setAddress(String Addressdetails)
	  {
		  Address.sendKeys(Addressdetails); 
	  }
	  
	  public void setCity(String Cityname)
	  {
		  cityname.sendKeys(Cityname); 
	  }
	  
	  public void setCountry(String Countryname)
	  {
		  countryname.sendKeys(Countryname); 
	  }
	  
	  public void setpostcode(String pcode)
	  {
		  postcode.sendKeys(pcode); 
	  }
	  
	  public void setEmail(String emailid)
	  {
		  Emailid.sendKeys(emailid); 
	  }
	  
	  public void setpassword(String pswd)
	  {
		  password.sendKeys(pswd); 
	  }
	  
	  public void setCpassword(String Cpswd)
	  {
		  confirmpassword.sendKeys(Cpswd); 
	  }
	  
	  public void submitbutton()
	  {
		  Submitbutton.click();
	  }
	  
	  public void setpassword1(String pswd1)
	  {
		  password1.sendKeys(pswd1); 
	  }




}
