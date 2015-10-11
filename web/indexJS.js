
            $(document).ready(function () {
                var gotData = false;
                while(gotData == false){
                
//                    var getPerson = function () {
//                                        $.ajax({
//                        url: "api/person/" + $("#textField").val(),
//                        type: "GET"
//
//                    }).done(function (dataFromServer){
//                        $("#theDiv").val(dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME);
//                    })
//                };
//                
                
                //GET    
                $("#getBtn").click(function () {
                    $.ajax({
                        url: "api/person/" + $("#textField").val(),
                        type: "GET"

                    }).done(function (dataFromServer) {
                        $("#theDiv").val(dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME);
//                        gotData = true;
                    })
                    
                    $.ajax({
                        url: "api/person/phone/" + $("#textField").val(),
                        type: "GET"
                        
                    }).done(function (dataFromServer) {
                        if(dataFromServer.FIRSTNAME.equalsIgnoreCase("undefined")){
                        $("#theDiv").val(dataFromServer.CVR + " " + dataFromServer.NAME);
                      
                        }else{
                        $("#theDiv").val(dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME);
                    }
                    })
                    
                    $.ajax({
                        url: "api/person/zip/" + $("#textField").val(),
                        type: "GET"

                    }).done(function (dataFromServer) {
                        $("#theDiv").val(dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME);
                    })
                    
                    
                    
                    $.ajax({
                        url: "api/company/" + $("#textField").val(),
                        type: "GET"
                        
                    }).done(function (dataFromServer){
                        $("#theDiv").val(dataFromServer.CVR + " " + dataFromServer.NAME);
                    })
                    

                });
          }

                //GET /blip
                var mStart = "<marquee behavior=\"alternate\" scrollamount=\"60\">";
                var mEnd = "</marquee>";
                
                
                var john = function (i, item) {
                    $("#print").append(mStart + item + mEnd);
                };

                $("#printBtn").click(function () {
                    $.ajax({
                        url: "api/person/all",
                        type: "GET"

                    }).done(function (dataFromServer) {
                        $.each($.parseJSON(dataFromServer), function(i, item){
                            $("#print").append(item);
                            
                        });

                    }).fail(function () {
                        alert("Wat in teh heeellll, dier aint no ppl dawg");
                    })

                });

                //POST UNFINISHED
                $("#createBtn").click(function () {
                    var nQ = $("#").val();


                    $.ajax({
                        url: "api/person/",
                        type: "POST",
                        data: JSON.stringify({person: $("#theDiv").val()})

                    }).done(function (dataToServer) {
                        $("#theDiv").val(dataToServer.person);
                    }).fail(function () {
                        alert("ERHMEGERD Y I KENT CREAT NEW PERSUN!?");
                    })

                });
                //PUT UNFINISHED
                $("#putBtn").click(function () {
                    $.ajax({
                        url: "api/person/" + $("#textField").val(),
                        type: "PUT",
                        data: JSON.stringify({person: $("#theDiv").val()})

                    }).done(function (dataToServer) {
                        $("#theDiv").val(dataToServer.person);
                    }).fail(function () {
                        alert("ERHMERHGEWD KENT PUT STUF HIER : (");
                    })

                });

                //DELETE UNFINISHED
                $("#deleteBtn").click(function () {
                    $.ajax({
                        url: "api/person/" + $("#textField").val(),
                        type: "DELETE",
                        data: JSON.stringify({person: $("#textField").val()})


                    }).done(function (dataToServer) {
                        $("id").val(dataToServer.person);


                    }).fail(function () {
                        alert("ERHMEGEWD NO DELIet : (");

                    })

                });

            });