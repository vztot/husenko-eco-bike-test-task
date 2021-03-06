package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.service.EbikeService;
import com.ecobike.service.FoldingBikeService;
import com.ecobike.service.SpeedelecService;
import com.ecobike.util.OutputUtil;
import dnl.utils.text.table.TextTable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class CatalogController {
    private FoldingBikeService foldingBikeService =
            (FoldingBikeService) AppContext.getInstance().getService(FoldingBikeService.class);
    private EbikeService ebikeService =
            (EbikeService) AppContext.getInstance().getService(EbikeService.class);
    private SpeedelecService speedelecService =
            (SpeedelecService) AppContext.getInstance().getService(SpeedelecService.class);

    public CatalogController() {
        showAllBikes();
    }

    private void showAllBikes() {
        List<String> foldingBikes =
                foldingBikeService.getAll().stream()
                        .map(b -> b.toCatalogString())
                        .collect(Collectors.toList());
        List<String> ebikes =
                ebikeService.getAll().stream()
                        .map(b -> b.toCatalogString())
                        .collect(Collectors.toList());
        List<String> speedelecs =
                speedelecService.getAll().stream()
                        .map(b -> b.toCatalogString())
                        .collect(Collectors.toList());

        List<String> all = Stream.of(foldingBikes, ebikes, speedelecs)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Collections.shuffle(all);

        TextTable table = new TextTable(new String[]{"#", "Description"}, new String[][]
                {
                        {"1", "Show all catalog"},
                        {"2", "Show all folding bikes"},
                        {"3", "Show all speedelecs"},
                        {"4", "Show all e-bikes"},
                });
        table.printTable();
        System.out.println();

        String answer = new Scanner(System.in).nextLine();

        if (answer.equals("1")) {
            OutputUtil.soutListWithPages(all);
        }
        if (answer.equals("2")) {
            OutputUtil.soutListWithPages(foldingBikes);
        }
        if (answer.equals("3")) {
            OutputUtil.soutListWithPages(speedelecs);
        }
        if (answer.equals("4")) {
            OutputUtil.soutListWithPages(ebikes);
        }
    }
}
