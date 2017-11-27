/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "cuenta_ahorros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaAhorros.findAll", query = "SELECT c FROM CuentaAhorros c")
    , @NamedQuery(name = "CuentaAhorros.findById", query = "SELECT c FROM CuentaAhorros c WHERE c.id = :id")
    , @NamedQuery(name = "CuentaAhorros.findByConsignar", query = "SELECT c FROM CuentaAhorros c WHERE c.consignar = :consignar")
    , @NamedQuery(name = "CuentaAhorros.findByRetirar", query = "SELECT c FROM CuentaAhorros c WHERE c.retirar = :retirar")
    , @NamedQuery(name = "CuentaAhorros.findByInteresMensual", query = "SELECT c FROM CuentaAhorros c WHERE c.interesMensual = :interesMensual")
    , @NamedQuery(name = "CuentaAhorros.findBySaldo", query = "SELECT c FROM CuentaAhorros c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "CuentaAhorros.findByMes", query = "SELECT c FROM CuentaAhorros c WHERE c.mes = :mes")})
public class CuentaAhorros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "consignar")
    private double consignar;
    @Basic(optional = false)
    @Column(name = "retirar")
    private double retirar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes_mensual")
    private double interesMensual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    @Temporal(TemporalType.DATE)
    private Date mes;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;

    public CuentaAhorros() {
    }

    public CuentaAhorros(Integer id) {
        this.id = id;
    }

    public CuentaAhorros(Integer id, double interesMensual, double saldo, Date mes) {
        this.id = id;
        this.interesMensual = interesMensual;
        this.saldo = saldo;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getConsignar() {
        return consignar;
    }

    public void setConsignar(double consignar) {
        this.consignar = consignar;
    }

    public double getRetirar() {
        return retirar;
    }

    public void setRetirar(double retirar) {
        this.retirar = retirar;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
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
        if (!(object instanceof CuentaAhorros)) {
            return false;
        }
        CuentaAhorros other = (CuentaAhorros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.simuladorbancario.entities.CuentaAhorros[ id=" + id + " ]";
    }
    
}
