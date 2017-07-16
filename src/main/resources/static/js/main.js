var echipeUrl = "http://localhost:8088/custom/echipe";
var meciuriUrl = "http://localhost:8088/meci/all";

var meciuri = {};

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

    getMeciuri(meciuriUrl);
    populateList(meciuri)

    function populateList(data) {
        $.each(data, function(i, item) {
            alert("each hjocewcw");
            // console.log(item[i].echipe[0].numeEchipa + "   " + item[i].echipe[1].numeEchipa);
            // $('#list').appendChild('<li>' + item[i].echipe[0].numeEchipa + '<span> vs </span>' + item[i].echipe[1].numeEchipa +  '</li>');
        });


        // $('#list').ap
        // $('#list').click(function() {
        //     var out = '<ul><li>Item One</li><li>Item Two</li><li>Item Three</li></ul>';
        //     $('#listView').html(out);
        // });
    }

} );

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






