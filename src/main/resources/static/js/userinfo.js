loadEvents();

function loadEvents(){
    const baseInfoBtn = document.getElementById('baseInfoBtn');
    if (baseInfoBtn){
        baseInfoBtn.addEventListener('click', sendBaseInfo);
    }
}

function sendBaseInfo(){

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
        contentType: 'application/json',
        data: JSON.stringify(form),
        success: function(data) {
            console.log("success! uID is " + data);
        },
        error: function(error){
            console.log("error : " + error);
            alert("error");
        }
    });
}