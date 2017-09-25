package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.d.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InviteRemindDialog extends MMBaseActivity {
    private String fJL = "";
    private TextView iUO;
    private TextView rlp;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.djt);
        this.iUO = (TextView) findViewById(R.h.ckf);
        this.rlp = (TextView) findViewById(R.h.ckc);
        this.fJL = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.iUO.setText(getString(R.l.fcx));
            this.rlp.setText(getString(R.l.fci));
        } else if (this.type == 1) {
            this.iUO.setText(getString(R.l.fcR));
            this.rlp.setText(getString(R.l.fcM));
        }
        findViewById(R.h.ckg).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteRemindDialog rlq;

            {
                this.rlq = r1;
            }

            public final void onClick(View view) {
                if (this.rlq.fJL != null) {
                    try {
                        ap.yY();
                        Map NF = a.NF((String) c.vr().get(77829, null));
                        a aVar;
                        if (NF != null) {
                            if (NF != null && NF.size() > 0) {
                                if (NF.containsKey(this.rlq.fJL)) {
                                    aVar = (a) NF.get(this.rlq.fJL);
                                    aVar.hOg++;
                                    NF.put(this.rlq.fJL, aVar);
                                } else {
                                    aVar = new a();
                                    aVar.hOg++;
                                    NF.put(this.rlq.fJL, aVar);
                                }
                            }
                            ap.yY();
                            c.vr().set(77829, a.ad(NF));
                            for (Entry value : NF.entrySet()) {
                                aVar = (a) value.getValue();
                                w.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hOg);
                            }
                        } else {
                            Map hashMap = new HashMap();
                            a aVar2 = new a();
                            aVar2.hOg++;
                            hashMap.put(this.rlq.fJL, aVar2);
                            ap.yY();
                            c.vr().set(77829, a.ad(hashMap));
                            for (Entry value2 : hashMap.entrySet()) {
                                aVar = (a) value2.getValue();
                                w.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hOg);
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
                    }
                }
                String string = this.rlq.type == 0 ? this.rlq.getString(R.l.fch) : this.rlq.type == 1 ? this.rlq.getString(R.l.fcL) : null;
                ap.vd().a(new com.tencent.mm.plugin.voip.model.c(this.rlq.fJL, string, o.fG(this.rlq.fJL)), 0);
                Intent intent = new Intent();
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.rlq.fJL);
                com.tencent.mm.plugin.voip.a.a.imv.e(intent, this.rlq);
                this.rlq.finish();
            }
        });
        findViewById(R.h.cjW).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteRemindDialog rlq;

            {
                this.rlq = r1;
            }

            public final void onClick(View view) {
                this.rlq.finish();
            }
        });
    }

    public void finish() {
        super.finish();
    }

    public static void h(Context context, String str, int i) {
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
    }
}
