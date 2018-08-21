const { Given, When, Then, After } = require('cucumber');
const assert = require('assert');
const webdriver = require('selenium-webdriver'), By = webdriver.By, until = webdriver.until;



Given('i am on the login page', {timeout: 30 * 1000}, function () {
    driver = new webdriver.Builder().usingServer('http://centos-selenium-hub:4444/wd/hub').withCapabilities({'browserName': 'chrome'}).build();
	driver.get('http://testing-ground.scraping.pro/login');
	return driver.wait(until.elementLocated(By.id('title')));
});
		 
		 
When('i enters username as {string}', async function (username) {
    await driver.findElement(By.id("usr")).sendKeys(username);
});
		 
		 
When('i enters password as {string}', async function (password) {
    await driver.findElement(By.id("pwd")).sendKeys(password);
	await driver.findElement(By.css("input[value='Login']")).click().catch(function(e){console.log(e);});
});
		 
		 
Then('Login should be succesful', async function () {
	await driver.findElement(By.className("success")).isDisplayed().then(function (result) {
		assert.deepEqual(result, true, "Login not successful");
	}).catch(function (e) {
		assert.fail(e);
	});
});


Then('Login should fail', async function () {
	await driver.findElement(By.className("error")).isDisplayed().then(function (result) {
		assert.deepEqual(result, true, "Login not successful");
	}).catch(function (e) {
		assert.fail(e);
	});
});
         

After(async function(){
	await driver.quit();
});

