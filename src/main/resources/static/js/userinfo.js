loadEvents();
setDefaultImage();
function setDefaultImage(){
    let image = document.getElementById("image");
    if (image.getAttribute("src") === ""){
        image.setAttribute("src", "/image/empty.png");
    }
}

function loadEvents(){
    const baseInfoBtn = document.getElementById('baseInfoBtn');
    if (baseInfoBtn){
        baseInfoBtn.addEventListener('click', save);
    }

    const clickInputBtn = document.getElementById('clickInputBtn');
    if (clickInputBtn){
        clickInputBtn.addEventListener('click', clickInput);
    }

    const imageInput = document.getElementById('imageInput');
    if(imageInput){
        imageInput.addEventListener('change', showLoadedImage);
    }

    const pjtSaveBtn = document.getElementById('pjtSaveBtn');
    if (pjtSaveBtn){
        pjtSaveBtn.addEventListener('click', sendProjectList);
    }

    const pjtAddBtn = document.getElementById('pjtAddBtn');
    if(pjtAddBtn){
        pjtAddBtn.addEventListener('click', insertPjtTableRow);
    }

    const careerSaveBtn = document.getElementById('careerSaveBtn');
    if (careerSaveBtn){
        careerSaveBtn.addEventListener('click', sendCareerList);
    }

    const careerAddBtn = document.getElementById('careerAddBtn');
    if(careerAddBtn){
        careerAddBtn.addEventListener('click', insertCareerTableRow);
    }

    const careerDeleteBtns = document.getElementsByClassName('career-delete-btn');

    for(let i=0; i< careerDeleteBtns.length; i++){
        careerDeleteBtns[i].addEventListener('click', deleteCareer);
    }
}

function clickInput(){
    $('#imageInput').click();
}

function showLoadedImage(){
    const imageInput = document.getElementById('imageInput');
    const fReader = new FileReader();

    fReader.readAsDataURL(imageInput.files[0]);
    fReader.onloadend = function(Event){
        $('#image').attr("src", Event.target.result);
    }
}


function save(){
    uploadImage();
    sendBaseInfo();
}

function uploadImage() {
    $('#baseInfoBtn').html("Loading...");

    var file = $('#imageInput')[0].files[0];
    var formData = new FormData();
    formData.append('data', file);
    console.log(formData);
    console.log(formData.get('data'.toString()));
    $.ajax({
        type: 'POST',
        url: '/profileUpload',
        data: formData,
        async: false,
        processData: false,
        contentType: false
    }).done(function (data) {
        $('#image').attr("src", data);
        console.log('uploadImage 성공');
    }).fail(function (error) {
        console.log(error);
    })
}

function sendBaseInfo(){
    $('#baseInfoBtn').html("Loading...");
    console.log($('#image').attr("src"));
    let form = {
        korName : ($('#korName').val()),
        engName : $('#engName').val(),
        email : $('#email').val(),
        contact : $('#contact').val(),
        blog : $('#blog').val(),
        selfIntroduce : $('#selfIntroduce').val(),
        image : $('#image').attr("src")
    };

    console.log('전송하는 값' + form);

    $.ajax({
        type: "POST",
        url: "/baseInfoSave",
        dataType: "JSON",
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(form),
        success: function(data) {
            $('#baseInfoBtn').html("성공");
            console.log("sendBaseInfo 성공! uID is " + data);
        },
        error: function(error){
            $('#baseInfoBtn').html("실패");
            console.log("error : " + error);
            alert("error");
        }
    });
}

function sendProjectList(){
    const pjtTable = document.getElementById('pjtTable');
    console.log("tr 개수:" + pjtTable.rows.length);

    const pjtArray = new Array();

    $('#pjtTable tr').each(function () {
        let pjtObject = {
            pjtSeq : $(this).find('.pjt-seq').val(),
            pjtName : $(this).find('.pjt-name').val(),
            pjtTeam : $(this).find('.pjt-team').val(),
            pjtStartDate : $(this).find('.pjt-start-date').val(),
            pjtEndDate : $(this).find('.pjt-end-date').val(),
            pjtDesc : $(this).find('.pjt-desc').val(),
            pjtTechStack : $(this).find('.pjt-tech-stack').val(),
            pjtMainTech : $(this).find('.pjt-main-tech').val(),
            pjtRole : $(this).find('.pjt-role').val()
        };

        pjtArray.push(pjtObject);
    })

    const jsonPjtArray = JSON.stringify(pjtArray);
    console.log("Pjt 전송하는 값 :" + jsonPjtArray);

    $.ajax({
        type: "POST",
        url: "/pjtListSave",
        dataType: "JSON",
        async: false,
        contentType: 'application/json',
        data: jsonPjtArray,
        success: function(data) {
            $('#pjtSaveBtn').html("성공");
            console.log("pjtSaveBtn 성공! uID is " + data);
        },
        error: function(error){
            $('#pjtSaveBtn').html("실패");
            console.log("error : " + error);
            alert("error");
        }
    });
}


function insertPjtTableRow(){
    let tr = ""
    tr += "<tr id=\"pjt-item\">";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <span class=\"pjt-seq\" name=\"pjtSeq\"></span>";
    tr += "        <input class=\"pjt-name\" name=\"pjtName\" type=\"text\" placeholder=\"프로젝트명\">";
    tr += "        <input class=\"pjt-team\" name=\"pjtTeam\" type=\"text\" placeholder=\"팀명\">";
    tr += "        <input class=\"pjt-start-date\" name=\"pjtStartDate\" type=\"text\" placeholder=\"시작일자\" maxlength=\"6\">";
    tr += "        <input class=\"pjt-end-date\" name=\"pjtEndDate\" type=\"text\" placeholder=\"종료일자\" maxlength=\"6\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-desc\" name=\"pjtDesc\" type=\"text\" placeholder=\"내용\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-tech-stack\" name=\"pjtTechStack\" type=\"text\" placeholder=\"기술스택\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-main-tech\" name=\"pjtMainTech\" type=\"text\" placeholder=\"주요기술\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-role\" name=\"pjtRole\" type=\"text\" placeholder=\"맡은역할\">";
    tr += "    </td>";
    tr += "</tr>";
    $("#pjtTable").append(tr);
}

