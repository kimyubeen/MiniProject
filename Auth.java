package BookManagement;

import com.google.gson.Gson;

public class Auth {
    private int memberId;
    private String userId;
    private String pw;
    
    public int getMemberId() {
        return memberId;
    }
    
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getPw() {
        return pw;
    }
    
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
   
}
