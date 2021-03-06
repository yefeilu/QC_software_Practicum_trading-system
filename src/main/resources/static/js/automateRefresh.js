
function refreshStock() {
    setInterval(function () {
        let rowStr = '';
        $.ajax({
            type: "GET",
            url: "/user/market/stocks",
            contentType: "application/json; charset=utf-8",
            success: function (stocks) {
                $.each(stocks, function (index, stock) {
                    console.log(stock);
                    rowStr += '<tr> <td id="index" style="display: none">'+index+'</td>'
                            + '<td id="stockName">'+stock.stockName+'</td>'
                            + '<td>' + stock.price + '</td>'
                            + '<td>' + stock.stockField + '</td>'
                            + '<td> <button class="btn btn-primary" onclick="getCurrentPrice(this)" data-toggle="modal" data-target="#buyStock">Buy/Sell</button></td></tr>';
                });
                $('#stockBody').html(rowStr);
            }
        });
    }, 5000);
}

function refreshOption() {
    setInterval(function () {
        let rowStr = '';
        $.ajax({
            type: "GET",
            url: "/user/market/options",
            contentType: "application/json; charset=utf-8",
            success: function (options) {
                $.each(options, function (index, option) {
                    let issuedOn = JSON.stringify(option.createdOn);
                    let expire = JSON.stringify(option.expiration);
                    rowStr += '<tr> <td id="optionName">' + option.optionName + '</td>'
                            + '<td id="underlying">' + option.underlying + '</td>'
                            + '<td id="strikePrice">' + option.strikePrice + '</td>'
                            + '<td id="optionValue">' + option.optionValue + '</td>'
                            + '<td >' + issuedOn.substr(1,10) + '</td>'
                            + '<td id="expire">' + expire.substr(1,10) + '</td>'
                            + '<td id="putCall">' + option.putCall + '</td>'
                            + '<td id="ameEur">' + option.ameEur + '</td>'
                            + '<td><button class="btn btn-primary" onclick="buyOption(this)">Buy</button></td> </tr>';
                });
                $('#optionBody').html(rowStr);
            }
        });
    }, 5000);
}

function refreshBond() {
    setInterval(function () {
        let rowStr = '';
        $.ajax({
            type: "GET",
            url: "/user/market/bonds",
            contentType: "application/json; charset=utf-8",
            success: function (bonds) {
                $.each(bonds, function (index, bond) {
                    let maturity = JSON.stringify(bond.maturity);
                    let issuedOn = JSON.stringify(bond.issuedOn);
                    console.log(bond);
                    rowStr += '<tr> <td id="bondName">'+bond.bondName+'</td>'
                            + '<td id="coupon">'+bond.coupon+'</td>'
                            + '<td>'+maturity.substr(1,10)+'</td>'
                            + '<td id="issuedOn">'+bond.createdOn+'</td>'
                            + '<td>100.0</td>'
                            + '<td id="value">'+bond.bondValue+'</td>'
                            + '<td style="display: none" id="length">'+bond.maturityLength+'</td>'
                            + '<td><button class="btn btn-primary" onclick="buyBond(this)">Buy</button></td>'
                });
                $('#bondBody').html(rowStr);
            }
        });
    }, 5000);
}