/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiti;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author claudio
 */
@Entity
@Table(name = "ingreso_clientes")
@NamedQueries({
    @NamedQuery(name = "IngresoCliente.findAll", query = "SELECT i FROM IngresoCliente i"),
    @NamedQuery(name = "IngresoCliente.findByRut", query = "SELECT i FROM IngresoCliente i WHERE i.rut = :rut"),
    @NamedQuery(name = "IngresoCliente.findByNombre", query = "SELECT i FROM IngresoCliente i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IngresoCliente.findByApellido", query = "SELECT i FROM IngresoCliente i WHERE i.apellido = :apellido"),
    @NamedQuery(name = "IngresoCliente.findByCorreo", query = "SELECT i FROM IngresoCliente i WHERE i.correo = :correo"),
    @NamedQuery(name = "IngresoCliente.findByComuna", query = "SELECT i FROM IngresoCliente i WHERE i.comuna = :comuna")})
public class IngresoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private Integer rut;
    @Size(max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 2147483647)
    @Column(name = "Correo")
    private String correo;
    @Size(max = 2147483647)
    @Column(name = "Comuna")
    private String comuna;

    public IngresoCliente() {
    }

    public IngresoCliente(Integer rut) {
        this.rut = rut;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoCliente)) {
            return false;
        }
        IngresoCliente other = (IngresoCliente) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiti.IngresoCliente[ rut=" + rut + " ]";
    }
    
}
