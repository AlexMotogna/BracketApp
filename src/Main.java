import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Bracket bracket = new DoubleElimBracket(8);

        System.out.println(bracket.numberOfLayers);

        for (int i = 0; i < bracket.numberOfLayers; i++) {
            bracket.computeMatches();
            List<Match> matches = bracket.getMatchesToBePlayed();

            for (int j = 0; j < matches.size(); j++) {
                System.out.println(matches.get(j).toString());
            }

            int played = 0;
            while (played < matches.size()) {
                int matchNb = in.nextInt();
                //int teamNb = in.nextInt();

                bracket.declareWinner(matches.get(matchNb), matches.get(matchNb).getTeam1());
            }
        }

        List<Match> playedMatches = bracket.getPlayedMatches();
        System.out.println(playedMatches.get(playedMatches.size() - 1).toString());
    }
}
