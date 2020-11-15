loadEvents();
checkSessionValue();


function loadEvents(){
    const logoArea = document.getElementById('logoArea');
    if(logoArea){
        logoArea.addEventListener('click', function (){
            location.href = "./";
        });
    }

    const backBtn = document.getElementById("backBtn");
    if(backBtn){
        backBtn.addEventListener('click', function () {
            history.back();
        })
    }

    const privacy = document.getElementById("privacy");
    if(privacy){
        privacy.addEventListener('click', function(){
            location.href = "./privacy";
        })
    }

    const introduce = document.getElementById("introduce");
    if(introduce){
        introduce.addEventListener('click', function () {
            location.href = "./introduce"
        })
    }

    const userInfo = document.getElementById("userInfo");
    if(userInfo){
        userInfo.addEventListener('click', function () {
            location.href = "./userinfo"
        })
    }
}

function checkSessionValue(){
    console.log('Check My Session Value***************');
    for(let key in window.sessionStorage) {
        console.log("key : " + key + ", value : " + sessionStorage.getItem(key));
    }
    console.log('*************************************');
}