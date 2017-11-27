package co.edu.sena.simuladorbancario.entities;

import co.edu.sena.simuladorbancario.entities.Cdt;
import co.edu.sena.simuladorbancario.entities.CuentaAhorros;
import co.edu.sena.simuladorbancario.entities.CuentaCorriente;
import co.edu.sena.simuladorbancario.entities.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T10:21:27")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile SingularAttribute<Usuarios, Integer> numDocumento;
    public static volatile ListAttribute<Usuarios, Roles> rolesList;
    public static volatile ListAttribute<Usuarios, Cdt> cdtList;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile ListAttribute<Usuarios, CuentaAhorros> cuentaAhorrosList;
    public static volatile SingularAttribute<Usuarios, Double> saldoTotal;
    public static volatile ListAttribute<Usuarios, CuentaCorriente> cuentaCorrienteList;
    public static volatile SingularAttribute<Usuarios, String> nombres;

}