/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import entiti.IngresoCliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author claudio
 */
public class IngresoClienteDAO implements Serializable {

    public IngresoClienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public IngresoClienteDAO (){
    
    }
    
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IngresoCliente ingresoCliente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ingresoCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIngresoCliente(ingresoCliente.getRut()) != null) {
                throw new PreexistingEntityException("IngresoCliente " + ingresoCliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IngresoCliente ingresoCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ingresoCliente = em.merge(ingresoCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ingresoCliente.getRut();
                if (findIngresoCliente(id) == null) {
                    throw new NonexistentEntityException("The ingresoCliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IngresoCliente ingresoCliente;
            try {
                ingresoCliente = em.getReference(IngresoCliente.class, id);
                ingresoCliente.getRut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ingresoCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(ingresoCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IngresoCliente> findIngresoClienteEntities() {
        return findIngresoClienteEntities(true, -1, -1);
    }

    public List<IngresoCliente> findIngresoClienteEntities(int maxResults, int firstResult) {
        return findIngresoClienteEntities(false, maxResults, firstResult);
    }

    private List<IngresoCliente> findIngresoClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IngresoCliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public IngresoCliente findIngresoCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IngresoCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getIngresoClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IngresoCliente> rt = cq.from(IngresoCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
