loadEvents();

function loadEvents(){
    var getStartBtn = document.getElementById('startBtn');
    getStartBtn.addEventListener('click', moveToStart);
}

function moveToStart(){
    console.log('hi');
    //location.href="html/input.html";
}