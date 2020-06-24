package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.service.EbikeService;
import com.ecobike.service.FoldingBikeService;
import com.ecobike.service.SpeedelecService;
import com.ecobike.util.FileUtil;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;

@Controller
public class IndexController {
    public static String pathToFile = "file/ecobike.txt";
    public static List<String> newLines;
    private static final Logger LOGGER = Logger.getLogger(IndexController.class);
    private static final Map<Integer, Command> COMMAND_MAP;
    // switching between controllers made by using command pattern
    private static List<String> lines;
    private FoldingBikeService foldingBikeService =
            (FoldingBikeService) AppContext.getInstance().getService(FoldingBikeService.class);
    private EbikeService ebikeService =
            (EbikeService) AppContext.getInstance().getService(EbikeService.class);
    private SpeedelecService speedelecService =
            (SpeedelecService) AppContext.getInstance().getService(SpeedelecService.class);

    static {
        Map<Integer, Command> map = new HashMap<>();
        map.put(1, () -> {
            new CatalogController();
        });
        map.put(2, () -> {
            new AddNewBikeController("FOLDING BIKE", newLines);
        });
        map.put(3, () -> {
            new AddNewBikeController("SPEEDELEC", newLines);
        });
        map.put(4, () -> {
            new AddNewBikeController("E-BIKE", newLines);
        });
        map.put(5, () -> {
            new SearchController();
        });
        map.put(6, () -> {
            new WriteToFileController();
        });
        map.put(7, () -> {
            new ExitController(newLines);
        });
        COMMAND_MAP = Collections.unmodifiableMap(map);
    }

    public void init() {
        while (pathToFile == null) {
            System.out.println("Please, enter path to \"ecobike.txt\" (by default enter "
                    + "\"file/ecobike.txt\", also you can use absolute path), for exit type \"q\"");
            getPathToFile(new Scanner(System.in));
        }
        lines = FileUtil.read(pathToFile);
        newLines = new ArrayList<>();

        for (String line : lines) {
            switch (line.charAt(0)) {
                case 'F': {
                    FoldingBike foldingBike = foldingBikeService.buildEntityFromString(line);
                    foldingBikeService.add(foldingBike);
                    break;
                }
                case 'E': {
                    Ebike ebike = ebikeService.buildEntityFromString(line);
                    ebikeService.add(ebike);
                    break;
                }
                case 'S': {
                    Speedelec speedelec = speedelecService.buildEntityFromString(line);
                    speedelecService.add(speedelec);
                    break;
                }
                default: {
                }
            }
        }
        lines = null; // for gc
        System.out.println("File was loaded successfully!");
    }

    public void service() {
        while (true) {
            drawMenu();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                Integer command = null;
                try {
                    command = Integer.parseInt(input);
                } catch (Exception e) {
                    LOGGER.warn("Cant parse command: " + command, e);
                }

                if (command != null && COMMAND_MAP.containsKey(command)) {
                    COMMAND_MAP.get(command).execute();
                } else {
                    System.out.println("Please enter appropriate command number");
                    drawMenu();
                }
            }
        }
    }

    private void drawMenu() {
        System.out.println(
                "\nPlease make your choice:\n"
                        + "   1 - Show the entire EcoBike catalog\n"
                        + "   2 – Add a new folding bike\n"
                        + "   3 – Add a new speedelec\n"
                        + "   4 – Add a new e-bike\n"
                        + "   5 – Find the first item of a particular brand\n"
                        + "   6 – Write to file\n"
                        + "   7 – Stop the program");
    }

    private void getPathToFile(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String path = scanner.nextLine();
            if (path.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if (Paths.get(path).toFile().exists()
                    && Paths.get(path).toFile().getName().equals("ecobike.txt")) {
                pathToFile = path;
                System.out.println("File was found successfully!");
            } else {
                System.out.println("Can't find \"ecobike.txt\" in \"" + path + "\"");
            }
        }
    }

    private interface Command {
        void execute();
    }
}
