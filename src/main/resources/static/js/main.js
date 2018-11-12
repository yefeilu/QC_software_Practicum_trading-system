console.log("Hello, ");

$(document).ready(function () {
   $("#calculate_yield").submit(function (event) {
       //stop submit the form, we will post it manually
       event.preventDefault();
       fire_ajax_submit();
   });
});

function fire_ajax_submit() {
    var params = {
        "bondName": $("#calculateByBond").val(),
        "bondValue": $("#bond_value").val()
    };
    $("#btn_calculate").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: "/user/market/calculateYield",
        data: params,
        success: function (data) {
            console.log(data);
            $("#display_yield").html(data);
            $("#btn_calculate").prop("disabled", false);
        },
        error: function (error) {
            console.log("Error", error);
            $("#display_yield").html(error);
            $("#btn_calculate").prop("disabled", false);
        }
    });
}

function getInfo(obj) {
    var stockName = $(obj).parents("tr").find("#stockName").text();
    getCurrentPrice(stockName);
}


function getCurrentPrice(stockName) {
    $.ajax({
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: "/user/market/getStockPrice",
        data: {"stockName": stockName },
        success: function (data) {
            console.log("Current price of ", stockName , " is: ", data);
            $("#currentPrice").html(data);
        },
        error: function (error) {
            console.log("Error: ", error);
        }
    });
}

function buyStock(obj) {

    console.log("Confirmed!");
}