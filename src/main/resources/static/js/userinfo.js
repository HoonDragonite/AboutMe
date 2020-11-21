loadEvents();

function loadEvents(){
    const baseInfoBtn = document.getElementById('baseInfoBtn');
    if (baseInfoBtn){
        baseInfoBtn.addEventListener('click', sendBaseInfo);
    }
}

function sendBaseInfo(){

    var form = {
        korName : ($('#korName').val()),
        engName : $('#engName').val(),
        email : $('#email').val(),
        contact : $('#contact').val(),
        blog : $('#blog').val(),
        selfIntroduce : $('#selfIntroduce').val()
    };

    console.log('View의 값 받아오기');
    console.log($('#korName').val());
    console.log($('#engName').val());
    console.log($('#email').val());
    console.log($('#contact').val());
    console.log($('#blog').val());
    console.log($('#selfIntroduce').val());
    /*
    ajax 테스트
    $.ajax({
        success: function(){
            alert("hi!");
        }
    })
    */

    $.ajax({
        type: "POST",
        url: "/userInfoSave",
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