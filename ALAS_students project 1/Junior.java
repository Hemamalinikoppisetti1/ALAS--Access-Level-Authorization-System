public class Junior extends Permit {
    private String supervisor;

    public Junior(int id, String ref, String supervisor) {
        super(id, ref, 3, 7); // Arbitrary protectionLevel=3
        this.supervisor = supervisor;
        setMaxEntries(2);
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String toString() {
        return super.toString() + ", Junior: Supervisor=" + supervisor;
    }
}
