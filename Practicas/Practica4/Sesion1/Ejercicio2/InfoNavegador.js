class InformacionNavegador{
    constructor(){
        this.buscador = navigator.appName;
        this.idioma = navigator.language;
        this.otros =[navigator.appCodeName, 
                    navigator.appVersion,
                    navigator.cookieEnabled,
                    navigator.geolocation,
                    navigator.onLine,
                    navigator.platform,
                    navigator.product,
                    navigator.userAgent ];
    }
}

var info = new InformacionNavegador();