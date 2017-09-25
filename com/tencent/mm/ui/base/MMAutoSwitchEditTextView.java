package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int kIv = 100;
    private Context mContext;
    private int mScreenWidth;
    private int naA;
    private int viI;
    private int viJ;
    private String viK;
    public ArrayList<MMAutoSwitchEditText> viL = new ArrayList();
    private c viM = new c(this);
    public a viN;
    public b viO;

    public interface a {
        void SL(String str);
    }

    public interface b {
        void bQJ();
    }

    private class c implements com.tencent.mm.ui.base.MMAutoSwitchEditText.b, com.tencent.mm.ui.base.MMAutoSwitchEditText.c, d {
        final /* synthetic */ MMAutoSwitchEditTextView viP;

        public c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView) {
            this.viP = mMAutoSwitchEditTextView;
        }

        public final void Ac(int i) {
            String str = "";
            Iterator it = this.viP.viL.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bg.mA(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (bg.mA(str) || str.length() != this.viP.viI * this.viP.naA) {
                if (this.viP.viO != null) {
                    this.viP.viO.bQJ();
                }
                if (this.viP.viL != null && i < this.viP.viL.size() - 1) {
                    mMAutoSwitchEditText = (MMAutoSwitchEditText) this.viP.viL.get(i + 1);
                    if (mMAutoSwitchEditText != null) {
                        mMAutoSwitchEditText.requestFocus();
                    }
                }
            } else if (this.viP.viN != null) {
                this.viP.viN.SL(str);
            }
        }

        public final void Ab(int i) {
            if (this.viP.viL != null && i < this.viP.viL.size() && i != 0) {
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) this.viP.viL.get(i - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
        }

        public final void bRO() {
            String str = "";
            Iterator it = this.viP.viL.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bg.mA(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (this.viP.viO != null) {
                this.viP.viO.bQJ();
            }
        }
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fpi);
        this.viI = obtainStyledAttributes.getInteger(m.hfy, 3);
        this.naA = obtainStyledAttributes.getInteger(m.hfB, 4);
        this.viJ = obtainStyledAttributes.getInteger(m.hfA, 2);
        int resourceId = obtainStyledAttributes.getResourceId(m.hfz, 0);
        if (resourceId != 0) {
            this.viK = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.kIv = ((this.mScreenWidth - 80) - ((this.viI - 1) * 20)) / this.viI;
        }
        setPadding(com.tencent.mm.bg.a.fromDPToPix(context, 20), 0, com.tencent.mm.bg.a.fromDPToPix(context, 20), 0);
        bRP();
    }

    private void bRP() {
        for (int i = 0; i < this.viI; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, h.hdK, null);
            mMAutoSwitchEditText.setInputType(this.viJ);
            if (this.viK != null && this.viK.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.viK));
            }
            mMAutoSwitchEditText.viD.mIndex = i;
            mMAutoSwitchEditText.viD.viH = this.naA;
            mMAutoSwitchEditText.viD.viE = this.viM;
            mMAutoSwitchEditText.viD.viF = this.viM;
            mMAutoSwitchEditText.viD.viG = this.viM;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kIv, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.viL.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
    }
}
