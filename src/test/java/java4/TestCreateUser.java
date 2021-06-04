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

public class TestCreateUser {
	WebDriver driver;
	String url = "http://localhost:8080/ASM.Poly/Login";
	String USER_NAME = "admin";
	String PASS_WORD = "admin";
	
	String user_tc1 = "test1";
	String pass_tc1 = "test1";
	String fullname_tc1 = "test1";
	String email_tc1 = "test1@gmail.com";
	
	String user_tc2 = "";
	String pass_tc2 = "test2";
	String fullname_tc2 = "test2";
	String email_tc2 = "test2@gmail.com";
	
	String user_tc3 = "test3";
	String pass_tc3 = "";
	String fullname_tc3 = "test3";
	String email_tc3 = "test3@gmail.com";
	
	String user_tc4 = "admin";
	String pass_tc4 = "test";
	String fullname_tc4 = "test";
	String email_tc4 = "test";
	
	String user_tc5 = "";
	String pass_tc5 = "";
	String fullname_tc5 = "";
	String email_tc5 = "";
	
	String user_tc6 = "test6";
	String pass_tc6 = "test6";
	String fullname_tc6 = "test6";
	String email_tc6 = "test6";
	
	String user_tc7 = "test 7";
	String pass_tc7 = "test7";
	String fullname_tc7 = "test7";
	String email_tc7  = "test7@gmail.com";
	
	String user_tc8 = "test8";
	String pass_tc8 = "test 8";
	String fullname_tc8 = "test8";
	String email_tc8 = "test8@gmail.com";
	
	String user_tc9 = "tést9";
	String pass_tc9 = "test9";
	String fullname_tc9 = "test9";
	String email_tc9 = "test9@gmail.com";
	
	String user_tc10 = "test10";
	String pass_tc10 = "tést 10";
	String fullname_tc10 = "test10";
	String email_tc10 = "test10@gmail.com";
	
