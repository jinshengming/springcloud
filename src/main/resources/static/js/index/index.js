$(document).ready(function () {
    //添加或者更新业主
    $("#add_btn").on("click", function () {
        // var flag = false;
        // $("#add_form li").each(function () {
        //     if ($(this).children("input").val() == "") {
        //         flag = true;
        //     }
        // });
        // if (flag) {
        //     window.wxc.xcConfirm("请将信息填写完整!!!", window.wxc.xcConfirm.typeEnum.warning);
        //     return false;
        // }
        $.ajax({
            url: "/owner/insertOrUpdate",
            data: $('#add_form').serialize(),
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.resultCode == 0) {
                    window.wxc.xcConfirm("操作成功!!!", window.wxc.xcConfirm.typeEnum.success);
                }
                $("#add_close").click();
            },
            error: function () {
                alert("失败");
            }

        });
    });
    //设置物业费
    $("#set_btn").on("click", function () {
        $.ajax({
            url: "/prop/setProp",
            data: $('#setProp_form').serialize(),
            type: "post",
            dataType: "json",
            success: function (data) {
                $("#setprop_Close").click();
                window.wxc.xcConfirm(data.resultMsg, window.wxc.xcConfirm.typeEnum.success);
            },
            error: function () {
                alert("失败");
            }

        });
    });
    //物业费设置初始化
    $("#setPropBtn").on("click", function () {
        $.ajax({
            url: "/prop/selectProp",
            type: "Get",
            dataType: "json",
            success: function (data) {
                if (data.resultCode == 0) {
                    var result = JSON.parse(data.resultMsg);
                    $("#propertyId").val(result.id);
                    $("#propPrice").val(result.propPrice);
                }
            },
            error: function () {
                window.wxc.xcConfirm(data.resultMsg, window.wxc.xcConfirm.typeEnum.error);
            }
        });
        setPopup();
    });


    $("#owners tbody").on("click", ".edit", function () {
        var td = $(this).parent().parent().children("td");
        for(var i = 0; i < td.length; i++){
            console.log(td.eq(i).html());
            if(td.eq(i).html() == "undefined"){
                td.eq(i).html("");
            }
        }
        var name = td.eq(0).html();
        var idCard = td.eq(1).html();
        var detailAddress = td.eq(2).html();
        var phone = td.eq(3).html();
        var roomArea = td.eq(4).html();
        var propertyPrice = td.eq(5).html();
        var carNum = td.eq(6).html();
        var waterPrice = td.eq(7).html();
        var propertyFeeDate = td.eq(8).html();
        var id = td.eq(9).html();
        var simplePrice = td.eq(10).html();

        $("#id").val(id);
        $("#name").val(name);
        $("#idCard").val(idCard);
        $("#detailAddress").val(detailAddress);
        $("#phone").val(phone);
        $("#roomArea").val(roomArea);
        $("#propertyPrice").val(propertyPrice);
        $("#carNum").val(carNum);
        $("#waterPrice").val(waterPrice);
        $("#datetimepicker2").val(propertyFeeDate);
        $("#simplePrice").val(simplePrice);
        newOwnerPopup();
    });
    $("#owners tbody").on("click", ".del", function () {
        var tr = $(this).parent().parent();
        window.wxc.xcConfirm("确定要删除该条记录么？", window.wxc.xcConfirm.typeEnum.confirm, {
            onOk: function (v) {
                var id = tr.children("td").eq(9).html();
                $.ajax({
                    url: "/owner/del",
                    type: "Post",
                    data: {"id": id},
                    dataType: "json",
                    success: function (data) {
                        if (data.resultCode == 0) {
                            tr.children("td").each(function () {
                                $(this).html("");
                            });
                            window.wxc.xcConfirm(data.resultMsg, window.wxc.xcConfirm.typeEnum.success);
                        }
                    },
                    error: function () {
                        window.wxc.xcConfirm(data.resultMsg, window.wxc.xcConfirm.typeEnum.error);
                    }
                });
            }
        });
    });

    $("#roomArea,#simplePrice").keyup(function(){
        var roomArea = $("#roomArea").val();
        var simplePrice = $("#simplePrice").val();
        if(roomArea == "" || simplePrice == ""){
            return;
        }
        if(isNaN(roomArea)){
            return;
        }
        if(isNaN(simplePrice)){
            return;
        }
        else{
            $("#propertyPrice").val(roomArea * simplePrice);
        }

    });

});
