package ink.unkindleds.imagespansample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ink.unkindleds.imagespansample.basic.BasicImageSpanActivity;
import ink.unkindleds.imagespansample.custom.CustomImageSpanActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View basic = findViewById(R.id.basic);
        View custom = findViewById(R.id.custom);
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicImageSpanActivity.class);
                startActivity(intent);
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomImageSpanActivity.class);
                startActivity(intent);
            }
        });
    }
}
