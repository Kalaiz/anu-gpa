package com.example.ANU_GPA;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/*Authorship:Kalai(u6555407)*/

public class GPACalc extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calc);
        final TextView result = findViewById(R.id.resultTextView);
        Button doneButton = findViewById(R.id.doneButton);
        final EditText hd = findViewById(R.id.hdEditText);
        final EditText d =  findViewById(R.id.dEditText);
        final EditText c =  findViewById(R.id.cEditText);
        final EditText p =  findViewById(R.id.pEditText);
        final EditText f =  findViewById(R.id.fEditText);
        final ScrollView scrollView = findViewById(R.id.scrollView);
        final SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                EditText[] numbersOfGrades = new EditText[]{hd, d, c, p, f};
                int[] nGrades = new int[5];
                boolean error=false;
                for (int i = 0; i < 5; i++) {
                    try {
                        nGrades[i] = Integer.parseInt(numbersOfGrades[i].getText().toString());
                    } catch (NumberFormatException n) {
                        error=true;
                        nGrades[i]=0;
                    }
                }

                if(error)
                {Toast.makeText(GPACalc.this, "Note:Your are neglecting some attributes;" +
                        "It's values will be considered as 0.", Toast.LENGTH_SHORT).show();}

                GPA gpa = new GPA(nGrades);
                findViewById(R.id.yourGPAisTextView).setVisibility(View.VISIBLE);
                result.setText(gpa.cgpa +"");
                editor.putFloat("cgpa", gpa.cgpa);
                editor.putInt("numOfTCourses", gpa.numOfTCourses);
                editor.apply();
                result.setVisibility(View.VISIBLE);
                Toast.makeText(GPACalc.this, "Extracted marks", Toast.LENGTH_LONG).show();
                scrollView.fullScroll(View.FOCUS_UP);
            }
        });
    }
}