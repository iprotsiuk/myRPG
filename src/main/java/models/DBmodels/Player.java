package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(targetEntity = GameCharacter.class)
    Set<GameCharacter> gameCharacter;

    @Column(unique = true)
    String login;
    String password;

    @OneToOne
    Profile profile;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GameCharacter> getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(Set<GameCharacter> gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
