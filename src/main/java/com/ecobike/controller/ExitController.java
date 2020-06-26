package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.util.FileUtil;
import java.util.List;
import java.util.Scanner;

@Controller
public class ExitController {
    public ExitController(List<String> lines) {
        if (lines.size() > 0) {
            System.out.println("Would you like to save unsaved changes (yes/no)?");
            String string = new Scanner(System.in).nextLine();
            if (string.equalsIgnoreCase("yes")) {
                FileUtil.writeAppend(IndexController.pathToFile, lines);
            }
        }
        System.out.println("Changes saved successfully.");
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
