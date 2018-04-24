API_URL = "http://localhost:8080/calculator";

$(document).ready(function () {

    getCountries();

    function getCountries() {
        $.ajax({
            url: API_URL
        }).done(function (countries) {
            console.log(countries);
        })
    }
})