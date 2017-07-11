var echipeUrl = "http://localhost:8088/custom/echipe";

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






