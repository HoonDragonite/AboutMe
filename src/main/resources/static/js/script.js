loadEvents();
checkSessionValue();


function loadEvents(){
    console.log("loadEvents");
    var logoArea = document.getElementById('logoArea');
    logoArea.addEventListener('click', moveToHome);

    var backBtn = document.getElementById("backBtn");
    backBtn.addEventListener('click', function () {
        history.back();
    })
}

function checkSessionValue(){
    console.log('Check My Session Value***************');
    for(var key in window.sessionStorage) {
        console.log("key : " + key + ", value : " + sessionStorage.getItem(key));
    }
    console.log('*************************************');
}