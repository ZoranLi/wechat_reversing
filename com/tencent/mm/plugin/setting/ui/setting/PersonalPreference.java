package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String fSe;
    private String gtR;
    Bitmap hqW = null;
    private TextView jZz = null;
    ImageView lMX = null;
    private TextView piH = null;
    int piI = -1;
    String piJ = null;
    private OnClickListener piK;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(R.i.djm);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diQ, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.lMX == null) {
            this.lMX = (ImageView) view.findViewById(R.h.bWV);
        }
        if (this.hqW != null) {
            this.lMX.setImageBitmap(this.hqW);
        } else if (this.piI > 0) {
            this.lMX.setImageResource(this.piI);
        } else if (this.piJ != null) {
            b.a(this.lMX, this.piJ);
        }
        this.lMX.setOnClickListener(this.piK);
        if (!(this.jZz == null || this.fSe == null)) {
            this.jZz.setText(h.b(this.mContext, this.fSe, this.jZz.getTextSize()));
        }
        if (this.piH != null) {
            String str = bg.mA(this.gtR) ? this.username : this.gtR;
            if (bg.mA(this.gtR) && x.QQ(this.username)) {
                this.piH.setVisibility(8);
            }
            this.piH.setText(this.mContext.getString(R.l.dHi) + str);
        }
        super.onBindView(view);
    }
}
