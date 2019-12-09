class Location {
    constructor(){
        this.infoWindow;
        this.map;
        this.initMap();
        this.labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
        this.labelsIndex = 0;
        this.path = [];
        this.coordinates = [];
    }

    cerrarCamino(){
        this.path.push("");
        this.coordinates = [];
    }

    initMap(){
        this.map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 6
        });
        
        google.maps.event.addListener(this.map, 'click', function(event) {
            this.addMarker(event.latLng, this.map);
        }.bind(this));
        this.infoWindow = new google.maps.InfoWindow;
        if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition(this.showPosition.bind(this), this.showError.bind(this));
        } else {
            $("#info").text("Este buscador no ofrece soporte para geolocalizacion.");
        }
    }

    addMarker(location, map){ 
        var marker = new google.maps.Marker({
            position: location,
            label: this.labels[this.labelIndex++ % this.labels.length],
            map: map
        });
        this.coordinates.push(location);
        this.path[this.path.length-1] = new google.maps.Polyline({
            path: this.coordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2,
            map:map
        });
    }

    showPosition(position) {
        var pos = {
            lat: position.coords.latitude,
            lng: position.coords.longitude
        };

        var marker = new google.maps.Marker({position: pos, map: this.map});
        this.map.setCenter(pos);
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

var api;
function start() {
    api = new Location();
}