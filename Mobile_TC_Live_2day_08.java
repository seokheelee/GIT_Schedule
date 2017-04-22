package com.cj.mobile;

import static org.junit.Assert.assertTrue;
import java.net.URL;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cj.util.SmartProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Mobile_TC_Live_2day_08 {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
 
  WebElement element = null;
    
  boolean setupSuccess = true;
  
  private String 	userId = null;
  private String 	passwd = null;
  private long 		waitTime = 50;
  private String 	videoPath = null;
  
  @Before
  public void setUp() throws Exception {
   
	  
	
	System.out.println("=====setUp start======");
	SmartProperties sp = SmartProperties.getInstance();
	 
	    
	userId 		= sp.getProperty("ID");
	passwd 		= sp.getProperty("PWD");
	waitTime 	= Long.parseLong(sp.getProperty("WaitTime"));
	videoPath 	= sp.getProperty("VIDEO_LOC");

	System.out.println("userId 	= "+userId);
	System.out.println("passwd 	= "+passwd);
	System.out.println("waitTime="+waitTime);
	System.out.println("videoPath = "+videoPath);
	    
	
	
	try
	{
		Thread.sleep(5000);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps = DesiredCapabilities. android ();
		
		
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LG-F160S-cdd1fa" );
		caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LGF460S859d639d" ); //device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME , MobilePlatform. ANDROID );
		caps.setCapability(MobileCapabilityType.BROWSER_NAME , "Chrome" );
		
		URL appiumUrl = new URL(    "http://127.0.0.1:4723/wd/hub" );
		
		System.out.println("Start driver.");
		driver = new AndroidDriver<WebElement>( appiumUrl , caps );
	
	
		/*
		driver = new FirefoxDriver();
	    baseUrl = "http://mw.cjmall.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    */
	}catch(Exception e)
	{
		try
		{
			Thread.sleep(5000);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps = DesiredCapabilities. android ();
			
			
			//caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LG-F160S-cdd1fa" );
			caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LGF460S859d639d" ); //device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME , MobilePlatform. ANDROID );
			caps.setCapability(MobileCapabilityType.BROWSER_NAME , "Chrome" );
			
			URL appiumUrl = new URL(    "http://127.0.0.1:4723/wd/hub" );
			
			System.out.println("Start driver.");
			driver = new AndroidDriver<WebElement>( appiumUrl , caps );
		
		
			/*
			driver = new FirefoxDriver();
		    baseUrl = "http://mw.cjmall.com";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    */
		}catch(Exception e1)
		{{
			try
			{
				Thread.sleep(5000);
				DesiredCapabilities caps = new DesiredCapabilities();
				caps = DesiredCapabilities. android ();
				
				
				//caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LG-F160S-cdd1fa" );
				caps.setCapability(MobileCapabilityType.DEVICE_NAME , "LGF460S859d639d" ); //device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME , MobilePlatform. ANDROID );
				caps.setCapability(MobileCapabilityType.BROWSER_NAME , "Chrome" );
				
				URL appiumUrl = new URL(    "http://127.0.0.1:4723/wd/hub" );
				
				System.out.println("Start driver.");
				driver = new AndroidDriver<WebElement>( appiumUrl , caps );
			
			
				/*
				driver = new FirefoxDriver();
			    baseUrl = "http://mw.cjmall.com";
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    */
			}catch(Exception e2)
			{
				System.out.println("Session Creation failed.");
				e.printStackTrace();
				assertTrue(false);
				setupSuccess = false;
				return;	
				} 
			}
		}
		}

	System.out.println("=====setUp end======");
	
	}
    
  @After
  public void tearDown() throws Exception {
    
	System.out.println("=====tearDown start======");
	
	if(setupSuccess)
		driver.quit();
   
	System.out.println("=====tearDown end======");
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
    
  public boolean existElement(WebDriver wd, By by, String meaning) 
  {
	  boolean ret = false;
	  WebElement element = null;
	  WebDriverWait wait = new WebDriverWait(wd, 2);
	 // wait.ignoring(NoSuchElementException.class); 
	  
	  try
	  {
		  wait.until(ExpectedConditions.presenceOfElementLocated(by));
	    
	  }catch (TimeoutException e)
	  {
		  
		  System.out.println("["+meaning+"] WebElement does not Exist. time out ");
		  return false;
	  }
	  System.out.println("["+meaning+"] WebElement Exist.");
	  return true;
  } 
   
  /**
   * @author JungmookOh 
   * Date : 2016-06-09
   * Subject : CJ Mall
   * Scenario : 오클락딜 > 편성표 > 금일 기준  +2 day 생방송 상품 자동화
   * Assertion : 구매하기 선택하여 주문서 작성으로 이동
   * History : 2016-06-13 : 옵션 선택이 2개 이상인 경우, 종료 처리
   * History : 2016-07-28 : 미리주문 -> 바로구매 관련 수정
   * History : 2016-12-28 : 로그인 path 수정
   * 
  **/
    

  /* 
   * day : +2
   * time : 8
  */
  
  @Test
  public void LiveDay_02_08() throws Exception {
	
	boolean isExist = false;
	WebDriverWait wait	=	null;
	int list, list1, list2, a;
	a = 8;

	System.out.println("=====TestCase Start======");
	
	if(!setupSuccess) {
		System.out.println("Setup failed. So this TestCase is stopped now.");
		assertTrue(true);
		return;
	}
	
	try {
	    int window_num = 0;
	    
	    driver.get("http://mw.cjmall.com/m/main.jsp");
	
	    String mainWindow = driver.getWindowHandle();
	    System.out.println("main Windows ="+mainWindow);
	    
	    Set<String> handles = driver.getWindowHandles();  
	    window_num = handles.size();
	    
	    System.out.println("Windows Num ="+window_num);
	    for (String handle : handles) {
	    	System.out.println("windows handles :"+handle);
	        if (!handle.equals(mainWindow)){
	            driver.switchTo().window(handle);
	            System.out.println("Switch Windows");
	            break;
	        }
	    }
	    
	    System.out.println("Windows Num ="+window_num);
	   
	    //팝업창이 뜨는데도 1로 나타는 경우가 있음.
	    if(window_num > 1) {
	    	System.out.println("팝업창 뜸. 팝업창 Element는 일관성 없음.");
	    	
	    	Thread.sleep(3000);
	    	return;
		 /*
	      	//오늘 하루 안보기 체크박스 선택    	
	    	element = driver.findElement(By.xpath(".//*[@id='ct']/div/div[1]/div/div/div/a[1]"));
	    	element.click();
	    */	    	                        
	    }
	    Thread.sleep(3000);
	    //팝업창이 존재하면...  팝업창이 떠도 위와 같이 1로 리턴하는 경우가 있음.
	    isExist = existElement(driver,By.xpath(".//*[@id='ct']/div/div[1]/div/div/div/a[1]"),"팝업창");
	  	if(isExist) {
	  		element = driver.findElement(By.xpath(".//*[@id='ct']/div/div[1]/div/div/div/a[1]"));
	  		element.click();
	  	}
    	
		////
		//// 1. 사이드 메뉴 기다림.
	  	wait = new WebDriverWait(driver, waitTime);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='o1h_header_wrap']/dl/dt/a")));
	     
	    element = driver.findElement(By.xpath(".//*[@id='o1h_header_wrap']/dl/dt/a"));
	    element.click();
	    
	    //// 2. 로그인 화면 기다림.
	    wait = new WebDriverWait(driver, waitTime);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='wrapper_cate_left']/dl/dt/a")));
	  	 
	    element = driver.findElement(By.xpath(".//*[@id='wrapper_cate_left']/dl/dt/a"));
	    element.click();
	    
	    
	    //// 2-1. ID 객체 기다림.
	    wait = new WebDriverWait(driver, waitTime);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='member_id']")));
	  	 
	  	 
	    element = driver.findElement(By.xpath(".//*[@id='member_id']"));
	    element.sendKeys(userId);
	    
	    element = driver.findElement(By.xpath(".//*[@id='pwd']"));
	    element.sendKeys(passwd);
	    
	    element = driver.findElement(By.xpath(".//*[@id='loginForm']/input[5]"));
	    element.click();
	    	
	  	Thread.sleep(3000);
	  	
	    // 편성표 뜰 때까지 기다림
	  	wait = new WebDriverWait(driver, waitTime);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ct']/div/div[6]/ul/li[2]/a")));
	  	System.out.println("편성표 뜰 때까지 기다림");
	  	
	  	isExist = existElement(driver,By.xpath(".//*[@id='ct']/div/div[4]/div/div[1]/span[1]"),"onair");
	  	if(isExist) {
	  		Point hoverItem = driver.findElement(By.xpath(".//*[@id='ct']/div/div[4]/div/a/div[1]/img")).getLocation();
	  		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
		  	System.out.println("생방송 객체로 스크롤 이동");
		  	
		  	element = driver.findElement(By.xpath(".//*[@id='ct']/div/div[6]/ul/li[2]/a"));
		    element.click();
		    System.out.println("편성표 선택");
		    
	  	}
	  	else {
		  	element = driver.findElement(By.xpath(".//*[@id='ct']/div/div[6]/ul/li[2]/a"));
		    element.click();
		    System.out.println("편성표 선택");
		    
	  	}
/*		// 생방송 객체로 스크롤 이동, 스크롤 아래로 이동 목적
		Point hoverItem = driver.findElement(By.xpath(".//*[@id='ct']/div/div[4]/div/a/div[1]/img")).getLocation();
	  	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
	  	System.out.println("생방송 객체로 스크롤 이동");
	  	
	  	// 편성표 선택
	  	element = driver.findElement(By.xpath(".//*[@id='ct']/div/div[6]/ul/li[2]/a"));
	    element.click();
	    System.out.println("편성표 선택");
	*/    
	    // 편성표 마지막 날짜의 상품목록 기다림
	    wait = new WebDriverWait(driver, waitTime);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[11]")));
	  	System.out.println("편성표 마지막 날짜의 상품목록 기다림");
	  	
	  	Thread.sleep(5000);
	  	
	  	// +2 day 클릭	  	
	    driver.findElement(By.xpath(".//*[@id='htmlStr']/li[8]/a")).click();
	    Thread.sleep(10000);
	    element = driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[1]/div"));
	    System.out.println("+2 day 클릭  = " + element.getText());
	    
	    // +2 day에 편성된 방송 수 카운트
	    list = driver.findElements(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li/div/div/span[1]")).size();
	    System.out.println(element.getText() + ": 방송 편성 수  = " + list);
	    
	    // TC no.가 방송 수보다 적을 경우 테스트 수행, 아니면 바로 종료
	    if(list < a) {
	    	System.out.println("TC_day_2_"+a+": 해당하는 시간 구간의 상품이 존재하지 않음. 여기서 종료합니다");
	    	assertTrue(true);
	    	return;
	    }
	    else {
	    	// "ul[]/li[]" 값 수정
	    	System.out.println(a + " 번째 상품: " + driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[9]/div/div/span[1]")).getText()
	    			+ " 시간대 상품 확인");
	    }
	   	    
	    // 방송 시간대별 상품이 몇개인지 확인. 1개/2개 이상일 경우 각각 xpath 가 다름. "ul[]/li[]" 값 수정
	    list1 = driver.findElements(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[9]/ul/li/a/div[1]/img")).size();
	    System.out.println("현재 시간의 방송 상품 수  = " + list1);
	    
	    if(list1 < 2) {
	    	// 방송 시간대 상품이 1개인 경우. "ul[]/li[]" 값 수정	 	
	    	driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[9]/ul/li/a/div[1]/img")).click();
	    	System.out.println("1번째 상품 선택");
	    	
	    	// 페이지 뜰 때까지 기다림
	    	wait = new WebDriverWait(driver, waitTime);
		  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='o1h_header_wrap']/div/span")));
		  	System.out.println("페이지 뜰 때까지 기다림");
		  	Thread.sleep(5000);
		  	
		  	// "보험/금융" 상품인지 확인
		  	if(driver.findElement(By.xpath(".//*[@id='o1h_header_wrap']/div/span")).getText().equals("보험/금융")){
		  		System.out.println("'보험/금융' 상품. 여기서 종료합니다");
		  		assertTrue(true);
		  		return;
		  	}
		  	
		  	// 구매하기 버튼 기다림
		  	wait = new WebDriverWait(driver, waitTime);
	  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='orderArea']/div[1]/a")));
	        System.out.println("구매하기 버튼 기다림");
	  	
	        element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[1]/a"));
	  	
	        // "보험/금융" 상품은 아니나 구매하기 대신 "상담신청" or "비교상품" or "생방송 중 주문 가능" 인 경우 처리
	        if(element.getText().equals("상담신청") || element.getText().equals("비교상품") || element.getText().equals("생방송 중 주문가능")) {
	        	System.out.println("'"+element.getText()+"'"+" 상품, 여기서 종료합니다");
	  		    assertTrue(true);
	  		    return;
	        }
	        	          
	        // 구매하기 버튼 클릭
	        element.click();
	        System.out.println("구매하기 버튼 클릭");
	        
	    	wait = new WebDriverWait(driver, waitTime);
		  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a")));
		  	System.out.println("장바구니, 바로구매 객체 뜰 때까지 기다림");
	        
	        // 여행 상품 등 방송 시작전에 구매불가(매진)인 상품 처리 
	        element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a"));
	        if(element.getText().equals("현재 주문가능한 상태가 아닙니다.") || element.getText().equals("준비한 모든 상품이 매진입니다")) {
	        	System.out.println(element.getText() + " 여기서 종료합니다");
	        	assertTrue(true);
	  		    return;
	        }
	        
	        //옵션 드롭다운 박스 개수 확인
	        list2 = driver.findElements(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span")).size();
	        System.out.println("옵션 드롭다운 박스 개수 : " + list2);
	        
	        //단일 옵션
	        if(list2<=1){
	        	isExist = existElement(driver,By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span"),"단일 옵션");
			    if(isExist) {
			    	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span"));
			    	element.click();
			    	 
			    	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/div[2]/div/ul/li[1]/a/span"));
			    	// 매진 여부 체크
			    	System.out.println(element.getText());
			    	 
			    	if(element.getText().indexOf("매진") >=0) {
			    		System.out.println("매진 상풉입니다.. 여기서 종료합니다.["+element.getText()+"]");
			    		assertTrue(true);
			    		Thread.sleep(3000);
			    		return;
			    		}
			    	element.click();
			    	 
			    	// 일부 화면은 장바구니가 없고 바로구매만 나오는 경우가 있음.
				   	// 그래서 정확히 하려면 2개인지 1개인지 판단하여 2개짜리면 2번째 클릭, 1개짜리면  1번 클릭하도록 수정 필요
				    element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a"));
				    if(element.getText().equals("바로구매")) {
				    	System.out.println("'바로구매'이 1번째 버튼에 존재함-1");
				    	element.click();
				    }
				    	
				   	else {
				   		System.out.println("'바로구매'이 2번째 버튼에 존재함-1");
				   		element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span[2]/a"));
				   		element.click();
				   	}
				    	
			    }
			    
			    else {
			    	// 일부 화면은 장바구니가 없고 바로구매만 나오는 경우가 있음.
			    	// 그래서 정확히 하려면 2개인지 1개인지 판단하여 2개짜리면 2번째 클릭, 1개짜리면  1번 클릭하도록 수정 필요
			       	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a"));
			    	
			       	if(element.getText().equals("바로구매")) {
			    		System.out.println("'바로구매'이 1번째 버튼에 존재함-2");
			    		element.click();
			    	}
			    	
			    	else {
			    		System.out.println("'바로구매'이 2번째 버튼에 존재함-2");
			    		element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span[2]/a"));
			    		element.click();
			    	}
			    }
			    
			    Thread.sleep(5000);
			    
			    // 바로구매 + 사은품 지급 상품 중 사은품 수량 부족으로 주문이 안되고 얼럿 발생하는 경우가 있음		    
			    if (isAlertPresent()) {
					System.out.println("팝업창 뜸  여기서 종료합니다 '" + driver.switchTo().alert().getText() + "'");
					Thread.sleep(3000);
					assertTrue(true);
					return;
			    }
			    
			  	// 6. 결제하기 버튼 기다림.
				if (driver.getTitle().equals("주문서 - CJmall")) {
					System.out.println("타이틀 '주문서 - CJmall' 확인");
					assertTrue(true);
					} 
				else {
					if (driver.getTitle().equals("주문서 작성")) {
			    	System.out.println("타이틀 '주문서 작성' 확인");
					assertTrue(true);
					}
					else {
					System.out.println("결제하기 버튼 없음");
					assertTrue(false);
					}
					}
	        }
	        
	        else{
	        	System.out.println("복수 옵션 상품으로 종료합니다");
				Thread.sleep(3000);
				assertTrue(true);
				return;
	        }
	        }
	    
	    else {
	    	//방송 시간대 상품이 2개 이상 경우. "ul[]/li[]" 값 수정	    	
	    	driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[9]/ul/li[1]/a/div[1]/img")).click();
	    	System.out.println("1번째 상품 선택");
	    	
	    	// 페이지 뜰 때까지 기다림
	    	wait = new WebDriverWait(driver, waitTime);
		  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='o1h_header_wrap']/div/span")));
		  	System.out.println("페이지 뜰 때까지 기다림");
		  	Thread.sleep(5000);
		  	
		  	//"보험/금융" 상품인지 확인
		  	if(driver.findElement(By.xpath(".//*[@id='o1h_header_wrap']/div/span")).getText().equals("보험/금융")) {
		  		System.out.println("'보험/금융' 상품 , 여기서 종료합니다");
		  		assertTrue(true);
		  		return;
		  	}
		  	
		    // 구매하기 버튼 기다림
		  	wait = new WebDriverWait(driver, waitTime);
	  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='orderArea']/div[1]/a")));
	        System.out.println("구매하기 버튼 기다림");
	  	
	        element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[1]/a"));
	  	
	        // "보험/금융" 상품은 아니나 구매하기 대신 "상담신청" or "비교상품" or "생방송 중 주문 가능" 인 경우 처리
	        if(element.getText().equals("상담신청") || element.getText().equals("비교상품") || element.getText().equals("생방송 중 주문가능")) {
	        	System.out.println("'"+element.getText()+"'"+" 상품, 여기서 종료합니다");
	  		    assertTrue(true);
	  		    return;
	        }
	        	          
	        // 구매하기 버튼 클릭
	        element.click();
	        System.out.println("구매하기 버튼 클릭");
	        
	    	wait = new WebDriverWait(driver, waitTime);
		  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a")));
		  	System.out.println("장바구니, 바로구매 객체 뜰 때까지 기다림");
	        
	        // 여행 상품 등 방송 시작전에 구매불가(매진)인 상품 처리 
	        element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a"));
	        if(element.getText().equals("현재 주문가능한 상태가 아닙니다.") || element.getText().equals("준비한 모든 상품이 매진입니다")){
	        	System.out.println(element.getText() + " 여기서 종료합니다");
	        	assertTrue(true);
	  		    return;	        
	        }
	        
	        //옵션 드롭다운 박스 개수 확인
	        list2 = driver.findElements(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span")).size();
	        System.out.println("옵션 드롭다운 박스 개수 : " + list2);
	        
	      //단일 옵션
	        if(list2<=1){
	        	isExist = existElement(driver,By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span"),"단일 옵션");
			    if(isExist) {
			    	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/span"));
			    	element.click();

			    	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[1]/div/div/div[1]/div/div[2]/div/ul/li[1]/a/span"));
			    	//매진 여부 체크
			    	System.out.println(element.getText());

			    	if(element.getText().indexOf("매진") >=0) {

			    		System.out.println("매진 상풉입니다.. 여기서 종료합니다.["+element.getText()+"]");
			    		assertTrue(true);
			    		Thread.sleep(3000);
			    		return;
			    		}
			    	element.click();
			    	
			    	// 일부 화면은 장바구니가 없고 바로구매만 나오는 경우가 있음.
				   	// 그래서 정확히 하려면 2개인지 1개인지 판단하여 2개짜리면 2번째 클릭, 1개짜리면  1번 클릭하도록 수정 필요
				    element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span/a"));
				    if(element.getText().equals("바로구매")) {
				    	System.out.println("'바로구매'이 1번째 버튼에 존재함-1");
				    	element.click();
				    }
				    	
				   	else {
				   		System.out.println("'바로구매'이 2번째 버튼에 존재함-1");
				   		element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span[2]/a"));
				   		element.click();
				   	}
			    }
			    
			    else {
			    	// 일부 화면은 장바구니가 없고 바로구매만 나오는 경우가 있음.
			    	// 그래서 정확히 하려면 2개인지 1개인지 판단하여 2개짜리면 2번째 클릭, 1개짜리면  1번 클릭하도록 수정 필요
			       	element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span[1]/a"));

			       	if(element.getText().equals("바로구매")) {
			       		System.out.println("'바로구매'이 1번째 버튼에 존재함-2");
			    		element.click();
			    	}
			    	
			    	else {
			    		System.out.println("'바로구매'이 2번째 버튼에 존재함-2");
			    		element = driver.findElement(By.xpath(".//*[@id='orderArea']/div[2]/div[2]/div[2]/span[2]/a"));
			    		element.click();
			    		}
			       	}
			    
			    Thread.sleep(5000);
			    
			    // 바로구매 + 사은품 지급 상품 중 사은품 수량 부족으로 주문이 안되고 얼럿 발생하는 경우가 있음		    
			    if (isAlertPresent()) {
					System.out.println("팝업창 뜸  여기서 종료합니다 '" + driver.switchTo().alert().getText() + "'");
					Thread.sleep(3000);
					assertTrue(true);
					return;
			    }
			    
			  	// 6. 결제하기 버튼 기다림.
				if (driver.getTitle().equals("주문서 - CJmall")) {
					System.out.println("타이틀 '주문서 - CJmall' 확인");
					assertTrue(true);
					} 
				else {
					if (driver.getTitle().equals("주문서 작성")) {
			    	System.out.println("타이틀 '주문서 작성' 확인");
					assertTrue(true);
					}
					else {
					System.out.println("결제하기 버튼 없음");
					assertTrue(false);
					}
					}
	        }
	        
	        else{
	        	System.out.println("복수 옵션 상품으로 종료합니다");
				Thread.sleep(3000);
				assertTrue(true);
				return;
	        }
	        }		    
	    }
	catch(Exception e) {
		e.printStackTrace();
		assertTrue(false);
		}
	finally {
		Thread.sleep(3000);
		System.out.println("=====TestCase end======");
		}
	}
}


