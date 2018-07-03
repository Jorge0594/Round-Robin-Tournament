public class Round implements Comparable<Round> {
    private int roundNum;
    private int localTeam;
    private int visitorTeam;
    private String localName;
    private String visitorName;
    private String date = "";


    public Round(int roundNum, int localTeam, int visitorTeam) {
        super();
        this.roundNum = roundNum;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
    }

    public Round(int roundNum, int visitorTeam) {
        super();
        this.roundNum = roundNum;
        this.visitorTeam = visitorTeam;
    }


    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public int getLocalTeam() {
        return localTeam;
    }

    public int getVisitorTeam() {
        return visitorTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeamNames(String localName, String visitorName) {
        this.localName = localName;
        this.visitorName = visitorName;
    }


    @Override
    public String toString() {
        return "Round: " + roundNum + " -> " + localName + " - " + visitorName + " Date: " + date;
    }

    @Override
    public int compareTo(Round round) {
        if (this.roundNum > round.roundNum) return 1;
        if (this.roundNum < round.roundNum) return -1;
        return 0;
    }


}
