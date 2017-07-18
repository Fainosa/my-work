var competitieUrl="http://localhost:8088/competitie/all";
var competitie;

var meciuriUrl = "http://localhost:8088/meci/all";
var meciuri = {};

$(document).ready(function(){

var interval;
    var minutes = 10;
    var seconds = 0;

    function countdown(element) {
        interval = setInterval(function() {
            var el = document.getElementById(element);
            if(seconds == 0) {
                if(minutes == 0) {
                    alert(el.innerHTML = "countdown's over!");
                    clearInterval(interval);
                    return;
                } else {
                    minutes--;
                    seconds = 60;
                }
            }
            if(minutes > 0) {
                var minute_text = minutes + (minutes > 1 ? ' minutes' : ' minute');
            } else {
                var minute_text = '';
            }
            var second_text = seconds > 1 ? 'seconds' : 'second';
            el.innerHTML = minute_text + ' ' + seconds + ' ' + second_text + ' remaining';
            seconds--;
        }, 1000);
    }

$('#addOneFirst').click(function() {
    $('#pointsFirst').html(function(i, val) { return val*1+1 });
});

$('#addTwoFirst').click(function() {
    $('#pointsFirst').html(function(i, val) { return val*1+2 });
});


$('#addOneSecond').click(function() {
    $('#pointsSecond').html(function(i, val) { return val*1+1 });
});

$('#addTwoSecond').click(function() {
    $('#pointsSecond').html(function(i, val) { return val*1+2 });
});
/*
$('#stopCompetition').toggle(
	function(){
		clearInterval(x);
		document.getElementById("stopCompetition").innerHTML ="START COMPETITION";
	},
    function(){
		document.getElementById("stopCompetition").innerHTML ="STOP COMPETITION";
	});
	*/


	 $('#stopCompetition').click(function(){
    			var startStop=$('#stopCompetition').html();
    			switch ( startStop) {
    				case "STOP MECI":
    					clearInterval(interval);
    					document.getElementById("stopCompetition").innerHTML ="START MECI";
    					break;

    				case "START MECI":
    					countdown('timer');
    					document.getElementById("stopCompetition").innerHTML ="STOP MECI";
    					break;
    			}
    		})



           var titlu=document.getElementById("titlu");
           var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
                                  getCompetitieById(getCompetitieByIdUrl);
                                  console.log(competitie);
            console.log(competitie.nume);
           titlu.innerHTML="<p>"+ competitie.nume+"</p>"
                    +"<p>"+ competitie.dataIncepere+"-" +competitie.dataTerminare+"</p>";
                      console.log(titlu);

      getMeciuri(meciuriUrl);
      console.log(meciuri);





});

function getData(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            competitieObject = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getCompetitieById(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
            competitie = data;

        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getMeciuri(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
           meciuri = data;
        },
        error: function (xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

