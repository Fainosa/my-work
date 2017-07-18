var antrenorUrl="http://localhost:8088/antrenor/all";

var antrenorObject;
var antrenor;

var echipa;

$(document).ready(function() {
var table= $('#antrenorTable').DataTable({
        "ajax" : {
                    "url" : antrenorUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "id" },
            { "data": "nume" },
            { "data": "prenume" },
            { "data": "descriere" },
            { "data": "eMail" },
            { "data": "telefon"}
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

  $('#antrenorTable tbody').on('click', 'tr', function () {
    var listaAntrenori = document.getElementById("listaAntrenori");
    listaAntrenori.innerHTML = '';
    var data = table.row( this ).data();

     var getAntrenorByIdUrl = "http://localhost:8088/antrenor/" + data.id;
                getAntrenorById(getAntrenorByIdUrl);

    var header = document.getElementById("numeAntrenor");
   header.innerHTML = antrenor.nume+ " "+antrenor.prenume;

   var getEchipaByAntrenorUrl = 'http://localhost:8088/echipa/antrenor/' + antrenor.id;
          getEchipaByAntrenor(getEchipaByAntrenorUrl);

          console.log("echipa", echipa);
      listaAntrenori.innerHTML = "<li style='text-align: center; font-size: 20px; font-family: serif;'>"+"Echipa:"+echipa.numeEchipa +"</li>";

      $("#delete-btn").on("click", function () {
                  var url = "http://localhost:8088/antrenor/delete/" + antrenor.id;
                  $.ajax({
                      url: url,
                      type: 'DELETE',
                      async: false,
                      success: function () {
                         alert("Antrenorul a fost sters din sistem!")
                         window.open("listaAntrenori.html");
                      },
                      error: function (xhr, message, errorThrown) {
                          // alert(errorThrown);
                      }
                  });
              });


    modal.style.display = "block";
  } );
} );


function getData(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            antrenorObject = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getEchipaByAntrenor(api) {
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




