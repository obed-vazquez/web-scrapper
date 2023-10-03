package org.white_sdev.samples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebScrapper {
    /**
     * Main method of the application.
     * This is the method that will launch the main process and run the provided application.
     * This is a special method of the language used to launch the main thread;
     * <a href="https://www.oracle.com/java/technologies/jpl1-building-applications.html#class"> more information</a>.
     *
     * @param args {@link String} Arguments provided by the caller of the application (Often omitted)
     */
    public static void main(String[] args) {
        System.out.println("Start");
        try {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.ktronix.com/computadores-tablet/computadores-portatiles/c/BI_104_KTRON");

            String productXpath = "/html/body/main/section/div/section/section/div[2]/div/div[4]/div/div/ol/li[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div/p[2]/span[1]";
            String price = driver
                    .findElement(By.xpath(productXpath))
                    .getText();

            String productName = driver
                    .findElement(By.xpath("//*/h3//a[@data-id='4711387121009']"))
                    .getText();

            driver.findElement(By.xpath("//*/div[@class='product__item__information__view-details js-details-block']/a[@data-id='4711387121009']"))
                    .click();

            driver.quit();
            System.out.println("Finish - productName:" + productName + ", price:" + price);

        } catch (Exception e) {
            throw new RuntimeException("Impossible to launch application ", e);
        }
    }

}
