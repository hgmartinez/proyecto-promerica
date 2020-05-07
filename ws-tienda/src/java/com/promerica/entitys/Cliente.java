
package com.promerica.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author henrymartinez
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_CLIENTE")
    private Integer id;
    @Size(max=60)
    @NotNull
    @Column(name="NOMBRES")
    private String nombres;
    @Size(max=70)
    @Column(name="APELLIDOS")
    private String apellidos;
    @XmlTransient
    @OneToMany(mappedBy = "client")
    private List<Orden> ordenList;
    
    
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

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }
    
    
}
