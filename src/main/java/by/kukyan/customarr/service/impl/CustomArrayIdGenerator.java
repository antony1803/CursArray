package by.kukyan.customarr.service.impl;

public class CustomArrayIdGenerator {
    private static final int MIN_ID = 100000;
    private static final int MAX_ID = 999999;
    private static int lastAssignedIdFromPositionOfMinId = 0;

    private CustomArrayIdGenerator(){}

    public static int getNextId(){
        lastAssignedIdFromPositionOfMinId++;
        if(MAX_ID < MIN_ID + lastAssignedIdFromPositionOfMinId){
            lastAssignedIdFromPositionOfMinId = 0;
        }
        return MIN_ID + lastAssignedIdFromPositionOfMinId;
    }
}
