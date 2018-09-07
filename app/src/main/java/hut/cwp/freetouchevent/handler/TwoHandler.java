package hut.cwp.freetouchevent.handler;

import android.util.Log;
import android.view.MotionEvent;

import hut.cwp.freetouchevent.fragment.IOnClick;

public class TwoHandler extends AbstractEventHandler <IOnClick> {

    private static final String TAG = "TwoHandler";

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent: ev -> " + ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                mView.singleClick();
                break;
            default:
                break;
        }
        return false;
    }

}
