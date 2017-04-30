package controllers;


//importar librerias
import play.mvc.*;
import java.sql.Timestamp;
import models.PC;
import play.libs.Json;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
//declarar clase que hereda de controller
public class PCController extends Controller {

	//se define el metodo que declara una accion dentro del controller
    public Result index() {
        return ok(views.html.index.render()); //retorna un result al cual le pasa una vista al index
    }

//se declara un metodo
public Result guardarPC(){

	//se crea una instacia (objeto) de la clase pc
	PC pc = new PC();

	//setea los atributos a la instancia creada
	pc.marca = "Dell";
	pc.modelo = "Alienware";
	pc.procesador = "Intel";
	pc.memoria = 8;
	pc.fechaFabricacion = new Timestamp(System.currentTimeMillis());

	//manda a llamar el metodo PC y le pasa lo almacenado en la instancia pc
	pc.guardarPC(pc);

	//retorna la respuesta
	return ok();


}

//crea una accion del metodo controller
public Result listapc(){

	//devuelve un result con un json que devuelve el model
	return ok(Json.toJson(PC.allpc()));

}

//crea la accion listar
public Result listar(){
	//devuelve una lista de los objetos
	return ok(views.html.computadoras.list.render());


}

}
