public class Team {

    private String teamName;
    private Boolean status; // FALSE - eliminated , TRUE - not eliminated
    private int matchesWon;

    public Team() {
        this.teamName = "Not yet entered";
        status = true;
        matchesWon = 0;
    }

    public void wonGame() {
        this.matchesWon++;
    }

    public void lostGame() {
        this.status = false;
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

    public boolean getStatus() {
        return status;
    }
}
