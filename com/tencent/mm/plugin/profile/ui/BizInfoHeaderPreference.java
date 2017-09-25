package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.modelbiz.l.a.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;

public class BizInfoHeaderPreference extends Preference implements a, b, d.a {
    public MMActivity fCi;
    BizInfo jZc;
    public x jiL;
    private boolean lib = false;
    private TextView nsG;
    private TextView osA;
    public String osB;
    private ImageView osx;
    private ImageView osy;
    private View osz;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        this.lib = false;
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCi = (MMActivity) context;
        this.lib = false;
    }

    public final void onBindView(View view) {
        w.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.nsG = (TextView) view.findViewById(R.h.bFu);
        this.osA = (TextView) view.findViewById(R.h.bFL);
        this.osy = (ImageView) view.findViewById(R.h.btK);
        this.osx = (ImageView) view.findViewById(R.h.bEX);
        this.osz = view.findViewById(R.h.bEY);
        this.lib = true;
        KC();
        super.onBindView(view);
    }

    private boolean aTv() {
        return this.lib && this.jiL != null;
    }

    final void KC() {
        if (aTv()) {
            Bitmap b;
            this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.tK()) + " ", this.nsG.getTextSize()));
            if (this.jZc == null) {
                this.jZc = e.hW(this.jiL.field_username);
            }
            if (this.jZc != null) {
                this.osB = this.jZc.field_brandIconURL;
                b = l.b(this.jZc.field_username, this.jZc.field_brandIconURL, R.g.bhR);
            } else {
                b = com.tencent.mm.x.b.a(this.jiL.field_username, true, -1);
                if (!(b == null || b.isRecycled())) {
                    b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                }
                if (b == null && !TextUtils.isEmpty(this.osB)) {
                    b = l.b(this.jiL.field_username, this.osB, R.g.bhR);
                }
            }
            if (b == null) {
                b = BitmapFactory.decodeResource(this.fCi.getResources(), R.g.bcY);
            }
            if (!(b == null || b.isRecycled())) {
                this.osx.setImageBitmap(b);
            }
            this.osx.setTag(this.jiL.field_username);
            this.osz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BizInfoHeaderPreference osC;

                {
                    this.osC = r1;
                }

                public final void onClick(View view) {
                    new f(this.osC.fCi, this.osC.jiL.field_username, this.osC.osB).bEf();
                }
            });
            if (!com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                this.osA.setVisibility(8);
            } else if (!bg.mA(this.jiL.pA())) {
                this.osA.setVisibility(0);
                this.osA.setText(this.mContext.getString(R.l.dHi) + this.jiL.pA());
            } else if (x.QQ(this.jiL.field_username) || o.eT(this.jiL.field_username)) {
                this.osA.setVisibility(8);
            } else {
                this.osA.setText(this.mContext.getString(R.l.dHi) + bg.mz(this.jiL.tM()));
                this.osA.setVisibility(0);
            }
            if (this.jiL.tC()) {
                this.osy.setVisibility(0);
                return;
            } else {
                this.osy.setVisibility(8);
                return;
            }
        }
        w.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lib + "contact = " + this.jiL);
    }

    public final void onDetach() {
        ap.yY();
        c.wR().b(this);
        n.Bl().e(this);
        com.tencent.mm.modelbiz.w.DP().b(this);
    }

    public final void ho(String str) {
        if (!aTv()) {
            w.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lib + "contact = " + this.jiL);
        } else if (bg.mz(str).length() <= 0) {
            w.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + str);
        } else if (str.equals(this.jiL.field_username)) {
            KC();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (aTv()) {
            String str = (String) obj;
            if (bg.mz(str).length() > 0 && this.jiL != null && this.jiL.field_username.equals(str)) {
                ap.yY();
                this.jiL = c.wR().Rc(str);
            }
        } else {
            w.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lib + "contact = " + this.jiL);
        }
    }

    public final void in(String str) {
        if (this.jiL != null && str != null && str.equals(this.jiL.field_username)) {
            KC();
        }
    }
}
