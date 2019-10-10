package com.hbeto021.module.appstartactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvReceivedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvReceivedValue = findViewById(R.id.text_view_received_value);

        Button btnStarActivity =  findViewById(R.id.button_start_activity);
        btnStarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, AppCodes.REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == AppCodes.REQUEST_CODE) {
            if(resultCode == AppCodes.RESULT_CODE) {
                assert data != null;
                tvReceivedValue.setText(data.getStringExtra(AppCodes.TYPED_VALUE));
            }
        }
    }
}
