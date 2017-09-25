package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends i<m> {
    public static final String[] gUx = new String[]{i.a(m.gTP, "BackupTempMoveTime")};
    private e gUz;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        return super.a(j, (m) cVar);
    }

    public n(g gVar) {
        super(gVar, m.gTP, "BackupTempMoveTime", null);
        this.gUz = gVar;
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        if (getCount() <= 0) {
            linkedList3.addAll(linkedList);
            linkedList4.addAll(linkedList2);
            return;
        }
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    LinkedList linkedList5;
                    long longValue2 = ((Long) it.next()).longValue();
                    if (longValue2 == 0) {
                        longValue2 = Long.MAX_VALUE;
                    }
                    LinkedList linkedList6 = new LinkedList();
                    String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
                    w.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:" + str2);
                    Cursor rawQuery = this.gUz.rawQuery(str2, null);
                    if (rawQuery == null) {
                        w.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", str);
                        linkedList5 = null;
                    } else {
                        while (rawQuery.moveToNext()) {
                            m mVar = new m();
                            mVar.b(rawQuery);
                            eb ebVar = new eb();
                            ebVar.startTime = mVar.field_startTime;
                            ebVar.endTime = mVar.field_endTime;
                            linkedList6.add(ebVar);
                        }
                        rawQuery.close();
                        linkedList5 = linkedList6;
                    }
                    if (linkedList5 == null || linkedList5.size() <= 0 || longValue2 < ((eb) linkedList5.getFirst()).startTime || longValue > ((eb) linkedList5.getLast()).endTime) {
                        linkedList3.add(str);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    } else {
                        Object obj2;
                        int i = 0;
                        while (i < linkedList5.size() && longValue <= longValue2) {
                            long j;
                            eb ebVar2 = (eb) linkedList5.get(i);
                            if (longValue <= ebVar2.endTime) {
                                if (longValue < ebVar2.startTime) {
                                    obj = 1;
                                    linkedList3.add(str);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < ebVar2.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = ebVar2.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(ebVar2.startTime));
                                }
                                longValue = ebVar2.endTime;
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
                            linkedList3.add(str);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            linkedList3.add(str);
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

    public final boolean bKQ() {
        w.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(this.gUz.eE("BackupTempMoveTime", "delete from BackupTempMoveTime")));
        return this.gUz.eE("BackupTempMoveTime", "delete from BackupTempMoveTime");
    }
}
