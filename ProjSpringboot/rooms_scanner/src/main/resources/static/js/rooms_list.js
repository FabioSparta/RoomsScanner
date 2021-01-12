// GET ROOMS LIST
GET: $(document).ready(
    function () {
        ajaxGet();
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
                            trHTML += '<tr style="height: 75px;" ><td class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + room.department +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.dnumber +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.number + '</td>';
                            if(room.sensorList.length > 0) {
                                if(room.sensorList[0].dataCaptured >= room.maxSeats){
                                    trHTML += '<td  class="u-border-1 u-border-grey-30 u-table-cell"><p style="color:red">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</p></td>';
                                }
                                else if (room.sensorList[0].dataCaptured ==0){
                                    trHTML += '<td  class="u-border-1 u-border-grey-30 u-table-cell"><p style="color:green">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</p></td>';
                                }
                                else{
                                    console.log("smaller than limit");
                                    trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</td>';
                                }
                            }
                            else{
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                            if(room.sensorList.length > 1) {
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + room.sensorList[1].dataCaptured + "ºC" +
                                    '</td>';
                            }
                            else{
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                        });
                    console.log("Success: ", result);
                    $('#table_body').append(trHTML);
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })


// FILTER ROOM

$(document).ready(
    function() {
        // SUBMIT FORM
        $("#filter_form").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            // PREPARE FORM DATA
            var formData = {
                department : $("#filter_department").val(),
                floor : $("#filter_floor").val(),
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "filterRooms",
                data : JSON.stringify(formData),
                success : function(result) {
                    var trHTML = '';
                    $("#roomsTable").find("tr:gt(0)").remove();
                    $.each(result,
                        function (i, room) {
                            trHTML += '<tr style="height: 75px;" ><td class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">' + room.department +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.dnumber +
                                '</td><td align="center" class="u-border-1 u-border-grey-30 u-table-cell">' + room.number + '</td>';
                            if(room.sensorList.length > 0) {
                                if(room.sensorList[0].dataCaptured >= room.maxSeats){
                                    trHTML += '<td  class="u-border-1 u-border-grey-30 u-table-cell"><p style="color:red">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</p></td>';
                                }
                                else if (room.sensorList[0].dataCaptured ==0){
                                    trHTML += '<td  class="u-border-1 u-border-grey-30 u-table-cell"><p style="color:green">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</p></td>';
                                }
                                else{
                                    console.log("smaller than limit");
                                    trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + room.sensorList[0].dataCaptured + "/" + room.maxSeats +
                                        '</td>';
                                }
                            }
                            else{
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                            if(room.sensorList.length > 1) {
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + room.sensorList[1].dataCaptured + "ºC" +
                                    '</td>';
                            }
                            else{
                                trHTML += '<td class="u-border-1 u-border-grey-30 u-table-cell">' + "No sensor" +
                                    '</td>';
                            }
                        });
                    console.log("Success: ", result);
                    $('#table_body').append(trHTML);
                    console.log("Before if ")
                        if ($('#roomsTable tr').length == 1) {
                        console.log("0 rows");
                        $("#some_error").html("<p style='background-color:#ff0000; color:white ;'> There are no rooms with the specified characteristic. </p>");
                    }
                    else{
                        console.log("entered else ");
                        $("#some_error").hide();
                    }
                },
                error : function(e) {
                    $("#some_error").html("<p style='background-color:#ff0000;'> Error! </p>");
                    console.log("ERROR: ", e);
                }
            });

        }
    })


