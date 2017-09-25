package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private ImageView ioV;
    private TextView ipa;
    private TextView iuH;
    private x jiL;
    private TextView ovh;
    private a ovi;
    private boolean ovj = false;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.ioV = (ImageView) view.findViewById(R.h.bEX);
        this.ipa = (TextView) view.findViewById(R.h.bFK);
        this.ovh = (TextView) view.findViewById(R.h.bFu);
        this.iuH = (TextView) view.findViewById(R.h.bFh);
        this.ovj = true;
        KC();
        super.onBindView(view);
    }

    public final void gm(boolean z) {
        if (this.ovi != null) {
            if (z) {
                this.ipa.setTextColor(r.fe(this.mContext));
                this.ipa.setText(R.l.eTC);
                this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkm, 0, 0, 0);
                return;
            }
            this.ipa.setTextColor(r.ff(this.mContext));
            this.ipa.setText(R.l.eTJ);
            this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkl, 0, 0, 0);
        }
    }

    private void KC() {
        if (!this.ovj || this.jiL == null) {
            w.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.ovj + "contact = " + this.jiL);
            return;
        }
        String str = this.jiL.field_username;
        w.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + str);
        if (this.ioV != null && this.jiL.field_username.equals(str)) {
            b.a(this.ioV, str);
        }
        if (this.ovh != null) {
            this.ovh.setText(this.jiL.tK());
        }
        if (this.ovi != null) {
            this.ovi.a(this);
            CharSequence hint = this.ovi.getHint();
            if (hint != null) {
                this.iuH.setText(hint);
                this.iuH.setVisibility(0);
                return;
            }
            this.iuH.setVisibility(8);
        }
    }

    public final void a(x xVar, a aVar) {
        Assert.assertTrue(xVar != null);
        this.jiL = xVar;
        this.ovi = aVar;
        KC();
    }
}
