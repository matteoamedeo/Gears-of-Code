console.log('profilo');
let bottoneEdit = document.getElementById('edit')
let bottoneSend = document.getElementById('invia-modifiche')
let inputNome = document.getElementById('inpNomeUtente')
let inputPass = document.getElementById('inputPassword')
let inputEmail = document.getElementById('inputEmail')
let nuovoNome;
let nuovaEmail;
let nuovaPass;
let arrNome = []
let arrEmail = []
let arrPass = []
const logo = document.getElementById('logo')


bottoneEdit.addEventListener('click', () => {
    inputNome.removeAttribute('readonly')
    inputPass.removeAttribute('readonly')
    inputEmail.removeAttribute('readonly')
    bottoneSend.removeAttribute('disabled')
    
    inputNome.addEventListener('keyup', (e) => {
        arrNome.push(e.key)
    })
    inputEmail.addEventListener('keyup', (e) => {
        arrEmail.push(e.key)
    })
    inputPass.addEventListener('keyup', (e) => {
        arrPass.push(e.key)
    })

})
bottoneSend.addEventListener('click', () => {

    nuovoNome = arrNome.join('')
    inputNome.setAttribute('value', nuovoNome)

    nuovaEmail = arrEmail.join('')
    inputEmail.setAttribute('value', nuovaEmail)

    nuovaPass = arrPass.join('')
    inputPass.setAttribute('value', nuovaPass)

    inputNome.setAttribute('readonly', 'readonly')
    inputPass.setAttribute('readonly', 'readonly')
    inputEmail.setAttribute('readonly', 'readonly')

})

