// GET ROOMS LIST
GET: $(document).ready(
    function () {
        // GET REQUEST
        $("#getRooms").click(function (event) {
            ShowTableRooms();
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "rooms",
                success: function (result) {
                    var trHTML = '';
                    $("#roomsTable").find("tr:gt(0)").remove();
                    $.each(result,
                        function (i, room) {
                            trHTML += '<tr style="height: 75px;" ><td class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + room.id +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell">' + room.department +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell">' + room.dnumber +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell">' + room.number +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell"><u style="color: blue">' + "Edit" +
                                '</u> </td><td class="u-border-1 u-border-grey-30 u-table-cell"><u style="color: blue"><i style="color:red;" class="fas fa-trash-alt"></i></u> </td></tr>';
                        });
                    console.log("Success: ", result);
                    $('#records_table').append(trHTML);
                    ActivateDeleteRoom()
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })

//GET SENSORS LIST
GET: $(document).ready(
    function () {
        // GET REQUEST
        $("#getSensors").click(function (event) {
            ShowTableSensors();
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "sensors",
                success: function (result) {
                    var trHTML = '';
                    $("#sensorsTable").find("tr:gt(0)").remove();
                    $.each(result,
                        function (i, sensor) {
                            trHTML += '<tr style="height: 75px;" ><td class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + sensor.id +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell">' + sensor.sensorType +
                                '</td><td class="u-border-1 u-border-grey-30 u-table-cell">' + sensor.dataCaptured +
                                '</u> </td><td class="u-border-1 u-border-grey-30 u-table-cell"><u style="color: blue"><i style="color:red;" class="fas fa-trash-alt"></i></u> </td></tr>';
                        });
                    console.log("Success: ", result);
                    $('#sensors_list').append(trHTML);
                    ActivateDeleteSensor();
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })


//DELETE SENSOR FROM TABLE
function ActivateDeleteSensor() {
    var index, table = document.getElementById('sensorsTable');
    for (var i = 1; i < table.rows.length; i++) {
        console.log(table.rows[i].cells[0].textContent);
        table.rows[i].cells[3].onclick = function () {
            var c = confirm("do you want to delete this row");
            if (c === true) {
                index = this.parentElement.rowIndex;
                deleted_id=this.parentElement.cells[0].textContent;
                AjaxDeleteSensor(deleted_id);
                table.deleteRow(index)
            }
        };
    }
}

//DELETE ROOM FROM TABLE
function ActivateDeleteRoom() {
    var index, table = document.getElementById('roomsTable');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].cells[5].onclick = function () {
            var c = confirm("do you want to delete this Room");
            if (c === true) {
                index = this.parentElement.rowIndex;
                deleted_id=this.parentElement.cells[0].textContent;
                AjaxDeleteRoom(deleted_id);
                table.deleteRow(index);
            }
        };
    }
}


function AjaxDeleteRoom(room_id) {
    console.log("This will be deleted.");
    console.log(room_id);
    // PREPARE FORM DATA
    var postData = {
        id: room_id,
    }
    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "deleteRoom",
        data: JSON.stringify(postData),
        success: function (result) {
            $("#postResultDiv").html("<p> Room Deleted Successfully! </p>");
            console.log(result);
        },
        error: function (e) {
            $("#postResultDiv").html("<p style='background-color:red;'> Error! </p>");
            console.log("ERROR: ", e);
        }
    });
}

function AjaxDeleteSensor(sensor_id) {
    console.log("This will be deleted.");
    console.log(sensor_id);
    // PREPARE FORM DATA
    var postData = {
        id: sensor_id,
    }
    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "deleteSensor",
        data: JSON.stringify(postData),
        success: function (result) {
            $("#postResultDiv").html("<p> Sensor Deleted Successfully! </p>");
            console.log(result);
        },
        error: function (e) {
            $("#postResultDiv").html("<p style='background-color:red;'> Error! </p>");
            console.log("ERROR: ", e);
        }
    });
}


function HideComponents() {
    var table_rooms = document.getElementById('carousel_3133');
    ;
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";

}

function ShowTableRooms() {
    var table_rooms = document.getElementById('carousel_3133');
    ;
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');


    table_rooms.style.display = "block";

    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
}

function ShowTableSensors() {
    var table_rooms = document.getElementById('carousel_3133');
    ;
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');

    table_sensors.style.display = "block";

    table_rooms.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
}



function ShowConfigForm(){
    var table_rooms = document.getElementById('carousel_3133');;
    var table_sensors=document.getElementById('sec-3e05');
    var config_form=document.getElementById('carousel_ad56');
    var new_sensor=document.getElementById('carousel_8ccf');
    var new_room=document.getElementById('sec-29f5');
    var id = document.getElementById('idSelected').value;

    config_form.style.display = "block";

    table_rooms.style.display="none";
    table_sensors.style.display="none";
    new_sensor.style.display="none";
    new_room.style.display="none";
    document.getElementById("editID").innerHTML = id;
}


function ShowNewRoom() {
    var table_rooms = document.getElementById('carousel_3133');
    ;
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');

    new_room.style.display = "block";

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
}

function ShowNewSensor() {
    var table_rooms = document.getElementById('carousel_3133');
    ;
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');

    new_sensor.style.display = "block";

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_room.style.display = "none";
}

