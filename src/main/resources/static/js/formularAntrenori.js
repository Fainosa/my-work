var echipeUrl = 'http://localhost:8088/echipa/all';

$(document).ready(function() {
   getData(echipeUrl);


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

//$("#btn_submit" ).click(function() {
//         alert("fghjkfgh");
//
//          var  nume = $('#nume').val();
//          alert(nume);
//
//     });

$("#btn_submit" ).on( "click", function() {
    alert("fghjkfgh");
});


