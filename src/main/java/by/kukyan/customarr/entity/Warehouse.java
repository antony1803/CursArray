package by.kukyan.customarr.entity;

import by.kukyan.customarr.exception.CustomCollectionExcepion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Integer, CustomArrayStatistics> mapStatistics;


    public Warehouse() {
        this.mapStatistics = new HashMap<Integer, CustomArrayStatistics>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public CustomArrayStatistics getById(long arrayId) throws CustomCollectionExcepion {
        if (mapStatistics.containsKey(arrayId)) {
            CustomArrayStatistics statistics = mapStatistics.get(arrayId);
            return statistics;
        } else {
            logger.error("warehouse does not contain element with id: " + arrayId);
            throw new CustomCollectionExcepion("warehouse does not contain element with id: " + arrayId);
        }
    }

    public CustomArrayStatistics putById(Integer arrayId, CustomArrayStatistics statistics) {
        return mapStatistics.put(arrayId, statistics);
    }

    public CustomArrayStatistics removeById(long arrayId) throws CustomCollectionExcepion{
        if (mapStatistics.containsKey(arrayId)) {
            return mapStatistics.remove(arrayId);
        } else {
            logger.error("warehouse does not contain element with id: " + arrayId);
            throw new CustomCollectionExcepion("warehouse does not contain element with id: " + arrayId);
        }
    }

    public CustomArrayStatistics clearValue(int arrayId) throws CustomCollectionExcepion {
        if(mapStatistics.containsKey(arrayId)){
            return mapStatistics.replace(arrayId, new CustomArrayStatistics());
        } else {
            logger.error("warehouse does not contain element with id: " + arrayId);
            throw new CustomCollectionExcepion("warehouse does not contain element with id: " + arrayId);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("mapStatistics=").append(mapStatistics);
        sb.append('}');
        return sb.toString();
    }
}
