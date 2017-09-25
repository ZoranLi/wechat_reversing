package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private p iLz = null;
    private long kuh = -1;
    private DayPickerView kwI;
    private String kwJ;
    private HashMap<String, com.tencent.mm.plugin.chatroom.d.a> kwK;
    private TextView kwL;
    private ae mHandler;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI r10) {
        /*
        r9 = 1;
        r8 = 0;
        r2 = java.lang.System.currentTimeMillis();
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r10.kwJ;
        r1 = r0.Ag(r1);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0083;
    L_0x0019:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x0054 }
        if (r0 != 0) goto L_0x0083;
    L_0x001f:
        r4 = -1;
        r6 = r10.kuh;	 Catch:{ Exception -> 0x0054 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x002e;
    L_0x0027:
        r0 = 0;
        r4 = r1.getLong(r0);	 Catch:{ Exception -> 0x0054 }
        r10.kuh = r4;	 Catch:{ Exception -> 0x0054 }
    L_0x002e:
        r0 = new com.tencent.mm.plugin.chatroom.d.a;	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0054 }
        r4 = 1;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.fGM = r4;	 Catch:{ Exception -> 0x0054 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r5 = r10.kwK;	 Catch:{ Exception -> 0x0054 }
        r5 = r5.containsKey(r4);	 Catch:{ Exception -> 0x0054 }
        if (r5 != 0) goto L_0x0050;
    L_0x004b:
        r5 = r10.kwK;	 Catch:{ Exception -> 0x0054 }
        r5.put(r4, r0);	 Catch:{ Exception -> 0x0054 }
    L_0x0050:
        r1.moveToNext();	 Catch:{ Exception -> 0x0054 }
        goto L_0x0019;
    L_0x0054:
        r0 = move-exception;
        r4 = "MicroMsg.SelectDateUI";
        r0 = r0.toString();	 Catch:{ all -> 0x0087 }
        com.tencent.mm.sdk.platformtools.w.e(r4, r0);	 Catch:{ all -> 0x0087 }
        r1.close();
    L_0x0062:
        r0 = "MicroMsg.SelectDateUI";
        r1 = "[prepareData] time:%s";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = java.lang.System.currentTimeMillis();
        r2 = r6 - r2;
        r2 = r5.append(r2);
        r2 = r2.toString();
        r4[r8] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r4);
        return;
    L_0x0083:
        r1.close();
        goto L_0x0062;
    L_0x0087:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.chatroom.ui.SelectDateUI.a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eNf);
        this.kwI = (DayPickerView) findViewById(R.h.crG);
        this.kwL = (TextView) findViewById(R.h.cAT);
        this.kwK = new HashMap();
        this.mHandler = new ae(getMainLooper());
        this.kwJ = getIntent().getStringExtra("detail_username");
        e.post(new Runnable(this) {
            final /* synthetic */ SelectDateUI kwM;

            {
                this.kwM = r1;
            }

            public final void run() {
                SelectDateUI.a(this.kwM);
                this.kwM.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kwN;

                    {
                        this.kwN = r1;
                    }

                    public final void run() {
                        this.kwN.kwM.kwI.kuh = this.kwN.kwM.kuh == -1 ? System.currentTimeMillis() * 1000 : this.kwN.kwM.kuh;
                        this.kwN.kwM.kwI.a(this.kwN.kwM, this.kwN.kwM.kwK.values());
                        if (this.kwN.kwM.kwK.size() == 0) {
                            this.kwN.kwM.kwL.setVisibility(0);
                            this.kwN.kwM.kwI.setVisibility(8);
                            this.kwN.kwM.kwL.setText(this.kwN.kwM.getString(R.l.dVi));
                            return;
                        }
                        this.kwN.kwM.kwL.setVisibility(8);
                        this.kwN.kwM.kwI.setVisibility(0);
                    }
                });
            }
        }, "prepare_data");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDateUI kwM;

            {
                this.kwM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kwM.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dnx;
    }

    public final long ajc() {
        return System.currentTimeMillis();
    }

    public final void a(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.SelectDateUI", "null == calendarDay");
            return;
        }
        w.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[]{Long.valueOf(aVar.ksK), Integer.valueOf(aVar.jXa), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year)});
        w.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(aVar.fGM)});
        com.tencent.mm.plugin.chatroom.a.imv.e(new Intent().putExtra("Chat_User", this.kwJ).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), this);
    }
}
