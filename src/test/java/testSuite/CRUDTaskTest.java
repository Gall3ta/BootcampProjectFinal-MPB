package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CRUDTaskTest extends TestBase {
    @Test
    public void test() {
        String newTaskName = "ProjectTask1";
        String updateTaskName = "UpdateProjectTask1";

//        LOGIN
        loginSession.loginButton.click();
        loginPage.emailTxt.setText(user);
        loginPage.pwdTxt.setText(pass);
        loginPage.loginButton.click();
        mainPage.inboxLabel.waitControlIsNotVisibleComponent();
        Assertions.assertTrue(mainPage.inboxLabel.isControlDisplayed(), "Error! Log in failed");

//        CREATE TASk
        createTaskList.buttonPlusAddList.click();
        addList.titleAddList.waitControlIsNotVisibleComponent();
        addList.nameTaskList.setText(newTaskName);
        addList.saveList.click();
        taskList.labelTask(newTaskName).waitControlIsNotVisibleComponent();
        taskList.labelTask(newTaskName).click();
        MenuTaskList.buttonMeatball(newTaskName).waitControlIsNotVisibleComponent();
        MenuTaskList.buttonMeatball(newTaskName).click();
        MenuTaskList.textEdit.click();
        Assertions.assertTrue(editList.editTextBox.isControlDisplayed(), "Error! Task was not created");

//        UPDATE TASK
        editList.editTextBox.setText(updateTaskName);
        editList.saveEditText.click();
        taskList.labelTask(newTaskName+updateTaskName).waitControlIsNotVisibleComponent();
        Assertions.assertTrue(taskList.labelTask(newTaskName+updateTaskName).isControlDisplayed(), "Error! Task was not updated");

//        DELETE TASK
        MenuTaskList.buttonMeatball(newTaskName+updateTaskName).click();
        MenuTaskList.textDelete.isControlDisplayed();
        MenuTaskList.textDelete.click();
        deleteList.deleteModal.waitControlIsNotVisibleComponent();
        deleteList.deleteModal.click();
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
}
