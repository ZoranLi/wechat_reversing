package com.tencent.mm.modelbiz.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ay.a;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static String gxF = null;
    public static final Object hwS = new Object();

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ a hll = null;
        final /* synthetic */ String hwT;
        final /* synthetic */ boolean hwU;

        AnonymousClass1(String str, boolean z, a aVar) {
            this.hwT = str;
            this.hwU = z;
        }

        public final void run() {
            b DK = w.DK();
            String str = this.hwT;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatConversation");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DK.gUz.eE("BizChatConversation", stringBuilder.toString())));
            if (DK.gUz.eE("BizChatConversation", stringBuilder.toString())) {
                a aVar = new a();
                b bVar = new b();
                bVar.hwG = -1;
                bVar.fGs = str;
                bVar.hwF = b.a.a.hwC;
                bVar.hwH = aVar;
                DK.hug.by(bVar);
                DK.hug.doNotify();
            }
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rl(this.hwT);
            d DJ = w.DJ();
            str = this.hwT;
            stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatInfo");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DJ.gUz.eE("BizChatInfo", stringBuilder.toString())));
            if (DJ.gUz.eE("BizChatInfo", stringBuilder.toString())) {
                c cVar = new c();
                d.a.b bVar2 = new d.a.b();
                bVar2.hwG = -1;
                bVar2.fGs = str;
                bVar2.hwQ = d.a.a.hwN;
                bVar2.hwR = cVar;
                DJ.hug.by(bVar2);
                DJ.hug.doNotify();
            }
            com.tencent.mm.a.e.d(new File(e.iz(this.hwT)));
            if (this.hwU) {
                k DL = w.DL();
                str = this.hwT;
                stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatUserInfo");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DL.gUz.eE("BizChatUserInfo", stringBuilder.toString())));
                if (DL.gUz.eE("BizChatUserInfo", stringBuilder.toString())) {
                    j jVar = new j();
                    k.a.b bVar3 = new k.a.b();
                    bVar3.hxs = k.a.a.hxp;
                    bVar3.hxt = jVar;
                    DL.hug.by(bVar3);
                    DL.hug.doNotify();
                }
                w.DM().iC(this.hwT);
                com.tencent.mm.a.e.d(new File(e.iA(this.hwT)));
            }
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hwV;

                {
                    this.hwV = r1;
                }

                public final void run() {
                    if (this.hwV.hll != null) {
                        this.hwV.hll.zr();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString() + "|deleteMsgByTalkers";
        }
    }

    public static boolean ir(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            return true;
        }
        return false;
    }

    public static boolean is(String str) {
        if (str != null) {
            return str.endsWith("@qy_g");
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
        return false;
    }

    public static boolean c(c cVar) {
        if (cVar == null) {
            return false;
        }
        List<String> DU = cVar.DU();
        String iF = w.DL().iF(cVar.field_brandUserName);
        if (iF == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            return false;
        }
        for (String equals : DU) {
            if (iF.equals(equals)) {
                return true;
            }
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", iF);
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(DU.toArray()));
        return false;
    }

    public static int ab(long j) {
        List ac = ac(j);
        if (ac != null) {
            return ac.size();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        return 0;
    }

    public static List<String> ac(long j) {
        return w.DJ().aa(j).DU();
    }

    public static String it(String str) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            return null;
        }
        j iD = w.DL().iD(str);
        if (iD != null) {
            return iD.field_userName;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String iu(String str) {
        j iD = w.DL().iD(str);
        if (iD != null) {
            return iD.field_headImageUrl;
        }
        return null;
    }

    public static c a(c cVar, long j) {
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        com.tencent.mm.sdk.platformtools.w.w(str, str2, objArr);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.field_bizChatLocalId = j;
        w.DJ().b(cVar2);
        return w.DJ().aa(j);
    }

    public static j a(j jVar, String str) {
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        com.tencent.mm.sdk.platformtools.w.w(str2, str3, objArr);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.field_userId = str;
        w.DL().b(jVar2);
        jVar = w.DL().iD(str);
        if (jVar != null) {
            return jVar;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
        return jVar2;
    }

    public static j iv(String str) {
        j jVar = null;
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
        } else {
            f iB = w.DM().iB(str);
            if (iB == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
            } else {
                jVar = w.DL().iD(iB.field_userId);
                if (jVar == null) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
            }
        }
        return jVar;
    }

    public static String iw(String str) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            return null;
        }
        CharSequence substring = str.substring(indexOf, indexOf2);
        return str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
    }

    public static String zz() {
        String str;
        synchronized (hwS) {
            str = gxF;
        }
        return str;
    }

    public static String d(c cVar) {
        if (cVar == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            return null;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        j iv = iv(cVar.field_brandUserName);
        if (iv == null || iv.field_userId == null) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        synchronized (hwS) {
            gxF = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), iv.field_userId});
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", gxF);
        return gxF;
    }

    public static void ix(String str) {
        synchronized (hwS) {
            gxF = str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.modelbiz.a.c e(com.tencent.mm.modelbiz.a.c r4) {
        /*
        r3 = 1;
        r0 = r4.field_bizChatServId;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r4 = 0;
    L_0x0006:
        return r4;
    L_0x0007:
        r0 = com.tencent.mm.modelbiz.w.DJ();
        r1 = r4.field_bizChatServId;
        r0 = r0.iq(r1);
        if (r0 == 0) goto L_0x0057;
    L_0x0013:
        r1 = r4.field_chatVersion;
        r2 = r0.field_chatVersion;
        if (r1 > r2) goto L_0x0021;
    L_0x0019:
        r1 = r0.field_brandUserName;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x0063;
    L_0x0021:
        r1 = r4.field_chatName;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x002d;
    L_0x0029:
        r1 = r4.field_chatName;
        r0.field_chatName = r1;
    L_0x002d:
        r1 = r4.field_brandUserName;
        r0.field_brandUserName = r1;
        r0.field_needToUpdate = r3;
        r1 = r4.field_chatType;
        r0.field_chatType = r1;
        r1 = com.tencent.mm.modelbiz.w.DJ();
        r1.b(r0);
        r4 = r0;
    L_0x003f:
        r0 = r4.DW();
        if (r0 == 0) goto L_0x0006;
    L_0x0045:
        r0 = r4.DV();
        if (r0 == 0) goto L_0x0065;
    L_0x004b:
        r0 = com.tencent.mm.modelbiz.w.DN();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.W(r1, r2);
        goto L_0x0006;
    L_0x0057:
        r4.field_needToUpdate = r3;
        r1 = com.tencent.mm.modelbiz.w.DJ();
        r1 = r1.a(r4);
        if (r1 != 0) goto L_0x003f;
    L_0x0063:
        r4 = r0;
        goto L_0x003f;
    L_0x0065:
        r0 = com.tencent.mm.modelbiz.w.DN();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.X(r1, r2);
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.a.e.e(com.tencent.mm.modelbiz.a.c):com.tencent.mm.modelbiz.a.c");
    }

    public static boolean f(c cVar) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            return false;
        }
        List<String> DU = cVar.DU();
        if (DU == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : DU) {
            j iD = w.DL().iD(str);
            if (iD != null && iD.DW()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            w.DN().b(linkedList, cVar.field_brandUserName);
            return true;
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        return false;
    }

    public static String ad(long j) {
        return w.DJ().aa(j).field_bizChatServId;
    }

    public static long iy(String str) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            return -1;
        }
        c iq = w.DJ().iq(str);
        if (iq != null) {
            return iq.field_bizChatLocalId;
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        return -1;
    }

    public static void u(String str, boolean z) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            return;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        com.tencent.mm.kernel.h.vL().D(new AnonymousClass1(str, z, null));
    }

    public static void l(final String str, final String str2, final String str3) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", str, str2, str3);
        com.tencent.mm.kernel.h.vL().D(new Runnable() {
            public final void run() {
                c iq = w.DJ().iq(str2);
                if (iq != null) {
                    if (iq.field_chatVersion < bg.getInt(str3, Integer.MAX_VALUE)) {
                        iq.field_needToUpdate = true;
                        w.DJ().b(iq);
                    }
                    if (iq.DV()) {
                        w.DN().W(iq.field_bizChatServId, str);
                    } else {
                        w.DN().X(iq.field_bizChatServId, str);
                    }
                }
            }
        });
    }

    public static String iz(String str) {
        if (bg.mA(str)) {
            str = "tempConv";
        }
        StringBuilder stringBuilder = new StringBuilder(com.tencent.mm.plugin.n.b.xc());
        stringBuilder.append(g.n(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        return stringBuilder.toString();
    }

    public static String iA(String str) {
        if (bg.mA(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(com.tencent.mm.plugin.n.b.xc());
        stringBuilder.append(g.n(str.getBytes())).append("/");
        stringBuilder.append("user/");
        return stringBuilder.toString();
    }

    public static boolean a(c cVar, String str, String str2, ss ssVar) {
        if (!(str == null || bg.mA(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && bg.mA(str2)) {
                    j jVar;
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j iD = w.DL().iD(string);
                    if (iD == null) {
                        jVar = new j();
                        z = true;
                    } else {
                        jVar = iD;
                        z = false;
                    }
                    jVar.field_userId = string;
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    if (jVar.field_brandUserName == null || jVar.field_brandUserName.length() == 0) {
                        jVar.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (jVar.field_addMemberUrl == null || jVar.field_addMemberUrl.length() == 0) {
                        jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!w.DL().b(jVar)) {
                        w.DL().a(jVar);
                    }
                    if (z) {
                        w.DN().Y(jVar.field_userId, jVar.field_brandUserName);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = jVar.field_userId;
                    cVar2.field_brandUserName = jVar.field_brandUserName;
                    cVar2.field_chatName = jVar.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = e(cVar2);
                    if (cVar2 == null) {
                        return false;
                    }
                    cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                    cVar.field_chatName = jVar.field_userName;
                    return true;
                }
                LinkedList linkedList = new LinkedList();
                if (!bg.mA(str2)) {
                    gs gsVar = new gs();
                    gsVar.tkM = str2;
                    linkedList.add(gsVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar2 = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar2.field_userId = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                    jVar2.field_userName = jSONObject2.getString("nick_name");
                    jVar2.field_brandUserName = cVar.field_brandUserName;
                    jVar2.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar2.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar2.field_UserVersion = jSONObject2.getInt("ver");
                    jVar2.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!w.DL().b(jVar2)) {
                        w.DL().a(jVar2);
                    }
                    gs gsVar2 = new gs();
                    gsVar2.tkM = jVar2.field_userId;
                    linkedList.add(gsVar2);
                }
                ssVar.tkN = linkedList;
                cVar.field_bizChatLocalId = -1;
                return true;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e.getMessage());
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        return false;
    }

    public static void g(c cVar) {
        if (cVar == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            return;
        }
        boolean X = w.DK().X(cVar.field_bizChatLocalId);
        boolean fu = cVar.fu(16);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(X), Boolean.valueOf(fu), cVar.field_chatName);
        if (fu && !X) {
            w.DK().Y(cVar.field_bizChatLocalId);
        } else if (!fu && X) {
            w.DK().Z(cVar.field_bizChatLocalId);
        }
    }

    public static void h(c cVar) {
        if (cVar == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            return;
        }
        ae Rm = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(cVar.field_brandUserName);
        if (Rm == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            return;
        }
        ce Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(cVar.field_brandUserName);
        ce ac = ((n) com.tencent.mm.kernel.h.h(n.class)).wU().ac(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (Ai != null && ac != null && Ai.field_msgId == ac.field_msgId) {
            String str = Rm.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (substring != null && !substring.equals(cVar.field_chatName)) {
                        Rm.cu(cVar.field_chatName + ":" + str);
                        ((h) com.tencent.mm.kernel.h.h(h.class)).wW().a(Rm, Rm.field_username);
                    }
                }
            }
        }
    }
}
