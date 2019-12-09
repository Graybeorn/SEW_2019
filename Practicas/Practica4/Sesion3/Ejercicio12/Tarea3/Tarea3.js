class Localizacion {
    constructor() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(this.showPosition, this.showError);
        } else {
            $("#mapholder").text("Este buscador no ofrece soporte para geolocalizacion.");
        }
    }
    
    showPosition(position) {
        console.log("Latitude: " + position.coords.latitude +
            "< Longitude: " + position.coords.longitude);
        var latlon = position.coords.latitude + "," + position.coords.longitude;
      
        var img_url = "https://maps.googleapis.com/maps/api/staticmap?center="
                +latlon+"&zoom=14&size=400x300&markers=color:blue%7Clabel:L%7C"+latlon+"&sensor=false&key=AIzaSyBfk99zVNKvTHEwZ8BeL9FlkDlM_dIMIbU";
      
        $("#mapholder").html("<img src='"+img_url+"'>");
    }

    showError(error) {
        switch(error.code) {
          case error.PERMISSION_DENIED:
              $("#mapholder").text("Acceso denegado a Geolocalizacion");
            break;
          case error.POSITION_UNAVAILABLE:
              $("#mapholder").text("Informacion no disponible.");
            break;
          case error.TIMEOUT:
              $("#mapholder").text("La solicitud de permisos ha caducado.");
            break;
          case error.UNKNOWN_ERROR:
              $("#mapholder").text("Ha sucedido un error desconocido.");
            break;
        }
    }
    
}

var api = new Localizacion();