package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    private static final String VOTE_FOR = "z";
    private static final String VOTE_AGAINST = "p";
    private static final String VOTE_NEUTRAL = "w";

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> votes = new ArrayList<>();
        for (String voter : voters) {
            boolean correctVote;
            do {
                System.out.printf("Jak głosuje %s? (%s - za, %s - przeciw, %s - wstrzymanie się) \n", voter,
                        VOTE_FOR, VOTE_AGAINST, VOTE_NEUTRAL);
                String vote = scanner.nextLine();
                correctVote = true;
                switch (vote) {
                    case VOTE_FOR -> votes.add(new Vote(voter, true));
                    case VOTE_AGAINST -> votes.add(new Vote(voter, false));
                    case VOTE_NEUTRAL -> votes.add(new Vote(voter, null));
                    default -> correctVote = false;
                }
            } while (!correctVote);
        }
        return new VotingResult(votes);
    }

}
