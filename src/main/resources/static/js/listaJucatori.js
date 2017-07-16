var jucatorUrl = "http://localhost:8088/jucator/all";

var jucatorObject;
var jucator;

var echipa;


$(document).ready(function () {
    var table = $('#jucatorTable').DataTable({
        "ajax": {
            "url": jucatorUrl,
            "dataSrc": ''
        },
        "columns": [
            {"data": "id"},
            {"data": "nume"},
            {"data": "prenume"},
            {"data": "dataNasterii"},
            {"data": "eMail"}
        ]

    });

    getData(jucatorUrl);

    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }


    $('#jucatorTable tbody').on('click', 'tr', function () {

        var lista = document.getElementById("listaJucatori");
        lista.innerHTML = '';
        var data = table.row(this).data();
        var getJucatorByIdUrl = "http://localhost:8088/jucator/" + data.id;
        getJucatorById(getJucatorByIdUrl);

        var header = document.getElementById("numeJucator");
        header.innerHTML = "Nume : "+jucator.nume + " " + jucator.prenume + "</br>"+ "Numar : "+jucator.numarJucator;

        var getEchipaByJucatorUrl = 'http://localhost:8088/echipa/jucator/' + jucator.id;
        getEchipaByJucator(getEchipaByJucatorUrl);

        console.log("echipa", echipa);

        lista.innerHTML = "<li style='text-align: center; font-size: 20px; font-family: serif;'>"
            + " Greutate : " + jucator.greutate + "</br> "
            + " Inaltime : " + jucator.inaltime + "</br>"
            + " Echipa : " + echipa.numeEchipa + "</li>";



        modal.style.display = "block";
    });


});

function getData(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            jucatorObject = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getEchipaByJucator(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            echipa = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getJucatorById(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            jucator = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}





