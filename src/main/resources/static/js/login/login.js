function login() {
    var username = $("#loginName").val();
    var password = $("#possword").val();

    if (username == "") {
        alert("账号密码为空!!!");
        return;
    }
    if (password == "") {
        alert("账号密码为空!!!");
        return;
    }
    var user = {"userName": username, "userPwd": password};
    $.ajax({
        type: "POST",
        contentType: 'application/json;charset=UTF-8',
        url: "/user/login",
        dataType: "json",
        data: JSON.stringify(user),
        async: true,
        success: function (data) {
            var resultCode = data.resultCode;
            console.log(resultCode);
            if (resultCode == "0") {
                console.log(resultCode);
                forward("/owner/list");
            } else {
                alert(data.resultMsg);
            }
        },
        error: function (data, status, e) {
            alert(data);
        }
    });
}

