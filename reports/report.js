$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/OpenCart.feature");
formatter.feature({
  "name": "OpenCartApplication",
  "description": "  In order to create a webpage\n  As a e-commerce vendor\n  I want to get access to the portal",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "SearchValidCredential",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I search for the product with \u0027\u003cproduct\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "name": "I should get all the search related products",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "product"
      ]
    },
    {
      "cells": [
        "samsung"
      ]
    }
  ]
});
formatter.background({
  "name": "these are the steps common for every scenario to be followed",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have browser with opencartpage",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cts.stepdefintion.StepDefinition.i_have_browser_with_opencartpage()"
});
