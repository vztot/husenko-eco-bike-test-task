package com.ecobike.service;

import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import java.util.List;

public interface SearchService {
    List<FoldingBike> searchFoldingBike(FoldingBike foldingBike);

    List<Speedelec> searchSpeedelec(Speedelec speedelec);

    List<Ebike> searchEbike(Ebike ebike);
}
