package com.example.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Utilities {

    public String convertUUIDToString(UUID uuid){
        return uuid.toString().replace("-","");
    }

    public UUID convertStringToUUID(String str){
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(str.split("")));
        strList.add(8,"-");
        strList.add(13,"-");
        strList.add(18,"-");
        strList.add(23,"-");
        return UUID.fromString(String.join("", strList));
    }

}
