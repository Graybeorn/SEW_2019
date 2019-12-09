class CalculadoraRPN{
    constructor(){
        this.data=[0,0,0,0];
        this.memory = "0";
        this.stack = 3;
        this.last="";
        this.dot = true;
    }

    parse(data){
        return eval(data);
    }

    print(){
        document.getElementById("screen1").textContent = this.data[this.stack];
        document.getElementById("screen2").textContent = this.data[this.stack-1];
        document.getElementById("screen3").textContent = this.data[this.stack-2];
    }

    plusM(){
        this.memory = this.parse(this.memory) + this.parse(this.data[this.stack]);
    }

    minusM(){
        this.memory = this.parse(this.memory) + this.parse(this.data[this.stack]);
    }

    mr(){
        this.data[this.stack] = this.memory;
        this.last = "op";
        this.dot = true;
        this.print();
    }
    mc(){
        this.memory = 0;
    }

    pow2(){
        this.data[this.stack] = Math.pow(this.data[this.stack], 2);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    powY(){
        let aux = Math.pow(this.data[this.stack], this.data[this.stack-1]);
        this.pop();
        this.data[this.stack] = aux;
        this.last = "op";
        this.dot = true;
        this.print();
    }

    pow10(){
        this.data[this.stack] = Math.pow(10, this.data[this.stack]);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    sqrt(){
        this.data[this.stack] = Math.sqrt(this.data[this.stack]);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    sin(){
        this.data[this.stack] = Math.sin(this.data[this.stack]);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    cos(){
        this.data[this.stack] = Math.cos(this.data[this.stack]);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    tan(){
        this.data[this.stack] = Math.tan(this.data[this.stack]);
        this.last = "op";
        this.dot = true;
        this.print();
    }

    inv(){
        this.data[this.stack] = 1/this.data[this.stack];
        this.last = "op";
        this.dot = true;
        this.print();
    }

    num(n){
        if(this.last == "op"){
            this.data.push(n);
            this.data.shift();
        } else {
            if(this.data[this.stack] == "0") this.data[this.stack] = "";
            this.data[this.stack] += ""+ n;
        }
        this.last = "num";
        this.print();
    }
    op(o){
        let aux = this.parse("" + this.data[this.stack-1] + o + this.data[this.stack]);
        this.pop();
        this.data[this.stack] = aux;
        this.last = "op";
        this.dot = true;
        this.print();
    }

    punto(){
        if(!this.dot){
            return;
        }
        if(this.last == "op"){
            this.data.push("0.");
            this.data.shift();
        } else {
            this.data[this.stack] += ".";
        }
        this.last = "num";
        this.dot = false;
        this.print();
    }

    c(){
        this.data[this.stack] = "";
        this.dot = true;
        this.print();
    }

    ac(){
        this.data = [0,0,0,0];
        this.dot = true;
        this.print();
    }

    pop(){
        this.data.pop();
        this.data.unshift(0);
        this.print();
    }
    enter(){
        this.data.push(0);
        this.data.shift();
        this.print();
    }

}


var calculadora = new CalculadoraRPN();