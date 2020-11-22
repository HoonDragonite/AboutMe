careerloadEvents();

function careerloadEvents(){

    $( document ).ready(function() {
        console.log( "careerinfo!" );

        getCareerList();

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

//목록조회
function getCareerList() {
    $.ajax({
        url : "getcareerlist",
        dataType : "JSON",
        type : "POST",
        success : function(obj) {
            getCareerListCallback(obj);
            console.log("getcareerlist > ",obj);
            //	alert("board list json ok");
        },
        error : function(xhr, status, error) {
        }

    });
}


/** 목록 조회  콜백 함수 */
function getCareerListCallback(obj) {
    var list = obj;
    var listLen = obj.length;

    $("#citbody").empty();

    if (listLen > 0) {

        for (var a = 0; a < listLen; a++) {

            var cno = list[a].cno;
            var cname = list[a].cicarname;
            var cment = list[a].cicomment;
            var sdate = list[a].startdate;
            var edate = list[a].enddate;

            str = "";
            str += "<tr>";
            // str += "<td>" + "<a href=careermodify?cno=" + cno + ">" + cname
            //     + "</a>" + "</td>";
            str += "<td id='cmname"+cno+"'>" + cname + "</td>";
            str += "<td id='cmcment"+cno+"'>" + cment + "</td>";
            str += "<td id='cmsdate"+cno+"'>" + sdate + "</td>";
            str += "<td id='cmedate"+cno+"'>" + edate + "</td>";
            str += "<td>" + "<button id='cmodi' onclick='modifycareer("+cno+")'>수정</button>";
            str += "<button id='cdel' onclick='deletecareer("+cno+")'>삭제</button>" + "</td>";

            str += "</tr>";

            $("#citbody").append(str);
        }

    } else {
        str += "<tr>";
        str += "<td colspan='5'>등록된 글이 존재하지 않습니다.</td>";
        str += "<tr>";
        $("#citbody").append(str);
    }
}


function addcareer() {
    $("#cinfotable").append(
        "<tr>"
        +"<td><input type='text' class='cname'></td>"
        +"<td><input type='text' id='cment'></td>"
        +"<td><input type='text' id='sdate' placeholder='20201111'></td>"
        +"<td><input type='text' id='edate' placeholder='20201111'></td>"
        // +"<td><button class='cmodify' value='수정'>수정</button>"
        // +"<button class='cdel' value='삭제'>삭제</button>"
        // +"</td>"
        +"</tr>"
    );
}//addcareer

function savecareer(){
    var cname = $('.cname').val();
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

function deletecareer(obj){
    // var params = {
    //     cno : $(".cno").val()
    // };
    console.log("deletecareer> " ,obj);

    var yn = confirm("경력사항을 삭제하시겠습니까?");
    if(yn){
        $.ajax({
            url : "/deletecareer/"+obj,
            type : "POST",
            data : obj,
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


function modifycareer(obj){
    console.log("modifycareer> ",obj);

    cmCallback(obj);

    // $.ajax({
    //     url : "modifycareer",
    //     dataType : "JSON",
    //     data : obj,
    //     type : "POST",
    //     success : function(data) {
    //         console.log("modify data > ",data);
    //         cmCallback(data);
    //     },
    //     error : function(xhr, status, error) {
    //     }
    //
    // });

}


/** 수정 input 조회 콜백 함수 */
function cmCallback(obj) {
    var str;
    console.log("cmcmcm > ",$("#cmcname"+obj).val());
    if (obj != null) {
        var cno = obj.cno;
        var cmcname = obj.cicarname;
        var cmcment = obj.cicomment;
        var cmsdate = obj.startdate;
        var cmedate = obj.enddate;


        $("#cmcname"+obj).val(cmcname);
        $("#cmcment").val(cmcment);
        $("#cmsdate").val(cmsdate);
        $("#cmedate").val(cmedate);



    } else {
        alert("등록된 글이 존재하지 않습니다.");
        return;
    }
}