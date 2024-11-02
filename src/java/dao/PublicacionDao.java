package dao;

import entity.Publicacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PublicacionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void crearPublicacion(Publicacion publicacion) {
        entityManager.persist(publicacion);
    }

    public void editarPublicacion(Publicacion publicacion) {
        entityManager.merge(publicacion);
    }

    public void eliminarPublicacion(Long id) {
        Publicacion publicacion = entityManager.find(Publicacion.class, id);
        entityManager.remove(publicacion);
    }

    public List<Publicacion> listarPublicaciones() {
        return entityManager.createQuery("SELECT p FROM Publicacion p").getResultList();
    }
}
