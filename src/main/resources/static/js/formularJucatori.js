var echipeUrl = 'http://localhost:8088/echipa/all';
var echipaObject;

$(document).ready(function () {
    getData(echipeUrl);

    $("#j_btn_submit").on("click", function () {

        var nume = $('#j_nume').val();
        var prenume = $('#j_prenume').val();

        $('input[type="date"]').change(function () {
            var inputDate = new Date(this.value);
        });

        var bday = $("#j_bday").val();

        var email = $('#j_email').val();
        var inaltime = $('#j_inaltime').val();
        var greutate = $('#j_greutate').val();

        var echipa = $('#j_drop-down :selected').text();
        var numeEchipaForBrowser = echipa.replace(" ", "%20");
        var getEchipaByNameUrl = "http://localhost:8088/echipa/name/" + numeEchipaForBrowser;

        getEchipaByName(getEchipaByNameUrl);
        var id_echipa = echipaObject[0].id;

        var jucator = {};
        jucator.nume = nume;
        jucator.prenume = prenume;
        jucator.data = bday;
        jucator.eMail = email;
        jucator.inaltime = inaltime;
        jucator.greutate = greutate;
        jucator.dataNasterii = bday;

        var postUrl = 'http://localhost:8088/jucator/addEchipa/' + id_echipa;

        saveJucator(postUrl, jucator)

    });

      function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#imgUpload').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files[0]);

                    input.files[0].nume = "poza.jpg";
                    console.log("poza", input.files[0].nume);
                }
            }

});

function saveJucator(url, data) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'PUT',
        'url': url,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function () {
           alert("Jucatorul a fost introdus in sistem!");
            window.open("listaJucatori.html");
            $('#j_nume').val("");
            $('#j_prenume').val("");
            $('#j_email').val("");
            $('#j_inaltime').val("");
            $('#j_greutate').val("");
        }
    });
}

function getData(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            populateDropdown(data);
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getEchipaByName(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            console.log(data);
            echipaObject = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function populateDropdown(data) {
    var myOption = [];

    $.each(data, function (i, item) {
        myOption[i] = item.numeEchipa;
    });

    var items;
    for (var i = 0; i < myOption.length; i++) {
        items += "<option>" + myOption[i] + "</option>";
    }

    $("#j_drop-down").append(items);
}





