package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.r;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements m {
    private p irJ = null;
    private String kbi = null;
    private int scene = 0;
    j vvG;
    private TextView vwD;

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        bizChatSelectConversationUI.vvG = w.DL().iD(w.DL().iF(bizChatSelectConversationUI.kbi));
        if (bizChatSelectConversationUI.vvG == null || bg.mA(bizChatSelectConversationUI.vvG.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.vvG != null ? bizChatSelectConversationUI.vvG.field_addMemberUrl : null;
            com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.l.dOV), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.vvG.field_addMemberUrl);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.vvG.field_addMemberUrl);
        intent.putExtra("useJs", true);
        d.b(bizChatSelectConversationUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        bTv();
        String iF = w.DL().iF(this.kbi);
        this.vvG = w.DL().iD(iF);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.kbi;
        objArr[1] = iF;
        if (this.vvG == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
        if (bg.mA(iF) || this.vvG == null || this.vvG.DW() || bg.mA(this.vvG.field_addMemberUrl)) {
            w.DN();
            h.a(this.kbi, (m) this);
            getString(R.l.dIO);
            this.irJ = g.a((Context) this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ BizChatSelectConversationUI vwE;

                {
                    this.vwE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.vwE.finish();
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void bTv() {
        if (bg.mA(this.kbi)) {
            this.kbi = getIntent().getStringExtra("enterprise_biz_name");
            if (bg.mA(this.kbi)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
    }

    protected final o Oi() {
        bTv();
        return new d(this, this.kbi);
    }

    protected final com.tencent.mm.ui.contact.m Oj() {
        bTv();
        return new com.tencent.mm.ui.contact.p(this, this.kbi);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.vwD == null) {
            OnClickListener anonymousClass1 = new OnClickListener(this) {
                final /* synthetic */ BizChatSelectConversationUI vwE;

                {
                    this.vwE = r1;
                }

                public final void onClick(View view) {
                    BizChatSelectConversationUI.a(this.vwE);
                }
            };
            CharSequence string = getString(R.l.eQs);
            View inflate = r.eC(this).inflate(R.i.dfA, null);
            inflate.setOnClickListener(anonymousClass1);
            TextView textView = (TextView) inflate.findViewById(R.h.bGD);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.vwD = textView;
        }
        this.vwD.setVisibility(i);
    }

    protected final void aIP() {
        super.aIP();
    }

    public final void hf(int i) {
        if (i < this.oCR.getHeaderViewsCount()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
        } else if (this.oCR.getAdapter().getItem(i) instanceof a) {
            a aVar = (a) this.oCR.getAdapter().getItem(i);
            if (aVar != null) {
                String str = aVar.username;
                long j = aVar.kbc;
                if (str == null || j == -1) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j));
                    return;
                }
                a(str, j, aVar.ipq);
            }
        } else {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        }
    }

    private void a(final String str, final long j, CharSequence charSequence) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene == 2) {
            long j2;
            if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
                j2 = j;
                com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, j2, getString(R.l.eLK), String.valueOf(charSequence), getString(R.l.dIA), new k.a(this) {
                    final /* synthetic */ BizChatSelectConversationUI vwE;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", str);
                            intent.putExtra("key_biz_chat_id", j);
                            intent.putExtra("key_is_biz_chat", true);
                            this.vwE.setResult(-1, intent);
                            this.vwE.finish();
                        }
                    }
                });
                return;
            }
            j2 = j;
            com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, j2, getString(R.l.eLK), String.valueOf(charSequence), getString(R.l.dIA), new k.a(this) {
                final /* synthetic */ BizChatSelectConversationUI vwE;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        this.vwE.setResult(-1, intent);
                        this.vwE.finish();
                    }
                }
            });
        } else if (this.scene == 1) {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
            String str2 = (String) hashMap.get("title");
            com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, str2, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), null, true, getResources().getString(R.l.dIA), new k.a(this) {
                final /* synthetic */ BizChatSelectConversationUI vwE;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        if (!bg.mA(str)) {
                            intent.putExtra("enterprise_share_append_text", str);
                        }
                        this.vwE.setResult(-1, intent);
                        this.vwE.finish();
                    }
                }
            });
        }
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return n.eK(this.kbi);
    }

    protected final boolean Of() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        String str;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        ss ssVar = new ss();
                        c cVar = new c();
                        if (this.vvG != null) {
                            str = this.vvG.field_addMemberUrl;
                        } else {
                            str = null;
                        }
                        cVar.field_addMemberUrl = str;
                        cVar.field_brandUserName = this.kbi;
                        if (!e.a(cVar, string, null, ssVar)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            a(this.kbi, cVar.field_bizChatLocalId, cVar.field_chatName);
                            z = true;
                        } else {
                            w.DN();
                            final com.tencent.mm.modelbiz.a.n a = h.a(this.kbi, ssVar, (m) this);
                            getString(R.l.dIO);
                            this.irJ = g.a((Context) this, getString(R.l.dCi), true, new OnCancelListener(this) {
                                final /* synthetic */ BizChatSelectConversationUI vwE;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ap.vd().c(a);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(this, getString(R.l.eLX), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, com.tencent.mm.y.k kVar) {
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (kVar.getType() == 1355) {
            c iq = w.DJ().iq(((com.tencent.mm.modelbiz.a.n) kVar).Eb().ttc.tAE.tkF);
            if (iq == null) {
                Toast.makeText(ab.getContext(), getString(R.l.eLX), 0).show();
            } else {
                a(this.kbi, iq.field_bizChatLocalId, iq.field_chatName);
            }
        }
    }
}
