package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements e {
    public static int pqp = 3;
    public float gKj = -85.0f;
    public float gKk = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ h pqq;

        {
            this.pqq = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            this.pqq.gKj = f2;
            this.pqq.gKk = f;
            this.pqq.pbQ = (int) d2;
            return false;
        }
    };
    private c hvP;
    public int pbQ = DownloadResult.CODE_UNDEFINED;
    private d pqk;
    public Collection<a> pql = null;
    private int pqm = CdnLogic.MediaType_FAVORITE_FILE;
    private int pqn = CdnLogic.MediaType_FAVORITE_VIDEO;
    private int pqo = 10003;

    public static final class a {
        public double hQZ = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String mry = null;
        public String pqr = "";
        public double pqs = 0.0d;
        public int pqt = 0;
    }

    public h(com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
    }

    public final void init() {
        ap.vd().a(658, this);
        baE();
    }

    public final void reset() {
        if (this.pqk != null) {
            ap.vd().c(this.pqk);
        }
    }

    public final void start() {
        w.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.hvP == null) {
            baE();
        }
        this.hvP.b(this.gKp, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) ab.getContext().getSystemService("location");
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ h pqq;

                    {
                        this.pqq = r1;
                    }

                    public final void run() {
                        this.pqq.por.d(null, 8);
                    }
                }, 1000);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ h pqq;

                {
                    this.pqq = r1;
                }

                public final void run() {
                    this.pqq.por.d(null, 9);
                }
            }, 1000);
        } else if (defaultAdapter == null) {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ h pqq;

                {
                    this.pqq = r1;
                }

                public final void run() {
                    this.pqq.por.d(null, 10);
                }
            }, 1000);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.pql != null) {
                size = this.pql.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            w.i(str, str2, objArr);
            this.pqk = new d(this.pql, this.gKj, this.gKk, this.pbQ);
            ap.vd().a(this.pqk, 0);
        }
    }

    public final void pause() {
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    public final void resume() {
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
    }

    private void baE() {
        this.hvP = c.Gk();
        this.hvP.a(this.gKp, true);
    }

    public final void baF() {
        super.baF();
        ap.vd().b(658, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            d dVar = (d) kVar;
            if (658 == kVar.getType() && dVar.action == 1) {
                afn com_tencent_mm_protocal_c_afn = (afn) dVar.hKp.hsk.hsr;
                if (com_tencent_mm_protocal_c_afn.tKL.tqS == 0) {
                    w.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[]{com_tencent_mm_protocal_c_afn.tKL.msK, com_tencent_mm_protocal_c_afn.tKL.opH, Integer.valueOf(com_tencent_mm_protocal_c_afn.tKL.tqS)});
                    try {
                        JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_afn.tKL.msK);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCu, Integer.valueOf(i3));
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCv, Long.valueOf(j));
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCw, Integer.valueOf(i4));
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCF, Integer.valueOf(i5));
                        w.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        com.tencent.mm.plugin.shake.b.e baS = m.baS();
                        baS.baK();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                d dVar2 = new d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = pqp;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                list.add(dVar2);
                                baS.a(dVar2, true);
                                if (dVar2.field_sex == pqp && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.por.d(list, 1);
                        return;
                    } catch (Exception e) {
                        w.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[]{bg.mz(e.getMessage())});
                        this.por.d(null, 1);
                        return;
                    }
                } else if (com_tencent_mm_protocal_c_afn.tKL.tqS == this.pqm) {
                    this.por.d(null, 6);
                    return;
                } else if (com_tencent_mm_protocal_c_afn.tKL.tqS == this.pqn) {
                    this.por.d(null, 7);
                    return;
                } else if (com_tencent_mm_protocal_c_afn.tKL.tqS == this.pqo) {
                    this.por.d(null, 8);
                    return;
                } else {
                    this.por.d(null, 1);
                    return;
                }
            }
            return;
        }
        this.por.d(null, 3);
    }

    public static void a(d dVar) {
        if (dVar != null && dVar.field_sex == pqp) {
            String str;
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCA, Boolean.valueOf(true));
            long Ny = bg.Ny();
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCB, Long.valueOf(Ny));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", new Object[]{"Unsupported"});
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCt, Long.valueOf(split[0]));
                }
            }
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", new Object[]{"Unsupported"});
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.mry = str2;
                    aVar.major = bg.getInt(str3, 0);
                    aVar.minor = bg.getInt(str, 0);
                }
            }
        }
    }
}
