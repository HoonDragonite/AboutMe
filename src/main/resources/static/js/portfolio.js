
loadEvents();

function loadEvents(){
    const printBtn = document.getElementById('printBtn');
    if(printBtn){
        printBtn.addEventListener('click', print);
    }
}

function print(){
    alert('Print 합니다.');
}

