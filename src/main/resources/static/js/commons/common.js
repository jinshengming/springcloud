function newOwnerPopup() {

    $("#newOwner").modal("show")
}

$("#newOwnerBtn").on("click", function () {
    $("#add_form li").each(function () {
        $(this).children("input").val("");
    });
    newOwnerPopup();
});

function setPopup() {
    $("#setProp").modal("show")
}

function forward(path) {
    location.href = path;
}

function ajaxCall(path) {
    $.ajax({
        url: path,
        type: "Get",
        dataType: "json",
        success: function (data) {
            appendHtml(data);
        },
        error: function () {

        }
    });
}

function appendHtml(data) {
    var owner = JSON.parse(data.resultMsg);
    var list = owner.list;
    var tbody = $("#owners").find("tbody");
    $("#owners tbody").html("");
    var html = "";
    for (var i = 0; i < list.length; i++) {

        var date = new Date(list[i].propertyFeeDate);
        var Y = date.getFullYear() + '/';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '/';
        var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        html += "<tr style='height:50px;'>";
        html += "<td>" + list[i].name + "</td>";
        html += "<td>" + list[i].idCard + "</td>";
        html += "<td>" + list[i].detailAddress + "</td>";
        html += "<td>" + list[i].phone + "</td>";
        html += "<td>" + list[i].roomArea + "</td>";
        html += "<td>" + list[i].propertyPrice + "</td>";
        html += "<td>" + list[i].carNum + "</td>";
        html += "<td>" + list[i].waterPrice + "</td>";
        html += "<td>" + (Y + M + D) + "</td>";
        html += "<td style='display: none;'>" + list[i].id + "</td>";
        html += "<td style='display: none;'>" + list[i].simplePrice + "</td>";
        html += "<td><input type='button' style='width:60px;' class='button edit' value='编辑' />&nbsp;&nbsp;&nbsp;";
        html += "<input type='button' style='width:60px;' class='button del' value='删除' /></td>";
        html += "</tr>";
    }

    if (list.length < 5) {
        for (var i = 0; i < 5 - list.length; i++) {
            html += "<tr style='height:50px;'>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td></td>";
            html += "<td style='display: none;'></td>";
            html += "<td></td>";
            html += "</tr>";
        }
    }
    $("#owners tbody").html(html);
}

function check(owner){

}