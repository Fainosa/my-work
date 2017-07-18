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
    populateList(meciuri);


    var titlu = document.getElementById("titlu");
    var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
    getCompetitieById(getCompetitieByIdUrl);

    var dataIncepereValue = new Date(competitie.dataIncepere);
    var dataTerminareValue = new Date(competitie.dataTerminare);

    titlu.innerHTML = "<p>" + competitie.nume + "</p>" + "<p>" + dataIncepereValue.getDate() + '/' + (dataIncepereValue.getMonth() + 1) + '/' + dataIncepereValue.getFullYear() + " - "
        + dataTerminareValue.getDate() + '/' + (dataTerminareValue.getMonth() + 1) + '/' + dataTerminareValue.getFullYear() + "</p>";

});

function schimbaData(){
    var x=document.getElementById("m_picker");

 if(x.value=="2017-07-19")
    {

       populateList(meciuri);

  $("#list").empty();
  $("#list").append(line);

    }


    if(x.value=="2017-07-20")
    {

      var content2 = "";

           var line = '<li>' + "Bulls" + '<span> vs </span>' + "Knicks" + '</li>';
                  content2 = content2 + line;

  $("#list").empty();
  $("#list").append(line);

    }

       if(x.value=="2017-07-21")
        {

          var content2 = "";

               var line = '<li>' + "Cleveland" + '<span> vs </span>' + "Portland" + '</li>';
                      content2 = content2 + line;

      $("#list").empty();
      $("#list").append(line);

        }


}

function populateList(data) {
    var content = "";

    $.each(data, function (i, item) {
        if(item != null) {
            var line = '<li>' + item.echipe[0].numeEchipa + '<span> vs </span>' + item.echipe[1].numeEchipa + '</li>';
            content = content + line;
        }
    });

    $('#list').html(content);

    $.each($('#list li'), function (i, item) {
        $(item).click(function () {
            var test = item.innerText;
            var words = test.split(" ");

            window.open('edit.html?echipa1=' + words[0] + '&echipa2=' + words[2])
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










