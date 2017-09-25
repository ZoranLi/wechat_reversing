package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i implements e {
    ;
    
    private ProgressDialog isv;
    private boolean ldn;
    public a ldo;

    public interface a {
        void dI(boolean z);
    }

    private i(String str) {
        this.ldn = false;
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        if (sharedPreferences.getLong(stringBuilder.append(c.uH()).toString(), 0) != 0) {
            w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[]{Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.uH()).toString(), 0))});
            return;
        }
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    }

    public final void a(Context context, final a aVar) {
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.ldn) {
            if (this.ldo == null) {
                this.ldo = aVar;
            }
            w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            return;
        }
        final k oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
            }
            context.getString(R.l.dIO);
            this.isv = g.a(context, context.getString(R.l.eOV), new OnCancelListener(this) {
                final /* synthetic */ i lds;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(oVar);
                    this.lds.isv.dismiss();
                    this.lds.ldn = false;
                    if (aVar != null) {
                        aVar.dI(false);
                    }
                }
            });
        }
        this.ldo = aVar;
        ap.vd().a(oVar, 0);
    }

    public final boolean dJ(boolean z) {
        if (this.ldn) {
            w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        long j = sharedPreferences.getLong(stringBuilder.append(c.uH()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            return true;
        }
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        return false;
    }

    public static void bp(long j) {
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[]{Long.valueOf(j)});
        Editor edit = ab.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        edit.putLong(stringBuilder.append(c.uH()).toString(), j).commit();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.ldn = false;
        if (kVar != null && i2 == 0 && i == 0) {
            w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    o oVar = (o) kVar;
                    final vt vtVar = (oVar.gUA == null || oVar.gUA.hsk.hsr == null) ? null : (vt) oVar.gUA.hsk.hsr;
                    if (vtVar == null || vtVar.tCW == null) {
                        if (this.ldo != null) {
                            this.ldo.dI(false);
                        }
                        if (this.isv != null && this.isv.isShowing()) {
                            this.isv.dismiss();
                            return;
                        }
                        return;
                    }
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ i lds;

                        public final void run() {
                            i.bp(bg.Nz());
                            com.tencent.mm.plugin.exdevice.h.c apt = ad.apt();
                            List<b> linkedList = new LinkedList();
                            Cursor Kk = apt.Kk();
                            Iterator it;
                            aen com_tencent_mm_protocal_c_aen;
                            boolean z;
                            Iterator it2;
                            amn com_tencent_mm_protocal_c_amn;
                            aeo com_tencent_mm_protocal_c_aeo;
                            aen com_tencent_mm_protocal_c_aen2;
                            bp vj;
                            com.tencent.mm.sdk.e.c bVar;
                            if (Kk == null || !Kk.moveToFirst()) {
                                if (Kk != null) {
                                    Kk.close();
                                }
                                for (b bVar2 : linkedList) {
                                    it = vtVar.tCW.iterator();
                                    while (it.hasNext()) {
                                        com_tencent_mm_protocal_c_aen = ((amn) it.next()).tjo;
                                        if (!bVar2.field_deviceType.equals(com_tencent_mm_protocal_c_aen.thD) && bVar2.field_deviceID.equals(com_tencent_mm_protocal_c_aen.jNm)) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                        w.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar2.field_deviceID, bVar2.field_deviceType});
                                        i.d(bVar2);
                                        ad.apt().bV(bVar2.field_deviceID, bVar2.field_deviceType);
                                        ad.apE();
                                        e.Q(bVar2.field_deviceID, false);
                                    }
                                }
                                it2 = vtVar.tCW.iterator();
                                while (it2.hasNext()) {
                                    com_tencent_mm_protocal_c_amn = (amn) it2.next();
                                    com_tencent_mm_protocal_c_aeo = com_tencent_mm_protocal_c_amn.tjp;
                                    com_tencent_mm_protocal_c_aen2 = com_tencent_mm_protocal_c_amn.tjo;
                                    if (!(com_tencent_mm_protocal_c_aen2 == null || com_tencent_mm_protocal_c_aeo == null || bg.mA(com_tencent_mm_protocal_c_aen2.jNm))) {
                                        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_aen2.jNm, com_tencent_mm_protocal_c_aen2.thD, Integer.valueOf(com_tencent_mm_protocal_c_amn.tRj)});
                                        vj = ad.apt().vj(com_tencent_mm_protocal_c_aen2.jNm);
                                        if (2 != com_tencent_mm_protocal_c_amn.tRj) {
                                            w.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_aen2.jNm, com_tencent_mm_protocal_c_aeo.tiU, com_tencent_mm_protocal_c_aeo.tJE});
                                            if (vj != null) {
                                                i.d(vj);
                                                ad.apt().bV(vj.field_deviceID, vj.field_deviceType);
                                                ad.apE();
                                                e.Q(vj.field_deviceID, false);
                                            }
                                        } else {
                                            bVar = new b();
                                            bVar.field_deviceID = com_tencent_mm_protocal_c_aen2.jNm;
                                            bVar.field_deviceType = com_tencent_mm_protocal_c_aen2.thD;
                                            bVar.field_connProto = com_tencent_mm_protocal_c_aeo.tJF;
                                            bVar.field_connStrategy = com_tencent_mm_protocal_c_aeo.tJG;
                                            bVar.field_closeStrategy = com_tencent_mm_protocal_c_aeo.tJH;
                                            if (!(com_tencent_mm_protocal_c_aeo.gtV != 2 || vj == null || vj.gtR == null)) {
                                                com_tencent_mm_protocal_c_aeo.hAI = vj.gtR;
                                            }
                                            bVar.bO(com_tencent_mm_protocal_c_aeo.hAI);
                                            bVar.cC(com_tencent_mm_protocal_c_aeo.tJN);
                                            bVar.cB(com_tencent_mm_protocal_c_aeo.tJM);
                                            bVar.cA(com_tencent_mm_protocal_c_aeo.tJL);
                                            bVar.dD(com_tencent_mm_protocal_c_aeo.tJO);
                                            bVar.cy(com_tencent_mm_protocal_c_aeo.muU);
                                            bVar.cz(com_tencent_mm_protocal_c_aeo.msF);
                                            bVar.dE(com_tencent_mm_protocal_c_aeo.gtV);
                                            bVar.w(com_tencent_mm_protocal_c_aeo.gtW);
                                            bVar.cD(com_tencent_mm_protocal_c_aeo.gtX);
                                            bVar.cE(com_tencent_mm_protocal_c_aeo.gtY);
                                            bVar.cF(com_tencent_mm_protocal_c_aeo.gtZ);
                                            bVar.cG(com_tencent_mm_protocal_c_aeo.gua);
                                            bVar.field_url = "";
                                            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.vx(com.tencent.mm.plugin.exdevice.j.b.vy(com_tencent_mm_protocal_c_aeo.tiU));
                                            bVar.field_md5Str = com.tencent.mm.a.g.n(new String(com_tencent_mm_protocal_c_aen2.thD + com_tencent_mm_protocal_c_aen2.jNm).getBytes());
                                            bVar.field_authKey = com_tencent_mm_protocal_c_aeo.thm;
                                            bVar.field_brandName = com_tencent_mm_protocal_c_aeo.tJE;
                                            if (bVar.field_mac == 0) {
                                                bVar.field_mac = System.currentTimeMillis();
                                            }
                                            if (vj == null) {
                                                z = ad.apt().b(bVar);
                                                if (z) {
                                                    ad.apE();
                                                    e.Q(bVar.field_deviceID, true);
                                                }
                                            } else {
                                                z = ad.apt().e(bVar) == 0;
                                            }
                                            w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_aen2.thD, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
                                        }
                                    }
                                }
                            }
                            do {
                                b bVar3 = new b();
                                bVar3.b(Kk);
                                linkedList.add(bVar3);
                            } while (Kk.moveToNext());
                            if (Kk != null) {
                                Kk.close();
                            }
                            for (b bVar22 : linkedList) {
                                it = vtVar.tCW.iterator();
                                while (it.hasNext()) {
                                    com_tencent_mm_protocal_c_aen = ((amn) it.next()).tjo;
                                    if (!bVar22.field_deviceType.equals(com_tencent_mm_protocal_c_aen.thD)) {
                                    }
                                }
                                z = false;
                                if (!z) {
                                    w.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar22.field_deviceID, bVar22.field_deviceType});
                                    i.d(bVar22);
                                    ad.apt().bV(bVar22.field_deviceID, bVar22.field_deviceType);
                                    ad.apE();
                                    e.Q(bVar22.field_deviceID, false);
                                }
                            }
                            it2 = vtVar.tCW.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_amn = (amn) it2.next();
                                com_tencent_mm_protocal_c_aeo = com_tencent_mm_protocal_c_amn.tjp;
                                com_tencent_mm_protocal_c_aen2 = com_tencent_mm_protocal_c_amn.tjo;
                                w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{com_tencent_mm_protocal_c_aen2.jNm, com_tencent_mm_protocal_c_aen2.thD, Integer.valueOf(com_tencent_mm_protocal_c_amn.tRj)});
                                vj = ad.apt().vj(com_tencent_mm_protocal_c_aen2.jNm);
                                if (2 != com_tencent_mm_protocal_c_amn.tRj) {
                                    bVar = new b();
                                    bVar.field_deviceID = com_tencent_mm_protocal_c_aen2.jNm;
                                    bVar.field_deviceType = com_tencent_mm_protocal_c_aen2.thD;
                                    bVar.field_connProto = com_tencent_mm_protocal_c_aeo.tJF;
                                    bVar.field_connStrategy = com_tencent_mm_protocal_c_aeo.tJG;
                                    bVar.field_closeStrategy = com_tencent_mm_protocal_c_aeo.tJH;
                                    com_tencent_mm_protocal_c_aeo.hAI = vj.gtR;
                                    bVar.bO(com_tencent_mm_protocal_c_aeo.hAI);
                                    bVar.cC(com_tencent_mm_protocal_c_aeo.tJN);
                                    bVar.cB(com_tencent_mm_protocal_c_aeo.tJM);
                                    bVar.cA(com_tencent_mm_protocal_c_aeo.tJL);
                                    bVar.dD(com_tencent_mm_protocal_c_aeo.tJO);
                                    bVar.cy(com_tencent_mm_protocal_c_aeo.muU);
                                    bVar.cz(com_tencent_mm_protocal_c_aeo.msF);
                                    bVar.dE(com_tencent_mm_protocal_c_aeo.gtV);
                                    bVar.w(com_tencent_mm_protocal_c_aeo.gtW);
                                    bVar.cD(com_tencent_mm_protocal_c_aeo.gtX);
                                    bVar.cE(com_tencent_mm_protocal_c_aeo.gtY);
                                    bVar.cF(com_tencent_mm_protocal_c_aeo.gtZ);
                                    bVar.cG(com_tencent_mm_protocal_c_aeo.gua);
                                    bVar.field_url = "";
                                    bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.vx(com.tencent.mm.plugin.exdevice.j.b.vy(com_tencent_mm_protocal_c_aeo.tiU));
                                    bVar.field_md5Str = com.tencent.mm.a.g.n(new String(com_tencent_mm_protocal_c_aen2.thD + com_tencent_mm_protocal_c_aen2.jNm).getBytes());
                                    bVar.field_authKey = com_tencent_mm_protocal_c_aeo.thm;
                                    bVar.field_brandName = com_tencent_mm_protocal_c_aeo.tJE;
                                    if (bVar.field_mac == 0) {
                                        bVar.field_mac = System.currentTimeMillis();
                                    }
                                    if (vj == null) {
                                        z = ad.apt().b(bVar);
                                        if (z) {
                                            ad.apE();
                                            e.Q(bVar.field_deviceID, true);
                                        }
                                    } else if (ad.apt().e(bVar) == 0) {
                                    }
                                    w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, com_tencent_mm_protocal_c_aen2.thD, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac)});
                                } else {
                                    w.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{com_tencent_mm_protocal_c_aen2.jNm, com_tencent_mm_protocal_c_aeo.tiU, com_tencent_mm_protocal_c_aeo.tJE});
                                    if (vj != null) {
                                        i.d(vj);
                                        ad.apt().bV(vj.field_deviceID, vj.field_deviceType);
                                        ad.apE();
                                        e.Q(vj.field_deviceID, false);
                                    }
                                }
                            }
                        }
                    });
                    if (this.ldo != null) {
                        this.ldo.dI(true);
                    }
                } else {
                    w.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                    if (this.ldo != null) {
                        this.ldo.dI(false);
                    }
                    if (this.isv != null && this.isv.isShowing()) {
                        this.isv.dismiss();
                        return;
                    }
                    return;
                }
            }
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
                return;
            }
            return;
        }
        w.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }
}
