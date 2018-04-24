API_URL = "http://localhost:8080/calculator";

$(document).ready(function () {

    getCountries();

    function getCountries() {
        $.ajax({
            url: API_URL
        }).done(function (countries) {
            console.log(countries);
            showCountries(countries);
        })
    }

    $('button').on('click', function (e) {
        e.preventDefault();

        var value = $('#value').val();

        if($.isNumeric(value) & value > 0) {
            $('#error').text('');

            var valueToSend = {
                value: value
            };

            var headers = new Headers({
                'Content-Type': 'application/json'
            });

            var myInit = {
                method: 'POST',
                headers: headers,
                cache: 'default',
                body: JSON.stringify(valueToSend)
            };

            fetch(API_URL + '/calculate', myInit).then(function (response) {
                showCountries(response);
            })

        } else {
            $('#error').text('Błędna wartość');
        }

    })

    function showCountries(countries) {
        var ul = $('div.countries');
        countries.forEach(function (country) {
            var earning;
            if(country.earning === undefined) {
                earning = 'przelicz';
            } else {
                earning = country.earning;
            }
            var li = $('<p>Miesięczny zarobek w ' + country.countrySymbol +
                ' - '+ earning +'</p>');
            ul.append(li);
        })
    }
})