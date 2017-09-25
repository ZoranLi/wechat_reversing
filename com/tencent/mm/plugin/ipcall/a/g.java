package com.tencent.mm.plugin.ipcall.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.Iterator;

public final class g implements com.tencent.mm.plugin.ipcall.a.a.a.a, com.tencent.mm.plugin.ipcall.a.a.b.a {
    public boolean fSy = false;
    public int mMP = 0;
    public int mMQ = 0;
    public int mMR = 0;
    public boolean mMS = false;
    public boolean mMT = false;
    public a mMU;
    public d mMV = new d();
    i mMW = new i();
    com.tencent.mm.plugin.ipcall.a.f.a mMX = new com.tencent.mm.plugin.ipcall.a.f.a();
    h mMY = new h();
    c mMZ = new c();
    public e mNa = new e();
    com.tencent.mm.plugin.ipcall.a.f.g mNb = new com.tencent.mm.plugin.ipcall.a.f.g();
    public f mNc = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c mNd;
    public boolean mNe = false;
    public boolean mNf = false;
    m mNg = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ g mNh;

        {
            this.mNh = r1;
        }

        public final void cU(int i) {
            int i2 = 0;
            w.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[]{Integer.valueOf(i)});
            if (i.aEi().mOY) {
                f aEl = i.aEl();
                if (aEl.mMN == 4 || aEl.mMN == 5) {
                    i2 = 1;
                }
                if (i2 != 0 && i == 4 && this.mNh.mNc != null) {
                    this.mNh.mNc.a(this.mNh.mNd);
                }
            }
        }
    };

    public interface a {
        void aDA();

        void aDB();

        void aDC();

        void aDy();

        void aDz();

        void aZ(String str, int i);

        void ba(String str, int i);

        void bb(String str, int i);

        void u(String str, String str2, int i);

        void v(String str, String str2, int i);

        void w(String str, String str2, int i);

        void x(String str, String str2, int i);

        void y(String str, String str2, int i);
    }

    public final void aEf() {
        if (this.mNd.mOr) {
            w.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.mMS = true;
        w.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(this.mNd.mNO)});
        this.mMZ.stop();
        this.mMW.stop();
        this.mMX.a(this.mNd);
        this.mNb.a(this.mNd);
    }

    public final void oi(int i) {
        if (!this.mNd.mOr) {
            w.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        w.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(this.mNd.mNO)});
        this.mMT = true;
        this.mMZ.stop();
        this.mMW.stop();
        this.mMY.mQQ = false;
        this.mMY.mQP = i;
        this.mMY.a(this.mNd);
        this.mNb.a(this.mNd);
    }

    private void eR(boolean z) {
        w.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.mMS), Boolean.valueOf(this.mMT)});
        if (this.mMS || this.mMT) {
            w.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
        } else if (z) {
            if (this.mMU != null) {
                if (this.mNd.mOb) {
                    this.mMU.aDy();
                } else {
                    this.mMU.y(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
                }
            }
            w.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.mMW.a(this.mNd);
        } else if (this.mMU == null) {
        } else {
            if (this.mNd.mNY) {
                this.mMU.v(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
            } else if (this.mNd.mNZ) {
                this.mMU.w(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
            } else if (this.mNd.mOa) {
                this.mMU.x(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
            } else if (this.mNd.mOb) {
                this.mMU.u(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
            } else {
                this.mMU.y(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
            }
        }
    }

    private void eS(boolean z) {
        w.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.mMP = 0;
            return;
        }
        this.mMP++;
        if (this.mMP >= 2) {
            w.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
            this.mMZ.stop();
            if (i.aEl().aEe() && this.mMU != null) {
                this.mMU.aDC();
            }
        }
    }

    private void j(boolean z, int i) {
        w.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[]{Boolean.valueOf(z)});
        if (!z && i < 0 && this.mMR <= 0) {
            this.mMR++;
            w.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[]{Integer.valueOf(this.mMR)});
            this.mMX.a(this.mNd);
        }
    }

    private void k(boolean z, int i) {
        w.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.mMY.mQQ)});
        if (!z && i < 0 && this.mMQ <= 0) {
            this.mMQ++;
            w.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[]{Integer.valueOf(this.mMQ), Boolean.valueOf(this.mMY.mQQ)});
            this.mMY.a(this.mNd);
        }
    }

    private void eT(boolean z) {
        int i = 1;
        w.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aEi().mOY) {
            i.aEi().ol(this.mNd.mOh);
        }
        if (!z) {
            w.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.mMW.stop();
            if (i.aEl().mMN != 3) {
                i = 0;
            }
            if (i != 0 && this.mMU != null) {
                this.mMU.bb(this.mNd.leS, this.mNd.mNR);
            }
        } else if (this.mNd != null && z) {
            oj(this.mNd.aEy());
        }
    }

    private void eU(boolean z) {
        w.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aEi().mOY) {
            i.aEi().ol(this.mNd.mOh);
        }
        if (this.mNd != null && z) {
            int aEy = this.mNd.aEy();
            if (aEy == 2 || aEy == 1) {
                if (this.mNf) {
                    w.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    return;
                } else {
                    ap.vd().a(new o(this.mNd.mNL, this.mNd.mNM, this.mNd.aEx(), this.mNd.mNN, false), 0);
                }
            }
            oj(this.mNd.aEy());
        }
    }

    public final boolean oj(int i) {
        switch (i) {
            case 1:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (this.mNe) {
                    return true;
                }
                this.mNe = true;
                if (this.mMU == null) {
                    return true;
                }
                this.mMU.aDz();
                return true;
            case 2:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(this.mMS), Boolean.valueOf(this.mMT)});
                if (this.mMS || this.mMT) {
                    return true;
                }
                this.mMW.stop();
                if (this.fSy) {
                    return true;
                }
                this.fSy = true;
                if (this.mNd != null) {
                    this.mNd.mOr = true;
                }
                if (this.mMU != null) {
                    this.mMU.aDA();
                }
                this.mMZ.a(this.mNd);
                return true;
            case 3:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.mMW.stop();
                this.mMZ.stop();
                if (this.mMU == null) {
                    return true;
                }
                this.mMU.ba(this.mNd.leS, this.mNd.mNR);
                return true;
            case 4:
            case 7:
            case 8:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.mNd.mOa) {
                    if (this.mMU == null) {
                        return true;
                    }
                    this.mMU.x(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
                    return true;
                } else if (this.mMU == null) {
                    return true;
                } else {
                    this.mMU.aZ(this.mNd.leS, this.mNd.mNR);
                    return true;
                }
            case 5:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.mMU == null) {
                    return true;
                }
                this.mMU.aDB();
                return true;
            case 6:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.mNd.mNY = true;
                if (this.mMU == null) {
                    return true;
                }
                this.mMU.v(this.mNd.mNS, this.mNd.leS, this.mNd.mNR);
                return true;
            default:
                w.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[]{Integer.valueOf(i)});
                return false;
        }
    }

    private void eV(boolean z) {
        bjy com_tencent_mm_protocal_c_bjy = null;
        w.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            bjy com_tencent_mm_protocal_c_bjy2;
            com.tencent.mm.plugin.ipcall.a.c.a aEi = i.aEi();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.mNd;
            w.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.jEB == null || cVar.jEB.size() <= 0) {
                com_tencent_mm_protocal_c_bjy2 = null;
            } else {
                com_tencent_mm_protocal_c_bjy2 = com.tencent.mm.plugin.ipcall.b.c.X(cVar.jEB);
            }
            if (!(cVar == null || cVar.mOk == null || cVar.mOk.size() <= 0)) {
                com_tencent_mm_protocal_c_bjy = com.tencent.mm.plugin.ipcall.b.c.X(cVar.mOk);
            }
            aEi.mOV.a(com_tencent_mm_protocal_c_bjy2, com_tencent_mm_protocal_c_bjy2, com_tencent_mm_protocal_c_bjy, 0, 0);
        }
    }

    public final void a(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            w.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            return;
        }
        switch (i) {
            case 1:
                eR(true);
                return;
            case 3:
                j(true, i3);
                return;
            case 4:
                k(true, i3);
                return;
            case 6:
                eV(true);
                return;
            case 8:
                eU(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            w.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            return;
        }
        switch (i) {
            case 1:
                eR(false);
                return;
            case 3:
                j(false, i3);
                return;
            case 4:
                k(false, i3);
                return;
            case 6:
                eV(false);
                return;
            case 8:
                eU(false);
                return;
            default:
                return;
        }
    }

    public final void a(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            w.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            return;
        }
        switch (i) {
            case 2:
                eT(true);
                return;
            case 5:
                eS(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            w.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            return;
        }
        switch (i) {
            case 2:
                eT(false);
                return;
            case 5:
                eS(false);
                return;
            default:
                return;
        }
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        if (this.mNd == null || obj == null) {
            w.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            return true;
        }
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        Object obj2;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.i) {
                    com.tencent.mm.plugin.ipcall.a.d.i iVar = (com.tencent.mm.plugin.ipcall.a.d.i) obj;
                    avp com_tencent_mm_protocal_c_avp = iVar.mPV;
                    if (this.mNd.mNO == iVar.mPU.tVX) {
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[]{Integer.valueOf(this.mNd.mNO)});
                        b aEj = i.aEj();
                        if (aEj.mNO == this.mNd.mNO) {
                            w.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[]{Integer.valueOf(i3)});
                            aEj.mPn = i3;
                        }
                        if (i2 == 0 && i3 == 0) {
                            if (this.mNd != null) {
                                this.mNd.mNL = com_tencent_mm_protocal_c_avp.tvL;
                                this.mNd.mNM = com_tencent_mm_protocal_c_avp.tvM;
                                this.mNd.mNN = com_tencent_mm_protocal_c_avp.tVZ;
                                this.mNd.mNT = com_tencent_mm_protocal_c_avp.tWi;
                                this.mNd.mNW = com_tencent_mm_protocal_c_avp.tWj * 1000;
                                this.mNd.mOd = com_tencent_mm_protocal_c_avp.mOd;
                                this.mNd.mOe = com_tencent_mm_protocal_c_avp.mOe;
                                this.mNd.jEB = com_tencent_mm_protocal_c_avp.thS;
                                this.mNd.mOk = com_tencent_mm_protocal_c_avp.tWk;
                                this.mNd.mOp = com_tencent_mm_protocal_c_avp.tWl;
                                if (com_tencent_mm_protocal_c_avp.mOl > 0) {
                                    this.mNd.mOl = com_tencent_mm_protocal_c_avp.mOl;
                                }
                                this.mNd.mOf = com_tencent_mm_protocal_c_avp.mOf;
                                this.mNd.mOg = com_tencent_mm_protocal_c_avp.mOg;
                                this.mNd.mOc = com_tencent_mm_protocal_c_avp.tWn;
                                if (com_tencent_mm_protocal_c_avp.mOi > 0) {
                                    this.mNd.mOi = com_tencent_mm_protocal_c_avp.mOi - 1;
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.mNd.mOi + "] from Invite resp");
                                } else {
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.mNd.mOi = 2;
                                }
                                this.mNd.mOj = com_tencent_mm_protocal_c_avp.tWm;
                                w.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avp.mNX)});
                                if (com_tencent_mm_protocal_c_avp.mNX > 0) {
                                    this.mNd.mOb = false;
                                    this.mNd.mNX = com_tencent_mm_protocal_c_avp.mNX;
                                } else {
                                    this.mNd.mOb = true;
                                    this.mNd.mNX = 0;
                                }
                                this.mNd.mNS = com_tencent_mm_protocal_c_avp.mNS;
                                this.mNd.mNR = com_tencent_mm_protocal_c_avp.mNR;
                                this.mNd.leR = i3;
                                this.mNd.leS = bg.mz(n.a(com_tencent_mm_protocal_c_avp.tZe.tiE));
                                break;
                            }
                        }
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (com_tencent_mm_protocal_c_avp.tZe == null) {
                            this.mNd.mNS = "";
                            this.mNd.mNR = 2;
                            this.mNd.leS = ab.getContext().getString(R.l.dPU);
                            this.mNd.leR = i3;
                            break;
                        }
                        if (i3 == 433) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.mNd.mNY = true;
                        } else if (i3 == 434) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.mNd.mNZ = true;
                        } else if (i3 == 435) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.mNd.mOa = true;
                        }
                        if (com_tencent_mm_protocal_c_avp.mNX > 0) {
                            this.mNd.mOb = false;
                            this.mNd.mNX = com_tencent_mm_protocal_c_avp.mNX;
                        } else {
                            this.mNd.mOb = true;
                            this.mNd.mNX = 0;
                        }
                        this.mNd.mNS = com_tencent_mm_protocal_c_avp.mNS;
                        this.mNd.mNR = com_tencent_mm_protocal_c_avp.mNR;
                        this.mNd.leR = i3;
                        if (com_tencent_mm_protocal_c_avp.tZe != null) {
                            this.mNd.leS = bg.mz(n.a(com_tencent_mm_protocal_c_avp.tZe.tiE));
                            w.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avp.mNR), Integer.valueOf(i3), this.mNd.leS});
                            break;
                        }
                    }
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.mNd.mNO), Integer.valueOf(iVar.mPU.tVX)});
                    return true;
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                return true;
                break;
            case 2:
                if (obj instanceof o) {
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    o oVar = (o) obj;
                    asb com_tencent_mm_protocal_c_asb = oVar.mQh;
                    if (this.mNd.mNL == oVar.mQg.tvL) {
                        if (i2 == 0 && i3 == 0) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asb.tvL), Integer.valueOf(com_tencent_mm_protocal_c_asb.tWw), Integer.valueOf(com_tencent_mm_protocal_c_asb.tWx), Integer.valueOf(com_tencent_mm_protocal_c_asb.tWu)});
                            if (com_tencent_mm_protocal_c_asb.tvL == this.mNd.mNL && com_tencent_mm_protocal_c_asb.tvM == this.mNd.mNM) {
                                if (com_tencent_mm_protocal_c_asb.tWx == this.mNd.mNT) {
                                    w.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (com_tencent_mm_protocal_c_asb.tWu > this.mNd.mNU) {
                                        this.mNd.mNU = com_tencent_mm_protocal_c_asb.tWu;
                                        if (com_tencent_mm_protocal_c_asb.tWw != 0) {
                                            this.mNd.mNV = com_tencent_mm_protocal_c_asb.tWw;
                                        }
                                    }
                                } else {
                                    w.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    it = this.mNd.mOm.iterator();
                                    Object obj3 = null;
                                    while (it.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                        if (dVar.mOs == com_tencent_mm_protocal_c_asb.tWx) {
                                            if (com_tencent_mm_protocal_c_asb.tWu > dVar.mNU) {
                                                dVar.mNU = com_tencent_mm_protocal_c_asb.tWu;
                                                if (com_tencent_mm_protocal_c_asb.tWw != 0) {
                                                    dVar.gXk = com_tencent_mm_protocal_c_asb.tWw;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj3;
                                        }
                                        obj3 = obj2;
                                    }
                                    if (obj3 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.mOs = com_tencent_mm_protocal_c_asb.tWx;
                                        dVar.gXk = com_tencent_mm_protocal_c_asb.tWw;
                                        dVar.mNU = com_tencent_mm_protocal_c_asb.tWu;
                                        this.mNd.mOm.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_asb.leR == TencentLocation.ERROR_UNKNOWN || com_tencent_mm_protocal_c_asb.leR == 484) {
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.mNd.mOa = true;
                                }
                                this.mNd.leS = com_tencent_mm_protocal_c_asb.leS;
                                this.mNd.leR = com_tencent_mm_protocal_c_asb.leR;
                                this.mNd.mNR = com_tencent_mm_protocal_c_asb.mNR;
                                this.mNd.mNS = com_tencent_mm_protocal_c_asb.mNS;
                                this.mNd.mOh = com_tencent_mm_protocal_c_asb.mOh;
                                break;
                            }
                        }
                    }
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(oVar.mQg.tvL)});
                    return true;
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.mNd.mNO != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).mPD.tVX) {
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.mNd.mNO), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).mPD.tVX)});
                        return true;
                    }
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.n) {
                    if (this.mNd.mNL == ((com.tencent.mm.plugin.ipcall.a.d.n) obj).mQe.tvL) {
                        if (i2 != 0 || i3 != 0) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.mNd.mNV = 5;
                        break;
                    }
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.n) obj).mQe.tvL)});
                    return true;
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.mNd.mNL != ((com.tencent.mm.plugin.ipcall.a.d.h) obj).mPS.tvL) {
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.h) obj).mPS.tvL)});
                        return true;
                    }
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                return true;
                break;
            case 6:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.k) {
                    com.tencent.mm.plugin.ipcall.a.d.k kVar = (com.tencent.mm.plugin.ipcall.a.d.k) obj;
                    arv com_tencent_mm_protocal_c_arv = kVar.mPZ;
                    if (this.mNd.mNL == kVar.mPY.tvL) {
                        if (i2 != 0 || i3 != 0) {
                            w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.mNd.jEB = com_tencent_mm_protocal_c_arv.thS;
                        this.mNd.mOk = com_tencent_mm_protocal_c_arv.tWk;
                        break;
                    }
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(kVar.mPY.tvL)});
                    return true;
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                return true;
                break;
            case 8:
                if (obj instanceof art) {
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    art com_tencent_mm_protocal_c_art = (art) obj;
                    if (this.mNd.mNL == com_tencent_mm_protocal_c_art.tvL) {
                        if (i2 == 0 && i3 == 0) {
                            this.mNd.mOh = com_tencent_mm_protocal_c_art.mOh;
                            w.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_art.tWo.size())});
                            it = com_tencent_mm_protocal_c_art.tWo.iterator();
                            while (it.hasNext()) {
                                asc com_tencent_mm_protocal_c_asc = (asc) it.next();
                                if (this.mNd.mNT == com_tencent_mm_protocal_c_asc.tWx) {
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(this.mNd.mNT), Integer.valueOf(com_tencent_mm_protocal_c_asc.tVh), Integer.valueOf(com_tencent_mm_protocal_c_asc.tWy)});
                                    if (com_tencent_mm_protocal_c_asc.tWy > this.mNd.mNU) {
                                        this.mNd.mNU = com_tencent_mm_protocal_c_asc.tWy;
                                        if (com_tencent_mm_protocal_c_asc.tVh != 0) {
                                            this.mNd.mNV = com_tencent_mm_protocal_c_asc.tVh;
                                        }
                                    }
                                } else {
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asc.tWx), Integer.valueOf(com_tencent_mm_protocal_c_asc.tVh), Integer.valueOf(com_tencent_mm_protocal_c_asc.tWy)});
                                    Object obj4 = null;
                                    Iterator it2 = this.mNd.mOm.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.mOs == com_tencent_mm_protocal_c_asc.tWx) {
                                            if (com_tencent_mm_protocal_c_asc.tWy > dVar.mNU) {
                                                dVar.mNU = com_tencent_mm_protocal_c_asc.tWy;
                                                if (com_tencent_mm_protocal_c_asc.tVh != 0) {
                                                    dVar.gXk = com_tencent_mm_protocal_c_asc.tVh;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.mOs = com_tencent_mm_protocal_c_asc.tWx;
                                        dVar.gXk = com_tencent_mm_protocal_c_asc.tVh;
                                        dVar.mNU = com_tencent_mm_protocal_c_asc.tWy;
                                        this.mNd.mOm.add(dVar);
                                    }
                                }
                                if (com_tencent_mm_protocal_c_asc.leR == TencentLocation.ERROR_UNKNOWN || com_tencent_mm_protocal_c_asc.leR == 484) {
                                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.mNd.mOa = true;
                                }
                                this.mNd.leS = com_tencent_mm_protocal_c_asc.leS;
                                this.mNd.leR = com_tencent_mm_protocal_c_asc.leR;
                                this.mNd.mNR = com_tencent_mm_protocal_c_asc.mNR;
                                this.mNd.mNS = com_tencent_mm_protocal_c_asc.mNS;
                            }
                            break;
                        }
                    }
                    w.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.mNd.mNL), Integer.valueOf(com_tencent_mm_protocal_c_art.tvL)});
                    return true;
                }
                w.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                return true;
                break;
        }
        return false;
    }
}
