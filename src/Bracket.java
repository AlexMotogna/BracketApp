import java.util.ArrayList;
import java.util.List;

public abstract class Bracket {

    List<Team> teams = new ArrayList<Team>();
    List<Match> matchQueue = new ArrayList<Match>();
    List<Match> playedMatches = new ArrayList<Match>();
    int numberOfLayers;
    int numberOfTeams;

    public List<Team> createTeams(int numberOfTeams) {
        for (int i = 1; i <= numberOfTeams; i++) {
            Team newTeam = new Team();
            teams.add(newTeam);
        }

        return teams;
    }

    public abstract void computeMatches();

    public abstract void declareWinner(Match match, Team winner);

    public List<Match> getMatchesToBePlayed() {
        return matchQueue;
    }

    public List<Match> getPlayedMatches() {
        return playedMatches;
    }

    public List<Team> getTeams() {
        return teams;
    }

}

