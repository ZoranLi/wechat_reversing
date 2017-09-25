package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements com.tencent.mm.sdk.e.j.a {
    public Queue<b> hDH = new LinkedList();
    public aj hDL = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b hJN;

        {
            this.hJN = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
            b bVar = this.hJN;
            long Nz = u.Nz();
            if (bVar.hqI && Nz - bVar.hqT > 300000) {
                w.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Nz - bVar.hqT));
                bVar.hqI = false;
            }
            if (bVar.hqI) {
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + bVar.hqI + " ret");
            } else {
                a aVar;
                String str = null;
                a aVar2 = null;
                if (!bVar.hJK.isEmpty()) {
                    aVar = (a) bVar.hJK.poll();
                    str = aVar.hJP;
                    aVar2 = aVar;
                }
                if (aVar2 == null) {
                    synchronized (bVar.hJJ) {
                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", Integer.valueOf(bVar.hJJ.size()), bVar.hJJ);
                        if (bVar.hJL == null || u.mA(bVar.hJL.Hq())) {
                            bVar.hJJ.clear();
                            bVar.hJL = null;
                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
                        } else {
                            str = bVar.hJL.Hq();
                            LinkedList linkedList = (LinkedList) bVar.hJJ.get(str);
                            if (linkedList == null || linkedList.size() == 0) {
                                String str2 = "MicroMsg.GetChatRoomMsgService";
                                String str3 = "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d";
                                Object[] objArr = new Object[2];
                                objArr[0] = str;
                                objArr[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                w.i(str2, str3, objArr);
                            } else {
                                while (!linkedList.isEmpty()) {
                                    a aVar3 = (a) linkedList.poll();
                                    ap.yY();
                                    ce y = com.tencent.mm.u.c.wT().y(str, (long) aVar3.hJR);
                                    if (y.field_msgId == 0) {
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + aVar3);
                                        aVar = aVar3;
                                        break;
                                    } else if ((y.field_flag & 1) != 0) {
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + aVar3 + " flag:" + y.field_flag + " seq:" + y.field_msgSeq);
                                        aVar = aVar3;
                                        break;
                                    } else {
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + aVar3 + " flag:" + y.field_flag + " seq:" + y.field_msgSeq);
                                    }
                                }
                                aVar = aVar2;
                                if (aVar == null && !u.mA(str)) {
                                    ap.yY();
                                    ae Rm = com.tencent.mm.u.c.wW().Rm(str);
                                    if (Rm != null) {
                                        long j = Rm.field_lastSeq;
                                        long j2 = Rm.field_firstUnDeliverSeq;
                                        int i = Rm.field_UnDeliverCount;
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i));
                                        if (j != 0) {
                                            ap.yY();
                                            if (com.tencent.mm.u.c.wT().y(str, j).field_msgId == 0) {
                                                aVar = new a(str, (int) j2, (int) j, i, 1);
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + aVar);
                                            } else {
                                                if (i > 0) {
                                                    Rm.dt(0);
                                                    ap.yY();
                                                    com.tencent.mm.u.c.wW().a(Rm, str);
                                                }
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", Long.valueOf(r5.field_msgId), Long.valueOf(r5.field_msgSvrId), Integer.valueOf(Rm.field_UnDeliverCount));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar = aVar2;
                }
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + aVar);
                if (aVar == null) {
                    bVar.hDL.v(500, 500);
                } else {
                    bVar.hqI = true;
                    bVar.hqT = Nz;
                    com.tencent.mm.bd.a wrVar = new wr();
                    wrVar.tDp = n.mw(str);
                    wrVar.tfl = aVar.hJR;
                    if (aVar.hJR == 0) {
                        wrVar.tDq = 0;
                        if (aVar.hJS != 0) {
                            w.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", Integer.valueOf(aVar.hJS), u.NC());
                        }
                    } else {
                        wrVar.tDq = 18;
                    }
                    wrVar.tDr = aVar.hJT;
                    wrVar.tDt = aVar.hJQ;
                    if ((wrVar.tDr != 0 && wrVar.tDt > wrVar.tfl) || (wrVar.tDr == 0 && wrVar.tDt < wrVar.tfl)) {
                        w.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", Integer.valueOf(wrVar.tDt), Integer.valueOf(wrVar.tfl), Integer.valueOf(wrVar.tDr), u.NC());
                        com.tencent.mm.plugin.report.c.oTb.a(403, wrVar.tDr == 0 ? 0 : 1, 1, false);
                        if (bVar.hJL != null) {
                            bVar.hJL.gd(1);
                        }
                    }
                    if (wrVar.tDr != 0 && wrVar.tDt == 0 && aVar.hJS < 18) {
                        if (aVar.hJS > 0) {
                            wrVar.tDq = aVar.hJS;
                        } else {
                            wrVar.tDq = 1;
                            com.tencent.mm.plugin.report.c.oTb.a(403, 3, 1, false);
                        }
                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", Integer.valueOf(aVar.hJS), Integer.valueOf(wrVar.tDq));
                    }
                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", Integer.valueOf(wrVar.tDt), Integer.valueOf(wrVar.tfl), Integer.valueOf(wrVar.tDq), Integer.valueOf(wrVar.tDr), Integer.valueOf(wrVar.tDs));
                    com.tencent.mm.y.b.a aVar4 = new com.tencent.mm.y.b.a();
                    aVar4.hsm = wrVar;
                    aVar4.hsn = new ws();
                    aVar4.uri = "/cgi-bin/micromsg-bin/getcrmsg";
                    aVar4.hsl = 805;
                    aVar4.hso = 0;
                    aVar4.hsp = 0;
                    com.tencent.mm.plugin.report.c.oTb.a(403, wrVar.tfl == 0 ? 9 : 8, 1, false);
                    com.tencent.mm.y.u.a(aVar4.BE(), new com.tencent.mm.y.u.a(bVar) {
                        final /* synthetic */ b hJN;

                        {
                            this.hJN = r1;
                        }

                        public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (kVar.getType() != 805) {
                                return 0;
                            }
                            com.tencent.mm.plugin.report.c.oTb.a(403, 10, 1, false);
                            this.hJN.hqI = false;
                            if (i == 0 && i2 == 0 && bVar != null) {
                                wr wrVar = (wr) bVar.hsj.hsr;
                                ws wsVar = (ws) bVar.hsk.hsr;
                                String a = n.a(wrVar.tDp);
                                String str2;
                                if (wrVar.tfl == 0) {
                                    String str3 = "MicroMsg.GetChatRoomMsgService";
                                    str2 = "summerbadcr clear chatroomId[%s], resp size[%d], ContinueFlag[%d]";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = a;
                                    objArr[1] = Integer.valueOf(wsVar.tDu == null ? -1 : wsVar.tDu.size());
                                    objArr[2] = Integer.valueOf(wsVar.tlZ);
                                    w.i(str3, str2, objArr);
                                    if (this.hJN.hDL.bJq()) {
                                        this.hJN.hDL.v(500, 500);
                                    }
                                    com.tencent.mm.plugin.report.c.oTb.a(403, 12, 1, false);
                                    return 0;
                                }
                                String str4;
                                int i3;
                                int i4;
                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback req chatroomId[%s], resp ContinueFlag[%d]", a, Integer.valueOf(wsVar.tlZ));
                                synchronized (this.hJN.hJJ) {
                                    if (this.hJN.hJL == null || u.mA(this.hJN.hJL.Hq())) {
                                        this.hJN.hJJ.clear();
                                        this.hJN.hJL = null;
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener is or its chatroomid is null so clear map");
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 15, 1, false);
                                    } else if (this.hJN.hJL.Hq().equals(a)) {
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 13, 1, false);
                                        LinkedList linkedList = wsVar.tDu;
                                        str4 = "MicroMsg.GetChatRoomMsgService";
                                        String str5 = "summerbadcr callback currentListener still in and resp.ContinueFlag[%d], size[%d]";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(wsVar.tlZ);
                                        objArr2[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                        w.i(str4, str5, objArr2);
                                        if (!(wsVar.tlZ <= 0 || linkedList == null || linkedList.isEmpty())) {
                                            i3 = ((bu) linkedList.getFirst()).tfl;
                                            i4 = ((bu) linkedList.getLast()).tfl;
                                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback ContinueFlag[%d], list size[%d],firstSeq[%d], lastSeq[%d], UpDownFlag[%d]", Integer.valueOf(wsVar.tlZ), Integer.valueOf(linkedList.size()), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(wrVar.tDr));
                                        }
                                    } else {
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener changed current[%s], old[%s]", this.hJN.hJL.Hq(), a);
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 14, 1, false);
                                    }
                                }
                                if (this.hJN.hDL.bJq()) {
                                    this.hJN.hDL.v(500, 500);
                                }
                                if (wsVar.tDu == null || wsVar.tDu.isEmpty()) {
                                    com.tencent.mm.plugin.report.c.oTb.a(403, 19, 1, false);
                                    str2 = "MicroMsg.GetChatRoomMsgService";
                                    str4 = "summerbadcr callback resp.AddMsgList is null[%b], empty[%b]";
                                    Object[] objArr3 = new Object[2];
                                    objArr3[0] = Boolean.valueOf(this.hJN.hDH == null);
                                    objArr3[1] = Boolean.valueOf(this.hJN.hDH != null ? this.hJN.hDH.isEmpty() : true);
                                    w.i(str2, str4, objArr3);
                                    if (wsVar.tlZ == 0 && wrVar.tDr != 0) {
                                        ap.yY();
                                        au y = com.tencent.mm.u.c.wT().y(a, (long) wrVar.tfl);
                                        int i5;
                                        if (y.field_msgSeq == ((long) wrVar.tfl)) {
                                            i5 = y.field_flag;
                                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty reset Fault[%d, %d, %d, %d, %d, %d, %d]", Integer.valueOf(y.field_flag), Integer.valueOf(y.field_isSend), Long.valueOf(y.field_msgId), Long.valueOf(y.field_msgSvrId), Long.valueOf(y.field_msgSeq), Long.valueOf(y.field_createTime), Integer.valueOf(y.field_type));
                                            if ((i5 & 1) != 0) {
                                                long j;
                                                y.dF(i5 & -2);
                                                ap.yY();
                                                com.tencent.mm.u.c.wT().a(y.field_msgId, y);
                                                com.tencent.mm.plugin.report.c cVar = com.tencent.mm.plugin.report.c.oTb;
                                                if (u.aA(y.field_createTime) < 259200000) {
                                                    j = 36;
                                                } else {
                                                    j = 37;
                                                }
                                                cVar.a(403, j, 1, false);
                                            }
                                        } else {
                                            ap.yY();
                                            ae Rm = com.tencent.mm.u.c.wW().Rm(a);
                                            if (Rm != null) {
                                                ap.yY();
                                                ce Aj = com.tencent.mm.u.c.wT().Aj(a);
                                                if (Aj != null) {
                                                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty need reset lastseq by last receive id[%d] svrid[%d], flag[%d] createtime[%d] seq[%d -> %d]", Long.valueOf(Aj.field_msgId), Long.valueOf(Aj.field_msgSvrId), Integer.valueOf(Aj.field_flag), Long.valueOf(Aj.field_createTime), Long.valueOf(Rm.field_lastSeq), Long.valueOf(Aj.field_msgSeq));
                                                    Rm.u(Aj.field_msgSeq);
                                                } else {
                                                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty but no receive msg!");
                                                    Rm.u(0);
                                                }
                                                Rm.dB(0);
                                                ap.yY();
                                                i5 = com.tencent.mm.u.c.wW().a(Rm, Rm.field_username, false);
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty and update conv ret:%d", Integer.valueOf(i5));
                                            } else {
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList but conv is null!");
                                            }
                                        }
                                    }
                                } else {
                                    boolean z;
                                    boolean z2;
                                    b bVar2 = new b(this.hJN);
                                    bVar2.hJP = a;
                                    bVar2.hJT = wrVar.tDr;
                                    if (wsVar.tlZ == 0) {
                                        bVar2.hJV = false;
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 21, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 20, 1, false);
                                    }
                                    ap.yY();
                                    ae Rm2 = com.tencent.mm.u.c.wW().Rm(a);
                                    int size;
                                    if (wrVar.tDr != 0) {
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 18, (long) wsVar.tDu.size(), false);
                                        size = (Rm2 == null ? 0 : Rm2.field_UnDeliverCount) - wsVar.tDu.size();
                                        if (size < 0) {
                                            size = 0;
                                        }
                                        if (Rm2 != null) {
                                            Rm2.dB(size);
                                            ap.yY();
                                            i3 = com.tencent.mm.u.c.wW().a(Rm2, Rm2.field_username, false);
                                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback up and FilterSeq 0 but NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(wrVar.tDq), Integer.valueOf(i4), Integer.valueOf(Rm2.field_UnDeliverCount), Integer.valueOf(i3));
                                        }
                                        if (Rm2 == null && size == 0) {
                                            bVar2.hJV = false;
                                        }
                                    } else {
                                        if (wrVar.tDt <= 0 || wrVar.tDt != wrVar.tfl) {
                                            com.tencent.mm.plugin.report.c.oTb.a(403, 16, (long) wsVar.tDu.size(), false);
                                        } else {
                                            com.tencent.mm.plugin.report.c.oTb.a(403, 17, (long) wsVar.tDu.size(), false);
                                        }
                                        if (Rm2 != null) {
                                            size = Rm2.field_UnDeliverCount;
                                            if (size > 0) {
                                                i4 = size - wsVar.tDu.size();
                                                if (i4 < 0) {
                                                    i4 = 0;
                                                }
                                                Rm2.dB(i4);
                                                ap.yY();
                                                i4 = com.tencent.mm.u.c.wW().a(Rm2, Rm2.field_username, false);
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback down NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(wrVar.tDq), Integer.valueOf(size), Integer.valueOf(Rm2.field_UnDeliverCount), Integer.valueOf(i4));
                                            }
                                        }
                                    }
                                    ap.yY();
                                    i3 = (int) com.tencent.mm.u.c.xC().Ad(a);
                                    if (i3 != 0) {
                                        z = false;
                                        while (!wsVar.tDu.isEmpty() && ((bu) wsVar.tDu.peek()).tfl <= i3) {
                                            wsVar.tDu.poll();
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        bVar2.hJV = false;
                                    }
                                    if (wrVar.tDr == 0 || wsVar.tDu.isEmpty()) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (wsVar.tDu.size() > 1 && z2) {
                                        Collections.reverse(wsVar.tDu);
                                    }
                                    if (!wsVar.tDu.isEmpty()) {
                                        bVar2.hJU = wsVar.tDu;
                                        this.hJN.hDH.add(bVar2);
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback add resp to respList size[%d], dealFault[%b], lastDeleteSeq[%d], needReverse[%b], removed[%b]", Integer.valueOf(this.hJN.hDH.size()), Boolean.valueOf(bVar2.hJV), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
                                    }
                                }
                                if (!this.hJN.hDH.isEmpty() && this.hJN.hDM.bJq()) {
                                    this.hJN.hDM.v(50, 50);
                                } else if (this.hJN.hJL != null) {
                                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty[%b] stopped[%b] at last", Boolean.valueOf(this.hJN.hDH.isEmpty()), Boolean.valueOf(this.hJN.hDM.bJq()));
                                    this.hJN.hJL.gd(1);
                                }
                                return 0;
                            }
                            w.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback errType:" + i + " errCode:" + i2 + " will retry");
                            if (this.hJN.hJL != null) {
                                w.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback err as ret errType, errcode[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                                this.hJN.hJL.gd(1);
                            }
                            com.tencent.mm.plugin.report.c.oTb.a(403, 11, 1, false);
                            this.hJN.hDL.v(5000, 5000);
                            return 0;
                        }
                    }, true);
                }
            }
            return false;
        }
    }, false);
    public final aj hDM = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b hJN;
        private g hJO;

        {
            this.hJN = r1;
        }

        public final boolean oQ() {
            ap.yY();
            com.tencent.mm.u.c.wT().Ae("MicroMsg.GetChatRoomMsgService" + this.hJN.hashCode());
            if (this.hJN.hDH.isEmpty()) {
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
                ap.yY();
                com.tencent.mm.u.c.wT().Af("MicroMsg.GetChatRoomMsgService" + this.hJN.hashCode());
                return false;
            }
            boolean z;
            long Nz = u.Nz();
            int i = (this.hJN.hqI ? 9 : 18) + 1;
            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", Integer.valueOf(i));
            int i2 = 0;
            while (i2 < i) {
                b bVar = (b) this.hJN.hDH.peek();
                if (bVar == null) {
                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", this.hJN.hJL);
                    ap.yY();
                    com.tencent.mm.u.c.wT().Af("MicroMsg.GetChatRoomMsgService" + this.hJN.hashCode());
                    z = false;
                    if (this.hJN.hJL != null) {
                        this.hJN.hJL.gd(0);
                    }
                    this.hJN.hDL.v(0, 0);
                } else {
                    LinkedList linkedList = bVar.hJU;
                    int size = linkedList.size();
                    int i3 = size - 1;
                    int i4 = bVar.hDU;
                    if (size <= i4) {
                        this.hJN.hDH.poll();
                        if (this.hJN.hDH.isEmpty()) {
                            b.d(new HashMap(this.hJN.hJM), bVar.hJP);
                            ap.yY();
                            com.tencent.mm.u.c.wT().Af("MicroMsg.GetChatRoomMsgService" + this.hJN.hashCode());
                            String str = "MicroMsg.GetChatRoomMsgService";
                            String str2 = "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i4);
                            objArr[1] = Integer.valueOf(size);
                            objArr[2] = this.hJN.hJL;
                            objArr[3] = Boolean.valueOf(this.hJN.hJL == null ? false : this.hJN.hJL.Hr());
                            w.i(str, str2, objArr);
                            z = false;
                            if (this.hJN.hJL != null) {
                                this.hJN.hJL.gd(0);
                            }
                            this.hJN.hDL.v(0, 0);
                        } else {
                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i4), Integer.valueOf(size));
                        }
                    } else {
                        boolean z2;
                        int i5;
                        au y;
                        long j;
                        au y2;
                        bu buVar = (bu) linkedList.get(i4);
                        w.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", Integer.valueOf(i4), Integer.valueOf(i3), Boolean.valueOf(bVar.hJV), Integer.valueOf(buVar.tfl), Integer.valueOf(buVar.ogM), Integer.valueOf(buVar.mtd));
                        boolean z3 = false;
                        int i6 = -1;
                        if (bVar.hJV && i4 == i3) {
                            ap.yY();
                            if (com.tencent.mm.u.c.wT().y(bVar.hJP, (long) buVar.tfl).field_msgId == 0) {
                                ap.yY();
                                com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(bVar.hJP);
                                if (Rm == null) {
                                    z2 = true;
                                    i5 = -1;
                                } else {
                                    if (!(bVar.hJT == 0 || Rm.field_firstUnDeliverSeq == ((long) buVar.tfl)) || (bVar.hJT == 0 && Rm.field_lastSeq != ((long) buVar.tfl))) {
                                        z3 = true;
                                        i6 = Rm.field_UnDeliverCount;
                                    }
                                    z2 = z3;
                                    i5 = i6;
                                }
                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hJT), Integer.valueOf(buVar.tfl));
                                if (this.hJO == null) {
                                    this.hJO = (g) h.h(g.class);
                                }
                                this.hJO.a(new com.tencent.mm.y.d.a(buVar, true, z2, bVar.hJT == 0), new com.tencent.mm.plugin.bbom.n(true));
                                if (z2 && r5 == 0 && size > 1 && bVar.hJT == 0) {
                                    ap.yY();
                                    y = com.tencent.mm.u.c.wT().y(bVar.hJP, (long) buVar.tfl);
                                    i5 = y.field_flag;
                                    j = y.field_createTime;
                                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", Integer.valueOf(size), Integer.valueOf(buVar.tfl), Integer.valueOf(i5), Long.valueOf(j));
                                    if ((i5 & 4) == 0) {
                                        ap.yY();
                                        y2 = com.tencent.mm.u.c.wT().y(bVar.hJP, (long) (buVar.tfl + 1));
                                        if (y2.field_msgId == 0 && y2.field_msgSeq == ((long) (buVar.tfl + 1))) {
                                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", Long.valueOf(y2.field_msgSeq), Long.valueOf(y2.field_createTime), Integer.valueOf(y2.field_flag));
                                            if ((y2.field_flag & 4) != 0) {
                                                y.dF(y.field_flag & -2);
                                                ap.yY();
                                                com.tencent.mm.u.c.wT().a(y.field_msgId, y);
                                                y2.dF(y2.field_flag & -2);
                                                ap.yY();
                                                com.tencent.mm.u.c.wT().a(y2.field_msgId, y2);
                                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                                                com.tencent.mm.plugin.report.c.oTb.a(403, 34, 1, false);
                                            }
                                        } else {
                                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", Boolean.valueOf(false), Long.valueOf(y2.field_msgId), Long.valueOf(y2.field_msgSeq));
                                        }
                                    }
                                }
                                bVar.hDU++;
                            } else {
                                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed curIdx == last[%d], MsgSeq[%d], flag[%d]", Integer.valueOf(i4), Long.valueOf(com.tencent.mm.u.c.wT().y(bVar.hJP, (long) buVar.tfl).field_msgSeq), Integer.valueOf(com.tencent.mm.u.c.wT().y(bVar.hJP, (long) buVar.tfl).field_flag));
                            }
                        }
                        z2 = false;
                        i5 = -1;
                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hJT), Integer.valueOf(buVar.tfl));
                        if (this.hJO == null) {
                            this.hJO = (g) h.h(g.class);
                        }
                        if (bVar.hJT == 0) {
                        }
                        this.hJO.a(new com.tencent.mm.y.d.a(buVar, true, z2, bVar.hJT == 0), new com.tencent.mm.plugin.bbom.n(true));
                        ap.yY();
                        y = com.tencent.mm.u.c.wT().y(bVar.hJP, (long) buVar.tfl);
                        i5 = y.field_flag;
                        j = y.field_createTime;
                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", Integer.valueOf(size), Integer.valueOf(buVar.tfl), Integer.valueOf(i5), Long.valueOf(j));
                        if ((i5 & 4) == 0) {
                            ap.yY();
                            y2 = com.tencent.mm.u.c.wT().y(bVar.hJP, (long) (buVar.tfl + 1));
                            if (y2.field_msgId == 0) {
                            }
                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", Boolean.valueOf(false), Long.valueOf(y2.field_msgId), Long.valueOf(y2.field_msgSeq));
                        }
                        bVar.hDU++;
                    }
                    i2++;
                }
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.hJN.hqI + " ret:" + z + " maxCnt:" + i + " take:" + (u.Nz() - Nz) + "ms");
                return z;
            }
            z = true;
            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.hJN.hqI + " ret:" + z + " maxCnt:" + i + " take:" + (u.Nz() - Nz) + "ms");
            return z;
        }
    }, true);
    public Map<String, LinkedList<a>> hJJ = new HashMap();
    LinkedBlockingQueue<a> hJK = new LinkedBlockingQueue();
    public c hJL;
    public Map<Long, ao> hJM = new HashMap();
    public boolean hqI = false;
    long hqT = 0;

    public static class a {
        final String hJP;
        final int hJQ;
        final int hJR;
        final int hJS;
        final int hJT;

        public a(String str, int i, int i2, int i3, int i4) {
            this.hJP = str;
            this.hJQ = i;
            this.hJR = i2;
            this.hJS = i3;
            this.hJT = i4;
        }

        public final String toString() {
            return "GetChatRoomMsgInfo hash[" + hashCode() + "], chatroomId[" + this.hJP + "], filterSeq[" + this.hJQ + "], msgSeq[" + this.hJR + "], needCount[" + this.hJS + "], upDownFlag[" + this.hJT + "]";
        }
    }

    class b {
        int hDU = 0;
        final /* synthetic */ b hJN;
        String hJP;
        int hJT = 0;
        LinkedList<bu> hJU = new LinkedList();
        boolean hJV = true;

        b(b bVar) {
            this.hJN = bVar;
        }
    }

    public interface c {
        String Hq();

        boolean Hr();

        void gd(int i);
    }

    b() {
    }

    public final void a(String str, l lVar) {
        if (!u.mA(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                com.tencent.mm.sdk.e.c aoVar = new ao();
                aoVar.field_originSvrId = longValue;
                if (ap.yY().xD().b(aoVar, new String[0])) {
                    this.hJM.put(Long.valueOf(longValue), aoVar);
                    w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(aoVar.uxb), Long.valueOf(longValue));
                    return;
                }
                this.hJM.remove(Long.valueOf(longValue));
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "summerbadcr onNotifyChange:", new Object[0]);
            }
        }
    }

    public final boolean a(a aVar, c cVar) {
        if (!b(aVar, cVar)) {
            return false;
        }
        this.hDL.v(0, 0);
        return true;
    }

    public final boolean a(a aVar) {
        if (aVar.hJR != 0) {
            return false;
        }
        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", aVar, u.NC());
        if (!this.hJK.add(aVar)) {
            return false;
        }
        this.hDL.v(0, 0);
        return true;
    }

    private boolean b(a aVar, c cVar) {
        if (aVar == null || cVar == null || u.mA(aVar.hJP) || !aVar.hJP.equals(cVar.Hq())) {
            return false;
        }
        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", aVar);
        synchronized (this.hJJ) {
            LinkedList linkedList = (LinkedList) this.hJJ.get(aVar.hJP);
            if (linkedList == null) {
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", Boolean.valueOf(linkedList.add(aVar)), Integer.valueOf(new LinkedList().hashCode()), this.hJJ);
                this.hJJ.put(aVar.hJP, linkedList);
            } else {
                linkedList.addLast(aVar);
                w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], needGetInfosMap[%s]", Boolean.valueOf(false), Integer.valueOf(linkedList.hashCode()), this.hJJ);
            }
            this.hJL = cVar;
        }
        return true;
    }

    public static void d(Map<Long, ao> map, String str) {
        if (map.size() != 0 && !u.mA(str)) {
            Iterator it = map.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ao aoVar = (ao) it.next();
                    if (aoVar != null && str.equals(aoVar.field_fromUserName)) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wT().x(str, aoVar.field_originSvrId).field_msgId != 0) {
                            w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(com.tencent.mm.u.c.wT().x(str, aoVar.field_originSvrId).field_msgId), Long.valueOf(com.tencent.mm.u.c.wT().x(str, aoVar.field_originSvrId).field_msgSvrId));
                            bu buVar = new bu();
                            buVar.tfk = aoVar.field_newMsgId;
                            buVar.tfd = n.mw(aoVar.field_fromUserName);
                            buVar.tfe = n.mw(aoVar.field_toUserName);
                            buVar.ogM = (int) aoVar.field_createTime;
                            buVar.tff = n.mw(aoVar.field_content);
                            buVar.tfi = aoVar.field_msgSource;
                            buVar.tfl = aoVar.field_msgSeq;
                            int i = aoVar.field_flag;
                            buVar.mtd = CdnLogic.MediaType_FAVORITE_VIDEO;
                            com.tencent.mm.plugin.report.c.oTb.a(403, 35, 1, false);
                            ap.getSysCmdMsgExtension().b(new com.tencent.mm.y.d.a(buVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                        }
                    }
                }
            }
        }
    }
}
