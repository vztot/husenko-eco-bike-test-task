package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.service.SearchService;
import dnl.utils.text.table.TextTable;
import java.util.Scanner;

@Controller
public class SearchIndexController {
    private SearchService searchService =
            (SearchService) AppContext.getInstance().getService(SearchService.class);

    public SearchIndexController() {
        drawMenu();
        String ans = "";
        while (!ans.equals("1") || !ans.equals("2") || !ans.equals("3") || !ans.equals("4")) {
            ans = new Scanner(System.in).nextLine();
            switch (ans) {
                case "1": {
                    new FindFirstItemController();
                    return;
                }
                case "2": {
                    new FindAndListAllItemsController();
                    return;
                }
                case "3": {
                    new HqlPowerController();
                    return;
                }
                case "4": {
                    return;
                }
                default: {
                }
            }
        }
    }

    private void drawMenu() {
        TextTable table = new TextTable(new String[]{"#", "Description"}, new String[][]
                {
                        {"1", "Find the first item of a particular brand and parameters"},
                        {"2", "Find and list all items of a particular brand and parameters"},
                        {"3", "Use power of HQL"},
                        {"4", "Back"},
                });
        table.printTable();
        System.out.println();
    }
}
