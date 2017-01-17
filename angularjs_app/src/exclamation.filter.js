export function ExclamationFilter () {

     return function(str, nb){
         if(typeof str !== 'string') return '';
         return  str+'!'.repeat(nb);
     }
}