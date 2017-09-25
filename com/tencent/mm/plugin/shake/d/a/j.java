package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean nGp = false;
    public static j pqv;
    private boolean fCF = false;
    public a pqu = new a();
    public long pqw;

    public static j a(a aVar) {
        if (pqv == null || pqv.por == null) {
            pqv = new j(aVar);
        }
        return pqv;
    }

    private j(a aVar) {
        super(aVar);
    }

    public final void start() {
        if (this.por == null) {
            w.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        this.pqw = System.currentTimeMillis();
        this.pqu.a(367, new a.a(this) {
            final /* synthetic */ j pqx;

            {
                this.pqx = r1;
            }

            public final void a(avp com_tencent_mm_protocal_c_avp, long j, boolean z) {
                if (this.pqx.por == null) {
                    w.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                    return;
                }
                azm com_tencent_mm_protocal_c_azm = (azm) com_tencent_mm_protocal_c_avp;
                if (com_tencent_mm_protocal_c_azm == null) {
                    w.w("Micromsg.ShakeMusicMgr", "resp null & return");
                    this.pqx.e(new ArrayList(), 4);
                } else if (com_tencent_mm_protocal_c_azm.uaU == 1) {
                    long currentTimeMillis;
                    if (j > this.pqx.pqw) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - this.pqx.pqw;
                    }
                    if (com_tencent_mm_protocal_c_azm != null && !bg.mA(com_tencent_mm_protocal_c_azm.uaW)) {
                        Object obj;
                        w.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azm.uaV), com_tencent_mm_protocal_c_azm.uaW});
                        String str = com_tencent_mm_protocal_c_azm.uaW;
                        if (str != null) {
                            str = str.trim();
                        }
                        j jVar;
                        List arrayList;
                        d dVar;
                        switch (com_tencent_mm_protocal_c_azm.uaV) {
                            case 0:
                                jVar = this.pqx;
                                arrayList = new ArrayList();
                                e Ek = e.Ek(str);
                                if (Ek != null && Ek.hSX != null) {
                                    w.d("Micromsg.ShakeMusicMgr", "parse url: link=" + Ek.hSX + ", title=" + Ek.title + ", thumburl=" + Ek.thumbUrl);
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
                                    jVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeMusicMgr", "parse url fail");
                                jVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 1:
                                jVar = this.pqx;
                                f El = f.El(str);
                                arrayList = new ArrayList();
                                if (El != null && El.userName != null) {
                                    w.d("Micromsg.ShakeMusicMgr", "parse user: username=" + El.userName + ", nickname=" + El.aIO + ", showchat=" + El.pqC);
                                    d dVar2 = new d();
                                    dVar2.field_username = El.userName;
                                    dVar2.field_nickname = El.aIO;
                                    dVar2.field_type = 6;
                                    dVar2.field_insertBatch = 1;
                                    dVar2.field_distance = El.pqC;
                                    m.baS().a(dVar2, true);
                                    arrayList.add(dVar2);
                                    jVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeMusicMgr", "parse user fail");
                                jVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            case 2:
                                jVar = this.pqx;
                                arrayList = new ArrayList();
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
                                        arrayList.add(dVar);
                                        d baI = m.baS().baI();
                                        if (baI.field_type == 8 && dVar.field_distance.equals(baI.field_distance) && dVar.field_nickname.equals(baI.field_nickname) && dVar.field_reserved2 - baI.field_reserved2 < 1800) {
                                            w.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + baI.field_reserved2);
                                            m.baS().sv(baI.field_shakeItemID);
                                        }
                                        m.baS().a(dVar, true);
                                        jVar.e(arrayList, 1);
                                        w.d("Micromsg.ShakeMusicMgr", "process get tv OK");
                                        obj = 1;
                                        break;
                                    }
                                    w.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
                                    jVar.e(arrayList, 4);
                                    obj = null;
                                    break;
                                }
                                String str2 = "Micromsg.ShakeMusicMgr";
                                String str3 = "wrong args, xml == null ? [%s]";
                                Object[] objArr = new Object[1];
                                objArr[0] = Boolean.valueOf(str == null);
                                w.e(str2, str3, objArr);
                                jVar.e(arrayList, 2);
                                obj = null;
                                break;
                                break;
                            case 3:
                                jVar = this.pqx;
                                arrayList = new ArrayList();
                                m.b Eh = m.b.Eh(str);
                                if (Eh != null && Eh.pqA != null) {
                                    w.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + Eh.pqA + ", title=" + Eh.title + ", thumbUrl=" + Eh.thumbUrl);
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
                                    jVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeMusicMgr", "parse pay fail");
                                jVar.e(arrayList, 4);
                                obj = null;
                                break;
                            case 4:
                                jVar = this.pqx;
                                arrayList = new ArrayList();
                                m.c Ei = m.c.Ei(str);
                                if (Ei != null && Ei.id != null) {
                                    w.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + Ei.id + ", title=" + Ei.title + ", thumbUrl=" + Ei.thumbUrl);
                                    dVar = new d();
                                    dVar.field_username = Ei.id;
                                    dVar.field_nickname = Ei.title;
                                    dVar.field_sns_bgurl = Ei.thumbUrl;
                                    dVar.field_type = 10;
                                    dVar.field_insertBatch = 1;
                                    dVar.field_lvbuffer = str.getBytes();
                                    m.baS().a(dVar, true);
                                    arrayList.add(dVar);
                                    jVar.e(arrayList, 1);
                                    obj = 1;
                                    break;
                                }
                                w.w("Micromsg.ShakeMusicMgr", "parse product fail");
                                jVar.e(arrayList, 4);
                                obj = null;
                                break;
                                break;
                            default:
                                w.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + com_tencent_mm_protocal_c_azm.uaV);
                                this.pqx.e(new ArrayList(), 4);
                                obj = null;
                                break;
                        }
                        if (obj != null) {
                            g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - this.pqx.pqw))});
                        } else {
                            g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                        }
                    } else if (z) {
                        this.pqx.e(new ArrayList(), 4);
                        g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
                    } else {
                        this.pqx.e(new ArrayList(), 4);
                        g.oUh.i(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
                    }
                } else {
                    List arrayList2 = new ArrayList();
                    if (com_tencent_mm_protocal_c_azm != null) {
                        d dVar3 = new d();
                        if (!(com_tencent_mm_protocal_c_azm.uaQ == null || com_tencent_mm_protocal_c_azm.uaQ.tZp == null)) {
                            dVar3.field_username = com_tencent_mm_protocal_c_azm.uaQ.tZp.bGX();
                        }
                        if (!(com_tencent_mm_protocal_c_azm.uaP == null || com_tencent_mm_protocal_c_azm.uaP.tZp == null)) {
                            dVar3.field_nickname = com_tencent_mm_protocal_c_azm.uaP.tZp.bGX();
                        }
                        if (!(com_tencent_mm_protocal_c_azm.uaQ == null || com_tencent_mm_protocal_c_azm.uaQ.tZp == null)) {
                            dVar3.field_distance = com_tencent_mm_protocal_c_azm.uaQ.tZp.bGX();
                        }
                        if (!(com_tencent_mm_protocal_c_azm.tGz == null || com_tencent_mm_protocal_c_azm.tGz.tZp == null)) {
                            dVar3.field_sns_bgurl = com_tencent_mm_protocal_c_azm.tGz.tZp.bGX();
                        }
                        dVar3.field_type = 4;
                        dVar3.field_insertBatch = 1;
                        try {
                            dVar3.field_lvbuffer = com_tencent_mm_protocal_c_azm.toByteArray();
                        } catch (IOException e) {
                            w.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[]{e.getLocalizedMessage()});
                        }
                        m.baS().a(dVar3, true);
                        arrayList2.add(dVar3);
                    }
                    this.pqx.por.d(arrayList2, j);
                }
            }
        });
    }

    public final void init() {
        if (!nGp) {
            if (this.pqu.bbr()) {
                nGp = true;
            } else {
                w.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void baF() {
        this.pqu.oX();
        super.baF();
    }

    public final void resume() {
    }

    public final void e(List<d> list, long j) {
        if (this.por != null) {
            this.por.d(list, j);
        }
    }
}
