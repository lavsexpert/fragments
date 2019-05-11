package club.plus1;

import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mButton3 = findViewById(R.id.btn_3);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                switchFragment("one", R.color.red);
                break;
            case R.id.btn_2:
                switchFragment("two", R.color.green);
                break;
            case R.id.btn_3:
                switchFragment("three", R.color.blue);
                break;
        }
    }

    void switchFragment(String name, int color) {
        Fragment fragment;
        fragment = getFragmentManager().findFragmentByTag(name);
        if (fragment == null) {
            fragment = SampleFragment.newInstance(name, ContextCompat.getColor(this, color));
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, name)
                    .commit();
        } else {
            Toast.makeText(this, "Не меняем", Toast.LENGTH_SHORT).show();
        }
    }
}
