package com.quickblox.sample.customobjects.model;

import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.sample.customobjects.utils.QBCustomObjectsUtils;

public class Movie {

    public interface Contract {
        String NAME = "name";
        String DESCRIPTION = "description";
        String YEAR = "year";
        String RATING = "rating";
    }

    private String id;
    private String name;
    private String description;
    private String year;
    private float rating;
    private String date;

    public Movie(QBCustomObject qbCustomObject) {
        id = qbCustomObject.getParentId();
        name = QBCustomObjectsUtils.parseField(Contract.NAME, qbCustomObject);
        description = QBCustomObjectsUtils.parseField(Contract.DESCRIPTION, qbCustomObject);
        year = QBCustomObjectsUtils.parseField(Contract.YEAR, qbCustomObject);
        String Rating = QBCustomObjectsUtils.parseField(Contract.RATING, qbCustomObject);
        rating = Rating.equals("null") ? 0 : Float.parseFloat(Rating);
        date = qbCustomObject.getUpdatedAt().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }
}