package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.util.FileUtil;
import java.util.List;
import java.util.Scanner;

@Controller
public class ExitController {
    public ExitController(List<String> lines, int oldSize) {
        if (lines.size() > oldSize) {
            System.out.println("Would you like to save unsaved changes (yes/no)?");
            String string = new Scanner(System.in).nextLine();
            if (string.equalsIgnoreCase("yes")) {
                FileUtil.write(IndexController.pathToFile, lines);
            }
        }
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
