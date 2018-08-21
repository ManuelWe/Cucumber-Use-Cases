var fs = require('co-fs');

var userFile = './users/users.json';

module.exports = {
    users : {
		deleteUsers: function *() {
			yield fs.writeFile(userFile, '[]');
		},
		deleteUser: function *(usrName) {
			var data = yield this.get();
			for(var user in data) {
				if(data[user].name == usrName) {
					data.splice(user, 1);
				}
			}
			if(data.length != 0) yield fs.writeFile(userFile, JSON.stringify(data));
			else yield fs.writeFile(userFile, '[]');
		},
        get: function *() {
            var data = yield fs.readFile(userFile, 'utf-8');
            return JSON.parse(data);
        },
        save: function *(user) {
            var users = yield this.get();
            users.push(user);
            yield fs.writeFile(userFile, JSON.stringify(users));
        },
		exists: function *(usrName) {
			var data = yield this.get();
			for(var user in data) {
				if(data[user].name == usrName) {
					return true;
				}
			}
			return false;
		},
		rename: function *(usrNameOld, usrNameNew) {
			var i = 0;
			var result = yield this.exists(usrNameOld);
			if(result) {
				var data = yield this.get();
				while(usrNameOld != data[i].name){
					i++;
				}
				data[i].name = usrNameNew;
				yield fs.writeFile(userFile, JSON.stringify(data));
			}
		}
    }
}




