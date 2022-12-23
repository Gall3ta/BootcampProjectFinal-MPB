package com.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import session.Session;
import util.GetProperties;

public class TestBase {

    LoginSession loginSession = new LoginSession();
    LoginPage loginPageSession = new LoginPage();
    MainPage mainPage = new MainPage();
    CreateTaskList createTaskList = new CreateTaskList();
    AddList addList = new AddList();
    MenuTaskList menuTaskList = new MenuTaskList();
    TaskList taskList = new TaskList();
    DeleteList deleteList = new DeleteList();
    EditList editList = new EditList();
    String user = GetProperties.getInstance().getUser();
    String pass = GetProperties.getInstance().getPass();

    String newTaskName;
    String updateTaskName = "Update task";

    @Given("Load page ticktick")
    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @Given("Close the session")
    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }

    @When("User log in")
    public void logginUser() {
        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(user);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.inboxLabel.waitControlIsNotVisibleComponent();
    }

    @And("Verify that the user is logged in the page")
    public void userLoggedInThePage() {
        Assertions.assertTrue(mainPage.inboxLabel.isControlDisplayed(), "Error! Log in failed");
    }

    @When("User is creating a new task")
    public void createTask() {
        createTaskList.buttonPlusAddList.click();
        addList.titleAddList.waitControlIsNotVisibleComponent();
    }
    @Then("The task is named {string}")
    public void theTaskIsNamed(String task) throws InterruptedException {
        newTaskName = task;
        addList.nameTaskList.setText(newTaskName);
        addList.saveList.click();
        taskList.labelTask(newTaskName).waitControlIsNotVisibleComponent();
        taskList.labelTask(newTaskName).click();
        menuTaskList.buttonMeatball(newTaskName).waitControlIsNotVisibleComponent();
        Thread.sleep(2000);
        menuTaskList.buttonMeatball(newTaskName).click();
        menuTaskList.textEdit.click();
    }
    @And("Verify that the task was created")
    public void verifyTheTaskWasCreated() {
        Assertions.assertTrue(editList.editTextBox.isControlDisplayed(), "Error! Task was not created");
    }
    @When("User updates task with {string}")
    public void updateTask(String newName) {
        updateTaskName = newName;
        editList.editTextBox.setText(updateTaskName);
        editList.saveEditText.click();
        taskList.labelTask(newTaskName + updateTaskName).waitControlIsNotVisibleComponent();
    }
    @And("Verify that the task was updated")
    public void verifyTheTaskWasUpdated() {
        Assertions.assertTrue(taskList.labelTask(newTaskName + updateTaskName).isControlDisplayed(), "Error! Task was not updated");
    }
    @When("User deletes the task")
    public void deleteTask() {
        menuTaskList.buttonMeatball(newTaskName+updateTaskName).click();
        menuTaskList.textDelete.isControlDisplayed();
        menuTaskList.textDelete.click();
        deleteList.deleteModal.waitControlIsNotVisibleComponent();
        deleteList.deleteModal.click();
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
    @And("Verify that the task was deleted")
    public void verifyTheTaskWasDelete() {
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
}
