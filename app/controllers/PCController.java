package controllers;


//importar librerias
import play.mvc.*;
import java.sql.Timestamp;
import models.PC;
import play.libs.Json;
import play.data.FormFactory;
import javax.inject.*;
import play.data.Form;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
//declarar clase que hereda de controller
public class PCController extends Controller {

	@Inject
	FormFactory formFactory;

	//se define el metodo que declara una accion dentro del controller
    public Result index() {
        return ok(views.html.index.render()); //retorna un result al cual le pasa una vista al index
    }

	//se declara un metodo
	public Result guardarPC(){
		Form<PC> pcForm = formFactory.form(PC.class);
		//se crea formulario

		if (pcForm.hasErrors()){
			return badRequest(views.html.computadoras.create.render(pcForm));
		}else{
			PC pc = pcForm.bindFromRequest().get();
			pc.fechaFabricacion = new Timestamp(System.currentTimeMillis());
			//manda a llamar el metodo PC y le pasa lo almacenado en la instancia pc
			pc.guardarPC(pc);

			//retorna la respuesta
			return ok(views.html.computadoras.list.render());
		}
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

	public Result guardarvista(){
		Form<PC> pcForm = formFactory.form(PC.class);
		return ok(views.html.computadoras.create.render(pcForm));

	}

	public Result eliminar(Long id){
		PC pc = PC.find.byId(id);
		if (pc != null){

			pc.delete();
			return ok(views.html.computadoras.list.render());
		}
		return badRequest(views.html.computadoras.list.render());

	}

	public Result editar(Long id){
		PC pc = PC.find.byId(id);
		Form<PC> pcForm = formFactory.form(PC.class).fill(pc);
		if (pc != null){
			return ok(views.html.computadoras.editar.render(pcForm));
		}else{
		return badRequest(views.html.computadoras.list.render());
		}
	}

	public Result actualizar(Long id){
		PC pc = PC.find.byId(id);
		Form<PC> pcForm = formFactory.form(PC.class);
		if (pc != null){
			PC pcUpdate = pcForm.bindFromRequest().get();
			pcUpdate.id = pc.id;
			pcUpdate.update();
			pcUpdate.refresh();
			return ok(views.html.computadoras.list.render());
		}else{
		return badRequest(views.html.computadoras.editar.render(pcForm));
		}
	}

}
