/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
//import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.VideojuegosDao;
import modelo.entidad.Videojuegos;

/**
 *
 * @author valle
 */
//@Named(value = "videojuegosControl")
@Dependent
@ManagedBean
@ViewScoped
public class VideojuegosControl {

    /**
     * Creates a new instance of VideojuegosControl
     */
    private List<Videojuegos> listaVideojuegos;
    private Videojuegos videojuegos;

    public VideojuegosControl() {
        videojuegos = new Videojuegos();
    }

    public List<Videojuegos> getListaVideojuegos() {
        VideojuegosDao ad = new VideojuegosDao();
        listaVideojuegos = ad.listarVideojuegos();
        return listaVideojuegos;
    }

    public void setListaVideojuegos(List<Videojuegos> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }

    public Videojuegos getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Videojuegos videojuegos) {
        this.videojuegos = videojuegos;
    }

    public void limpiarVideojuegos() {
        videojuegos = new Videojuegos();
    }

    public void agregarVideojuegos() {
        VideojuegosDao ad = new VideojuegosDao();
        ad.agregar(videojuegos);
    }

    public void modificarVideojuegos() {
        VideojuegosDao ad = new VideojuegosDao();
        ad.modificar(videojuegos);
        limpiarVideojuegos();
    }

    public void eliminarVideojuegos() {
        VideojuegosDao ad = new VideojuegosDao();
        ad.eliminar(videojuegos);
        limpiarVideojuegos();
    }
    
}
