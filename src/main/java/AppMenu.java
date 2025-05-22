import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppMenu {

    private final WebDriverWait wait;

    public AppMenu(WebDriverWait wait) {
        this.wait = wait;
    }

    public void openMenu() {
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.samsung.android.app.reminder:id/open_drawer")));
        menuButton.click();
    }

    public void openAll() {
        WebElement all = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.samsung.android.app.reminder:id/title\" and @text=\"All\"]")));
        all.click();
    }

    public void openTrash() {
        WebElement trash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.samsung.android.app.reminder:id/title\" and @text=\"Trash\"]")));
        trash.click();
    }

    public void openCompleted(){
        WebElement completed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.samsung.android.app.reminder:id/title\" and @text=\"Completed\"]")));
        completed.click();
    }
}
