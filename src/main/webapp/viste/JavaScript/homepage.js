// http://localhost:8080/GearsOfCode/Index?comando=prova
//PREVENT DEFAULT

// for (let i = 0; i < document.forms.length; i++) {
//     document.forms[i].addEventListener('submit', (e) => e.preventDefault())
// }
// Array.from(document.getElementsByTagName('a')).forEach(element => {
//     element.addEventListener('click', (e) => e.preventDefault())
// });
// Array.from(document.getElementsByTagName('input')).forEach(element => {
//     element.addEventListener('submit', (e) => e.preventDefault())
// });
// Array.from(document.getElementsByTagName('form')).forEach(element => {
//     element.addEventListener('submit', (e) => e.preventDefault())
// });
// Array.from(document.getElementsByTagName('button')).forEach(element => {
//     element.addEventListener('click', (e) => e.preventDefault())
// });
// Array.from(document.getElementsByTagName('i')).forEach(element => {
//     element.addEventListener('click', (e) => e.preventDefault())
// });

const dataEsercizi = 'http://localhost:8080/GearsOfCode/Index?comando=apiEsercizi';
const dataSoluzioni = 'http://localhost:8080/GearsOfCode/Index?comando=apiSoluzioni';
const dataEserciziSoluzioni = 'http://localhost:8080/GearsOfCode/Index?comando=apiEserciziSoluzioni';

const body = document.getElementsByTagName('body')[0]
const listaLinguaggi = document.getElementById('lista-linguaggi')
const listaLvelli = document.getElementById('scelta-livello')
const livelli = document.querySelectorAll('#scelta-livello > ul > li')
const linguaggi = document.querySelectorAll('#lista-linguaggi > #ul-linguaggi > li')
const sideBar = document.getElementById('side-bar')
const barreSideBar = document.getElementsByClassName('barre-menu')
const livelloUtenteLoggato = document.getElementsByClassName('livello-utente-loggato')
const logo = document.getElementById('logo')
let aggiungiEsercizio = document.getElementById('aggiungi-esercizio')
let esercizi;
let soluzioni;
let eserciziGraficati = ''
const listaEsercizi = document.querySelector('#lista-esercizi > ul')
let linguaggio = document.getElementsByClassName('linguaggio-selezionato')[0].textContent
const idUtenteLoggato = document.getElementById('idUtente').textContent
let esercizioSelezionato;
let esercizi_soluzioni;
let eserciziDisponibili;
let arrSoluzioni = []

aggiungiEsercizio.addEventListener('click', () => {
    if (+livelloUtenteLoggato[0].title < 3) {
        aggiungiEsercizio.href = 'homepage.html'
        alert('devi essere di livello 3 per aggiungere esercizi')
    }
})

