class Localizacion {
    constructor() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(this.showPosition, this.showError);
        } else {
            $("#info").text("Este buscador no ofrece soporte para geolocalizacion.");
        }
    }
    
    showPosition(position) {
        $('#info').html("Latitude: " + position.coords.latitude +
        "<br>Longitude: " + position.coords.longitude);
    }

    showError(error) {
        switch(error.code) {
          case error.PERMISSION_DENIED:
              $("#info").text("Acceso denegado a Geolocalizacion");
            break;
          case error.POSITION_UNAVAILABLE:
              $("#info").text("Informacion no disponible.");
            break;
          case error.TIMEOUT:
              $("#info").text("La solicitud de permisos ha caducado.");
            break;
          case error.UNKNOWN_ERROR:
              $("#info").text("Ha sucedido un error desconocido.");
            break;
        }
    }
    
}

var api = new Localizacion();