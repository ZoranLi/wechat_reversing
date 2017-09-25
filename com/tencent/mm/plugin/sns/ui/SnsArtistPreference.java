package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private MMActivity fCi;
    private String mTitle;
    private String piN;
    private int piO;
    private int piP;
    private TextView qyT;
    String qyU;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fCi = (MMActivity) context;
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.mTitle = "";
        this.piO = -1;
        this.piP = 8;
        this.qyT = null;
        this.qyU = "";
        this.fCi = (MMActivity) context;
        setLayoutResource(g.diC);
        setWidgetLayoutResource(g.djm);
    }

    public final void bjL() {
        if (this.qyT != null && this.qyU != null && !this.qyU.equals("") && this.fCi != null) {
            this.qyT.setText(this.fCi.getString(j.pJY, new Object[]{this.qyU}));
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.mTitle = this.fCi.getString(j.pJZ);
        layoutInflater.inflate(g.pGL, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.qyT = (TextView) view.findViewById(f.pBL);
        ((TextView) view.findViewById(f.bon)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(f.cHL);
        if (textView != null) {
            textView.setVisibility(this.piP);
            textView.setText(this.piN);
            if (this.piO != -1) {
                textView.setBackgroundDrawable(a.a(this.fCi, this.piO));
            }
        }
        bjL();
    }
}
