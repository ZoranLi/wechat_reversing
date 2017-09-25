package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b {
    public static HashMap<String, Integer> hOH;

    public static class a {
        public int hOI;
        public int hOJ;
        public int hOK;
        public int hOL;
        public int hOM;
        public int hON;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.hOI > 0) {
                stringBuffer.append("totalCount:" + this.hOI + " ");
            }
            if (this.hOJ > 0) {
                stringBuffer.append("enterRecoveryCount:" + this.hOJ + " ");
            }
            if (this.hOK > 0) {
                stringBuffer.append("existRecoveryProcessCount:" + this.hOK + " ");
            }
            if (this.hOL > 0) {
                stringBuffer.append("foregroundExpCount:" + this.hOL + " ");
            }
            if (this.hOM > 0) {
                stringBuffer.append("backgroundExpCount:" + this.hOM + " ");
            }
            if (this.hON > 0) {
                stringBuffer.append("normalCount:" + this.hON + " ");
            }
            return stringBuffer.toString();
        }
    }

    public static class b {
        public int hOO;
        public int hOP;
        public int hOQ;
        public int hOR;
        public int hOS;
        public int hOT;
        public int hOU;
        public int hOV;
        public int hOW;
        public int hOX;
        public int hOY;
        public int hOZ;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.hOO > 0) {
                stringBuffer.append("appForegroundExpCount:" + this.hOO + " ");
            }
            if (this.hOP > 0) {
                stringBuffer.append("appBackgroundExpCount:" + this.hOP + " ");
            }
            if (this.hOQ > 0) {
                stringBuffer.append("componentForegroundExpCount:" + this.hOQ + " ");
            }
            if (this.hOR > 0) {
                stringBuffer.append("componentBackgroundExpCount:" + this.hOR + " ");
            }
            if (this.hOS > 0) {
                stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.hOS + " ");
            }
            if (this.hOT > 0) {
                stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.hOT + " ");
            }
            if (this.hOU > 0) {
                stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.hOU + " ");
            }
            if (this.hOV > 0) {
                stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.hOV + " ");
            }
            if (this.hOW > 0) {
                stringBuffer.append("appForegroundTimeoutExpCount:" + this.hOW + " ");
            }
            if (this.hOX > 0) {
                stringBuffer.append("appBackgroundTimeoutExpCount:" + this.hOX + " ");
            }
            if (this.hOY > 0) {
                stringBuffer.append("componentForegroundTimeoutExpCount:" + this.hOY + " ");
            }
            if (this.hOZ > 0) {
                stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.hOZ + " ");
            }
            return stringBuffer.toString();
        }
    }

    public static void Ig() {
        List<RecoveryStatusItem> a = RecoveryReporter.a(ab.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        w.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            b bVar = hashMap2.containsKey(recoveryStatusItem.processName) ? (b) hashMap2.get(recoveryStatusItem.processName) : new b();
            aVar.hOI++;
            if (recoveryStatusItem.wQd == 1) {
                aVar.hOL++;
            } else {
                aVar.hOM++;
            }
            Object obj = null;
            int i;
            switch (recoveryStatusItem.wQf) {
                case 1:
                    if (recoveryStatusItem.wQd != 1) {
                        bVar.hOP++;
                        switch (recoveryStatusItem.wQg) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hOX++;
                                i = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hOT++;
                                i = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    bVar.hOO++;
                    switch (recoveryStatusItem.wQg) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hOW++;
                            i = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hOS++;
                            i = 1;
                            break;
                        default:
                            break;
                    }
                case 16:
                    if (recoveryStatusItem.wQd != 1) {
                        bVar.hOR++;
                        switch (recoveryStatusItem.wQg) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hOZ++;
                                i = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hOV++;
                                i = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    bVar.hOQ++;
                    switch (recoveryStatusItem.wQg) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hOY++;
                            i = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hOU++;
                            i = 1;
                            break;
                        default:
                            break;
                    }
            }
            if (obj == null) {
                w.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, bVar);
        }
        b(hashMap);
        c(hashMap2);
        RecoveryReporter.br(ab.getContext(), "ProcessStatus");
    }

    private static void b(HashMap<String, a> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hOH.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hOH.get(entry.getKey())).intValue();
                a aVar = (a) entry.getValue();
                if (aVar.hOI > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue(aVar.hOI);
                    arrayList.add(iDKey);
                }
                if (aVar.hOJ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue(aVar.hOJ);
                    arrayList.add(iDKey);
                }
                if (aVar.hOK > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue(aVar.hOK);
                    arrayList.add(iDKey);
                }
                if (aVar.hOL > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue(aVar.hOL);
                    arrayList.add(iDKey);
                }
                if (aVar.hOM > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue(aVar.hOM);
                    arrayList.add(iDKey);
                }
                if (aVar.hON > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue(aVar.hON);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.oUh.b(arrayList, true);
        }
        w.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", ab.um(), hashMap.toString());
    }

    private static void c(HashMap<String, b> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hOH.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hOH.get(entry.getKey())).intValue();
                b bVar = (b) entry.getValue();
                if (bVar.hOO > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue(bVar.hOO);
                    arrayList.add(iDKey);
                }
                if (bVar.hOP > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue(bVar.hOP);
                    arrayList.add(iDKey);
                }
                if (bVar.hOQ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue(bVar.hOQ);
                    arrayList.add(iDKey);
                }
                if (bVar.hOR > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue(bVar.hOR);
                    arrayList.add(iDKey);
                }
                if (bVar.hOS > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue(bVar.hOS);
                    arrayList.add(iDKey);
                }
                if (bVar.hOT > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue(bVar.hOT);
                    arrayList.add(iDKey);
                }
                if (bVar.hOU > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue(bVar.hOU);
                    arrayList.add(iDKey);
                }
                if (bVar.hOV > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue(bVar.hOV);
                    arrayList.add(iDKey);
                }
                if (bVar.hOW > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue(bVar.hOW);
                    arrayList.add(iDKey);
                }
                if (bVar.hOX > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue(bVar.hOX);
                    arrayList.add(iDKey);
                }
                if (bVar.hOY > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue(bVar.hOY);
                    arrayList.add(iDKey);
                }
                if (bVar.hOZ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue(bVar.hOZ);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.oUh.b(arrayList, true);
        }
        w.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", ab.um(), hashMap.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        hOH = hashMap;
        hashMap.put(ab.getPackageName(), Integer.valueOf(0));
        hOH.put(ab.getPackageName() + ":push", Integer.valueOf(20));
        hOH.put(ab.getPackageName() + ":tools", Integer.valueOf(40));
        hOH.put(ab.getPackageName() + ":exdevice", Integer.valueOf(60));
        hOH.put(ab.getPackageName() + ":sandbox", Integer.valueOf(80));
    }
}