	String result_text = "";
	String result_true = "User is inserted !!";
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDate localDate = localDateTime.toLocalDate();
	String date = " " + localDate;
	Map<String, Object[]> testNGResult;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	
  @Test(priority = 1)
  public void TestCreate_01() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc1);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc1);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc1);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc1);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("1",
						new Object[] { "user_insert_01", "Kiểm Tra Create User",
								"username: " + user_tc1 +"\n"+ " password: " + pass_tc1, "Thêm Thành Công",
								"Pass", date });
			} else {
				testNGResult.put("1", new Object[] { "user_insert_01", "Kiểm Tra Login",
						"username: " + user_tc1 +"\n"+ " password: " + pass_tc1, "Thêm Thất Bại", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("2", new Object[] { "user_insert_01", "Test Create User", "Create", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 2)
  public void TestCreate_02() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc2);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc2);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc2);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc2);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("2",
						new Object[] { "user_insert_02", "Kiểm Tra Create User",
								"username: " + user_tc2 +"\n"+ " password: " + pass_tc2, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("2", new Object[] { "user_insert_02", "Kiểm Tra Login",
						"username: " + user_tc2 +"\n"+ " password: " + pass_tc2, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("3", new Object[] { "user_insert_02", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 3)
  public void TestCreate_03() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc3);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc3);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc3);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc3);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("3",
						new Object[] { "user_insert_03", "Kiểm Tra Create User",
								"username: " + user_tc3 +"\n"+ " password: " + pass_tc3, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("3", new Object[] { "user_insert_03", "Kiểm Tra Create User",
						"username: " + user_tc3 +"\n"+ " password: " + pass_tc3, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("4", new Object[] { "user_insert_03", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 4)
  public void TestCreate_04() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc4);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc4);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc4);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc4);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("4",
						new Object[] { "user_insert_04", "Kiểm Tra Create User",
								"username: " + user_tc4 +"\n"+ " password: " + pass_tc4, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("4", new Object[] { "user_insert_04", "Kiểm Tra Create User",
						"username: " + user_tc4 +"\n"+ " password: " + pass_tc4, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("5", new Object[] { "user_insert_04", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}

  @Test(priority = 5)
  public void TestCreate_05() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("5",
						new Object[] { "user_insert_05", "Kiểm Tra Create User",
								"username: " + user_tc5 +"\n"+ " password: " + pass_tc5, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("5", new Object[] { "user_insert_05", "Kiểm Tra Create User",
						"username: " + user_tc5 +"\n"+ " password: " + pass_tc5, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("6", new Object[] { "user_insert_05", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 6)
  public void TestCreate_06() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc6);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc6);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc6);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc6);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("6",
						new Object[] { "user_insert_06", "Kiểm Tra Create User",
								"username: " + user_tc6 +"\n"+ " password: " + pass_tc6, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("6", new Object[] { "user_insert_06", "Kiểm Tra Create User",
						"username: " + user_tc6 +"\n"+ " password: " + pass_tc6, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("7", new Object[] { "user_insert_06", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 7)
  public void TestCreate_07() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc7);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc7);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc7);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc7);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("7",
						new Object[] { "user_insert_07", "Kiểm Tra Create User",
								"username: " + user_tc7 +"\n"+ " password: " + pass_tc7, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("7", new Object[] { "user_insert_07", "Kiểm Tra Create User",
						"username: " + user_tc7 +"\n"+ " password: " + pass_tc7, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("8", new Object[] { "user_insert_07", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 8)
  public void TestCreate_08() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc8);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc8);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc8);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc8);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("8",
						new Object[] { "user_insert_08", "Kiểm Tra Create User",
								"username: " + user_tc8 +"\n"+ " password: " + pass_tc8, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("8", new Object[] { "user_insert_08", "Kiểm Tra Create User",
						"username: " + user_tc8 +"\n"+ " password: " + pass_tc8, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("9", new Object[] { "user_insert_01", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 9)
  public void TestCreate_09() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc9);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc9);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc9);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc9);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("9",
						new Object[] { "user_insert_09", "Kiểm Tra Create User",
								"username: " + user_tc9 +"\n"+ " password: " + pass_tc9, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("9", new Object[] { "user_insert_09", "Kiểm Tra Create User",
						"username: " + user_tc9 +"\n"+ " password: " + pass_tc9, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("10", new Object[] { "user_insert_09", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 10)
  public void TestCreate_10() {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			WebElement usernamelogin = driver.findElement(By.id("username"));
			usernamelogin.sendKeys(USER_NAME);
			WebElement passwordlogin = driver.findElement(By.id("password"));
			passwordlogin.sendKeys(PASS_WORD);
			WebElement login = driver.findElement(By.className("btn-login"));
			login.click();
			WebElement admin = driver.findElement(By.id("admin"));
			admin.click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys(user_tc10);
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass_tc10);
			
			WebElement fullname = driver.findElement(By.name("fullname"));
			fullname.sendKeys(fullname_tc10);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email_tc10);
			WebElement create = driver.findElement(By.id("create"));
			create.click();
			Thread.sleep(2000);
			WebElement result = driver.findElement(By.className("message"));
			String result_text = result.getText().trim();
			System.out.print(result_text);
			if (result_text.contentEquals(result_true)) {
				testNGResult.put("10",
						new Object[] { "user_insert_10", "Kiểm Tra Create User",
								"username: " + user_tc10 +"\n"+ " password: " + pass_tc10, "Thêm Thành Công",
								"Fail", date });
			} else {
				testNGResult.put("10", new Object[] { "user_insert_10", "Kiểm Tra Create User",
						"username: " + user_tc10 +"\n"+ " password: " + pass_tc10, "Thêm Thất Bại", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("11", new Object[] { "user_insert_10", "Test Create User", "Create", "Pass", date  });
			Assert.assertTrue(false);
		}
	}
  
	@BeforeClass
	public void suiteSetUp() {
		WebDriverManager.chromedriver().setup();
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Create User Result");
		testNGResult = new LinkedHashMap<String, Object[]>();
		testNGResult.put("0", new Object[] { "Test ID", "Mô Tả", "Test Data", "Kết quả Thực Tế", "Trạng Thái", "Ngày Test" });
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
			FileOutputStream out = new FileOutputStream(new File("TestCreateUserResultExcel.xls"));
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
