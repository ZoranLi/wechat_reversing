package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.a.o;
import com.tencent.mm.bg.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class g {
    private static final String fwJ;
    private static final String fwK;
    public static final int nQY = a.fromDPToPix(ab.getContext(), 8);
    public static final int nRe = a.fromDPToPix(ab.getContext(), 96);
    public static final int nRf = a.fromDPToPix(ab.getContext(), 76);
    public Intent intent;
    public h rnR;
    private Point rnS;
    private a rnT;
    public aj rnU;

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
    }

    public final void a(final Intent intent, final a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            return;
        }
        this.intent = intent;
        this.rnT = aVar;
        if (b.aA(ab.getContext())) {
            R(intent);
            return;
        }
        w.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        VoipWarningDialog.a(ab.getContext(), new VoipWarningDialog.a(this) {
            final /* synthetic */ g rnW;

            public final void a(VoipWarningDialog voipWarningDialog) {
                voipWarningDialog.finish();
                if (aVar.aDL()) {
                    this.rnW.R(intent);
                }
            }

            public final void b(VoipWarningDialog voipWarningDialog) {
                voipWarningDialog.finish();
            }
        });
    }

    public final void R(final Intent intent) {
        w.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.rnR != null) {
            dismiss();
        }
        if (this.rnR == null) {
            this.rnR = new h(ab.getContext());
        }
        if (this.rnU != null) {
            this.rnU.KH();
        }
        this.rnR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g rnW;

            public final void onClick(View view) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ab.getContext().startActivity(intent);
                view.setOnClickListener(null);
                this.rnW.rnU = new aj(new aj.a(this) {
                    final /* synthetic */ AnonymousClass2 rnX;

                    {
                        this.rnX = r1;
                    }

                    public final boolean oQ() {
                        w.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
                        this.rnX.rnW.dismiss();
                        if (this.rnX.rnW.rnU != null) {
                            this.rnX.rnW.rnU.KH();
                        }
                        return true;
                    }
                }, false);
                this.rnW.rnU.v(2000, 2000);
            }
        });
        WindowManager windowManager = (WindowManager) ab.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = nRf;
        layoutParams.height = nRe;
        if (this.rnS == null) {
            ap.yY();
            int i = c.vr().getInt(327947, 0);
            int i2 = nQY;
            layoutParams.x = (a.dO(ab.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.rnS.x;
            layoutParams.y = this.rnS.y;
        }
        try {
            windowManager.addView(this.rnR, layoutParams);
        } catch (Exception e) {
            w.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[]{e});
        }
        this.rnT.a(intent, this.rnR);
    }

    public final void tt(int i) {
        if (this.rnR != null) {
            this.rnR.HF(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
        }
    }

    public final void HE(String str) {
        if (this.rnR != null) {
            this.rnR.HE(str);
        }
    }

    public final void dismiss() {
        w.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
        WindowManager windowManager = (WindowManager) ab.getContext().getSystemService("window");
        try {
            if (this.rnR != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.rnR.getLayoutParams();
                this.rnS = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.rnR);
                this.rnR.setOnClickListener(null);
                this.rnR = null;
            }
        } catch (Exception e) {
            w.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[]{e});
        }
    }
}
