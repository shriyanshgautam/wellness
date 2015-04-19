package nthvidusha.userinput;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by shriyansh on 18/4/15.
 */
public class DbMethods implements DbConstants{
   public Context context;
    DbHelper dbHelper;
    SQLiteDatabase db;
    public DbMethods(Context context){
        this.context=context;
        dbHelper=new DbHelper(context);
    }

    public long insert(String title,String desc,String tag,float rating,long groupID){
        db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_TITLE,title);
        values.put(COL_DESCRIPTION,desc);
        values.put(COL_CATEGORY,tag);
        values.put(COL_RATING,rating);
        values.put(COL_GROUP_ID,groupID);
        values.put(COL_COMPLETED,COMPLETED);
       long id=db.insert(TBL_CHALLENGE,null,values);
        Log.d("INSRTED",id+"");
        return id;
    }

    public Cursor getChallenges(long groupID){
        db=dbHelper.getWritableDatabase();
        return db.query(TBL_CHALLENGE,null,COL_GROUP_ID+" =? ",new String[]{String.valueOf(groupID)},null,null,null);
    }
    public Cursor getChallenges(int completed){
        db=dbHelper.getWritableDatabase();
        return db.query(TBL_CHALLENGE,null,COL_COMPLETED+" =? ",new String[]{String.valueOf(completed)},null,null,null);
    }

}
