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

$(document).ready(function() {
    $('#example').DataTable();
} );

// Set the date we're counting down to
var countDownDate = new Date("Jul 5, 2017 15:37:25").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    document.getElementById("timer").innerHTML = days + "z " + hours + "o "
    + minutes + "m " + seconds + "s ";
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("timer").innerHTML = "EXPIRED";
    }
}, 1000);



var getDataUrl = "http://localhost:8088/graph/clasament-echipe";

$(document).ready(function() {
    // getData(getDataUrl);
    $("body").append('<div id="graph"></div>');
    // $("body").append('<div id="clasamentEchipa"></div>');
    
    drawLine()

});

function drawLine1(data) {
    new Morris.Bar({
        barGap : 4,
        barSizeRatio : 0.7,
        element : 'clasamentEchipa',
        data : data,
        xkey: 'x',
        ykeys: ['y'],
        labels: ['Y'],
        barColors: function (row, series, type) {
            if (type === 'bar') {
                var red = Math.ceil(255 * row.y / this.ymax);
                return 'rgb(' + red + ',0,0)';
            }
            else {
                return '#000';
            }
        }
    });
}
function drawLine() {
    Morris.Bar({
        element: 'graph',
        data: [
            {x: 'Boston Celtics', y: 25},
            {x: 'Brooklyn Nets', y: 29},
            {x: 'Chicago Bulls', y: 48},
            {x: 'Clevenad Cavaliers', y: 84},
            {x: 'Miami Heat', y: 33},
            {x: 'Orlango Magic', y: 45},
            {x: 'Denver Nuggets', y: 20},
            {x: 'Washington Wizards', y: 50},
            {x: 'New York Knicks', y: 73}
        ],
        xkey: 'x',
        ykeys: ['y'],
        labels: ['Puncte'],
        barColors: function (row, series, type) {
            if (type === 'bar') {
                var red = Math.ceil(255 * row.y / this.ymax);
                return 'rgb(' + red + ',0,0)';
            }
            else {
                return '#000';
            }
        }
    });
}
function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'json',
        async : false,
        success : function(data) {
            alert("fgnmfgh")
            console.log(data);

                drawLine1(data)
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}
