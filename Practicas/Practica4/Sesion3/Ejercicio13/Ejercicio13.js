class Lector{
    constructor(){
        this.checkSupport();
    }

    checkSupport(){
        if (window.File && window.FileReader && window.FileList && window.Blob) {
        } else {
            $('#error').text('The File APIs are not fully supported in this browser.');
            $('button').disabled = true;
            $('input').disabled = true;
        }
    }

    loadFile(file){
        $('#nombre').text(file.name)
        if(file.type.match('application.json') || file.type.match('text.plain') || file.type.match('text.xml')){
            var reader = new FileReader();
            reader.onload = this.loaded;
            reader.readAsText(file);
        }else{
            $('#contenido').html("Tipo: " + file.type + "<br>"
                    + "Tamaño: " + file.size + "<br>");
        }
    }

    loaded(e){
        $('#contenido').text(e.target.result);
    }
}

var lector = new Lector();