package com.tencent.mm.f;

import android.content.Intent;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.qu;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a gMB;
    public Map<Integer, Long> gMC = new HashMap();
    public Map<Long, a> gMD = new HashMap();
    public c gME = new c<ah>(this) {
        final /* synthetic */ b gMF;

        {
            this.gMF = r2;
            this.usg = ah.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ah ahVar = (ah) bVar;
            com.tencent.mm.e.a.ah.a aVar = ahVar.fDx;
            b bVar2;
            long j;
            a aVar2;
            qu quVar;
            switch (aVar.type) {
                case 1:
                    bVar2 = this.gMF;
                    String str = aVar.fDz;
                    j = bg.getLong(str, 0);
                    int i = aVar.position;
                    w.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", str, Integer.valueOf(i), bVar2.gMB, Integer.valueOf(bVar2.gMD.size()));
                    if (bVar2.gMD.size() > 0 && j > 0) {
                        aVar2 = (a) bVar2.gMD.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            w.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", aVar2);
                            if (i <= 0) {
                                Collection values = aVar2.gML.values();
                                if (values != null) {
                                    Iterator it = values.iterator();
                                    if (it != null) {
                                        while (it.hasNext()) {
                                            quVar = (qu) it.next();
                                            if (quVar != null && quVar.fXP.visible) {
                                                w.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Long.valueOf(j), Boolean.valueOf(quVar.fXP.visible));
                                                quVar.fXP.visible = false;
                                                com.tencent.mm.sdk.b.a.urY.m(quVar);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            quVar = (qu) aVar2.gML.get(Integer.valueOf(i));
                            if (quVar != null) {
                                w.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Integer.valueOf(i), Boolean.valueOf(quVar.fXP.visible));
                                if (quVar.fXP.visible) {
                                    quVar.fXP.visible = false;
                                    com.tencent.mm.sdk.b.a.urY.m(quVar);
                                    g.oUh.i(13939, Integer.valueOf(2));
                                    break;
                                }
                            }
                            w.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", Integer.valueOf(i));
                        } else {
                            w.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                        }
                    }
                    if (bVar2.gMB != null) {
                        if (!bg.mA(str) && !str.equals(bVar2.gMB.gMI)) {
                            w.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", bVar2.gMB.gMI, str);
                            break;
                        }
                        quVar = (qu) bVar2.gMB.gML.get(Integer.valueOf(0));
                        if (quVar != null && quVar.fXP.visible) {
                            g.oUh.i(13939, Integer.valueOf(2));
                            quVar.fXP.visible = false;
                            com.tencent.mm.sdk.b.a.urY.m(quVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    bVar2 = this.gMF;
                    int i2 = ahVar.fDx.position;
                    w.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", Integer.valueOf(i2), bVar2.gMB, Integer.valueOf(bVar2.gMC.size()));
                    if (i2 <= 0 || bVar2.gMC.size() <= 0) {
                        if (bVar2.gMB != null) {
                            quVar = (qu) bVar2.gMB.gML.get(Integer.valueOf(0));
                            if (quVar != null) {
                                ahVar.fDy.desc = quVar.fXP.desc;
                                ahVar.fDy.fDA = quVar.fXP.fDA;
                                ahVar.fDy.showType = quVar.fXP.showType;
                                ahVar.fDy.url = quVar.fXP.url;
                                ahVar.fDy.visible = quVar.fXP.visible;
                                ahVar.fDy.fDD = quVar.fXP.fDD;
                                ahVar.fDy.fDB = quVar.fXP.fDB;
                                ahVar.fDy.fDC = quVar.fXP.fDC;
                                ahVar.fDy.fDE = quVar.fXP.fDE;
                                ahVar.fDy.position = quVar.fXP.position;
                                if (quVar.fXP.visible) {
                                    g.oUh.i(13936, Integer.valueOf(i2));
                                }
                                bVar2.qA();
                                break;
                            }
                        }
                    }
                    j = bg.a((Long) bVar2.gMC.get(Integer.valueOf(i2)), 0);
                    w.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", Integer.valueOf(i2), Long.valueOf(j));
                    if (j > 0) {
                        aVar2 = (a) bVar2.gMD.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            quVar = (qu) aVar2.gML.get(Integer.valueOf(i2));
                            if (quVar != null) {
                                ahVar.fDy.desc = quVar.fXP.desc;
                                ahVar.fDy.fDA = quVar.fXP.fDA;
                                ahVar.fDy.showType = quVar.fXP.showType;
                                ahVar.fDy.url = quVar.fXP.url;
                                ahVar.fDy.visible = quVar.fXP.visible;
                                ahVar.fDy.fDD = quVar.fXP.fDD;
                                ahVar.fDy.fDB = quVar.fXP.fDB;
                                ahVar.fDy.fDC = quVar.fXP.fDC;
                                ahVar.fDy.fDE = quVar.fXP.fDE;
                                ahVar.fDy.position = quVar.fXP.position;
                                if (quVar.fXP.visible) {
                                    g.oUh.i(13936, Integer.valueOf(i2));
                                    break;
                                }
                            }
                        }
                        bVar2.gMC.remove(Integer.valueOf(i2));
                        break;
                    }
                    break;
                case 4:
                    this.gMF.do(aVar.fDz);
                    break;
                case 5:
                    this.gMF.a(ahVar);
                    break;
            }
            return false;
        }
    };

    static class a {
        String gMI = null;
        long gMJ = 0;
        String gMK = null;
        Map<Integer, qu> gML = new HashMap();

        a() {
        }

        public final String toString() {
            String str = "";
            for (Integer num : this.gML.keySet()) {
                str = str + num + ",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            return String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[]{Integer.valueOf(hashCode()), this.gMI, Long.valueOf(this.gMJ), this.gMK, str});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.e.a.ah r20) {
        /*
        r19 = this;
        r0 = r20;
        r2 = r0.fDx;
        r3 = r2.fDz;
        r4 = "MicroMsg.BroadcastController";
        r5 = "summerdiz handleNewDisaster xml len[%d]";
        r2 = 1;
        r6 = new java.lang.Object[r2];
        r7 = 0;
        if (r3 != 0) goto L_0x0030;
    L_0x0012:
        r2 = -1;
    L_0x0013:
        r2 = java.lang.Integer.valueOf(r2);
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r2 = "e";
        r14 = com.tencent.mm.sdk.platformtools.bh.q(r3, r2);
        if (r14 != 0) goto L_0x0035;
    L_0x0025:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster this is not errmsg";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        r2 = 0;
    L_0x002f:
        return r2;
    L_0x0030:
        r2 = r3.length();
        goto L_0x0013;
    L_0x0035:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster values[%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r14;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = ".e.NoticeId";
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        r4 = 0;
        r16 = com.tencent.mm.sdk.platformtools.bg.getLong(r2, r4);
        r2 = 0;
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0062;
    L_0x0059:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster noticeID null";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
    L_0x0062:
        r2 = com.tencent.mm.platformtools.r.ijW;
        if (r2 != 0) goto L_0x00a4;
    L_0x0066:
        r2 = ".e.ExpiredTime";
        r2 = r14.get(r2);	 Catch:{ Exception -> 0x0094 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0094 }
        r4 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bg.getLong(r2, r4);	 Catch:{ Exception -> 0x0094 }
        r4 = com.tencent.mm.sdk.platformtools.bg.az(r2);	 Catch:{ Exception -> 0x0094 }
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x00a4;
    L_0x007f:
        r4 = "MicroMsg.BroadcastController";
        r5 = "summerdiz handleNewDisaster expiredTime is too small, drop id:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0094 }
        r7 = 0;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0094 }
        r6[r7] = r2;	 Catch:{ Exception -> 0x0094 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);	 Catch:{ Exception -> 0x0094 }
        r2 = 0;
        goto L_0x002f;
    L_0x0094:
        r2 = move-exception;
        r3 = "MicroMsg.BroadcastController";
        r4 = "parseLong expiredTime error:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
    L_0x00a4:
        r3 = new com.tencent.mm.f.b$a;
        r3.<init>();
        r2 = java.lang.String.valueOf(r16);
        r3.gMI = r2;
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r4 = "disaster_pref";
        r5 = 4;
        r2 = r2.getSharedPreferences(r4, r5);
        r4 = "disaster_noticeid_list_key";
        r5 = "";
        r2 = r2.getString(r4, r5);
        r4 = com.tencent.mm.platformtools.r.ijX;
        if (r4 != 0) goto L_0x00e8;
    L_0x00c9:
        r4 = r3.gMI;
        r4 = r2.contains(r4);
        if (r4 == 0) goto L_0x00e8;
    L_0x00d1:
        r4 = "MicroMsg.BroadcastController";
        r5 = "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r2;
        r2 = 1;
        r3 = r3.gMI;
        r6[r2] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r2 = 0;
        goto L_0x002f;
    L_0x00e8:
        r0 = r19;
        r2 = r0.gMD;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x013a;
    L_0x00f2:
        r0 = r19;
        r2 = r0.gMD;
        r4 = java.lang.Long.valueOf(r16);
        r2 = r2.get(r4);
        r2 = (com.tencent.mm.f.b.a) r2;
        if (r2 == 0) goto L_0x012d;
    L_0x0102:
        r3 = "MicroMsg.BroadcastController";
        r4 = "summerdiz  handleNewDisaster found info in map[%s]";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        r5 = r2;
    L_0x0112:
        r2 = ".e.Position";
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r3 == 0) goto L_0x0147;
    L_0x0121:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster positionStr is null!";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        r2 = 0;
        goto L_0x002f;
    L_0x012d:
        r0 = r19;
        r2 = r0.gMD;
        r4 = java.lang.Long.valueOf(r16);
        r2.put(r4, r3);
        r5 = r3;
        goto L_0x0112;
    L_0x013a:
        r0 = r19;
        r2 = r0.gMD;
        r4 = java.lang.Long.valueOf(r16);
        r2.put(r4, r3);
        r5 = r3;
        goto L_0x0112;
    L_0x0147:
        r15 = new java.util.ArrayList;
        r15.<init>();
        r3 = ",";
        r4 = r2.split(r3);
        if (r4 == 0) goto L_0x0158;
    L_0x0155:
        r2 = r4.length;
        if (r2 > 0) goto L_0x0164;
    L_0x0158:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster positionStr id invaild!";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        r2 = 0;
        goto L_0x002f;
    L_0x0164:
        r6 = 0;
        r7 = r4.length;
        r2 = 0;
        r3 = r2;
    L_0x0168:
        if (r3 >= r7) goto L_0x0197;
    L_0x016a:
        r2 = r4[r3];
        r8 = 0;
        r8 = com.tencent.mm.sdk.platformtools.bg.getInt(r2, r8);
        if (r8 <= 0) goto L_0x0195;
    L_0x0173:
        r2 = 1;
        if (r8 != r2) goto L_0x018e;
    L_0x0176:
        r2 = 1;
        r6 = "MicroMsg.BroadcastController";
        r9 = "summerdiz handleNewDisaster found tonyTips[%d]";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r8 = java.lang.Integer.valueOf(r8);
        r10[r11] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r6, r9, r10);
    L_0x018a:
        r3 = r3 + 1;
        r6 = r2;
        goto L_0x0168;
    L_0x018e:
        r2 = java.lang.Integer.valueOf(r8);
        r15.add(r2);
    L_0x0195:
        r2 = r6;
        goto L_0x018a;
    L_0x0197:
        if (r6 != 0) goto L_0x01ab;
    L_0x0199:
        r2 = r15.size();
        if (r2 != 0) goto L_0x01ab;
    L_0x019f:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster positions size is 0!";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        r2 = 0;
        goto L_0x002f;
    L_0x01ab:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r18 = com.tencent.mm.sdk.platformtools.v.ea(r2);
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster curLang[%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r4[r7] = r18;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = 0;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r9 = 0;
        r8 = 0;
        r7 = 0;
        r10 = r2;
    L_0x01ca:
        r3 = new java.lang.StringBuilder;
        r2 = ".e.Item";
        r3.<init>(r2);
        if (r10 != 0) goto L_0x0303;
    L_0x01d4:
        r2 = "";
    L_0x01d7:
        r2 = r3.append(r2);
        r4 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r4);
        r3 = ".Language";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        if (r2 != 0) goto L_0x01fe;
    L_0x01fb:
        r3 = 3;
        if (r10 > r3) goto L_0x04cd;
    L_0x01fe:
        r0 = r18;
        r3 = r0.equalsIgnoreCase(r2);
        if (r3 == 0) goto L_0x0309;
    L_0x0206:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r4);
        r3 = ".Content";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r4);
        r10 = ".Url";
        r3 = r3.append(r10);
        r3 = r3.toString();
        r3 = r14.get(r3);
        r3 = (java.lang.String) r3;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = r10.append(r4);
        r10 = ".Tips";
        r4 = r4.append(r10);
        r4 = r4.toString();
        r4 = r14.get(r4);
        r4 = (java.lang.String) r4;
    L_0x0254:
        r10 = "MicroMsg.BroadcastController";
        r11 = "summerdiz handleNewDisaster content[%s] tips[%s]";
        r12 = 2;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r12[r13] = r2;
        r13 = 1;
        r12[r13] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r10, r11, r12);
        r10 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r10 == 0) goto L_0x04c3;
    L_0x026c:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster cann't hit curLang";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
    L_0x0275:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r2 == 0) goto L_0x0285;
    L_0x027b:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = com.tencent.mm.R.l.ebG;
        r8 = r2.getString(r3);
    L_0x0285:
        if (r6 == 0) goto L_0x02f1;
    L_0x0287:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r9);
        if (r2 == 0) goto L_0x0297;
    L_0x028d:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = com.tencent.mm.R.l.ebB;
        r9 = r2.getString(r3);
    L_0x0297:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r2 == 0) goto L_0x02a7;
    L_0x029d:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = com.tencent.mm.R.l.ebE;
        r7 = r2.getString(r3);
    L_0x02a7:
        r0 = r20;
        r2 = r0.fDy;
        r2.desc = r9;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 30;
        r2.fDA = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 0;
        r2.showType = r3;
        r0 = r20;
        r2 = r0.fDy;
        r2.url = r8;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 1;
        r2.visible = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 0;
        r2.fDD = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 6;
        r2.fDB = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = "";
        r2.fDC = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = java.lang.String.valueOf(r16);
        r2.fDE = r3;
        r0 = r20;
        r2 = r0.fDy;
        r3 = 1;
        r2.position = r3;
    L_0x02f1:
        r2 = r15.size();
        if (r2 != 0) goto L_0x0368;
    L_0x02f7:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster no other position need to tip";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
        r2 = 0;
        goto L_0x002f;
    L_0x0303:
        r2 = java.lang.Integer.valueOf(r10);
        goto L_0x01d7;
    L_0x0309:
        r3 = "en";
        r2 = r3.equalsIgnoreCase(r2);
        if (r2 == 0) goto L_0x04c8;
    L_0x0312:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r4);
        r3 = ".Content";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r2 = r14.get(r2);
        r2 = (java.lang.String) r2;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r4);
        r7 = ".Url";
        r3 = r3.append(r7);
        r3 = r3.toString();
        r3 = r14.get(r3);
        r3 = (java.lang.String) r3;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r4 = r7.append(r4);
        r7 = ".Tips";
        r4 = r4.append(r7);
        r4 = r4.toString();
        r4 = r14.get(r4);
        r4 = (java.lang.String) r4;
    L_0x0360:
        r7 = r10 + 1;
        r8 = r3;
        r9 = r2;
        r10 = r7;
        r7 = r4;
        goto L_0x01ca;
    L_0x0368:
        r2 = r5.gMJ;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x0389;
    L_0x0370:
        r2 = r5.gMJ;
        r2 = com.tencent.mm.sdk.platformtools.bg.aB(r2);
        r10 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x0389;
    L_0x037d:
        r2 = "MicroMsg.BroadcastController";
        r3 = "summerdiz handleNewDisaster disasterTick within half an hour, drop it";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
        r2 = 0;
        goto L_0x002f;
    L_0x0389:
        r2 = com.tencent.mm.sdk.platformtools.bg.NA();
        r5.gMJ = r2;
        r10 = r15.iterator();
    L_0x0393:
        r2 = r10.hasNext();
        if (r2 == 0) goto L_0x04ba;
    L_0x0399:
        r2 = r10.next();
        r2 = (java.lang.Integer) r2;
        r0 = r19;
        r3 = r0.gMC;
        r3 = r3.get(r2);
        r3 = (java.lang.Long) r3;
        r12 = 0;
        r12 = com.tencent.mm.sdk.platformtools.bg.a(r3, r12);
        r3 = java.lang.Long.valueOf(r12);
        r12 = r3.longValue();
        r14 = 0;
        r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r4 <= 0) goto L_0x03df;
    L_0x03bd:
        r12 = r3.longValue();
        r4 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1));
        if (r4 < 0) goto L_0x03df;
    L_0x03c5:
        r4 = "MicroMsg.BroadcastController";
        r11 = "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]";
        r12 = 3;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r12[r13] = r2;
        r2 = 1;
        r12[r2] = r3;
        r2 = 2;
        r3 = java.lang.Long.valueOf(r16);
        r12[r2] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r4, r11, r12);
        goto L_0x0393;
    L_0x03df:
        r3 = r5.gML;
        r3 = r3.get(r2);
        r3 = (com.tencent.mm.e.a.qu) r3;
        if (r3 != 0) goto L_0x04c0;
    L_0x03e9:
        r3 = new com.tencent.mm.e.a.qu;
        r3.<init>();
        r4 = r3.fXP;
        r11 = 0;
        r4.showType = r11;
        r4 = r3.fXP;
        r11 = 30;
        r4.fDA = r11;
        r4 = r3.fXP;
        r11 = "";
        r4.fDC = r11;
        r4 = r3.fXP;
        r11 = com.tencent.mm.R.i.dju;
        r4.fDD = r11;
        r4 = r3.fXP;
        r11 = r2.intValue();
        r4.position = r11;
        r4 = r5.gML;
        r4.put(r2, r3);
        r4 = r3;
    L_0x0414:
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r3 == 0) goto L_0x04bd;
    L_0x041a:
        r3 = r9;
    L_0x041b:
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r7 == 0) goto L_0x0432;
    L_0x0421:
        r3 = com.tencent.mm.R.l.ebD;
        r7 = r2.intValue();
        switch(r7) {
            case 2: goto L_0x04b2;
            case 3: goto L_0x04b6;
            case 4: goto L_0x04b6;
            default: goto L_0x042a;
        };
    L_0x042a:
        r7 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = r7.getString(r3);
    L_0x0432:
        r7 = r4.fXP;
        r7.desc = r3;
        r7 = r4.fXP;
        r7.url = r8;
        r7 = r4.fXP;
        r11 = 1;
        r7.visible = r11;
        r7 = r4.fXP;
        r11 = 2;
        r7.fDB = r11;
        r7 = r4.fXP;
        r11 = r5.gMI;
        r7.fDE = r11;
        r0 = r19;
        r7 = r0.gMC;
        r11 = java.lang.Long.valueOf(r16);
        r7.put(r2, r11);
        if (r6 != 0) goto L_0x04a5;
    L_0x0457:
        r0 = r20;
        r7 = r0.fDy;
        r7.desc = r3;
        r0 = r20;
        r7 = r0.fDy;
        r11 = 30;
        r7.fDA = r11;
        r0 = r20;
        r7 = r0.fDy;
        r11 = 0;
        r7.showType = r11;
        r0 = r20;
        r7 = r0.fDy;
        r7.url = r8;
        r0 = r20;
        r7 = r0.fDy;
        r11 = 1;
        r7.visible = r11;
        r0 = r20;
        r7 = r0.fDy;
        r11 = com.tencent.mm.R.i.dju;
        r7.fDD = r11;
        r0 = r20;
        r7 = r0.fDy;
        r11 = 2;
        r7.fDB = r11;
        r0 = r20;
        r7 = r0.fDy;
        r11 = "";
        r7.fDC = r11;
        r0 = r20;
        r7 = r0.fDy;
        r11 = java.lang.String.valueOf(r16);
        r7.fDE = r11;
        r0 = r20;
        r7 = r0.fDy;
        r2 = r2.intValue();
        r7.position = r2;
    L_0x04a5:
        r2 = new com.tencent.mm.f.b$2;
        r0 = r19;
        r2.<init>(r0, r4);
        com.tencent.mm.sdk.platformtools.af.v(r2);
        r7 = r3;
        goto L_0x0393;
    L_0x04b2:
        r3 = com.tencent.mm.R.l.ebF;
        goto L_0x042a;
    L_0x04b6:
        r3 = com.tencent.mm.R.l.ebC;
        goto L_0x042a;
    L_0x04ba:
        r2 = 1;
        goto L_0x002f;
    L_0x04bd:
        r3 = r7;
        goto L_0x041b;
    L_0x04c0:
        r4 = r3;
        goto L_0x0414;
    L_0x04c3:
        r8 = r3;
        r9 = r2;
        r7 = r4;
        goto L_0x0275;
    L_0x04c8:
        r4 = r7;
        r3 = r8;
        r2 = r9;
        goto L_0x0360;
    L_0x04cd:
        r3 = r11;
        r2 = r12;
        r4 = r13;
        goto L_0x0254;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.f.b.a(com.tencent.mm.e.a.ah):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean do(java.lang.String r14) {
        /*
        r13 = this;
        r4 = 0;
        r12 = 2;
        r6 = 0;
        r9 = 1;
        r8 = 0;
        r0 = "MicroMsg.BroadcastController";
        r1 = "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]";
        r2 = new java.lang.Object[r12];
        r3 = r13.gMB;
        r2[r8] = r3;
        r2[r9] = r14;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r14);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        return r8;
    L_0x001e:
        r0 = "<";
        r0 = r14.indexOf(r0);
        if (r0 < 0) goto L_0x001d;
    L_0x0027:
        r0 = "e";
        r10 = com.tencent.mm.sdk.platformtools.bh.q(r14, r0);
        if (r10 != 0) goto L_0x003a;
    L_0x0030:
        r0 = "MicroMsg.BroadcastController";
        r1 = "this is not errmsg";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x001d;
    L_0x003a:
        r0 = r13.gMB;
        if (r0 != 0) goto L_0x008d;
    L_0x003e:
        r0 = new com.tencent.mm.f.b$a;
        r0.<init>();
        r13.gMB = r0;
        r0 = new com.tencent.mm.e.a.qu;
        r0.<init>();
        r1 = r13.gMB;
        r1 = r1.gML;
        r2 = java.lang.Integer.valueOf(r8);
        r1.put(r2, r0);
        r1 = r0.fXP;
        r2 = "";
        r1.desc = r2;
        r1 = r0.fXP;
        r2 = "";
        r1.url = r2;
        r1 = r0.fXP;
        r1.showType = r8;
        r1 = r0.fXP;
        r2 = 30;
        r1.fDA = r2;
        r1 = r0.fXP;
        r1.visible = r8;
        r1 = r0.fXP;
        r2 = "";
        r1.fDC = r2;
        r1 = r0.fXP;
        r1.fDB = r8;
        r1 = r0.fXP;
        r2 = com.tencent.mm.R.i.dju;
        r1.fDD = r2;
        r1 = r0.fXP;
        r2 = "";
        r1.fDE = r2;
        r0 = r0.fXP;
        r0.position = r8;
    L_0x008d:
        r0 = com.tencent.mm.platformtools.r.ijV;
        if (r0 != 0) goto L_0x00bb;
    L_0x0091:
        r0 = r13.gMB;
        r0 = r0.gMJ;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b3;
    L_0x0099:
        r0 = r13.gMB;
        r0 = r0.gMJ;
        r0 = com.tencent.mm.sdk.platformtools.bg.aB(r0);
        r2 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x00b3;
    L_0x00a8:
        r0 = "MicroMsg.BroadcastController";
        r1 = "disasterTick within half an hour, drop it";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x001d;
    L_0x00b3:
        r0 = r13.gMB;
        r2 = com.tencent.mm.sdk.platformtools.bg.NA();
        r0.gMJ = r2;
    L_0x00bb:
        r0 = com.tencent.mm.platformtools.r.ijW;
        if (r0 != 0) goto L_0x00f9;
    L_0x00bf:
        r0 = ".e.ExpiredTime";
        r0 = r10.get(r0);	 Catch:{ Exception -> 0x00eb }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00eb }
        r2 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.getLong(r0, r2);	 Catch:{ Exception -> 0x00eb }
        r2 = com.tencent.mm.sdk.platformtools.bg.az(r0);	 Catch:{ Exception -> 0x00eb }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x00f9;
    L_0x00d6:
        r2 = "MicroMsg.BroadcastController";
        r3 = "expiredTime is too small, drop id:%d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00eb }
        r5 = 0;
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x00eb }
        r4[r5] = r0;	 Catch:{ Exception -> 0x00eb }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ Exception -> 0x00eb }
        goto L_0x001d;
    L_0x00eb:
        r0 = move-exception;
        r1 = "MicroMsg.BroadcastController";
        r2 = "parseLong expiredTime error:%s";
        r3 = new java.lang.Object[r9];
        r3[r8] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
    L_0x00f9:
        r1 = r13.gMB;
        r0 = ".e.NoticeId";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1.gMI = r0;
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = "disaster_pref";
        r2 = 4;
        r0 = r0.getSharedPreferences(r1, r2);
        r1 = "disaster_noticeid_list_key";
        r2 = "";
        r0 = r0.getString(r1, r2);
        r1 = com.tencent.mm.platformtools.r.ijX;
        if (r1 != 0) goto L_0x013f;
    L_0x0120:
        r1 = r13.gMB;
        r1 = r1.gMI;
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x013f;
    L_0x012a:
        r1 = "MicroMsg.BroadcastController";
        r2 = "noticeIdList %s contain notifyID:%s, drop id";
        r3 = new java.lang.Object[r12];
        r3[r8] = r0;
        r0 = r13.gMB;
        r0 = r0.gMI;
        r3[r9] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x001d;
    L_0x013f:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r11 = com.tencent.mm.sdk.platformtools.v.ea(r0);
        r3 = r6;
        r4 = r6;
        r5 = r6;
        r7 = r8;
    L_0x014b:
        r1 = new java.lang.StringBuilder;
        r0 = ".e.Item";
        r1.<init>(r0);
        if (r7 != 0) goto L_0x0262;
    L_0x0155:
        r0 = "";
    L_0x0158:
        r0 = r1.append(r0);
        r2 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r2);
        r1 = ".Language";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        if (r0 != 0) goto L_0x017f;
    L_0x017c:
        r1 = 3;
        if (r7 > r1) goto L_0x02d3;
    L_0x017f:
        r1 = r11.equalsIgnoreCase(r0);
        if (r1 == 0) goto L_0x0268;
    L_0x0185:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r2);
        r1 = ".Content";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r6 = ".Url";
        r1 = r1.append(r6);
        r1 = r1.toString();
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = r6.append(r2);
        r6 = ".Tips";
        r2 = r2.append(r6);
        r2 = r2.toString();
        r2 = r10.get(r2);
        r2 = (java.lang.String) r2;
        r6 = r1;
    L_0x01d4:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x02ca;
    L_0x01da:
        r0 = "MicroMsg.BroadcastController";
        r1 = "handleEventOOB cann't hit curLang";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
    L_0x01e3:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r0 == 0) goto L_0x01f3;
    L_0x01e9:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.ebG;
        r4 = r0.getString(r1);
    L_0x01f3:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r0 == 0) goto L_0x020c;
    L_0x01f9:
        r0 = "MicroMsg.BroadcastController";
        r1 = "handleEventOOB defContent is also null use hardcode";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.ebA;
        r5 = r0.getString(r1);
    L_0x020c:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 == 0) goto L_0x0222;
    L_0x0212:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r0 == 0) goto L_0x02c7;
    L_0x0218:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.ebD;
        r3 = r0.getString(r1);
    L_0x0222:
        r0 = r13.gMB;
        r0 = r0.gML;
        r1 = java.lang.Integer.valueOf(r8);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.e.a.qu) r0;
        r1 = r0.fXP;
        r1.desc = r3;
        r1 = r0.fXP;
        r1.url = r4;
        r1 = r0.fXP;
        r1.visible = r9;
        r1 = r0.fXP;
        r1.fDB = r12;
        r1 = r0.fXP;
        r2 = r13.gMB;
        r2 = r2.gMI;
        r1.fDE = r2;
        r1 = new com.tencent.mm.f.b$3;
        r1.<init>(r13, r0);
        com.tencent.mm.sdk.platformtools.af.v(r1);
        r0 = r13.gMB;
        r0.gMK = r5;
        r0 = com.tencent.mm.u.ap.vd();
        r0 = r0.foreground;
        if (r0 == 0) goto L_0x025f;
    L_0x025c:
        r13.qA();
    L_0x025f:
        r8 = r9;
        goto L_0x001d;
    L_0x0262:
        r0 = java.lang.Integer.valueOf(r7);
        goto L_0x0158;
    L_0x0268:
        r1 = "en";
        r0 = r1.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x02cf;
    L_0x0271:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r2);
        r1 = ".Content";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r3 = ".Url";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = ".Tips";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r2 = r10.get(r2);
        r2 = (java.lang.String) r2;
    L_0x02bf:
        r3 = r7 + 1;
        r4 = r1;
        r5 = r0;
        r7 = r3;
        r3 = r2;
        goto L_0x014b;
    L_0x02c7:
        r3 = r5;
        goto L_0x0222;
    L_0x02ca:
        r4 = r6;
        r5 = r0;
        r3 = r2;
        goto L_0x01e3;
    L_0x02cf:
        r2 = r3;
        r1 = r4;
        r0 = r5;
        goto L_0x02bf;
    L_0x02d3:
        r0 = r6;
        r2 = r6;
        goto L_0x01d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.f.b.do(java.lang.String):boolean");
    }

    final void qA() {
        if (this.gMB != null && this.gMB.gML.get(Integer.valueOf(0)) != null && !bg.mA(this.gMB.gMK)) {
            w.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", this.gMB.gMK);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", this.gMB.gMK);
            intent.putExtra("key_disaster_url", ((qu) this.gMB.gML.get(Integer.valueOf(0))).fXP.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            this.gMB.gMK = null;
        }
    }
}
