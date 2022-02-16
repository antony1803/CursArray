package by.kukyan.customarr.observer.impl;

import by.kukyan.customarr.customaction.impl.CustomArrayActionImplementation;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayStatistics;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import by.kukyan.customarr.observer.CustomCollectionObserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayObserver implements CustomCollectionObserver {
    private static final Logger logger = LogManager.getLogger();


    public void replaceStatistic(CustomArrayEvent event){
        try {
            CustomArray source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.clearValue(sourceId);
        } catch (CustomCollectionExcepion e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void updateMin(CustomArrayEvent event) {
        try {
            CustomArray source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            CustomArrayStatistics statistics = warehouse.getById(sourceId);
            CustomArrayActionImplementation action = CustomArrayActionImplementation.getInstance();
            OptionalInt min = action.getMin(source);
            if (min.isPresent()){
                statistics.setMin(min.getAsInt());
            }
        } catch (CustomCollectionExcepion e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateMax(CustomArrayEvent event) {
        try {
            CustomArray source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            CustomArrayStatistics statistics = warehouse.getById(sourceId);
            CustomArrayActionImplementation action = new CustomArrayActionImplementation();
            OptionalInt max = action.getMax(source);
            if (max.isPresent()){
                statistics.setMax(max.getAsInt());
            }
        } catch (CustomCollectionExcepion e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateAvg(CustomArrayEvent event) {
        try {
            CustomArray source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            CustomArrayStatistics statistics = warehouse.getById(sourceId);
            CustomArrayActionImplementation action = new CustomArrayActionImplementation();
            OptionalDouble avg = action.getAvg(source);
            if (avg.isPresent()){
                statistics.setAvg(avg.getAsDouble());
            }
        } catch (CustomCollectionExcepion e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateSum(CustomArrayEvent event) {
        try {
            CustomArray source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            CustomArrayStatistics statistics = warehouse.getById(sourceId);
            CustomArrayActionImplementation action = new CustomArrayActionImplementation();
            statistics.setSum((action.getSum(source)).getAsLong());
        } catch (CustomCollectionExcepion e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
