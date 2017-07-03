var dataUrl = "http://localhost:8088/graph/clasament-echipe";

$(document).ready(function() {
    $("body").append('<div id="graph"></div>');

    getData(dataUrl);

});

function drawLine(data) {
    new Morris.Bar({
        element : 'graph',
        data : data ,
        xkey: 'x',
        ykeys: ['y'],
        labels: ['Punctaj'],
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
            drawLine(data);
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}

