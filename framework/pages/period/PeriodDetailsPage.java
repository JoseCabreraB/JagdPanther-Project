package framework.pages.period;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.applicant.NewApplicantPage;

public class PeriodDetailsPage {
	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement labelName;
	
	@FindBy(id = "j_id_t:j_id_17") 
	WebElement textBoxName;
	
	@FindBy(xpath = "//button[@type='button']") 
	WebElement buttonSaveName;
	
	@FindBy(xpath = "(//button[@type='button'])[3]") 
	WebElement buttonSaveDate;
	
	@FindBy(id = "j_id_t:inputInitialDate_display") 
	WebElement labelDate;
	
	@FindBy(id = "j_id_t:j_id_1b_input") 
	WebElement textBoxDate;
	
	@FindBy(xpath = "//a[contains(text(),'Postulantes')]") 
	WebElement applicantButton;
	
	@FindBy(id = "j_id_t:applcantStageTabs:j_id_1o")
	WebElement newApplicantButton;
	
	@FindBy(id = "j_id_t:applcantStageTabs:applicantList_data") 
	WebElement applicantTable;
	
	public PeriodDetailsPage setPeriodName(String name){
		labelName.click();
		textBoxName.sendKeys(name);
		buttonSaveName.click();
		return this;
	}

	public PeriodDetailsPage setStartPeriodDate(String date){
		labelDate.click();
		textBoxDate.sendKeys(date);
		buttonSaveDate.click();
		return this;
	}
	
	public PeriodDetailsPage clickApplicantButton(){
		applicantButton.click();
		return this;
	}
	
	public NewApplicantPage clickNewApplicantButton(){
		newApplicantButton.click();
		return new NewApplicantPage();
	}
	
	public String getPeriodName(){
		return labelName.getText();
	}
	
	public String getAllAplicants(){
		return applicantTable.getText();
	}

}
