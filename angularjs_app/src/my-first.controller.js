
export class MyFirstController{
constructor (UserService, Version) {

    this.version = Version;
    this.UserService = UserService;
    this.UserService.getUsers()
        .then(users => {
            this.users = users;
        });

    this.users = [{ name: "Thomas", age:"40"},
    { name: "Nicolas", age:"25" },
    { name: "Lilian", age:"37" },
    { name: "Murielle", age:"31" }];


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

sort(predicat){
if (this.predicat === predicat) {
        this.reverse = !this.reverse;
    }
    this.predicat = predicat;
}

    saveUser(form, user) {
        if (form.$invalid) return;

       this.UserService.saveUser(user).then(() => {
                this._initUser();
                form.$setPristine(true);
            })
    }


    // ajoute user à this.users si non trouvé, le modifie si trouvé 
    upsert(user) {
        const _user = this.users.find(u => u.id === user.id);
        
    }

delUser(user) {

    user.deleted = true;
    this.UserService.delUser(user)
        .then(() => {
            console.log(user)
        this.users = this.users = this.users.filter(user => user.id !== user.id);

    });
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

    
