package com.example.cc_3.volunteerapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnborden on 3/20/17.
 */

public class CommServiceModel {

    public String sponsor;
    public String address;
    public String phoneNumber;
    public String desc;
    public String dateCreated;
    public String dateExpires;

    public CommServiceModel() {

    }

    public CommServiceModel(String sponsor, String address, String phoneNumber,
                            String desc, String dateCreated, String dateExpires) {

        this.sponsor = sponsor;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.desc = desc;
        this.dateCreated = dateCreated;
        this.dateExpires = dateExpires;

    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("sponsor", sponsor);
        result.put("address", address);
        result.put("phoneNumber", phoneNumber);
        result.put("desc", desc);
        result.put("dateCreated", dateCreated);
        result.put("dateExpires", dateExpires);
        return result;
    }

}
