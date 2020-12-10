
loadEvents();
setImage();

function loadEvents(){
    console.log('loadEvents');
    var templateItems = document.getElementsByClassName('template-item');

    for(let i = 0; i < templateItems.length; i++) {
        templateItems[i].addEventListener("click", selectTemplate);
    }
}

function setImage(){
    console.log('setImage');
    const templateImage1 = document.getElementById('templateImage1');
    const templateImage2 = document.getElementById('templateImage2');
    const templateImage3 = document.getElementById('templateImage3');
    const templateImage4 = document.getElementById('templateImage4');
    const templateImage5 = document.getElementById('templateImage5');

    templateImage1.src = '/image/test1.png';
    templateImage2.src = '/image/test2.png';
    templateImage3.src = '/image/test3.png';
    templateImage4.src = '/image/test4.png';
    templateImage5.src = '/image/test5.png';
}

/* 선택 시 이동*/
function selectTemplate(Event){
    console.log('selectTemplate');
    console.log("선택한 노드 : " + Event.target.parentNode.id);
    var selectedTemplate = Event.target.parentNode.id;
    switch(selectedTemplate){
        case "templateItem1" :
            location.href="./portfolio/template1.html";
            break;
        case "templateItem2" :
            location.href="./portfolio/template2.html";
            break;
        case "templateItem3" :
            location.href="./portfolio/template3.html";
            break;
        case "templateItem4" :
            location.href="./portfolio/template4.html";
            break;
        case "templateItem5" :
            location.href="./portfolio/template5.html";
            break;
        default:
            console.log('Nothing');
            break;
    }
}