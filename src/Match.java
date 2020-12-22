public class Match {

    private Team team1, team2;
    private Team winner;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        winner = null;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getTeamByIndex(int index) {
        if (index == 1) {
            return team1;
        } else {
            return team2;
        }
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Team getLoser() {
        if (this.winner == null) {
            System.out.println("cannot retrieve loser yet");
            return null;
        } else {
            if (this.team1 == this.winner) {
                return team2;
            } else {
                return team1;
            }
        }
    }

    public String toString() {
        String string = "Match of team " + team1.getTeamName() + " versus team " + team2.getTeamName();
        if (winner == null) {
            string += " : not yet played";
        } else {
            string += " : winner is: " + this.winner.getTeamName();
        }

        return string;
    }

}
