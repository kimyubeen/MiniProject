package BookManagement;

import java.util.Date;

import com.google.gson.Gson;

public class Member {
    private int id;
    private String name;
    private Date birth;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
