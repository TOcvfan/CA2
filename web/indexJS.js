
$(document).ready(function () {


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
                })

            })

        })


//        $.ajax({
//            url: "api/person/zip/" + $("#textField").val(),
//            type: "GET"
//
//        }).done(function (dataFromServer) {
//            $("#theDiv").val(dataFromServer.FIRSTNAME + " " + dataFromServer.LASTNAME);
//        })






    });


    //GET /blip
    var mStart = "<marquee behavior=\"alternate\" scrollamount=\"60\">";
    var mEnd = "</marquee>";




    var john = function (i, item) {
        $("#print").append("<li>" + item + "</li>");
    };

    $("#printBtn").click(function () {
        $.ajax({
            url: "api/person/all",
            type: "GET"

        }).done(function (dataFromServer) {

            $("#print").empty();
            for (i=0; i< dataFromServer.length;i++) {
                $("#print").append("<li>" + dataFromServer[i].FIRSTNAME + " " + dataFromServer[i].LASTNAME + "</li>");
            }



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
            $("#id").val(dataToServer.person);
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