var echipeUrl = 'http://localhost:8088/echipa/all';
var echipaObject;

$(document).ready(function () {
    getData(echipeUrl);

    $("#btn_submit").on("click", function () {

        var nume = $('#nume').val();
        var prenume = $('#prenume').val();

        $('input[type="date"]').change(function () {
            var inputDate = new Date(this.value);
        });

        var bday = $("#bday").val();
        var email = $('#email').val();
        var telefon = $('#telefon').val();
        var echipa = $('#drop-down :selected').text();

        var numeEchipaForBrowser = echipa.replace(" ", "%20");
        var getEchipaByNameUrl = "http://localhost:8088/echipa/name/" + numeEchipaForBrowser;
        getEchipaByName(getEchipaByNameUrl);

        var id_echipa = echipaObject[0].id;

        var antrenor = {};
        antrenor.nume = nume;
        antrenor.prenume = prenume;
        antrenor.data = bday;
        antrenor.eMail = email;
        antrenor.telefon = telefon;

        var postUrl = 'http://localhost:8088/antrenor/addEchipa/' + id_echipa;

        saveAntrenor(postUrl, antrenor)
    });

    function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#imgUpload').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#imgInp").change(function(){
            readURL(this);
        });
});

function saveAntrenor(url, data) {
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
            alert("Antrenorul a fost introdus in sistem!");
            $('#nume').val("");
            $('#prenume').val("");
            $('#email').val("");
            $('#telefon').val("");
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

    $("#drop-down").append(items);
}

