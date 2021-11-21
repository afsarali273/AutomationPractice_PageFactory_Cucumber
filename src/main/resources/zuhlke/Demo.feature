Feature: Test Scenario outline with tags

  Scenario Outline: Test different tags
    Given I am on the home page with <url>
    When I click on <page> button
    Then I navigated to <page> page
    @qa
    Examples:
      | url    | page  |
      | qa url | Login |
    @prod
    Examples:
      | url      | page  |
      | prod url | Login |