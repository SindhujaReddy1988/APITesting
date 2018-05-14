import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://api.wunderground.com/api/99a8db9a0f3c2e31/forecast/geolookup/conditions/q/IL/Chicago.json");
		WebElement element = driver.findElement(By.xpath("//pre"));
		try {
			JSONObject jsonObject = new JSONObject(element.getText());
			JSONObject obj = (JSONObject) jsonObject.get("location");
			String stateCheck = obj.get("state").toString();
			//Assert.assertEquals(stateCheck, "IL"); if you use TestNg this statement works
			String cityCheck = obj.getString("city").toString();
			System.out.println(stateCheck);
			System.out.println(cityCheck);
			
		if(stateCheck.equals("IL") && cityCheck.equals("Chicago"))
		{
			System.out.println("Testcase Passed");
		}
		else
		{
			System.out.println("Testcase Failed");
		}	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
