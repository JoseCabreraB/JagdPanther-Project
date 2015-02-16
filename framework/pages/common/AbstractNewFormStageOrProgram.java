package framework.pages.common;

/**Created by Jose Cabrera
 * 2/4/15
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @title  NewFromStageProgramPage
 * @author Jose Cabrera
 * @description Is the page that is used for create Registered Users
 */
public abstract class AbstractNewFormStageOrProgram {
	
	//The locator used for find an inputName TextBox
	@FindBy(id = "form:inputName")
	protected WebElement txtName;
	
	//The locator used for find an inputTitle TextBox
	@FindBy(id = "form:inputTitle")
	protected WebElement txtTitle;
	
	//The locator used for find an inputDescription TextBox
	@FindBy(id = "form:inputDescription")
	protected WebElement txtDescription;

	public void setName(String names) {
		txtName.sendKeys(names);
	}

	public void setTitle(String tittle) {
		txtTitle.sendKeys(tittle);
	}

	public void setDescription(String description) {
		txtDescription.sendKeys(description);
	}
}
