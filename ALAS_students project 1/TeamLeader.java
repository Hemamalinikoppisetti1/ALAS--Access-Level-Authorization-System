public class TeamLeader extends Permit {
    private int teamSize;
    private double budget;

    public TeamLeader(int id, String name, int maxEntries, int clearanceLevel, double budget) {
        super(id, name, maxEntries, clearanceLevel);
        this.budget = budget;
        this.teamSize = 0; // Default
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "TeamLeader: " + super.toString() + " | Budget: " + budget + " | TeamSize: " + teamSize;
    }
}
