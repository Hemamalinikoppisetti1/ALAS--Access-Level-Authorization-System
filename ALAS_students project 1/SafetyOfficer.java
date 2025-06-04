public class SafetyOfficer extends Permit {
    private String licenseId;
    private String supervisor;
    private int skillLevel;

    public SafetyOfficer(int id, String name, String licenseId, String supervisor, int skillLevel) {
        super(id, name, 8, 7); // Fixed maxEntries and clearance
        this.licenseId = licenseId;
        this.supervisor = supervisor;
        this.skillLevel = skillLevel;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void promote() {
        if (skillLevel < 7) {
            skillLevel++;
        } else {
            System.out.println("Already at maximum skill level.");
        }
    }

    @Override
    public String toString() {
        return "SafetyOfficer: " + super.toString() +
               " | LicenseID: " + licenseId +
               " | Supervisor: " + supervisor +
               " | SkillLevel: " + skillLevel;
    }
}
