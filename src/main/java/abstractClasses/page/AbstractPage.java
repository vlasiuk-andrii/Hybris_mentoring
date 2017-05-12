package abstractClasses.page;

import com.ServiceWD;

import static appendice.CommonConstants.ROOT_URL;
import static junit.framework.TestCase.assertTrue;

public class AbstractPage extends ServiceWD {
    protected String title;
    protected String url;

    public void visit(){
        driver.get(ROOT_URL + url);
    }

    public void visit(String requestText){
        driver.get(ROOT_URL + url + requestText);
    }

    public void check(){
        assertTrue(driver.getCurrentUrl().contains(url));
        assertTrue(driver.getTitle().contains(title));
    }

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setUrl(String url){
        this.url = url;
    }

}
