package Cricbuzz;

import Cricbuzz.MatchTypes.MatchType;
import Cricbuzz.Team.Player.Person;
import Cricbuzz.Team.Player.PlayerDetails;
import Cricbuzz.Team.Player.PlayerType;
import Cricbuzz.Team.Team;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Cricbuzz {
    private static Cricbuzz cricbuzz;
    public Map<String, Match> matches;

    private Cricbuzz(){
        matches = new ConcurrentHashMap<>();
    }

    public static synchronized Cricbuzz getInstance(){
        if (cricbuzz == null){
            cricbuzz = new Cricbuzz();
        }
        return cricbuzz;
    }

    public Team addTeam(String name) {

        Queue<PlayerDetails> playerDetails = new LinkedList<>();

        PlayerDetails p1 = addPlayer(name+"1", PlayerType.ALLROUNDER);
        PlayerDetails p2 = addPlayer(name+"2", PlayerType.ALLROUNDER);
        PlayerDetails p3 = addPlayer(name+"3", PlayerType.ALLROUNDER);
        PlayerDetails p4 = addPlayer(name+"4", PlayerType.ALLROUNDER);
        PlayerDetails p5 = addPlayer(name+"5", PlayerType.ALLROUNDER);
        PlayerDetails p6 = addPlayer(name+"6", PlayerType.ALLROUNDER);
        PlayerDetails p7 = addPlayer(name+"7", PlayerType.ALLROUNDER);
        PlayerDetails p8 = addPlayer(name+"8", PlayerType.ALLROUNDER);
        PlayerDetails p9 = addPlayer(name+"9", PlayerType.ALLROUNDER);
        PlayerDetails p10 = addPlayer(name+"10", PlayerType.ALLROUNDER);
        PlayerDetails p11 = addPlayer(name+"11", PlayerType.ALLROUNDER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        List<PlayerDetails> bowlers = new ArrayList<>();
        bowlers.add(p7);
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        return new Team(name, playerDetails, new ArrayList<>(), bowlers);
    }

    public PlayerDetails addPlayer(String name, PlayerType playerType) {

        Person person = new Person();
        person.name = name;
        return new PlayerDetails(person, playerType);
    }

    public Match createMatch(String matchId, Team A, Team B, LocalDate date, String venue, MatchType matchType){
        Match match = new Match(matchId, A, B, date, venue, matchType);
        matches.put(matchId, match);
        return match;
    }
}
