package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.R;
import com.tencent.mm.ao.k;
import com.tencent.mm.j.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference extends Preference {
    boolean fOg;
    x kWy;
    boolean kmK = false;
    private boolean ksZ;
    String ktm;
    Context mContext;
    private ToggleButton sTc;
    private ToggleButton sTd;
    private ToggleButton sTe;
    private OnCheckedChangeListener sTf = new OnCheckedChangeListener(this) {
        final /* synthetic */ SpecialCheckBoxPreference sTg;

        {
            this.sTg = r1;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = 0;
            int id = compoundButton.getId();
            SpecialCheckBoxPreference specialCheckBoxPreference;
            if (id == R.h.czh) {
                specialCheckBoxPreference = this.sTg;
                if (specialCheckBoxPreference.kWy != null) {
                    ap.yY();
                    if (c.wW().Rt(specialCheckBoxPreference.kWy.field_username)) {
                        o.m(specialCheckBoxPreference.kWy.field_username, true);
                    } else {
                        o.l(specialCheckBoxPreference.kWy.field_username, true);
                    }
                }
            } else if (id == R.h.czg) {
                SpecialCheckBoxPreference specialCheckBoxPreference2 = this.sTg;
                specialCheckBoxPreference2.kmK = !specialCheckBoxPreference2.kmK;
                if (specialCheckBoxPreference2.fOg) {
                    if (!specialCheckBoxPreference2.kmK) {
                        i = 1;
                    }
                    ap.yY();
                    c.wQ().b(new k(specialCheckBoxPreference2.ktm, i));
                    specialCheckBoxPreference2.kWy.dm(i);
                    ap.yY();
                    c.wR().a(specialCheckBoxPreference2.ktm, specialCheckBoxPreference2.kWy);
                }
                specialCheckBoxPreference2.bGs();
            } else if (id == R.h.czj) {
                specialCheckBoxPreference = this.sTg;
                if (specialCheckBoxPreference.kWy == null) {
                    return;
                }
                if (a.ez(specialCheckBoxPreference.kWy.field_type)) {
                    specialCheckBoxPreference.kWy.td();
                    o.t(specialCheckBoxPreference.kWy);
                    g.bl(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eMV));
                    return;
                }
                o.q(specialCheckBoxPreference.kWy);
                g.bl(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eNd));
            }
        }
    };

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.sTc = (ToggleButton) view.findViewById(R.h.czh);
        this.sTd = (ToggleButton) view.findViewById(R.h.czg);
        this.sTe = (ToggleButton) view.findViewById(R.h.czj);
        this.ktm = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.fOg = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ksZ = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        ap.yY();
        this.kWy = c.wR().Rc(this.ktm);
        if (this.kWy != null) {
            ToggleButton toggleButton = this.sTc;
            ap.yY();
            toggleButton.setChecked(c.wW().Rt(this.kWy.field_username));
            this.sTe.setChecked(a.ez(this.kWy.field_type));
            this.sTd.setChecked(bGs());
        }
        this.sTc.setOnCheckedChangeListener(this.sTf);
        this.sTd.setOnCheckedChangeListener(this.sTf);
        this.sTe.setOnCheckedChangeListener(this.sTf);
    }

    final boolean bGs() {
        if (this.fOg) {
            this.kmK = this.kWy.gkz == 0;
        } else if (!this.ksZ) {
            this.kmK = this.kWy.tD();
        }
        if (!(this.mContext instanceof MMActivity)) {
            return false;
        }
        if (this.kmK) {
            ((MMActivity) this.mContext).zo(0);
            return true;
        }
        ((MMActivity) this.mContext).zo(8);
        return false;
    }
}
