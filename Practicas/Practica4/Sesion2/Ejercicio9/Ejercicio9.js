class Climate {
    constructor() {
        this.url1= 'http://api.openweathermap.org/data/2.5/weather?q=';
        this.url2 = '&units=metric&lang=es&APPID=f2329889d7242c5d47fc7dce9eb42759&mode=xml';
        this.icon1 = 'http://openweathermap.org/img/wn/';
        this.icon2 = '@2x.png';
        this.par = {
            dataType: 'xml',
            url: "",
            method: 'GET',
            success: function(data){
                this.setData(data);
            }.bind(this),
            error: function() {
                console.log("Error personalizado");
            }
        };
        $('#table').hide();
    }

    getWeather(ciudad){
        this.par.url = this.url1 + ciudad + this.url2;
        $.ajax(this.par);
        $('#table').show();
    }

    setData(data){
        console.log(data);
        // xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
        $('#ciudad').text(data.getElementsByTagName('city')[0].getAttribute('name'));
        $('#imgClima').attr('src', this.icon1 + data.getElementsByTagName('weather')[0].getAttribute('icon') + this.icon2);
        $('#clima').text(data.getElementsByTagName('weather')[0].getAttribute('value'));
        $('#temp').text(data.getElementsByTagName('temperature')[0].getAttribute('value') + "ºC");
        $('#max').text(data.getElementsByTagName('temperature')[0].getAttribute('max') + "ºC");
        $('#min').text(data.getElementsByTagName('temperature')[0].getAttribute('min') + "ºC");
        $('#presion').text(data.getElementsByTagName('pressure')[0].getAttribute('value') + " " + data.getElementsByTagName('pressure')[0].getAttribute('unit'));
        $('#humedad').text(data.getElementsByTagName('humidity')[0].getAttribute('value') + " " + data.getElementsByTagName('humidity')[0].getAttribute('unit'));
        $('#viento').text(data.getElementsByTagName('speed')[0].getAttribute('value') + "m/s, " + data.getElementsByTagName('direction')[0].getAttribute('value') + "º");
    }
}

var climate = new Climate();