class Localizacion {
    constructor() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(this.showPosition);
        } else {
            $("#mapholder").text("Este buscador no ofrece soporte para geolocalizacion.");
        }
    }
    
    showPosition(position) {
        $('#info').html("Latitude: " + position.coords.latitude +
        "<br>Longitude: " + position.coords.longitude);
    }
    
}

var api = new Localizacion();