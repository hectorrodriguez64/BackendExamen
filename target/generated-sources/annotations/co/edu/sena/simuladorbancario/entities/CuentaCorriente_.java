package co.edu.sena.simuladorbancario.entities;

import co.edu.sena.simuladorbancario.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T09:26:22")
@StaticMetamodel(CuentaCorriente.class)
public class CuentaCorriente_ { 

    public static volatile SingularAttribute<CuentaCorriente, String> retirar;
    public static volatile SingularAttribute<CuentaCorriente, Date> mes;
    public static volatile SingularAttribute<CuentaCorriente, Integer> id;
    public static volatile SingularAttribute<CuentaCorriente, Double> saldo;
    public static volatile SingularAttribute<CuentaCorriente, String> consignar;
    public static volatile SingularAttribute<CuentaCorriente, Usuarios> idUsuarios;

}