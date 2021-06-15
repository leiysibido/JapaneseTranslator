package database;

import android.provider.BaseColumns;

public class Gamit {
    private Gamit() {
    }

    public static final class UserWord implements BaseColumns{

        public static final String TABLE_NAME = "Language";
        public static final String COL_ENGLISH = "English";
        public static final String COL_JAPANESE = "Japanese";
    }
}
