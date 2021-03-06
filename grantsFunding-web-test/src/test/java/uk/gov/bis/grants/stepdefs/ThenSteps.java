package uk.gov.bis.grants.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import uk.gov.bis.grants.pagemodel.*;
import uk.gov.bis.grants.utils.AppProperties;

import java.math.BigDecimal;
import java.util.List;

//import junit.framework.Assert;

public class ThenSteps {

	manageApplicationPage mngeApplication;
	AppFormPage appformpage;

	startPage startpage;
	OpportunityDetailPage oppdetailPage;
	ApplicationDateEntry dateEntry;
	ApplicationEventObjEntry eventEntry;
	ApplicationCostEntry appCostPage;
	CostsPreviewPage costsPreviewPage;
	OpportunityTemplateView opptemplate;

	private WebDriver driver;
	String platform = AppProperties.get("platform");

	public ThenSteps(SharedWebDriver driver) {

		this.driver = driver;

		mngeApplication = PageFactory.initElements(driver, manageApplicationPage.class);
		appformpage = PageFactory.initElements(driver, AppFormPage.class);

		startpage = PageFactory.initElements(driver, startPage.class);
		oppdetailPage = PageFactory.initElements(driver, OpportunityDetailPage.class);
		dateEntry = PageFactory.initElements(driver, ApplicationDateEntry.class);
		eventEntry = PageFactory.initElements(driver, ApplicationEventObjEntry.class);
		appCostPage = PageFactory.initElements(driver, ApplicationCostEntry.class);
		costsPreviewPage = PageFactory.initElements(driver, CostsPreviewPage.class);
		opptemplate = PageFactory.initElements(driver,OpportunityTemplateView.class);

	}

