//package com.ecobike.view;
//
//import java.util.Scanner;
//
//public class ConsoleHandler {
//    private Scanner scanner;
//
//    public ConsoleHandler(Scanner scanner) {
//        this.scanner = new Scanner(System.in);
//        handle();
//    }
//
//    private void handle() {
//        while (true) {
//            if (scanner.hasNextLine()) {
//                String inputLine = scanner.nextLine();
//                String[] inputSplitData = inputLine.split(" ");
//                String command = inputSplitData[0].toLowerCase();
//                switch (command) {
//                    case "create": {
//                        service.create(inputSplitData);
//                        break;
//                    }
//                    case "read": {
//                        service.read(inputSplitData);
//                        break;
//                    }
//                    case "info": {
//                        service.info(inputSplitData);
//                        break;
//                    }
//                    case "help": {
//                        service.help(inputSplitData);
//                        break;
//                    }
//                    case "exit": {
//                        service.exit();
//                        break;
//                    }
//                    default: {
//                        service.execDefaultCommand(inputLine);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//    private interface Command {
//        String execute(String[] splitData, char command);
//    }
//}
