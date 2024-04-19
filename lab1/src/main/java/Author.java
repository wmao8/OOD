public class Author {
    private String name;
    private String email;

    private String address;


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Creates a new author given the author's name, email and address as strings.
     *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address
     */
    public Author(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

