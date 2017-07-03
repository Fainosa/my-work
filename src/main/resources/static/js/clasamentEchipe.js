var getDataUrl = "http://localhost:8088/graph/clasament-echipe";

$(document).ready(function() {
    $("body").append('<div id="graph"></div>');
    getData(getDataUrl);
    // $("body").append('<div id="graph"></div>');


    drawLine()

});

function drawLine1(data) {
    new Morris.Bar({
        barGap : 4,
        barSizeRatio : 0.7,
        element : 'graph',
        data : [ data ],
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
            // {x: 'Boston Celtics', y: 25},
            // {x: 'Brooklyn Nets', y: 29},
            // {x: 'Chicago Bulls', y: 48},
            // {x: 'Clevenad Cavaliers', y: 84},
            // {x: 'Miami Heat', y: 33},
            // {x: 'Orlango Magic', y: 45},
            // {x: 'Denver Nuggets', y: 20},
            // {x: 'Washington Wizards', y: 50},
            // {x: 'New York Knicks', y: 73}
             {x: 'echipa1' , y: 15 } , {x: 'echipa2' , y: 17 } , {x: 'echipa3' , y: 22 }
        ],
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
function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'text',
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

