export class UserController {
    constructor($routeParams, UserService, $location) {
        console.log($routeParams)
        this.id = $routeParams.id;
        this.UserService = UserService;
        this.$location = $location;
        this.UserService.getUser(this.id)
            .then(user => this.user = user);
    }

    saveUser(user) {
        console.log(user)
        this.UserService.saveUser(user)
            .then(() => this.$location.path('/users'));
    }
}