$(document).ready(function() {
 var table = $('#example').DataTable();

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

  var jucatori = [{
      'nume':'Ceva',
      'prenume':'Ceva1',
    },
    {
      'nume':'Ceva',
      'prenume':'Ceva1',
    },
    {
      'nume':'Ceva',
      'prenume':'Ceva1',
    }];

  $('#example tbody').on('click', 'tr', function () {
    var listaJucatori = document.getElementById("listaJucatori");
    listaJucatori.innerHTML = '';
    var data = table.row( this ).data();
    var header = document.getElementById("numeEchipa");
    header.innerHTML = data[0];

    for (var i =0; i<jucatori.length; i++) {
      listaJucatori.innerHTML += "<li>" + jucatori[i].nume + "</li>";
    }




    modal.style.display = "block";
  } );
} );
