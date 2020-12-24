loadEvents();

function loadEvents(){
    const startBtn = document.getElementById('startBtn');
    if(startBtn){
        startBtn.addEventListener('click', function () {
            console.log("Move To Template");
            location.href = "./template";
        });
    }


}