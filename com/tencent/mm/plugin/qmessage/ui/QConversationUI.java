package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements e {
    private TextView jWk;
    private d jWo = new d(this) {
        final /* synthetic */ QConversationUI ozb;

        {
            this.ozb = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            QConversationUI.a(this.ozb, this.ozb.oza);
        }
    };
    private boolean jWp = false;
    private x kWy;
    private boolean nxL = false;
    private ListView oyT;
    private c oyU;
    private c oyV;
    private boolean oyW = false;
    private String oyX;
    private String oyY;
    private boolean oyZ = false;
    private String oza;

    static /* synthetic */ void a(QConversationUI qConversationUI, int i) {
        if (i <= 0) {
            qConversationUI.jWk.setVisibility(0);
            qConversationUI.oyT.setVisibility(8);
            return;
        }
        qConversationUI.jWk.setVisibility(8);
        qConversationUI.oyT.setVisibility(0);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, final String str) {
        ap.yY();
        ce Ah = com.tencent.mm.u.c.wT().Ah(str);
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.d(str, Ah.field_msgSvrId));
        qConversationUI.jWp = false;
        qConversationUI.getString(R.l.dIO);
        final ProgressDialog a = g.a(qConversationUI, qConversationUI.getString(R.l.dJd), true, new OnCancelListener(qConversationUI) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.ozb.jWp = true;
            }
        });
        ay.a(str, new a(qConversationUI) {
            final /* synthetic */ QConversationUI ozb;

            public final boolean zs() {
                return this.ozb.jWp;
            }

            public final void zr() {
                ap.yY();
                com.tencent.mm.u.c.wW().Rl(str);
                if (a != null) {
                    a.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        if (str == null) {
            w.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            return;
        }
        f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str, true);
        if (aJ == null || !p.n(qConversationUI.uSU.uTo, aJ.field_packageName)) {
            if (bg.mA(str2)) {
                str2 = p.t(qConversationUI.uSU.uTo, str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bb.d.b(qConversationUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
        } else if (aJ.field_status == 3) {
            w.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + aJ.field_packageName);
        } else if (p.b(qConversationUI.uSU.uTo, aJ)) {
            w.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent2.setClassName(aJ.field_packageName, at(qConversationUI.uSU.uTo, aJ.field_packageName));
            intent2.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(9, null);
            int intValue = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            if (intValue != 0) {
                try {
                    byte[] bytes = String.valueOf(intValue).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    intValue = 0;
                    int i = 0;
                    while (intValue < length) {
                        byte b = bytes2[intValue];
                        if (i >= bytes.length) {
                            break;
                        }
                        int i2 = i + 1;
                        bytes[i] = (byte) (b ^ bytes[i]);
                        intValue++;
                        i = i2;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
            } catch (Exception e2) {
            }
        } else {
            w.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", new Object[]{aJ.field_appName});
            Toast.makeText(qConversationUI.uSU.uTo, qConversationUI.getString(R.l.eoN, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(qConversationUI.uSU.uTo, aJ, null)}), 1).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dpe;
    }

    public void onDestroy() {
        this.oyU.aEW();
        if (this.oyV != null) {
            ap.vd().c(this.oyV);
            ap.vd().b(this.oyV.getType(), this);
            this.oyV = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        aUh();
        ap.yY();
        com.tencent.mm.u.c.wW().a(this.oyU);
        this.oyU.a(null, null);
    }

    private static void aUh() {
        ap.yY();
        ce pl = com.tencent.mm.u.c.wT().pl(2);
        if (pl != null && pl.field_msgId > 0) {
            w.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + pl.field_createTime);
            ap.yY();
            com.tencent.mm.u.c.vr().set(12295, Long.valueOf(pl.field_createTime));
        }
        ap.yY();
        aj Rm = com.tencent.mm.u.c.wW().Rm("qmessage");
        if (Rm == null || bg.mz(Rm.field_username).length() <= 0) {
            w.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            return;
        }
        Rm.dt(0);
        ap.yY();
        if (com.tencent.mm.u.c.wW().a(Rm, Rm.field_username) == -1) {
            w.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
    }

    public void onPause() {
        w.v("MicroMsg.QConversationUI", "on pause");
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.oyU);
        aUh();
        this.oyU.onPause();
        super.onPause();
    }

    protected final void KC() {
        this.nxL = getIntent().getBooleanExtra("finish_direct", false);
        w.d("MicroMsg.QConversationUI", "isFromSearch  " + this.nxL);
        ap.yY();
        this.kWy = com.tencent.mm.u.c.wR().Rc("qmessage");
        String str = "can not find qmessage";
        boolean z = this.kWy != null && ((int) this.kWy.gTQ) > 0;
        Assert.assertTrue(str, z);
        this.oyT = (ListView) findViewById(R.h.cJi);
        this.jWk = (TextView) findViewById(R.h.bLU);
        this.jWk.setText(R.l.eet);
        this.oyU = new c(this, new k.a(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void OH() {
                QConversationUI qConversationUI = this.ozb;
                String tK = this.ozb.kWy.tK();
                int fM = com.tencent.mm.u.p.fM(o.hlt);
                if (fM <= 0) {
                    qConversationUI.qP(tK);
                } else {
                    qConversationUI.qP(tK + "(" + fM + ")");
                }
                QConversationUI.a(this.ozb, this.ozb.oyU.getCount());
            }

            public final void OI() {
            }
        });
        this.oyU.a(new MMSlideDelView.c(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final int cb(View view) {
                return this.ozb.oyT.getPositionForView(view);
            }
        });
        this.oyU.a(new MMSlideDelView.f(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void s(View view, int i) {
                this.ozb.oyT.performItemClick(view, i, 0);
            }
        });
        this.oyU.a(new MMSlideDelView.e(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.QConversationUI", "onItemDel object null");
                } else {
                    QConversationUI.a(this.ozb, obj.toString());
                }
            }
        });
        this.oyT.setAdapter(this.oyU);
        this.oyT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ae aeVar = (ae) this.ozb.oyU.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", aeVar.field_username);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.qmessage.a.imv.e(intent, this.ozb.uSU.uTo);
            }
        });
        final com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this);
        this.oyT.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ QConversationUI ozb;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.ozb.oyT.getHeaderViewsCount()) {
                    w.w("MicroMsg.QConversationUI", "on header view long click, ignore");
                    return true;
                }
                gVar.a(view, i, j, this.ozb, this.ozb.jWo, 0, 0);
                return true;
            }
        });
        com.tencent.mm.plugin.qmessage.a.oyy.cT(1010);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ozb.goBack();
                return true;
            }
        });
        AnonymousClass12 anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.ozb.oyT);
            }
        };
        ap.yY();
        this.oyX = (String) com.tencent.mm.u.c.vr().get(77, "");
        ap.yY();
        this.oyY = (String) com.tencent.mm.u.c.vr().get(78, "");
        if (this.oyV == null) {
            this.oyV = new c();
            ap.vd().a(this.oyV.getType(), this);
        }
        ap.vd().a(this.oyV, 0);
        aUi();
        com.tencent.mm.plugin.qmessage.a.oyy.cT(1010);
    }

    private static String at(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        return null;
    }

    private void aUi() {
        this.uSU.bQf();
        if (!bg.mA(this.oyX)) {
            this.oyW = true;
            a(0, R.l.dBL, R.k.ctC, new OnMenuItemClickListener(this) {
                final /* synthetic */ QConversationUI ozb;

                {
                    this.ozb = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (!bg.mA(this.ozb.oyX)) {
                        QConversationUI.a(this.ozb, this.ozb.oyX, this.ozb.oyY);
                    }
                    return true;
                }
            });
        }
        a(2, R.l.dBM, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ QConversationUI ozb;

            {
                this.ozb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.ozb.kWy.field_username);
                intent.putExtra("Chat_Readonly", true);
                com.tencent.mm.plugin.qmessage.a.imv.d(intent, this.ozb.uSU.uTo);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        if (this.nxL) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.imv.t(intent, this);
        overridePendingTransition(R.a.aQL, R.a.aRn);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ae aeVar = (ae) this.oyU.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        ap.yY();
        contextMenu.setHeaderTitle(com.tencent.mm.u.c.wR().Rc(aeVar.field_username).tL());
        contextMenu.add(0, 0, 0, R.l.ezd);
        this.oza = aeVar.field_username;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        String str2 = null;
        w.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    yu yuVar;
                    Object obj;
                    String str3;
                    c cVar = (c) kVar;
                    if (cVar.hWk != null) {
                        yuVar = (yu) cVar.hWk.hsk.hsr;
                        if (yuVar != null) {
                            obj = yuVar.tFa;
                            if (cVar.hWk != null) {
                                yuVar = (yu) cVar.hWk.hsk.hsr;
                                if (yuVar != null) {
                                    str3 = yuVar.tky;
                                    if (cVar.hWk != null) {
                                        yuVar = (yu) cVar.hWk.hsk.hsr;
                                        if (yuVar != null) {
                                            str2 = yuVar.tFb;
                                        }
                                    }
                                    if (!bg.mA(str2)) {
                                        this.oyX = str2;
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(77, str2);
                                    }
                                    this.oyY = str3;
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().set(78, str3);
                                    if (!this.oyW) {
                                        aUi();
                                    }
                                    w.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                                    return;
                                }
                            }
                            str3 = null;
                            if (cVar.hWk != null) {
                                yuVar = (yu) cVar.hWk.hsk.hsr;
                                if (yuVar != null) {
                                    str2 = yuVar.tFb;
                                }
                            }
                            if (bg.mA(str2)) {
                                this.oyX = str2;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(77, str2);
                            }
                            this.oyY = str3;
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(78, str3);
                            if (this.oyW) {
                                aUi();
                            }
                            w.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                            return;
                        }
                    }
                    String str4 = null;
                    if (cVar.hWk != null) {
                        yuVar = (yu) cVar.hWk.hsk.hsr;
                        if (yuVar != null) {
                            str3 = yuVar.tky;
                            if (cVar.hWk != null) {
                                yuVar = (yu) cVar.hWk.hsk.hsr;
                                if (yuVar != null) {
                                    str2 = yuVar.tFb;
                                }
                            }
                            if (bg.mA(str2)) {
                                this.oyX = str2;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(77, str2);
                            }
                            this.oyY = str3;
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(78, str3);
                            if (this.oyW) {
                                aUi();
                            }
                            w.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                            return;
                        }
                    }
                    str3 = null;
                    if (cVar.hWk != null) {
                        yuVar = (yu) cVar.hWk.hsk.hsr;
                        if (yuVar != null) {
                            str2 = yuVar.tFb;
                        }
                    }
                    if (bg.mA(str2)) {
                        this.oyX = str2;
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(77, str2);
                    }
                    this.oyY = str3;
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(78, str3);
                    if (this.oyW) {
                        aUi();
                    }
                    w.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                    return;
                }
                return;
            default:
                return;
        }
    }
}
