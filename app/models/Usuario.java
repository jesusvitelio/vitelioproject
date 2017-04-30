package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import java.sql.Timestamp;
import play.data.validation.*;

@Entity
public class Usuario extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String usuario;

    public String contraseña;

    public String area;

    public boolean estatus;

    public Timestamp ingreso;

    public static Finder<Long, Usuario> find = new Finder<Long,Usuario>(Usuario.class);

    public Usuario guardarUsuario(Usuario user){
    	user.save();
    	return user;
    }

    public static List<Usuario> listarUsuarios(){
    	return Usuario.find.all();
    }
}