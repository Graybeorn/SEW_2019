class CalculadoraBasica{
    constructor(){
        this.input = "";
        this.currentNum="";
        this.memory = [];
        this.memory[0] = 0;
        this.last="";
        this.dot = true;
        this.result = "";
    }

    parser(){
        return eval(this.input);
    }

    print(){
        document.getElementById("screen").textContent = this.input + "\t" + this.currentNum;
    }

    number( num ){
        if(this.last == "eq" || this.last == "mrc"){
            if(this.dot){
                   document.getElementById("screen").textContent = "";
                   this.currentNum = "";
            }
        }
        this.currentNum += "" + num;
        this.last = "num";
        console.log(num);
        this.print();
    }

    add(){
        if(this.last === "op" || this.last === "sub"){
            return
        }
        this.last = "op";
        this.dot = true;
        this.input+=this.currentNum;
        this.currentNum = "";
        this.input+="+";
        this.print();
    }

    sub(){
        if(this.last === "sub" ){
            return
        }
        this.last = "sub";
        this.dot = true;
        this.input+=this.currentNum;
        this.currentNum = "";
        this.input+="-";
        this.print();
    }

    div(){
        if(this.last === "op" || this.last === "sub" ){
            return
        }
        this.last = "op";
        this.input+=this.currentNum;
        this.currentNum = "";
        this.dot = true;
        this.input+="/";
        
        this.print();
    }

    mul(){
        if(this.last === "op" || this.last === "sub"  ){
            return
        }
        this.last = "op";
        this.input+=this.currentNum;
        this.currentNum = "";
        this.dot = true;
        this.input+="*";
        this.print();
    }

    c(){
        this.input="";
        this.dot=true;
        this.last= "";
        this.currentNum = "";
        this.print();
    }

    punto() {
        if(!this.dot){
            return;
        }
        
        if(this.last == "eq" || this.last == "mrc"){
            this.currentNum = "0";
        }
        this.dot=false;
        this.currentNum += '.';
        this.print();
    }

    eq(){
        this.input += this.currentNum;
        this.currentNum = "";
        let c = this.input.substring(this.input.length-1);
        switch(c){
            case "-":
            case '+':
            case '*':
            case '/':
                this.input = this.input.substring(0, this.input.length-1);
                this.eq();
                return;
        }
        
        this.currentNum = this.parser();
        this.last = "eq";
        this.input = "";
        this.dot = true;
        this.print();
    }

    mrc(){
        this.currentNum = "" +  this.memory.pop();
        this.print();
        this.last =="mrc";
    }

    plusM(){
        this.memory[this.memory.length-1] = +(eval(this.memory[this.memory.length-1])) + (eval(this.currentNum));
    }

    minusM(){
        this.memory[this.memory.length-1] = +(eval(this.memory[this.memory.length-1])) - (eval(this.currentNum));
    }
}
