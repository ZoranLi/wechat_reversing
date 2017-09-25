package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.ae;

public class MMCallBackScrollView extends ScrollView {
    private ae mHandler = new ae(this) {
        final /* synthetic */ MMCallBackScrollView oxK;

        {
            this.oxK = r1;
        }

        public final void handleMessage(Message message) {
            int scrollY = this.oxK.getScrollY();
            if (scrollY == this.oxK.oxI) {
                this.oxK.ry(0);
                return;
            }
            this.oxK.oxI = scrollY;
            this.oxK.mHandler.sendMessageDelayed(this.oxK.mHandler.obtainMessage(), 5);
            this.oxK.ry(1);
        }
    };
    private int mState = 0;
    private int oxI;
    public a oxJ;

    public interface a {
        void bi(int i);
    }

    private void ry(int i) {
        if (this.oxJ != null && this.mState != i) {
            this.mState = i;
            this.oxJ.bi(i);
        }
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.oxI = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                ry(1);
                break;
        }
        return onTouchEvent;
    }
}
