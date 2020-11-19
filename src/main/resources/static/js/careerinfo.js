careerloadEvents();

function careerloadEvents(){

    $( document ).ready(function() {
        console.log( "ready!" );
        $("#addcareer").on('click', function () {
            //alert("button ok");
            addcareer();
        });
        $(".cdel").on('click', function () {
            deletecareer();
        });
        $("#savecareer").on('click', function () {
            savecareer();
        });
    });

}


function addcareer() {
    $("#careertable").append(
        "<tr>"
        +"<td><input type='text' id='cname'></td>"
        +"<td><input type='text' id='cment'></td>"
        +"<td><input type='text' id='sdate' placeholder='20201111'></td>"
        +"<td><input type='text' id='edate' placeholder='20201111'></td>"
        +"<td><input type='button' class='cdel' value='삭제'></td>"
        +"</tr>"
    );
}//addcareer

function savecareer(){
    var cname = $("#cname").val();
    var cment = $('#cment').val();
    var sdate = $('#sdate').val();
    var edate = $('#edate').val();

    var objParam = {
        "cicarname" : cname,
        "cicomment" : cment,
        "startdate" : sdate,
        "enddate" : edate,
    };
    console.log("objParm=>>"+JSON.stringify(objParam));

    var yn = confirm('저장하시겠습니까?');
    if(yn){
        $.ajax({
            url:'/savecareer',
            //dataType:'json',
            //contentType: 'application/json',
            type:'post',
            data:JSON.stringify(objParam),
            success : function(data){
                console.log(data);
                alert("저장되었습니다.");
                //location.href="/cinfo";
            }, error : function(request, status, error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
}//savecareer

function deletecareer(){
    var params = {
        cname : $("#cname").val()
    };
    console.log("deleteclick cname=> " + JSON.stringify(params));

    var yn = confirm("경력사항을 삭제하시겠습니까?");
    if(yn){
        $.ajax({
            url : "deletecareer",
            type : "POST",
            data : params,
            success : function(obj) {
                console.log("delete obj>> " + obj);
                alert("삭제되었습니다");
            },error : function(request, status, error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });// ajax
    }//if
}//deletecareer
