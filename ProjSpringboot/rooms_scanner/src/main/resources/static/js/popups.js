
function displaySignUp() {
    var modal = document.getElementById('sec-e252');
    modal.style.display = "none";
    var modal = document.getElementById('sec-f378');
    modal.style.display = "block";
    $("#signUpForm")[0].reset();
    $("#signUp_result").hide();
}
function displayLogin() {
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
