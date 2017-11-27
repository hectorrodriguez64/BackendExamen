/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarios.findByNumDocumento", query = "SELECT u FROM Usuarios u WHERE u.numDocumento = :numDocumento")
    , @NamedQuery(name = "Usuarios.findBySaldoTotal", query = "SELECT u FROM Usuarios u WHERE u.saldoTotal = :saldoTotal")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numDocumento")
    private int numDocumento;
    @Basic(optional = true)
    @NotNull
    @Column(name = "saldoTotal")
    private double saldoTotal;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Cdt> cdtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<CuentaCorriente> cuentaCorrienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<CuentaAhorros> cuentaAhorrosList;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombres, String apellidos, int numDocumento, double saldoTotal) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numDocumento = numDocumento;
        this.saldoTotal = saldoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Cdt> getCdtList() {
        return cdtList;
    }

    public void setCdtList(List<Cdt> cdtList) {
        this.cdtList = cdtList;
    }

    @XmlTransient
    public List<CuentaCorriente> getCuentaCorrienteList() {
        return cuentaCorrienteList;
    }

    public void setCuentaCorrienteList(List<CuentaCorriente> cuentaCorrienteList) {
        this.cuentaCorrienteList = cuentaCorrienteList;
    }

    @XmlTransient
    public List<CuentaAhorros> getCuentaAhorrosList() {
        return cuentaAhorrosList;
    }

    public void setCuentaAhorrosList(List<CuentaAhorros> cuentaAhorrosList) {
        this.cuentaAhorrosList = cuentaAhorrosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.simuladorbancario.entities.Usuarios[ id=" + id + " ]";
    }
    
}
