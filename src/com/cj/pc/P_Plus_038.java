package com.cj.pc;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cj.util.SmartProperties;


/**
 ** 
 ** @author 이석희
 **  Date : 2017-07-12
 ** Subject : CJ Mall 운영 
 ** Name : PC 편성표 자동화 038
 ** Scenario : CJmall > TV 쇼핑 > 편성표 > 상품선택 > 바로구매 > 로그인 > 주문서 
 ** Assertion : 주문서 Text 체크
 ** +1day 38
 **
 **/

public class P_Plus_038 {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private String ID_1 = null;
	private String PW_1 = null;
	private String P_URL = null;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		SmartProperties sp = SmartProperties.getInstance();
		ID_1 = sp.getProperty("ID_1");
		PW_1 = sp.getProperty("PW_1");
		P_URL = sp.getProperty("P_URL");

	}

	@Test
	public void p_schedule_038() throws Exception {
		boolean isExist1 = false;
		boolean isExist2 = false;
		boolean isExist3 = false;
		boolean isExist4 = false;
		boolean isExist5 = false;
		boolean isExist6 = false;
		boolean isExist7 = false;
		boolean isExist8 = false;

		// CJ 오쇼핑 메인 페이지 호출
		driver.get(P_URL);
		
		// TV 쇼핑 버튼 클릭
		driver.findElement(By.xpath(".//*[@id='header']/div[1]/div[4]/div[1]/ul/li[1]/a/span")).click();
		System.out.println("TV 쇼핑 버튼 클릭");
		
		// 오쇼핑 플러스 선택
		driver.findElement(By.xpath(".//*[@id='btnPlus']")).click();
		System.out.println("오쇼핑 플러스 버튼 클릭");
		Thread.sleep(3000);
		
		// 편성표 버튼 클릭
		driver.findElement(By.xpath(".//*[@id='plusMenu']/ul/li[2]/a")).click();
		System.out.println("편성표 버튼 클릭");
		
		// 일자 선택
		driver.findElement(By.xpath(".//*[@id='scheduleDate']/li[7]/a/span[1]")).click();
		System.out.println("+1 day 버튼 클릭");
		Thread.sleep(3000);
		
		// 해당 상품이 편성표에 존재하는지 체크
		isExist1 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/ul[38]/li/a[1]"), "38번째 단일상품");
		isExist2 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/ul[38]/li[1]/a[1]"), "38번째 복수상품");;
		if (isExist1 && true) {
			System.out.println("편성표 존재 합니다. (단일상품) 계속 진행합니다.");
			WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li/a[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(searchBtn).perform();
			Thread.sleep(3000);
		} else {
			if (isExist2 && true) {
				System.out.println("편성표 존재 합니다. (복수상품) 계속 진행합니다.");
				WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li[1]/a[1]"));
				Actions action = new Actions(driver);
				action.moveToElement(searchBtn).perform();
				Thread.sleep(3000);
			} else {
				System.out.println("더이상 상품이 존재하지 않습니다. 여기서 종료 합니다.");
				assertTrue(true);
				return;
			}
		}
		
		// 상담신청 체크 (단일상품)
		// 대표상품 가격란에 '상담신청상품' 체크 
		isExist3 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/ul[38]/li/div/div/span"), "단일 상담신청 상품");
		isExist4 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/ul[38]/li[1]/div/div/span"), "복수 상담신청 상품");
		if (isExist3 && driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li/div/div/span")).getText().equals("상담신청상품")) {
			System.out.println("상담신청상품 입니다. (단일)");
			assertTrue(true);
			return;
		}
		else{
			// 상담신청 체크 (복수상품)
			// 대표상품 가격란에 '상담신청상품' 체크
			if (isExist4 && driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li[1]/div/div/span")).getText()
					.equals("상담신청상품")) {
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
		isExist5 = existElement(driver, By.xpath(".//*[@id='scheduleItem']/ul[38]/li/a[1]"), "상품진입");
		if (isExist5) {
			//복수상품일경우 (보통 이 옵션으로 모두 선택됨)
			driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li[1]/a[1]")).click();
			System.out.println("대표상품 선택 (복수상품)");
			Thread.sleep(3000);
		} else {
			//단일상품일경우
			driver.findElement(By.xpath(".//*[@id='scheduleItem']/ul[38]/li/a[1]")).click();
			System.out.println("대표상품 선택 (단일상품)");
			Thread.sleep(3000);
		}
		
		// 주문가능여부 체크
		isExist6 = existElement(driver, By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[3]/div[2]/a"), "주문가능여부 체크");
		// 매진상태 체크
		if (isExist6 && driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[3]/div[2]/a")).getText().equals("매진")) {
			System.out.println("매진된 상품입니다");
			assertTrue(true);
			return;
		}
		else{
			// 주문 가능한 상태가 아닐 경우 체크
			if (isExist6 && driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[3]/div[2]/a")).getText().equals("주문 가능한 상태가 아닙니다")) {
				System.out.println("주문 가능한 상태가 아닙니다");
				assertTrue(true);
				return;
			}
			// 주문가능할 경우 아래 내용 출력
			else {
				if (isExist6 && driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[3]/div[2]/a")).getText().equals("생방송 중 주문가능")){
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
		
		// 옵션 유무 체크
		isExist7 = existElement(driver, By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/a"), "옵션버튼 체크");
		isExist8 = existElement(driver, By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/div/ul/li[1]/a/div/span[3]"), "옵션 매진 상태 체크");
		if (isExist7) {
			System.out.println("옵션이 존재 합니다.");
			Thread.sleep(3000);

			driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/a")).click();
			System.out.println("옵션 버튼 클릭");
			Thread.sleep(3000);
			
			// 옵션 매진 체크
			if (isExist8 && driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/div/ul/li[1]/a/div/span[3]")).getText().equals("매진")) {
				System.out.println("해당 옵션 매진 입니다. 여기서 종료 합니다.");
				assertTrue(true);
				return;
			} else {
				driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/div/ul/li[1]/a/div")).click();
				System.out.println("첫번째 옵션 선택");

				driver.findElement(By.linkText("바로구매")).click();
				System.out.println("바로구매 버튼 선택");
				Thread.sleep(3000);
			}
		}
		// 옵션이 없는 단일 상품일 경우 아래 else 진행
		else{
			// 장바구니 존재 유무 없이 By.linkText("바로구매") 로 체크됨
			System.out.println("단일 상품 확인");
			driver.findElement(By.linkText("바로구매")).click();
		}

		// 로그인 처리
		driver.findElement(By.xpath("//*[@id='id_input']")).clear();
		driver.findElement(By.xpath("//*[@id='id_input']")).sendKeys(ID_1);
		driver.findElement(By.xpath(".//*[@id='password_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='password_input']")).sendKeys(PW_1);
		driver.findElement(By.xpath(".//*[@id='loginSubmit']")).click();
		System.out.println("로그인 성공");
		Thread.sleep(5000);

		// 주문서 진입 확인
		if ("주문서".equals(driver.findElement(By.xpath(".//*[@id='wrap_order']/h2")).getText())) {
			System.out.println("주문서 확인 종료 합니다.");
			assertTrue(true);
			return;
		} else {
			System.out.println("주문서 진입 안됨");
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
