
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class speadtest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		driver.get("https://www.speedtest.net");

	

		if (driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).isDisplayed()) {

			driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();

		}

		driver.findElement(By.xpath("//span[@class='start-text']")).click();

		

		WebElement download = driver
				.findElement(By.xpath("//span[@class='result-data-large number result-data-value download-speed']"));

		System.out.println(download.getText());

		WebElement upload = driver
				.findElement(By.xpath("//span[@class='result-data-large number result-data-value upload-speed']"));

		System.out.println(upload.getText());

	}

}
