package entity;

public class ConservationRecord {

    private String conservationAction;//养护的操作
    private String conservationTime;//养护时间
    private String conservationPerson;//养护人


    public ConservationRecord(String conservationAction, String conservationTime, String conservationPerson) {
        this.conservationAction = conservationAction;
        this.conservationTime = conservationTime;
        this.conservationPerson = conservationPerson;
    }



    public String getConservationAction() {
        return conservationAction;
    }

    public void setConservationAction(String conservationAction) {
        this.conservationAction = conservationAction;
    }

    public String getConservationTime() {
        return conservationTime;
    }

    public void setConservationTime(String conservationTime) {
        this.conservationTime = conservationTime;
    }

    public String getConservationPerson() {
        return conservationPerson;
    }

    public void setConservationPerson(String conservationPerson) {
        this.conservationPerson = conservationPerson;
    }
}
