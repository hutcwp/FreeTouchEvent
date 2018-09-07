package hut.cwp.freetouchevent.handler;

import android.util.Log;
import android.view.MotionEvent;


public abstract class AbstractEventHandler <View>{

    private static final String TAG = "AbstractEventHandler";
    private AbstractEventHandler nextHandler = null;

    protected View mView;

    public void bindView(View mView) {
        this.mView = mView;
    }

    public void setNextHandler(AbstractEventHandler handler) {
        this.nextHandler = handler;
    }

    public boolean dispatchEvent(MotionEvent ev) throws Exception {
        if (mView == null) {
            throw new Exception("View 不能为空");
        }

        if (!intercepteEvent()) {
            Log.d(TAG, "分发给下一个处理者");
            return nextHandler.dispatchEvent(ev);
        }

        if(!onTouchEvent(ev)) {
            if (nextHandler == null) {
                Log.d(TAG, "nextHandler == null 事件传递终止");
                return false;
            }
            return nextHandler.dispatchEvent(ev);
        }else{
            Log.d(TAG, "自己处理，事件传递终结");
        }

       return false;
    }

    public boolean intercepteEvent() {
        return true;
    }

    public abstract boolean onTouchEvent(MotionEvent ev) ;
}
