package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean fEq = false;
    private static List<String> qVB = new ArrayList();
    private String fJL = "";
    private ae handler = new ae();
    private h oHT;
    private List<String> qVA = new ArrayList();
    private d qVC = new d(this) {
        final /* synthetic */ RemindDialog qVD;

        {
            this.qVD = r1;
        }

        public final void h(String str, long j) {
            w.d("MicroMsg.RemindDialog", "onVoiceRemind " + str);
            this.qVD.qVA.add(str);
            this.qVD.bni();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        h.a aVar = new h.a(this);
        aVar.zW(R.l.faR);
        aVar.SX(" ");
        aVar.zZ(R.l.faO).a(new OnClickListener(this) {
            final /* synthetic */ RemindDialog qVD;

            {
                this.qVD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.subapp.c.d bmY = com.tencent.mm.plugin.subapp.c.d.bmY();
                if (bmY != null) {
                    bmY.gd(this.qVD.fJL);
                }
                if (o.fs(ap.getNotification().qh())) {
                    this.qVD.finish();
                    return;
                }
                b.imv.e(new Intent().putExtra("Chat_User", this.qVD.fJL), this.qVD);
                this.qVD.finish();
            }
        });
        aVar.Aa(R.l.faQ).b(new OnClickListener(this) {
            final /* synthetic */ RemindDialog qVD;

            {
                this.qVD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.subapp.c.d bmY = com.tencent.mm.plugin.subapp.c.d.bmY();
                if (bmY != null) {
                    bmY.gd(this.qVD.fJL);
                }
                this.qVD.finish();
            }
        });
        aVar.a(new OnDismissListener(this) {
            final /* synthetic */ RemindDialog qVD;

            {
                this.qVD = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.qVD.finish();
            }
        });
        this.fJL = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.qVA.clear();
        this.qVA.add(stringExtra);
        for (String stringExtra2 : qVB) {
            this.qVA.add(stringExtra2);
        }
        this.oHT = aVar.WJ();
        this.oHT.setCanceledOnTouchOutside(false);
        this.oHT.show();
        bni();
    }

    private void bni() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ RemindDialog qVD;

            {
                this.qVD = r1;
            }

            public final void run() {
                CharSequence stringBuffer = new StringBuffer();
                for (String str : this.qVD.qVA) {
                    if (bg.mA(str)) {
                        stringBuffer.append("\n\n");
                    } else {
                        stringBuffer.append(str + "\n\n");
                    }
                }
                if (this.qVD.oHT != null) {
                    this.qVD.oHT.setMessage(stringBuffer);
                }
            }
        });
    }

    public void onResume() {
        fEq = true;
        com.tencent.mm.plugin.subapp.c.d bmY = com.tencent.mm.plugin.subapp.c.d.bmY();
        if (bmY != null) {
            bmY.a(this.qVC);
        }
        super.onResume();
    }

    public void onPause() {
        fEq = false;
        com.tencent.mm.plugin.subapp.c.d bmY = com.tencent.mm.plugin.subapp.c.d.bmY();
        if (bmY != null) {
            bmY.b(this.qVC);
        }
        super.onPause();
    }

    public static void r(Context context, String str, String str2) {
        w.d("MicroMsg.RemindDialog", "show " + fEq + " remind " + str2);
        if (fEq) {
            qVB.add(str2);
            return;
        }
        qVB.clear();
        fEq = true;
        if (ap.vd().foreground) {
            Intent intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }
}
