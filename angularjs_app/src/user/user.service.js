export class UserService {
    constructor($http, $timeout, $q) {
        this.$http = $http;
        this.$timeout = $timeout;
        this.$q = $q;

        this.uri = 'http://localhost:3000/users';
    }

    getUsers() {
        return this.$http.get(this.uri)
            .then((response) => response.data);

    }

    addUser(user) {

        return this.$http.post(this.uri, user)
            .then((response) => response.data);
    }

    deleteUser(user) {
        return this.$http.delete(this.uri + '/' + user.id)
            .then((response) => response.data);

    }

    editUser(user) {
        return this.$http.put(this.uri + '/' + user.id, user)
            .then((response) => response.data);
    }

    saveUser(user) {
        console.log(user);
        return !user.id ? this.addUser(user) : this.editUser(user);
    }

    getUser(id) {
        if (!id) return this.$q.resolve({ name: 'Jean', age: 5 });
        return this.$http.get(this.uri + '/' + id)
            .then((response) => response.data);
    }
}