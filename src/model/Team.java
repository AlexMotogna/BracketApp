package model;

public class Team {

    private String teamName;
    private int matchesWon;

    public Team() {
        this.teamName = "Not yet entered";
        matchesWon = 0;
    }

    public void wonGame() {
        this.matchesWon++;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", matchesWon=" + matchesWon +
                '}';
    }
}
