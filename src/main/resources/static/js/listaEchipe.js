var echipaUrl="http://localhost:8088/echipa/all";
var echipa;
var jucator;
var editor;


$(document).ready(function() {

//editor = new $.fn.dataTable.Editor( {
//          ajax: "../php/staff.php",
//          table: "#echipaTanle",
//          fields: [ {
//                  label: "",
//                  name: "id"
//              }, {
//                  label: "Nume Echipa:",
//                  name: "numeEchipa"
//              }, {
//                  label: "Locatie:",
//                  name: "locatie"
//              }
//          ]
//      } );
//
//   $('#echipaTable').on( 'click', 'tbody td:not(:first-child)', function (e) {
//          editor.inline( this );
//      } );
 var table= $('#echipaTable').DataTable({
        "ajax" : {
                    "url" : echipaUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "id" },
            { "data": "numeEchipa" },
            { "data": "locatie" },
            { "data": "dataInfiintare" }
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

    var header = document.getElementById("numeEchipa");
    header.innerHTML =  echipa.numeEchipa +"</br>" + echipa.locatie;

      var getJucatorByIdUrl = "http://localhost:8088/jucator/" + data.id;
            getJucatorById(getJucatorByIdUrl);

     if(getEchipaByIdUrl)
     {
      listaJucatori.innerHTML +="<li style='text-align: center; font-size: 20px; font-family: serif;'>"
      +"Nume : " +jucator.nume+" "+jucator.prenume +"</li>" ;
     }
     else
     {
      listaJucatori.innerHTML +="<li style='text-align: center; font-size: 20px; font-family: serif;'>"
      + " " +"</li>" ;
     }


    modal.style.display = "block";
  } );
} );


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






