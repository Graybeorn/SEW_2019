class Controller{
    constructor(){
        this.counter = 0;
        this.mods = 0;
        this.visible = true;
    }

    ocultarYMostrar(){
        this.visible ?  $('#tarea1').hide() : $('#tarea1').show();
        this.visible = !this.visible;
    }

    modificar(){
        this.mods++;
        $('h3').text("Hasta ahora este texto se ha modificado " + this.mods + " veces.");
    }

    añadir(){
        this.counter++;
        $('ul').append('<li>Has añadido el elemento ' + this.counter + ' a la lista</li>');
    }

    borrar(){
        if(this.counter <= 0) return;
        $('ul > li').remove(":contains('" + this.counter+ "')");
        this.counter--;
    }

    recorrer(){
        let aux = "";
        $("*").each(function (){
            aux += "Element type: " + $(this).prop('nodeName');
            aux += ", Parent: " + $(this).parent().prop('nodeName');
            aux += '<br>'; 
        });
        $('#salida').html(aux);
    }

    sumar(){
        let r = 0;
        let c = 0;
        $('tr').each(function() {
            r++;
        });

        $('tr:nth-child(1) td').each(function () {
            if ($(this).attr('colspan')) {
                c += $(this).attr('colspan');
            } else { 
                c++;
        }});

        $('#salida').text("La tabla tiene " + r + " filas y " + c + " columnas");
    }   
}

let controller = new Controller();