package abstractClasses.fragment;

import com.ServiceWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class AbstractFragment extends ServiceWD {

    private WebElement rootElement;

    public WebElement getRootElement(){
        return rootElement;
    }

    public void setRootElement(WebElement element){
        this.rootElement = element;
    }

    public WebElement getChildElement(By cssSelector){
        return $(rootElement).find(cssSelector);
    }

    public List<By> getChildElements(By... elements){
        List<By> webElements = new ArrayList<By>();
        for (By element : elements) {
            webElements.add(element);
        }
        return webElements;
    }
}
