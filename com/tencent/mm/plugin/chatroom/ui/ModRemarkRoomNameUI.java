package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private p isP = null;
    private c ktC = new c<kr>(this) {
        final /* synthetic */ ModRemarkRoomNameUI kuI;

        {
            this.kuI = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kr krVar = (kr) bVar;
            String str = krVar.fRk.fRl;
            String str2 = krVar.fRk.fRm;
            int i = krVar.fRk.ret;
            if (i != 0 && str2 != null) {
                g.b(this.kuI, str2, str, true);
                if (this.kuI.kuH != null) {
                    ap.yY();
                    com.tencent.mm.u.c.wQ().c(this.kuI.kuH);
                }
            } else if (i == 0 && this.kuI.kty) {
                Intent intent = new Intent();
                intent.putExtra("room_name", this.kuI.kuF);
                this.kuI.setResult(-1, intent);
                this.kuI.finish();
            }
            if (this.kuI.isP != null) {
                this.kuI.isP.dismiss();
            }
            return false;
        }
    };
    private String ktm;
    private boolean kty = false;
    private String kuF = "";
    private MMEditText kuG;
    private e.b kuH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ktm = getIntent().getStringExtra("RoomInfo_Id");
        com.tencent.mm.sdk.b.a.urY.b(this.ktC);
        KC();
    }

    protected final void KC() {
        zi(R.l.eLR);
        this.kuG = (MMEditText) findViewById(R.h.ckV);
        final CharSequence mz = bg.mz(getIntent().getStringExtra("room_name"));
        if (bg.mA(mz)) {
            this.kuG.setHint(h.b(this, ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().eK(this.ktm), this.kuG.getTextSize()));
            this.kuG.setEllipsize(TruncateAt.END);
        } else {
            this.kuG.setText(h.b(this, mz, this.kuG.getTextSize()));
        }
        this.kuG.setSelection(this.kuG.getText().length());
        this.kuG.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ModRemarkRoomNameUI kuI;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!mz.equals(charSequence)) {
                    this.kuI.kr(true);
                }
                if (charSequence.length() > 0) {
                    this.kuI.kuG.setEllipsize(null);
                } else {
                    this.kuI.kuG.setEllipsize(TruncateAt.END);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI kuI;

            {
                this.kuI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kuI.setResult(0);
                this.kuI.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI kuI;

            {
                this.kuI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kuI.aHf();
                String str = "";
                String sE = com.tencent.mm.i.b.sE();
                if (bg.mA(sE) || !str.matches(".*[" + sE + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(this.kuI.kuG).em(1, 32).a(this.kuI);
                    return true;
                }
                g.b(this.kuI.uSU.uTo, this.kuI.getString(R.l.esK, new Object[]{sE}), this.kuI.getString(R.l.dIO), true);
                return false;
            }
        }, l.b.uTY);
        kr(false);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.ktC);
    }

    protected final int getLayoutId() {
        return R.i.djC;
    }

    public final void ro(String str) {
        this.kuF = str;
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isP = g.a(context, getString(R.l.dXM), false, null);
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amd = new amd();
        com_tencent_mm_protocal_c_amd.teL = new avx().OV(bg.mz(this.ktm));
        com_tencent_mm_protocal_c_amd.tQE = new avx().OV(bg.mz(str));
        this.kuH = new e.a(27, com_tencent_mm_protocal_c_amd);
        this.kty = true;
        ap.yY();
        com.tencent.mm.u.c.wQ().b(this.kuH);
    }

    public final void YN() {
        g.h(this, R.l.eSW, R.l.eSY);
    }

    public final void Yp() {
        g.h(this, R.l.eSX, R.l.eSY);
    }
}
