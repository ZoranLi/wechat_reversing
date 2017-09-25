package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static boolean DEBUG = false;
    public static boolean xjD = false;
    private static final g<c> xjE = new g<c>() {
        protected final /* synthetic */ Object cdk() {
            return new c();
        }
    };
    Map<String, TalkRoom> xjF = new HashMap();
    Map<String, String> xjG = new HashMap();
    g xjH;

    public static c chs() {
        return (c) xjE.get();
    }

    public c() {
        d.d("TalkRoomManager", "asyncLoadCache");
    }

    public final boolean be(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            d.k("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            return false;
        }
        TalkRoom Wc = Wc(str);
        if (Wc == null) {
            d.k("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            return false;
        }
        List<d> chm = Wc.chm();
        if (chm == null) {
            d.k("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : chm) {
            if (dVar != null) {
                boolean z4;
                TalkRoom.chi();
                if (dVar.getState() != 10) {
                    z4 = z2;
                    z2 = z3;
                } else if (dVar.chw()) {
                    z4 = true;
                    z2 = z3;
                } else {
                    z4 = z2;
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
                if (z4 && z2) {
                    d.k("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    return true;
                }
                z3 = z2;
                z2 = z4;
            }
        }
        return false;
    }

    public final TalkRoom Wc(String str) {
        TalkRoom talkRoom = (TalkRoom) this.xjF.get(str);
        if (talkRoom != null || !j.Wo(str)) {
            return talkRoom;
        }
        return (TalkRoom) this.xjF.get((String) this.xjG.get(str));
    }

    public final int Wd(String str) {
        if (TextUtils.isEmpty(str)) {
            d.k("TalkRoomManager", "getSelfMemberId invalid groupId");
            return -1;
        }
        TalkRoom Wc = Wc(str);
        if (Wc == null) {
            d.k("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            return -1;
        }
        d Wb = Wc.Wb(a.cdm());
        if (Wb != null) {
            d.k("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.cdm(), " memberId: ", Integer.valueOf(Wb.chv()));
            return Wb.chv();
        }
        d.k("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        return -1;
    }

    public final int We(String str) {
        if (TextUtils.isEmpty(str)) {
            d.k("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            return 0;
        }
        TalkRoom Wc = Wc(str);
        if (Wc != null) {
            return Wc.chj();
        }
        d.k("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
        return 0;
    }

    public final boolean a(String str, String str2, int i, int i2, String... strArr) {
        d.d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!j.Wo(str)) {
            d.k("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            return false;
        } else if (strArr == null || strArr.length == 0) {
            d.k("TalkRoomManager", "newTmpGroup empty uuid array");
            return false;
        } else {
            try {
                aq aqVar = new aq();
                aqVar.fKw = 0;
                aqVar.wNQ = str2;
                aqVar.wNP = a.cdm();
                TalkRoom talkRoom = new TalkRoom(str, null, aqVar);
                int length = strArr.length;
                for (int i3 = 0; i3 != length; i3++) {
                    String str3 = strArr[i3];
                    as asVar = new as();
                    asVar.wNl = str3;
                    asVar.wOr = a.cdm();
                    asVar.status = 20;
                    asVar.mOs = -1;
                    asVar.wOf = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(asVar, new at()));
                }
                this.xjF.put(str, talkRoom);
                cht();
                return true;
            } catch (Exception e) {
                d.k("TalkRoomManager", "newTmpGroup err: ", e);
                return false;
            }
        }
    }

    static void cht() {
        d.d("TalkRoomManager", "asyncWriteBackCache");
    }

    public static boolean Wf(String str) {
        TalkRoom Wc = chs().Wc(str);
        if (Wc == null) {
            d.k("TalkRoomManager", "isMySelfExit talkRoom is null");
            return true;
        }
        d cho = Wc.cho();
        if (cho == null || 20 == cho.getState()) {
            return true;
        }
        return false;
    }

    public static int Wg(String str) {
        TalkRoom Wc = chs().Wc(str);
        if (Wc == null) {
            d.k("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            return 0;
        }
        int i;
        d cho = Wc.cho();
        if (cho == null || cho.xjI == null) {
            i = 0;
        } else {
            i = cho.xjI.fOl;
        }
        d.k("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i));
        return i;
    }

    public final MultiTalkGroup Wh(String str) {
        TalkRoom Wc = Wc(str);
        if (Wc == null) {
            return null;
        }
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.wPf = Wc.wPf;
        multiTalkGroup.wPg = Wc.wPg;
        multiTalkGroup.wLa = Wc.wLa;
        multiTalkGroup.wPh = Wc.wPh;
        multiTalkGroup.wPi = Wc.wPi;
        List arrayList = new ArrayList();
        List<d> chn = Wc.chn();
        if (chn.size() > 0) {
            for (d dVar : chn) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.wPk = dVar.chu();
                    multiTalkGroupMember.wPl = dVar.xjI != null ? dVar.xjI.wOr : "";
                    multiTalkGroupMember.fOl = dVar.xjI != null ? dVar.xjI.fOl : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    int i = (dVar.xjI == null || dVar.xjI.wOf == 0) ? 0 : dVar.xjI.wOf;
                    multiTalkGroupMember.wOf = i;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.wPj = arrayList;
        return multiTalkGroup;
    }
}
