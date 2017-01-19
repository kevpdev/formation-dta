import angular from 'angular';
import { DtaSoundButton } from './dta-sound-btn/dta-sound-btn.component';
import { DtaSoundBox } from './dta-sound-box/dta-sound-box.component';
import { DtaSoundForm } from './dta-sound-form/dta-sound-form.component';


export default angular.module('soundbox', [])

.component('soundButton', DtaSoundButton)
.component('soundBox', DtaSoundBox)
.component('soundForm', DtaSoundForm)
.name;