package com.toast.administrator.hello.data.db.model;

import android.provider.BaseColumns;

public final class UserContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public UserContract() {}

    /* Inner class that defines the table contents */
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "tb_user";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}