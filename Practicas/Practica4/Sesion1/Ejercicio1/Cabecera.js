class Cabecera {
    constructor(){
        this.nombreAsignatura = "Software y estándares para la Web";
        this.nombreTitulacion = "Ingeniería informática de Software";
        this.nombreCentro = "Campus de los Catalanes";
        this.nombreUniversidad = "Universidad de Oviedo";
        this.cursoActual = "3º";
        this.nombreEstudiante = "Juan Sánchez-Ocaña Sánchez";
        this.emailEstudiante = "UO252376@uniovi.es";
    }

    getAsignatura(){
        return this.nombreAsignatura;
    }
    getTitulacion(){
        return this.nombreTitulacion;
    }
    getCentro(){
        return this.nombreCentro;
    }
    getUniversidad(){
        return this.nombreUniversidad;
    }
    getCurso(){
        return this.cursoActual;
    }
    getEstudiante(){
        return this.nombreEstudiante;
    }
    getEmail(){
        return this.emailEstudiante;
    }


}