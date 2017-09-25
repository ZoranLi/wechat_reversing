package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.eb;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements com.tencent.mm.plugin.exdevice.model.e.b, e {
    private ListView Fg;
    private p iLz;
    private final BroadcastReceiver iRM = new BroadcastReceiver(this) {
        final /* synthetic */ ExdeviceAddDataSourceUI lil;

        {
            this.lil = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                    if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                        this.lil.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 lio;

                            {
                                this.lio = r1;
                            }

                            public final void run() {
                                if (!this.lio.lil.lij || this.lio.lil.lii.isProviderEnabled("gps")) {
                                    this.lio.lil.lR(3);
                                    w.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                    return;
                                }
                                this.lio.lil.lR(4);
                            }
                        });
                        if (!this.lil.lij || this.lil.lii.isProviderEnabled("gps")) {
                            ad.apE();
                            com.tencent.mm.plugin.exdevice.model.e.apg();
                        }
                    }
                } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10 && !com.tencent.mm.plugin.h.a.e.a.adm()) {
                    this.lil.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 lio;

                        {
                            this.lio = r1;
                        }

                        public final void run() {
                            this.lio.lil.lR(1);
                            w.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                        }
                    });
                    ad.apF().acS();
                }
            }
            if (!this.lil.lij || !"android.location.MODE_CHANGED".equals(action)) {
                return;
            }
            if (this.lil.lii.isProviderEnabled("gps")) {
                this.lil.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 lio;

                    {
                        this.lio = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                            this.lio.lil.lR(3);
                            w.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                            return;
                        }
                        this.lio.lil.lR(1);
                    }
                });
                if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                    ad.apE();
                    com.tencent.mm.plugin.exdevice.model.e.apg();
                    return;
                }
                return;
            }
            this.lil.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass4 lio;

                {
                    this.lio = r1;
                }

                public final void run() {
                    this.lio.lil.lR(4);
                    w.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                }
            });
            ad.apF().acS();
        }
    };
    private View kPJ;
    private a lic;
    private List<b> lid;
    private TextView lie;
    private TextView lif;
    private TextView lig;
    private RelativeLayout lih;
    private LocationManager lii;
    private boolean lij = false;
    private l lik;

    private static final class a extends BaseAdapter {
        private List<b> lid = new LinkedList();
        private com.tencent.mm.ah.a.a.c lir;

        private static class a {
            ImageView jbU;
            TextView kzl;
        }

        public final /* synthetic */ Object getItem(int i) {
            return lS(i);
        }

        public a() {
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.g.beY;
            this.lir = aVar.Hg();
        }

        public final void ao(List<b> list) {
            this.lid.clear();
            if (list != null && list.size() != 0) {
                this.lid.addAll(list);
            }
        }

        public final b vo(String str) {
            if (!bg.mA(str)) {
                for (b bVar : this.lid) {
                    if (str.equalsIgnoreCase(bVar.mac)) {
                        return bVar;
                    }
                }
            }
            return null;
        }

        public final int getCount() {
            return this.lid.size();
        }

        public final b lS(int i) {
            return (b) this.lid.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            b lS = lS(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dbn, null);
                aVar2.jbU = (ImageView) view.findViewById(R.h.bWv);
                aVar2.kzl = (TextView) view.findViewById(R.h.cml);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            w.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), lS.name, lS.mac});
            aVar.kzl.setText(lS.name);
            n.GW().a(lS.iconUrl, aVar.jbU, this.lir);
            return view;
        }
    }

    private static class b {
        String fGV;
        public String iconUrl;
        int lis = c.lit;
        String mac;
        String name;
    }

    private enum c {
        ;

        static {
            lit = 1;
            liu = 2;
            liv = 3;
            liw = new int[]{lit, liu, liv};
        }
    }

    protected final int getLayoutId() {
        return R.i.dbo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lil.finish();
                return true;
            }
        });
        zi(R.l.efi);
        if (!(!f.eo(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.lij = true;
        }
        this.lid = new LinkedList();
        this.lii = (LocationManager) this.uSU.uTo.getSystemService("location");
        KC();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.uSU.uTo.registerReceiver(this.iRM, intentFilter);
        ap.vd().a(536, this);
        ap.vd().a(1706, this);
        ad.apE().a((com.tencent.mm.plugin.exdevice.model.e.b) this);
        if (!com.tencent.mm.plugin.h.a.e.a.bL(this.uSU.uTo)) {
            w.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            lR(2);
        } else if (!com.tencent.mm.plugin.h.a.e.a.adm()) {
            w.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            lR(1);
        } else if (this.lii == null || !this.lij || this.lii.isProviderEnabled("gps")) {
            ad.apE();
            com.tencent.mm.plugin.exdevice.model.e.apg();
        } else {
            w.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            lR(4);
        }
    }

    private void lR(int i) {
        switch (i) {
            case 1:
                this.lih.setVisibility(8);
                this.lif.setText(R.l.efy);
                this.lig.setText(R.l.efn);
                return;
            case 2:
                this.lih.setVisibility(8);
                this.lif.setText(R.l.efw);
                this.lig.setText("");
                return;
            case 3:
                this.lih.setVisibility(0);
                this.kPJ.setVisibility(0);
                return;
            case 4:
                this.lih.setVisibility(8);
                this.lif.setText(R.l.efy);
                this.lig.setText(R.l.efZ);
                return;
            default:
                return;
        }
    }

    protected final void KC() {
        this.Fg = (ListView) findViewById(R.h.cbx);
        View inflate = View.inflate(this, R.i.dbq, null);
        this.lih = (RelativeLayout) findViewById(R.h.cAj);
        this.kPJ = View.inflate(this, R.i.dbp, null);
        this.lie = (TextView) findViewById(R.h.czN);
        this.lif = (TextView) findViewById(R.h.bMo);
        this.lig = (TextView) findViewById(R.h.bMp);
        String string = getString(R.l.egC);
        String string2 = getString(R.l.efD);
        CharSequence spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(R.e.aUA), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.model.f.S(this.lil.uSU.uTo, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }, string.length(), string.length() + string2.length(), 33);
        this.lie.setMovementMethod(LinkMovementMethod.getInstance());
        this.lie.setText(spannableString);
        this.Fg.addHeaderView(inflate, null, false);
        this.Fg.addFooterView(this.kPJ, null, false);
        this.lic = new a();
        this.Fg.setAdapter(this.lic);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b lS = this.lil.lic.lS(i - ((ListView) adapterView).getHeaderViewsCount());
                if (lS.lis == c.lit) {
                    if (ExdeviceAddDataSourceUI.W(lS.mac, true)) {
                        this.lil.runOnUiThread(new Runnable(this.lil, lS.mac) {
                            final /* synthetic */ ExdeviceAddDataSourceUI lil;

                            public final void run() {
                                this.lil.iLz = g.a(this.lil.uSU.uTo, this.lil.getString(R.l.dJd), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass3 lin;

                                    {
                                        this.lin = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(this.lin.lil.lik);
                                        this.lin.lil.lik = null;
                                        b vo = this.lin.lil.lic.vo(r2);
                                        if (vo != null) {
                                            vo.lis = c.lit;
                                        }
                                    }
                                });
                            }
                        });
                        lS.lis = c.liu;
                        this.lil.lic.notifyDataSetChanged();
                        return;
                    }
                    w.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final void run() {
                w.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
                com.tencent.mm.sdk.b.a.urY.m(new pz());
            }
        });
        ap.vd().b(536, this);
        ap.vd().b(1706, this);
        this.uSU.uTo.unregisterReceiver(this.iRM);
        ad.apE().b(this);
        ad.apF().acS();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            w.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
        } else if (kVar.getType() == 536) {
            aqa();
            this.lik = null;
            ga apm = ((l) kVar).apm();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", com.tencent.mm.plugin.exdevice.j.b.vx(com.tencent.mm.plugin.exdevice.j.b.vy(apm.tjp.tiU)));
                W(com.tencent.mm.plugin.exdevice.j.b.vy(apm.tjp.tiU), false);
                setResult(-1, intent);
                finish();
                return;
            }
            b vo = this.lic.vo(com.tencent.mm.plugin.exdevice.j.b.vy(apm.tjp.tiU));
            if (vo != null) {
                vo.lis = c.lit;
                W(vo.mac, false);
            }
            w.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        } else if (kVar.getType() == 1706) {
            awo app = ((t) kVar).app();
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[]{Long.valueOf(app.tjp.gtW)});
                if (0 == (app.tjp.gtW & 1)) {
                    return;
                }
                if (ad.apt().bT(app.tjo.jNm, app.tjo.thD) != null) {
                    w.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[]{app.tjp.tiU});
                    return;
                }
                b bVar = new b();
                bVar.name = app.tja.tLj == null ? "" : com.tencent.mm.platformtools.n.a(app.tja.tLj);
                bVar.mac = com.tencent.mm.plugin.exdevice.j.b.vy(app.tjp.tiU);
                bVar.fGV = app.tiZ;
                bVar.iconUrl = app.tjp.muU;
                this.lid.add(bVar);
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[]{bVar.mac, bVar.name});
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceAddDataSourceUI lil;

                    {
                        this.lil = r1;
                    }

                    public final void run() {
                        this.lil.lic.ao(this.lil.lid);
                        this.lil.lic.notifyDataSetChanged();
                    }
                });
                return;
            }
            w.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public final void j(String str, String str2, boolean z) {
        w.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (z) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI lil;

                {
                    this.lil = r1;
                }

                public final void run() {
                    this.lil.kPJ.setVisibility(8);
                    this.lil.lic.notifyDataSetChanged();
                }
            });
        }
        if (bg.mA(str2)) {
            w.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        int i = 0;
        while (i < this.lid.size()) {
            int i2;
            b bVar = (b) this.lid.get(i);
            if (bVar == null || bg.mA(bVar.mac)) {
                i2 = i - 1;
                this.lid.remove(i);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[]{str2});
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = ap.vd().a(new t(str2.replaceAll(":", ""), null, null), 0);
        w.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[]{Boolean.valueOf(a), str2});
    }

    public final void d(String str, int i, long j) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            return;
        }
        final b vo = this.lic.vo(str);
        if (vo == null) {
            w.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[]{str});
            return;
        }
        if (vo.lis == c.liu && i == 4) {
            vo.lis = c.lit;
            aqa();
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI lil;

                public final void run() {
                    g.a(this.lil, R.l.efG, R.l.efE, R.l.efF, R.l.efH, false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 liq;

                        {
                            this.liq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.liq.lil.lid.remove(vo);
                            this.liq.lil.lic.ao(this.liq.lil.lid);
                            this.liq.lil.lic.notifyDataSetChanged();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 liq;

                        {
                            this.liq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.exdevice.model.f.S(this.liq.lil.uSU.uTo, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
                        }
                    }).show();
                }
            });
        } else if (i == 2) {
            if (vo.lis == c.liu) {
                vo.lis = c.liv;
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[]{vo.mac, vo.name});
                if (vo.fGV != null) {
                    this.lik = new l(vo.fGV, 0);
                    ap.vd().a(this.lik, 0);
                }
            } else {
                w.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[]{str});
                W(str, false);
            }
        } else if (i != 1 && i != 2) {
            vo.lis = c.lit;
        } else {
            return;
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final void run() {
                this.lil.lic.notifyDataSetChanged();
            }
        });
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    private static boolean W(String str, boolean z) {
        com.tencent.mm.sdk.b.b ebVar = new eb();
        ebVar.fHZ.mac = str;
        ebVar.fHZ.fGt = z;
        if (com.tencent.mm.sdk.b.a.urY.m(ebVar)) {
            return true;
        }
        w.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[]{str});
        return false;
    }

    private void aqa() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lil;

            {
                this.lil = r1;
            }

            public final void run() {
                if (this.lil.iLz != null && this.lil.iLz.isShowing()) {
                    this.lil.iLz.dismiss();
                }
            }
        });
    }
}
