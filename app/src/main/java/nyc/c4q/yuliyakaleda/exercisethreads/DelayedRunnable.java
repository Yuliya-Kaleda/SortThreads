package nyc.c4q.yuliyakaleda.exercisethreads;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by July on 6/16/15.
 */
public class DelayedRunnable implements Runnable{

    protected long delay;
    protected TextView view;

    public DelayedRunnable(int delay, TextView view) {
        this.delay=(long)delay*1000;
        this.view = view;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        view.post(new Runnable() {
            @Override
            public void run() {
                view.append("" + delay/1000);

            }
        });
    }

}
