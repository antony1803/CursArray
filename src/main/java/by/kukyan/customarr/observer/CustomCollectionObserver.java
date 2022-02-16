package by.kukyan.customarr.observer;

import by.kukyan.customarr.observer.impl.CustomArrayEvent;

public interface CustomCollectionObserver {
    void replaceStatistic(CustomArrayEvent event);

    void updateMin(CustomArrayEvent event);

    void updateMax(CustomArrayEvent event);

    void updateAvg(CustomArrayEvent event);

    void updateSum(CustomArrayEvent event);
}
