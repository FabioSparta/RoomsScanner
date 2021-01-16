// SIGN UP
GET: $(document).ready(
    function () {
        // GET REQUEST
        $("#signUp_click").click(function (event) {
            event.preventDefault();
            console.log("Entered sign up onclick event ");
            if($("#pw_field").val() == $("#conf_pw_field").val() )
                ajaxPost();
            else
                console.log("Passwords do not match.");
        });

        function ajaxPost() {
            // PREPARE FORM DATA
            console.log("nmec below")
            console.log($("#nmec_field").val());
            var formData = {
                nmec : $("#nmec_field").val(),
                username : $("#username_field").val(),
                email : $("#email_field").val(),
                password : $("#pw_field").val(),
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "user",
                data : JSON.stringify(formData),
                success : function(result) {
                    //$("#postResultDiv").html("<p> Room created successfully! </p>");
                    console.log("User signed up successfully");
                    console.log(result);
                    //$("#postResultDiv").html("<p> Room created successfully! </p>");
                    $("#signUp_result").show();
                    setTimeout(displayLogin, 1200);
                    $("#signUp_result").hide();
                    //$("#newRoomForm")[0].reset();
                    //$('#postResultDiv').fadeIn().delay(5000).fadeOut();
                },
                error : function(e) {
                    //$("#postResultDiv").html("<p style='background-color:#ff0000;'> Error! </p>");
                    console.log("ERROR: ", e);
                    console.log(e.responseText);
                    document.getElementById("signUp_failed").innerHTML = e.responseText;
                    $('#signUp_failed').fadeIn().delay(3000).fadeOut();
                }
            });
        }
    })

// LOGIN
GET: $(document).ready(
    function () {
        // GET REQUEST
        $("#login_click").click(function (event) {
            event.preventDefault();
            ajaxLogin($("#login_username").val(),$("#login_pw").val());
        });

        // LOGIN
        function ajaxLogin(username,pw) {
            $.ajax({
                type: "GET",
                url: "user?username=" + username + "&pw=" + pw,
                success: function (result) {
                    console.log(result)
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Failed to Load Rooms</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })

