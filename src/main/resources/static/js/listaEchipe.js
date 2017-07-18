var echipaUrl="http://localhost:8088/echipa/all";
var echipa={};
var jucator;
var editor;
var antrenor;


$(document).ready(function() {

 var table= $('#echipaTable').DataTable({
        "ajax" : {
                    "url" : echipaUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "id" },
            { "data": "numeEchipa" },
            { "data": "locatie" },
            { "data": "descriere" }
        ],
        select: {
                    style:    'os',
                    selector: 'td:first-child'
                },
                buttons: [
                    { extend: "create", editor: editor },
                    { extend: "edit",   editor: editor },
                    { extend: "remove", editor: editor }
                ]

    });

  // Get the modal
  var modal = document.getElementById('myModal');

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
      modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
  }

  $('#echipaTable ').on('click', 'tr', function () {

    var listaJucatori = document.getElementById("listaJucatori");
    listaJucatori.innerHTML = '';
    var data = table.row( this ).data();

    var getEchipaByIdUrl = "http://localhost:8088/echipa/" + data.id;
            getEchipaById(getEchipaByIdUrl);

    if(echipa.imagineUrl != null) {
                // get existing photo from entityImages that have names like: jucator1.png if jucator.id = 1
                $("#j_imgUpload").attr("src", "images/entityImages/e" + echipa.id + ".png");
            } else {
                $("#j_imgUpload").attr("src", "images/entityImages/antrenor.png");
            }

    var header = document.getElementById("numeEchipa");
    header.innerHTML =  echipa.numeEchipa +"</br>" + echipa.locatie;

      var getJucatorByIdUrl = "http://localhost:8088/jucator/" + data.id;
            getJucatorById(getJucatorByIdUrl);

      var getAntrenorByIdUrl = "http://localhost:8088/antrenor/" + data.id;
            getAntrenorById(getAntrenorByIdUrl);


      listaJucatori.innerHTML +="<li style='text-align: center; font-size: 20px; font-family: serif;'>"
      +"Nume : " +jucator.nume+" "+jucator.prenume +"</li>" ;

//  $.each(echipa, function(i, item) {
//        listaJucatori.innerHTML += '<li>' + item.jucatori[0].nume +'</li>';
//
//    });

 //listaJucatori.innerHTML+=populateList(echipa);


     $("#delete-btn").on("click", function () {
            var url = "http://localhost:8088/echipa/delete/" + echipa.id;
            $.ajax({
                url: url,
                type: 'DELETE',
                async: false,
                success: function () {
                   alert("Echipa a fost stearsa din sistem!")
                   window.open("listaEchipe.html");
                   window.close();
                },
                error: function (xhr, message, errorThrown) {
                    // alert(errorThrown);
                }
            });
        });

    modal.style.display = "block";
  } );
} );


function populateList(data) {
    var content = "";

    $.each(data, function(i, item) {
        var line = '<li>' + item.jucatori[0].nume +'</li>';
        content = content + line;
    });

    $('#list').html(content);

     $('#list').click(function() {
                window.open("edit.html");
        });


}

function getEchipaById(api) {
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

function getAntrenorById(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            antrenor = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}




