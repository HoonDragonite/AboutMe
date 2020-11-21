careerloadEvents();

function careerloadEvents(){

    $( document ).ready(function() {
        console.log( "ready!" );

        //getCareerCallback();

        $("#addcareer").on('click', function () {
            //alert("button ok");
            addcareer();
        });
        $(".cmodify").on('click', function () {
            modifycareer();
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
        +"<td><button class='cmodify' value='수정'>수정</button>"
        +"<button class='cdel' value='삭제'>삭제</button>"
        +"</td>"
        +"</tr>"
    );
}//addcareer

function savecareer(){
    var cname = $('#cname').val();
    var cment = $('#cment').val();
    var sdate = $('#sdate').val();
    var edate = $('#edate').val();

    var objParam = {
        cicarname : cname,
        cicomment : cment,
        startdate : sdate,
        enddate : edate
    };
    console.log("objParm=>>"+JSON.stringify(objParam));

    var yn = confirm('저장하시겠습니까?');
    if(yn){
        $.ajax({
            url:"/savecareer",
            dataType:"JSON",
            contentType: "application/json",
            type:"post",
            data:JSON.stringify(objParam),
            success : function(data){
                console.log(data);
                alert("저장되었습니다.");
                location.href="/cinfo";
            }, error : function(request, status, error){ //+request.responseText
                location.href="/cinfo";
                //alert("code:"+request.status+"\n"+"message:"+"\n"+"error:"+error);
            }
        });
    }
}//savecareer

function deletecareer(){
    var params = {
        cno : $(".cno").val()
    };
    console.log("deleteclick cno=> " + JSON.stringify(params));

    var yn = confirm("경력사항을 삭제하시겠습니까?");
    if(yn){
        $.ajax({
            url : "/deletecareer/"+JSON.stringify(params),
            type : "POST",
            data : params,
            datatype : 'json',
            contentType: "application/json",
            success : function(obj) {
                console.log("delete obj>> " + obj);
                alert("삭제되었습니다");
                location.href = "/cinfo";
            },error : function(request, status, error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });// ajax
    }//if
}//deletecareer


function getCareerCallback(){
    // if(obj !=null){
    //     var cname = obj.cname;
    //     var cment = obj.cment;
    //     var sdate = obj.sdate;
    //     var edate = obj.edate;
    //
    //     $("#cname").val(cname);
    //     $('#cment').val(cment);
    //     $('#sdate').val(sdate);
    //     $('#edate').val(edate);
    // }

    alert("");


    $.ajax({
        url : "cnolist",
        //type : "POST",
        dataType:"JSON",
        //data : params,
        contentType: "application/json",
        success : function(obj) {
            console.log("cnolist obj>> " + obj);
            alert("obj"+obj);
        },error : function(request, status, error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });// ajax
}


function modifycareer(){
    alert("");

    
}