package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import junit.framework.Assert;

public final class e implements OnItemClickListener {
    private Activity activity;
    private g wbL;
    private ListView wbi;

    public e(g gVar, ListView listView, Activity activity) {
        this.wbL = gVar;
        this.wbi = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = false;
        if (i >= this.wbi.getHeaderViewsCount()) {
            int headerViewsCount = i - this.wbi.getHeaderViewsCount();
            ae aeVar = (ae) this.wbL.yQ(headerViewsCount);
            if (aeVar == null) {
                w.e("MicroMsg.ConversationClickListener", "null user at position = " + headerViewsCount);
                return;
            }
            boolean z2;
            if (o.fa(aeVar.field_username)) {
                if (m.yd()) {
                    d.w(this.activity, "tmessage", ".ui.TConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (o.fb(aeVar.field_username)) {
                if (m.yc()) {
                    d.w(this.activity, "bottle", ".ui.BottleConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (o.fg(aeVar.field_username)) {
                MMAppMgr.cancelNotification(aeVar.field_username);
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                z2 = false;
            } else {
                if (o.eY(aeVar.field_username)) {
                    h.vJ();
                    if (bg.f((Integer) h.vI().vr().get(17, null)) == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (o.fl(aeVar.field_username)) {
                    if (m.yi()) {
                        r1 = new Intent();
                        r1.addFlags(67108864);
                        r1.putExtra(Columns.TYPE, 20);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", r1);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (o.ft(aeVar.field_username)) {
                    if (m.yj()) {
                        r1 = new Intent();
                        r1.addFlags(67108864);
                        r1.putExtra(Columns.TYPE, 11);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", r1);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (o.fd(aeVar.field_username)) {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                } else if (o.fe(aeVar.field_username)) {
                    if (m.yl()) {
                        d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (o.fs(aeVar.field_username)) {
                    if (a.hlV != null) {
                        a.hlV.gd(aeVar.field_username);
                    }
                    z2 = true;
                } else if (o.fu(aeVar.field_username)) {
                    this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                    z2 = false;
                } else if (o.eV(aeVar.field_username) && com.tencent.mm.modelbiz.e.ib(aeVar.field_username)) {
                    if (o.eU(aeVar.field_username)) {
                        r1 = new Intent(this.activity, EnterpriseConversationUI.class);
                        r1.putExtra("enterprise_biz_name", aeVar.field_username);
                        r1.putExtra("enterprise_biz_display_name", n.eK(aeVar.field_username));
                        r1.putExtra("enterprise_from_scene", 1);
                        this.activity.startActivity(r1);
                        z2 = false;
                    } else {
                        g.bl(this.activity, this.activity.getString(R.l.eeP));
                        return;
                    }
                } else if (o.eV(aeVar.field_username) && com.tencent.mm.modelbiz.e.dr(aeVar.field_username)) {
                    if (o.eU(aeVar.field_username)) {
                        r1 = new Intent(this.activity, BizChatConversationUI.class);
                        r1.putExtra("Contact_User", aeVar.field_username);
                        r1.putExtra("biz_chat_from_scene", 1);
                        r1.addFlags(67108864);
                        this.activity.startActivity(r1);
                        z2 = false;
                    } else {
                        g.bl(this.activity, this.activity.getString(R.l.eeP));
                        return;
                    }
                } else if (o.fD(aeVar.field_username)) {
                    r1 = new Intent();
                    r1.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                    r1.putExtra("Contact_User", aeVar.field_username);
                    r1.putExtra("app_brand_conversation_from_scene", 1);
                    r1.addFlags(67108864);
                    this.activity.startActivity(r1);
                    z2 = false;
                }
                z2 = true;
            }
            if (z2) {
                f.rY(9);
                LauncherUI launcherUI = (LauncherUI) this.activity;
                String str = "Launcher should not be empty.";
                if (launcherUI != null) {
                    z = true;
                }
                Assert.assertTrue(str, z);
                launcherUI.a(aeVar.field_username, null, true);
            }
        }
    }
}
