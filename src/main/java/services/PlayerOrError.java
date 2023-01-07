package services;

import models.DBmodels.Player;

public class PlayerOrError {
    Player player;
    Error_ error;

    public PlayerOrError(Player player) {
        this.player = player;
    }

    public PlayerOrError(String error) {
        this.error =  new Error_(error);
    }

    public Player getPlayer() {
        return player;
    }

    public Error_ getError() {
        return error;
    }
}
