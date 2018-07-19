import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String>teamNames = new ArrayList<>(20);
        for (int i = 0; i < 8 ; i++) {
            teamNames.add("Team" + (i + 1));
        }

        TournamentCalendar calendar = new TournamentCalendar(teamNames, "07-07-2018", 3);

        List<Round> schedule = calendar.getSchedule();

        schedule.forEach(System.out::println);


    }

}
