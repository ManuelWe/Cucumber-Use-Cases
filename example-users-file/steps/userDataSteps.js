const { Given, When, Then, BeforeAll } = require('cucumber');
const assert = require('assert');
const fs = require('co-fs');
const co = require('co');
const data = require('../users/user-data.js');



BeforeAll(co.wrap(function*() {
	yield fs.writeFile('./users/users.json', '[]');
}));

When('i create a new User', co.wrap(function* () {
    users = yield data.users.get();
    yield data.users.save({ name: 'John' });
}));
    
Then('the user should be saved', co.wrap(function* () {
	var newUsers = yield data.users.get();
	assert.deepEqual(newUsers.length, users.length + 1, "The User has not been saved");
}));      

Given('there are some Users', co.wrap(function* () {
	yield data.users.save({ name: 'John' });
	yield data.users.save({ name: 'Helen' });
}));
		 
When('i delete all Users', co.wrap(function* () {
	yield data.users.deleteUsers();
}));  

Then('there should be no User', co.wrap(function* () {
	var user = yield data.users.get();
	assert.deepEqual(user.length, 0, "There are still Users");
}));

Given('there is a User named Karl', co.wrap(function* () {
	yield data.users.save({ name: 'Karl' });
}));

When('i delete Karl', co.wrap(function* () {
	yield data.users.deleteUser('Karl');
}));

Then('there should be no User named Karl', co.wrap(function* () {
	var returnValue = yield data.users.exists('Karl');
	assert.ok(!returnValue, "There is still a User named Karl");
}));

When('i rename Karl to John', co.wrap(function* () {
	yield data.users.rename('Karl', 'John');
}));
		 
Then('a User named John should exist', co.wrap(function* () {
	assert.deepEqual(yield data.users.exists('John'), true);
}));
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 







