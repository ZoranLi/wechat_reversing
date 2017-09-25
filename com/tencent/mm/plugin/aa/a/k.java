package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.f;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.y.e;
import java.util.List;
import java.util.Map;

public final class k implements e {
    public static String inG = "title";
    public static String inH = "totalPayAmount";
    public static String inI = "totalUserNumber";
    public static String inJ = "perAmount";
    public static String inK = "chatRoomName";
    public static String inL = "launchScene";
    public static String inM = "payerlist";
    public static String inN = "timestamp";
    private static int inO = 131100026;
    private b hsf;
    private boolean inP = false;
    private Map<String, Object> inQ;
    private int mode = 0;

    public final boolean d(int i, Map<String, Object> map) {
        this.hsf = g.cbB();
        if (this.inP) {
            w.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.hsf.bJ(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.hsf.bJ(Boolean.valueOf(false));
            return false;
        } else {
            w.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[]{map.keySet()});
            this.inP = true;
            this.inQ = map;
            this.mode = i;
            String str;
            String str2;
            int i2;
            if (i == a.imK) {
                if (this.inQ.containsKey(inG) && this.inQ.containsKey(inJ) && this.inQ.containsKey(inI) && this.inQ.containsKey(inL) && this.inQ.containsKey(inK) && this.inQ.containsKey(inN)) {
                    try {
                        str = (String) this.inQ.get(inG);
                        long longValue = ((Long) this.inQ.get(inJ)).longValue();
                        int intValue = ((Integer) this.inQ.get(inI)).intValue();
                        int intValue2 = ((Integer) this.inQ.get(inL)).intValue();
                        str2 = (String) this.inQ.get(inK);
                        long longValue2 = ((Long) this.inQ.get(inN)).longValue();
                        w.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                        ap.vd().a(new f(longValue, str, intValue, intValue2, longValue2, str2), 0);
                        if (intValue > 0 && intValue <= 10) {
                            i2 = 13;
                        } else if (intValue > 10 && intValue <= 20) {
                            i2 = 14;
                        } else if (intValue <= 20 || intValue > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(407, (long) i2, 1, false);
                        this.hsf.cbA();
                        return true;
                    } catch (Exception e) {
                        w.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[]{e.getMessage()});
                        this.hsf.bJ(Boolean.valueOf(false));
                        this.inP = false;
                        return false;
                    }
                }
                this.hsf.bJ(Boolean.valueOf(false));
                this.inP = false;
                return false;
            } else if (i != a.imL) {
                return false;
            } else {
                if (this.inQ.containsKey(inG) && this.inQ.containsKey(inJ) && this.inQ.containsKey(inM) && this.inQ.containsKey(inL) && this.inQ.containsKey(inK) && this.inQ.containsKey(inN)) {
                    try {
                        str = (String) this.inQ.get(inG);
                        List list = (List) this.inQ.get(inM);
                        str2 = (String) this.inQ.get(inK);
                        ap.vd().a(new f(((Long) this.inQ.get(inJ)).longValue(), str, list, ((Integer) this.inQ.get(inL)).intValue(), ((Long) this.inQ.get(inN)).longValue(), str2), 0);
                        i2 = list.size();
                        if (i2 > 0 && i2 <= 10) {
                            i2 = 13;
                        } else if (i2 > 10 && i2 <= 20) {
                            i2 = 14;
                        } else if (i2 <= 20 || i2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(407, (long) i2, 1, false);
                        this.hsf.cbA();
                        return true;
                    } catch (Exception e2) {
                        w.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[]{e2.getMessage()});
                        this.hsf.bJ(Boolean.valueOf(false));
                        this.inP = false;
                        return false;
                    }
                }
                this.hsf.bJ(Boolean.valueOf(false));
                this.inP = false;
                return false;
            }
        }
    }

