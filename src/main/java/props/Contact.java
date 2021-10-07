package props;

public class Contact {
private String name;
private String email;
private int cid;
private int aid;
public Contact(){

}

    public Contact(String name, String email, int cid,int aid) {
        this.name = name;
        this.email = email;
        this.cid = cid;
        this.aid=aid;
    }
    public Contact(String name, String email,int aid) {
        this.name = name;
        this.email = email;

        this.aid=aid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
