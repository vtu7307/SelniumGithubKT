package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	//Common method to select drop down values
	public void SelectDropDownButton(WebElement element,String ValuestobeSelected) throws Exception {
		Select os = new Select(element);
		try {
			os.selectByVisibleText(ValuestobeSelected);
			
		} catch (Exception e) {
			throw new Exception("Value is not present in dropdown for webelement: "+element+ "value to be entered is : "+ValuestobeSelected);
		}
		
		
	}
	//Common method for selecting Gender radio button
	public void SelectRadioButtonValue(List<WebElement> elements,String Valuestobeopted) {
		for (WebElement ref : elements) {
			if (ref.getText().equalsIgnoreCase(Valuestobeopted)) {
				ref.click();
				break;
			}	
		}
	}
	//selecting check boxes
	
	public void selectChecBoxes(List<WebElement> element,String checks) {
		String[] checksArrStrings = checks.split(",");
		for (String str : checksArrStrings) {
			for (WebElement ele : element) {
				if(ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					break;
				}
			}
		}
		
		
	}
	
public List<String> getdropDownasalist(WebElement element) {
	Select os = new Select(element);
	List<WebElement> list_webelement_model=os.getOptions();
	List<String> actualContents = new ArrayList<String>();
	for (WebElement ref : list_webelement_model) {
		actualContents.add(ref.getText());
		
	}
	return actualContents;
	

	
}

}
