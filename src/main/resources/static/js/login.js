var dataUrl = "http://localhost:8088/user/all";
var users;

$(document).ready(function() {
    getData(dataUrl);
});

$("#btn_login" ).click(function() {
    var username = $('#input_user').val();
    var password = $('#input_password').val();

    $.each(users, function(i, item) {
        if(username === item.userName) {
            if (password === item.password) {
                alert("Hello, " + item.userName + " ! You are now logged into the application");
                window.open("main.html");
            } else {
                alert("Hello, " + item.userName + " ! Your password is incorrect! Please try again");
                $('#input_password').val("");
            }
        } else {
            alert("Username: " + username + " is not recognised in the application");
            $('#input_password').val("");
            $('#input_user').val("");
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

$("#input_password").keyup(function(event){
    if(event.keyCode == 13){
        $("#btn_login").click();
    }
});