class Location {
    constructor(){
        this.infoWindow;
        this.map;
        this.initMap();
    }
    initMap(){
        this.map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 6
        });
        this.infoWindow = new google.maps.InfoWindow;
        this.infoWindow.setPosition(this.map.center);
        this.infoWindow.setContent("Location");
        this.infoWindow.open(this.map);
    }
}


function start() {
    var api = new Location();
}