loadEvents();

function loadEvents(){
    const baseInfoBtn = document.getElementById('baseInfoBtn');
    if (baseInfoBtn){
        baseInfoBtn.addEventListener('click', sendBaseInfo);
    }

    const uploadImageBtn = document.getElementById('uploadImageBtn');
    if (uploadImageBtn){
        uploadImageBtn.addEventListener('click', uploadImage);
    }
}

function sendBaseInfo(){
    $('#baseInfoBtn').html("Loading...");

    let form = {
        korName : ($('#korName').val()),
        engName : $('#engName').val(),
        email : $('#email').val(),
        contact : $('#contact').val(),
        blog : $('#blog').val(),
        selfIntroduce : $('#selfIntroduce').val()
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
            $('#baseInfoBtn').html("저장");
            console.log("sendBaseInfo 성공! uID is " + data);
        },
        error: function(error){
            $('#baseInfoBtn').html("저장");
            console.log("error : " + error);
            alert("error");
        }
    });
}

function uploadImage() {
        var file = $('#img')[0].files[0];
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
            $('#profileImage').attr("src", data);
            console.log('uploadImage 성공');
        }).fail(function (error) {
            alert(error);
        })
    }