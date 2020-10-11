initFirebase();

function  initFirebase(){
    console.log("Firebase 초기화");
    var firebaseConfig = {
        apiKey: "AIzaSyCDmSXqLBL0d4CeTwqOEYUq0amxQ516OIQ",
        projectId: "aboutme-86854",
        appID: "1:659228179523:web:9380e2db2e933d222fe8f6",
    };

    firebase.initializeApp(firebaseConfig);
}