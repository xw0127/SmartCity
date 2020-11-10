package nbpt.com.smartcity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by Administrator on 2020/9/23.
 */

public class AccountDBHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static final String DB_Name="user.db";
    static final  String TABLE_Name="tb_accounts";

    public AccountDBHelper(Context context, int version) {
        super(context,DB_Name, null, version);
        this.mContext = context;
    }

    public Cursor select(String where,String orderby){
        StringBuilder stringBuilder =new StringBuilder("SELECT * FROM "+TABLE_Name);
        if(where!=null){
            stringBuilder.append("WHRER");
            stringBuilder.append(where);
        }
        if(orderby!=null){
            stringBuilder.append("ORDER BY");
            stringBuilder.append(orderby);
        }
        return getWritableDatabase().rawQuery(stringBuilder.toString(),null) ;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insertUser(String username, String password, int gender,String phone) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password",password);
        values.put("gender", gender);
        values.put("phone", phone);
        long retValue = getReadableDatabase().insert(TABLE_Name,null, values);
        return retValue;
    }
    View.OnClickListener listener_Register = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String username = et_user.getText().toString();
            String password = et_pwd.getText().toString();
            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(SecondActivity.this,"用户名和密码不能为空！,Toast.LENGTH_LONG).show();
            } else{
                AccountDBHelper db= new AccountDBHelper (SecondActivity.this,AccountDBHelper.VERSION_1);
                long ret = db.insertUser(usernane, password,1,null):
            }
        }
    };
}
