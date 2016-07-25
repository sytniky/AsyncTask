package edu.hillel.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvText;
    private Button btnStart, btnShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnShowText = (Button) findViewById(R.id.btnShowText);

        btnStart.setOnClickListener(this);
        btnShowText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnShowText) {
            tvText.setText("Abra kadabra");

        } else if (view.getId() == R.id.btnStart) {
            startCalc();
        }
    }

    private void startCalc() {
        MyTask task = new MyTask(this);
        task.execute(10);
    }

    public void setResultText(String str) {
        tvText.setText(str);
    }
}
