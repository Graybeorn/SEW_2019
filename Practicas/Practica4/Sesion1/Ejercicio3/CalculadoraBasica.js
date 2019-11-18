class Calculadora{
    constructor(){
        this.input = "";
        this.memory = "";
        this.last="";
        this.dot = true;
        this.result = "";
    }

    parser(){
        return eval(this.input);
    }

    number( num ){
        this.input += num;
        this.last = "num";
        document.getElementById("screen").innerText = document.getElementById("screen").innerText + num;
    }

    add(){
        if(this.last = "op" ){
            return
        }
        this.last = "op";
        this.dot = false;
        this.input+="+";
    }

    sub(){
        if(this.last = "op" ){
            return
        }
        this.last = "op";
        this.dot = false;
        this.input+="-";
    }

    div(){
        if(this.last = "op" ){
            return
        }
        this.last = "op";
        this.dot = false;
        this.input+="/";
    }

    mul(){
        if(this.last = "op" ){
            return
        }
        this.last = "op";
        this.dot = false;
        this.input+="-";
    }

    c(){
        this.input="";
        this.dot=false;
        this.last= "";
    }

    dot(){
        if(this.dot){
            return
        }
        this.dot=true;
    }

    eq(){
        this.result = parser();
        this.last = "num";
        this.input = "" + this.result;
        this.dot = false;
    }

    mrc(){

    }

    plusM(){

    }

    minusM(){

    }
}

var calculadora = new Calculadora();