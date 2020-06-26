package com.ecobike.service.impl;

import com.ecobike.annotation.Inject;
import com.ecobike.annotation.Service;
import com.ecobike.dao.SearchDao;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.service.SearchService;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Inject
    private SearchDao searchDao;

    @Override
    public List<FoldingBike> searchFoldingBike(FoldingBike foldingBike) {
        return searchDao.searchFoldingBike(foldingBike);
    }

    @Override
    public List<FoldingBike> searchFirstFoldingBike(FoldingBike foldingBike) {
        return searchDao.searchFirstFoldingBike(foldingBike);
    }

    @Override
    public List<Speedelec> searchSpeedelec(Speedelec speedelec) {
        return searchDao.searchSpeedelec(speedelec);
    }

    @Override
    public List<Speedelec> searchFirstSpeedelec(Speedelec speedelec) {
        return searchDao.searchFirstSpeedelec(speedelec);
    }

    @Override
    public List<Ebike> searchEbike(Ebike ebike) {
        return searchDao.searchEbike(ebike);
    }

    @Override
    public List<Ebike> searchFirstEbike(Ebike ebike) {
        return searchDao.searchFirstEbike(ebike);
    }

    @Override
    public List<Object> executeHql(String query) {
        return searchDao.executeHql(query);
    }
}
