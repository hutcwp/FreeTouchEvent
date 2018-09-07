package hut.cwp.freetouchevent;

import androidx.appcompat.app.AppCompatActivity;
import hut.cwp.freetouchevent.fragment.OneFragment;
import hut.cwp.freetouchevent.fragment.ThreeFragment;
import hut.cwp.freetouchevent.fragment.TwoFragment;
import hut.cwp.freetouchevent.handler.AbstractEventHandler;
import hut.cwp.freetouchevent.handler.OneHandler;
import hut.cwp.freetouchevent.handler.ThreeHandler;
import hut.cwp.freetouchevent.handler.TwoHandler;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private OneHandler handler1;
    private TwoHandler handler2;
    private ThreeHandler handler3;

    private OneFragment oneFragment = new OneFragment();
    private TwoFragment twoFragment = new TwoFragment();
    private ThreeFragment threeFragment = new ThreeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        initHandler();

    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_one, oneFragment)
                .replace(R.id.fragment_two, twoFragment)
                .replace(R.id.fragment_three, threeFragment)
                .commitAllowingStateLoss();
    }

    private void initHandler() {
        handler1 = new OneHandler();
        handler2 = new TwoHandler();
        handler3 = new ThreeHandler();
        handler1.bindView(oneFragment);
        handler2.bindView(twoFragment);
        handler3.bindView(threeFragment);
        handler1.setNextHandler(handler3);
        handler3.setNextHandler(handler2);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return handler1.dispatchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
