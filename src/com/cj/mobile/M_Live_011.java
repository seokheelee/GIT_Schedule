package com.cj.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.URL;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cj.util.SmartProperties;

public class M_Live_011 {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	WebElement element = null;
	boolean setupSuccess = true;
	private String ID_1 = null;
	private String PW_1 = null;
	private String M_URL = null;

	/**
	 * 
	 * @author 이석희 
	 * Date : 2017-06-20  
	 * Subject : CJ Mall 운영  
	 * Name : M_Schedule_011  
	 * Scenario : CJmall > TV 쇼핑 > 편성표 > 상품선택 > 바로구매 > 로그인 > 주문서
	 * Assertion : 주문서 Text 체크
	 *   
	 */

	@Before
	public void setUp() throws Exception {

		SmartProperties sp = SmartProperties.getInstance();
		ID_1 = sp.getProperty("ID_1");
		PW_1 = sp.getProperty("PW_1");
		M_URL = sp.getProperty("M_URL");

		try {
			Thread.sleep(5000);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps = DesiredCapabilities.android();

			// device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LGF460S859d639d");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

			URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");

			System.out.println("Start driver.");
			driver = new AndroidDriver<WebElement>(appiumUrl, caps);

		} catch (Exception e) {
			try {
				Thread.sleep(5000);
				DesiredCapabilities caps = new DesiredCapabilities();
				caps = DesiredCapabilities.android();

				// device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LGF460S859d639d");
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

				URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");

				System.out.println("Start driver.");
				driver = new AndroidDriver<WebElement>(appiumUrl, caps);

			} catch (Exception e1) {
				{
					try {
						Thread.sleep(5000);
						DesiredCapabilities caps = new DesiredCapabilities();
						caps = DesiredCapabilities.android();

						// device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
						caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LGF460S859d639d");
						caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
						caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

						URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");

						System.out.println("Start driver.");
						driver = new AndroidDriver<WebElement>(appiumUrl, caps);

					} catch (Exception e2) {
						System.out.println("Session Creation failed.");
						e.printStackTrace();
						assertTrue(false);
						setupSuccess = false;
						return;
					}
				}
			}
		}
	}

