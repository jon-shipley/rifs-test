package uk.gov.bis.grants.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import uk.gov.bis.grants.pagemodel.*;
import uk.gov.bis.grants.utils.AppProperties;

public class WhenSteps {

	private WebDriver driver;

	startPage appStartPge;

	AppFormPage appform;

	OpportunityDetailPage oppdetailPage;
	ApplicationDateEntry dateEntry;
	ApplicationEventObjEntry eventEntry;
	ApplicationCostEntry appCostPage;
	CostsPreviewPage costsPreviewPage;
	CreateNewOpportunity createopp;
	OpportunityTemplateView opptemplate;

	String platform = AppProperties.get("platform");

	public WhenSteps(SharedWebDriver driver) {
		this.driver = driver;

		appStartPge = PageFactory.initElements(driver, startPage.class);
		appform = PageFactory.initElements(driver, AppFormPage.class);
		oppdetailPage = PageFactory.initElements(driver, OpportunityDetailPage.class);
		dateEntry = PageFactory.initElements(driver, ApplicationDateEntry.class);
		eventEntry = PageFactory.initElements(driver, ApplicationEventObjEntry.class);
		appCostPage = PageFactory.initElements(driver, ApplicationCostEntry.class);
		costsPreviewPage = PageFactory.initElements(driver, CostsPreviewPage.class);
		createopp = PageFactory.initElements(driver,CreateNewOpportunity.class);
		opptemplate = PageFactory.initElements(driver,OpportunityTemplateView.class);
		
	}

	@When("^I click on start$")
	public void i_click_on_start() throws Throwable {
		appStartPge.startApplication();
	}

	@When("^I click on apply button$")
	public void i_click_on_apply_button() throws Throwable {
		appStartPge.clickApply();

	}

	@When("^I click firstnext button$")
	public void i_click_firstnext_button() throws Throwable {
		oppdetailPage.clickfirstNext();
	}

	@When("^I click on next button again$")
	public void i_click_on_next_button_again() throws Throwable {
		oppdetailPage.clickNext();
	}

	@When("^I click on previous button$")
	public void i_click_on_previous_button() throws Throwable {
		oppdetailPage.clickPrevious();
	}

	@When("^I click on applicant link$")
	public void i_click_on_applicant_link() throws Throwable {
		appStartPge.asanApplicant();
	}

	@When("^I click on Make an application$")
	public void i_click_on_Make_an_application() throws Throwable {

		oppdetailPage.makeApplication();

	}

	@When("^I select an Opportunity from list$")
	public void i_select_an_Opportunity_from_list() throws Throwable {
		appStartPge.selectOppor();

	}

	@When("^I click on event title link on application overview page$")
	public void i_click_on_event_title_link_on_application_overview_page() throws Throwable {
		appform.OpenTitilePage();
	}

	@When("^I open event objectives page$")
	public void i_open_event_objectives_page() throws Throwable {
		appform.OpenSection("EventObjs");

	}

	@When("^I open section \"([^\"]*)\"$")
	public void i_open_section(String arg1) throws Throwable {
		appform.OpenSection(arg1);
	}

	@When("^I  enter event objective \"([^\"]*)\"$")
	public void i_enter_event_objective(String arg1) throws Throwable {
		eventEntry.EnterObjectives(arg1);
	}


	private String makeNWords(int wordCount) {
		String s = "";
		for (int i = 0; i < wordCount; i++) {
			s = s + "t ";
		}
		return s;
	}

	@When("^I enter event ([0-9]+) words in event objective$")
	public void i_enter_event_objective_words(int wordCount) throws Throwable {
		eventEntry.EnterObjectives(makeNWords(wordCount));
	}

	@When("^I  enter \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_enter_in(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appform.Entertext(arg1, arg2);
	}

	@When("^I  enter ([0-9]+) words in \"([^\"]*)\"$")
	public void i_enter_words_in(int wordCount, String fieldName) throws Throwable {
		appform.Entertext(makeNWords(wordCount), fieldName);
	}


	@When("^I enter title \"([^\"]*)\"$")
	public void i_enter_title(String arg1) throws Throwable {
		appform.EnterTitle(arg1);
	}

	@When("^I enter title \"([^\"]*)\" within required word size limit$")
	public void i_enter_title_within_required_word_size_limit(String arg1) throws Throwable {
		appform.EnterTitle(arg1);
	}

	@When("^I enter title \"([^\"]*)\" outside required word size limit$")
	public void i_enter_title_outside_required_word_size_limit(String arg1) throws Throwable {
		appform.EnterTitle(arg1);
	}

	@When("^I keep title field empty$")
	public void i_keep_title_field_empty() throws Throwable {
		appform.Cleartextfield();
	}

	@When("^I save and continue$")
	public void i_save_and_continue() throws Throwable {
		appform.SaveAndContine();
	}

