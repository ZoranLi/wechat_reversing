package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    public static boolean aJi = false;
    private static boolean nGp = false;
    private Context context;
    private boolean fCF = false;
    private a pqu = new a();
    public long pqw;

    public l(Context context, a aVar) {
        super(aVar);
        this.context = context;
        aJi = false;
    }

    public final void start() {
        if (this.por == null) {
            w.w("Micromsg.ShakeTVService", "shakeGetListener == null");
        } else if (this.context instanceof Activity) {
            aJi = true;
            this.pqw = System.currentTimeMillis();
            this.pqu.a(408, new a.a(this) {
                final /* synthetic */ l pqz;

                {
                    this.pqz = r1;
                }

                public final void a(avp com_tencent_mm_protocal_c_avp, long j, boolean z) {
                    long currentTimeMillis;
                    if (j > this.pqz.pqw) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - this.pqz.pqw;
                    }
                    if (com_tencent_mm_protocal_c_avp != null && !bg.mA(((azq) com_tencent_mm_protocal_c_avp).tlo)) {
                        azq com_tencent_mm_protocal_c_azq = (azq) com_tencent_mm_protocal_c_avp;
                        w.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azq.jOc), com_tencent_mm_protocal_c_azq.tlo});
                        String str = null;
                        String str2 = null;
                        if (com_tencent_mm_protocal_c_azq.tlo != null) {
                            com_tencent_mm_protocal_c_azq.tlo = com_tencent_mm_protocal_c_azq.tlo.trim();
                            int indexOf = com_tencent_mm_protocal_c_azq.tlo.indexOf("<tvinfo>");
                            if (indexOf > 0) {
                                str = com_tencent_mm_protocal_c_azq.tlo.substring(0, indexOf);
                                str2 = com_tencent_mm_protocal_c_azq.tlo.substring(indexOf);
                            } else if (indexOf == 0) {
                                str2 = com_tencent_mm_protocal_c_azq.tlo;
                            } else {
                                str = com_tencent_mm_protocal_c_azq.tlo;
                            }
                        }
                        l.Ef(str2);
                        Object obj = null;
                        l lVar;
                        List arrayList;
                        d dVar;
                        switch (com_tencent_mm_protocal_c_azq.jOc) {
                            case 0:
                                lVar = this.pqz;
                                arrayList = new ArrayList();
                                e Ek = e.Ek(str);
                                if (Ek != null && Ek.hSX != null) {
                                    w.d("Micromsg.ShakeTVService", "parse url: link=" + Ek.hSX + ", title=" + Ek.title + ", thumburl=" + Ek.thumbUrl);
                                    dVar = new d();
                                    dVar.field_username = Ek.hSX;
                                    dVar.field_nickname = Ek.title;
                                    dVar.field_distance = Ek.fRu;
                                    dVar.field_sns_bgurl = Ek.thumbUrl;
                                    dVar.field_type = 7;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse url fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 1:
                                lVar = this.pqz;
                                f El = f.El(str);
                                arrayList = new ArrayList();
                                if (El != null && El.userName != null) {
                                    w.d("Micromsg.ShakeTVService", "parse user: username=" + El.userName + ", nickname=" + El.aIO + ", showchat=" + El.pqC);
                                    d dVar2 = new d();
                                    dVar2.field_username = El.userName;
                                    dVar2.field_nickname = El.aIO;
                                    dVar2.field_type = 6;
                                    dVar2.field_insertBatch = 1;
                                    dVar2.field_distance = El.pqC;
                                    m.baS().a(dVar2, true);
                                    arrayList.add(dVar2);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse user fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 2:
                                l lVar2 = this.pqz;
                                List arrayList2 = new ArrayList();
                                if (str != null && str.startsWith("<tv")) {
                                    c.a En = c.En(str);
                                    if (En != null) {
                                        dVar = new d();
                                        dVar.field_username = bg.mz(En.field_subtitle);
                                        dVar.field_nickname = bg.mz(En.field_topic);
                                        dVar.field_distance = bg.mz(En.field_title);
                                        if (En.field_thumburl != null) {
                                            dVar.field_sns_bgurl = En.field_thumburl;
                                        }
                                        dVar.field_type = 8;
                                        dVar.field_insertBatch = 1;
                                        dVar.field_lvbuffer = str.getBytes();
                                        dVar.field_reserved2 = (int) bg.Ny();
                                        arrayList2.add(dVar);
                                        d baI = m.baS().baI();
                                        if (baI.field_type == 8 && dVar.field_distance.equals(baI.field_distance) && dVar.field_nickname.equals(baI.field_nickname) && dVar.field_reserved2 - baI.field_reserved2 < 1800) {
                                            w.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + baI.field_reserved2);
                                            m.baS().sv(baI.field_shakeItemID);
                                        }
                                        m.baS().a(dVar, true);
                                        lVar2.e(arrayList2, 1);
                                        w.d("Micromsg.ShakeTVService", "process get tv OK");
                                        obj = 1;
                                        break;
                                    }
                                    w.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
                                    l.aJi = false;
                                    lVar2.e(arrayList2, 4);
                                    obj = null;
                                    break;
                                }
                                String str3 = "Micromsg.ShakeTVService";
                                String str4 = "wrong args, xml == null ? [%s]";
                                Object[] objArr = new Object[1];
                                objArr[0] = Boolean.valueOf(str == null);
                                w.e(str3, str4, objArr);
                                lVar2.e(arrayList2, 2);
                                obj = null;
                                break;
                                break;
                            case 3:
                                lVar = this.pqz;
                                arrayList = new ArrayList();
                                m.b Eh = m.b.Eh(str);
                                if (Eh != null && Eh.pqA != null) {
                                    w.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + Eh.pqA + ", title=" + Eh.title + ", thumbUrl=" + Eh.thumbUrl);
                                    dVar = new d();
                                    dVar.field_username = Eh.pqA;
                                    dVar.field_nickname = Eh.title;
                                    dVar.field_sns_bgurl = Eh.thumbUrl;
                                    dVar.field_distance = Eh.oho;
                                    dVar.field_type = 9;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse pay fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 4:
                                lVar = this.pqz;
                                arrayList = new ArrayList();
                                m.c Ei = m.c.Ei(str);
                                if (Ei != null && Ei.id != null) {
                                    w.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + Ei.id + ", title=" + Ei.title + ", thumbUrl=" + Ei.thumbUrl);
                                    dVar = new d();
                                    dVar.field_username = Ei.id;
                                    dVar.field_nickname = Ei.title;
                                    dVar.field_sns_bgurl = Ei.thumbUrl;
                                    dVar.field_type = 10;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse product fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 5:
                                lVar = this.pqz;
                                arrayList = new ArrayList();
                                m.d Ej = m.d.Ej(str);
                                if (Ej != null && !bg.mA(Ej.pqB)) {
                                    dVar = new d();
                                    dVar.field_username = Ej.pqB;
                                    dVar.field_nickname = Ej.title;
                                    dVar.field_distance = Ej.username;
                                    dVar.field_sns_bgurl = Ej.thumbUrl;
                                    dVar.field_type = 12;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse TempSession fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                            case 6:
                                lVar = this.pqz;
                                arrayList = new ArrayList();
                                m.a Eg = m.a.Eg(str);
                                if (Eg != null && !bg.mA(Eg.path)) {
                                    dVar = new d();
                                    dVar.field_username = Eg.username;
                                    dVar.field_nickname = Eg.title;
                                    dVar.field_reserved3 = Eg.path;
                                    dVar.field_sns_bgurl = Eg.thumbUrl;
                                    dVar.field_reserved2 = Eg.version;
                                    dVar.field_type = 13;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    lVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeTVService", "parse appBrand fail");
                                lVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            default:
                                w.w("Micromsg.ShakeTVService", "parse unknown type:" + com_tencent_mm_protocal_c_azq.jOc);
                                this.pqz.e(new ArrayList(), 4);
                                break;
                        }
                        if (obj != null) {
                            g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - this.pqz.pqw))});
                        } else {
                            g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                        }
                    } else if (z) {
                        this.pqz.e(new ArrayList(), 4);
                        g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
                    } else {
                        this.pqz.e(new ArrayList(), 4);
                        g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
                    }
                    l.aJi = false;
                }
            });
        } else {
            w.e("Micromsg.ShakeTVService", "context not an Activity");
            this.por.d(new ArrayList(), 0);
        }
    }

    public final void init() {
        if (!nGp) {
            if (this.pqu.bbr()) {
                nGp = true;
            } else {
                w.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void baF() {
        super.baF();
        this.pqu.oX();
        if (aJi) {
            long currentTimeMillis = System.currentTimeMillis() - this.pqw;
            w.d("Micromsg.ShakeTVService", "destroyShakeMgr, costTime=%s, isRunning=%s", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(aJi)});
            g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis)});
            aJi = false;
        }
    }

    public final void resume() {
    }

    public static void Ef(String str) {
        com.tencent.mm.sdk.e.c cVar;
        String[] strArr = null;
        if (bg.mA(str)) {
            cVar = null;
        } else {
            com.tencent.mm.sdk.e.c cVar2;
            Map q = bh.q(str, "tvinfo");
            if (q != null) {
                String str2 = (String) q.get(".tvinfo.username");
                if (bg.mA(str2)) {
                    cVar = null;
                } else {
                    com.tencent.mm.sdk.e.c nVar = new n();
                    nVar.field_username = str2;
                    nVar.field_iconurl = bg.mz((String) q.get(".tvinfo.iconurl"));
                    nVar.field_title = bg.mz((String) q.get(".tvinfo.title"));
                    nVar.field_deeplink = bg.mz((String) q.get(".tvinfo.deeplinkjumpurl"));
                    nVar.field_createtime = bg.getLong((String) q.get(".tvinfo.createtime"), 0);
                    cVar2 = nVar;
                }
            } else {
                cVar2 = null;
            }
            cVar = cVar2;
        }
        if (cVar != null) {
            o baU = m.baU();
            Cursor a = baU.gUz.a("shaketvhistory", null, "username=?", new String[]{cVar.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new n();
                strArr.b(a);
                a.close();
            } else {
                w.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:" + r10);
                a.close();
            }
            if (strArr != null) {
                w.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                baU = m.baU();
                if (bg.mA(cVar.field_username)) {
                    w.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    return;
                }
                baU.gUz.update("shaketvhistory", cVar.pv(), "username=?", new String[]{cVar.field_username});
                return;
            }
            w.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.baU().b(cVar);
        }
    }

    public final void e(List<d> list, long j) {
        if (this.por != null) {
            this.por.d(list, j);
        }
    }
}
