angular.module('app', [])
.run(function(){
  console.log('PizzaYOLO !');
})
.controller('MyFirstController', function(){
     console.log('MyFirstController');
     this.user = {
         name :"Kevin",
         age : 22
     }
     this.users = [{ name: "Thomas", age:"40"},
      { name: "Nicolas", age:"25" },
       { name: "Lilian", age:"37" },
       { name: "Murielle", age:"31" }];

      this.getUserName = (user) => user.name || 'Name Not Found';
       this.getUserNameUpp = (user) => user.name.toUpperCase() || 'Name Not Found';
        this.startWithT = (user) => user.name[0] === 'T';
        this.showUser = (i) => this.user.name[i];     
        this.action = function(user){
           console.log(user)
            user.action = true;
            
        };
        this.cssClass = false;
        this.name='';
         this.predicat = 'name';
        this.reverse = false;
        this.enableCss =  ()=> this.cssClass = !this.cssClass;
        this.filter = ()=>{
            return  this.users.filter(user => user.name.includes(this.name))
        }
        this.sort = (predicat)=>{
           if (this.predicat === predicat) {
            this.reverse = !this.reverse;
        }
        this.predicat = predicat;
        }
       
})
.filter('ptExclam', function(){

    return function(str, nb){
        if(typeof str !== 'string') return '';
        return  str+'!'.repeat(nb);
    }
        
});