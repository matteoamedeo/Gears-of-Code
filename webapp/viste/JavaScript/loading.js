
const myTimeout = setTimeout(loadHomepage, 5000);

function loadHomepage() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "viste/HTML/index.jsp", true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        document.getElementsByTagName('html')[0].innerHTML = this.responseText
    }
}