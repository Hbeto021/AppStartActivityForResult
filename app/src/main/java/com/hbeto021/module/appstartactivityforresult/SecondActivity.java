package com.hbeto021.module.appstartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText edtTypedValued = findViewById(R.id.edit_text_typed_value);

        Button btnSubmit = findViewById(R.id.button_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtTypedValued.getText().toString().trim().isEmpty()){
                    setResult(edtTypedValued.getText().toString());

                } else {
                    Toast.makeText(SecondActivity.this, "Type something!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setResult(String textTyped) {
        Intent intent = new Intent();
        intent.putExtra(AppCodes.TYPED_VALUE, textTyped);
        setResult(AppCodes.RESULT_CODE, intent);
        finish();
    }

}
