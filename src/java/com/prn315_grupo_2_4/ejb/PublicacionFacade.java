@Stateless
public class PublicacionFacade extends AbstractFacade<Publicacion> implements PublicacionFacadeLocal {

    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionFacade() {
        super(Publicacion.class);
    }

    public Publicacion create(Publicacion publicacion) {
        em.persist(publicacion);
        return publicacion;
    }

    public Publicacion edit(Publicacion publicacion) {
        em.merge(publicacion);
        return publicacion;
    }

    public void remove(Publicacion publicacion) {
        em.remove(em.merge(publicacion));
    }

    public Publicacion find(Object id) {
        return em.find(Publicacion.class, id);
    }

    public List<Publicacion> findAll() {
        return em.createQuery("SELECT p FROM Publicacion p").getResultList();
    }
}