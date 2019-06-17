package cn.edu.gdpt.healthknowledge;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    public static String DB_NAME = "topline.db";
    public static final String U_USERINFO = "userinfo";


    public SQLiteHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+U_USERINFO+"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"userName VARCHAR,"
                +"password VARCHAR,"
                +"nickName VARCHAR,"
                +"sex VARCHAR,"
                +"signature VARCHAR,"
                +"head VARCHAR"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+U_USERINFO);
        onCreate(db);

    }
}
