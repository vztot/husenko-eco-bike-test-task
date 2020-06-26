import com.ecobike.dao.EbikeDao;
import com.ecobike.dao.FoldingBikeDao;
import com.ecobike.dao.SearchDao;
import com.ecobike.dao.SpeedelecDao;
import com.ecobike.dao.impl.EbikeDaoImpl;
import com.ecobike.dao.impl.FoldingBikeDaoImpl;
import com.ecobike.dao.impl.SearchDaoImpl;
import com.ecobike.dao.impl.SpeedelecDaoImpl;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;

public class Init {
    // i dont have enough time to cover app with test this why coverage is so low
    public static EbikeDao ebikeDao = new EbikeDaoImpl();
    public static SpeedelecDao speedelecDao = new SpeedelecDaoImpl();
    public static FoldingBikeDao foldingBikeDao = new FoldingBikeDaoImpl();
    public static SearchDao searchDao = new SearchDaoImpl();
    public static Ebike ebike1;
    public static Ebike ebike2;
    public static FoldingBike foldingBike1;
    public static FoldingBike foldingBike2;
    public static Speedelec speedelec1;
    public static Speedelec speedelec2;

    static {
        // static because h2 database is static
        ebike1 = new Ebike();
        ebike1.setBatteryCapacity(5400);
        ebike1.setBrand("Ebike Brand one");
        ebike1.setColor("Blue");
        ebike1.setLights(false);
        ebike1.setMaximumSpeed(50);
        ebike1.setPrice(950);
        ebike1.setWeight(7000);

        ebike2 = new Ebike();
        ebike2.setBatteryCapacity(6800);
        ebike2.setBrand("Ebike Brand two");
        ebike2.setColor("RED");
        ebike2.setLights(false);
        ebike2.setMaximumSpeed(69);
        ebike2.setPrice(580);
        ebike2.setWeight(3000);

        foldingBike1 = new FoldingBike();
        foldingBike1.setBrand("GIANT");
        foldingBike1.setColor("BLUE");
        foldingBike1.setLights(false);
        foldingBike1.setNumberOfGears(12);
        foldingBike1.setPrice(1200);
        foldingBike1.setWeight(5000);
        foldingBike1.setWheelSize(11);

        foldingBike2 = new FoldingBike();
        foldingBike2.setBrand("GIANT2");
        foldingBike2.setColor("BLUE2");
        foldingBike2.setLights(false);
        foldingBike2.setNumberOfGears(13);
        foldingBike2.setPrice(900);
        foldingBike2.setWeight(500);
        foldingBike2.setWheelSize(13);

        speedelec1 = new Speedelec();
        speedelec1.setBatteryCapacity(5400);
        speedelec1.setBrand("Speedelec Brand one");
        speedelec1.setColor("Blue");
        speedelec1.setLights(false);
        speedelec1.setMaximumSpeed(50);
        speedelec1.setPrice(800);
        speedelec1.setWeight(7000);

        speedelec2 = new Speedelec();
        speedelec2.setBatteryCapacity(6800);
        speedelec2.setBrand("Speedelec Brand two");
        speedelec2.setColor("RED");
        speedelec2.setLights(false);
        speedelec2.setMaximumSpeed(69);
        speedelec2.setPrice(1600);
        speedelec2.setWeight(3000);

        foldingBikeDao.add(foldingBike1);
        foldingBikeDao.add(foldingBike2);
        speedelecDao.add(speedelec1);
        speedelecDao.add(speedelec2);
        ebikeDao.add(ebike1);
        ebikeDao.add(ebike2);
    }
}
