export class UserService {
    constructor($http, $timeout) {
        this.$http = $http;
        this.$timeout = $timeout;
    
        this.uri = 'http://localhost:3000/users';
    }

    getUsers() {
       return this.$http.get(this.uri)
            .then((response) => response.data);

    }

    addUser(user){

        return this.$http.post(this.uri, user)
            .then((response) => response.data);
    }

    delUser(user){     
        return this.$timeout(3000)
            .then(() => this.$http.delete(this.uri+'/'+user.id)
            .then((response) => response.data));
    }

    editUser(user){
         return this.$http.put(this.uri+'/'+user.id, user)
            .then((response) => response.data);
    }

    saveUser(user){
        return !user.id ? this.addUser(user) : this.editUser(user);
    }
}

    