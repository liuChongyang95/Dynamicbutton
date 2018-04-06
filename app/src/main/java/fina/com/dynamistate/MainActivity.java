package fina.com.dynamistate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static int a=1;
    private int i =0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage =  findViewById(R.id.message);
        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final LinearLayout linearLayout=findViewById(R.id.ButtonGroup);
        TextView tv1=new TextView(this);
        tv1.setText("添加");
        tv1.setId(a);
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        linearLayout.addView(tv1);

        Button btn=findViewById(R.id.textBTN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i+=1;
                TextView textView=new TextView(MainActivity.this);
                textView.setText(String.valueOf(i));
                textView.setId(i);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                linearLayout.addView(textView);
                Log.d("MainActivity", String.valueOf(i));
            }
        });

    }

}
