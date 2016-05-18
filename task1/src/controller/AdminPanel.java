package controller;

import interaction.InteractionLocker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by alexey on 18/05/16.
 */
@ManagedBean
@RequestScoped
public class AdminPanel {
    public AdminPanel(){

    }

    InteractionLocker interactionLocker = new InteractionLocker();
    private String lockerName;

    public String addLocker(String name){
        interactionLocker.addLocker(name);
        return "adminpanel";
    }

    public String getLockerName() {
        return lockerName;
    }

    public void setLockerName(String lockerName) {
        this.lockerName = lockerName;
    }
}
