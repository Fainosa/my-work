var competitieUrl = "http://localhost:8088/competitie/all";
var competitie;

var meciuriUrl = "http://localhost:8088/meci/all";
var meciuri = {};

var echipaByNameURL = "http://localhost:8088/echipa/name/"

var team1;
var team2;

$(document).ready(function () {

    var url = window.location.href;

    var url = new URL(url);
    var echipa1_name = url.searchParams.get("echipa1");
    var echipa2_name = url.searchParams.get("echipa2");
    console.log(echipa1_name + "   " + echipa2_name);

    document.getElementById("e1_nume").innerHTML = echipa1_name;
    document.getElementById("e2_nume").innerHTML = echipa2_name;

    var interval;
    var minutes = 10;
    var seconds = 0;

    function countdown(element) {
        interval = setInterval(function () {
            var el = document.getElementById(element);
            if (seconds == 0) {
                if (minutes == 0) {
                    alert(el.innerHTML = "countdown's over!");
                    clearInterval(interval);
                    return;
                } else {
                    minutes--;
                    seconds = 60;
                }
            }
            if (minutes > 0) {
                var minute_text = minutes + (minutes > 1 ? ' minutes' : ' minute');
            } else {
                var minute_text = '';
            }
            var second_text = seconds > 1 ? 'seconds' : 'second';
            el.innerHTML = minute_text + ' ' + seconds + ' ' + second_text + ' remaining';
            seconds--;
        }, 1000);
    }

    $('#addOneFirst').click(function () {
        $('#pointsFirst').html(function (i, val) {
            return val * 1 + 1
        });
    });

    $('#addTwoFirst').click(function () {
        $('#pointsFirst').html(function (i, val) {
            return val * 1 + 2
        });
    });


    $('#addOneSecond').click(function () {
        $('#pointsSecond').html(function (i, val) {
            return val * 1 + 1
        });
    });

    $('#addTwoSecond').click(function () {
        $('#pointsSecond').html(function (i, val) {
            return val * 1 + 2
        });
    });

    $('#stopCompetition').click(function () {
        var startStop = $('#stopCompetition').html();
        switch (startStop) {
            case "STOP MECI":
                clearInterval(interval);
                document.getElementById("stopCompetition").innerHTML = "START MECI";
                break;

            case "START MECI":
                countdown('timer');
                document.getElementById("stopCompetition").innerHTML = "STOP MECI";
                break;
        }
    })


    var titlu = document.getElementById("titlu");
    var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
    getCompetitieById(getCompetitieByIdUrl);

    var dataIncepereValue = new Date(competitie.dataIncepere);
    var dataTerminareValue = new Date(competitie.dataTerminare);


    titlu.innerHTML = "<p>" + competitie.nume + "</p>" + "<p>" + dataIncepereValue.getDate() + '/' + (dataIncepereValue.getMonth() + 1) + '/' + dataIncepereValue.getFullYear() + " - "
        + dataTerminareValue.getDate() + '/' + (dataTerminareValue.getMonth() + 1) + '/' + dataTerminareValue.getFullYear() + "</p>";

    getMeciuri(meciuriUrl);

    $('#finish').click(function () {
        var url1 = echipaByNameURL + echipa1_name;
        getEchipa1ByName(url1);
        var url2 = echipaByNameURL + echipa2_name;
        getEchipa2ByName(url2);

        var points1 = document.getElementById("pointsFirst").innerHTML;
        var points2 = document.getElementById("pointsSecond").innerHTML;

        // var team1Obj = toObject(team1);
        // console.log("svasvas",team1[0].numeEchipa)
        var team2Obj = toObject(team2);

        var newEchipa1 = {};
            newEchipa1.id = team1[0].id;
            newEchipa1.numeEchipa = team1[0].numeEchipa;
            newEchipa1.locatie = team1[0].locatie;
            newEchipa1.dataInfiintare = team1[0].dataInfiintare;
            newEchipa1.cosuriMarcate = points1;
            newEchipa1.cosuriPrimite = points2;
            newEchipa1.jucatori = team1[0].jucatori;
            newEchipa1.antrenori = team1[0].antrenori;
            newEchipa1.infrangeri = team1[0].infrangeri;
            newEchipa1.victorii = team1[0].victorii;
            newEchipa1.descriere = team1[0].victorii;
            newEchipa1.imagineUrl = team1[0].imagineUrl;

        // console.log(newEchipa1)
        //
        // updateEchipa(newEchipa1, echipa1_name)
        //
        // var infrangeri = team1[0].infrangeri;
        // console.log("infrangeri",infrangeri);

        var echipaCastigatoare = "";
        var echipaPierzatoare;
        var diff;

        if(points1 > points2) {
            echipaCastigatoare = echipa1_name;
            echipaPierzatoare = echipa2_name;
            diff = points1 - points2;
        } else {
            echipaCastigatoare = echipa2_name;
            echipaPierzatoare = echipa1_name;
            diff = points2 - points1;
        }

        alert("Echipa castigatoare este " + echipaCastigatoare + ", care a inscris " + points1 + " puncte");
        alert("Echipa " + echipaPierzatoare + " a pierdut la o diferenta de " + diff + " puncte");
    })


});

function toObject(arr) {
    var rv = {};
    for (var i = 0; i < arr.length; ++i)
        rv[i] = arr[i];
    return rv;
}


function getData(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            competitieObject = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

var updateUrl = 'http://localhost:8088/echipa/update';

function updateEchipa(data, nume) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'PUT',
        'url': updateUrl,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function () {
            alert("Echipa " + nume + " a fost actualizata!");
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

function getEchipa1ByName(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            team1 = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getEchipa2ByName(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            team2 = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

