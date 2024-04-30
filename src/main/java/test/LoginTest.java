package test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
@RunWith(Parameterized.class)
public class LoginTest {
	private String name,pw,role;
	  public LoginTest(String name, String pw, String role) {
			super();
			this.name = name;
			this.pw = pw;
			this.role = role;
		}
	  private static Object[][] loadDatasFromFile() {
			Object[][] datas=null;
			File file=new File("src/main/java/test/loginTestCase.csv");
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(file);
				br=new BufferedReader(fr);
				int count=0;
				String row=null;
				br.readLine();
				while(br.readLine()!=null) {
					count++;
				}
				br.close();
				fr=new FileReader(file);
				br=new BufferedReader(fr);
				datas=new Object[count][];
				int i=0;
				br.readLine();
				while((row=br.readLine())!=null) {
					String columns[]=row.split(",");
					datas[i]=new Object[columns.length];
					for(int j=0;j<columns.length-1;j++) {
						datas[i][j]=columns[j];
					}
					datas[i][columns.length-1]=columns[columns.length-1];
					i++;
				}
				br.close();
				fr.close();
				} catch(Exception e) {
				e.printStackTrace();
				}
				return datas;
	}
	@Parameters
	public static Collection<Object[]> getDatas() {
		return Arrays.asList(loadDatasFromFile());
	}
private WebDriver driver;
  @Before
  public void setUp() {
	  System.setProperty("webdriver.edge.driver", 
			  "src/main/java/test/msedgedriver.exe");
    driver = new EdgeDriver();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void login() throws InterruptedException {
    driver.get("http://localhost:8080/CookieShop/user_login.jsp");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    Thread.sleep(1000);
    driver.findElement(By.name("ue")).click();
    driver.findElement(By.name("ue")).sendKeys(name);
    Thread.sleep(1000);
    driver.findElement(By.name("password")).sendKeys(pw);
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".register-but > input")).click();
//    driver.findElement(By.name("name")).click();
//    {
//      Thread.sleep(2000);
//      String value = driver.findElement(By.name("name"))
//    		  .getAttribute("value");
//      assertThat(value, is(role));
//    }
    boolean bool=isJudgingElement(driver,By.name("name"));
	 assertTrue(bool);
    Thread.sleep(2000);
    driver.close();
  }
  
  public boolean isJudgingElement(WebDriver webDriver,By by) {
		try {
			String value=webDriver.findElement(by).getAttribute("value");
			if(value.equals(role)) return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
	}
}