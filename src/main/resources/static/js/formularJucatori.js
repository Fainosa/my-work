var echipeUrl = 'http://localhost:8088/echipa/all';

$(document).ready(function() {
   getData(echipeUrl);

    $("#btn_submit" ).click(function() {
        var nume = $('#nume').val(); alert(nume);
        var prenume = $('#prenume').val(); alert(nume);
        var dataNasteri = $('#bday').val(); alert(dataNasteri);
    });


	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#imgUpload').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgInp").change(function(){
        readURL(this);
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



