class DtaUserController {
    
    constructor() {}

    $onChanges() {
        this.user = angular.copy(this.user);
    }

    saveUser(form, user) {
       if (form.$invalid) return;
       this.onSubmit({
           $event: this.user
       });
    }
}

export const DtaUser = {
    bindings: {
        user: '<',
        onSubmit: '&'
    },
    template: require('./dta-user.component.html'),
    controller: DtaUserController
}