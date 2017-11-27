/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "cdt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdt.findAll", query = "SELECT c FROM Cdt c")
    , @NamedQuery(name = "Cdt.findById", query = "SELECT c FROM Cdt c WHERE c.id = :id")
    , @NamedQuery(name = "Cdt.findBySaldo", query = "SELECT c FROM Cdt c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "Cdt.findByInteresMensual", query = "SELECT c FROM Cdt c WHERE c.interesMensual = :interesMensual")
    , @NamedQuery(name = "Cdt.findByActivo", query = "SELECT c FROM Cdt c WHERE c.activo = :activo")})
public class Cdt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes_mensual")
    private double interesMensual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;

    public Cdt() {
    }

    public Cdt(Integer id) {
        this.id = id;
    }

    public Cdt(Integer id, double saldo, double interesMensual, boolean activo) {
        this.id = id;
        this.saldo = saldo;
        this.interesMensual = interesMensual;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        if (!(object instanceof Cdt)) {
            return false;
        }
        Cdt other = (Cdt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.simuladorbancario.entities.Cdt[ id=" + id + " ]";
    }
    
}
