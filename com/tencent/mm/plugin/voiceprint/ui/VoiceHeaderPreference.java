package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity fCi;
    private TextView ioX;
    private TextView itX;
    private ImageView jla;
    private int lAi;
    private Button lAj;
    private View lAk;
    private OnClickListener lAl;
    private String lAm;
    private String lAn;
    private String mTitle;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fCi = (MMActivity) context;
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.lAi = 255;
        this.lAl = null;
        this.lAm = "";
        this.lAn = "";
        this.fCi = (MMActivity) context;
        setLayoutResource(R.i.dpF);
    }

    public final void ca(String str, String str2) {
        this.lAm = str;
        this.lAn = str2;
        if (this.ioX != null) {
            if (bg.mA(this.lAm)) {
                this.ioX.setVisibility(8);
            } else {
                this.ioX.setText(this.lAm);
                this.ioX.setVisibility(0);
            }
        }
        if (this.itX == null) {
            return;
        }
        if (bg.mA(this.lAn)) {
            this.itX.setVisibility(8);
            return;
        }
        this.itX.setText(this.lAn);
        this.itX.setVisibility(0);
    }

    public final void a(OnClickListener onClickListener) {
        this.lAl = onClickListener;
        if (this.lAj != null && this.lAk != null) {
            if (this.lAj == null || this.lAl == null) {
                this.lAj.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            }
            this.lAj.setOnClickListener(onClickListener);
            this.lAj.setVisibility(0);
            this.lAk.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jla = (ImageView) view.findViewById(R.h.cNh);
        this.ioX = (TextView) view.findViewById(R.h.cNi);
        this.itX = (TextView) view.findViewById(R.h.cNk);
        this.lAj = (Button) view.findViewById(R.h.cyU);
        this.lAk = view.findViewById(R.h.bvE);
        if (bg.mA(this.lAm)) {
            this.ioX.setVisibility(8);
        } else {
            this.ioX.setText(this.lAm);
            this.ioX.setVisibility(0);
        }
        if (bg.mA(this.lAn)) {
            this.itX.setVisibility(8);
        } else {
            this.itX.setText(this.lAn);
            this.itX.setVisibility(0);
        }
        if (this.lAj == null || this.lAl == null) {
            this.lAj.setVisibility(8);
            this.lAk.setVisibility(8);
            return;
        }
        this.lAj.setOnClickListener(this.lAl);
        this.lAj.setVisibility(0);
        this.lAk.setVisibility(0);
    }
}
