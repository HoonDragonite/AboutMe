loadEvents();

function loadEvents(){
    /* 기본 이미지 로딩*/
    var userImage = document.getElementById('userImage');
    userImage.src ="../Image/empty.png";
    
    /* 업로드 버튼 클릭 시 input click 발생 */
    var inputUserImage = document.getElementById('inputUserImage');
    inputUserImage.addEventListener('change', uploadUserImage);
    
    var uploadBtn = document.getElementById('uploadBtn');
    uploadBtn.addEventListener('click', function(){
        inputUserImage.click();
    });

    /* 기술 엔터키 이벤트, 입력 이벤트*/
    var tech = document.getElementById('tech');
    var techList = document.getElementById('techList');
    var techBtn = document.getElementById('techBtn');

    tech.onkeyup = function(){
        if(window.event.keyCode == 13){
            techBtn.click();
        }
    }

    techBtn.addEventListener('click', function(){
        var li = document.createElement("li");
        var str = document.createTextNode(tech.value);
        li.appendChild(str);
        techList.appendChild(li);
        tech.value = '';
    })


    /* 프로젝트 엔터키 이벤트, 입력 이벤트*/
    var pjt = document.getElementById('pjt');
    var pjtList = document.getElementById('pjtList');
    var pjtBtn = document.getElementById('pjtBtn');

    pjt.onkeyup = function(){
        if(window.event.keyCode == 13){
            pjtBtn.click();
        }
    }

    pjtBtn.addEventListener('click', function(){
        var li = document.createElement("li");
        var str = document.createTextNode(pjt.value);
        li.appendChild(str);
        pjtList.appendChild(li);
        pjt.value = '';
        
        /*
        for(var i=0; i<pjtList.childElementCount; i++){
            console.log('item : ' + pjtList.children[i].textContent);
        }
        console.log('Count : ' + pjtList.childElementCount);
        console.log('children : ' + pjtList.children);
        */
    })


    /* 이벤트 등록 */
    var submitBtn = document.getElementById('submitBtn');
    submitBtn.addEventListener('click', moveToSelect);
}

/* 세션에 값 담아서 양식 선택 화면으로 이동*/
function moveToSelect(){
    console.log('moveToSelect');

    sessionStorage.clear();

    var name = document.getElementById('name');
    var phone = document.getElementById('phone');
    var email = document.getElementById('email');
    
    sessionStorage.setItem("name", name.value);
    sessionStorage.setItem("phone", phone.value);
    sessionStorage.setItem("email".id, email.value);
    sessionStorage.setItem("userImage", userImage.src);

    sessionStorage.setItem("techList", JSON.stringify(techList.children));
    sessionStorage.setItem("pjtList", JSON.stringify(pjtList.children));
    
    
    var jsonTechList = JSON.parse(sessionStorage.getItem("techList"));
    console.log(jsonTechList);
    
    var jsonPjtList = JSON.parse(sessionStorage.getItem("pjtList"));
    console.log(jsonPjtList);
    
    //location.href="./select.html";
}

/* 업로드한 이미지 출력 */
function uploadUserImage(){
    var input = document.getElementById('inputUserImage');
    var fReader = new FileReader();

    fReader.readAsDataURL(input.files[0]);
    fReader.onloadend = function(Event){
        userImage.src = Event.target.result;
    }   
}