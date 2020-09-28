loadEvents();
checkSessionValue();


function loadEvents(){
    var logoArea = document.getElementById('logoArea');
    logoArea.addEventListener('click', moveToHome);
}

function moveToHome(){
    console.log('Move to Home');
    location.href="/MyProjects/AboutMe/index.html";
}

function checkSessionValue(){
    console.log('Check My Session Value***************');
    for(var key in window.sessionStorage) {
        console.log("key : " + key + ", value : " + sessionStorage.getItem(key));
    }
    console.log('*************************************');
}