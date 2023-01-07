package services;

import javafx.util.Pair;
import map.ILocation;
import map.MapGenerator;
import models.DBmodels.*;
import models.GAMEmodels.IUnit;
import models.adapters.Map_;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class MapService extends Service{


    public MapService(EntityManager em) {
        super(em);
    }

    private boolean isExist(int id){
        Map_ map = em.find(Map_.class, id);
        if(map == null)
            return false;
        return true;
    }

    public boolean isExistAtLeastOneMap(){
        Query query = em.createQuery("select count(id) from Map");
        long count = (long) query.getSingleResult();
        if(count == 0)
            return false;
        return true;
    }


    //1 - generate map

    public void generateMap(int chunksRows, int chunkCols, int chunkRowSize, int chunkColSize){
        Map map = new Map();

        startTransaction();
        em.persist(map);
        transaction.commit();
        int row = 0;
        int col = 0;

        for(int i = 0; i <chunksRows; i++){
            for (int j = 0; j < chunkCols ; j++) {
                List<Pair<ILocation, IUnit>> chunk = MapGenerator.generateEmptyChunk(chunkRowSize, chunkColSize);
                startTransaction();
                listToChunk(chunk, map, i, j, chunkRowSize, chunkColSize);
                transaction.commit();
            }
        }
    }




    private void listToChunk(List<Pair<ILocation, IUnit>> chunk, Map map, int chunkRow, int chunkCol, int chunkRowSize, int chunkColSize) {

        int incr = 0;

        for(int i = 0; i < chunkColSize; i++ ){
            for (int j = 0; j < chunkRowSize ; j++, incr++) {
                Location location = (Location) chunk.get(incr).getKey();
                LocationToMap ltm = new LocationToMap( location, map, i+(chunkColSize*chunkCol), j+(chunkRowSize*chunkRow));
                em.persist(location);
                em.persist((Unit) chunk.get(incr).getValue());
                em.persist(ltm);
            }
        }

    }



































    }

