var echipeUrl = "http://localhost:8088/custom/echipe";
var meciuriUrl = "http://localhost:8088/meci/all";

var meciuri = {};
var competitie;

$(document).ready(function() {
    $('#teamTable').DataTable({
        "ajax" : {
                    "url" : echipeUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "loc" },
            { "data": "nume" },
            { "data": "cosuriMarcate" },
            { "data": "cosuriPrimite" },
            { "data": "victorii" },
            { "data": "infrangeri" },
            { "data": "punctaj" }
        ]
    });

    getMeciuri(meciuriUrl);
    populateList(meciuri)

 var titlu = document.getElementById("titlu");
           var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
                                  getCompetitieById(getCompetitieByIdUrl);

            console.log(competitie.nume);
           titlu.innerHTML="<p>"+ competitie.nume+"</p>"
                    +"<p>"+ competitie.dataIncepere+"-" +competitie.dataTerminare+"</p>";
                      console.log(titlu);


} );

function populateList(data) {
    var content = "";

    $.each(data, function(i, item) {
        var line = '<li>' + item.echipe[0].numeEchipa + '<span> vs </span>' + item.echipe[1].numeEchipa +  '</li>';
        content = content + line;
    });

    $('#list').html(content);

     $('#list').click(function() {
                window.open("edit.html");
        });


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










