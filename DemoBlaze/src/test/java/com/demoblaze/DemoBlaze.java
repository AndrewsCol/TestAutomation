package com.demoblaze;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DemoBlaze {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webchromedriver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();
    }

    @Test
    public void search() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'MacBook Pro')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Andres Ospina");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Colombia");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Cali");
        driver.findElement(By.xpath("//input[@id='card']")).sendKeys("4381917902");
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("09");
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2025");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

        String mensaje = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText();
        Assert.assertEquals("Thank you for your purchase!", mensaje);
    }

    @After
    public void close() {
        driver.close();
    }
}
