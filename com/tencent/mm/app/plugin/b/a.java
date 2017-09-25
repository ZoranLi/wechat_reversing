package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.a.eq;
import com.tencent.mm.e.a.et;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.ew;
import com.tencent.mm.e.a.ex;
import com.tencent.mm.e.a.ey;
import com.tencent.mm.e.a.fc;
import com.tencent.mm.e.a.fd;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class a {

    public static class a extends com.tencent.mm.sdk.b.c<em> {
        h fyA;
        g fyB;
        c fyC;
        b fyD;
        i fyw;
        e fyx;
        f fyy;
        d fyz;

        public a() {
            this.usg = em.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            em emVar = (em) bVar;
            if (emVar.fIo.op == 1) {
                w.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
                this.fyw = new i();
                this.fyx = new e();
                this.fyy = new f();
                this.fyz = new d();
                this.fyA = new h();
                this.fyB = new g();
                this.fyC = new c();
                this.fyD = new b();
                com.tencent.mm.sdk.b.a.urY.b(this.fyw);
                com.tencent.mm.sdk.b.a.urY.b(this.fyx);
                com.tencent.mm.sdk.b.a.urY.b(this.fyy);
                com.tencent.mm.sdk.b.a.urY.b(this.fyz);
                com.tencent.mm.sdk.b.a.urY.b(this.fyA);
                com.tencent.mm.sdk.b.a.urY.b(this.fyB);
                com.tencent.mm.sdk.b.a.urY.b(this.fyC);
                com.tencent.mm.sdk.b.a.urY.b(this.fyD);
            } else if (emVar.fIo.op == 2) {
                if (this.fyw != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyw);
                }
                if (this.fyx != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyx);
                }
                if (this.fyy != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyy);
                }
                if (this.fyz != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyz);
                }
                if (this.fyA != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyA);
                }
                if (this.fyB != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyB);
                }
                if (this.fyC != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyC);
                }
                if (this.fyD != null) {
                    com.tencent.mm.sdk.b.a.urY.c(this.fyD);
                }
            }
            return true;
        }
    }

    public static class b extends com.tencent.mm.sdk.b.c<eq> {
        public b() {
            this.usg = eq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eq eqVar = (eq) bVar;
            if (m.pQG != null) {
                eqVar.fIC.fIu = m.pQG.Ez(eqVar.fIB.fID);
            }
            return true;
        }
    }

    public static class c extends com.tencent.mm.sdk.b.c<et> {
        public c() {
            this.usg = et.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            et etVar = (et) bVar;
            k jVar = new j(etVar.fIV.toUserName, etVar.fIV.content, etVar.fIV.type);
            etVar.fIW.fIX = jVar;
            etVar.fIW.fGM = jVar.fGM;
            return true;
        }
    }

    public static class d extends com.tencent.mm.sdk.b.c<ev> {
        com.tencent.mm.c.a.a fyE;
        String fyF;

        public d() {
            this.usg = ev.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ev evVar = (ev) bVar;
            if (bg.mA(evVar.fJa.fyF) && evVar.fJa.op == 1) {
                w.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", evVar.fJa.fyF);
            } else if (evVar.fJa.op == 1) {
                if (this.fyE == null) {
                    this.fyE = new com.tencent.mm.c.a.a(ab.getContext());
                } else if (!evVar.fJa.fyF.equals(this.fyF)) {
                    if (this.fyE.isPlaying()) {
                        this.fyE.ap(false);
                    }
                    this.fyF = evVar.fJa.fyF;
                } else if (this.fyE.oV()) {
                    evVar.fJb.fFj = this.fyE.oR();
                } else if (this.fyE.isPlaying()) {
                    evVar.fJb.fFj = false;
                }
                this.fyE.fzb = evVar.fJa.fJd;
                this.fyE.fza = evVar.fJa.fJe;
                evVar.fJb.fFj = this.fyE.a(evVar.fJa.fyF, evVar.fJa.fyQ, evVar.fJa.fJc, -1);
            } else if (evVar.fJa.op == 2) {
                if (this.fyE != null) {
                    this.fyE.ap(false);
                }
            } else if (evVar.fJa.op == 4 && this.fyE != null && this.fyE.isPlaying()) {
                evVar.fJb.fFj = this.fyE.ao(true);
            }
            return true;
        }
    }

    public static class e extends com.tencent.mm.sdk.b.c<ew> {
        String fyF;
        com.tencent.mm.c.b.h fyG;

        public e() {
            this.fyF = "";
            this.usg = ew.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ew ewVar = (ew) bVar;
            if (ewVar.fJf.op == 1) {
                if (this.fyG == null) {
                    this.fyG = new com.tencent.mm.c.b.h(ab.getContext(), false);
                }
                ewVar.fJg.fFj = this.fyG.bx(ewVar.fJf.username);
                this.fyF = this.fyG.getFileName();
                w.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(ewVar.fJf.op), Boolean.valueOf(ewVar.fJg.fFj));
            } else if (ewVar.fJf.op == 2 && this.fyG != null) {
                ewVar.fJg.fyF = this.fyF;
                ewVar.fJg.fFj = this.fyG.pd();
                w.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(ewVar.fJf.op), this.fyF, Boolean.valueOf(ewVar.fJg.fFj));
                this.fyF = "";
            }
            return true;
        }
    }

    public static class f extends com.tencent.mm.sdk.b.c<ey> {
        String fyF;
        com.tencent.mm.modelvoice.k fyH;
        aj fyI;
        boolean fyJ;
        boolean fyK;
        boolean fyL;
        ey fyM;
        Runnable fyN;

        public f() {
            this.fyF = "";
            this.usg = ey.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ey eyVar = (ey) bVar;
            if (eyVar instanceof ey) {
                if (eyVar.fJh.op == 1) {
                    if (this.fyH == null) {
                        this.fyH = new com.tencent.mm.modelvoice.k();
                    }
                    this.fyN = eyVar.fJh.fyN;
                    if (this.fyH.mStatus == 1) {
                        this.fyH.oX();
                    }
                    eyVar.fJi.fFj = this.fyH.bw(eyVar.fJh.filePath);
                    long j = (long) (bg.getInt(com.tencent.mm.i.g.sW().z("OpenApi", "maxVoiceRecordTime"), 60) * 1000);
                    w.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)", Long.valueOf(j));
                    if (this.fyI == null) {
                        this.fyI = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                            final /* synthetic */ f fyO;

                            {
                                this.fyO = r1;
                            }

                            public final boolean oQ() {
                                w.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
                                this.fyO.fyL = true;
                                this.fyO.oP();
                                return false;
                            }
                        }, false);
                    }
                    if (this.fyI.bJq()) {
                        this.fyI.KH();
                    }
                    this.fyL = false;
                    this.fyI.v(j, j);
                    this.fyJ = false;
                    w.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(eyVar.fJh.op), Boolean.valueOf(eyVar.fJi.fFj));
                } else if (eyVar.fJh.op == 2 && this.fyH != null) {
                    if (!this.fyJ) {
                        this.fyI.KH();
                        w.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                        oP();
                    }
                    eyVar.fJi.fFj = this.fyK;
                    w.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(eyVar.fJh.op), this.fyF, Boolean.valueOf(eyVar.fJi.fFj));
                    this.fyF = "";
                    this.fyK = false;
                }
                return true;
            }
            w.f("MicroMsg.SubCoreExtAgent", "mismatched event");
            return false;
        }

        public final void oP() {
            if (this.fyH != null) {
                this.fyK = this.fyH.oX();
                if (this.fyN != null) {
                    if (this.fyM != null) {
                        this.fyM.fJi.fJj = this.fyH.fzv.fAj;
                        this.fyM = null;
                    }
                    if (this.fyL) {
                        this.fyN.run();
                    }
                    this.fyN = null;
                }
                this.fyJ = true;
            }
        }
    }

    public static class g extends com.tencent.mm.sdk.b.c<fc> {
        public g() {
            this.usg = fc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            p pVar = null;
            fc fcVar = (fc) bVar;
            if (com.tencent.mm.modelvoice.m.Ly() == null) {
                w.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + bg.bJZ());
            }
            u Ly = com.tencent.mm.modelvoice.m.Ly();
            String str = fcVar.fJC.fyF;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE FileName= ?";
                Cursor a = Ly.hnH.a(str2, new String[]{str}, 2);
                w.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + a.getCount());
                if (a.moveToFirst()) {
                    pVar = new p();
                    pVar.b(a);
                }
                a.close();
            }
            if (pVar != null) {
                fcVar.fJD.fGM = (long) pVar.iaq;
            }
            return true;
        }
    }

    public static class h extends com.tencent.mm.sdk.b.c<fd> {
        public h() {
            this.usg = fd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fd fdVar = (fd) bVar;
            if (com.tencent.mm.modelvoice.m.Ly() == null) {
                w.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + bg.bJZ());
                fdVar.fJF.fyF = "";
            }
            p gR = com.tencent.mm.modelvoice.m.Ly().gR((int) fdVar.fJE.fGM);
            if (gR == null) {
                fdVar.fJF.fyF = "";
            } else {
                fdVar.fJF.fyF = gR.fyF;
            }
            return true;
        }
    }

    public static class i extends com.tencent.mm.sdk.b.c<ex> {
        public i() {
            this.usg = ex.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (ab.getContext() == null) {
                w.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                return false;
            }
            com.tencent.mm.modelsimple.d.bg(ab.getContext());
            return true;
        }
    }
}
