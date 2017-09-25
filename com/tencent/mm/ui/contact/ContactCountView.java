package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;

public class ContactCountView extends FrameLayout {
    private int count = 0;
    private View lmQ;
    private TextView mSJ;
    int vWC = 1;
    private boolean visible = true;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ContactCountView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.i.cZt, this);
    }

    protected void onMeasure(int i, int i2) {
        w.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.lmQ == null) {
            this.lmQ = (FrameLayout) findViewById(R.h.bES);
            this.mSJ = (TextView) findViewById(R.h.bER);
        }
        bXO();
        super.onMeasure(i, i2);
    }

    public final void bXO() {
        String[] strArr = o.hly;
        if (this.vWC == 1) {
            ap.yY();
            this.count = c.wR().b(strArr, m.xL(), "weixin", "helper_entry", "filehelper");
        } else {
            ap.yY();
            this.count = c.wR().c(strArr, m.xL(), "weixin", "helper_entry", "filehelper");
        }
        w.d("MicroMsg.ContactCountView", "contact count %d", Integer.valueOf(this.count));
        if (this.mSJ != null) {
            if (this.vWC == 1) {
                this.mSJ.setText(getContext().getResources().getQuantityString(R.j.dsg, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.mSJ.setText(getContext().getResources().getQuantityString(R.j.dsf, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.visible);
    }

    public final void setVisible(boolean z) {
        this.visible = z;
        if (this.lmQ != null) {
            View view = this.lmQ;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
    }
}
