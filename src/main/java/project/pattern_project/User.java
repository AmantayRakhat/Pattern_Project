package project.pattern_project;

class User {
    private int id;
    private String name;
    private String email;
    private double cash;
    private String address;
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getCash() {
        return cash;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public User(int id, String name, String email, String password, Double cash, String address) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password = password;
        this.cash=cash;
        this.address=address;
    }
}
