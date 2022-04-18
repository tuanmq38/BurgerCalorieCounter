package com.example.burgercaloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.burgercaloriecounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int totalCalories = 220;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                binding.textViewCalories.setText(String.valueOf(totalCalories + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rbBeef:
                if (checked)
                    totalCalories = 120;
                break;
            case R.id.rbLamb:
                if (checked)
                    totalCalories = 190;
                break;
            case R.id.rbOstrich:
                if (checked)
                    totalCalories = 170;
                break;
        }
        binding.textViewCalories.setText(String.valueOf(totalCalories));
    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            totalCalories += 125;
        } else {
            totalCalories -= 125;
        }
//        binding.textViewCalories.setText(String.valueOf(totalCalories));
    }


    public void onRadioButtonClicked2(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            switch (view.getId()) {
                case R.id.rbAsiagoCheese:
                    totalCalories += 100;
                    break;
                case R.id.rbCreme:
                    totalCalories += 130;
                    break;
            }
        }
        binding.textViewCalories.setText(String.valueOf(totalCalories));
    }
}