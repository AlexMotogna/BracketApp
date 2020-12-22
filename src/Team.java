import java.util.List;

public class Team {

    private String teamName;
    private List<Participant> team;
    private Boolean status; // FALSE - eliminated , TRUE - not eliminated
    private int matchesWon;

    public Team(int numberOfParticipants, String teamName){
        this.teamName = teamName;
        status = true;
        matchesWon = 0;
    }

    public void wonGame(){
        this.matchesWon++;
    }

    public void lostGame(){
        this.status = false;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getMatchesWon(){
        return matchesWon;
    }

    public boolean getStatus(){
        return status;
    }
}
