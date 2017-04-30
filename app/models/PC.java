package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import java.sql.Timestamp;
import play.data.validation.*;

@Entity
public class PC extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String marca;

    public String modelo;

    public String procesador;

    public int memoria;

    public Timestamp fechaFabricacion;

    public static Finder<Long, PC> find = new Finder<Long,PC>(PC.class);

    public int getMemoriaMegas(){

        int totalMegas = this.memoria*1024;

        return totalMegas;

    }

    public PC guardarPC(PC pc){

        pc.save();

        return pc;




    }

    public static List<PC> allpc(){
        
        return PC.find.all();

    }

}