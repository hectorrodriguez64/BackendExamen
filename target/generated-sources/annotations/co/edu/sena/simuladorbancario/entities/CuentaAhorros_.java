package co.edu.sena.simuladorbancario.entities;

import co.edu.sena.simuladorbancario.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T10:33:09")
@StaticMetamodel(CuentaAhorros.class)
public class CuentaAhorros_ { 

    public static volatile SingularAttribute<CuentaAhorros, Double> retirar;
    public static volatile SingularAttribute<CuentaAhorros, Date> mes;
    public static volatile SingularAttribute<CuentaAhorros, Integer> id;
    public static volatile SingularAttribute<CuentaAhorros, Double> saldo;
    public static volatile SingularAttribute<CuentaAhorros, Double> consignar;
    public static volatile SingularAttribute<CuentaAhorros, Usuarios> idUsuarios;
    public static volatile SingularAttribute<CuentaAhorros, Double> interesMensual;

}