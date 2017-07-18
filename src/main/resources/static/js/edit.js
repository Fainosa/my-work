var competitieUrl="http://localhost:8088/competitie/all";

var competitie;

$(document).ready(function(){

// Set the date we're counting down to
var countDownDate = new Date("Jul 21, 2017 15:37:25").getTime();

// Update the count down every 1 second
var x;

function setCountdown () {
	x = setInterval(function() {

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
};

setCountdown();



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
				case "STOP COMPETITION":
					clearInterval(x);
					document.getElementById("stopCompetition").innerHTML ="START COMPETITION";
					break;

				case "START COMPETITION":
					setCountdown();
					document.getElementById("stopCompetition").innerHTML ="STOP COMPETITION";
					break;
			}
		})



           var titlu=document.getElementById("titlu");
           var getCompetitieByIdUrl = "http://localhost:8088/competitie/1";
                                  getCompetitieById(getCompetitieByIdUrl);
                                  console.log(competitie);
            console.log(competitie.nume);
           titlu.innerHTML="<p>"+ competitie.nume+"</p>"+"</br>"
                    +"<p>"+ competitie.dataIncepere+"-" +competitie.dataTerminare+"</p>";
                      console.log(titlu);






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

