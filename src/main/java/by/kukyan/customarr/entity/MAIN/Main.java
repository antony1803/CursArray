package by.kukyan.customarr.entity.MAIN;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import by.kukyan.customarr.observer.CustomCollectionObserver;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;
import by.kukyan.customarr.parser.impl.CustomArrayParser;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;
import by.kukyan.customarr.service.impl.CustomArrayService;
import by.kukyan.customarr.service.impl.CustomRepositoryServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
public class Main {
    private static final String PATH = "resources/file/numbers.txt";
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArrayService service = new CustomArrayService();
        List<CustomArray> list = new ArrayList<>();
        CustomArray array = new CustomArray(1, 123, 23, 432, -2);
        CustomArray array1 = new CustomArray(2, 2315, -3424, -5);
        list.add(array);
        list.add(array1);
        CustomRepositoryServiceImplementation crs = new CustomRepositoryServiceImplementation();
        crs.addListInRepo(list);
        Warehouse warehouse = Warehouse.getInstance();
        CustomArray array2 = repository.get(1);
        array2.attach(new CustomArrayObserver());
        logger.info(array);
        logger.info(warehouse);

        array2.setArray(1,5, 15);

        logger.info(array);
        logger.info(warehouse);


    }
}
