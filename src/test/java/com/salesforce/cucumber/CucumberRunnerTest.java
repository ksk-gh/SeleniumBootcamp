package com.salesforce.cucumber;

import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features ={"src/main/java/features/CreateOpportunity.feature","src/main/java/features/EditOpportunity.feature","src/main/java/features/DeleteOpportunity.feature"},glue="com.salesforce.cucumber",publish=true, plugin= {"pretty","html:target/cucumber-reports.html"})

//@CucumberOptions(features ="src/main/java/features",glue="com.salesforce.cucumber",publish=true, plugin= {"pretty","html:target/cucumber-reports.html"})
@CucumberOptions(features ={"src/main/java/features/Opportunity.feature","src/main/java/features/Accounts.feature"},glue="com.salesforce.cucumber",publish=true, plugin= {"pretty","html:target/cucumber-reports.html"})

public class CucumberRunnerTest extends Base{

}
