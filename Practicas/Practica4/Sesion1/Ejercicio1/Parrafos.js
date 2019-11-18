function parrafos(){
    var cabecera = new Cabecera();
    document.write("<p>"+ cabecera.getCurso() +"</p>");
    document.write("<p>"+ cabecera.getEstudiante() +"</p>");
    document.write("<p>"+ cabecera.getEmail() +"</p>");
}

parrafos();