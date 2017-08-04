
package mergesort;


public class BusinessRecord {
    String busName;
    String phoneNum;
    
    public BusinessRecord(String name, String phNum) {
        this.busName = name;
        this.phoneNum = phNum;
    }
    
    public void setName(String name) {
        this.busName = name;
    }
    
    public String getName() {
        return this.busName;
    }
    
    public void setPhNum(String phNum) {
        this.phoneNum = phNum;
    }
    
    public String getPhNum() {
        return this.phoneNum;
    }
    
    public String stringOut() {
        String str = this.busName + ", " + this.phoneNum;
        return str;
    }
    
    public void printOut() {
        String str = this.busName + ", " + this.phoneNum;
        System.out.println(str);
    }
    
}