package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private Context context;
    private String fJz;
    private String fVJ;
    private ae handler = new ae(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean pQJ = false;
    private int qpI = 0;
    protected TextView qqA;
    private String qqB;
    private String qqC;
    private HashMap<String, Integer> qqD;
    private Runnable qqE = new Runnable(this) {
        final /* synthetic */ CollapsibleTextView qqF;

        {
            this.qqF = r1;
        }

        public final void run() {
            if (this.qqF.qqy != null && (this.qqF.qqy.getTag() instanceof ar) && ((ar) this.qqF.qqy.getTag()).fVJ.equals(this.qqF.fVJ)) {
                this.qqF.qqy.setMaxLines(6);
                this.qqF.qqA.setVisibility(0);
                this.qqF.qqA.setText(this.qqF.qqB);
            }
        }
    };
    protected SnsPostDescPreloadTextView qqy;
    protected SnsTextView qqz;
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.qqB = this.context.getString(j.pKG);
        this.qqC = this.context.getString(j.pKF);
        View inflate = r.eC(this.context).inflate(g.pGG, this);
        inflate.setPadding(0, -3, 0, 0);
        this.qqy = (SnsPostDescPreloadTextView) inflate.findViewById(f.bIb);
        this.qqA = (TextView) inflate.findViewById(f.hck);
        this.qqz = (SnsTextView) inflate.findViewById(f.pCp);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, au auVar, String str3, boolean z) {
        this.context = auVar.fCi;
        this.qqD = hashMap;
        this.text = charSequence;
        this.pQJ = z;
        this.fJz = str;
        this.fVJ = str2;
        this.qpI = i;
        this.qqB = this.context.getString(j.pKG);
        this.qqC = this.context.getString(j.pKF);
        this.qqz.neH = str3;
        ar arVar = new ar(this.fVJ, this.fJz, false, false, 1);
        if (i == 0) {
            this.qqy.setText(str3);
            this.qqz.setVisibility(8);
            this.qqA.setVisibility(0);
            this.qqy.setVisibility(0);
            this.qqy.setOnTouchListener(new k(this.context));
            this.qqy.setTag(arVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.qqA.setVisibility(8);
                this.qqy.setMaxLines(7);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.qqA.setVisibility(8);
                    return;
                case 1:
                    this.qqy.setMaxLines(6);
                    this.qqA.setVisibility(0);
                    this.qqA.setText(this.qqB);
                    return;
                case 2:
                    this.qqy.setMaxLines(Integer.MAX_VALUE);
                    this.qqA.setVisibility(0);
                    this.qqA.setText(this.qqC);
                    return;
                default:
                    return;
            }
        }
        this.qqz.setText(charSequence, bufferType);
        this.qqz.setTag(arVar);
        this.qqz.setVisibility(0);
        this.qqA.setVisibility(8);
        this.qqy.setVisibility(8);
        this.qqz.setOnClickListener(auVar.pZk.qNK);
    }

    public final int bip() {
        w.i("MicroMsg.CollapsibleTextView", "count:" + this.qqy.getLineCount() + "  height:" + this.qqy.getLineHeight());
        return (this.qqy.getLineCount() - 6) * this.qqy.getLineHeight();
    }

    public final void e(OnClickListener onClickListener) {
        if (this.qqA != null) {
            this.qqA.setOnClickListener(onClickListener);
        }
    }

    public void setLongClickable(boolean z) {
        this.qqA.setLongClickable(z);
        this.qqz.setLongClickable(z);
        this.qqy.setLongClickable(z);
        super.setLongClickable(z);
    }

    public void setClickable(boolean z) {
        this.qqA.setClickable(z);
        this.qqz.setClickable(z);
        this.qqy.setClickable(z);
        super.setClickable(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.qpI == 0 && !this.pQJ && !this.hasCheck) {
            this.hasCheck = true;
            if (this.qqy.getLineCount() <= 6) {
                this.qqD.put(this.fJz, Integer.valueOf(0));
                return;
            }
            this.qqD.put(this.fJz, Integer.valueOf(1));
            this.handler.post(this.qqE);
        }
    }
}
