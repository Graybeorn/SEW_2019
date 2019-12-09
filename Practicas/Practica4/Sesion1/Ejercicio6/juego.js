class Juego {
    constructor(){
        this.puntosUser=0;
        this.puntosJugados=0;
        this.selected = -1;
    }

    pintarVictoria(){ // width = 300 height = 40
        var c = document.getElementById("puntuacion");
        var ctx  = c.getContext("2d");
        ctx.fillStyle= "blue";
        ctx.fillRect((this.puntosJugados-1)*300,0,299,100);
    }
    
    pintarDerrota(){
        var c = document.getElementById("puntuacion");
        var ctx  = c.getContext("2d");
        ctx.fillStyle="red";
        ctx.fillRect((this.puntosJugados-1)*300,0,299,100);
    }
    
    pintarBlanco(){
        var c = document.getElementById("puntuacion");
        let ctx  = c.getContext("2d");
        ctx.fillStyle="white";
        ctx.fillRect(0,0,900,100);
    }

    jugar(){
        if(this.selected == -1){
            alert("Debes seleccionar una opción!");
            return;
        }
        if(this.puntosJugados>=3){
            alert("Se va a empezar una nueva partida");
            this.reiniciar();
            return;
        }
        let i = Math.floor(Math.random()*3);
        this.deselectM();
        switch(i){
            case 0:
                document.getElementById("mPiedra").className = "selectedM";
                break;
            case 1:
                document.getElementById("mPapel").className = "selectedM";
                break;
            case 2:
                document.getElementById("mTijera").className = "selectedM";
                break;
            default:
                break;
        }
        if(this.selected == i){      // empate
            console.log("empate");
        } else {
            this.puntosJugados++;
            if(this.selected == 0){ // piedra contra
                if (i == 1){            //papel
                    this.pintarDerrota();
                } else {                //tijera
                    this.puntosUser++;
                    this.pintarVictoria();
                }
            }
            if(this.selected == 1){ // papel contra
                if(i == 0){             //piedra
                    this.puntosUser++
                    this.pintarVictoria();
                } else {                // tijeras
                    this.pintarDerrota();
                }
            }
            else {                  // tijeras contra
                if(i==0){               //piedra 
                    this.pintarDerrota();
                } else{                 //papel
                    this.puntosUser++;
                    this.pintarVictoria();
                }
            }
        }
        if(this.puntosJugados>=3){
            if(this.puntosUser>=2){
                alert("¡Felicidades! Has ganado");
            } else{
                alert("Has perdido, qué lástima...");
            }
        }
    }

    reiniciar(){
        this.deselect();
        this.deselectM();
        this.puntosJugados = 0;
        this.puntosUser = 0;
        this.pintarBlanco();
    }

    deselect(){     
        this.selected = -1;
        let els = document.getElementsByClassName("selectedUser");
        for(let i=0;i<els.length;i++){
            els.item(i).className = "user";
        }
    }

    deselectM(){     
        let els = document.getElementsByClassName("selectedM");
        for(let i=0;i<els.length;i++){
            els.item(i).className = "";
        }
    }


    seleccionPiedra(){
        this.deselect();
        document.getElementById("piedra").className = "selectedUser";
        this.selected=0;
    }
    seleccionPapel(){
        this.deselect();
        document.getElementById("papel").className = "selectedUser";
        this.selected=1
    }
    seleccionTijera(){
        this.deselect();
        document.getElementById("tijera").className = "selectedUser";
        this.selected=2
    }
}


var juego=new Juego();