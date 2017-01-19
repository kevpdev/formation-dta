
class SoundBoxController{
    constructor(){}


$onInit() {
        this.sounds = [
            { url: 'http://192.168.99.41:1337/10415.mp3', title: 'SON 1' },
            { url: 'http://192.168.99.41:1337/3634.mp3', title: 'SON 2' },
            { url: 'http://192.168.99.41:1337/4072.mp3', title: 'SON 3' },
             { url: 'http://192.168.99.41:1337/6111.mp3', title: 'SON 4' }
        ];
    }

    delete(sound) {
        this.sounds = this.sounds.filter(s => s !== sound);
    }

    
}
export const DtaSoundBox = {

    template: require('./dta-sound-box.component.html'),
    controller: SoundBoxController
        
    }