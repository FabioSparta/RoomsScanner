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
                },
                error : function(e) {
                    $("#postResultDiv").html("<p style='background-color:#ff0000;'> Error! </p>");
                    console.log("ERROR: ", e);
                }
            });

        }
    })


// EDIT ROOM + ASSOCIATE ROOM AND SENSORS
$(document).ready(
    function() {
        // SUBMIT FORM
        $("#editRoomForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            var roomID =  document.getElementById('editID').innerText;
            alert(roomID)
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
                type : "POST",
                contentType : "application/json",
                url : "roomsEdit",
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#editRoomdiv").html("<p> Seats updated successfully! </p>");
                    console.log(result);
                    $("#editRoomForm")[0].reset();
                },
                error : function(e) {
                    $("#editRoomdiv").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
                }
            });
        }
        function ajaxPost1(roomID) {
            // PREPARE FORM DATA
            var formData = {
                id : $("#peopleEdit").val(),
                sensorType : "People Counter"
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "roomSetSensor/"+roomID,
                data : JSON.stringify(formData),
                success : function(result) {
                    $("#editRoomdiv2").html("<p> Occupancy sensor added to room "+roomID+"! </p>");
                    console.log(result);
                    $("#editRoomForm")[0].reset();
                },
                error : function(e) {
                    $("#editRoomdiv2").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
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
                    $("#editRoomdiv3").html("<p> Temperature sensor added to room "+roomID+"! </p>");
                    console.log(result);
                    $("#editRoomForm")[0].reset();
                },
                error : function(e) {
                    $("#editRoomdiv3").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
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
            alert(sensorData.sensorType)
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "sensors",
                data: JSON.stringify(sensorData),
                success: function (result) {
                    $("#postsensor").html("<p> Sensor created successfully! </p>");
                    console.log(result);
                    $("#newSensorForm")[0].reset();
                },
                error: function (e) {
                    $("#postsensor").html("<p style='background-color:red;'> Error! </p>");
                    console.log("ERROR: ", e);
                }
            });
        }

    })