var jucatorUrl="http://localhost:8088/jucatorCustom/jucatori";

$(document).ready(function() {
  $('#jucatorTable').DataTable({
        "ajax" : {
                    "url" : jucatorUrl,
                    "dataSrc": ''
                },
        "columns": [
            { "data": "loc" },
            { "data": "nume" },
            { "data": "prenume" },
            { "data": "dataNasterii" },
            { "data": "eMail" }
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

  var jucator = [{
      'echipa':'ASDFGHJ',

    }];

  $('#example tbody').on('click', 'tr', function () {
    var listaJucatori = document.getElementById("listaJucatori");
    listaJucatori.innerHTML = '';
    var data = table.row( this ).data();
    var header = document.getElementById("numeJucator");
    header.innerHTML = data[0] + " " + data[1];

    for (var i =0; i<jucator.length; i++) {
      listaJucatori.innerHTML += "<li>" + jucator[i].echipa + "</li>";
    }
    modal.style.display = "block";
  } );


} );



$(function() {
  if ($.browser.msie && $.browser.version.substr(0,1)<7)
  {
    $('li').has('ul').mouseover(function(){
        $(this).children('ul').css('visibility','visible');
        }).mouseout(function(){
        $(this).children('ul').css('visibility','hidden');
        })
  }
});

/* Mobile */
$('#menu-wrap').prepend('<div id="menu-trigger">Menu</div>');
$("#menu-trigger").on("click", function(){
    $("#menu").slideToggle();
});

// iPad
var isiPad = navigator.userAgent.match(/iPad/i) != null;
if (isiPad) $('#menu ul').addClass('no-transition');

$(window).scroll(function(e){
  var $el = $('.fixedElement');
  var isPositionFixed = ($el.css('position') == 'fixed');
  if ($(this).scrollTop() > 200 && !isPositionFixed){
    $('.fixedElement').css({'position': 'fixed', 'top': '0px'});
  }
  if ($(this).scrollTop() < 200 && isPositionFixed)
  {
    $('.fixedElement').css({'position': 'static', 'top': '0px'});
  }
});

