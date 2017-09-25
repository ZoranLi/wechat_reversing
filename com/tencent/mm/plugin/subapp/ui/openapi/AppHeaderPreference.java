package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class AppHeaderPreference extends Preference {
    boolean fYd = false;
    private ImageView ioV;
    private TextView ipa;
    private TextView iuH;
    private TextView ovh;
    private boolean ovj = false;
    a qUo;

    public interface a {
        String bnd();

        Bitmap bne();

        String getHint();

        String hT(boolean z);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.ioV = (ImageView) view.findViewById(R.h.bEX);
        this.ipa = (TextView) view.findViewById(R.h.bFK);
        this.ovh = (TextView) view.findViewById(R.h.bFu);
        this.iuH = (TextView) view.findViewById(R.h.bFh);
        this.ovj = true;
        if (!this.ovj || this.qUo == null) {
            w.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.ovj);
        } else {
            Bitmap bne = this.qUo.bne();
            if (!(this.ioV == null || bne == null || bne.isRecycled())) {
                this.ioV.setImageBitmap(bne);
            }
            CharSequence bnd = this.qUo.bnd();
            if (!(this.ovh == null || bnd == null || bnd.length() <= 0)) {
                this.ovh.setText(bnd);
            }
            bnd = this.qUo.getHint();
            if (bnd != null) {
                this.iuH.setText(bnd);
                this.iuH.setVisibility(0);
            } else {
                this.iuH.setVisibility(8);
            }
            boolean z = this.fYd;
            if (this.ipa != null) {
                CharSequence hT = this.qUo.hT(z);
                if (z) {
                    if (hT == null || hT.length() <= 0) {
                        this.ipa.setVisibility(8);
                    } else {
                        this.ipa.setTextColor(r.fe(this.mContext));
                        this.ipa.setText(hT);
                        this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkm, 0, 0, 0);
                    }
                } else if (hT == null || hT.length() <= 0) {
                    this.ipa.setVisibility(8);
                } else {
                    this.ipa.setTextColor(r.ff(this.mContext));
                    this.ipa.setText(hT);
                    this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkl, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
    }
}
