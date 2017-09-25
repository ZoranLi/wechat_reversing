package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<i> {
    public static final String[] gUx = new String[]{i.a(i.gTP, "BackupMoveTime")};
    public e gUz;

    public j(g gVar) {
        super(gVar, i.gTP, "BackupMoveTime", null);
        this.gUz = gVar;
        long currentTimeMillis = System.currentTimeMillis();
        long cs = gVar.cs(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"CREATE INDEX IF NOT EXISTS BackupMoveTimeDeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"}));
        for (int i = 0; i < arrayList.size(); i++) {
            gVar.eE("BackupMoveTime", (String) arrayList.get(i));
        }
        w.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        gVar.aD(cs);
        w.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    ec ecVar;
                    long longValue2 = ((Long) it.next()).longValue();
                    if (longValue2 == 0) {
                        longValue2 = Long.MAX_VALUE;
                    }
                    String str3 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + str2 + "\" ";
                    w.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:" + str3);
                    Cursor rawQuery = this.gUz.rawQuery(str3, null);
                    if (rawQuery == null) {
                        w.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", str, str2);
                        ecVar = null;
                    } else if (rawQuery.moveToFirst()) {
                        i iVar = new i();
                        iVar.b(rawQuery);
                        rawQuery.close();
                        ecVar = iVar.field_moveTime;
                    } else {
                        rawQuery.close();
                        ecVar = null;
                    }
                    if (ecVar == null || ecVar.thQ.size() <= 0 || longValue2 < ((eb) ecVar.thQ.getFirst()).startTime || longValue > ((eb) ecVar.thQ.getLast()).endTime) {
                        linkedList3.add(str2);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    } else {
                        Object obj2;
                        LinkedList linkedList5 = ecVar.thQ;
                        int i = 0;
                        while (i < linkedList5.size() && longValue <= longValue2) {
                            long j;
                            eb ebVar = (eb) linkedList5.get(i);
                            if (longValue <= ebVar.endTime) {
                                if (longValue < ebVar.startTime) {
                                    obj = 1;
                                    linkedList3.add(str2);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < ebVar.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = ebVar.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(ebVar.startTime));
                                }
                                longValue = ebVar.endTime;
                                obj2 = obj;
                                j = longValue;
                            } else {
                                obj2 = obj;
                                j = longValue;
                            }
                            i++;
                            longValue = j;
                            obj = obj2;
                        }
                        obj2 = obj;
                        if (longValue <= longValue2) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void d(String str, LinkedList<m> linkedList) {
        HashMap hashMap;
        w.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        w.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:" + str2);
        Cursor rawQuery = this.gUz.rawQuery(str2, null);
        if (rawQuery == null) {
            w.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", str);
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.b(rawQuery);
                hashMap2.put(iVar.field_sessionName, iVar);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.gUz.delete("BackupMoveTime", "deviceId= ? ", new String[]{str}) < 0) {
            w.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", str);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            i iVar2 = (i) hashMap.get(mVar.field_sessionName);
            if (iVar2 == null) {
                eb ebVar = new eb();
                ebVar.startTime = mVar.field_startTime;
                ebVar.endTime = mVar.field_endTime;
                i iVar3 = new i();
                iVar3.field_deviceId = str;
                iVar3.field_sessionName = mVar.field_sessionName;
                iVar3.field_moveTime = new ec();
                iVar3.field_moveTime.thQ = new LinkedList();
                iVar3.field_moveTime.thQ.add(ebVar);
                hashMap.put(mVar.field_sessionName, iVar3);
            } else {
                a(iVar2.field_moveTime.thQ, mVar);
            }
        }
        for (String str3 : hashMap.keySet()) {
            w.i("MicroMsg.BackupMoveTimeStorage", "summerbak insert BackupMoveTimeStorage ret[%b], sessionName:%s", Boolean.valueOf(b((c) hashMap.get(str3))), str3);
        }
    }

    private static void a(LinkedList<eb> linkedList, m mVar) {
        if (mVar.field_startTime <= mVar.field_endTime) {
            eb ebVar;
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ebVar = (eb) it.next();
                if (mVar.field_startTime < ebVar.endTime) {
                    if (mVar.field_endTime < ebVar.startTime) {
                        ebVar = new eb();
                        ebVar.startTime = mVar.field_startTime;
                        ebVar.endTime = mVar.field_endTime;
                        linkedList.add(ebVar);
                        obj = 1;
                    } else {
                        int i;
                        if (mVar.field_startTime < ebVar.startTime) {
                            ebVar.startTime = mVar.field_startTime;
                        }
                        if (mVar.field_endTime > ebVar.endTime) {
                            ebVar.endTime = mVar.field_endTime;
                            while (it.hasNext()) {
                                eb ebVar2 = (eb) it.next();
                                if (mVar.field_endTime <= ebVar2.startTime) {
                                    break;
                                } else if (mVar.field_endTime <= ebVar2.endTime) {
                                    ebVar.endTime = ebVar2.endTime;
                                    it.remove();
                                    i = 1;
                                    break;
                                } else {
                                    it.remove();
                                }
                            }
                        }
                        i = 1;
                    }
                    if (obj == null) {
                        ebVar = new eb();
                        ebVar.startTime = mVar.field_startTime;
                        ebVar.endTime = mVar.field_endTime;
                        linkedList.add(ebVar);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                ebVar = new eb();
                ebVar.startTime = mVar.field_startTime;
                ebVar.endTime = mVar.field_endTime;
                linkedList.add(ebVar);
            }
        }
    }
}
