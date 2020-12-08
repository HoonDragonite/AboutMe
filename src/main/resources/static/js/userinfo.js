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
function insertPjtTableRow(){
    let tr = ""
    tr += "<tr id=\"pjt-item\">";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <span class=\"pjt-seq\" id=\"pjtSeq\" name=\"pjtSeq\"></span>";
    tr += "        <input class=\"pjt-name\" id=\"pjtName\" name=\"pjtName\" type=\"text\" placeholder=\"프로젝트명\">";
    tr += "        <input class=\"pjt-team\" id=\"pjtTeam\" name=\"pjtTeam\" type=\"text\" placeholder=\"팀명\">";
    tr += "        <input class=\"pjt-start-date\" id=\"pjtStartDate\" name=\"pjtStartDate\" type=\"text\" placeholder=\"시작일자\" maxlength=\"6\">";
    tr += "        <input class=\"pjt-end-date\" id=\"pjtEndDate\" name=\"pjtEndDate\" type=\"text\" placeholder=\"종료일자\" maxlength=\"6\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-desc\" id=\"pjtDesc\" name=\"pjtDesc\" type=\"text\" placeholder=\"내용\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-tech-stack\" id=\"pjtTechStack\" name=\"pjtTechStack\" type=\"text\" placeholder=\"기술스택\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-main-tech\" id=\"pjtMainTech\" name=\"pjtMainTech\" type=\"text\" placeholder=\"주요기술\">";
    tr += "    </td>";
    tr += "    <td class=\"pjt-td\">";
    tr += "        <input class=\"pjt-role\" id=\"pjtRole\" name=\"pjtRole\" type=\"text\" placeholder=\"맡은역할\">";
    tr += "    </td>";
    tr += "</tr>";
    $("#pjtTable").append(tr);
}