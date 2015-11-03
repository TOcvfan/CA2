
$(document).ready(function () {

$("#form").submit(function(e){
    e.preventDefault();
    
});


    //GET    
    $("#getBtn").click(function () {

        $.ajax({
            url: "api/person/" + $("#textField").val(),
            type: "GET"

        }).done(function (dataFromServer) {

            $("#print").empty();
            $("#print").append("<li>" + dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME + "</li>");

        }).fail(function (dataFromServer) {

            $.ajax({
                url: "api/person/phone/" + $("#textField").val(),
                type: "GET"

            }).done(function (dataFromServer) {
                $("#print").empty();
                $("#print").append("<li>" + dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME + "</li>");

            }).fail(function (dataFromServer) {
                $.ajax({
                    url: "api/company/" + $("#textField").val(),
                    type: "GET"

                }).done(function (dataFromServer) {
                    $("#print").empty();
                    $("#print").append("<li>" + dataFromServer.CVR + " " + dataFromServer.NAME + "</li>");
                }).fail(function (dataFromServer) {
                    $.ajax({
                        url: "api/person/zip/" + $("#textField").val(),
                        type: "GET"

                    }).done(function (dataFromServer) {

                        $("#print").empty();
                        for (i = 0; i < dataFromServer.length; i++) {
                            $("#print").append("<li>" + dataFromServer[i].FIRSTNAME + " " + dataFromServer[i].LASTNAME + "</li>");
                        }
                    }).fail(function () {
                        alert("Wat in teh heeellll, dier aint no ppl dawg");
                    })
                })
            })
        })
    });


    //GET /blip
    var mStart = "<marquee behavior=\"alternate\" scrollamount=\"60\">";
    var mEnd = "</marquee>";


    $("#openPostBtn").click(function () {
        window.location.href = "Post.html";
    });


    $("#printBtn").click(function () {
        $.ajax({
            url: "api/person/all",
            type: "GET"

        }).done(function (dataFromServer) {

            $("#print").empty();
            for (i = 0; i < dataFromServer.length; i++) {
                $("#print").append("<li>" + dataFromServer[i].FIRSTNAME + " " + dataFromServer[i].LASTNAME + "</li>");
            }

        }).fail(function () {
            alert("Wat in teh heeellll, dier aint no ppl dawg");
        })

    });



    //POST UNFINISHED
    $("#postBtn").click(function () {
       
//        $(function () {
            var frm = $("#form");
            var dat = JSON.stringify(frm.serializeArray());

            alert("I am about to POST this:\n\n" + dat);
             
             $.ajax({
                 url: "api/person/",
                 type: "POST",
                 data: dat
                 
             }).done(function (dataToServer){
                 console.log(dat + " has been sent to server!");
                 
             }).fail(function (){
                 console.log("OMDG ERRO");
                 
             })
             
//
//            $.post(
//                    frm.attr("action"),
//                    dat,
//                    function (data) {
//                        alert("Response: " + data);
//            
//        });


//        $.ajax({
//            url: "api/person/",
//            type: "POST",
//            data: JSON.stringify({person: $("#fName").val() + $("#lName").val() + $("#eMail").val() + $("#phone").val() + $("#zip").val() + $("#address").val() + $("#addinfo").val()})
//
//        }).done(function (dataToServer) {
//            $("#fName").val(dataToServer.person);
//        }).fail(function () {
//            alert("ERHMEGERD Y I KENT CREAT NEW PERSUN!?");
//        })

    });
    //PUT UNFINISHED
    $("#putBtn").click(function () {
        $.ajax({
            url: "api/person/" + $("#textField").val(),
            type: "PUT",
            data: JSON.stringify({person: $("#theDiv").val()})

        }).done(function (dataToServer) {
            $("#id").val(dataToServer.person);
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
