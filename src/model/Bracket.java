package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Bracket {

    List<Team> teams = new ArrayList<>();
    List<Match> matchQueue = new ArrayList<>();
    List<Match> playedMatches = new ArrayList<>();
    int numberOfTeams;

    public List<Team> createTeams(int numberOfTeams) {
        for (int i = 1; i <= numberOfTeams; i++) {
            Team newTeam = new Team();
            newTeam.setTeamName("Team " + i);
            teams.add(newTeam);
        }

        return teams;
    }

    public abstract void computeMatches();

    public abstract void declareWinner(Match match, Team winner);

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

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

