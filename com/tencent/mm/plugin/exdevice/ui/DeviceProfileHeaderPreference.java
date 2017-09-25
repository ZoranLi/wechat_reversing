package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    protected MMActivity iwk;
    private String jUR;
    private ImageView lhR;
    private TextView lhS;
    private TextView lhT;
    private TextView lhU;
    private View lhV;
    TextView lhW;
    private boolean[] lhX;
    private OnClickListener[] lhY;
    String lhZ;
    private String lia;
    private boolean lib;
    private CharSequence vn;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lhX = new boolean[6];
        this.lhY = new OnClickListener[6];
        this.lib = false;
        this.iwk = (MMActivity) context;
        this.lib = false;
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lhX = new boolean[6];
        this.lhY = new OnClickListener[6];
        this.lib = false;
        this.iwk = (MMActivity) context;
        this.lib = false;
    }

    public final void onBindView(View view) {
        w.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.lhR = (ImageView) view.findViewById(R.h.bqH);
        this.lhS = (TextView) view.findViewById(R.h.cml);
        this.lhT = (TextView) view.findViewById(R.h.bKG);
        this.lhU = (TextView) view.findViewById(R.h.bIS);
        this.lhV = view.findViewById(R.h.bKH);
        this.lhW = (TextView) view.findViewById(R.h.bIR);
        w(this.lhR, 0);
        w(this.lhS, 2);
        w(this.lhT, 1);
        w(this.lhU, 3);
        w(this.lhV, 4);
        w(this.lhW, 5);
        this.lib = true;
        if (this.lib) {
            this.lhS.setText(this.vn);
            this.lhU.setText(this.jUR);
            this.lhW.setText(this.lhZ);
            cy(this.lia);
        } else {
            w.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lib);
        }
        super.onBindView(view);
    }

    private void w(View view, int i) {
        view.setVisibility(this.lhX[i] ? 8 : 0);
        view.setOnClickListener(this.lhY[i]);
    }

    public final void E(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        switch (i) {
            case 0:
                view = this.lhR;
                break;
            case 1:
                view = this.lhT;
                break;
            case 2:
                view = this.lhS;
                break;
            case 3:
                view = this.lhU;
                break;
            case 4:
                view = this.lhV;
                break;
            case 5:
                view = this.lhW;
                break;
            default:
                return;
        }
        boolean[] zArr = this.lhX;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        switch (i) {
            case 0:
                view = this.lhR;
                break;
            case 1:
                view = this.lhT;
                break;
            case 2:
                view = this.lhS;
                break;
            case 3:
                view = this.lhU;
                break;
            case 4:
                view = this.lhV;
                break;
            case 5:
                view = this.lhW;
                break;
            default:
                return;
        }
        this.lhY[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setName(CharSequence charSequence) {
        this.vn = charSequence;
        if (this.lhS != null) {
            this.lhS.setText(charSequence);
        }
    }

    public final void vm(String str) {
        this.jUR = str;
        if (this.lhU != null) {
            this.lhU.setText(str);
        }
    }

    public final void cy(String str) {
        this.lia = str;
        if (this.lhR != null) {
            a aVar = new a();
            Bitmap yp = d.yp(R.g.beX);
            if (!(yp == null || yp.isRecycled())) {
                yp = d.a(yp, true, 0.5f * ((float) yp.getWidth()));
                if (!(yp == null || yp.isRecycled())) {
                    aVar.hJb = new BitmapDrawable(yp);
                }
            }
            if (yp == null || yp.isRecycled()) {
                aVar.hJa = R.g.beX;
            }
            aVar.hJi = true;
            n.GW().a(this.lia, this.lhR, aVar.Hg());
        }
    }
}
