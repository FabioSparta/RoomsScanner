

function HideComponents() {
    var table = document.getElementById('sec-3e05');
    var config_form=document.getElementById('sec-29f5');
    table.style.display="none";
    config_form.style.display="none";
}
function ShowTable(){
    var table = document.getElementById('sec-3e05');
    var config_form=document.getElementById('sec-29f5');
    table.style.display="block";
    config_form.style.display="none";
}
function ShowConfigForm(){
    var table = document.getElementById('sec-3e05');
    var config_form=document.getElementById('sec-29f5');
    config_form.style.display="block";
    table.style.display="none";
}