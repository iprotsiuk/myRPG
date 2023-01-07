package services;

public class ServiceManager {
    static PlayerService playerService;
    static CharacterService characterService;
    static RaceService raceService;
    static ClassService classService;

    public static RaceService getRaceService() {
        return raceService;
    }

    public static void setRaceService(RaceService raceService) {
        ServiceManager.raceService = raceService;
    }

    public static ClassService getClassService() {
        return classService;
    }

    public static void setClassService(ClassService classService) {
        ServiceManager.classService = classService;
    }

    public static PlayerService getPlayerService() {
        return playerService;
    }

    public static void setPlayerService(PlayerService playerService) {
        ServiceManager.playerService = playerService;
    }

    public static CharacterService getCharacterService() {
        return characterService;
    }

    public static void setCharacterService(CharacterService characterService) {
        ServiceManager.characterService = characterService;
    }
}
