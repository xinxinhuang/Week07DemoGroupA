package domainmodel;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int SIN;

    
    
    public User(int id, String firstname, String lastname, String email, String password, int SIN){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.SIN = SIN;   
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getSIN() {
        return SIN;
    }
}
