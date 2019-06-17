package cn.edu.gdpt.healthknowledge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class DBUtils {
    private static DBUtils instance=null;
    private static SQLiteHelper helper;
    private static SQLiteDatabase db;

    public DBUtils(Context context){
        helper=new SQLiteHelper(context);
        db=helper.getWritableDatabase();
    }

    public static DBUtils getInstance(Context context) {
        if (instance==null){
            instance=new DBUtils(context);
        }
        return instance;

    }
    public boolean userIsExist(String userName){
        boolean result=false;
        String sql="SELECT * FROM "+SQLiteHelper.U_USERINFO+" WHERE userName = ?";
        Cursor cursor=db.rawQuery(sql,new String[]{userName});
        if (cursor.getCount()>0){
            result=true;
        }
        return result;
    }

    public boolean userRegister(String userName,String password){
        boolean result=false;
        ContentValues cv=new ContentValues();
        cv.put("userName",userName);
        cv.put("password",password);
        long id=db.insert(SQLiteHelper.U_USERINFO,null,cv);
        if (id>0){
            result=true;
        }
        return result;
    }
    public boolean userLogin(String userName,String password){
        boolean result=false;
        String sql="SELECT * FROM "+SQLiteHelper.U_USERINFO+" WHERE userName = ? and password = ?";
        Cursor cursor=db.rawQuery(sql,new String[]{userName,password});
        if (cursor.getCount()>0){
            result=true;
        }
        return result;
    }
    public String getUserHead(String userName){
        String sql="SELECT head FROM "+SQLiteHelper.U_USERINFO+" WHERE userName = ?";
        Cursor cursor=db.rawQuery(sql,new String[]{userName});
        String head="";
        while (cursor.moveToNext()){
            head=cursor.getString(cursor.getColumnIndex("head"));
        }
        cursor.close();
        return head;
    }
    public void saveUserInfo(UserBean bean){
        ContentValues cv=new ContentValues();
        cv.put("userName",bean.getUserName());
        cv.put("nickName",bean.getNickName());
        cv.put("sex",bean.getSex());
        cv.put("signature",bean.getSignature());
        db.insert(SQLiteHelper.U_USERINFO,null,cv);
    }
    public UserBean getUserInfo(String userName){
        String sql="SELECT * FROM "+SQLiteHelper.U_USERINFO+" WHERE userName = ? ";
        Cursor cursor=db.rawQuery(sql,new String[]{userName});
        UserBean bean=null;
        while (cursor.moveToNext()){
            bean=new UserBean();
            bean.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
            bean.setNickName(cursor.getString(cursor.getColumnIndex("nickName")));
            bean.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            bean.setSignature(cursor.getString(cursor.getColumnIndex("signature")));
            bean.setHead(cursor.getString(cursor.getColumnIndex("head")));
        }
        cursor.close();
        return bean;
    }
    public void updateUserInfo(String key,String value,String userName){
        ContentValues cv=new ContentValues();
        cv.put(key, value);
        db.update(SQLiteHelper.U_USERINFO,cv,"userName = ?",new String[]{userName});

    }

}
