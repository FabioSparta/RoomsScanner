// CREATE ROOM
$(document).ready(
    function() {
        // SUBMIT FORM
        $("#newRoomForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            // PREPARE FORM DATA
            var formData = {
                department : $("#department").val(),
                dnumber : $("#dnumber").val(),
                floor : $("#floor").val(),
                number : $("#number").val(),
                maxSeats : $("#maxSeats").val()
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "rooms",
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#postResultDiv").html("<p> Room created successfully! </p>");
                    console.log(result);
                    $("#newRoomForm")[0].reset();
                    $('#postResultDiv').fadeIn().delay(5000).fadeOut();
                },
                error : function(e) {
                    $("#postResultDiv").html("<p style='background-color:#ff0000;'> Error! </p>");
                    console.log("ERROR: ", e);
                    $('#postResultDiv').fadeIn().delay(5000).fadeOut();
                }
            });

        }
    })
// BOTOES EDIT FORM
$(document).ready(function(){
    $("#editForm button").click(function (ev) {
        ev.preventDefault()
        if ($(this).attr("value") == "update") {
            $("#editForm").submit();
        }
        if ($(this).attr("value") == "rmTemp") {
            rmSensor("tempEdit");
        }
        if ($(this).attr("value") == "rmPeop") {
            rmSensor("peopleEdit");
        }
    });
});
function rmSensor(type) {
    // PREPARE FORM DATA
    var formData = {
        id:  $("#"+type).val()
    }
    // DO POST
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "roomRmSensor/"+document.getElementById('editID').innerText,
        data : JSON.stringify(formData),
        success : function(result) {
            $("#editRoomdiv4").html("<p style='color:white'> Sensor removed! </p>");
            console.log(result);
            $("#editForm")[0].reset();
            $('#editRoomdiv4').fadeIn().delay(5000).fadeOut();
        },
        error : function(e) {
            $("#editRoomdiv4").html("<p style='background-color:red;'> Error! </p>");
            console.log("ERROR: ", e);
            $('#editRoomdiv4').fadeIn().delay(5000).fadeOut();
        }
    });
}


// EDIT ROOM + ASSOCIATE ROOM AND SENSORS
$(document).ready(
    function() {
        // SUBMIT FORM
        $("#editForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            var roomID =  document.getElementById('editID').innerText;
            ajaxPost(roomID);
            ajaxPost1(roomID);
            ajaxPost2(roomID);
        });

        function ajaxPost(roomID) {
            // PREPARE FORM DATA
            var formData = {
                id:  roomID,
                maxSeats : $("#seatsEdit").val()
            }
            // DO POST
            $.ajax({
                type : "PUT",
                contentType : "application/json",
                url : "roomsEdit",
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#editRoomdiv").html("<p style='color:white'> Seats updated successfully! </p>");
                    console.log(result);
                    $("#editForm")[0].reset();
                    $('#editRoomdiv').fadeIn().delay(5000).fadeOut();
                },
                error : function(e) {
                    $("#editRoomdiv").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
                    $('#editRoomdiv').fadeIn().delay(5000).fadeOut();
                }
            });
        }
        function ajaxPost1(roomID) {
            // PREPARE FORM DATA
            var formData = {
                id : $("#peopleEdit").val(),
                sensorType : "PeopleCounter"
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "roomSetSensor/"+roomID,
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#editRoomdiv2").html("<p style='color:white'> Occupancy sensor added to room "+roomID+"! </p>");
                    console.log(result);
                    $("#editForm")[0].reset();
                    $('#editRoomdiv2').fadeIn().delay(5000).fadeOut();
                },
                error : function(e) {
                    $("#editRoomdiv2").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
                    $('#editRoomdiv2').fadeIn().delay(5000).fadeOut();
                }
            });
        }
        function ajaxPost2(roomID) {
            // PREPARE FORM DATA
            var formData = {
                id : $("#tempEdit").val(),
                sensorType : "Temperature"
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "roomSetSensor/"+roomID,
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#editRoomdiv3").html("<p style='color:white'> Temperature sensor added to room "+roomID+"! </p>");
                    console.log(result);
                    $("#editForm")[0].reset();
                    $('#editRoomdiv3').fadeIn().delay(5000).fadeOut();
                },
                error : function(e) {
                    $("#editRoomdiv3").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
                    $('#editRoomdiv3').fadeIn().delay(5000).fadeOut();
                }
            });
        }
    })

// CREATE SENSOR
$(document).ready(

    function() {
        // SUBMIT FORM
        $("#newSensorForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost(getSelect());
        });

        function getSelect() {
            var txt = $('#selectBox').find("option:selected").text();
            return txt
        };

        function ajaxPost(txt) {
            // PREPARE FORM DATA
            var sensorData = {
                id: $("#id").val(),
                sensorType: txt,
            }
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "sensors",
                data: JSON.stringify(sensorData),
                success: function (result) {
                    $("#postsensor").html("<p> Sensor created successfully! </p>");
                    $('#postsensor').fadeIn().delay(5000).fadeOut();
                    console.log(result);
                    $("#newSensorForm")[0].reset();
                },
                error: function (e) {
                    $("#postsensor").html("<p style='background-color:red;'> Error! </p>");
                    $('#postsensor').fadeIn().delay(5000).fadeOut();
                    console.log("ERROR: ", e);
                }
            });
        }
    })

// GET NOTIFICATIONS
GET: $(document).ready(
    function () {
        // GET REQUEST
        $("#getNotifications").click(function (event) {
            ShowTableNotifications();
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "notifications",
                success: function (result) {
                    var trHTML = '';
                    $("#notificationsTable").find("tr:gt(0)").remove();
                    $.each(result,
                        function (i, notification) {
                            trHTML += '<tr style="height: 75px;" ><<td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + notification.message +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + notification.date +" "+ notification.time;
                            });

                    console.log("Success: ", result);
                    $('#tableN').append(trHTML);
                },
                error: function (e) {
                    $("#getResNotifications").html("<strong>Failed to Load Notifications</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })

function ShowTableNotifications() {
    var table_rooms = document.getElementById('carousel_3133');
    var table_sensors = document.getElementById('sec-3e05');
    var config_form = document.getElementById('carousel_ad56');
    var new_sensor = document.getElementById('carousel_8ccf');
    var new_room = document.getElementById('sec-29f5');
    var notifications_table = document.getElementById('notificationsSection');

    notifications_table.style.display = "block";

    table_rooms.style.display = "none";
    table_sensors.style.display = "none";
    config_form.style.display = "none";
    new_sensor.style.display = "none";
    new_room.style.display = "none";
}