	@Test
	public void m_schedule_001() throws Exception {
		driver.get(M_URL);
		
		boolean isExist1 = false;
		boolean isExist2 = false;
		boolean isExist3 = false;
		boolean isExist4 = false;
		boolean isExist5 = false;
		boolean isExist6 = false;
		boolean isExist7 = false;
		boolean isExist8 = false;
		boolean isExist9 = false;
		
		
		//알럿 발생확인
		isExist1 = existElement(driver, By.xpath(".//*[@id='notToday']/label"), "오늘 하루 보이지 않기");
		if (isExist1) {
			//오늘 하루 보지 않기 버튼 클릭
			driver.findElement(By.xpath(".//*[@id='notToday']/label")).click();
			System.out.println("오늘 하루 보지 않기 버튼 클릭");
			Thread.sleep(3000);
		} else {
			//알럿이 없는 경우
			System.out.println("알럿 없음 다음 내용 수행");
			Thread.sleep(3000);
		}
		
		// TV 쇼핑 이동
		driver.findElement(By.xpath(".//*[@id='_homeTab']/ul/li[1]/a/span")).click();
		System.out.println("TV 쇼핑 탭 클릭");
		Thread.sleep(3000);
		
        WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='osp_tab']/ul/li[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(searchBtn).build().perform();
        Thread.sleep(3000);
        
		// 편성표 보기 버튼 클릭
		driver.findElement(By.xpath(".//*[@id='liveNextItem']/div[1]/a")).click();
		System.out.println("편성표 보기 클릭");
		Thread.sleep(3000);
		
		// 오늘을 기준으로 +1 day 클릭
		driver.findElement(By.xpath(".//*[@id='scheduleDate']/div/ul/li[7]/a/span")).click();
		System.out.println("+1 day 클릭");
		Thread.sleep(3000);

		// n번째 상품 선택
		// 해당 상품이 편성표에 존재하는지 체크
		isExist2= existElement(driver, By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a"), "11번째 단일상품");
		isExist3 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li[1]/a"), "11번째 복수상품");;
		if (isExist2 && true) {
			System.out.println("편성표 존재 합니다. (단일상품) 계속 진행합니다.");
			WebElement searchBtn1 = driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(searchBtn1).perform();
			Thread.sleep(3000);
		} else {
			if (isExist3 && true) {
				System.out.println("편성표 존재 합니다. (복수상품) 계속 진행합니다.");
				WebElement searchBtn1 = driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li[1]/a"));
				Actions action1 = new Actions(driver);
				action1.moveToElement(searchBtn1).perform();
				Thread.sleep(3000);
			} else {
				System.out.println("더이상 상품이 존재하지 않습니다. 여기서 종료 합니다.");
				assertTrue(true);
				return;
			}
		}
		
		
		
		// 상담신청 체크 (단일상품)
		// 대표상품 가격란에 '상담신청상품' 체크 
		isExist4 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a/div[2]/div/span"), "단일 상담신청 상품");
		isExist5 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li[1]/a/div[2]/div[1]/div/span"), "복수 상담신청 상품");
		if (isExist4 && driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a/div[2]/div/span")).getText().equals("상담신청 상품")) {
			System.out.println("상담신청상품 입니다. (단일)");
			assertTrue(true);
			return;
		}
		else{
			// 상담신청 체크 (복수상품)
			// 대표상품 가격란에 '상담신청상품' 체크
			if (isExist5 && driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li[1]/a/div[2]/div[1]/div/span")).getText().equals("상담신청 상품")) {
				System.out.println("상담신청상품 입니다. (복수)");
				assertTrue(true);
				return;
			}
			// 상담신청 상품이 아닐경우 else 진행
			else {
				System.out.println("상담신청상품 아닙니다. 계속 진행");
				Thread.sleep(3000);
			}
		}
		
		// 대표상품 선택
		isExist6 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a"), "상품진입");
		if (isExist6) {
			//단일상품일경우 (보통 이 옵션으로 모두 선택됨)
			driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li/a")).click();
			System.out.println("대표상품 선택 (단일상품)");
			Thread.sleep(3000);
		} else {
			//복수상품일경우
			driver.findElement(By.xpath(".//*[@id='scheduleItem']/div[22]/ul/li[1]/a")).click();
			System.out.println("대표상품 선택 (복수상품)");
			Thread.sleep(3000);
		}

		// 주문가능여부 체크
		isExist7 = existElement(driver, By.xpath(".//*[@id='orderArea']/div[1]/a"), "주문가능여부 체크");
		// 매진상태 체크
		if (isExist7 && driver.findElement(By.xpath(".//*[@id='orderArea']/div[1]/a")).getText().equals("매진")) {
			System.out.println("매진된 상품입니다");
			assertTrue(true);
			return;
		}
		else{
			// 주문 가능한 상태가 아닐 경우 체크
			if (isExist7 && driver.findElement(By.xpath(".//*[@id='orderArea']/div[1]/a")).getText().equals("생방송 중 주문가능")) {
				System.out.println("주문 가능한 상태가 아닙니다");
				assertTrue(true);
				return;
			}
			// 주문가능할 경우 아래 내용 출력
			else {
				if (isExist7 && driver.findElement(By.xpath(".//*[@id='orderArea']/div[1]/a")).getText().equals("생방송 중 주문가능")){
					System.out.println("생방송 중 주문가능 상품 입니다.");
					assertTrue(true);
					return;
				}
				else {
					System.out.println("매진 상품 아님. 계속 진행");
					Thread.sleep(3000);	
				}
			}
		}
		
		//구매하기 버튼 클릭
		driver.findElement(By.linkText("구매하기")).click();
		System.out.println("구매하기 버튼 클릭");
		Thread.sleep(3000);
		
		isExist8 = existElement(driver, By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span"),"옵션버튼 체크");
		isExist9 = existElement(driver, By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/ul/li[1]/a/span[3]"),"옵션 매진 상태 체크");
		// 옵션버튼이 있는경우
		if (isExist8) {
			System.out.println("옵션이 존재 합니다.");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span")).click();
			System.out.println("옵션 버튼 클릭");
			
			// 옵션 매진 체크
			if (isExist9 && driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/ul/li[1]/a/span[3]")).getText().equals("매진")) {
				System.out.println("해당 옵션 매진 입니다. 여기서 종료 합니다.");
				assertTrue(true);
				return;
			} else {
				driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/ul/li[1]/a")).click();
				System.out.println("첫번째 옵션 선택");

				driver.findElement(By.linkText("바로구매")).click();
				System.out.println("바로구매 버튼 선택");
				Thread.sleep(3000);
			}
		}
		// 옵션버튼이 없는경우
		else{
			System.out.println("옵션이 존재 하지 않습니다.");
			Thread.sleep(1000);
			driver.findElement(By.linkText("바로구매")).click();
			System.out.println("바로구매 버튼 선택");
			Thread.sleep(3000);
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='id_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='id_input']")).sendKeys(ID_1);
		driver.findElement(By.xpath(".//*[@id='password_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='password_input']")).sendKeys(PW_1);
		
		// 가상키보드를 끄기위해 빈공간 클릭
		driver.findElement(By.xpath(".//*[@id='content']/div[1]/div[2]/fieldset/div[2]")).click();
		
		// 로그인 버튼 클릭
		driver.findElement(By.xpath(".//*[@id='loginSubmit']")).click();
		System.out.println("로그인 성공");
		
		Thread.sleep(7000);
		
		// 주문서 진입 확인
		if ("주문서".equals(driver.findElement(By.xpath(".//*[@id='header']/div/h1")).getText())) {
			System.out.println("주문서 확인 종료 합니다.");
			Thread.sleep(3000);
			assertTrue(true);
			return;
		} else {
			System.out.println("주문서 진입 안됨");
			Thread.sleep(3000);
			assertTrue(false);
			return;
		}
	
	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	public boolean existElement(WebDriver wd, By by, String meaning) {
		WebDriverWait wait = new WebDriverWait(wd, 2);
		// wait.ignoring(NoSuchElementException.class);

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (TimeoutException e) {

			System.out.println("[" + meaning + "] WebElement does not Exist. time out ");
			return false;
		}
		System.out.println("[" + meaning + "] WebElement Exist.");
		return true;
	}

}
