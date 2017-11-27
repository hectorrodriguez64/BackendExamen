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
@Table(name = "cuenta_corriente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaCorriente.findAll", query = "SELECT c FROM CuentaCorriente c")
    , @NamedQuery(name = "CuentaCorriente.findById", query = "SELECT c FROM CuentaCorriente c WHERE c.id = :id")
    , @NamedQuery(name = "CuentaCorriente.findByRetirar", query = "SELECT c FROM CuentaCorriente c WHERE c.retirar = :retirar")
    , @NamedQuery(name = "CuentaCorriente.findByConsignar", query = "SELECT c FROM CuentaCorriente c WHERE c.consignar = :consignar")
    , @NamedQuery(name = "CuentaCorriente.findBySaldo", query = "SELECT c FROM CuentaCorriente c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "CuentaCorriente.findByMes", query = "SELECT c FROM CuentaCorriente c WHERE c.mes = :mes")})
public class CuentaCorriente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "retirar")
    private String retirar;
    @Size(max = 45)
    @Column(name = "consignar")
    private String consignar;
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

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer id) {
        this.id = id;
    }

    public CuentaCorriente(Integer id, double saldo, Date mes) {
        this.id = id;
        this.saldo = saldo;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRetirar() {
        return retirar;
    }

    public void setRetirar(String retirar) {
        this.retirar = retirar;
    }

    public String getConsignar() {
        return consignar;
    }

    public void setConsignar(String consignar) {
        this.consignar = consignar;
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
        if (!(object instanceof CuentaCorriente)) {
            return false;
        }
        CuentaCorriente other = (CuentaCorriente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.simuladorbancario.entities.CuentaCorriente[ id=" + id + " ]";
    }
    
}
