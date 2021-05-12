package com.restful.automation.pages;

import com.restful.automation.dsl.WebDriverDsl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * @author olufemi on 2021-05-12
 */
public class RoomPage extends BasePageObject<RoomPage> {

    @FindBy(id = "createRoom")
    private WebElement createRoom;
    @FindBy(id = "roomNumber")
    private WebElement roomNumber;
    @FindBy(id = "wifiCheckbox")
    private WebElement wifiCheckbox;
    @FindBy(id = "chkSafe")
    private WebElement chkSafe;
    @FindBy(id = "roomPrice")
    private WebElement roomPrice;
    @FindBy(css = "[data-type='room']")
    private List<WebElement> rooms;



    public void deleteRoom(String roomNos) {
        boolean isRoomDeleted = rooms.stream().anyMatch(f -> deleteARoom(f, roomNos));
        Assert.assertTrue(isRoomDeleted, String.format("Room %s was not deleted or found",roomNos));
    }

    private boolean deleteARoom(WebElement roomRow, String roomNos) {
        List<WebElement> columns = roomRow.findElements(By.tagName("div"));
        if(columns.get(0).getText().equals(roomNos)){
            columns.get(5).findElement(By.tagName("span")).click();
            return true;
        }
        return false;
    }

    public void bookRoom(String roomNos, String price) {
        int previousSize = rooms.size();
        WebDriverDsl.fillText(roomNumber, roomNos);
        WebDriverDsl.fillText(roomPrice, price);
        createRoom.click();

        WebDriverDsl.waitForElementSize(rooms,previousSize);
        Assert.assertTrue(driver.findElement(By.id(String.format("roomNumber%s",roomNos))).isDisplayed(), String.format("Room %s was not created",roomNos));
    }


    @Override
    public RoomPage waitForPage() {
        WebDriverDsl.waitForNewPage(createRoom);
        return this;
    }
}
