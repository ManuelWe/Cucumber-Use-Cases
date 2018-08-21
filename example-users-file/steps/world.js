const { setWorldConstructor } = require('cucumber')

class CustomWorld {
	constructor() {
		this.users = 0;
	}

}

setWorldConstructor(CustomWorld)