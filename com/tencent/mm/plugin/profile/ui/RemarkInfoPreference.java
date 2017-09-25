package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity fCi;
    private TextView ioX;
    private ImageView jla;
    private String muI;
    private TextView ouW;
    private boolean owg = false;
    private String title;

    public final /* synthetic */ CharSequence getSummary() {
        return this.ouW.getText().toString();
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(R.i.djm);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diU, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ioX = (TextView) view.findViewById(R.h.title);
        this.ouW = (TextView) view.findViewById(R.h.summary);
        this.jla = (ImageView) view.findViewById(R.h.bWV);
        if (this.owg) {
            this.jla.setVisibility(0);
        } else {
            this.jla.setVisibility(8);
        }
        if (this.ioX != null) {
            this.ioX.setText(this.title);
        }
        if (this.ouW != null) {
            this.ouW.setText(this.muI);
        }
        super.onBindView(view);
    }
}
