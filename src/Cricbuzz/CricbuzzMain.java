package Cricbuzz;

import Cricbuzz.MatchTypes.T20MatchType;
import Cricbuzz.Team.Team;

import java.time.LocalDate;

public class CricbuzzMain {
    public static void main(String[] args) {
        Cricbuzz cricbuzz = Cricbuzz.getInstance();

        Team teamA = cricbuzz.addTeam("India");
        Team teamB = cricbuzz.addTeam("SriLanka");

        Match match = cricbuzz.createMatch("MAT01", teamA, teamB, LocalDate.now(), "SMS STADIUM", new T20MatchType());
        match.startMatch();
    }
}
