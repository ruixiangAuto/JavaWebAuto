function getUserInfo() {
    $.ajax({
        //请求的url地址
        url: "./../GetUser",
        //http方法
        type: "get",
        // 指定接口返回数据的类型。
        dataType: "json",
        //执行完之后的处理操作
        success: function (result) {
            $("#userid")[0].innerText=result["userId"];
            $("#nickname")[0].innerText=result["nickname"];
            $("#describe")[0].innerText=result["description"];
        },
        error: function (result) {
            alert("查询接口调用失败");
        }
    })

}

function loginout() {
    $.ajax({
        url: "./../LoginOut",
        type: "get",
        dataType: "json",
        success: function (result) {
            alert(result["msg"]);
            window.location.href="./../index.html";
        },
        error: function () {
            alert("退出接口调用失败");
        }
    })
}