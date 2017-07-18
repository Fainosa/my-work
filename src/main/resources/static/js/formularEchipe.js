
$(document).ready(function () {

    $("#btn_submit").on("click", function () {

        var nume = $('#nume').val();
        var locatie = $('#locatie').val();

        $('input[type="date"]').change(function () {
            var inputDate = new Date(this.value);
        });

        var dataInfiintare = $("#dataInfiintare").val();

        var echipa = {};
        echipa.numeEchipa=nume;
        echipa.locatie=locatie;
        echipa.dataInfiintare=dataInfiintare;

        var postUrl = 'http://localhost:8088/echipa/add';
        console.log(echipa);
        saveEchipa(postUrl, echipa)

    });

      function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#imgUpload').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(input.files[0]);
                    console.log(input.files[0]);

                    input.files[0].nume = "poza.jpg";
                    console.log("poza", input.files[0].nume);

                    $.ajax({
                        url : 'static/images/entityImages',
                        success: function (data) {
                            alert('succcessss')
                            $(data).find("a").attr("href", function (i, val) {
                                if( val.match(/\.(jpe?g|png|gif)$/) ) {
                                    $("body").append( "<img src='"+ folder + val +"'>" );
                                }
                            });
                        }
                    })



                    // $('#imgUpload').change(function(){
                    //     var frm = new FormData();
                    //     frm.append('imgUpload', input.files[0]);
                    //     $.ajax({
                    //         method: 'POST',
                    //         address: 'static/images/entityImages',
                    //         data: frm,
                    //         contentType: false,
                    //         processData: false,
                    //         cache: false
                    //     });
                    // });
                }
            }

            $("#imgInp").change(function(){
                readURL(this);
            });

});

function saveEchipa(url, data) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': url,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function () {
           alert("Echipa a fost introdus in sistem!");
            $('#nume').val("");
            $('#locatie').val("");
            $('#dataInfiintare').val("");

        }
    });
}
