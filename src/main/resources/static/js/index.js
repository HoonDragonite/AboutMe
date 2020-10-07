loadEvents();

function loadEvents(){
    const startBtn = document.getElementById('startBtn');
    startBtn.addEventListener('click', function () {
        console.log("Move To Template");
        location.href = "./template";
    });

    const loginBtn = document.getElementById('loginBtn');
    loginBtn.addEventListener('click', function () {
        console.log("Move To Login");
        location.href = "./login";
    });
}