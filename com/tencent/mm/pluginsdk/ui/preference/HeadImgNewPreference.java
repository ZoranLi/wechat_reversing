package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    private int height;
    public ImageView jki;
    public OnClickListener sAw;
    private View sNP;
    private TextView sSh;
    public String sSi;
    public boolean sSj;
    private boolean sSk;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        this.sSj = false;
        this.sSk = false;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        if (this.sSk) {
            View.inflate(this.mContext, R.i.djF, viewGroup2);
        } else {
            View.inflate(this.mContext, R.i.diK, viewGroup2);
        }
        this.jki = (ImageView) onCreateView.findViewById(R.h.bWS);
        this.sSh = (TextView) onCreateView.findViewById(R.h.com);
        this.sNP = onCreateView.findViewById(R.h.ciQ);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jki == null) {
            this.jki = (ImageView) view.findViewById(R.h.bWS);
        }
        if (this.sSh == null) {
            this.sSh = (TextView) view.findViewById(R.h.com);
        }
        if (this.sNP == null) {
            this.sNP = view.findViewById(R.h.ciQ);
        }
        if (this.sAw != null) {
            this.sNP.setOnClickListener(this.sAw);
        }
        if (this.sSi != null) {
            b.a(this.jki, this.sSi);
            this.sSi = null;
        }
        if (this.sSj) {
            this.sSh.setVisibility(8);
            this.sNP.setVisibility(0);
        } else {
            this.sNP.setVisibility(8);
            this.sSh.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.h.ckj);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
    }
}
