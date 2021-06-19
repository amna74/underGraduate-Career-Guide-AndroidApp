package com.example.undergradcareerguide.Database;

import android.provider.BaseColumns;

public class entries {

    private  entries(){}

    public static class FeedEntry implements BaseColumns
    {
        // keys of our table in DB
        public static final String TableName = "TableUser";
        public static final String COL1 = "Name";
        public static final String COL2 = "TestName";
        public static final String COL3 = "CorrectAns";
        public static final String COL4 = "WrongAns";
        public static final String COL5 = "Percentage";
    }

}
