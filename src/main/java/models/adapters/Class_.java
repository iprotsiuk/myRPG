package models.adapters;

import models.DBmodels.Class;
import models.GAMEmodels._classes.IClass;

public class Class_ {
    Class _class;

    public Class_(Class _class) {
        this._class = _class;
    }

    public IClass fromDBToGame(){
        models.GAMEmodels._classes.Class gclass = new models.GAMEmodels._classes.Class();
        gclass.setAgiMultiplier(_class.getAgiMultiplier());
        gclass.setIntMultiplier(_class.getIntMultiplier());
        gclass.setStaMultiplier(_class.getStaMultiplier());
        gclass.setStrMultiplier(_class.getStrMultiplier());
        gclass.setName(_class.getName());
        return gclass;
    }
}
