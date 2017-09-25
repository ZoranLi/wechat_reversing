package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    aq xjA;
    Map<String, d> xjB = new ConcurrentHashMap();

    static class a implements Comparator<d> {
        a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    }

    public static TalkRoom a(String str, String str2, Integer num, int i, long j, aq aqVar, as[] asVarArr, at[] atVarArr) {
        d.d("tagorewang:TalkRoom:create", "create groupId: ", str, " tmpId: ", str2);
        TalkRoom talkRoom = new TalkRoom(str, num, aqVar);
        talkRoom.Wa(str2);
        Ec(i);
        fe(j);
        int length = asVarArr == null ? 0 : asVarArr.length;
        int length2 = atVarArr == null ? 0 : atVarArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            as asVar = asVarArr[i2];
            if (asVar == null) {
                d.k("tagorewang:TalkRoom:create", "null member info, index: ", Integer.valueOf(i2));
            } else {
                at atVar = null;
                int i3 = 0;
                while (i3 != length2) {
                    atVar = atVarArr[i3];
                    if (atVar != null && atVar.taQ == asVar.taQ) {
                        d.d("tagorewang:TalkRoom:create", "member info: ", asVar, " profile: ", atVar);
                        break;
                    }
                    i3++;
                    atVar = null;
                }
                talkRoom.a(new d(asVar, atVar));
            }
        }
        d.d("tagorewang:TalkRoom:create", "did create");
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, aq aqVar, as[] asVarArr, at[] atVarArr) {
        if (talkRoom == null) {
            d.k("tagorewang:TalkRoom:update", "updateAll null");
            return null;
        }
        d.d("tagorewang:TalkRoom:update", "updateAll groupId: ", str, " tmpId: ", str2);
        talkRoom.c(str, num);
        talkRoom.Wa(str2);
        Ec(i);
        fe(j);
        talkRoom.b(aqVar);
        int length = asVarArr == null ? 0 : asVarArr.length;
        int length2 = atVarArr == null ? 0 : atVarArr.length;
        if (length == 0 && length2 == 0) {
            d.k("tagorewang:TalkRoom:update", "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array.");
            return talkRoom;
        }
        Set<String> hashSet = new HashSet(talkRoom.xjB.keySet());
        hashSet.remove(com.tencent.pb.b.a.a.cdm());
        for (int i2 = 0; i2 != length; i2++) {
            as asVar = asVarArr[i2];
            if (asVar == null) {
                d.k("tagorewang:TalkRoom:update", "null member info, index: ", Integer.valueOf(i2));
            } else {
                d Wb = talkRoom.Wb(asVar.wNl);
                if (Wb == null) {
                    d.d("tagorewang:TalkRoom:update", "add new member");
                    Wb = new d(asVar);
                    talkRoom.a(Wb);
                } else {
                    Wb.a(asVar);
                }
                hashSet.remove(Wb.chu());
            }
        }
        for (String str3 : hashSet) {
            d.d("tagorewang:TalkRoom:update", "keyset", str3);
            d.d("tagorewang:TalkRoom", "remove", talkRoom.xjB.remove(str3));
        }
        if (hashSet.size() > 0) {
            d.k("tagorewang:TalkRoom:update", "updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size()));
        }
        d.d("tagorewang:TalkRoom:update", "did updateAll");
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, aq aqVar) {
        c(str, num);
        b(aqVar);
    }

    public static boolean chi() {
        return false;
    }

    private void Wa(String str) {
        if (j.Wo(str)) {
            this.wPg = str;
        }
    }

    public final int chj() {
        return this.wLa == 0 ? 0 : this.wLa;
    }

    private void c(String str, Integer num) {
        if (!TextUtils.isEmpty(str)) {
            if (j.Wo(str)) {
                this.wPg = str;
            } else {
                this.wPf = str;
            }
            if (num != null) {
                this.wLa = num.intValue();
            }
        }
    }

    public static int chk() {
        return j.chP();
    }

    private static void Ec(int i) {
        d.d("tagorewang:TalkRoom", "setRoomId: ", Integer.valueOf(i));
    }

    public static long bqi() {
        return j.chQ();
    }

    private static void fe(long j) {
        d.d("tagorewang:TalkRoom", "setRoomKey: ", Long.valueOf(j));
    }

    private static r a(aq aqVar) {
        if (aqVar != null) {
            try {
                if (aqVar.wNJ != null) {
                    byte[] bArr = aqVar.wNJ;
                    return (r) e.a(new r(), bArr, bArr.length);
                }
            } catch (Exception e) {
                d.k("tagorewang:TalkRoom", "toPlayItemInfo err: ", e);
                return null;
            }
        }
        return null;
    }

    private String chl() {
        if (this.xjA == null || TextUtils.isEmpty(this.xjA.name)) {
            List arrayList = new ArrayList(this.xjB.values());
            arrayList.remove(this.xjB.get(com.tencent.pb.b.a.a.cdm()));
            List db = db(arrayList);
            d.j("tagorewang:TalkRoom", "getOtherMembers size: ", Integer.valueOf(db.size()), " all size: ", Integer.valueOf(this.xjB.size()));
            StringBuilder stringBuilder = new StringBuilder();
            if (db != null) {
                int size = db.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder.append(((d) db.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder.append('、');
                        }
                    } catch (Exception e) {
                        d.k("tagorewang:TalkRoom", "updateRoomNameIfEmpty err and continue: ", e);
                    }
                }
            }
            if (stringBuilder.toString().length() > 0) {
                return stringBuilder.toString();
            }
        }
        if (this.xjA != null && !TextUtils.isEmpty(this.xjA.name)) {
            return this.xjA.name;
        }
        d.k("tagorewang:TalkRoom", "updateRoomNameIfEmpty still empty, groupId: ", this.wPf, " tmpId: ", this.wPg);
        return null;
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            try {
                this.wPh = aqVar.wNQ;
                this.wPi = aqVar.wNP;
                if (!(this.xjA == null || aqVar.fKw == 0)) {
                    r a = a(aqVar);
                    r a2 = a(this.xjA);
                    if (a == null) {
                        aqVar.wNJ = this.xjA.wNJ;
                    } else if (a.wMB == 0 || a.wMB != a2.wMB) {
                        d.k("tagorewang:TalkRoom", "setRoomInfo bad id: ", Integer.valueOf(a2.wMB), " -> ", Integer.valueOf(a.wMB));
                        aqVar.wNJ = this.xjA.wNJ;
                    }
                }
                this.xjA = aqVar;
            } catch (Exception e) {
                d.k("tagorewang:TalkRoom", "setRoomInfo assert failed: ", e);
                this.xjA = aqVar;
            }
        }
    }

    public final void a(d dVar) {
        this.xjB.put(dVar.chu(), dVar);
    }

    public final List<d> chm() {
        List<d> db = db(new ArrayList(this.xjB.values()));
        d cho = cho();
        db.remove(cho);
        db.add(0, cho);
        cho = (d) this.xjB.get(Integer.valueOf(90100));
        if (cho != null) {
            db.remove(cho);
            db.add(cho);
        }
        return db;
    }

    public final List<d> chn() {
        return new ArrayList(this.xjB.values());
    }

    private static List<d> db(List<d> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, new a());
        }
        return list;
    }

    public final d Wb(String str) {
        return (d) this.xjB.get(str);
    }

    public final d cho() {
        return (d) this.xjB.get(com.tencent.pb.b.a.a.cdm());
    }

    public final List<as> chp() {
        List<as> arrayList = new ArrayList();
        for (Entry value : this.xjB.entrySet()) {
            arrayList.add(((d) value.getValue()).xjI);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String chl;
            stringBuilder.append("groupId: ").append(this.wPf);
            stringBuilder.append(" tmpId: ").append(this.wPg);
            stringBuilder.append(" routeId: ").append(this.wLa);
            StringBuilder append = stringBuilder.append(" room name: ");
            if (this.xjA == null || TextUtils.isEmpty(this.xjA.name)) {
                chl = chl();
            } else {
                chl = this.xjA.name;
            }
            append.append(chl);
        } catch (Exception e) {
            stringBuilder.append(" broken by " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
