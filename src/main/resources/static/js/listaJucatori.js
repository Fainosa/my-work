var jucatorUrl = "http://localhost:8088/jucator/all";

var jucatorObject;
var jucator;


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

        var lista = $("#listaJucatori");
        listaJucatori.innerHTML = '';
        var data = table.row(this).data();
        console.log("dataaaa", data)

    // var header = document.getElementById("numeJucator");
    // header.innerHTML = data.nume+ " "+data.prenume;


        // if (data.id == jucatorObject.id) {
            var getJucatorByIdUrl = "http://localhost:8088/jucator/" + data.id;
            getJucatorById(getJucatorByIdUrl);

            console.log('jucator', jucator);

        var header = document.getElementById("numeJucator");
        header.innerHTML = jucator.nume+ " "+jucator.prenume;

            lista.innerHTML = "<li>" + jucator.eMail + "</li>";
            console.log(jucator.eMail);
        // }
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





