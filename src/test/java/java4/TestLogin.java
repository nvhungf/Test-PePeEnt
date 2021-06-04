package java4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	WebDriver driver;
	String url = "http://localhost:8080/ASM.Poly/Login";
	String USER_NAME_true = "admin";
	String PASS_WORD_true = "admin";
	String USER_NAME_false = "adminn";
	String PASS_WORD_false = "adminn";
	String result_text="";
	String result_false = "invalid username or password";
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDate localDate = localDateTime.toLocalDate();
	String date = " " + localDate;
	Map<String, Object[]> testNGResult;
	HSSFWorkbook workbook;
	HSSFSheet sheet;

	@Test(priority = 1)
	public void TestLogin_1() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("1",
						new Object[] { "login_01", "Kiểm Tra Login",
								"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_true, "Đăng Nhập Thành Công",
								"Pass", date });
			} else {
				testNGResult.put("1", new Object[] { "login_01", "Kiểm Tra Login",
						"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_true, "Đăng Nhập Thất Bại", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("2", new Object[] { "login_01", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void TestLogin_2() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("2",
						new Object[] { "login_02", "Kiểm Tra Login",
								"username: " + USER_NAME_true +"\n"+ "password: ",
								"Đăng Nhập Thành Công", "Fail", date  });
			} else {
				testNGResult.put("2",
						new Object[] { "login_02", "Kiểm Tra Login",
								"username: " + USER_NAME_true +"\n"+ "password: ", "Đăng Nhập Thất Bại",
								"Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("3", new Object[] { "login_02", "Test Loin", "Login", "Fail" });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 3)
	public void TestLogin_3() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if ( result_text.contentEquals(result_false)) {
				testNGResult.put("3",
						new Object[] { "login_03", "Kiểm Tra Login",
								"username: " +"\n"+ "password: " + PASS_WORD_true,
								"Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				testNGResult.put("3",
						new Object[] { "login_03", "Kiểm Tra Login",
								"username: " +"\n"+ "password: " + PASS_WORD_true, "Đăng Nhập Thành Công",
								"Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("3", new Object[] { "login_03", "Test Loin", "Login", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void TestLogin_4() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("4",
						new Object[] { "login_04", "Kiểm Tra Login",
								"username: " + "\n"+"password: ", "Đăng Nhập Thất Bại",
								"Pass", date  });
			} else {
				testNGResult.put("4", new Object[] { "login_04", "Kiểm Tra Login",
						"username: "+ "\n"+"password: ", "Đăng Nhập Thành Công", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("4", new Object[] { "login_04", "Test Loin", "Login", "Fail" });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 5)
	public void TestLogin_5() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_false);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("5", new Object[] { "login_05", "Kiểm Tra Login",
						"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_false, "Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				
				testNGResult.put("5",
						new Object[] { "login_05", "Kiểm Tra Login",
								"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_false, "Đăng Nhập Thành Công",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("5", new Object[] { "login_05", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 6)
	public void TestLogin_6() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_false);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("6", new Object[] { "login_06", "Kiểm Tra Login",
						"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_false, "Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				
				testNGResult.put("6",
						new Object[] { "login_06", "Kiểm Tra Login",
								"username: " + USER_NAME_true +"\n"+ "password: " + PASS_WORD_false, "Đăng Nhập Thành Công",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("6", new Object[] { "login_06", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 7)
	public void TestLogin_7() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("7", new Object[] { "login_07", "Kiểm Tra Login",
						 "password: " + PASS_WORD_true	 +"\n" + "username: " + USER_NAME_true , "Đăng Nhập Thành Công ", "Pass", date  });
			} else {
				
				testNGResult.put("7",
						new Object[] { "login_07", "Kiểm Tra Login",
								"password: " + PASS_WORD_true +"\n"+ "username: " + USER_NAME_true, "Đăng Nhập Thất Bại",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("7", new Object[] { "login_07", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 8)
	public void TestLogin_8() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement password = driver.findElement(By.id("username"));
			password.sendKeys(PASS_WORD_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("8", new Object[] { "login_08", "Kiểm Tra Login",
						"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true , "Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				
				testNGResult.put("8",
						new Object[] { "login_08", "Kiểm Tra Login",
								"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true, "Đăng Nhập Thành Công",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("8", new Object[] { "login_08", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 9)
	public void TestLogin_9() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("password"));
			username.sendKeys(USER_NAME_true);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("9", new Object[] { "login_09", "Kiểm Tra Login",
						"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true , "Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				
				testNGResult.put("9",
						new Object[] { "login_09", "Kiểm Tra Login",
								"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true, "Đăng Nhập Thành Công",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("9", new Object[] { "login_09", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 10)
	public void TestLogin_10() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(USER_NAME_true);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(PASS_WORD_true);
			WebElement username2 = driver.findElement(By.id("username"));
			username2.clear();
			WebElement password2 = driver.findElement(By.id("password"));
			password2.clear();
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (result_text.contentEquals(result_false)) {
				testNGResult.put("10", new Object[] { "login_10", "Kiểm Tra Login",
						"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true , "Đăng Nhập Thất Bại", "Pass", date  });
			} else {
				
				testNGResult.put("10",
						new Object[] { "login_10", "Kiểm Tra Login",
								"username: " + USER_NAME_true	 +"\n" + "password: " + PASS_WORD_true, "Đăng Nhập Thành Công",
								"Fail", date });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("10", new Object[] { "login_10", "Test Loin", "Login", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
	@BeforeClass
	public void suiteSetUp() {
		WebDriverManager.chromedriver().setup();
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Login Result");
		testNGResult = new LinkedHashMap<String, Object[]>();
		testNGResult.put("0", new Object[] { "ID", "Mô Tả", "Test Data", "Kết quả Thực Tế", "Trạng Thái", "Ngày Test" });
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("can't start web driver");
		}
	}

	@AfterClass
	public void afterClass() {
		Set<String> keyset = testNGResult.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = testNGResult.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("TestLoginResultExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}
}
