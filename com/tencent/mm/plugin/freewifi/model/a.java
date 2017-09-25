package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.AnonymousClass2;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a {
    public SparseArray<Long> lSW = new SparseArray();
    private g lSX = new g();

    public final void a(String str, b bVar, int i, Intent intent) {
        j.awF().awp().post(new com.tencent.mm.plugin.freewifi.model.g.AnonymousClass1(this.lSX, str, intent, bVar, i));
    }

    public final void a(String str, String str2, Intent intent) {
        j.awF().awp().post(new AnonymousClass2(this.lSX, str2, str, intent, null));
    }

    public final synchronized void awn() {
        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String awt = d.awt();
        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", new Object[]{awt});
        if (!bg.mA(awt)) {
            if (j.awC().wO(awt) == null) {
                int i;
                String awr = d.awr();
                String str = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str2 = "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d";
                Object[] objArr = new Object[3];
                objArr[0] = awt;
                objArr[1] = awr;
                if (awr == null) {
                    i = 0;
                } else {
                    i = awr.hashCode();
                }
                objArr[2] = Integer.valueOf(i);
                w.i(str, str2, objArr);
                if (!bg.mA(awr)) {
                    boolean z;
                    c wP = j.awC().wP(awt);
                    str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                    String str3 = "now mac is : %s, loacal mac is : %s";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = awr;
                    objArr2[1] = wP == null ? "null free wifiinfo" : wP.field_mac;
                    w.i(str2, str3, objArr2);
                    if (wP != null) {
                        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", new Object[]{Long.valueOf(wP.field_expiredTime)});
                        if (!awr.equalsIgnoreCase(wP.field_mac) || wP.field_expiredTime - bg.Ny() < 0) {
                            w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                            z = true;
                        }
                        z = false;
                    } else if (this.lSW.indexOfKey(awr.hashCode()) >= 0) {
                        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", new Object[]{Long.valueOf(bg.Nz() - ((Long) this.lSW.get(awr.hashCode())).longValue())});
                        if (bg.Nz() - ((Long) this.lSW.get(awr.hashCode())).longValue() > 43200000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                        z = true;
                    }
                    w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", new Object[]{Integer.valueOf(d.aws()), awr, Integer.valueOf(awr.hashCode())});
                        if (System.currentTimeMillis() - a.lRv.mB("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((a.lRv.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * 1000))) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                            i |= 2;
                        }
                        if (a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                            i |= 4;
                        }
                        if (a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                            i |= 8;
                        }
                        w.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : " + i);
                        new com.tencent.mm.plugin.freewifi.d.b(awr, awt, r5, i).b(new e(this) {
                            final /* synthetic */ a lSY;

                            {
                                this.lSY = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                String str2 = ((com.tencent.mm.plugin.freewifi.d.b) kVar).mac;
                                if (!m.wx(str2)) {
                                    if (i2 == -30011) {
                                        this.lSY.lSW.put(str2.hashCode(), Long.valueOf(bg.Nz()));
                                    } else {
                                        this.lSY.lSW.remove(str2.hashCode());
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}
