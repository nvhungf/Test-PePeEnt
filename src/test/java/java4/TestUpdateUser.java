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

public class TestUpdateUser {
	WebDriver driver;
	String url = "http://localhost:8080/ASM.Poly/Login";
	String USER_NAME = "admin";
	String PASS_WORD = "admin";
	String USER_edit = "test2";
	String PASS_edit = "test123";
	String fullname_edit = "user_update_02";
	String email_edit = "user_update_04@gmail.com";
	String result_text="";
	String result_false = "UserName is not found!";
	By edit1 =  By.xpath("//*[@id=\"VideoList\"]/table/tbody/tr[3]/td[4]/a[1]");
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDate localDate = localDateTime.toLocalDate();
	String date = " " + localDate;
	Map<String, Object[]> testNGResult;
	HSSFWorkbook workbook;
	HSSFSheet sheet;

	
	
	 @Test(priority = 1)
	  public void TestUpdateUser_1 () {
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
				WebElement userlist = driver.findElement(By.id("VideoList-tab"));
				userlist.click();
				driver.findElement(edit1).click();
				WebElement username = driver.findElement(By.id("username"));
				username.clear();
				username.sendKeys(USER_edit);
				WebElement update = driver.findElement(By.id("update"));
				update.click();
				Thread.sleep(1000);
				WebElement result = driver.findElement(By.className("message"));
				 result_text = result.getText().trim();
				if (! result_text.contentEquals(result_false)) {
					testNGResult.put("1",
							new Object[] { "user_update_01", "Kiểm Tra chức năng sửa user",
									"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n" + "username_edit : " + USER_edit , "User is updated",
									"Fail", date });
				} else {
					testNGResult.put("1", new Object[] { "user_update_01", "Kiểm Tra chức năng sửa user",
							"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n" + "username_edit : " + USER_edit , "User is not updated", "Pass", date  });
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				testNGResult.put("1", new Object[] { "user_update_01", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
				Assert.assertTrue(false);
			}
		}

  @Test(priority = 2)
  public void TestUpdateUser_2 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement password = driver.findElement(By.id("password"));
			password.clear();
			password.sendKeys(PASS_edit);
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("2",
						new Object[] { "user_update_02", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n" + "password_edit : " + PASS_edit, "User is updated",
								"Pass", date });
			} else {
				testNGResult.put("2", new Object[] { "user_update_02", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "password_edit : " + PASS_edit, "User is not updated", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("2", new Object[] { "user_update_02", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 3)
  public void TestUpdateUser_3 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement fullname = driver.findElement(By.id("fullname"));
			fullname.clear();
			fullname.sendKeys(fullname_edit);
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("3",
						new Object[] { "user_update_03", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n" + "fullname_edit : " + fullname_edit, "User is updated",
								"Pass", date });
			} else {
				testNGResult.put("3", new Object[] { "user_update_03", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "fullname_edit : " + fullname_edit, "User is not updated", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("3", new Object[] { "user_update_03", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 4)
  public void TestUpdateUser_4 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			email.sendKeys(email_edit);
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("4",
						new Object[] { "user_update_04", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n" + "email_edit : " + email_edit, "User is updated",
								"Pass", date });
			} else {
				testNGResult.put("5", new Object[] { "user_update_04", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "email_edit : " + email_edit, "User is not updated", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("4", new Object[] { "user_update_04", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  
  @Test(priority = 5)
  public void TestUpdateUser_5 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement password = driver.findElement(By.id("password"));
			password.clear();
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("5",
						new Object[] { "user_update_05", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n", "User is updated",
								"Fail", date });
			} else {
				testNGResult.put("5", new Object[] { "user_update_05", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not updated", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("5", new Object[] { "user_update_05", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 6)
  public void TestUpdateUser_6 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement fullname = driver.findElement(By.id("fullname"));
			fullname.clear();
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("6",
						new Object[] { "user_update_06", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n", "User is updated",
								"Fail", date });
			} else {
				testNGResult.put("6", new Object[] { "user_update_06", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not updated", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("6", new Object[] { "user_update_06", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 7)
  public void TestUpdateUser_7 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("7",
						new Object[] { "user_update_07", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD + "\n", "User is updated",
								"Fail", date });
			} else {
				testNGResult.put("7", new Object[] { "user_update_07", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not updated", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("7", new Object[] { "user_update_07", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 8)
  public void TestUpdateUser_8 () {
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
			WebElement userlist = driver.findElement(By.id("VideoList-tab"));
			userlist.click();
			driver.findElement(edit1).click();
			WebElement username = driver.findElement(By.id("username"));
			username.clear();
			WebElement password = driver.findElement(By.id("password"));
			password.clear();
			WebElement fullname = driver.findElement(By.id("fullname"));
			fullname.clear();
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			WebElement update = driver.findElement(By.id("update"));
			update.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("8",
						new Object[] { "user_update_08", "Kiểm Tra chức năng sửa user",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is updated",
								"Fail", date });
			} else {
				testNGResult.put("8", new Object[] { "user_update_08", "Kiểm Tra chức năng sửa user",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not updated", "Pass", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("8", new Object[] { "user_update_08", "Kiểm Tra chức năng sửa user", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@BeforeClass
	public void suiteSetUp() {
		WebDriverManager.chromedriver().setup();
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Update User Result");
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
			FileOutputStream out = new FileOutputStream(new File("TestUpdateUserResultExcel.xls"));
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
