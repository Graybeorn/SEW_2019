class CalculadoraCientifica extends CalculadoraBasica {

    constructor(){
        super();
        this.parLevel = 0;
    }

    mr(){
        this.currentNum = "" +  this.memory[this.memory.length-1];
        this.print();
        this.last = "mrc";
    }

    mc(){
        this.memory=[];
    }

    ms(){
        this.memory.push(this.currentNum);
    }
    number(n){
        if(this.last == "closedExp"){
            this.input = "";
            this.currentNum = "" + n;
            this.last = "num";
            this.print();
            return;
        }
        super.number(n);
    }


    pow2(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.pow(" + this.currentNum + ", 2)";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    powY(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.pow("+ this.currentNum + ", ";
        this.parLevel++;
        this.dot = true;
        this.last = "openExp";
        
        this.print();

    }
    sin(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.sin(" +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
        
    }
    cos(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.cos(" +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    tan(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.tan(" +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    sqrt(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.sqrt(" +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    exp10(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.pow( 10, " +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    log(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.log(" +  this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    exp(){
        if(this.currentNum.length == 0){
            return;
        }
        this.input += this.currentNum + "* Math.pow(10, ";
        this.dot =true;
        this.currentNum = "";
        this.last = "openExp";
        this.parLevel++;
        
        this.print();
    }
    mod(){
        if(this.last === "op" || this.last === "sub" || this.last == "openExp"){
            return
        }
        this.last = "op";
        this.input+=this.currentNum;
        this.currentNum = "";
        this.dot = true;
        this.input+="%";
        this.print();
    }
    up(){
        if(this.currentNum.length == 0){
            return;
        }
        this.currentNum = "Math.pow(" +  this.currentNum + ", " + this.currentNum + ")";
        this.dot = false;
        this.last = "closedExp";
        
        this.print();
    }
    c(){
        super.c();
        this.parLevel = 0;
        this.print();
    }
    ce(){
        this.currentNum = "";
        this.dot = true;
        this.print();
    }
    erease(){
        if(this.currentNum.length>0){
            this.currentNum = this.currentNum.substring(0, this.currentNum.length-1);
        }
        this.print();
    }
    pi(){
        this.currentNum = "Math.PI";
        this.dot = false;
        this.last = "closedExp";
        this.print();
    }
    n(){
        let num = 1;
        for(let i = 0; i<eval(this.currentNum);i++){
            num = num*(i+1);
        }
        this.currentNum = num;

        this.print();

    }
    plusminus(){
        this.currentNum = "" + (-1* eval(this.currentNum));
        this.print();
    }
    leftPar(){
        this.input += "(";
        this.dot = true;
        this.parLevel++;
        this.print();
    }
    rightPar(){
        if(this.parLevel<= 0){
            return;
        }
        this.input += this.currentNum + ")";
        this.dot = false;
        this.currentNum = "";
        this.parLevel--;
        this.print();
    }
}

let calculadora = new CalculadoraCientifica();