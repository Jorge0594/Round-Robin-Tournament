import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;


public class RoundDates {
    private LocalDate initDate;
    private DateTimeFormatter formatter;
    private List<Round> rounds;
    private List<LocalDate>feastDays;

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

    public RoundDates(String date, List<Round> rounds, List<String>feastDays){
        this(date, rounds);

        this.feastDays = this.feastDaysParser(feastDays);
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
        List<Round> listMatches;

        for (int i = 0; i < roundsByNumber.keySet().size(); i++) {
            listMatches = roundsByNumber.get(i + 1);
            numMatches = listMatches.size();

            it = numMatches / roundDuration;
            if (numMatches % roundDuration == 0) {

                for (Round round : listMatches) {
                    round.setDate(roundDate.format(formatter));
                    it--;
                    if (it == 0) {
                        it = numMatches / roundDuration;
                        roundDate = roundDate.plusDays(1);
                    }
                }

            } else {
                LocalDate auxRoundDate = roundDate;

                for(int j = 0; j < listMatches.size(); j++){
                    listMatches.get(j).setDate(auxRoundDate.format(formatter));
                    it--;
                    if(it == 0){
                        it = numMatches / roundDuration;
                        auxRoundDate = auxRoundDate.equals(roundDate.plusDays(roundDuration - 1)) ? roundDate : auxRoundDate.plusDays(1);
                    }
                }

                roundDate = roundDate.plusDays(roundDuration);

            }
            roundDate = roundDate.plusDays(7 - roundDuration);

        }

    }

    private List<LocalDate> feastDaysParser(List<String> feastDays){
        return feastDays.stream()
                .map(date -> LocalDate.parse(date, formatter))
                .collect(Collectors.toList());
    }


}
