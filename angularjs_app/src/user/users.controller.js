export class UsersController {
    constructor(UserService, Version, $timeout) {

        this.version = Version;
        this.UserService = UserService;
        this.$timeout = $timeout;
        this.UserService.getUsers()
            .then(users => {
                this.users = users;
            });

        // this.users = [{ name: "Thomas", age: "40" },
        //     { name: "Nicolas", age: "25" },
        //     { name: "Lilian", age: "37" },
        //     { name: "Murielle", age: "31" }
        // ];
        this.undo = {};


        //    //   this.getUserName = (user) => user.name || 'Name Not Found';
        //      //  this.getUserNameUpp = (user) => user.name.toUpperCase() || 'Name Not Found';
        //         this.startWithT = (user) => user.name[0] === 'T';
        //         this.showUser = (i) => this.user.name[i];     
        //         this.action = function(user){
        //            console.log(user)
        //             user.action = true;

        //         };
        //         this.cssClass = false;
        //         this.name='';
        //          this.predicat = 'name';
        //         this.reverse = false;
        //         this.enableCss =  ()=> this.cssClass = !this.cssClass;
        //         this.filter = ()=>{
        //             return  this.users.filter(user => user.name.includes(this.name))
        //         }



    }
    enableCss() {
        this.cssEnable = !this.cssEnable;
    }

    sort(predicat) {
        if (this.predicat === predicat) {
            this.reverse = !this.reverse;
        }
        this.predicat = predicat;
    }

    saveUser(form, user) {
        if (form.$invalid) return;
        console.log('save after test valid: ' + user);
        this.UserService.saveUser(user)
            .then(user => this.upsert(user))
            .then(() => {
                this._initUser();
                form.$setPristine(true);
            });
    }


    // ajoute user à this.users si non trouvé, le modifie si trouvé 
    upsert(user) {
        const idx = this.users.findIndex(u => u.id === user.id);
        if (idx !== -1) { // user trouvé mise à jour
            this.users[idx] = user;
        } else { // on ajoute le user
            this.users.push(user);
        }
    }

    deleteUser(user) {
        //user.delete = true;

        this.undo[user.id] = this.$timeout(5000);
        this.undo[user.id].then(() => {
            this.users = this.users.filter(u => u.id !== user.id);
            this.UserService.deleteUser(user);
            delete this.undo[user.id];
        }, () => {
            delete this.undo[user.id];
        });
    }

    cancelDelete(user) {
        this.$timeout.cancel(this.undo[user.id]);
    }


    editUser(user) {
        this.user = angular.copy(user);
    }

    cancel() {
        this._initUser();
    }

    _initUser() {
        this.user = { name: '', age: 0 };
    }

}