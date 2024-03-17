public class Patron {
    private String id;
    private String name;

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters for all properties

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
