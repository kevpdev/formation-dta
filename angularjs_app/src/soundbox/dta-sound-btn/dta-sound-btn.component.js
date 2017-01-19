import css from './dta-sound-btn.component.css';
class SoundButtonController{
    constructor ($scope) {
        this.$scope = $scope;
    }


    $onChanges (changes) {
        console.log(changes);
        if (changes.sound && changes.sound.currentValue) {
            this.audio = new Audio(changes.sound.currentValue.url);
            this.title = changes.sound.currentValue.title || changes.sound.currentValue.url.split('/').pop();
            this.audio.onended = () => this.$scope.$apply();
        }
    }

    play () {
       if (this.audio.paused) {
           this.audio.play(); 
       this.played = true;
       }
        else {
            this.audio.pause();
            this.played = false;
            this.audio.currentTime = 0;
        }
    }

      delete () {
      this.onDelete();
    }

    
}
export const DtaSoundButton = {
 bindings: {
        sound: '<',
            onDelete: '&'
    },  
    template: require('./dta-sound-btn.component.html'),
    controller: SoundButtonController
        
    }