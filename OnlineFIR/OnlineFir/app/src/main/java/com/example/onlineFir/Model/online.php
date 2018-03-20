
<script src="https://www.gstatic.com/firebasejs/4.11.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyBnscVF2B7Ls3SHpG9xTTJiE65pbV_7Y0s",
    authDomain: "onlinefir-f357e.firebaseapp.com",
    databaseURL: "https://onlinefir-f357e.firebaseio.com",
    projectId: "onlinefir-f357e",
    storageBucket: "onlinefir-f357e.appspot.com",
    messagingSenderId: "629129808872"
  };
  firebase.initializeApp(config);
  
  function a(){
	var name = document.getElementById("aadhaar").value;
	
	firebase.database().ref('Report/' +aadhaar).set(message);
	return false;
  }
</script>

