package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.c;
import com.tencent.mm.plugin.address.model.h;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements b, e {
    private String fSz = "";
    private int itA = 0;
    private Dialog ita = null;
    private AddrEditView iva;
    private AddrEditView ivb;
    private AddrEditView ivc;
    private AddrEditView ivd;
    private AddrEditView ive;
    private com.tencent.mm.plugin.address.d.b ivf = null;
    private com.tencent.mm.plugin.address.d.b ivg = new com.tencent.mm.plugin.address.d.b();

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        if (walletAddAddressUI.itA != 0) {
            w.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.ivg.toString());
            a.OT().OV();
            ap.vd().a(new h(walletAddAddressUI.ivg), 0);
            walletAddAddressUI.ita = g.a(walletAddAddressUI, "", true, new OnCancelListener(walletAddAddressUI) {
                final /* synthetic */ WalletAddAddressUI ivh;

                {
                    this.ivh = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            return;
        }
        w.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.ivg.toString());
        ap.vd().a(new c(walletAddAddressUI.ivg), 0);
        walletAddAddressUI.ita = g.a(walletAddAddressUI, "", true, new OnCancelListener(walletAddAddressUI) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(415, this);
        ap.vd().a(418, this);
        w.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        w.yu(0);
        this.itA = getIntent().getIntExtra("address_id", 0);
        if (this.itA == 0) {
            zi(R.l.dCn);
        } else {
            zi(R.l.dCE);
        }
        KC();
    }

    public final void KC() {
        a.OT().OU();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cRI);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.iva = (AddrEditView) findViewById(R.h.bnD);
        this.ivb = (AddrEditView) findViewById(R.h.bny);
        this.ivc = (AddrEditView) findViewById(R.h.bnz);
        this.ivd = (AddrEditView) findViewById(R.h.bnK);
        this.ive = (AddrEditView) findViewById(R.h.bnF);
        this.iva.itV = this;
        this.ivb.itV = this;
        this.ivc.itV = this;
        this.ivd.itV = this;
        this.ive.itV = this;
        this.iva.itU = new AddrEditView.a(this) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final void onClick() {
                w.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ivh, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ()});
                if (com.tencent.mm.pluginsdk.i.a.a(this.ivh, "android.permission.READ_CONTACTS", 48, null, null)) {
                    this.ivh.Pf();
                }
            }
        };
        this.ivb.itU = new AddrEditView.a(this) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final void onClick() {
                w.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ivh, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                if (com.tencent.mm.pluginsdk.i.a.a(this.ivh, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    this.ivh.Pg();
                }
            }
        };
        this.ivb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final void onClick(View view) {
                this.ivh.startActivityForResult(new Intent(this.ivh, WalletMultiRcptSelectUI.class), 1);
            }
        });
        if (this.itA != 0) {
            this.ivf = a.OT().hm(this.itA);
            this.iva.mU(this.ivf.itx);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.ivf.its)) {
                stringBuilder.append(this.ivf.its);
            }
            if (!TextUtils.isEmpty(this.ivf.itt)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.ivf.itt);
            }
            if (!TextUtils.isEmpty(this.ivf.itu)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.ivf.itu);
            }
            this.ivb.mU(stringBuilder.toString());
            this.ivc.mU(this.ivf.itw);
            this.ivd.mU(this.ivf.itv);
            this.ive.mU(this.ivf.ity);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivh.OZ();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletAddAddressUI ivh;

            {
                this.ivh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ivh.OX()) {
                    if (this.ivh.itA != 0) {
                        this.ivh.ivf = a.OT().hm(this.ivh.itA);
                        w.d("MicroMsg.WalletAddAddressUI", "get addr " + this.ivh.ivf.toString());
                        WalletAddAddressUI.a(this.ivh.ivf, this.ivh.ivg);
                    } else {
                        this.ivh.ivf = new com.tencent.mm.plugin.address.d.b();
                    }
                    String text = this.ivh.iva.getText();
                    String text2 = this.ivh.ivb.getText();
                    String text3 = this.ivh.ivc.getText();
                    String text4 = this.ivh.ivd.getText();
                    String text5 = this.ivh.ive.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        this.ivh.ivg.its = split[0];
                    }
                    if (split.length >= 2) {
                        this.ivh.ivg.itt = split[1];
                    }
                    if (split.length >= 3) {
                        this.ivh.ivg.itu = split[2];
                    } else {
                        this.ivh.ivg.itu = "";
                    }
                    this.ivh.ivg.itw = text3;
                    this.ivh.ivg.itx = text;
                    this.ivh.ivg.ity = text5;
                    this.ivh.ivg.itv = text4;
                    if (!bg.mA(this.ivh.fSz)) {
                        this.ivh.ivg.itz = this.ivh.fSz;
                    }
                    WalletAddAddressUI.o(this.ivh);
                }
                return true;
            }
        }, l.b.uTY);
        OX();
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(415, this);
        ap.vd().b(418, this);
        com.tencent.mm.plugin.address.model.l OT = a.OT();
        w.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : OT.itk.values()) {
            clear.clear();
        }
        for (List clear2 : OT.itl.values()) {
            clear2.clear();
        }
        OT.itj.clear();
        OT.itk.clear();
        OT.itl.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    str = intent.getStringExtra("karea_result");
                    if (!bg.mA(str)) {
                        w.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + str);
                        this.ivb.mU(str);
                    }
                    str = intent.getStringExtra("kpost_code");
                    if (!bg.mA(str)) {
                        w.d("MicroMsg.WalletAddAddressUI", "post:" + str);
                        this.ivd.mU(str);
                    }
                    this.fSz = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        w.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        return;
                    }
                    String str2;
                    String[] b = com.tencent.mm.pluginsdk.a.b(getBaseContext(), data);
                    if (b == null || b.length != 2) {
                        g.b(this, getString(R.l.eAp), "", true);
                        str2 = null;
                    } else {
                        str = b[0];
                        str2 = b[1];
                    }
                    this.iva.mU(str);
                    this.ive.mU(str2);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                        OX();
                        return;
                    } else {
                        g.b(this, getString(R.l.eAp), "", true);
                        return;
                    }
                }
                return;
            case 3:
                if (i2 == -1) {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        w.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            StringBuilder stringBuilder;
                            if (a.OT().t(addr.hCF, addr.hCH, addr.hCI)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(addr.hCF);
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hCH);
                                if (!TextUtils.isEmpty(addr.hCI)) {
                                    stringBuilder.append(" ");
                                    stringBuilder.append(addr.hCI);
                                }
                                this.ivb.mU(stringBuilder.toString());
                            } else {
                                this.ivb.mU("");
                            }
                            stringBuilder = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.hCJ)) {
                                stringBuilder.append(addr.hCJ);
                            }
                            if (!TextUtils.isEmpty(addr.hCK)) {
                                stringBuilder.append(addr.hCK);
                            }
                            if (!TextUtils.isEmpty(addr.hCL)) {
                                stringBuilder.append(addr.hCL);
                            }
                            if (!TextUtils.isEmpty(addr.hCN)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hCN);
                            }
                            this.ivc.mU(stringBuilder.toString());
                            RcptItem s = a.OT().s(addr.hCF, addr.hCH, addr.hCI);
                            if (s != null) {
                                this.ivd.mU(s.itg);
                                this.fSz = s.code;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dpT;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ita != null) {
            this.ita.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.OT().iti;
            if (aVar.itq.size() > 0) {
                a(this.ivg, this.ivf);
                com.tencent.mm.plugin.address.d.b bVar = (com.tencent.mm.plugin.address.d.b) aVar.itq.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                g.a(this, str, "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI ivh;

                    {
                        this.ivh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case -3100:
                g.a(this, R.l.dCm, 0, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI ivh;

                    {
                        this.ivh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ivh.finish();
                    }
                });
                return;
            default:
                g.a(this, R.l.dCk, 0, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI ivh;

                    {
                        this.ivh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
        }
    }

    private boolean OX() {
        boolean z = false;
        boolean z2 = true;
        if (!this.iva.Pb()) {
            z2 = false;
        }
        if (!this.ivc.Pb()) {
            z2 = false;
        }
        if (!this.ivb.Pb()) {
            z2 = false;
        }
        if (!this.ivd.Pb()) {
            z2 = false;
        }
        if (this.ive.Pb()) {
            z = z2;
        }
        kr(z);
        return z;
    }

    public final void OY() {
        OX();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        OZ();
        return true;
    }

    private void OZ() {
        int i;
        int i2 = 1;
        int i3 = R.l.dCq;
        if (this.itA == 0) {
            i3 = R.l.dCp;
        }
        if (this.iva.Pc()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.ivc.Pc()) {
            i = 1;
        }
        if (this.ivb.Pc()) {
            i = 1;
        }
        if (this.ivd.Pc()) {
            i = 1;
        }
        if (!this.ive.Pc()) {
            i2 = i;
        }
        if (i2 != 0) {
            g.a(this, i3, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletAddAddressUI ivh;

                {
                    this.ivh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ivh.setResult(0);
                    this.ivh.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void Pf() {
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 2);
    }

    private void Pg() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.ivb.getText())) {
            stringBuilder.append(this.ivb.getText());
        }
        if (!TextUtils.isEmpty(this.ivc.getText())) {
            stringBuilder.append(this.ivc.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        d.b(this, "location", ".ui.RedirectUI", intent, 3);
    }

    private static void a(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.its = bVar.its;
            bVar2.itt = bVar.itt;
            bVar2.itu = bVar.itu;
            bVar2.itw = bVar.itw;
            bVar2.itx = bVar.itx;
            bVar2.ity = bVar.ity;
            bVar2.itv = bVar.itv;
            bVar2.itz = bVar.itz;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    Pf();
                    return;
                } else {
                    g.a(this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI ivh;

                        {
                            this.ivh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.ivh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI ivh;

                        {
                            this.ivh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            case 64:
                if (iArr[0] == 0) {
                    Pg();
                    return;
                } else {
                    g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI ivh;

                        {
                            this.ivh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.ivh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI ivh;

                        {
                            this.ivh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
