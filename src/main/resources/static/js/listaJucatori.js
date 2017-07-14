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
console.log(items);
    $("#populatePopUp").append(items);
}



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

