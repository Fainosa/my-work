var echipeUrl = "http://localhost:8088/custom/echipe";
var meciuriUrl = "http://localhost:8088/meci/all";

var meciuri = {};
var competitie;

$(document).ready(function () {
    $('#teamTable').DataTable({
        "ajax": {
            "url": echipeUrl,
            "dataSrc": ''
        },
        "columns": [
            {"data": "loc"},
            {"data": "nume"},
            {"data": "cosuriMarcate"},
            {"data": "cosuriPrimite"},
            {"data": "victorii"},
            {"data": "infrangeri"},
            {"data": "punctaj"}
        ]
    });

    getMeciuri(meciuriUrl);
    populateList(meciuri)


    var titlu = document.getElementById("titlu");
    var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
    getCompetitieById(getCompetitieByIdUrl);
    console.log(competitie.nume);

    var dataIncepereValue = new moment(competitie.dataIncepere, 'MM/DD/YYYY').toDate()
    var dataTerminareValue = new moment(competitie.dataTerminare, 'MM/DD/YYYY').toDate()

    //var dateString = moment.unix(value).format("MM/DD/YYYY");

    titlu.innerHTML = "<p>" + competitie.nume + "</p>" + "<p>" + dataIncepereValue + "-" + dataTerminareValue + "</p>";
    console.log(titlu);


});

function populateList(data) {
    var content = "";

    $.each(data, function (i, item) {
        var line = '<li>' + item.echipe[0].numeEchipa + '<span> vs </span>' + item.echipe[1].numeEchipa + '</li>';
        content = content + line;
    });

    // var lines = $('#list li')[0];
    // console.log(lines)


    $('#list').html(content);

    $.each($('#list li'), function (i, item) {
        $(item).click(function () {
            var test = item.innerText;
            var words = test.split(" ");
            console.log(words)

            window.open('edit.html?echipa1=' + words[0] + '$echipa2=' + words[2])

        });

    })

}

function getMeciuri(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            meciuri = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getCompetitieById(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            competitie = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}










