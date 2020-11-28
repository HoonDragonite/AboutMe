careerloadEvents();

function careerloadEvents() {

    $(document).ready(function () {
        console.log("careerinfo!");

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
        $(document).on("click","#savecareer",function(){
            savecareer();
        });
    });

}

//목록조회
function getCareerList() {
    $.ajax({
        url: "getcareerlist",
        dataType: "JSON",
        type: "POST",
        success: function (obj) {
            getCareerListCallback(obj);
            //console.log("getcareerlist > ", obj);
        },
        error: function (xhr, status, error) {
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
            str += "<td id='cmcname" + cno + "'>" + cname + "</td>";
            str += "<td id='cmcment" + cno + "'>" + cment + "</td>";
            str += "<td id='cmsdate" + cno + "'>" + sdate + "</td>";
            str += "<td id='cmedate" + cno + "'>" + edate + "</td>";
            str += "<td>" + "<button id='cmodi' onclick='modifycareer(" + cno + ")'>수정</button>";
            str += "<button id='cdel' onclick='deletecareer(" + cno + ")'>삭제</button>" + "</td>";
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
        + "<td><input type='text' id='cname'></td>"
        + "<td><input type='text' id='cment'></td>"
        + "<td><input type='text' id='sdate' placeholder='20201111'></td>"
        + "<td><input type='text' id='edate' placeholder='20201111'></td>"
        + "<td><button id='savecareer' value='저장'>저장 </button></td>"
        + "</tr>"
    );
}//addcareer

function savecareer() {
    var cname = $('#cname').val();
    var cment = $('#cment').val();
    var sdate = $('#sdate').val();
    var edate = $('#edate').val();

    var objParam = {
        cicarname: cname,
        cicomment: cment,
        startdate: sdate,
        enddate: edate
    };
    console.log("objParm=>>" + JSON.stringify(objParam));

    var yn = confirm('저장하시겠습니까?');
    if (yn) {
        $.ajax({
            url: "/savecareer",
            dataType: "JSON",
            contentType: "application/json",
            type: "post",
            data: JSON.stringify(objParam),
            success: function (data) {
                console.log(data);
                alert("저장되었습니다.");
                //location.href = "/cinfo";
            }, error: function (request, status, error) { //+request.responseText
                location.href = "/cinfo";
                //alert("code:"+request+"\n"+"message:"+"\n"+"error:"+error);
            }
        });
    }
}//savecareer

function deletecareer(obj) {
    console.log("deletecareer> ", obj);

    var yn = confirm("경력사항을 삭제하시겠습니까?");
    if (yn) {
        $.ajax({
            url: "/deletecareer/" + obj,
            type: "POST",
            data: obj,
            datatype: 'json',
            contentType: "application/json",
            success: function (obj) {
                console.log("delete obj>> " + obj);
                alert("삭제되었습니다");
                getCareerList();
               // location.href = "/cinfo";
            }, error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });// ajax
    }//if
}//deletecareer


function modifycareer(mobj) {
    console.log("modifycareer mobj> ", mobj);

    $.ajax({
        url: "getcareerlist",
        dataType: "JSON",
        type: "POST",
        success: function (obj) {
            cmCallback(mobj, obj);
            //getCareerListCallback(obj);
            //console.log("modifycareer obj> ", obj);
        },
        error: function (xhr, status, error) {
        }
    });
}


/** 수정 input 조회 콜백 함수 */
function cmCallback(mobj, obj) {
    var str = "";
    var list = obj;
    var listLen = obj.length;
    var mo = mobj-1;
    //console.log("list[mobj].cno > ",list[mo].cno);

    $("#citbody").empty();

    str += "<tr>"
    str += "<td><input type='text' id='cmcname'></td>"
    str += "<td><input type='text' id='cmcment'></td>"
    str += "<td><input type='text' id='cmsdate' ></td>"
    str += "<td><input type='text' id='cmedate' ></td>"
    str += "<td>" + "<button id='modicareer' onclick='modicareer("+mobj+")'>확인</button>";
     str += "<button id='cback' onclick='getCareerList()'>취소</button>" + "</td>";
    str += "</tr>"
    $("#citbody").append(str);

        $("#cmcname").val(list[mo].cicarname);
        $("#cmcment").val(list[mo].cicomment);
        $("#cmsdate").val(list[mo].startdate);
        $("#cmedate").val(list[mo].enddate);

}//cmCallback


function modicareer(mobj) {
    var cno = mobj;
    var cname = $('#cmcname').val();
    var cment = $('#cmcment').val();
    var sdate = $('#cmsdate').val();
    var edate = $('#cmedate').val();

    var objParam = {
        cno : cno,
        cicarname: cname,
        cicomment: cment,
        startdate: sdate,
        enddate: edate
    };
    console.log("objParm=>>" + JSON.stringify(objParam));

    $.ajax({
        url: "/modifycareer/"+cno,
        dataType: "JSON",
        type: "POST",
        data: JSON.stringify(objParam),
        contentType: "application/json",
        success: function (obj) {
            getCareerList();
            console.log("modifycareer obj> ", obj);
            //location.href = "/cinfo";
        },
        error: function (xhr, status, error) {
            getCareerList();
            location.href = "/cinfo";
            //alert(error);
        }
    });

}

