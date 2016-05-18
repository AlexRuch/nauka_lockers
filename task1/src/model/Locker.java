package model;

import javax.persistence.*;

/**
 * Created by alexey on 18/05/16.
 */
@Entity(name = "locker")
@Table(name = "locker")
public class Locker {

    public Locker(){

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String lockerName;

    @Column
    private int server;

    @Column
    private int raid;

    @Column
    private int ups;


    public int getId() {
        return id;
    }

    public String getLockerName() {
        return lockerName;
    }

    public void setLockerName(String lockerName) {
        this.lockerName = lockerName;
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }
}
