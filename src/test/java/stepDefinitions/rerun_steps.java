package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rerun_steps {
    WebDriver driver=new ChromeDriver();

    @Given("user navigates to my contact form")
    public void user_navigates_to_my_contact_form() {
      driver.get("https://www.mycontactform.com/");
      driver.manage().window().maximize();
    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
     driver.findElement((By.xpath("//*[@id=\"user\"]"))).sendKeys("qatrainer");
     driver.findElement((By.xpath("//*[@id=\"pass\"]"))).sendKeys("admin123");
    }
    @And("user click on submit button")
    public void user_click_on_submit_button() {
      driver.findElement((By.xpath("//*[@id=\"right_col_top\"]/form/div/input"))).click();
    }
    @And("user click on logout button")
    public void user_click_on_logout_button() {
       driver.findElement(By.xpath("//*[@id=\"user_bar\"]/ul/li[1]/a")).click();
    }
    @Then("user quits the browser")
    public void user_quits_the_browser() {
       driver.close();;
    }
    @Given("user navigates to youtube")
    public void user_navigates_to_youtube() {
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

    }
    @Given("user type something in search")
    public void user_type_something_in_search() {
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("RestAssured");


    }
    @Then("user quits the youtube")
    public void user_quits_the_youtube() {
       driver.close();
    }
    @Given("user navigates to Amazon")
    public void user_navigates_to_amazon() {
       driver.get("https://www.amazon.com/");
       driver.manage().window().maximize();
    }
    @When("user search for a product")
    public void user_search_for_a_product() {
     driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("bottles");
    }
    @Then("user quits the amazon")
    public void user_quits_the_amazon() {
      driver.close();
    }



}
