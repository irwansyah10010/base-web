
$(document).ready(function(){
    $(".preloader").fadeOut();

    submitForm('form_signIn', {
        'username': 'nnull',
        'password': 'nnull'
    }, (errors)=>{
        // for (const [id, messages] of Object.entries(errors)) { 

        // }
    });

});

// $(document).ready(function(){
//     $('#btn-login').click(function(){
//         login();
//     });
//     $('#username').keypress(function(event){
//         return entsubLogin(event);
//     });
//     $('#password_plain').keypress(function(event){
//         return entsubLogin(event);
//     });

//     $('#show-password').on('click',()=>{

//         if($('#password_plain')[0].type == 'password'){
//             $('#password_plain')[0].type = 'text'
//         }else{
//             $('#password_plain')[0].type = 'password'
//         }

//     })
// });

// function entsubLogin(e) {
//     if (e.keyCode === 13) {
//         login();
//     } else {
//         return true;
//     }
// }
// function login() {
//     // if($('#username').val().length <= 0 || $('#password_plain').val().length <= 0){
//     //     // showToast('warning','Warning','Please fill username and password');
//     //     return;
//     // }
//     $('#password').val('');
//     $('#btn-login').attr('disabled', 'disabled');
//     $.get($('#url_auth_key').val(), function(resp){
//         var parsedKey = CryptoJS.enc.Hex.parse(resp.key);
//         var parsedIv = CryptoJS.enc.Hex.parse(resp.iv);
//         var encrypted = CryptoJS.AES.encrypt($('#password_plain').val(), parsedKey, {iv:parsedIv});
//         encrypted = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
//         $('#password').val(encrypted);
//         $('#password_plain').val('');
//         $('#form_signIn').submit();
//     });
// }