    public final boolean o(Map<String, Object> map) {
        this.hsf = g.cbB();
        w.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.inP) {
            w.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.hsf.bJ(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.hsf.bJ(Boolean.valueOf(false));
            return false;
        } else {
            this.inP = true;
            this.inQ = map;
            this.mode = a.imM;
            if (this.mode != a.imM) {
                this.hsf.bJ(Boolean.valueOf(false));
                return false;
            }
            if (this.inQ.containsKey(inG) && this.inQ.containsKey(inH) && this.inQ.containsKey(inM) && this.inQ.containsKey(inL) && this.inQ.containsKey(inK) && this.inQ.containsKey(inN)) {
                try {
                    List list = (List) this.inQ.get(inM);
                    ap.vd().a(new com.tencent.mm.plugin.aa.a.a.g((String) this.inQ.get(inG), ((Long) this.inQ.get(inH)).longValue(), list, ((Integer) this.inQ.get(inL)).intValue(), (String) this.inQ.get(inK), ((Long) this.inQ.get(inN)).longValue()), 0);
                    int size = list.size();
                    size = (size <= 0 || size > 10) ? (size <= 10 || size > 20) ? (size <= 20 || size > 50) ? 20 : 19 : 18 : 17;
                    com.tencent.mm.plugin.report.service.g.oUh.a(407, (long) size, 1, false);
                    this.hsf.cbA();
                    return true;
                } catch (Exception e) {
                    w.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
                }
            }
            this.hsf.bJ(Boolean.valueOf(false));
            this.inP = false;
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kVar, Integer.valueOf(this.mode)});
        String str2;
        String str3;
        Object[] objArr;
        y yVar;
        if (kVar.getType() == 1624) {
            this.inP = false;
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                com.tencent.mm.protocal.c.g gVar = fVar.inZ;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.kAC);
                objArr[1] = gVar.kAD;
                objArr[2] = Boolean.valueOf(gVar.tbj == null);
                objArr[3] = gVar.tbh;
                w.i(str2, str3, objArr);
                if (gVar.kAC == 0) {
                    if (gVar.tbj != null) {
                        h.q(gVar.tbh, fVar.chatroomName, gVar.tbj);
                        g.a(this.hsf, new Object[]{Boolean.valueOf(true)});
                    } else {
                        h.a(gVar.tbh, false, 0);
                        g.a(this.hsf, new Object[]{Boolean.valueOf(true)});
                    }
                    h.mH(fVar.chatroomName);
                    com.tencent.mm.plugin.report.service.g.oUh.a(407, 0, 1, false);
                    return;
                }
                if (this.hsf != null) {
                    if (gVar.kAC > 0) {
                        yVar = gVar.tbp;
                        if (yVar != null && yVar.tca > 0) {
                            this.hsf.bJ(yVar);
                        } else if (bg.mA(gVar.kAD)) {
                            this.hsf.bJ(Boolean.valueOf(false));
                        } else {
                            this.hsf.bJ(gVar.kAD);
                        }
                    } else {
                        this.hsf.bJ(Boolean.valueOf(false));
                    }
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 2, 1, false);
                return;
            }
            if (this.hsf != null) {
                this.hsf.bJ(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(407, 1, 1, false);
        } else if (kVar.getType() == 1655) {
            this.inP = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.g gVar2 = (com.tencent.mm.plugin.aa.a.a.g) kVar;
                i iVar = gVar2.iob;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(iVar.kAC);
                objArr[1] = iVar.kAD;
                objArr[2] = Boolean.valueOf(iVar.tbj == null);
                w.i(str2, str3, objArr);
                w.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[]{iVar.kAD, iVar.tbh});
                if (iVar.kAC == 0) {
                    if (iVar.tbj != null) {
                        h.q(iVar.tbh, gVar2.chatroomName, iVar.tbj);
                        g.a(this.hsf, new Object[]{Boolean.valueOf(true), iVar.tbh});
                    } else {
                        h.a(iVar.tbh, false, 0);
                        g.a(this.hsf, new Object[]{Boolean.valueOf(true), iVar.tbh});
                    }
                    h.mH(gVar2.chatroomName);
                    com.tencent.mm.plugin.report.service.g.oUh.a(407, 3, 1, false);
                    return;
                }
                if (iVar.kAC > 0) {
                    yVar = iVar.tbp;
                    if (yVar != null && yVar.tca > 0) {
                        this.hsf.bJ(yVar);
                    } else if (bg.mA(iVar.kAD)) {
                        this.hsf.bJ(Boolean.valueOf(false));
                    } else {
                        this.hsf.bJ(iVar.kAD);
                    }
                } else {
                    this.hsf.bJ(Boolean.valueOf(false));
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 5, 1, false);
                return;
            }
            if (this.hsf != null) {
                this.hsf.bJ(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(407, 4, 1, false);
        }
    }
}
