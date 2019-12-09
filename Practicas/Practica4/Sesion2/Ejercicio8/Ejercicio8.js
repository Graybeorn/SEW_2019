class Climate {
    constructor() {
        this.url1= 'http://api.openweathermap.org/data/2.5/weather?q=';
        this.url2 = '&units=metric&lang=es&APPID=f2329889d7242c5d47fc7dce9eb42759';
        this.icon1 = 'http://openweathermap.org/img/wn/';
        this.icon2 = '@2x.png';
        this.par = {
            dataType: 'json',
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
        $('#ciudad').text(data.name);
        $('#imgClima').attr('src', this.icon1 + data.weather[0].icon + this.icon2);
        $('#clima').text(data.weather[0].main);
        $('#temp').text(data.main.temp + "ºC");
        $('#max').text(data.main.temp_max + "ºC");
        $('#min').text(data.main.temp_min + "ºC");
        $('#presion').text(data.main.pressure);
        $('#humedad').text(data.main.humidity);
        $('#viento').text(data.wind.speed + "m/s, " + data.wind.deg + "º");
    }
}

var climate = new Climate();