	@Then("^I should see application form$")
	public void i_should_see_application_form() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I should be able to enter \"(.*?)\" in project title$")
	public void i_should_be_able_to_enter_in_project_title(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I should successfully save application$")
	public void i_should_successfully_save_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		mngeApplication.verifymanageapplicationpage();
	}

	@Then("^I should land on manage application page$")
	public void i_should_land_on_manage_application_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		mngeApplication.verifymanageapplicationpage();
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.validateLandingPage();

	}

	@Then("^I should be able to land on start page$")
	public void i_should_be_able_to_land_on_start_page() throws Throwable {
		startpage.verifyPageTitle("Research and Innovation Funding Service - RIFS");
	}

	@Then("^I should see applicant start link$")
	public void i_should_see_applicant_start_link() throws Throwable {
		startpage.validateapplicantLink();

	}

	@Then("^I should be able to see opportunity list page$")
	public void i_should_be_able_to_see_opportunity_list_page() throws Throwable {
		startpage.oppList();
	}

	@Then("^I should be able to see details of that opportunity$")
	public void i_should_be_able_to_see_details_of_that_opportunity() throws Throwable {
		oppdetailPage.VerifyPageTitle();

	}

	@Then("^I should see all sections on opportunity detail page$")
	public void i_should_see_all_sections_on_opportunity_detail_page() throws Throwable {
		oppdetailPage.validateOppPageSections();
		oppdetailPage.validateAllSections();

	}

	@Then("^I should see section \"([^\"]*)\"$")
	public void i_should_see_section(String arg1) throws Throwable {
		oppdetailPage.VerifynavigationOnDetailPage(arg1);
	}

	@Then("^I should see application \"([^\"]*)\" page$")
	public void i_should_see_application_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.verifyPageTitle(arg1);
		// appformpage.validateLandingPage();

	}

	@Then("^I should see all six questions displayed$")
	public void i_should_see_all_six_questions_displayed() throws Throwable {

		appformpage.verifyQuestions();
	}

	@Then("^I should be able to enter title \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_title(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.EnterTitle(arg1);
	}

	@Then("^I should be able save and Continue$")
	public void i_should_be_able_save_and_Continue() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.SaveAndContine();

	}

	@Then("^I should return back to overview page\\.$")
	public void i_should_return_back_to_overview_page() throws Throwable {
		// nothing to do in this step as its verified in above step.
	}

	@Then("^I should see word count \"([^\"]*)\"$")
	public void i_should_see_word_count(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// appformpage.Validatewordcount(arg1);
	}

	@Then("^I should see word count \"([^\"]*)\" on event ObjectivePage$")
	public void i_should_see_word_count_on_event_ObjectivePage(String arg1) throws Throwable {
		eventEntry.Validatewordcount(arg1);
	}

	@Then("^I should see word count \"([^\"]*)\" on \"([^\"]*)\"$")
	public void i_should_see_word_count_on(String arg1, String arg2) throws Throwable {
		appformpage.Validatewordcount(arg1, arg2);
	}

	@Then("^I should see all six questions are clickable$")
	public void i_should_see_all_six_questions_are_clickable() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.verifyQuestions();
	}

	@Then("^I should be click event title$")
	public void i_should_be_click_event_title() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.OpenTitilePage();
	}

	@Then("^navigate to \"([^\"]*)\" page$")
	public void navigate_to_page(String arg1) throws Throwable {
		appformpage.verifyPageTitle(arg1);
	}

	@Then("^I should be able to naviate to page \"([^\"]*)\"$")
	public void i_should_be_able_to_naviate_to_page(String arg1) throws Throwable {
		appformpage.verifyPageTitle(arg1);
	}

	@Then("^I should be able to see date and time stamp$")
	public void i_should_be_able_to_see_date_and_time_stamp() throws Throwable {
		// appformpage.verifyDatetimestamp();
	}

	@Then("^I should be able to see date and time stamp on \"([^\"]*)\" page$")
	public void i_should_be_able_to_see_date_and_time_stamp_on_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.verifyDatetimestamp(arg1);
	}

	@Then("^I should be able to preview$")
	public void i_should_be_able_to_preview() throws Throwable {
		appformpage.preview();
	}

	@Then("^I should be able to view entered \"([^\"]*)\"$")
	public void i_should_be_able_to_view_entered(String arg1) throws Throwable {
		appformpage.verifyonPreviewPage(arg1);
	}

    @Then("^I should be able to view ([0-9]+) entered words$")
	public void i_should_be_able_to_view_number_entered(int wordCount) throws Throwable {
		String s = "";
		for (int i = 0; i < wordCount; i++) {
			s = s + "t ";
		}
		appformpage.verifyonPreviewPage(s);
	}

	@Then("^I should see error message \"([^\"]*)\"$")
	public void i_should_see_error_message(String arg1) throws Throwable {
		dateEntry.validateErrorMessage(arg1);
	}

	@Then("^I should be able select mark as complete checkbox$")
	public void i_should_be_able_select_mark_as_complete_checkbox() throws Throwable {
		// appformpage.clickMarkcomplete();
	}

	@Then("^I should see duration field error \"([^\"]*)\"$")
	public void i_should_see_duration_field_error(String arg1) throws Throwable {
		dateEntry.ValidatedurationfieldError(arg1);
	}

	@Then("^I should be able to enter event objective \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_event_objective(String arg1) throws Throwable {
		eventEntry.EnterObjectives(arg1);

	}

	@Then("^I should be able to enter \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_in(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appformpage.Entertext(arg1, arg2);
	}

	@Then("^I should see entered date\"([^\"]*)\" in preview page$")
	public void i_should_see_entered_date_in_preview_page(String arg1) throws Throwable {
		dateEntry.ValidateStartDateonPreviewpage(arg1);

	}

	@Then("^I should see end date \"([^\"]*)\" in preview page$")
	public void i_should_see_end_date_in_preview_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dateEntry.ValidateEndDateonPreviewpage(arg1);
	}

	@Then("^I should see duration \"([^\"]*)\" in preview page$")
	public void i_should_see_duration_in_preview_page(String arg1) throws Throwable {
		dateEntry.ValidateDurationPreviewpage(arg1);

	}

	@Then("^I should return back to Dateform page$")
	public void i_should_return_back_to_Dateform_page() throws Throwable {
		dateEntry.ValidatePagetitle();
	}

	@Then("^I should be able to see \"([^\"]*)\"status as \"([^\"]*)\"$")
	public void i_should_be_able_to_see_status_as(String arg1, String arg2) throws Throwable {
		appformpage.verifyStatus(arg1, arg2);
	}

	@Then("^I (should be able to )?add cost items$")
	public void i_should_be_able_to_add_cost_items(String ignored, DataTable arg1) throws Throwable {

		appCostPage.AddCostItem(arg1);

	}

	@Then("^I should be able to add one more cost item$")
	public void i_should_be_able_to_add_one_more_cost_item(DataTable arg1) throws Throwable {

		appCostPage.AddItem(arg1);

	}

	@Then("^I should be able to add (\\d+) cost items$")
	public void i_should_be_able_to_add_cost_items(int arg1, DataTable arg2) throws Throwable {
		appCostPage.AddMoreItem(arg1, arg2);

	}

	@Then("^I click on save$")
	public void i_click_on_save() throws Throwable {
		// nothing to do , above step would click on save;
	}

	@Then("^I should be able to edit \"([^\"]*)\"$")
	public void i_should_be_able_to_edit(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I should be able to edit cost Items$")
	public void i_should_be_able_to_edit_cost_Items(DataTable arg1) throws Throwable {

		appCostPage.UpdateCostInfo(arg1);

	}

	@Then("^I should be able to delete (\\d+) item$")
	public void i_should_be_able_to_delete_item(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appCostPage.DeleterequiredItem(arg1);
	}

	@Then("^I should see (\\d+) cost items remaining$")
	public void i_should_see_for_cost_items_remaining(int arg1) throws Throwable {
		appCostPage.verifyRemainingItems(arg1);

	}

	@Then("^Costs page should display the \"Preview this page\" button$")
	public void costs_page_should_have_preview_button() throws Throwable {
		appCostPage.canSeePreviewPageLink();
	}

	@Then("I (should )?see the \"Costs preview page\"")
	public void i_should_see_costs_preview_page(String ignored) {
		costsPreviewPage.onDisplay();
	}

	@Then("^I should be able to see the cost item added$")
	public void i_should_be_able_to_see_the_cost_item_added(DataTable arg1) throws Throwable {
		costsPreviewPage.checkItemsDisplayed(arg1.asLists(String.class));
	}

	@Then("^The Total Requested is '([^']+)'$")
	public void the_Total_Requested_is(String arg1) throws Throwable {
		costsPreviewPage.checkTotalDisplayed(new BigDecimal(arg1));
	}

	@Then("^I (should be able to )?see the \"([^\"]*)\" link at costs preview$")
	public void i_should_be_able_to_see_the_Return_to_application_overview_link(String ignored, String arg1)
			throws Throwable {
		costsPreviewPage.checkReturnToOverviewDisplayed(arg1);
	}

	@Then("^I (should be able to )?see the \"([^\"]*)\" button at costs preview$")
	public void i_should_be_able_to_see_the_button_at_costs_preview(String ignored, String arg1) throws Throwable {
		costsPreviewPage.checkCloseButtonDisplayed(arg1);
	}

	@Then("^I should see application submitted page$")
	public void i_should_see_application_submitted_page() throws Throwable {
		appformpage.verifyApplicationSubmit();
	}

	@Then("^I should see error \"([^\"]*)\"$")
	public void i_should_see_error(String arg1) throws Throwable {
		appformpage.verifyApplicationSubmiterror(arg1);

	}

	@Then("^I should see page error \"([^\"]*)\"$")
	public void i_should_see_page_error(String arg1) throws Throwable {
		appformpage.verifyApplicationSubmitpageerror(arg1);
	}

	@Then("^Cost items should be$")
	public void cost_items_should_be(DataTable arg1) throws Throwable {
		appCostPage.checkCostItemsDisplayed(arg1.asLists(String.class));
	}

	@Then("^I should return back to opportunity list page$")
	public void i_should_return_back_to_opportunity_list_page() throws Throwable {
	   appformpage.verifyPageTitle("Opportunity list - RIFS");
	}

	
	@Then("^I should see setup$")
	public void i_should_see_setup() throws Throwable {
	    
	}

	@Then("^I should see all the sections in SetupTab$")
	public void i_should_see_all_the_sections_in_SetupTab() throws Throwable {
		opptemplate.ValidateAllsectionsonSetupTab();
	    
	}
	
	@Then("^I should see \"([^\"]*)\" preview page$")
	public void i_should_see_preview_page(String arg1) throws Throwable {
		
		opptemplate.ValidateSectionHeader(arg1);
	   
	}
	
	@Then("^I should be able save$")
	public void i_should_be_able_save() throws Throwable {
	    opptemplate.Savesection();
	}
	
	@Then("^I should return back to set-up pages$")
	public void i_should_return_back_to_set_up_pages() throws Throwable {
	   opptemplate.verifyPageTitle("Opportunity template setup - RIFS");
	}
	
	@Then("^I should see new opportunity created$")
	public void i_should_see_new_opportunity_created() throws Throwable {
//to verify new opportunity created,validate publish button exists
		opptemplate.VerifyOpporutnityCreated();
	}
	
	@After()
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				// byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}

	}

}
