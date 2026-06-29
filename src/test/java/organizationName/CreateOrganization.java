package organizationName;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the organisation name");
		
		String organisation = sc.nextLine();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions aobj = new Actions(driver);
		
		driver.get("http://49.249.29.4:8888/index.php?action=Login&module=Users");
		
		WebElement untxtfld = driver.findElement(By.name("user_name"));
		
		WebElement pwdtxtfld = driver.findElement(By.name("user_password"));
		
		WebElement lgnbtn = driver.findElement(By.id("submitButton"));
		
		if (untxtfld.isDisplayed()&&pwdtxtfld.isDisplayed()&&lgnbtn.isDisplayed()) {
			
			System.out.println("username textfield is displayed");
			System.out.println("password textfield is displayed");
			System.out.println("login button is displayed");

		}
		System.out.println("----------------------");
		
		untxtfld.sendKeys("admin");
		pwdtxtfld.sendKeys("admin");
		lgnbtn.click();
		
		WebElement orglink = driver.findElement(By.xpath("//a[text()='Organizations']"));
		
		orglink.click();
		
		WebElement addbtn = driver.findElement(By.xpath("//img[@title='Create Organization...']"));
		
		addbtn.click();
		
		WebElement orgnamtxtfld = driver.findElement(By.xpath("//input[@name='accountname']"));
				
		orgnamtxtfld.sendKeys(organisation);
		
		WebElement savbtn = driver.findElement(By.xpath("(//input[@name='button'])[3]"));
		
		aobj.scrollToElement(savbtn);
		
		savbtn.click();
		
		Thread.sleep(2000);
		
		WebElement srchbxfld = driver.findElement(By.xpath("//tr/td/input[@class='searchBox']"));
		
		srchbxfld.sendKeys(organisation);
		
		//aobj.sendKeys(Keys.TAB,"Kalasalingam University",Keys.ENTER).perform();
		
		Thread.sleep(2000);
		
		WebElement srchbtn = driver.findElement(By.xpath("//input[@class='searchBtn']"));
		
		srchbtn.click();
		
		Thread.sleep(3000);
		
		WebElement orgname = driver.findElement(By.xpath("//table[@class='small']//a[text()='"+organisation+"']"));
		
		System.out.println(orgname.getText());
		
		WebElement orgnum = driver.findElement(By.xpath("//table[@class='small']//a[text()='"+organisation+"']/../preceding-sibling::td"));

		System.out.println(orgnum.getText());
		
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		WebElement signout = driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
		
		aobj.moveToElement(profile).click().perform();
		
		driver.close();
		
		System.out.println("done");
		
		
	}
	
}