/*
//시간 별 첫번째 상품 선택 for문 
for(a=2; a<list + 1; a++)
{
	System.out.println(a + "번째 방송 상품을 확인합니다");
	isExist4 = existElement(driver,By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li[1]/a/div[1]/img"),"");
	isExist5 = existElement(driver,By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li/a/div[1]/img"),"");
	if(isExist4 || isExist5 == false)
  	{
  		if(isExist4 = true){
  			
  			//첫번째 
  			driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li[1]/a/div[1]/img")).click();
	  			
  			if(driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li/a/div[2]")).getTagName().equals("상담신청 상품"))
  			System.out.println("상담신청 상품이므로 다음 상품으로 이동");
  			}
  		
  		    else{
  		    	driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li/a/div[1]/img")).click();
  		    	System.out.println("상품 선택");
  		    }
  	}
  		
  		else if(isExist5 = true){
  			if(driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li[1]/a/div[2]/strong")).getText().equals("상담신청 상품"))
	  			System.out.println("상담신청 상품이므로 다음 상품으로 이동");
	  			}
	  		
	  		    else{
	  		    	driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[" + a + "]/ul/li[1]/a/div[1]/img")).click();
	  		    	System.out.println("상품 선택");
	  		    }
  		}
}    	  	
	상품 위치로 스크롤 이동
	Point hoverItem = driver.findElement(By.xpath(".//*[@id='o1h_center']/div/div[3]/ul[8]/li[22]/ul/li[1]/a/div[1]/img")).getLocation();
	
	((JavascriptExecutor)driver).executeScript("window.scrollBy("+(hoverItem.getX())+ ",0);");
	
	Thread.sleep(10000);  	
	
	System.out.println("상품 위치로 스크롤 이동" + driver.findElement(By.xpath(".//*[@id='htmlStr']/li[11]/a")).getLocation());
	*/

