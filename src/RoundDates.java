import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RoundDates {
    private LocalDate initDate;
    private DateTimeFormatter formatter;
    private List<Round> rounds;

    public RoundDates(String date, String format, List<Round> rounds) {
        formatter = DateTimeFormatter.ofPattern(format);
        initDate = LocalDate.parse(date, formatter);
        this.rounds = rounds;
    }

    public RoundDates(String date, List<Round> rounds) {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        initDate = LocalDate.parse(date, formatter);
        this.rounds = rounds;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void generateRoundsDates(int roundDuration) {
        Map<Integer, List<Round>> roundsByNumber = rounds.stream()
                .collect(Collectors.groupingBy(Round::getRoundNum));

        LocalDate roundDate = initDate;
        int numMatches;
        int it;
        List<Round> listRounds;

        for (int i = 0; i < roundsByNumber.keySet().size(); i++) {
            listRounds = roundsByNumber.get(i + 1);
            numMatches = listRounds.size();

            it = numMatches / roundDuration;
            if (numMatches % roundDuration == 0) {

                for (Round round : listRounds) {
                    round.setDate(roundDate.format(formatter));
                    it--;
                    if (it == 0) {
                        it = numMatches / roundDuration;
                        roundDate = roundDate.plusDays(1);
                    }
                }

            } else {
                LocalDate auxRoundDate = roundDate;

                for (int j = 0; j < numMatches / roundDuration; j++) {
                    listRounds.get(j).setDate(roundDate.format(formatter));
                    it--;
                    if (it == 0) {
                        it = numMatches / roundDuration;
                        roundDate = roundDate.plusDays(1);
                    }
                }

                for (int k = numMatches / roundDuration; k < listRounds.size(); k++) {
                    listRounds.get(k).setDate(auxRoundDate.format(formatter));
                    auxRoundDate = auxRoundDate.plusDays(1);
                }

                roundDate = auxRoundDate;

            }
            roundDate = roundDate.plusDays(7 - roundDuration);

        }

    }


}
