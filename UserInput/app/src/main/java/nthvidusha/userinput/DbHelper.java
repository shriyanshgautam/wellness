package nthvidusha.userinput;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shriyansh on 18/4/15.
 */
public class DbHelper extends SQLiteOpenHelper implements DbConstants{

    public DbHelper(Context context) {
        super(context, "welness.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         String SQL="CREATE TABLE "+TBL_CHALLENGE+" ( "+
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
                COL_TITLE+ " TEXT, "+
                COL_DESCRIPTION+" TEXT, "+
                COL_CATEGORY+ " TEXT , "+
                COL_RATING+ " REAL, "+
                COL_COMPLETED+" INTEGER , "+
                COL_GROUP_ID+ " INTEGER"+
                ");";

        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TBL_CHALLENGE );
    }
}
