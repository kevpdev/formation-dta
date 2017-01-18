export class UserController {
    constructor(UserService, $routeParams, $location) {
        console.log($routeParams)
        this.id = $routeParams.id;
        this.UserService = UserService;
        this.UserService.getUser(this.id)
            .then(user => this.user = user);
        this.$location = $location;

    }
    saveUser(form, user) {
        if (form.$invalid) return;
        console.log('save after test valid: ' + user);
        this.UserService.saveUser(user)
            .then(user => this.$location.path("/users"))
            // .then(() => {
            //     this._initUser();
            //     form.$setPristine(true);
            // });
    }

}