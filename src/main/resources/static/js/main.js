var echipeUrl = 'http://localhost:8088/echipa/all';
var myTableObject;

$(document).ready(function() {
    //
    // $('#teamTable').DataTable({
    //     "processing" : true,
    //     "ajax" : {
    //         "url" : echipeUrl,
    //         dataSrc : ''
    //     },
    //     "columns" : [ {
    //         "data" : "nume"
    //     }, {
    //         "data" : "cosuriMarcate"
    //     }, {
    //         "data" : "cosuriPrimite"
    //     }, {
    //         "data" : "victorii"
    //     }, {
    //         "data" : "infrangeri"
    //     }, {
    //         "data" : "punctaj"
    //     }]
    // });

    $('#teamTable').DataTable({
        "ajax" : {
                    "url" : echipeUrl,
                    "dataSrc": ''
                },
        "columns" : [ {
            "data" : "nume"
        }, {
            "data" : "cosuriMarcate"
        }, {
            "data" : "cosuriPrimite"
        }, {
            "data" : "victorii"
        }, {
            "data" : "infrangeri"
        }, {
            "data" : "punctaj"
        }]
    });


    // $.ajax({
    //     url : echipeUrl,
    //     type : 'GET',
    //     dataType : 'json',
    //     success : function(data) {
    //         assignToEventsColumns(data);
    //     }
    // });
    //
    // function assignToEventsColumns(data) {
    //     var table = $('#teamTable').dataTable({
    //         "bAutoWidth" : false,
    //         "aaData" : data,
    //         "columns" : [ {
    //             "data" : 'data.nume'
    //         }, {
    //             "data" : "cosuriMarcate"
    //         }, {
    //             "data" : "cosuriPrimite"
    //         }, {
    //             "data" : "victorii"
    //         }, {
    //             "data" : "infrangeri"
    //         }, {
    //             "data" : "punctaj"
    //         }]
    //     })
    // }


} );

function processDataForTable(data) {
    myTableObject = Object.assign({}, data);

    $.each(data, function(i, item) {
        myTableObject[i].punctaj = 2 * Number(data[i].victorii[0].numarVictorii) + Number(data[i].infrangeri[0].numarInfrangeri);
    });

    var myTableObjectArray = $.map(myTableObject, function(value, index) {
        return [value];
    });

    myTableObjectArray.sort(function(a, b) {
        return parseInt(b.punctaj) - parseInt(a.punctaj);
    });

    // $('#example').DataTable();
    // //
    // $.each(myTableObjectArray, function(i, item) {
    //     $('#teamTable tr:last').after('<tr><td>' + ++i + '</td>' +
    //         '<td>' + item.numeEchipa + '</td>' +
    //         '<td>' + item.cosuriMarcate + '</td>' +
    //         '<td>' + item.cosuriPrimite + '</td>' +
    //         '<td>' + item.victorii[0].numarVictorii + '</td>' +
    //         '<td>' + item.infrangeri[0].numarInfrangeri + '</td>' +
    //         '<td>' + item.punctaj + '</td>' +
    //     '</tr>')
    //   });


    // $('#teamTable').DataTable().css('background-color', 'white');
    //


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






