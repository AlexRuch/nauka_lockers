package interaction;

import model.Locker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey on 18/05/16.
 */
@ManagedBean
@RequestScoped
public class InteractionLocker {

    public InteractionLocker(){}
    private Locker locker;

    private List<Locker> lockersList;
    EntityManager entityManager = Persistence.createEntityManagerFactory("NAUKA").createEntityManager();

    public List<Locker> allLockers(){
        lockersList = new ArrayList<>();
        lockersList = entityManager.createQuery("select l from locker l", Locker.class).getResultList();

        return lockersList;
    }

    public String deleteLocker(int id){
        locker = new Locker();
        locker = entityManager.find(Locker.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(locker);
        entityManager.getTransaction().commit();

        return "adminpanel";
    }
    public void addLocker(String lockerName){
        locker = new Locker();
        entityManager.getTransaction().begin();
        locker.setLockerName(lockerName);;
        entityManager.persist(locker);
        entityManager.getTransaction().commit();

    }

    public String serverInc(Locker locker){
        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        this.locker.setServer(this.locker.getServer()+1);
        entityManager.merge(this.locker);
        entityManager.getTransaction().commit();
        return "adminpanel";
    }
    public String serverDec(Locker locker){
        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        if (this.locker.getServer() > 0){
            this.locker.setServer(locker.getServer()-1);
            entityManager.merge(this.locker);
        }
        entityManager.getTransaction().commit();
        return "adminpanel";
    }

    public String raidInc(Locker locker){

        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        this.locker.setRaid(this.locker.getRaid()+1);
        entityManager.merge(this.locker);
        entityManager.getTransaction().commit();
        return "adminpanel";
    }

    public String raidDec(Locker locker){

        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        if (this.locker.getRaid() > 0){
            this.locker.setRaid(locker.getRaid()-1);
            entityManager.merge(this.locker);
        }
        entityManager.getTransaction().commit();
        return "adminpanel";
    }

    public String upsInc(Locker locker){
        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        this.locker.setUps(this.locker.getUps()+1);
        entityManager.merge(this.locker);
        entityManager.getTransaction().commit();
        return "adminpanel";
    }

    public String  upsDec(Locker locker){

        entityManager.getTransaction().begin();
        this.locker = entityManager.find(Locker.class, locker.getId());
        if (this.locker.getUps() > 0){
            this.locker.setUps(locker.getUps()-1);
            entityManager.merge(this.locker);
        }
        entityManager.getTransaction().commit();
        return "adminpanel";
    }
}
