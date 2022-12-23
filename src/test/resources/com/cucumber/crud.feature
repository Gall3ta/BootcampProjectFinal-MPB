Feature: Automation Web UI for TickTick page
  @test
  Scenario: CRUD of a task list
    Given Load page ticktick
    When User log in
    And Verify that the user is logged in the page
    When User is creating a new task
    Then The task is named "New taskList"
    And Verify that the task was created
    When User updates task with "Update taskList"
    And Verify that the task was updated
    When User deletes the task
    And Verify that the task was deleted
    Then Close the session