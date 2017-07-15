
$(document).ready(function () {

    $("#btn_submit").on("click", function () {

        var nume = $('#nume').val();
        var locatie = $('#locatie').val();

        $('input[type="date"]').change(function () {
            var inputDate = new Date(this.value);
        });

        var dataInfiintare = $("#dataInfiintare").val();

        var echipa = {};
        echipa.nume=nume;
        echipa.locatie=locatie;
        echipa.dataInfiintare=dataInfiintare;

        var postUrl = 'http://localhost:8088/echipa/add';
       console.log(echipa);
        saveEchipa(postUrl, echipa)

    });

});

function saveEchipa(url, data) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'PUT',
        'url': url,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function () {
           alert("Jucatorul a fost introdus in sistem!");
            $('#nume').val("");
            $('#locatie').val("");
            $('#dataInfiintare').val("");

        }
    });
}
