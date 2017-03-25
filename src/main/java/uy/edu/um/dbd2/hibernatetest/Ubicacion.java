package uy.edu.um.dbd2.hibernatetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 */
@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "nro_ubicacion")
  private Long numero;

  @Column(name = "desc_ubicacion")
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "nro_local")
  private Local local;

  public Ubicacion() {

  }

  public Ubicacion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Local getLocal() {
    return local;
  }

  public void setLocal(Local local) {
    this.local = local;
  }
}
