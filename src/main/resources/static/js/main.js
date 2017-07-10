var echipeUrl = 'http://localhost:8088/echipa/all';
var myTableObject;

$(document).ready(function() {
    getData(echipeUrl);

    $('#example').DataTable();
} );

function processDataForTable(data) {
    myTableObject = Object.assign({}, data);


    $.each(data, function(i, item) {
        console.log('data' , Number(data[i].infrangeri[0].numarInfrangeri));
        myTableObject[i].punctaj = 2 * Number(data[i].victorii[0].numarVictorii) + Number(data[i].infrangeri[0].numarInfrangeri);
    });

    var myTableObjectArray = $.map(myTableObject, function(value, index) {
        return [value];
    });

    myTableObjectArray.sort(function(a, b) {
        return parseInt(b.punctaj) - parseInt(a.punctaj);
    });

    $.each(myTableObject, function(i, item) {
        $('#example').append('<tr class="child">');
        $('#example').append('<td> ++i </td>');
        $('#example').append('<tr class="child"><td> item[i].numeEchipa</td></tr>');
        $('#example').append('<tr class="child"><td> item[i].cosuriMarcate</td></tr>');
        $('#example').append('<tr class="child"><td> item[i].cosuriPrimite</td></tr>');
        $('#example').append('<tr class="child"><td> item[i].victorii[0].numarVictorii</td></tr>');
        $('#example').append('<tr class="child"><td> item[i].infrangeri[0].numarInfrangeri</td></tr>');
        $('#example').append('<tr class="child"><td> item[i].punctaj</td></tr>');
        $('#example').append('</tr');
    });


    console.log(myTableObjectArray)

}

function highest(data){
    return [].slice.call(arguments).sort(function(a,b){
        return b - a;
    });
}


function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'json',
        async : false,
        success : function(data) {
           processDataForTable(data);
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
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






