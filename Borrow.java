package BookManagement;

import java.util.Date;

public class Borrow {
    private int bookId;
    private boolean status;
    private int memberId;
    private Date startDay;
    private Date returnDay;
    
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public Date getStartDay() {
        return startDay;
    }
    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }
    public Date getReturnDay() {
        return returnDay;
    }
    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }
    

    
    
}
