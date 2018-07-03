import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> teamNames = Arrays.asList("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10", "Team11", "Team12", "Team13", "Team14", "Team15", "Team16", "Team17", "Team18", "Team19");

        TournamentCalendar calendar = new TournamentCalendar(teamNames, "07-07-2018", 2);

        List<Round> schedule = calendar.getSchedule();

        schedule.forEach(System.out::println);

    }

}
