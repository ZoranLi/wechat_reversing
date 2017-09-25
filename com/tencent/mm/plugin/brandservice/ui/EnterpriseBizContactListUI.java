package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.b;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.m;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private long gKS;
    private long hVi = 0;
    public String kaE;
    private m kaF;
    private EnterpriseBizContactListView kaG;
    private ae kaH;
    private boolean kaI = false;

    protected final int getLayoutId() {
        return R.i.dbe;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kaE = getIntent().getStringExtra("enterprise_biz_name");
        this.gKS = System.currentTimeMillis() / 1000;
        if (this.kaH == null) {
            this.kaH = new ae(this) {
                final /* synthetic */ EnterpriseBizContactListUI kaJ;

                {
                    this.kaJ = r1;
                }

                public final void handleMessage(Message message) {
                    if (message != null && message.what == 1 && this.kaJ != null && !this.kaJ.isFinishing()) {
                        w.DR().hB(this.kaJ.kaE);
                        w.DH();
                        List hR = d.hR(this.kaJ.kaE);
                        for (int i = 0; i < hR.size(); i++) {
                            String str = (String) hR.get(i);
                            if (o.eU(str) && (e.ic(str) || e.dr(str))) {
                                w.DR().hB(str);
                            }
                        }
                    }
                }
            };
        } else {
            this.kaH.removeMessages(1);
        }
        this.kaH.sendEmptyMessageDelayed(1, 500);
    }

    protected void onResume() {
        super.onResume();
        if (o.eU(this.kaE)) {
            KC();
            if (!this.kaI) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.kaG != null) {
                    i = this.kaG.kaN;
                }
                b hC = w.DO().hC(this.kaE);
                int i2 = hC != null ? hC.field_qyUin : 0;
                long j = hC != null ? hC.field_wwCorpId : 0;
                long j2 = hC != null ? hC.field_wwUserVid : 0;
                g.oUh.i(12892, new Object[]{this.kaE, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{this.kaE, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
                this.kaI = true;
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[]{this.kaE});
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.kaG != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.gKS > 0 && this.hVi > 0) {
            long j = this.hVi - this.gKS;
            b hC = w.DO().hC(this.kaE);
            int i = hC != null ? hC.field_qyUin : 0;
            int i2 = hC != null ? hC.field_userUin : 0;
            g.oUh.i(13465, new Object[]{"", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
        }
        super.onDestroy();
    }

    public void finish() {
        this.hVi = System.currentTimeMillis() / 1000;
        super.finish();
    }

    protected final void KC() {
        ap.yY();
        qP(c.wR().Rc(this.kaE).tK());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactListUI kaJ;

            {
                this.kaJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kaJ.aHf();
                this.kaJ.finish();
                return true;
            }
        });
        if (!bg.mA(this.kaE)) {
            BizInfo hW = e.hW(this.kaE);
            if (hW != null && hW.CH()) {
                a(1, R.l.dBP, R.k.dsI, new OnMenuItemClickListener(this) {
                    final /* synthetic */ EnterpriseBizContactListUI kaJ;

                    {
                        this.kaJ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.kaJ.kaF != null) {
                            this.kaJ.kaF.dismiss();
                            this.kaJ.kaF = null;
                        }
                        this.kaJ.kaF = new m(this.kaJ.uSU.uTo);
                        this.kaJ.kaF.qJf = new n.c(this) {
                            final /* synthetic */ AnonymousClass2 kaK;

                            {
                                this.kaK = r1;
                            }

                            public final void a(l lVar) {
                                lVar.W(2, R.l.dZx, R.k.dyx);
                                lVar.W(3, R.l.eeI, R.k.dsM);
                                lVar.W(4, R.l.dBQ, R.k.dsW);
                            }
                        };
                        this.kaJ.kaF.qJg = new n.d(this) {
                            final /* synthetic */ AnonymousClass2 kaK;

                            {
                                this.kaK = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 2:
                                        intent = new Intent();
                                        intent.putExtra("Select_Talker_Name", this.kaK.kaJ.kaE);
                                        intent.putExtra("Select_block_List", this.kaK.kaJ.kaE);
                                        intent.putExtra("Select_Send_Card", true);
                                        intent.putExtra("Select_Conv_Type", 3);
                                        com.tencent.mm.bb.d.a(this.kaK.kaJ, ".ui.transmit.SelectConversationUI", intent, 1);
                                        return;
                                    case 3:
                                        intent = new Intent(this.kaK.kaJ, EnterpriseBizContactPlainListUI.class);
                                        intent.putExtra("enterprise_biz_name", this.kaK.kaJ.kaE);
                                        intent.putExtra("enterprise_scene", 2);
                                        this.kaK.kaJ.startActivity(intent);
                                        return;
                                    case 4:
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", this.kaK.kaJ.kaE);
                                        a.imv.d(intent, this.kaK.kaJ);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        this.kaJ.kaF.dL();
                        return false;
                    }
                });
            }
        }
        this.kaG = (EnterpriseBizContactListView) findViewById(R.h.bMl);
        this.kaG.kaE = this.kaE;
        this.kaG.kaL = false;
        this.kaG.refresh();
        this.kaG.aem();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.d.aJW().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.e(this, this.uSU.uTo.getString(R.l.ekV));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
