package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String sJG;
    public String sJH;
    public String[] sJI;
    private LinearLayout sJJ;
    private boolean sJK = false;
    public a sJL;

    public interface a {
        void adZ();

        void bEu();
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aTQ() {
        return R.i.dlo;
    }

    public final void init() {
        this.sJJ = (LinearLayout) findViewById(R.h.cgQ);
    }

    public void clearFocus() {
        for (int i = 1; i < this.sJJ.getChildCount(); i++) {
            this.sJJ.getChildAt(i).clearFocus();
        }
    }

    public final boolean L(x xVar) {
        this.kWy = xVar;
        return true;
    }

    public final boolean aTR() {
        int i;
        int i2;
        if (bg.mA(this.sJG)) {
            i = 0;
            i2 = 0;
        } else {
            aL(this.sJG, true);
            i = 1;
            i2 = 1;
        }
        if (!bg.mA(this.sJH)) {
            this.sJI = this.sJH.split(",");
            while (i2 < this.sJI.length + i) {
                aL(this.sJI[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            aL(null, false);
            this.sJK = false;
        } else {
            this.sJK = true;
        }
        return false;
    }

    public final ArrayList<String> bEs() {
        int childCount = this.sJJ.getChildCount();
        if (childCount == 1) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.sJJ.getChildAt(i)).getText().toString();
            if (!bg.mA(obj)) {
                arrayList.add(obj);
            }
        }
        if (!bg.mA(this.sJG)) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private void bEt() {
        if (this.sJL != null) {
            this.sJL.adZ();
        }
    }

    public final void f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (mMPhoneNumberEditText.sJn) {
            g.a(getContext(), R.l.eso, 0, R.l.esn, R.l.esm, new OnClickListener(this) {
                final /* synthetic */ ProfileEditPhoneNumberView sJN;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sJN.sJG = "";
                    this.sJN.sJL.bEu();
                    this.sJN.h(mMPhoneNumberEditText);
                    if (!this.sJN.sJK) {
                        this.sJN.aL(null, false);
                    }
                }
            }, null);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.sJK) {
            aL(null, false);
            this.sJK = false;
        }
        bEt();
    }

    public final void bEn() {
        bEt();
    }

    public final void bEm() {
        if (this.sJJ.getChildCount() - 1 < 5) {
            aL(null, false);
        } else {
            this.sJK = true;
        }
        bEt();
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (this.sJJ.getChildCount() - 1 != 1) {
            h(mMPhoneNumberEditText);
            if (this.sJK) {
                aL(null, false);
            }
            this.sJK = false;
            bEt();
        }
    }

    private void aL(String str, boolean z) {
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.i.dln, null);
        if (z) {
            mMPhoneNumberEditText.sJn = true;
            mMPhoneNumberEditText.sJl = mMPhoneNumberEditText.getResources().getDrawable(R.k.dxu);
            mMPhoneNumberEditText.sJl.setBounds(0, 0, mMPhoneNumberEditText.sJl.getIntrinsicWidth(), mMPhoneNumberEditText.sJl.getIntrinsicHeight());
            mMPhoneNumberEditText.setFocusable(false);
            mMPhoneNumberEditText.bEk();
        }
        mMPhoneNumberEditText.sJm = this;
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 12), 0, 0);
        this.sJJ.addView(mMPhoneNumberEditText, layoutParams);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.sJJ.removeView(mMPhoneNumberEditText);
        this.sJJ.getChildAt(this.sJJ.getChildCount() - 1).requestFocus();
    }
}
