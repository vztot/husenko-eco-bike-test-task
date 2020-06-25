package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.util.FileUtil;
import java.util.Scanner;

@Controller
public class WriteToFileController {
    public WriteToFileController() {
        if (IndexController.newLines.size() > 0) {
            System.out.println("Would you like to save unsaved changes (yes/no)?");
            String string = new Scanner(System.in).nextLine();
            if (string.equalsIgnoreCase("yes")) {
                FileUtil.writeAppend(IndexController.pathToFile, IndexController.newLines);
                IndexController.newLines.clear();
                System.out.println("Data successfully saved.");
            }
        } else {
            System.out.println("You don't have unsaved data.");
        }
    }
}
