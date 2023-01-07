package controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.RequestJson;
import services.ServiceManager;
import services.SuccessOrError;

public class PlayerController {

    @PostMapping("/createPlayer")
    public String createPlayer(@RequestBody String json){
        Gson gson = new Gson();
        RequestJson requestJson = gson.fromJson(json, RequestJson.class);
        String login = requestJson.getLogin();
        String pwd = requestJson.getPassword();
        SuccessOrError character = ServiceManager.getPlayerService().register(login, pwd);

        return gson.toJson(character.getObject());
    }


    }
