function displaySignUp() {
    var modal1 = document.getElementById('sec-e252');
    modal1.style.display = "none";
    var modal2 = document.getElementById('sec-f378');
    modal2.style.display = "block";
    console.log("should be displaying sign up")
    $("#signUpForm")[0].reset();
    $("#signUp_result").hide();
}

function displayLogin() {
    console.log("should display login")
    var modal = document.getElementById('sec-f378');
    modal.style.display = "none";
    var modal = document.getElementById('sec-e252');
    modal.style.display = "block";
}

function closePopUp() {
    var modal = document.getElementById('sec-f378');
    modal.style.display = "none";
    var modal = document.getElementById('sec-e252');
    modal.style.display = "none";
}
