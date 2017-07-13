var echipeUrl="http://localhost:8088/echipa/all";


$(document).ready(function() {
   getData(echipeUrl);

$("#btn_submit" ).on( "click", function() {
    alert("fghjkfgh");
});
});

function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'json',
        async : false,
        success : function(data) {
            populateDropdown(data);
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function populateDropdown(data) {
    var myOption = [];

     $.each(data, function(i, item) {
           myOption[i] = item.numeEchipa;
        });

    var items;
    for (var i=0; i< myOption.length; i++){
        items += "<option>" + myOption[i] + "</option>";
    }

    $("#drop-down").append(items);
}


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



