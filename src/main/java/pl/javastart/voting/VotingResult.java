package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private List<Vote> votes;

    public VotingResult(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int allVotes = votes.size();
        int votesFor = 0;
        int votesAgainst = 0;
        int votesNeutral = 0;

        for (Vote vote : votes) {
            if (vote.getVote() == null) {
                votesNeutral++;
            } else if (vote.getVote()) {
                votesFor++;
            } else {
                votesAgainst++;
            }
        }
        System.out.printf("Głosów za: %.2f%% \n", ((double) votesFor / allVotes * 100));
        System.out.printf("Głosów przeciw: %.2f%% \n", ((double) votesAgainst / allVotes * 100));
        System.out.printf("Wstrzymało się: %.2f%% \n", ((double) votesNeutral / allVotes * 100));
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                Boolean castVote = vote.getVote();
                if (castVote == null) {
                    System.out.println(voterName + ": WSTRZYMAŁ SIĘ");
                } else if (castVote) {
                    System.out.println(voterName + ": ZA");
                } else {
                    System.out.println(voterName + ": PRZECIW");
                }
            }
        }
    }
}
