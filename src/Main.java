import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> teamNames = Arrays.asList("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");

        TournamentCalendar calendar = new TournamentCalendar(teamNames, "05-07-2018", 2);

        List<Round> schedule = calendar.getSchedule();

        schedule.forEach(System.out::println);

    }

}
