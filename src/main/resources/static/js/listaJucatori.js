var jucatorUrl="http://localhost:8088/jucator/all";
var jucator;
$(document).ready(function() {
 var table= $('#jucatorTable').DataTable({
        "ajax" : {
                    "url" : jucatorUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "id" },
            { "data": "nume" },
            { "data": "prenume" },
            { "data": "dataNasterii" },
            { "data": "eMail" }
        ]

    });
    getData(jucatorUrl);

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

  var jucator = [{
      'echipa':'ASDFGHJ',

    }];

  $('#jucatorTable tbody').on('click', 'tr', function () {

    var listaJucatori = document.getElementById("listaJucatori");
    listaJucatori.innerHTML = '';
    var data = table.row( this ).data();
    var header = document.getElementById("numeJucator");
    header.innerHTML = data.nume+ " "+data.prenume;

    for (var i =0; i<jucator.length; i++) {
      listaJucatori.innerHTML += "<li>" + jucator[i].greutate + "</li>";
    }
    modal.style.display = "block";
  } );



} );

function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'json',
        async : false,
        success : function(data) {
        populatePopUp(data);
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function populatePopUp(data) {
    var myOption = [];

     $.each(data, function(i, item) {
           myOption[i] = item.greutate +" " +item.inaltime;

        });

    var items;
    for (var i=0; i< myOption.length; i++){
        items += "<option>" + myOption[i] + "</option>";
    }
    $("#populatePopUp").append(items);
}