	@When("^I save and continue on date entry$")
	public void i_save_and_continue_on_date_entry() throws Throwable {
		dateEntry.SaveAndContineValidationCheck();
	}

	@When("^I open event title page again$")
	public void i_open_event_title_page_again() throws Throwable {
		appform.OpenTitilePage();
	}

	@When("^I click on preview$")
	public void i_click_on_preview() throws Throwable {
		appform.preview();
	}

	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appform.OpenSection(arg1);
	}

	@When("^I should be able click mark as complete link$")
	public void i_should_be_able_click_mark_as_complete_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appform.clickMarkcomplete("EventTitle");
	}

	@When("^I should be able select mark as complete checkbox  \"([^\"]*)\" page$")
	public void i_should_be_able_select_mark_as_complete_checkbox_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		appform.clickMarkcomplete(arg1);
	}

	@When("^I enter invalid date$")
	public void i_enter_invalid_date(DataTable arg1) throws Throwable {
		dateEntry.EnterDate(arg1);

	}

	@When("^I enter valid date$")
	public void i_enter_valid_date(DataTable arg1) throws Throwable {
		dateEntry.EnterDate(arg1);
	}

	@When("^I enter duration \"([^\"]*)\"$")
	public void i_enter_duration(String arg1) throws Throwable {
		dateEntry.Enterduration(arg1);
	}

	@When("^I open provisional date section$")
	public void i_open_provisional_date_section() throws Throwable {
		appform.OpenSection("provisionalDate");
	}

	@When("^I click mark as complete$")
	public void i_click_mark_as_complete() throws Throwable {
		dateEntry.clickMarkcomplete();

	}

	@When("^I click on close button preview$")
	public void i_click_on_close_button_preview() throws Throwable {
		dateEntry.Closepreview();
	}

	@When("^I click on edit link on preview page$")
	public void i_click_on_edit_link_on_preview_page() throws Throwable {
		dateEntry.EditPage();
	}

	@When("^I should be able to add cost item with invalid currency$")
	public void i_should_be_able_to_add_cost_item_with_invalid_currency(DataTable arg1) throws Throwable {
		appCostPage.AddCostItem(arg1);
	}

	@When("^I click on added Item$")
	public void i_click_on_added_Item() throws Throwable {

		appCostPage.EditCostItems();

	}

	@When("I click \"Preview this page\" at Costs page")
	public void i_click_preview_page_at_costs_page() {
		appCostPage.previewThisPage();
	}

	@When("^I click on submit Application button$")
	public void i_click_on_submit_Application_button() throws Throwable {
		appform.submitApplication();

	}

	@When("^I click the \"([^\"]*)\" link at costs preview$")
	public void i_click_the_link_at_costs_preview(String arg1) throws Throwable {
		costsPreviewPage.clickReturnToOverview();
	}

	@When("^I click the \"([^\"]*)\" button at costs preview$")
	public void i_click_the_button_at_costs_preview(String arg1) throws Throwable {
		costsPreviewPage.clickCloseButton();
		
	}
	
	@When("^I choose existing opportunity on create oportunity page$")
	public void i_choose_existing_opportunity_on_create_oportunity_page() throws Throwable {
		createopp.ReusingExistingopp();
	    
	}
	
	@When("^I open opportunity from the list$")
	public void i_open_opportunity_from_the_list() throws Throwable {
		
		//createopp.selectOpportunity();
		opptemplate.chooseDraftOppfromlist();
	    
	}

	@When("^I click on return to opportunity link$")
	public void i_click_on_return_to_opportunity_link() throws Throwable {
	    createopp.returntoOpplist();
	}

	@When("^I open opportunity template view$")
	public void i_open_opportunity_template_view() throws Throwable {
	    opptemplate.OpenOpptemplate();
	}

	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String arg1) throws Throwable {
	   opptemplate.OpenSetupsection(arg1);
	}

	@When("^I click on Questions tab$")
	public void i_click_on_Questions_tab() throws Throwable {
		opptemplate.OpenQuestionsTab();
	    
	}
	
	@When("^I enter \"([^\"]*)\" in setup \"([^\"]*)\"$")
	public void i_enter_in_setup(String arg1, String arg2) throws Throwable {
	    opptemplate.Entertext(arg1, arg2);
	    
	    
	}
	
	@When("^I enter (\\d+) in PM setup \"([^\"]*)\"$")
	public void i_enter_in_PM_setup(int words, String field) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		opptemplate.Entertext(makeNWords(words), field);
	}
	
	@When("^I  enter (\\d+) in setup \"([^\"]*)\"$")
	public void i_enter_in_setup(int words, String field) throws Throwable {
		opptemplate.Entertext(makeNWords(words), field);
	  
	}

	@When("^I  click save$")
	public void i_click_save() throws Throwable {
		
		opptemplate.Savesection();
	    
	}

	@When("^I enter application reference$")
	public void i_enter_application_reference() throws Throwable {
	    appform.EnterApplicationref();
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
