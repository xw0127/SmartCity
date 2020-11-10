package nbpt.com.smartcity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {
    EditText name,password;
    private Button zc,qx;
    private String nn,mm;
    SecondActivity secondActivity=new SecondActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        zc=findViewById(R.id.btn1);
        zc.setOnClickListener(listener);
        name.setHint("请输入用户名");
        password.setHint("请输入密码");
    }
    View.OnClickListener listener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nn = name.getText().toString();
            mm = password.getText().toString();
            SharedPreferences.Editor editor=secondActivity.sp.edit();
            editor.putString("username",nn);
            editor.putString("password",mm);
            editor.commit();
        }
    };

}
