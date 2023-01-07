package controllers;

import com.google.gson.Gson;
import models.DBmodels.GameCharacter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.RequestJson;
import services.ServiceManager;
import services.SuccessOrError;


public class CharacterController {

    @PostMapping("/createCharacter")
    public String createCharacter(@RequestBody String json){
        Gson gson = new Gson();
        RequestJson requestJson = gson.fromJson(json, RequestJson.class);
        SuccessOrError character = ServiceManager.getCharacterService().create(requestJson);
        if(character.getError() != null)
            return gson.toJson(character.getError());


        return gson.toJson(character.getObject());
    }
}
