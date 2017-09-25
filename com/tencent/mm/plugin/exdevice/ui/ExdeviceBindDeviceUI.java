package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements com.tencent.mm.plugin.exdevice.model.e.b, com.tencent.mm.y.e {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ListView Fg;
    private ProgressDialog isv;
    private TextView kna;
    private String lcq;
    private com.tencent.mm.plugin.exdevice.model.j.a lde;
    private String lhH;
    private a liT;
    private View liU;
    private TextView liV;
    private ImageView liW;
    private ScrollView liX;
    private View liY;
    private int liZ;
    private TextView lif;
    private TextView lig;
    private String lja;
    private String ljb;
    private boolean ljc = false;
    private com.tencent.mm.plugin.exdevice.model.j.a ljd;
    private boolean lje = false;
    private boolean ljf = false;

    private static final class a extends BaseAdapter {
        private com.tencent.mm.ah.a.a.c lir;
        List<f> ljn = new ArrayList();
        private String ljo;
        private int ljp;
        private String ljq;

        private static class a {
            ImageView jbU;
            TextView kzl;
        }

        public final /* synthetic */ Object getItem(int i) {
            return lT(i);
        }

        public a(String str, int i, String str2) {
            this.ljo = str;
            this.ljp = i;
            this.ljq = str2;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJe = R.e.aVP;
            this.lir = aVar.Hg();
        }

        public final void aqb() {
            for (int i = 0; i < this.ljn.size(); i++) {
                f fVar = (f) this.ljn.get(i);
                fVar.ljz = c(fVar);
            }
        }

        public final boolean b(f fVar) {
            if (vr(fVar.getKey()) < 0) {
                return false;
            }
            fVar.ljz = c(fVar);
            return true;
        }

        public final boolean vp(String str) {
            return vr(str) >= 0;
        }

        public final f vq(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            for (int i = 0; i < this.ljn.size(); i++) {
                f fVar = (f) this.ljn.get(i);
                if (!vs(fVar.aqc()) && str.equalsIgnoreCase(fVar.aqc())) {
                    return fVar;
                }
            }
            return null;
        }

        public final int getCount() {
            int i = 0;
            for (int i2 = 0; i2 < this.ljn.size(); i2++) {
                if (((f) this.ljn.get(i2)).ljz) {
                    i++;
                }
            }
            return i;
        }

        public final f lT(int i) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.ljn.size(); i3++) {
                if (((f) this.ljn.get(i3)).ljz) {
                    i2++;
                }
                if (i2 == i) {
                    return (f) this.ljn.get(i3);
                }
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            f lT = lT(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dbt, null);
                aVar2.kzl = (TextView) view.findViewById(R.h.cml);
                aVar2.jbU = (ImageView) view.findViewById(R.h.bWv);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (lT.ljE == null) {
                Assert.assertTrue(false);
            } else {
                String str;
                String str2;
                Object obj;
                CharSequence spannableString;
                if (lT.ljA == b.ljs) {
                    w.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[]{Integer.valueOf(i), lT.ljB.lju, lT.ljB.aQl, lT.ljE.tJL});
                    str = "";
                    str2 = lT.ljE.gtZ;
                    if (str2 != null && str2.length() >= 4) {
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else if (lT.ljB.aQl != null && lT.ljB.aQl.length() >= 4) {
                        str = lT.ljB.aQl;
                        str = str.substring(str.length() - 4, str.length());
                    }
                    obj = lT.ljE.tJL + " " + str;
                    spannableString = new SpannableString(obj);
                    spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.aUo)), lT.ljE.tJL.length() + 1, obj.length(), 17);
                    aVar.kzl.setText(spannableString);
                } else if (lT.ljA == b.ljr) {
                    str = "";
                    str2 = lT.ljE.gtZ;
                    if (str2 != null && str2.length() >= 4) {
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else if (lT.ljE.tiU != null && lT.ljE.tiU.length() >= 4) {
                        str = lT.ljE.tiU;
                        str = str.substring(str.length() - 4, str.length());
                    }
                    obj = lT.ljE.tJL + " " + str;
                    spannableString = new SpannableString(obj);
                    spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.aUo)), lT.ljE.tJL.length() + 1, obj.length(), 17);
                    aVar.kzl.setText(spannableString);
                } else {
                    Assert.assertTrue(false);
                }
                str = lT.ljE.muU;
                if (!vs(str)) {
                    n.GW().a(str, aVar.jbU, this.lir);
                }
            }
            return view;
        }

        private int vr(String str) {
            for (int i = 0; i < this.ljn.size(); i++) {
                if (((f) this.ljn.get(i)).getKey().compareTo(str) == 0) {
                    return i;
                }
            }
            return -1;
        }

        final int bW(String str, String str2) {
            for (int i = 0; i < this.ljn.size(); i++) {
                f fVar = (f) this.ljn.get(i);
                String Cg = fVar.Cg();
                String deviceId = fVar.getDeviceId();
                if (!vs(Cg) && !vs(deviceId) && str.compareTo(fVar.Cg()) == 0 && str2.compareTo(fVar.getDeviceId()) == 0) {
                    return i;
                }
            }
            return -1;
        }

        final boolean c(f fVar) {
            if (fVar.ljE == null) {
                return false;
            }
            if (this.ljp == e.ljx) {
                if (fVar.ljE.tJE == null || fVar.ljE.tJE.compareTo(this.ljo) != 0 || fVar.ljE.tJN == null || fVar.ljE.tJN.compareTo(this.ljq) != 0) {
                    return false;
                }
            } else if (this.ljp != e.ljw) {
                Assert.assertTrue(false);
                return false;
            } else if (fVar.ljE.gtV == 0) {
                return false;
            }
            return true;
        }

        private static boolean vs(String str) {
            return str == null || str.length() == 0;
        }
    }

    enum b {
        ;

        static {
            ljr = 1;
            ljs = 2;
            ljt = new int[]{ljr, ljs};
        }
    }

    private class c {
        public String aQl;
        final /* synthetic */ ExdeviceBindDeviceUI ljg;
        public String lju;

        public c(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.ljg = exdeviceBindDeviceUI;
        }
    }

    private class d {
        public String lcr;
        public String lhH;
        final /* synthetic */ ExdeviceBindDeviceUI ljg;

        public d(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.ljg = exdeviceBindDeviceUI;
        }
    }

    private enum e {
        ;

        static {
            ljv = 1;
            ljw = 2;
            ljx = 3;
            ljy = new int[]{ljv, ljw, ljx};
        }
    }

    private class f {
        public String liH;
        public int ljA = b.ljr;
        public c ljB;
        public d ljC;
        public aen ljD;
        public aeo ljE;
        public int ljF;
        public ame ljG;
        public String ljH;
        final /* synthetic */ ExdeviceBindDeviceUI ljg;
        public boolean ljz = false;

        public f(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.ljg = exdeviceBindDeviceUI;
        }

        public final String getKey() {
            if (this.ljA == b.ljr) {
                return this.ljC.lhH + this.ljC.lcr;
            }
            return this.ljB.aQl;
        }

        public final String aqc() {
            if (this.ljA != b.ljr) {
                return this.ljB.aQl;
            }
            if (this.ljE == null) {
                return null;
            }
            return this.ljE.tiU;
        }

        public final String Cg() {
            if (this.ljD != null) {
                return this.ljD.thD;
            }
            if (this.ljA == b.ljr) {
                return this.ljC.lhH;
            }
            return null;
        }

        public final String getDeviceId() {
            if (this.ljD != null) {
                return this.ljD.jNm;
            }
            if (this.ljA == b.ljr) {
                return this.ljC.lcr;
            }
            return null;
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, k kVar) {
        f fVar = null;
        if (kVar instanceof p) {
            if (exdeviceBindDeviceUI.isv != null && exdeviceBindDeviceUI.isv.isShowing()) {
                exdeviceBindDeviceUI.isv.dismiss();
            }
            exdeviceBindDeviceUI.ljc = false;
            p pVar = (p) kVar;
            if (!(i == 0 && i2 == 0)) {
                w.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            yn ynVar = (pVar.gUA == null || pVar.gUA.hsk.hsr == null) ? null : (yn) pVar.gUA.hsk.hsr;
            exdeviceBindDeviceUI.ljb = ynVar.tEU;
            String str2 = exdeviceBindDeviceUI.ljb;
            if (bg.mA(str2)) {
                w.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bb.d.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
        } else if (kVar instanceof t) {
            awo app = ((t) kVar).app();
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (app.tjp == null) {
                w.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
            } else {
                fVar = exdeviceBindDeviceUI.liT.vq(app.tjp.tiU);
                if (fVar == null) {
                    w.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                } else if (fVar.ljD != null) {
                    w.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                } else {
                    fVar.ljE = app.tjp;
                    fVar.ljD = app.tjo;
                    fVar.liH = app.tiZ;
                    fVar.ljG = app.tja;
                    exdeviceBindDeviceUI.liT.b(fVar);
                    exdeviceBindDeviceUI.liT.notifyDataSetChanged();
                    w.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", new Object[]{app.tjo.thD, app.tjo.jNm, app.tjp.tJL, app.tjp.tiU, Integer.valueOf(app.tjp.gtV)});
                }
            }
        } else if (!(kVar instanceof v)) {
        } else {
            if (i == 0 && i2 == 0) {
                v vVar = (v) kVar;
                axj com_tencent_mm_protocal_c_axj = (vVar.gUA == null || vVar.gUA.hsk.hsr == null) ? null : (axj) vVar.gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_axj.tjo == null) {
                    w.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                    return;
                }
                a aVar = exdeviceBindDeviceUI.liT;
                String str3 = com_tencent_mm_protocal_c_axj.tjo.thD;
                String str4 = com_tencent_mm_protocal_c_axj.tjo.jNm;
                if (!(str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0)) {
                    int bW = aVar.bW(str3, str4);
                    if (bW >= 0) {
                        fVar = (f) aVar.ljn.get(bW);
                    }
                }
                if (fVar == null) {
                    w.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    return;
                } else if (fVar.ljD != null) {
                    w.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    return;
                } else {
                    fVar.ljE = com_tencent_mm_protocal_c_axj.tjp;
                    fVar.ljD = com_tencent_mm_protocal_c_axj.tjo;
                    fVar.liH = com_tencent_mm_protocal_c_axj.tiZ;
                    fVar.ljG = com_tencent_mm_protocal_c_axj.tja;
                    exdeviceBindDeviceUI.liT.b(fVar);
                    exdeviceBindDeviceUI.liT.notifyDataSetChanged();
                    w.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", new Object[]{com_tencent_mm_protocal_c_axj.tjo.thD, com_tencent_mm_protocal_c_axj.tjo.jNm, com_tencent_mm_protocal_c_axj.tjp.tJL, Integer.valueOf(com_tencent_mm_protocal_c_axj.tjp.gtV)});
                    return;
                }
            }
            w.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        aeo com_tencent_mm_protocal_c_aeo = fVar.ljE;
        intent.putExtra("device_mac", com_tencent_mm_protocal_c_aeo.tiU);
        intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_aeo.tJE);
        intent.putExtra("device_desc", com_tencent_mm_protocal_c_aeo.tJM);
        intent.putExtra("device_title", com_tencent_mm_protocal_c_aeo.tJL);
        intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_aeo.muU);
        intent.putExtra("device_alias", com_tencent_mm_protocal_c_aeo.hAI);
        intent.putExtra("device_jump_url", com_tencent_mm_protocal_c_aeo.msF);
        intent.putExtra("bind_ticket", fVar.liH);
        intent.putExtra("device_type", fVar.ljD.thD);
        intent.putExtra("device_id", fVar.ljD.jNm);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.ljF);
        if (fVar.ljA == b.ljs) {
            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_aeo.gtW);
        } else if (fVar.ljA != b.ljr) {
            Assert.assertTrue(false);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        if (fVar == null) {
            w.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
        } else if (fVar.ljG == null) {
            w.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
        } else {
            ame com_tencent_mm_protocal_c_ame = fVar.ljG;
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_ame.ttp));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.ljD.jNm);
            intent.putExtra("device_type", fVar.ljD.thD);
            intent.putExtra("Contact_User", com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_ame.ttp));
            intent.putExtra("Contact_Scene", com_tencent_mm_protocal_c_ame.tsI);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.liH);
            if (Rc != null) {
                if (!com.tencent.mm.j.a.ez(Rc.field_type)) {
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_ame.hAI);
                    intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_ame.tLj.toString());
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_ame.hAG);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_ame.hAM, com_tencent_mm_protocal_c_ame.hAE, com_tencent_mm_protocal_c_ame.hAF));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_ame.hAD);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_ame.tMQ);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_ame.tMP);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_ame.tMT);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_ame.tMR);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_ame.tMS);
                    if (com_tencent_mm_protocal_c_ame.tMW != null) {
                        try {
                            intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_ame.tMW.toByteArray());
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.bb.d.b(exdeviceBindDeviceUI.uSU.uTo, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dbu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            {
                this.ljg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ljg.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.lja = intent.getStringExtra("device_category_id");
        this.lcq = intent.getStringExtra("device_brand_name");
        this.lhH = intent.getStringExtra("device_type");
        if (this.lhH == null || this.lhH.length() == 0) {
            this.lhH = this.lcq;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (bg.mA(stringExtra3)) {
            stringExtra3 = this.uSU.uTo.getString(R.l.efS);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.liZ = e.ljw;
            str = this.uSU.uTo.getString(R.l.efj);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.liZ = e.ljx;
            str = this.uSU.uTo.getString(R.l.efh);
        } else {
            Assert.assertTrue(false);
        }
        qP(str);
        if (this.liZ == e.ljx) {
            this.lje = stringExtra.contains("wifi");
            this.ljf = stringExtra.contains("blue");
            w.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[]{Boolean.valueOf(this.lje), Boolean.valueOf(this.ljf)});
        } else if (this.liZ == e.ljw) {
            this.ljf = true;
            this.lje = true;
        }
        this.lde = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            {
                this.ljg = r1;
            }

            public final void f(int i, Object... objArr) {
                Throwable e;
                if (i == 10 && objArr != null) {
                    String string;
                    String str;
                    String string2;
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            string2 = jSONObject2.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                            string2 = null;
                            w.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            w.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                        try {
                            if (!jSONObject.isNull("manufacturerData")) {
                                str = jSONObject.getString("manufacturerData");
                                if (string != null && string2 != null) {
                                    final f fVar = new f(this.ljg);
                                    fVar.ljA = b.ljr;
                                    fVar.ljC = new d(this.ljg);
                                    fVar.ljC.lhH = string;
                                    fVar.ljC.lcr = string2;
                                    if (bg.mA(str)) {
                                        fVar.ljH = null;
                                    } else {
                                        fVar.ljH = Base64.encodeToString(str.getBytes(), 2);
                                        w.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[]{fVar.ljH});
                                    }
                                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass3 lji;

                                        public final void run() {
                                            this.lji.ljg.a(fVar);
                                        }
                                    });
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            w.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            w.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        string2 = null;
                        string = null;
                        w.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        w.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                        str = null;
                        if (string != null) {
                        }
                    }
                    str = null;
                    if (string != null) {
                    }
                }
            }
        };
        this.ljd = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            {
                this.ljg = r1;
            }

            public final void f(int i, Object... objArr) {
            }
        };
        KC();
        this.kna.setText(this.uSU.uTo.getString(R.l.egD, new Object[]{stringExtra3}));
        ap.vd().a(1264, this);
        ap.vd().a(1706, this);
        ap.vd().a(1270, this);
        ap.vd().a(1719, this);
        if (this.ljf) {
            ad.apE().a((com.tencent.mm.plugin.exdevice.model.e.b) this);
        }
        if (this.lje) {
            j.apk().a(10, this.lde);
            j.apk().a(11, this.ljd);
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    protected void onResume() {
        super.onResume();
        w.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.ljf) {
            ad.apE();
            com.tencent.mm.plugin.exdevice.model.e.apg();
        }
        if (this.lje) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.liT.aqb();
        this.liT.notifyDataSetChanged();
    }

    protected final void KC() {
        this.Fg = (ListView) findViewById(R.h.cbx);
        View inflate = View.inflate(this, R.i.dbw, null);
        this.liY = View.inflate(this, R.i.dbY, null);
        this.liU = this.liY.findViewById(R.h.cBg);
        this.kna = (TextView) this.liY.findViewById(R.h.cIO);
        this.liV = (TextView) findViewById(R.h.czN);
        this.liW = (ImageView) findViewById(R.h.ccL);
        this.lif = (TextView) findViewById(R.h.bMo);
        this.lig = (TextView) findViewById(R.h.bMp);
        this.liX = (ScrollView) findViewById(R.h.bIQ);
        this.Fg.addHeaderView(inflate, null, false);
        this.Fg.addFooterView(this.liY, null, false);
        this.liT = new a(this.lcq, this.liZ, this.lja);
        this.Fg.setAdapter(this.liT);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            {
                this.ljg = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f lT = this.ljg.liT.lT(i - ((ListView) adapterView).getHeaderViewsCount());
                if (lT.ljE.gtV != 0) {
                    ExdeviceBindDeviceUI.a(this.ljg, lT);
                } else {
                    ExdeviceBindDeviceUI.b(this.ljg, lT);
                }
            }
        });
        if (this.ljf && !this.lje) {
            if (!com.tencent.mm.plugin.h.a.e.a.bL(this.uSU.uTo)) {
                w.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                lR(4);
                return;
            } else if (!com.tencent.mm.plugin.h.a.e.a.adm()) {
                w.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                lR(3);
                return;
            }
        }
        if (!this.ljf && this.lje && !am.isWifi(this.uSU.uTo)) {
            w.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            lR(5);
        } else if (this.liZ == e.ljw) {
            lR(0);
        } else if (this.liZ != e.ljx) {
            int i = e.ljv;
            Assert.assertTrue(false);
        } else if (this.ljf && this.lje) {
            Assert.assertTrue(false);
            lR(1);
        } else if (this.ljf) {
            lR(2);
        } else if (this.lje) {
            lR(1);
        }
    }

    protected void onPause() {
        super.onPause();
        w.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.lje) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.ljf) {
            ad.apF().acS();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lje) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ ExdeviceBindDeviceUI ljg;

                {
                    this.ljg = r1;
                }

                public final void run() {
                    Java2CExDevice.stopScanWCLanDevice();
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            j.apk().b(10, this.lde);
            j.apk().b(11, this.ljd);
        }
        if (this.ljf) {
            ad.apE().b(this);
            ad.apF().acS();
        }
        ap.vd().b(1264, this);
        ap.vd().b(1706, this);
        ap.vd().b(1270, this);
        ap.vd().b(1719, this);
    }

    public final void j(String str, String str2, boolean z) {
        w.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str2)) {
            w.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        final f fVar = new f(this);
        fVar.ljA = b.ljs;
        fVar.ljB = new c(this);
        fVar.ljB.lju = str;
        fVar.ljB.aQl = com.tencent.mm.plugin.exdevice.j.b.bH(com.tencent.mm.plugin.exdevice.j.b.vx(str2));
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            public final void run() {
                this.ljg.a(fVar);
            }
        });
    }

    public final void d(String str, int i, long j) {
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            w.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            return;
        }
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final k kVar2 = kVar;
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ ExdeviceBindDeviceUI ljg;

            public final void run() {
                ExdeviceBindDeviceUI.a(this.ljg, i3, i4, str2, kVar2);
            }
        });
    }

    final void a(f fVar) {
        if (!this.liT.vp(fVar.getKey())) {
            w.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.aqc());
            a aVar = this.liT;
            if (!(fVar == null || aVar.vp(fVar.getKey()))) {
                fVar.ljz = aVar.c(fVar);
                aVar.ljn.add(fVar);
            }
            this.liT.notifyDataSetChanged();
            if (fVar.ljA == b.ljs) {
                w.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[]{fVar.ljB.aQl, this.lcq, this.lja});
                ap.vd().a(new t(fVar.ljB.aQl, this.lcq, this.lja), 0);
            } else if (fVar.ljA == b.ljr) {
                w.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[]{fVar.ljC.lhH, fVar.ljC.lcr});
                ap.vd().a(new v(fVar.ljC.lhH, fVar.ljC.lcr, fVar.ljH), 0);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.liT.aqb();
        this.liT.notifyDataSetChanged();
    }

    private void lR(int i) {
        String string;
        String string2;
        CharSequence spannableString;
        switch (i) {
            case 0:
                string = getString(R.l.efp);
                CharSequence spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(R.e.aUA), 0, string.length(), 33);
                spannableString2.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI ljg;

                    {
                        this.ljg = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.exdevice.model.f.S(this.ljg.uSU.uTo, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, 0, string.length(), 33);
                this.liV.setMovementMethod(LinkMovementMethod.getInstance());
                this.liV.setText(spannableString2);
                break;
            case 1:
                string = getString(R.l.efs);
                string2 = getString(R.l.dbx);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.aUA), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI ljg;

                    {
                        this.ljg = r1;
                    }

                    public final void onClick(View view) {
                        this.ljg.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.liV.setMovementMethod(LinkMovementMethod.getInstance());
                this.liV.setText(spannableString);
                break;
            case 2:
                string = getString(R.l.efr);
                string2 = getString(R.l.efq);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.aUA), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI ljg;

                    {
                        this.ljg = r1;
                    }

                    public final void onClick(View view) {
                        this.ljg.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.liV.setMovementMethod(LinkMovementMethod.getInstance());
                this.liV.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.liW.setImageResource(R.k.dut);
                this.lif.setText(R.l.efy);
                this.lig.setText(R.l.efn);
                break;
            case 4:
                this.liW.setImageResource(R.k.dut);
                this.lif.setText(R.l.efw);
                this.lig.setText("");
                break;
            case 5:
                this.liW.setImageResource(R.k.dAJ);
                this.lif.setText(R.l.efy);
                this.lig.setText(R.l.efu);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.liU.setVisibility(0);
                this.Fg.setVisibility(0);
                this.liV.setVisibility(0);
                this.liW.setVisibility(8);
                this.lif.setVisibility(8);
                this.lig.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
                this.liX.setVisibility(8);
                this.liU.setVisibility(8);
                this.Fg.setVisibility(8);
                this.liV.setVisibility(8);
                this.liW.setVisibility(0);
                this.lif.setVisibility(0);
                if (i == 4) {
                    this.lig.setVisibility(8);
                    return;
                } else {
                    this.lig.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
