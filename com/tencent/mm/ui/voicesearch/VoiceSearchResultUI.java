package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI extends MMActivity {
    private int hNV = 2;
    private int lrE = -1;
    int showType = 1;
    private ListView wrS;
    private String wrU = null;
    private TextView wrV;
    private b wsg;
    private String[] wsh;
    private boolean wsi = false;
    boolean wsj = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        this.wsi = false;
    }

    protected final void KC() {
        this.wrS = (ListView) findViewById(R.h.cNB);
        this.wrV = (TextView) findViewById(R.h.bMf);
        this.wsh = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.wrU = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.lrE = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.hNV = this.showType == 1 ? 2 : 1;
        this.wsj = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        w.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", Integer.valueOf(this.showType), Boolean.valueOf(this.wsj));
        this.wsg = new b(getApplicationContext(), this.showType);
        this.wsg.lQ(false);
        List linkedList = new LinkedList();
        switch (this.showType) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int xW = m.xW();
                if ((xW & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(o.yy() && (xW & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((xW & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((xW & FileUtils.S_IWUSR) != 0) {
                    linkedList.add("qqsync");
                }
                if ((xW & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((SQLiteGlobal.journalSizeLimit & xW) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & xW) == 0 && o.yx())) {
                    linkedList.add("blogapp");
                }
                if ((65536 & xW) != 0) {
                    linkedList.add("masssendapp");
                }
                if ((xW & 33554432) != 0) {
                    linkedList.add("voiceinputapp");
                    break;
                }
                break;
        }
        if (this.wsg != null) {
            this.wsg.cK(linkedList);
        }
        this.wrS.setAdapter(this.wsg);
        this.wrV.setVisibility(8);
        w.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.lrE);
        if (this.showType == 2) {
            qP("");
            this.wsh = H(this.wsh);
        } else {
            qP(getString(R.l.dpI));
        }
        qP(getString(R.l.dpI));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceSearchResultUI wsk;

            {
                this.wsk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.wsk.wsi) {
                    g.oUh.A(10452, this.wsk.hNV + "," + this.wsk.lrE + "," + (this.wsk.wsh == null ? 0 : this.wsk.wsh.length) + ",0");
                }
                if (this.wsk.wsj) {
                    this.wsk.moveTaskToBack(true);
                }
                this.wsk.finish();
                return true;
            }
        });
        this.wrS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ VoiceSearchResultUI wsk;

            {
                this.wsk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.wsk.wsi) {
                    g.oUh.A(10452, this.wsk.hNV + "," + this.wsk.lrE + "," + (this.wsk.wsh == null ? 0 : this.wsk.wsh.length) + "," + i);
                }
                af kO = this.wsk.wsg.kO(i);
                Context context = this.wsk;
                String str = kO.field_username;
                String tL = kO.tL();
                if (str != null && str.length() > 0) {
                    w.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + str);
                    Intent intent;
                    if (context.showType == 3) {
                        intent = new Intent();
                        intent.putExtra("Select_Conv_User", str);
                        context.setResult(-1, intent);
                        context.finish();
                    } else if (context.showType != 1 && !o.fF(str) && !o.eV(str) && !o.dH(str) && !o.eS(str) && !VoiceSearchResultUI.Uy(tL)) {
                        Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                        intent2.putExtra("SearchConversationResult_User", tL);
                        context.startActivity(intent2);
                    } else if (context.showType == 1) {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (o.eS(str)) {
                            intent.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent, str);
                            if (context.wsj) {
                                context.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                                context.finish();
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", intent);
                        }
                    } else if (context.showType != 2) {
                    } else {
                        if (bg.mA(str)) {
                            w.e("MicroMsg.VoiceSearchResultUI", "username is null " + str);
                        } else if (o.fa(str)) {
                            if (m.ye()) {
                                d.b(context.uSU.uTo, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (o.fc(str)) {
                            if (m.yb()) {
                                d.b(context.uSU.uTo, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (o.fb(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (o.fg(str)) {
                            MMAppMgr.cancelNotification(str);
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (o.eY(str)) {
                            if (m.yn()) {
                                context.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (o.fl(str)) {
                            if (m.yi()) {
                                intent = new Intent();
                                intent.putExtra(Columns.TYPE, 20);
                                d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (o.ft(str)) {
                            if (m.yj()) {
                                intent = new Intent();
                                intent.putExtra(Columns.TYPE, 11);
                                d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (o.fd(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (o.fe(str)) {
                            if (m.yl()) {
                                d.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (o.fk(str)) {
                            if (m.yf()) {
                                context.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (o.fi(str) || o.fj(str) || o.ff(str) || o.fm(str) || o.fn(str) || o.eZ(str) || o.fw(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else {
                            context.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        }
                    }
                }
            }
        });
        I(this.wsh);
    }

    private static String[] H(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        w.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (String str : strArr) {
            String eK = n.eK(str);
            w.d("MicroMsg.VoiceSearchResultUI", "displayname " + eK);
            if (!hashMap.containsValue(eK) || !o.dH(str)) {
                w.d("MicroMsg.VoiceSearchResultUI", "username " + str);
                hashMap.put(eK, str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.wsg.aEW();
    }

    public void onPause() {
        super.onPause();
        this.wsi = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (!this.wsi) {
                g.oUh.A(10452, this.hNV + "," + this.lrE + "," + (this.wsh == null ? 0 : this.wsh.length) + ",0");
            }
            if (this.wsj) {
                moveTaskToBack(true);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    static boolean Uy(String str) {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = ap.yY().hkK.a(o.hlr, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                w.d("MicroMsg.VoiceSearchResultUI", "block user " + string);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e, "", new Object[0]);
            }
        }
        cursorArr[1] = ap.yY().hkL.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        w.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            return true;
        }
        return false;
    }

    private void I(String[] strArr) {
        List arrayList = new ArrayList();
        if (!(strArr == null || this.wsg == null)) {
            for (String str : strArr) {
                if (this.wsg.Ux(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.wrV.setVisibility(0);
            if (this.wrU != null) {
                this.wrV.setText(this.wrU);
            } else {
                this.wrV.setText(getString(R.l.dCz));
            }
        } else {
            this.wrV.setVisibility(8);
        }
        if (this.wsg != null) {
            this.wsg.cW(arrayList);
        }
    }

    protected final int getLayoutId() {
        return R.i.dpI;
    }
}
