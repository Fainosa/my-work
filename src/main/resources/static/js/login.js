var dataUrl = "http://localhost:8088/user/all";
var users;

$(document).ready(function() {
    getData(dataUrl);
    console.log(users[0])

});

$("#btn_login" ).click(function() {
    var username = $('#input_user').val();
    var password = $('#input_password').val();

    $.each(users, function(i, item) {
        if(username === item.userName) {
            if (password === item.password) {
                alert("success")
            } else {
                alert("not success")
            }
        } else {
            alert("not a valid user")
        }
    });
});

function getData(api) {
    $.ajax({
        url : api,
        type : 'GET',
        dataType : 'json',
        async : false,
        success : function(data) {
            users = data;
        },
        error : function(xhr, message, errorThrown) {
            alert(errorThrown);
        }
    });
}