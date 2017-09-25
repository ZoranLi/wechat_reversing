package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;

public class ConversationOverscrollListView extends ListView implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener, com.tencent.mm.sdk.platformtools.aj.a {
    private static final boolean wcG = d.eq(10);
    private int AT = 0;
    private OnItemClickListener Yi;
    private OnItemSelectedListener Yj;
    private Rect fv = new Rect();
    private aj irQ;
    private c wcH = new c();
    private a wcI;
    private boolean wcJ = false;
    private int wcK = 0;
    private int wcL = 0;
    private float wcM = 0.0f;
    private long wcN = 1;
    private final float wcO = 3.5f;
    private final float wcP = 13.5f;
    private float wcQ = 0.0f;
    private b wcR = new b(this);
    private final int wcS = 50;
    private OnItemLongClickListener wcT;

    public interface a {
        boolean bYz();
    }

    public class b implements Runnable {
        final /* synthetic */ ConversationOverscrollListView wcU;

        public b(ConversationOverscrollListView conversationOverscrollListView) {
            this.wcU = conversationOverscrollListView;
        }

        public final void run() {
            if (this.wcU.wcI != null && !this.wcU.wcI.bYz()) {
                w.d("MicroMsg.ConversationOverscrollListView", "jacks cancel to Show Main");
                this.wcU.wcI;
            }
        }
    }

    private static class c implements Interpolator {
        private float oIj = 1.3f;

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            f2 = (((f2 * (this.oIj + 1.0f)) + this.oIj) * (f2 * f2)) + 1.0f;
            if (f2 > 1.0f) {
                return 1.0f;
            }
            return f2;
        }
    }

    public ConversationOverscrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        this.irQ = new aj(this, false);
    }

    @TargetApi(11)
    protected void onFinishInflate() {
    }

    @TargetApi(11)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.Yi = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.wcT = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Yj = onItemSelectedListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.wcJ = true;
        if (this.Yi != null) {
            this.Yi.onItemClick(adapterView, view, i, j);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.wcJ = true;
        if (this.Yj != null) {
            this.Yj.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        if (this.Yj != null) {
            this.Yj.onNothingSelected(adapterView);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.wcJ = true;
        if (this.wcT != null) {
            return this.wcT.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }

    public final boolean oQ() {
        return false;
    }
}
