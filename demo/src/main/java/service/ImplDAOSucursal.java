package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Sucursal;

import java.util.List;

public class ImplDAOSucursal implements IDAOSucursal {

    @Override
    public List<Sucursal> getAll(String nameQuery) { //get all  para traer todos loe registros.
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            TypedQuery<Sucursal> query = em.createNamedQuery(nameQuery, Sucursal.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public void insert(Sucursal entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public Sucursal getById(Integer id) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try{
            Sucursal entity = em.find(Sucursal.class, id);
            return entity;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {em.close();}
        return null;
    }

    @Override
    public void remove(Sucursal entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try{
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {em.close();}

    }

    @Override
    public Sucursal update(Sucursal entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try{
            em.getTransaction().begin();
            Sucursal e = em.merge(entity);
            em.flush();
            em.getTransaction().commit();
            return e;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {em.close();}
        return null;
    }
}
