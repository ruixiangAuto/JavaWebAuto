function ajaxlogin() {
     $.ajax({
         url:"./Login",
         type:"post",
         data:$("form").serialize(),
         dataType:"json",
         success: function (result) {
             if (result["statuecode"]==200){
                 $("#_cb")[0].innerText=result["msg"];
                 window.location.href="./../html/user.html";
             }else if(result["statuecode"]==500){
                 $("#_cb")[0].innerText=result["msg"];
             }else {
                 $("#_cb")[0].innerText=result["msg"];
             }
         },
         error: function (result) {
             $("#_cb").innerText="错误的请求";
         }
     })


}