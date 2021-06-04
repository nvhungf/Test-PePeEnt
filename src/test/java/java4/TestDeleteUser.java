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

public class TestDeleteUser {
	WebDriver driver;
	String url = "http://localhost:8080/ASM.Poly/Login";
	String USER_NAME = "admin";
	String PASS_WORD = "admin";
	String result_text="";
	String result_false = "UserName is not found!";
	By delete =  By.xpath("//*[@id=\"VideoList\"]/table/tbody/tr[2]/td[4]/a[2]");
	By edit =  By.xpath("//*[@id=\"VideoList\"]/table/tbody/tr[3]/td[4]/a[1]");
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDate localDate = localDateTime.toLocalDate();
	String date = " " + localDate;
	Map<String, Object[]> testNGResult;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
  @Test(priority = 1)
  public void TestDeleteUser_1 () {
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
			driver.findElement(delete).click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("1",
						new Object[] { "user_delete_01", "Kiểm tra chức năng xóa user\n"
								+ "",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD  , "User is deleted",
								"Pass", date });
			} else {
				testNGResult.put("1", new Object[] { "user_delete_01", "Kiểm tra chức năng xóa user\n"
						+ "",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not deleted", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("1", new Object[] { "user_delete_01", "Kiểm tra chức năng xóa user\n"
					+ "", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 2)
  public void TestDeleteUser_2 () {
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
			driver.findElement(edit).click();
			WebElement delete = driver.findElement(By.id("delete"));
			delete.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("2",
						new Object[] { "user_delete_02", "Kiểm tra chức năng xóa user\n"
								+ "",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD  , "User is deleted",
								"Pass", date });
			} else {
				testNGResult.put("2", new Object[] { "user_delete_02", "Kiểm tra chức năng xóa user\n"
						+ "",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not deleted", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("2", new Object[] { "user_delete_02", "Kiểm tra chức năng xóa user\n"
					+ "", "Update", "Fail" });
			Assert.assertTrue(false);
		}
	}
  @Test(priority = 3)
  public void TestDeleteUser_3 () {
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
			WebElement delete = driver.findElement(By.id("delete"));
			delete.click();
			Thread.sleep(1000);
			WebElement result = driver.findElement(By.className("message"));
			 result_text = result.getText().trim();
			if (! result_text.contentEquals(result_false)) {
				testNGResult.put("3",
						new Object[] { "user_delete_03", "Kiểm tra chức năng xóa user\n"
								+ "",
								"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD  , "User is deleted",
								"Pass", date });
			} else {
				testNGResult.put("3", new Object[] { "user_delete_03", "Kiểm tra chức năng xóa user\n"
						+ "",
						"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , "User is not deleted", "Fail", date  });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testNGResult.put("3", new Object[] { "user_delete_03", "Kiểm tra chức năng xóa user", 
					"username: " + USER_NAME +"\n"+ "password: " + PASS_WORD , " ", "Fail", date  });
			Assert.assertTrue(false);
		}
	}
  @BeforeClass
	public void suiteSetUp() {
		WebDriverManager.chromedriver().setup();
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Delete User Result");
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
			FileOutputStream out = new FileOutputStream(new File("TestDeleteUserResultExcel.xls"));
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