function getEsercizi(linguaggio, livello) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", dataEserciziSoluzioni, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        eserciziGraficati = ' '
        if (this.readyState == 4 && this.status == 200) {
            esercizi = JSON.parse(xhttp.responseText);
            for (let i = 0; i < esercizi.length; i++) {
                if (esercizi[i].linguaggio === linguaggio && esercizi[i].livello === livello) {
                
                    eserciziGraficati += '<li class="esercizio-disponibile">' +
                        '<textarea id="esercizio-titolo" class="input-prova" type="text" name="titolo"' +
                        'autocomplete="off" readonly cols="1" rows="1">' + esercizi[i].titolo + '</textarea>' +
                        '<input id="esercizio-punti"' +
                        'class="esercizio-punti input-prova" type="text" name="punti" autocomplete="off"' +
                        'value="' + esercizi[i].punti + '" readonly>' +
                        '<div id="test-esercizio">' +
                        '<input type="hidden" name="linguaggio" value="' + esercizi[i].linguaggio + '">' +
                        '<input type="hidden" name="idEsercizio" value="' + esercizi[i].id + '">' +
                        '<input type="hidden" name="livello" value="' + esercizi[i].livello + '">' +
                        '<input type="hidden" name="idUtente" value="' + idUtenteLoggato + '">' +
                        '<input class="caricaEsercizio" type="submit" value="Train" title="' + esercizi[i].id + '">' +
                        '</div>' +
                        '</li>'
                }
            }

            listaEsercizi.innerHTML = eserciziGraficati
            eserciziDisponibili = document.getElementsByClassName('esercizio-disponibile')
            pulsantiEserciziDisponibili = document.getElementsByClassName('caricaEsercizio')
            let esercizioScelto;
         
            Array.from(pulsantiEserciziDisponibili).forEach(pulsante => {
                pulsante.addEventListener('click', e => {
                    let posEsercizioScelto = e.path[0].title - 1
                    esercizioScelto = esercizi[posEsercizioScelto]
                   // console.log(esercizioScelto);
                    fetch('svolgimentoEsercizio2.jsp')
                        .then(function (response) {
                            return response.text()
                        }).then(function (html) {
                            body.innerHTML = html
                            const corpoEsercizio = document.getElementById('corpo')
                            let soluzioni = [esercizioScelto.opzione1, esercizioScelto.opzione2, esercizioScelto.opzione3]
                            let arr = [0, 1, 2]
                            let labels = document.getElementsByTagName('label')
                            let inputs = document.querySelectorAll('input[type="radio"]')
                           // console.log(inputs);
                            corpoEsercizio.innerHTML = esercizioScelto.corpoEsercizio + "<br>"
                            const labelsWrapper = document.querySelectorAll('#opzioni>div')
                            
                
                            for (let i = 0; i < soluzioni.length; i++) {
                                let random = Math.floor(Math.random() * arr.length)
                                labels[i].innerHTML = soluzioni[arr[random]]
                                if (esercizioScelto.opzione1 === soluzioni[arr[random]])
                                    labels[i].setAttribute('name', 'opzione1')
                                if (esercizioScelto.opzione2 === soluzioni[arr[random]])
                                    labels[i].setAttribute('name', 'opzione2')
                                if (esercizioScelto.opzione3 === soluzioni[arr[random]])
                                    labels[i].setAttribute('name', 'opzione3')
                                arr = arr.filter((item) => item != arr[random])
                            }
                            setHeight(labelsWrapper)
                             let inputEsercizio = document.querySelector('input[name="idEsercizio"]')
							inputEsercizio.setAttribute('value', esercizioScelto.id_esercizio)
                            Array.from(inputs).forEach(input => {
                                input.addEventListener('click', () => {
                                    rimuoviAttributo(inputs, 'checked')
                                    input.setAttribute('checked', 'checked')
                                })
                            });


                            let pulsanteTest = document.getElementById('invia')
                            let pulsanteForfait = document.getElementById('forfait')
                            let risultatoEsatto = document.getElementById('risultatoEsatto')
                            let risultatoErrato = document.getElementById('risultatoErrato')
                            let countEsatto = 0;
                            let inviaRisultato = document.getElementById('inviarisultato')
                            let inputRisultato = document.querySelector('input[name="risultatoesercizio"]')
                          // console.log(inputRisultato)
                            pulsanteTest.addEventListener('click', () => {
							
                                for (let i = 0; i < inputs.length; i++) {
                                    if (inputs[i].getAttribute('checked') === 'checked' && labels[i].getAttribute('name') === 'opzione1'){
											labels[i].parentElement.classList.add('esatto')
                                        countEsatto++
                                       }
                                       if (inputs[i].getAttribute('checked') === 'checked' && labels[i].getAttribute('name') !== 'opzione1'){
											labels[i].parentElement.classList.add('errato')
                                        countEsatto++
                                       }
                                }
                                if (countEsatto === 1) {
                                    risultatoEsatto.style.display = 'block'
                                    inputRisultato.setAttribute('value', 'true')
                                   // console.log(inputRisultato)
                                } else
                                    risultatoErrato.style.display = 'block'

                                inviaRisultato.style.display = 'block'

                                pulsanteForfait.addEventListener('click', () => {
                                    window.location.reload()
                                })
                            })
                        }).catch(function (err) {
                            console.log('Failed to fetch page: ', err);
                        });
                })
            });

        }

    }
}
getEsercizi('Java', 1)

//ADD EVENTO LISTENER

logo.addEventListener('click', ()=>{
	window.location.reload()
	console.log('reload')
})

sideBar.addEventListener('click', () => {
    listaLinguaggi.classList.toggle('mostra-side-bar')
    barreSideBar[0].classList.toggle('barra1')
    barreSideBar[1].classList.toggle('barra2')
    barreSideBar[2].classList.toggle('barra3')

})

for (let i = 0; i < livelli.length; i++) {
    livelli[i].addEventListener('click', () => {
        livelli[i].classList.add('livello-selezionato')
        getEsercizi(linguaggio, livelli[i].value)
    })
}
for (let i = 0; i < linguaggi.length; i++) {
    let livello = document.getElementsByClassName('livello-selezionato')[0].value
    linguaggi[i].addEventListener('click', () => {
        linguaggi[i].classList.add('linguaggio-selezionato')
        getEsercizi(linguaggi[i].textContent, livello)
    })
}

// FUNZIONI
function scegliLivello() {
    for (let i = 0; i < livelli.length; i++) {
        rimuoviClasse(livelli[i], 'livello-selezionato')
    }
}

function rimuoviClasse(array, classe) {
    for (let i = 0; i < livelli.length; i++)
        array.classList.remove(classe)
}

function rimuoviAttributo(array, attributo) {
    for (let i = 0; i < array.length; i++)
        array[i].removeAttribute(attributo);
}

function scegliLinguaggio() {
    for (let i = 0; i < linguaggi.length; i++) {
        rimuoviClasse(linguaggi[i], 'linguaggio-selezionato')
    }
}

function mostraEsercizio(esercizioJSON) {
    console.log(esercizioJSON);
    listaEsercizi.innerHTML = 'esercizio scelto: ' + "<br>" + esercizioJSON.titolo
    return esercizioJSON
}

   function setHeight(HTMLelement) {
        let arrHeight = []
        let maxHeight;
        for (let i = 0; i < HTMLelement.length; i++) {
            arrHeight.push(HTMLelement[i].clientHeight)
            arrHeight = arrHeight.sort()
        }
        maxHeight = arrHeight[arrHeight.length - 1]
        for (let i = 0; i < HTMLelement.length; i++)
            HTMLelement[i].style.height = `${maxHeight}px`
    }

