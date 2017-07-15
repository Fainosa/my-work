var echipeUrl = 'http://localhost:8088/echipa/all';
var echipaObject;

$(document).ready(function() {
   getData(echipeUrl);

    $("#btn_submit" ).click(function() {
        var nume = $('#nume').val();
        var prenume = $('#prenume').val();
         $('input[type="date"]').change(function () {
                   var inputDate = new Date(this.value);
               });
       var bday = $("#bday").val();
       var email = $('#email').val();
       var inaltime = $('#inaltime').val();
       var greutate = $('#greutate').val();

   var echipa = $('#drop-down :selected').text();

        var numeEchipaForBrowser = echipa.replace(" ", "%20");
        var getEchipaByNameUrl = "http://localhost:8088/echipa/name/" + numeEchipaForBrowser;
        getEchipaByName(getEchipaByNameUrl);

        console.log(echipaObject);



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

function getEchipaByName(api) {
    $.ajax({
        url: api,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (data) {
        alert("ceva");
        console.log(data);
            echipaObject = data;
        },
        error: function (xhr, message, errorThrown) {
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





