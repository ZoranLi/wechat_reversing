package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class SnsSingleTextViewUI extends MMActivity {
    private String fJz;
    private ClipboardManager lMa;
    private d nxN = new d(this) {
        final /* synthetic */ SnsSingleTextViewUI qGF;

        {
            this.qGF = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    if (this.qGF.qGz != null && this.qGF.qGz.getText() != null) {
                        this.qGF.lMa.setText(this.qGF.qGz.getText());
                        g.bl(this.qGF.uSU.uTo, this.qGF.uSU.uTo.getString(j.dGy));
                        return;
                    }
                    return;
                case 1:
                    if (this.qGF.qGz != null && this.qGF.qGz.getText() != null) {
                        cb cbVar = new cb();
                        a.a(cbVar, this.qGF.fJz, this.qGF.qGz.getText());
                        cbVar.fFA.activity = this.qGF;
                        cbVar.fFA.fFH = 18;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                        return;
                    }
                    return;
                case 6:
                    if (this.qGF.qGz != null && this.qGF.qGz.getText() != null) {
                        Intent intent = new Intent();
                        m Gg = ae.beL().Gg(this.qGF.fJz);
                        intent.putExtra("k_username", Gg == null ? "" : Gg.field_userName);
                        intent.putExtra("k_expose_msg_id", Gg == null ? Integer.valueOf(0) : Gg.bhe());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        com.tencent.mm.bb.d.b(this.qGF, "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    }
                    return;
                case 14:
                    if (this.qGF.qGz != null && this.qGF.qGz.getText() != null) {
                        ao.o(ae.beL().Gg(this.qGF.fJz));
                        return;
                    }
                    return;
                case 16:
                    if (this.qGF.qGz != null && this.qGF.qGz.getText() != null) {
                        ao.p(ae.beL().Gg(this.qGF.fJz));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private m pYr;
    private boolean qGA = false;
    private SnsTranslateResultView qGB;
    private c qGC = new c<pl>(this) {
        final /* synthetic */ SnsSingleTextViewUI qGF;

        {
            this.qGF = r2;
            this.usg = pl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pl plVar = (pl) bVar;
            if ((plVar instanceof pl) && this.qGF.pYr != null && this.qGF.pYr.bhe().equals(plVar.fWp.id)) {
                ao.bH(this.qGF.pYr.bhe(), 8);
                this.qGF.qGB.setVisibility(0);
                this.qGF.qGB.uh(2);
                this.qGF.qGA = false;
            }
            return false;
        }
    };
    private c qGD = new c<pk>(this) {
        final /* synthetic */ SnsSingleTextViewUI qGF;

        {
            this.qGF = r2;
            this.usg = pk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pk pkVar = (pk) bVar;
            if ((pkVar instanceof pk) && this.qGF.pYr != null && this.qGF.pYr.bhe().equals(pkVar.fWn.id)) {
                ao.bH(this.qGF.pYr.bhe(), 8);
                String str = pkVar.fWn.result;
                String str2 = pkVar.fWn.fWo;
                if (bg.mA(str)) {
                    this.qGF.qGB.setVisibility(8);
                    ao.bI(this.qGF.pYr.bhe(), 8);
                } else {
                    this.qGF.qGB.setVisibility(0);
                    this.qGF.qGB.a(null, 1, str, str2, true);
                    this.qGF.qGA = true;
                }
            }
            return false;
        }
    };
    private c qGE = new c<pm>(this) {
        final /* synthetic */ SnsSingleTextViewUI qGF;

        {
            this.qGF = r2;
            this.usg = pm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pm pmVar = (pm) bVar;
            if ((pmVar instanceof pm) && this.qGF.pYr.bhe().equals(pmVar.fWq.id)) {
                ao.bI(pmVar.fWq.id, 8);
                this.qGF.qGB.setVisibility(8);
                this.qGF.qGA = false;
            }
            return false;
        }
    };
    private TextView qGz;
    protected int requestType = 0;
    private String text;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lMa = (ClipboardManager) getSystemService("clipboard");
        zi(j.pKs);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsSingleTextViewUI qGF;

            {
                this.qGF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qGF.finish();
                return true;
            }
        });
        this.text = getIntent().getStringExtra("sns_text_show");
        this.fJz = bg.ap(getIntent().getStringExtra("sns_local_id"), "");
        this.pYr = ae.beL().Gg(this.fJz);
        if (bg.mA(this.text)) {
            this.text = "";
        }
        this.qGz = (TextView) findViewById(f.pFT);
        this.qGz.setText(this.text, BufferType.SPANNABLE);
        h.d(this.qGz, 2);
        this.qGz.setOnTouchListener(new aa());
        new l(this).a(this.qGz, this, this.nxN);
        this.qGB = (SnsTranslateResultView) findViewById(f.pFZ);
        this.qGB.ap(this.qGz.getTextSize());
        if (this.pYr != null && ao.bJ(this.pYr.bhe(), 8)) {
            ao.b Fq = ao.Fq(this.pYr.bhe());
            if (Fq != null && Fq.hoD) {
                this.qGB.setVisibility(0);
                this.qGB.a(null, 1, Fq.result, Fq.hwe, false);
                this.qGA = true;
            }
        }
        com.tencent.mm.sdk.b.a.urY.b(this.qGC);
        com.tencent.mm.sdk.b.a.urY.b(this.qGD);
        com.tencent.mm.sdk.b.a.urY.b(this.qGE);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.qGC);
        com.tencent.mm.sdk.b.a.urY.c(this.qGD);
        com.tencent.mm.sdk.b.a.urY.c(this.qGE);
    }

    protected final int getLayoutId() {
        return i.g.pId;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(j.dGx));
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(0, 1, 0, getString(j.ehy));
            }
            contextMenu.add(0, 6, 1, getString(j.pJD));
            if (this.qGA) {
                ao.b(contextMenu, true);
            } else {
                ao.a(contextMenu, true);
            }
        }
    }
}
