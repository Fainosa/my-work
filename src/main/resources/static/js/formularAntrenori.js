var echipeUrl = 'http://localhost:8088/echipa/all';
var echipaObject;
var postUrl = 'http://localhost:8088/antrenor/add/';

$(document).ready(function () {


    getData(echipeUrl);

    $("#btn_submit").on("click", function () {

        var nume = $('#nume').val();
        var prenume = $('#prenume').val();

        $('input[type="date"]').change(function () {
            var inputDate = new Date(this.value);
        });

        var bday = $("#bday").val();
        alert(bday);
        var email = $('#email').val();
        var telefon = $('#telefon').val();
        var echipa = $('#drop-down :selected').text();

        var numeEchipaForBrowser = echipa.replace(" ", "%20");

        var getEchipaByNameUrl = "http://localhost:8088/echipa/name/" + numeEchipaForBrowser;
        getEchipaByName(getEchipaByNameUrl);

        var echipaJson = toObject(echipaObject);
        console.log(echipaJson);

        var antrenor = {};

        antrenor.nume = nume;
        antrenor.prenume = prenume;
        antrenor.data = bday;
        antrenor.eMail = email;
        antrenor.telefon = telefon;
        antrenor.echipa = echipaJson;

        console.log(antrenor);

        saveAntrenor(antrenor)

    });
});

$.postJSON = function (url, data, callback) {
    return jQuery.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': 'http://localhost:8088/antrenor/add/',
        'data': JSON.stringify(data),
        'dataType': 'json',

    });
};

function saveAntrenor(data) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': postUrl,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': alert("OBJECT SAVED!")
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

function toObject(arr) {
    var rv = {};
    for (var i = 0; i < arr.length; ++i)
        rv[i] = arr[i];
    return rv;
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

