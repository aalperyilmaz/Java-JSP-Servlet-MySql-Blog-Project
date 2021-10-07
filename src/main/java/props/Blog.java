package props;

public class Blog {
    private int cidx;
    private  String title;
    private String detail;
    public Blog(){

    }

    public Blog(int cidx, String title, String detail) {
        this.cidx = cidx;
        this.title = title;
        this.detail = detail;
    }

    public Blog(String title, String detail) {
    }

    public int getCidx() {
        return cidx;
    }

    public void setCidx(int cidx) {
        this.cidx = cidx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
