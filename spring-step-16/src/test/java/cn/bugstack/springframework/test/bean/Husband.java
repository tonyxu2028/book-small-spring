package cn.bugstack.springframework.test.bean;

public class Husband {

    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    @SuppressWarnings("unused")
    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
