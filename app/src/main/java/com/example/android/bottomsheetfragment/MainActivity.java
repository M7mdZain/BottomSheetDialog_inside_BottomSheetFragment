package com.example.android.bottomsheetfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AddPhotoBottomDialogFragment mBottomDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mBottomDialogFragment = AddPhotoBottomDialogFragment.newInstance();

        mBottomDialogFragment.show(getSupportFragmentManager(),
                mBottomDialogFragment.getTag());

        Button bt = findViewById(R.id.btn_show_bottomsheet);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomDialogFragment.show(getSupportFragmentManager(),
                        mBottomDialogFragment.getTag());
            }
        });

    }

}
