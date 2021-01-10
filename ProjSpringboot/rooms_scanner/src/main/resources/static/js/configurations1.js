function HideComponents() {
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');

    table_rooms.style.display="none";
    table_sensors.style.display="none";
    config_form.style.display="none";
    new_sensor.style.display="none";
    new_room.style.display="none";

}

function ShowTableRooms(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');

    table_rooms.style.display="block";

    table_sensors.style.display="none";
    config_form.style.display="none";
    new_sensor.style.display="none";
    new_room.style.display="none";
}

function ShowTableSensors(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');

    table_sensors.style.display="block";

    table_rooms.style.display="none";
    config_form.style.display="none";
    new_sensor.style.display="none";
    new_room.style.display="none";
}


function ShowConfigForm(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');
    var id = document.getElementById('idSelected').value;

    config_form.style.display="block";

    table_rooms.style.display="none";
    table_sensors.style.display="none";
    new_sensor.style.display="none";
    new_room.style.display="none";
    document.getElementById("editID").innerHTML = id;
}


function ShowNewRoom(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');

    new_room.style.display="block";

    table_rooms.style.display="none";
    table_sensors.style.display="none";
    config_form.style.display="none";
    new_sensor.style.display="none";
}

function ShowNewSensor(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');

    new_sensor.style.display="block";

    table_rooms.style.display="none";
    table_sensors.style.display="none";
    config_form.style.display="none";
    new_room.style.display="none";
}

