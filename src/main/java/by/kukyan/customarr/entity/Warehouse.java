package by.kukyan.customarr.entity;

import by.kukyan.customarr.exception.CustomCollectionExcepion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Integer, CustomArrayParameters> mapStatistics;


    public Warehouse() {
        this.mapStatistics = new HashMap<Integer, CustomArrayParameters>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public CustomArrayParameters getById(int arrayId) throws CustomCollectionExcepion {
        if (mapStatistics.containsKey(arrayId)) {
            CustomArrayParameters statistics = mapStatistics.get(arrayId);
            return statistics;
        } else {
            logger.error("warehouse does not contain element with id: " + arrayId);
            throw new CustomCollectionExcepion("warehouse does not contain element with id: " + arrayId);
        }
    }

    public CustomArrayParameters putById(Integer arrayId, CustomArrayParameters statistics) {
        return mapStatistics.put(arrayId, statistics);
    }

    public CustomArrayParameters removeById(int arrayId) throws CustomCollectionExcepion{
        if (mapStatistics.containsKey(arrayId)) {
            return mapStatistics.remove(arrayId);
        } else {
            logger.error("warehouse does not contain element with id: " + arrayId);
            throw new CustomCollectionExcepion("warehouse does not contain element with id: " + arrayId);
        }
    }

    public CustomArrayParameters clearValue(int arrayId) throws CustomCollectionExcepion {
        if(mapStatistics.containsKey(arrayId)){
            return mapStatistics.replace(arrayId, new CustomArrayParameters());
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
