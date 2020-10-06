loadEvents();

function loadEvents(){
    var startBtn = document.getElementById('startBtn');
    startBtn.addEventListener('click', function () {
        location.href = "./select";
    });

    var loginBtn = document.getElementById('loginBtn');
    loginBtn.addEventListener('click', function () {
        location.href = "./login";
        console.log("hihi");
    });
}