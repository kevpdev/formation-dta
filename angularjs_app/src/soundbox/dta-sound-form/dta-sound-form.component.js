class SoundFormController{
    constructor(){
       
    }

    $onInit () {
    }


    saveSound(form, sound){
  console.log('sound : '+sound);
 if (form.$invalid) return;
       this.onSubmit({
           $event: this.sound
       });
    }


    
}
export const DtaSoundForm = {
 bindings: {
     sound:'<',   onAdd: '&'
    },  
    template: require('./dta-sound-form.component.html'),
    controller: SoundFormController
        
    }