function sendCareerList(){
    const careerTable = document.getElementById('careerTable');
    console.log("tr 개수:" + careerTable.rows.length);

    const careerArray = new Array();

    $('#careerTable tr').each(function () {
        let careerObject = {
            careerSeq : $(this).find('.career-seq').val(),
            careerName : $(this).find('.career-name').val(),
            careerTeam : $(this).find('.career-team').val(),
            careerStartDate : $(this).find('.career-start-date').val(),
            careerEndDate : $(this).find('.career-end-date').val(),
            careerDesc : $(this).find('.career-desc').val(),
            careerTechStack : $(this).find('.career-tech-stack').val(),
            careerMainTech : $(this).find('.career-main-tech').val(),
            careerRole : $(this).find('.career-role').val()
        };

        careerArray.push(careerObject);
    })

    const jsonCareerArray = JSON.stringify(careerArray);
    console.log("career 전송하는 값 :" + jsonCareerArray);

    $.ajax({
        type: "POST",
        url: "/careerListSave",
        dataType: "JSON",
        async: false,
        contentType: 'application/json',
        data: jsonCareerArray,
        success: function(data) {
            $('#careerSaveBtn').html("성공");
            console.log("careerSaveBtn 성공! uID is " + data);
        },
        error: function(error){
            $('#careerSaveBtn').html("실패");
            console.log("error : " + error);
            alert("error");
        }
    });
}


function insertCareerTableRow(){
    let tr = ""
    tr += "<tr id=\"career-item\">";
    tr += "    <td class=\"career-td\">";
    tr += "        <span class=\"career-seq\" name=\"careerSeq\"></span>";
    tr += "        <input class=\"career-name\" name=\"careerName\" type=\"text\" placeholder=\"경력\">";
    tr += "        <input class=\"career-team\" name=\"careerTeam\" type=\"text\" placeholder=\"팀명\">";
    tr += "        <input class=\"career-start-date\" name=\"careerStartDate\" type=\"text\" placeholder=\"시작일자\" maxlength=\"6\">";
    tr += "        <input class=\"career-end-date\" name=\"careerEndDate\" type=\"text\" placeholder=\"종료일자\" maxlength=\"6\">";
    tr += "        <button class=\"career-delete-btn\" id=\"careerDeleteBtn\">X</button>";
    tr += "    </td>";
    tr += "    <td class=\"career-td\">";
    tr += "        <input class=\"career-desc\" id=\"careerDesc\" name=\"careerDesc\" type=\"text\" placeholder=\"내용\">";
    tr += "    </td>";
    tr += "    <td class=\"career-td\">";
    tr += "        <input class=\"career-tech-stack\" id=\"careerTechStack\" name=\"careerTechStack\" type=\"text\" placeholder=\"기술스택\">";
    tr += "    </td>";
    tr += "    <td class=\"career-td\">";
    tr += "        <input class=\"career-main-tech\" id=\"careerMainTech\" name=\"careerMainTech\" type=\"text\" placeholder=\"주요기술\">";
    tr += "    </td>";
    tr += "    <td class=\"career-td\">";
    tr += "        <input class=\"career-role\" id=\"careerRole\" name=\"careerRole\" type=\"text\" placeholder=\"맡은역할\">";
    tr += "    </td>";
    tr += "</tr>";
    $("#careerTable").append(tr);
}

function deleteCareer(){
    console.log($(this).siblings('.career-seq').val());

    let careerObject = {
        careerSeq : $(this).siblings('.career-seq').val()
    }

    const jsonCareerArray = JSON.stringify(careerObject);

    $.ajax({
        type: "POST",
        url: "/careerDelete",
        dataType: "JSON",
        async: false,
        contentType: 'application/json',
        data: jsonCareerArray,
        context:this,
        success: function(data) {
            console.log("receive data : " + data);
            $(this).parent().parent().remove();
        },
        error: function(error){
            alert("error");
        }
    });
}

// 단일 값 보내기, 사용X 다른 코드 작성할 때 참고하기
/*
function sendProject(){
    $('#pjtSaveBtn').html("Loading...");

    let pjtForm = {
        pjtSeq : ($('#pjtSeq').val()),
        pjtName : $('#pjtName').val(),
        pjtTeam : $('#pjtTeam').val(),
        pjtStartDate : $('#pjtStartDate').val(),
        pjtEndDate : $('#pjtEndDate').val(),
        pjtDesc : $('#pjtDesc').val(),
        pjtTechStack : $('#pjtTechStack').val(),
        pjtMainTech : $('#pjtMainTech').val(),
        pjtRole : $('#pjtRole').val()
    };

    console.log('pjt 전송하는 값' + JSON.stringify(pjtForm));

    $.ajax({
        type: "POST",
        url: "/pjtSave",
        dataType: "JSON",
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(pjtForm),
        success: function(data) {
            $('#pjtSaveBtn').html("성공");
            console.log("pjtSaveBtn 성공! uID is " + data);
        },
        error: function(error){
            $('#pjtSaveBtn').html("실패");
            console.log("error : " + error);
            alert("error");
        }
    });
}
*/