package nyc.c4q.yuliyakaleda.exercisethreads;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText userInput;
    private TextView result;
    private Button sort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.user_input);
        result = (TextView) findViewById(R.id.result);
        sort = (Button) findViewById(R.id.sort);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = userInput.getText().toString();
                String[] strNumbers = str.split(" ");
                int largest = 0;
                for(String currentNum : strNumbers){
                    int seconds = Integer.parseInt(currentNum);
                    if (seconds > largest) {
                        largest =seconds;
                    }
                    Thread myThread = new Thread(new DelayedRunnable(seconds, result));
                    myThread.start();
                }

                long delay =(long) largest*1000;
                sort.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_SHORT).show();
                    }
                },delay);
            }
        });
    }
}
