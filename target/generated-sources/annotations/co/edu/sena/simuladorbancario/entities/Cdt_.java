package co.edu.sena.simuladorbancario.entities;

import co.edu.sena.simuladorbancario.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T09:26:22")
@StaticMetamodel(Cdt.class)
public class Cdt_ { 

    public static volatile SingularAttribute<Cdt, Integer> id;
    public static volatile SingularAttribute<Cdt, Double> saldo;
    public static volatile SingularAttribute<Cdt, Usuarios> idUsuarios;
    public static volatile SingularAttribute<Cdt, Double> interesMensual;
    public static volatile SingularAttribute<Cdt, Boolean> activo;

}