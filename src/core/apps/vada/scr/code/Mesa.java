package core.apps.vada.scr.code;

public class Mesa {

    private int ID;
    private String name;

    private double ranking = 0;
    private boolean status =true;
    private double percentage = 0;


    public Mesa(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Mesa(){

    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void print(){
        System.out.println("ID : " + this.ID);
        System.out.println("Name : " + this.name);
        System.out.println("Status : " + this.status);
        System.out.println("Ranking : " + this.ranking);
        System.out.println("Percentage : " + this.percentage);
    }

}
