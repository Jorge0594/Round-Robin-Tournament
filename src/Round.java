public class Round implements Comparable<Round> {
    private int roundNum;
    private int localTeam;
    private int visitorTeam;
    private String localId;
    private String visitorId;
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

    public void setTeamNames(String localId, String visitorId) {
        this.localId = localId;
        this.visitorId = visitorId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public String toString() {
        return "Round: " + roundNum + " -> " + localId + " - " + visitorId + " Date: " + date;
    }

    @Override
    public int compareTo(Round round) {
        if (this.roundNum > round.roundNum) return 1;
        if (this.roundNum < round.roundNum) return -1;
        if (this.roundNum == round.roundNum) return this.date.compareTo(round.date);
        return 0;
    }


}
