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
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.department +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.dnumber +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.number +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.maxSeats;

                            //Sort by sensorType
                            room.sensorList = room.sensorList.sort((a,b) => {
                                if(a.sensorType > b.sensorType){
                                    return 1
                                } else{
                                    return -1
                                }});

                            //Fill Table
                            if(room.sensorList.length < 1) {
                                trHTML += '<td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                            else if(room.sensorList.length < 2 && room.sensorList[0].sensorType == "PeopleCounter"){
                                trHTML += '<td align="center" class="u-border-1 u-border-grey-30 u-table-cell"><u style="color:blue">' +  room.sensorList[0].id +
                                    '</u></td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                            else if(room.sensorList.length <2  && room.sensorList[0].sensorType == "Temperature"){
                                trHTML += '<td align="center" class="u-border-1 u-border-grey-30 u-table-cell">'  + "No sensor" +
                                    '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell"><u style="color:blue">' +  room.sensorList[0].id +
                                    '</u></td>';
                            }
                            else{
                                trHTML += '<td align="center" class="u-border-1 u-border-grey-30 u-table-cell"><u style="color:blue">' + room.sensorList[0].id+
                                    '</u></td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell"><u style="color:blue">' +  room.sensorList[1].id +
                                    '</u></td>';
                            }
                            trHTML+='</td><td  align="center"  class="u-border-1 u-border-grey-30 u-table-cell"><i style="color:orangered;"class="fas fa-pencil-alt fa-lg"></i>' +
                                '<td align="center" class="u-border-1 u-border-grey-30 u-table-cell"><i style="color:red;" class="fas fa-times-circle fa-lg"></i> </td></tr>';
                    });
                    console.log("Success: ", result);
                    $('#records_table').append(trHTML);
                    ActivateDeleteRoom();
                    ActivateEditRoom();
                    ActivateSensorHistory(5,5,'roomsTable');
                    ActivateSensorHistory(6,6,'roomsTable');
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
                            trHTML += '<tr style="height: 75px;" ><td id="idSelected" align="center" class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + sensor.id +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + sensor.sensorType +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + sensor.dataCaptured +
                                '</td><td align="center" align="center" class="u-border-1 u-border-grey-30 u-table-cell"><i style="color:blue;"class="fas fa-history fa-lg"></i> </td>' +
                                '<td align="center" align="center" class="u-border-1 u-border-grey-30 u-table-cell"><i style="color:red;" class="fas fa-times-circle fa-lg"></i> </td></tr>';
                        });
                    console.log("Success: ", result);
                    $('#sensors_list').append(trHTML);
                    ActivateDeleteSensor();
                    ActivateSensorHistory(3,0,'sensorsTable')
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })


// GET SENSOR HISTORY
function ajaxSensorHistory(sensor_id) {
    $.ajax({
        type: "GET",
        url: "sensors?id=" + sensor_id,
        success: function (result) {
            var trHTML = '';
            $("#sensor_history").find("tr:gt(0)").remove();
                for (i = result.sensor_history.length-1; i > -1; i--) {
                    trHTML += '<tr style="height: 75px;" ><td id="idSelected" align="center" class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + result.id +
                        '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + result.sensorType +
                        '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + result.sensor_history[i].date +
                        '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + result.sensor_history[i].value + '</td>' ;
                }
            console.log("Success: ", result);
            $('#senhist_list').append(trHTML);
        },
        error: function (e) {
            $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
            console.log("ERROR: ", e);
        }
    });
}

// GET 1 ROOM
function ajaxGetRoom(room_id) {
    $.ajax({
        type: "GET",
        url: "rooms?id=" + room_id,
        success: function (result) {
            console.log("Success: ", result);
            var seats = document.getElementById("seatsEdit");
            var people = document.getElementById("peopleEdit");
            var temp = document.getElementById("tempEdit");
            people.disabled = false;
            temp.disabled = false;
            var maxSeats = result.maxSeats; // id="seatsEdit"
            var SensorPeople = ''; // id="peopleEdit"
            var SensorTemp = '';  // id="tempEdit"


            //Sort sensors by sensorType
            result.sensorList = result.sensorList.sort((a,b) => {
                if(a.sensorType > b.sensorType){
                    return 1
                } else{
                    return -1
                }});

            //GET SENSORS INFO
            if(result.sensorList.length > 1) {
                SensorPeople = result.sensorList[0].id;
                SensorTemp = result.sensorList[1].id;
            }
            else if(result.sensorList.length){
                if(result.sensorList[0].sensorType == "PeopleCounter"){
                    SensorPeople = result.sensorList[0].id
                }
                else
                    SensorTemp = result.sensorList[0].id
            }

            //LOAD INFO ON HTML
            seats.value = maxSeats ;
            people.value = SensorPeople;
            temp.value = SensorTemp;

            if(people.value.length > 0){
                people.disabled=true;
                console.log("disabled true");
            }
            if(temp.value.length > 0)
                temp.disabled=true;



        },
        error: function (e) {
            $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
            console.log("ERROR: ", e);
        }
    });
}



