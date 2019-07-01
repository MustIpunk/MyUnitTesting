package com.example.saiful.myunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {

    EditText edtWidth, edtLength, edtHeight;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        edtHeight = findViewById(R.id.edt_height);
        tvResult = findViewById(R.id.tv_result);
        Button btnCalculate = findViewById(R.id.btn_calculate);

        final MainPresenter presenter = new MainPresenter(this);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = edtLength.getText().toString().trim();
                String width = edtWidth.getText().toString().trim();
                String height = edtHeight.getText().toString().trim();

                boolean isEmptyFileds = false;

                if (TextUtils.isEmpty(length)) {
                    isEmptyFileds = true;
                    edtLength.setError("Harus di isi bro....");
                }

                if (TextUtils.isEmpty(width)) {
                    isEmptyFileds = true;
                    edtWidth.setError("Harus di isi bro....");
                }

                if (TextUtils.isEmpty(height)) {
                    isEmptyFileds = true;
                    edtHeight.setError("Harus di isi bro....");
                }

                if(!isEmptyFileds){
                    double l = Double.parseDouble(length);
                    double w = Double.parseDouble(width);
                    double h = Double.parseDouble(height);

                    presenter.calculateVolume(l, w, h);

                }

            }
        });

    }

    @Override
    public void showVolume(MainModel model) {
        tvResult.setText(String.valueOf(model.getVolume()));

    }
}
