import org.omg.SendingContext.RunTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver extends Thread{

	private static WebDriver aDriver = null;
	private static boolean avoidRecursiveCall = false;


	public enum BrowserName{FIREFOX, GOOGLECHROME, OPERA, IE}

	public static BrowserName currentDriver;

	private static BrowserName useThisDriver = BrowserName.FIREFOX;

	public static void set(BrowserName aBrowser){
		useThisDriver = aBrowser;
	}

	public static WebDriver get() {
		if (aDriver == null) {

			switch (useThisDriver) {
			case FIREFOX:
				aDriver = new FirefoxDriver();
				currentDriver = BrowserName.FIREFOX;
				break;

			case OPERA:
				aDriver = new OperaDriver();
				currentDriver = BrowserName.OPERA;
				break;

			case IE:
				String currentUserDir = System.getProperty("user.dir");
				String IEDriverLocation = currentUserDir + "/drivers/iedriver_64/IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", IEDriverLocation);

				aDriver = new InternetExplorerDriver();
				currentDriver = BrowserName.IE;
				break;

			case GOOGLECHROME:
				String currentDir = System.getProperty("user.dir");
				String chromeDriverLocation = currentDir + "/drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

				aDriver = new ChromeDriver();
				currentDriver = BrowserName.GOOGLECHROME;
				break;
			}

			//If JVM failed shutdownHook should close the browser
			Runtime.getRuntime().addShutdownHook(
					new Thread(){
						public void run(){
							Driver.quit();
						}
					}
			);

		}else{
			try{
				if(aDriver.getWindowHandle()!=null){
				}
			}catch(Exception e){
				if(avoidRecursiveCall){
					throw new RuntimeException();
				}
			}
			quit();
			aDriver = null;
			avoidRecursiveCall = true;
			return get();
		}
		avoidRecursiveCall = false;
		return aDriver;
	}

	public static void quit(){
		if(aDriver != null){
			try{
				aDriver.quit();
				aDriver = null;
			}catch (Exception e){
				throw new RuntimeException();
			}
		}
	}
}