//DELETE SENSOR FROM TABLE
function ActivateDeleteSensor() {
    var index, table = document.getElementById('sensorsTable');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].cells[4].onclick = function () {
            var c = confirm("Do you want to delete this row?");
            if (c === true) {
                index = this.parentElement.rowIndex;
                deleted_id = this.parentElement.cells[0].textContent;
                AjaxDeleteSensor(deleted_id);
                table.deleteRow(index)
            }
        };
    }
}

//See Sensor History
function ActivateSensorHistory(cell,sensor_id_pos,table_id) {
    var table = document.getElementById(table_id);
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].cells[cell].onclick = function () {
                ShowHistorySensors();
                sensor_id = this.parentElement.cells[sensor_id_pos].textContent;
                ajaxSensorHistory(sensor_id);
        };
    }
}

//EDIT ROOM
function ActivateEditRoom() {
    var table = document.getElementById('roomsTable');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].cells[7].onclick = function () {
                ShowConfigForm(this.parentElement.cells[0].textContent);
        };
    }
}

//DELETE ROOM FROM TABLE
function ActivateDeleteRoom() {
    var index, table = document.getElementById('roomsTable');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].cells[8].onclick = function () {
            var c = confirm("Do you want to delete this room?");
            if (c === true) {
                index = this.parentElement.rowIndex;
                deleted_id = this.parentElement.cells[0].textContent;
                AjaxDeleteRoom(deleted_id);
                table.deleteRow(index);
            }
        };
    }
}



function AjaxDeleteRoom(room_id) {
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
            $('#postResultDiv').fadeIn().delay(5000).fadeOut();
        },
        error: function (e) {
            $("#postResultDiv").html("<p style='background-color:red;'> Error! </p>");
            console.log("ERROR: ", e);
            $('#postResultDiv').fadeIn().delay(5000).fadeOut();
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
            $('#postResultDiv').fadeIn().delay(5000).fadeOut();
            console.log(result);
        },
        error: function (e) {
            $("#postResultDiv").html("<p style='background-color:red;'> Error! </p>");
            console.log("ERROR: ", e);
            $('#postResultDiv').fadeIn().delay(5000).fadeOut();
        }
    });
}









function HideComponents() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
    table_history_sensors.style.display="none";

}

function ShowTableRooms() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');


    table_rooms.style.display = "block";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
    table_history_sensors.style.display="none";
}

function ShowTableSensors() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');

    table_sensors.style.display = "block";
    table_rooms.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
    table_history_sensors.style.display="none";
}

function ShowHistorySensors() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
    table_history_sensors.style.display="block";

}

function ShowConfigForm(num) {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');
    var id = null;


    // vem do input box
    if (num == -1) {
        id = document.getElementById('idSelected').value;
    } else { // Não vem do input
        id = num;
    }

    console.log(id)
    if(id !=""){
        table_rooms.style.display = "none";
        table_sensors.style.display = "none";
        new_sensor.style.display = "none";
        new_room.style.display = "none";
        table_history_sensors.style.display="none";
        config_form.style.display = "block";
        ajaxGetRoom(id)
    }

    document.getElementById("editID").innerHTML = id;
    if (num == -1) {
        document.getElementById('idSelected').value = '' //reset search
    }
}


function ShowNewRoom() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');

    new_room.style.display = "block";

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    table_history_sensors.style.display="none";
}

function ShowNewSensor() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var table_history_sensors = document.getElementById('senhistory');

    new_sensor.style.display = "block";
    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_room.style.display = "none";
    table_history_sensors.style.display="none";
}

