package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements e {
    private ListView Fg;
    BroadcastReceiver iRM = new BroadcastReceiver(this) {
        final /* synthetic */ ExdeviceBindDeviceGuideUI liN;

        {
            this.liN = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent != null) {
                String action = intent.getAction();
                w.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[]{action});
                int intExtra;
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && this.liN.liM) {
                    intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra == 12) {
                        if (!this.liN.lij || this.liN.lii.isProviderEnabled("gps")) {
                            this.liN.lR(2);
                            return;
                        }
                    } else if (intExtra == 10) {
                        this.liN.lR(3);
                        return;
                    } else {
                        return;
                    }
                } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && this.liN.liL) {
                    intExtra = intent.getIntExtra("wifi_state", -1);
                    w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[]{Integer.valueOf(intExtra)});
                    if (intExtra == 3) {
                        this.liN.lR(1);
                        return;
                    } else if (intExtra == 1) {
                        this.liN.lR(5);
                        return;
                    } else {
                        return;
                    }
                } else if (!this.liN.lij || !"android.location.MODE_CHANGED".equals(action)) {
                    return;
                } else {
                    if (this.liN.lii.isProviderEnabled("gps")) {
                        if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                            this.liN.lR(2);
                            return;
                        } else {
                            this.liN.lR(3);
                            return;
                        }
                    }
                }
                this.liN.lR(6);
            }
        }
    };
    private String lcq;
    private String lcr;
    private String lhH;
    private String lhZ;
    private TextView liA;
    private ScrollView liB;
    private ImageView liC;
    private TextView liD;
    private String liE;
    private String liF;
    private String liG;
    private String liH;
    private long liI;
    private ArrayList<String> liJ;
    private String liK;
    private boolean liL = false;
    private boolean liM = false;
    private String lia;
    private TextView lif;
    private LocationManager lii;
    private boolean lij = false;
    private a lix;
    private Button liy;
    private Button liz;
    private String mTitle;
    private String sk;

    private static final class a extends BaseAdapter {
        private ArrayList<String> liO;

        private static class a {
            TextView liP;
            TextView liQ;
            View liR;
            View liS;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public a(ArrayList<String> arrayList) {
            this.liO = arrayList;
        }

        public final int getCount() {
            if (this.liO != null) {
                return this.liO.size();
            }
            return 0;
        }

        private String hO(int i) {
            if (this.liO == null || this.liO.size() <= 0) {
                return null;
            }
            return (String) this.liO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.liO == null || this.liO.size() <= 0) {
                return null;
            }
            a aVar;
            CharSequence hO = hO(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dbr, null);
                aVar2.liQ = (TextView) view.findViewById(R.h.bGv);
                aVar2.liP = (TextView) view.findViewById(R.h.cGC);
                aVar2.liR = view.findViewById(R.h.cJp);
                aVar2.liS = view.findViewById(R.h.buJ);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.liP.setText(Integer.toString(i + 1));
            aVar.liQ.setText(hO);
            if (i == 0 && this.liO.size() == 1) {
                aVar.liR.setVisibility(4);
                aVar.liS.setVisibility(4);
                return view;
            } else if (i == 0) {
                aVar.liR.setVisibility(4);
                aVar.liS.setVisibility(0);
                return view;
            } else if (i != this.liO.size() - 1) {
                return view;
            } else {
                aVar.liS.setVisibility(4);
                aVar.liR.setVisibility(0);
                return view;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dbs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceGuideUI liN;

            {
                this.liN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.liN.finish();
                return true;
            }
        });
        if (!(!f.eo(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[]{VERSION.RELEASE});
            this.lij = true;
        }
        Intent intent = getIntent();
        this.liE = intent.getStringExtra("device_scan_mode");
        this.liF = intent.getStringExtra("device_scan_conn_proto");
        this.lcr = intent.getStringExtra("device_id");
        this.lhH = intent.getStringExtra("device_type");
        this.liG = intent.getStringExtra("device_title");
        this.lhZ = intent.getStringExtra("device_desc");
        this.lia = intent.getStringExtra("device_icon_url");
        this.sk = intent.getStringExtra("device_category_id");
        this.lcq = intent.getStringExtra("device_brand_name");
        this.liH = intent.getStringExtra("bind_ticket");
        this.liI = intent.getLongExtra("device_ble_simple_proto", -1);
        this.liJ = intent.getStringArrayListExtra("device_airkiss_steps");
        this.liK = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[]{Integer.valueOf(this.liJ.size())});
        this.lii = (LocationManager) this.uSU.uTo.getSystemService("location");
        this.Fg = (ListView) findViewById(R.h.bGu);
        View inflate = View.inflate(this, R.i.dbm, null);
        this.liA = (TextView) inflate.findViewById(R.h.cIU);
        this.lix = new a(this.liJ);
        this.Fg.addHeaderView(inflate);
        this.Fg.setDividerHeight(0);
        this.Fg.setClickable(false);
        this.Fg.setFooterDividersEnabled(false);
        this.Fg.setAdapter(this.lix);
        this.liC = (ImageView) findViewById(R.h.ccL);
        this.liB = (ScrollView) findViewById(R.h.bVK);
        this.liy = (Button) findViewById(R.h.bEH);
        this.liz = (Button) findViewById(R.h.cnX);
        this.lif = (TextView) findViewById(R.h.bMo);
        this.liD = (TextView) findViewById(R.h.bMp);
        String str = "";
        if (this.liE.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.liF.contains("wifi")) {
            this.liL = true;
            str = this.uSU.uTo.getString(R.l.dbx);
        } else if (this.liF.contains("blue")) {
            this.liM = true;
            str = this.uSU.uTo.getString(R.l.efq);
        } else {
            Assert.assertTrue(false);
        }
        qP(str);
        if (this.liM && !this.liL) {
            if (!com.tencent.mm.plugin.h.a.e.a.bL(this.uSU.uTo)) {
                w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                lR(4);
            } else if (!com.tencent.mm.plugin.h.a.e.a.adm()) {
                w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                lR(3);
            } else if (!(this.lii == null || !this.lij || this.lii.isProviderEnabled("gps"))) {
                w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                lR(6);
            }
            this.liy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExdeviceBindDeviceGuideUI liN;

                {
                    this.liN = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", this.liN.liE);
                    intent.putExtra("device_scan_conn_proto", this.liN.liF);
                    intent.putExtra("device_id", this.liN.lcr);
                    intent.putExtra("device_type", this.liN.lhH);
                    intent.putExtra("device_title", this.liN.liG);
                    intent.putExtra("device_desc", this.liN.lhZ);
                    intent.putExtra("device_icon_url", this.liN.lia);
                    intent.putExtra("device_category_id", this.liN.sk);
                    intent.putExtra("device_brand_name", this.liN.lcq);
                    intent.putExtra("bind_ticket", this.liN.liH);
                    intent.putExtra("device_ble_simple_proto", this.liN.liI);
                    intent.putExtra("encryptKey", this.liN.liK);
                    intent.putExtra("jumpToBindDevice", true);
                    if (this.liN.liM && !this.liN.liL) {
                        d.b(this.liN.uSU.uTo, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (this.liN.liL && !this.liN.liM) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        d.b(this.liN.uSU.uTo, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                }
            });
            this.liz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExdeviceBindDeviceGuideUI liN;

                {
                    this.liN = r1;
                }

                public final void onClick(View view) {
                    if (this.liN.liL && !this.liN.liM) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", this.liN.liE);
                        intent.putExtra("device_scan_conn_proto", this.liN.liF);
                        intent.putExtra("device_id", this.liN.lcr);
                        intent.putExtra("device_type", this.liN.lhH);
                        intent.putExtra("device_title", this.liN.liG);
                        intent.putExtra("device_desc", this.liN.lhZ);
                        intent.putExtra("device_icon_url", this.liN.lia);
                        intent.putExtra("device_category_id", this.liN.sk);
                        intent.putExtra("device_brand_name", this.liN.lcq);
                        intent.putExtra("bind_ticket", this.liN.liH);
                        d.b(this.liN.uSU.uTo, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.uSU.uTo.registerReceiver(this.iRM, intentFilter);
        }
        if (!this.liM && this.liL && !am.isWifi(this.uSU.uTo)) {
            w.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            lR(5);
            this.liy.setOnClickListener(/* anonymous class already generated */);
            this.liz.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter2.addAction("android.location.MODE_CHANGED");
            this.uSU.uTo.registerReceiver(this.iRM, intentFilter2);
        } else if (!this.liL || this.liM) {
            if (this.liM && !this.liL) {
                lR(2);
            }
            this.liy.setOnClickListener(/* anonymous class already generated */);
            this.liz.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter22 = new IntentFilter();
            intentFilter22.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter22.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter22.addAction("android.location.MODE_CHANGED");
            this.uSU.uTo.registerReceiver(this.iRM, intentFilter22);
        } else {
            lR(1);
            this.liy.setOnClickListener(/* anonymous class already generated */);
            this.liz.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter222 = new IntentFilter();
            intentFilter222.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter222.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter222.addAction("android.location.MODE_CHANGED");
            this.uSU.uTo.registerReceiver(this.iRM, intentFilter222);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.uSU.uTo.unregisterReceiver(this.iRM);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    private void lR(int i) {
        switch (i) {
            case 1:
                this.liy.setText(this.uSU.uTo.getString(R.l.dbx));
                this.liz.setText(this.uSU.uTo.getString(R.l.efm));
                this.liA.setText(this.uSU.uTo.getString(R.l.efI));
                break;
            case 2:
                this.liy.setText(this.uSU.uTo.getString(R.l.efC));
                this.liz.setVisibility(8);
                this.liA.setText(this.uSU.uTo.getString(R.l.efB));
                break;
            case 3:
                this.liC.setImageResource(R.k.dut);
                this.lif.setText(R.l.efy);
                this.liD.setText(R.l.efn);
                break;
            case 4:
                this.liC.setImageResource(R.k.dut);
                this.lif.setText(R.l.efw);
                this.liD.setText("");
                break;
            case 5:
                this.liC.setImageResource(R.k.dAJ);
                this.lif.setText(R.l.efy);
                this.liD.setText(R.l.efu);
                break;
            case 6:
                this.liC.setImageResource(R.k.dut);
                this.lif.setText(R.l.efy);
                this.liD.setText(R.l.efZ);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.liC.setVisibility(8);
                this.lif.setVisibility(8);
                this.liD.setVisibility(8);
                this.Fg.setVisibility(0);
                this.liB.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.liC.setVisibility(0);
                this.lif.setVisibility(0);
                this.Fg.setVisibility(8);
                this.liB.setVisibility(8);
                if (i == 4) {
                    this.liD.setVisibility(8);
                    return;
                } else {
                    this.liD.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
