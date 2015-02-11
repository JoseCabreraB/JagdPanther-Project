package framework.pages.navigation;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.applicant.ApplicantPage;
import framework.pages.period.PeriodPage;
import framework.pages.program.ProgramPage;
import framework.pages.registereduser.RegisteredUserPage;
import framework.pages.stage.StagePage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  NavigationPage
 * @author Jose Cabrera
 * @description Is the navigation bar that have the links to all pages of JagdPanther
 */
public class NavigationPage {
	
	//declare the instance of Selenium Webdriver
	WebDriver driver;
	
	//The locator of link that is used for go to ProgramsPage
	@FindBy(linkText = "Programas")
	WebElement programsLink;
	
	//The locator of link that is used for go to PeriodsPage
	@FindBy(linkText = "Periodos")
	WebElement periodsLink;
	
	//The locator of link that is used for go to ApplicantsPage
	@FindBy(linkText = "Postulantes")
	WebElement applicantsLink;

	//The locator of link that is used for go to StagePage
	@FindBy(linkText = "Etapas")
	WebElement stagesLink;
	
	//The locator of link that is used for go to RegisteredUsersPage
	@FindBy(linkText = "Usuarios de Sistema Registrados")
	WebElement registeredUsersLink;

	public NavigationPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public ProgramPage clickProgramsLink() {
		programsLink.click();
		return new ProgramPage(); 
	}

	public PeriodPage clickPeriodsLink() {
		periodsLink.click();
		return new PeriodPage(); 
	}

	public ApplicantPage clickApplicantsLink() {
		applicantsLink.click();
		return new ApplicantPage(); 
	}

	public StagePage clickStagesLink() {
		stagesLink.click();
		return new StagePage(); 
	}

	public RegisteredUserPage clickRegisteredUsersLink() {
		registeredUsersLink.click();
		return new RegisteredUserPage(); 
	}
}
