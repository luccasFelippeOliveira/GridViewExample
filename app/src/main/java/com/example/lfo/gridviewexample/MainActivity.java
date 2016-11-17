package com.example.lfo.gridviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GradeItemView grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade = (GradeItemView) findViewById(R.id.grade_item);
        Log.d("onCreate", "grade res = " + grade);
        grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Clicked", "Help");
            }
        });

    }
    public void gradeItemClicked(View v) {
        Log.d("MyApp", "gradeItemClicked");
    }
}
