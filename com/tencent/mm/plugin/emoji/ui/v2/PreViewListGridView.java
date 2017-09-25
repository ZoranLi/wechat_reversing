package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ae;

public class PreViewListGridView extends ListView {
    private int Xd;
    private WindowManager kSs;
    private PopEmojiView kVL;
    private LayoutParams kVM;
    private int kVN;
    private int kVO;
    private boolean kVP;
    private boolean kZC = true;
    private int kZI;
    private volatile int kZJ = -1;
    private String kZK;
    private d kZL;
    private ae mHandler = new ae();

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.kVL = new PopEmojiView(getContext());
        this.kZI = context.getResources().getDimensionPixelSize(R.f.aZN);
        this.kSs = (WindowManager) context.getSystemService("window");
        this.kVM = new LayoutParams(-1, -1, 2, 8, 1);
        this.kVM.width = this.kZI;
        this.kVM.height = this.kZI;
        this.kVM.gravity = 17;
        this.Xd = getResources().getConfiguration().orientation;
        if (this.Xd == 2) {
            this.kVN = this.kSs.getDefaultDisplay().getHeight();
            this.kVO = this.kSs.getDefaultDisplay().getWidth();
            return;
        }
        this.kVN = this.kSs.getDefaultDisplay().getWidth();
        this.kVO = this.kSs.getDefaultDisplay().getHeight();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.kZL = (d) listAdapter;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.kVP) {
                    aoJ();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void aoJ() {
        if (this.kVP) {
            this.kSs.removeView(this.kVL);
            this.kVP = false;
        }
        this.kZK = "";
    }
}
