package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.k.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private String username;
    private ListView wrS;
    private a wrT;
    private String wrU = null;
    private TextView wrV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.wrS = (ListView) findViewById(R.h.cNB);
        this.wrV = (TextView) findViewById(R.h.bMf);
        this.wrT = new a(getApplicationContext(), new a(this) {
            final /* synthetic */ SearchConversationResultUI wrW;

            {
                this.wrW = r1;
            }

            public final void OI() {
            }

            public final void OH() {
            }
        });
        if (this.wrT != null) {
            this.wrT.cK(new LinkedList());
        }
        this.wrS.setAdapter(this.wrT);
        this.wrV.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.wrU = getIntent().getStringExtra("SearchConversationResult_Error");
        qP(getString(R.l.dpI));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SearchConversationResultUI wrW;

            {
                this.wrW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wrW.finish();
                return true;
            }
        });
        this.wrS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SearchConversationResultUI wrW;

            {
                this.wrW = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.wrW.wrS.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.wrW.wrS.getHeaderViewsCount();
                    ae aeVar = (ae) this.wrW.wrT.getItem(headerViewsCount);
                    if (aeVar == null) {
                        w.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + headerViewsCount);
                        return;
                    }
                    w.d("MicroMsg.VoiceSearchResultUI", "username " + aeVar.field_username);
                    if (o.fa(aeVar.field_username)) {
                        if (m.ye()) {
                            d.b(this.wrW.uSU.uTo, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fc(aeVar.field_username)) {
                        if (m.yb()) {
                            d.b(this.wrW.uSU.uTo, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fb(aeVar.field_username)) {
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fg(aeVar.field_username)) {
                        MMAppMgr.cancelNotification(aeVar.field_username);
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.eY(aeVar.field_username)) {
                        if (m.yn()) {
                            this.wrW.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        }
                    } else if (o.fl(aeVar.field_username)) {
                        if (m.yi()) {
                            r0 = new Intent();
                            r0.putExtra(Columns.TYPE, 20);
                            d.b(this.wrW, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.ft(aeVar.field_username)) {
                        if (m.yj()) {
                            r0 = new Intent();
                            r0.putExtra(Columns.TYPE, 11);
                            d.b(this.wrW, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fd(aeVar.field_username)) {
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fe(aeVar.field_username)) {
                        if (m.yl()) {
                            d.b(this.wrW, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (o.fk(aeVar.field_username)) {
                        if (m.yf()) {
                            this.wrW.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        }
                    } else if (o.fi(this.wrW.username) || o.fj(this.wrW.username) || o.ff(this.wrW.username) || o.fm(this.wrW.username) || o.fn(this.wrW.username) || o.eZ(this.wrW.username) || o.fw(this.wrW.username)) {
                        d.b(this.wrW, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else {
                        this.wrW.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                    }
                }
            }
        });
        String str = this.username;
        this.wrV.setVisibility(8);
        if (this.wrT != null) {
            this.wrT.yD(str);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.wrT.aEW();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final int getLayoutId() {
        return R.i.dpI;
    }
}
