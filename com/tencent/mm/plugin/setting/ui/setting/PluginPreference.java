package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;

public final class PluginPreference extends Preference implements a {
    private MMActivity fCi;
    private ImageView hBi;
    int lAi;
    String piL;
    String piM;
    private String piN;
    private int piO;
    private int piP;
    boolean piQ;

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.piO = -1;
        this.piP = 8;
        this.piQ = false;
        this.hBi = null;
        this.lAi = 255;
        this.fCi = (MMActivity) context;
        setLayoutResource(R.i.diC);
        n.Bl().a(this);
    }

    public final boolean Eb(String str) {
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            w.e("MicroMsg.PluginPreference", "plugin do not exist");
            return false;
        }
        this.piL = Rc.field_username;
        this.piM = Rc.tK();
        setKey("settings_plugins_list_#" + this.piL);
        return true;
    }

    public final void aXo() {
        if (this.hBi != null) {
            b.a(this.hBi, this.piL);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diR, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hBi = (ImageView) view.findViewById(R.h.bWV);
        this.hBi.setAlpha(this.lAi);
        TextView textView = (TextView) view.findViewById(R.h.cHL);
        if (textView != null) {
            textView.setVisibility(this.piP);
            textView.setText(this.piN);
            if (this.piO != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.fCi, this.piO));
            }
        }
        ((TextView) view.findViewById(R.h.cne)).setVisibility(this.piQ ? 0 : 8);
        aXo();
    }

    public final void ho(String str) {
        if (this.piL != null && this.piL.equals(str)) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ PluginPreference piR;

                {
                    this.piR = r1;
                }

                public final void run() {
                    this.piR.aXo();
                }
            });
        }
    }
}
