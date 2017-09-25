package com.tencent.mm.ap;

import android.os.Looper;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.e.a.rd;
import com.tencent.mm.i.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.y.k implements j, m {
    private int fFz;
    private int flags;
    private b gUA;
    private e gUD;
    private boolean hOl;

    public k(boolean z) {
        this.hOl = false;
        this.flags = -1;
        this.fFz = 26;
        this.hOl = false;
        w.d("MicroMsg.NetSceneGetPackageList", new StringBuilder("Init dkregcode:26").toString());
        w.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
    }

    public k(int i) {
        this.hOl = false;
        this.flags = -1;
        this.fFz = i;
        this.hOl = false;
        w.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.fFz);
        a aVar = new a();
        aVar.hsm = new zu();
        aVar.hsn = new zv();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.hsl = JsApiGetBackgroundAudioState.CTRL_INDEX;
        aVar.hso = 51;
        aVar.hsp = 1000000051;
        this.gUA = aVar.BE();
        zu zuVar = (zu) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        if (!h.vG().uV()) {
            return -1;
        }
        m[] gl = t.Ic().gl(this.fFz);
        if (gl != null && gl.length > 0) {
            for (int i = 0; i < gl.length; i++) {
                apb com_tencent_mm_protocal_c_apb = new apb();
                com_tencent_mm_protocal_c_apb.mvT = gl[i].id;
                if (r.iiM && this.fFz == 7) {
                    w.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                    com_tencent_mm_protocal_c_apb.jOb = 0;
                } else {
                    com_tencent_mm_protocal_c_apb.jOb = gl[i].version;
                }
                w.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_apb.mvT), Integer.valueOf(com_tencent_mm_protocal_c_apb.jOb));
                linkedList.add(com_tencent_mm_protocal_c_apb);
            }
        }
        zuVar.jNe = linkedList;
        zuVar.jNd = linkedList.size();
        zuVar.jOc = this.fFz;
        if (this.flags != -1) {
            zuVar.teT = this.flags;
        }
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 20;
    }

    protected final void a(a aVar) {
    }

    public final boolean BI() {
        return true;
    }

    private m a(apb com_tencent_mm_protocal_c_apb) {
        m mVar = new m();
        mVar.id = com_tencent_mm_protocal_c_apb.mvT;
        mVar.version = com_tencent_mm_protocal_c_apb.jOb;
        mVar.name = com_tencent_mm_protocal_c_apb.msj;
        mVar.size = com_tencent_mm_protocal_c_apb.jNW;
        mVar.hOq = com_tencent_mm_protocal_c_apb.tuV;
        mVar.status = 5;
        mVar.fKL = this.fFz;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fFz), str);
        if (i2 == 0 || i3 == 0) {
            zv zvVar = (zv) ((b) pVar).hsk.hsr;
            if (zvVar.jOc != this.fFz) {
                w.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(zvVar.jOc));
                this.gUD.a(3, -1, "", this);
                return;
            }
            LinkedList linkedList = zvVar.jNe;
            w.v("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.fFz + " resp.Type: " + zvVar.jOc);
            if (this.fFz == 2) {
                i(linkedList);
            } else if (this.fFz == 1) {
                h(linkedList);
            } else if (this.fFz == 4) {
                j(linkedList);
            } else if (this.fFz == 6) {
                w.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.fFz == 7) {
                k(linkedList);
            } else if (this.fFz == 8) {
                if (linkedList == null || linkedList.size() <= 0) {
                    w.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
                } else {
                    w.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (apb) linkedList.get(0);
                    r3 = t.Ic().aQ(r1.mvT, this.fFz);
                    r4 = a(r1);
                    r4.fRW = -1;
                    if (r3 == null) {
                        t.Ic().a(r4);
                    } else {
                        t.Ic().b(r4);
                    }
                    w.d("MicroMsg.NetSceneGetPackageList", r1.msj + " - " + r1.mvT + " - " + r1.tuV + " - " + r1.jNW);
                }
            } else if (this.fFz == 9) {
                g(linkedList);
            } else if (this.fFz == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    w.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    w.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (apb) linkedList.get(0);
                    r3 = t.Ic().aQ(r1.mvT, this.fFz);
                    r1 = a(r1);
                    r1.fRW = -1;
                    if (r3 == null) {
                        t.Ic().a(r1);
                    } else {
                        t.Ic().b(r1);
                    }
                }
            } else if (this.fFz != 11) {
                if (this.fFz == 12) {
                    m(linkedList);
                } else if (this.fFz == 5) {
                    n(linkedList);
                } else if (this.fFz == 20) {
                    l(linkedList);
                } else if (this.fFz == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        w.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        r1 = (apb) linkedList.get(0);
                        w.d("MicroMsg.NetSceneGetPackageList", r1.msj + " - " + r1.mvT + " - " + r1.tuV + " - " + r1.jNW);
                        r3 = t.Ic().aQ(r1.mvT, this.fFz);
                        r4 = a(r1);
                        r4.fRW = -1;
                        if (r3 == null) {
                            t.Ic().a(r4);
                        } else {
                            t.Ic().b(r4);
                        }
                        com.tencent.mm.sdk.b.b kzVar = new kz();
                        try {
                            kzVar.fRG.content = n.a(r1.tfV);
                            if (kzVar.fRG.content != null) {
                                com.tencent.mm.sdk.b.a.urY.a(kzVar, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.fFz == 18) {
                    if (linkedList == null || linkedList.size() == 0) {
                        w.d("MicroMsg.NetSceneGetPackageList", "feature list type is null");
                    } else {
                        r1 = (apb) linkedList.get(0);
                        w.d("MicroMsg.NetSceneGetPackageList", r1.msj + " - " + r1.mvT + " - " + r1.tuV + " - " + r1.jNW + "-" + r1.jOb);
                        r3 = t.Ic().aQ(r1.mvT, this.fFz);
                        if (r3 == null) {
                            w.i("MicroMsg.NetSceneGetPackageList", "Feature List First Time Update");
                            t.Ic().a(a(r1));
                            b(r1);
                        } else if (r3.version < r1.jOb) {
                            w.i("MicroMsg.NetSceneGetPackageList", "Feature List New Version");
                            t.Ic().b(a(r1));
                            b(r1);
                        } else {
                            w.i("MicroMsg.NetSceneGetPackageList", "Feature List Old Version");
                        }
                    }
                } else if (this.fFz == 19) {
                    K(linkedList);
                } else if (this.fFz == 21) {
                    if (linkedList == null || linkedList.size() <= 0) {
                        w.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                    } else {
                        r1 = (apb) linkedList.get(0);
                        w.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + r1 + "|id = " + r1.mvT + "|Name = " + r1.msj + "|PackName = " + r1.tuV + "|Size = " + r1.jNW + "|Version = " + r1.jOb);
                        r3 = t.Ic().aQ(r1.mvT, this.fFz);
                        r1 = a(r1);
                        r1.fRW = -1;
                        if (r3 == null) {
                            t.Ic().a(r1);
                        } else if (r3.version < r1.version) {
                            t.Ic().b(r1);
                        } else {
                            w.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(r3.version), Integer.valueOf(r1.version));
                        }
                    }
                } else if (23 == this.fFz) {
                    if (linkedList == null || linkedList.size() <= 0) {
                        w.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                    } else {
                        r1 = (apb) linkedList.get(0);
                        w.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + r1 + "|id = " + r1.mvT + "|Name = " + r1.msj + "|PackName = " + r1.tuV + "|Size = " + r1.jNW + "|Version = " + r1.jOb);
                        r3 = t.Ic().aQ(r1.mvT, this.fFz);
                        r1 = a(r1);
                        r1.fRW = -1;
                        if (r3 == null) {
                            t.Ic().a(r1);
                        } else if (r3.version < r1.version) {
                            t.Ic().b(r1);
                        }
                    }
                } else if (this.fFz == 26) {
                    L(linkedList);
                } else if (this.fFz == 36) {
                    M(linkedList);
                } else if (this.fFz == 37) {
                    o(linkedList);
                }
            }
            com.tencent.mm.sdk.b.b rdVar = new rd();
            rdVar.fYf.fYg = linkedList;
            rdVar.fYf.fFz = this.fFz;
            com.tencent.mm.sdk.b.a.urY.m(rdVar);
            if (zvVar.tlZ <= 0) {
                this.gUD.a(i2, i3, str, this);
                return;
            } else if (a(this.hsD, this.gUD) == -1) {
                this.gUD.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    private static void b(apb com_tencent_mm_protocal_c_apb) {
        com.tencent.mm.sdk.b.b fqVar = new fq();
        fqVar.fKH.fKI = com_tencent_mm_protocal_c_apb;
        com.tencent.mm.sdk.b.a.urY.m(fqVar);
    }

    protected final boolean b(com.tencent.mm.y.k kVar) {
        if ((kVar instanceof k) && this.fFz == ((k) kVar).fFz) {
            return false;
        }
        return true;
    }

    private void g(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            return;
        }
        t.Ic();
        String HY = n.HY();
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                com.tencent.mm.loader.stub.b.deleteFile(HY + t.Ic().aS(com_tencent_mm_protocal_c_apb.mvT, this.fFz));
                m a = a(com_tencent_mm_protocal_c_apb);
                a.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a);
                } else {
                    t.Ic().b(a);
                }
                h.vH().gXC.a(new j(a.id, 9), 0);
            }
            if (n.a(com_tencent_mm_protocal_c_apb.tfV) != null) {
                w.v("MicroMsg.NetSceneGetPackageList", "xml:" + new String(n.a(com_tencent_mm_protocal_c_apb.tfV)));
            }
            if (n.a(com_tencent_mm_protocal_c_apb.tUb) != null) {
                w.v("MicroMsg.NetSceneGetPackageList", "xml2:" + new String(n.a(com_tencent_mm_protocal_c_apb.tUb)));
            }
            w.v("MicroMsg.NetSceneGetPackageList", "xml3:" + com_tencent_mm_protocal_c_apb.toString());
            w.v("MicroMsg.NetSceneGetPackageList", "xml4:" + com_tencent_mm_protocal_c_apb.msj);
            w.v("MicroMsg.NetSceneGetPackageList", "xml5:" + com_tencent_mm_protocal_c_apb.tuV);
        }
    }

    private void h(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            return;
        }
        t.Ic();
        String HY = n.HY();
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                com.tencent.mm.loader.stub.b.deleteFile(HY + t.Ic().aS(com_tencent_mm_protocal_c_apb.mvT, this.fFz));
                m a = a(com_tencent_mm_protocal_c_apb);
                a.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a);
                } else {
                    t.Ic().b(a);
                }
            }
            byte[] a2 = n.a(com_tencent_mm_protocal_c_apb.tfV);
            if (a2 != null && a2.length > 0) {
                t.Ic();
                String aR = n.aR(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
                com.tencent.mm.loader.stub.b.deleteFile(HY + aR);
                com.tencent.mm.a.e.a(HY, aR, a2);
            }
        }
    }

    @Deprecated
    private void i(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            m a = a(com_tencent_mm_protocal_c_apb);
            a.fRW = -1;
            if (aQ == null) {
                t.Ic().a(a);
            } else {
                t.Ic().b(a);
            }
            byte[] a2 = n.a(com_tencent_mm_protocal_c_apb.tfV);
            if (a2 != null && a2.length > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new String(a2));
                arrayList.size();
            }
        }
    }

    private void j(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        w.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        t.Ic();
        String HY = n.HY();
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            byte[] a = n.a(com_tencent_mm_protocal_c_apb.tfV);
            if (com_tencent_mm_protocal_c_apb.tfV == null) {
                w.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
            } else {
                if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                    String str = new String(a);
                    String str2 = "zh_CN";
                    if (str.indexOf(str2) < 0) {
                        str2 = "en";
                        if (str.indexOf(str2) < 0) {
                            str2 = "zh_TW";
                            if (str.indexOf(str2) < 0) {
                                str2 = "en";
                            }
                        }
                    }
                    str = str2 + "_ARTIST.mm";
                    com.tencent.mm.loader.stub.b.deleteFile(HY + str);
                    com.tencent.mm.loader.stub.b.deleteFile(HY + str2 + "_ARTISTF.mm");
                    com.tencent.mm.a.e.a(HY, str, a);
                }
                m a2 = a(com_tencent_mm_protocal_c_apb);
                a2.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a2);
                } else {
                    t.Ic().b(a2);
                }
                w.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_apb.msj + " - " + com_tencent_mm_protocal_c_apb.mvT + " - " + com_tencent_mm_protocal_c_apb.tuV + " - " + com_tencent_mm_protocal_c_apb.jNW);
            }
        }
    }

    private void k(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            return;
        }
        w.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            m a = a(com_tencent_mm_protocal_c_apb);
            a.fRW = -1;
            if (aQ == null) {
                t.Ic().a(a);
            } else {
                t.Ic().b(a);
            }
            w.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_apb.msj + " - " + com_tencent_mm_protocal_c_apb.mvT + " - " + com_tencent_mm_protocal_c_apb.tuV + " - " + com_tencent_mm_protocal_c_apb.jNW);
            byte[] a2 = n.a(com_tencent_mm_protocal_c_apb.tfV);
            w.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + new String(a2));
            c sW = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sW();
            int i2 = com_tencent_mm_protocal_c_apb.mvT;
            File file = new File(c.gTi);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(c.er(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.tencent.mm.a.e.b(c.er(i2), a2, a2.length);
                sW.l(i2, new String(a2));
            } catch (Throwable e) {
                w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e));
            }
        }
    }

    private void l(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            return;
        }
        w.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            apb com_tencent_mm_protocal_c_apb = (apb) it.next();
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            m a = a(com_tencent_mm_protocal_c_apb);
            a.fRW = -1;
            if (aQ == null) {
                t.Ic().a(a);
            } else {
                t.Ic().b(a);
            }
            w.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_apb.msj + " - " + com_tencent_mm_protocal_c_apb.mvT + " - " + com_tencent_mm_protocal_c_apb.tuV + " - " + com_tencent_mm_protocal_c_apb.jNW);
        }
    }

    private void m(LinkedList<apb> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            return;
        }
        w.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) linkedList.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            m a = a(com_tencent_mm_protocal_c_apb);
            a.fRW = -1;
            if (aQ == null) {
                t.Ic().a(a);
            } else {
                t.Ic().b(a);
            }
            h.vH().gXC.a(new j(a.id, 12), 0);
        }
    }

    private void K(List<apb> list) {
        if (list == null || list.size() <= 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            return;
        }
        t.Ic();
        String HY = n.HY();
        for (int i = 0; i < list.size(); i++) {
            apb com_tencent_mm_protocal_c_apb = (apb) list.get(i);
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                com.tencent.mm.loader.stub.b.deleteFile(HY + t.Ic().aS(com_tencent_mm_protocal_c_apb.mvT, this.fFz));
                m a = a(com_tencent_mm_protocal_c_apb);
                a.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a);
                } else {
                    t.Ic().b(a);
                }
                h.vH().gXC.a(new j(a.id, 19), 0);
            }
            w.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", com_tencent_mm_protocal_c_apb.msj, com_tencent_mm_protocal_c_apb.tuV);
        }
    }

    private void L(List<apb> list) {
        if (list == null || list.size() == 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            return;
        }
        w.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(-1))).intValue();
        w.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue != -1) {
            m aQ = t.Ic().aQ(intValue, this.fFz);
            for (apb a : list) {
                m a2 = a(a);
                w.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.id), Integer.valueOf(a2.version));
                if (aQ != null && a2.id == intValue) {
                    w.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                    t.Ic().b(a2);
                    return;
                } else if (aQ == null && a2.id == intValue) {
                    w.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                    t.Ic().a(a2);
                    return;
                }
            }
        }
    }

    private void M(List<apb> list) {
        if (list == null || list.size() == 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            return;
        }
        w.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (apb com_tencent_mm_protocal_c_apb : list) {
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                m a = a(com_tencent_mm_protocal_c_apb);
                a.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a);
                } else {
                    t.Ic().b(a);
                }
                h.vH().gXC.a(new j(a.id, 36), 0);
            }
        }
    }

    private void n(LinkedList<apb> linkedList) {
        w.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            apb com_tencent_mm_protocal_c_apb = (apb) it.next();
            w.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", com_tencent_mm_protocal_c_apb.toString());
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            m a = a(com_tencent_mm_protocal_c_apb);
            a.fRW = -1;
            if (aQ == null) {
                t.Ic().a(a);
            } else {
                t.Ic().b(a);
            }
        }
    }

    private void o(LinkedList<apb> linkedList) {
        w.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            w.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            return;
        }
        w.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            apb com_tencent_mm_protocal_c_apb = (apb) it.next();
            m aQ = t.Ic().aQ(com_tencent_mm_protocal_c_apb.mvT, this.fFz);
            if (aQ == null || aQ.version != com_tencent_mm_protocal_c_apb.jOb) {
                m a = a(com_tencent_mm_protocal_c_apb);
                a.fRW = -1;
                if (aQ == null) {
                    t.Ic().a(a);
                } else {
                    t.Ic().b(a);
                }
                h.vH().gXC.a(new j(a.id, 37), 0);
            }
        }
    }

    public final int getType() {
        return JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    public final int BQ() {
        return this.fFz;
    }
}
