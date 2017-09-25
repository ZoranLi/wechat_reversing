package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.qq.taf.jce.JceStruct;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.i;
import com.tencent.pb.common.c.j;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.model.f.b;
import com.tencent.wecall.talkroom.model.g.AnonymousClass12;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class e implements d {
    private static e xjL = null;
    private final String TAG = "TalkRoomSdkApi";
    public a xjK = null;
    private ConnectReceiver xjM = new ConnectReceiver();
    private g.a xjN = new g.a(this) {
        final /* synthetic */ e xjO;

        {
            this.xjO = r1;
        }

        public final void p(MultiTalkGroup multiTalkGroup) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
            if (com.tencent.pb.common.a.a.wKz) {
                Toast.makeText(com.tencent.pb.common.c.e.rof, "onCreateRoom " + multiTalkGroup, 0).show();
            }
            if (this.xjO.xjK != null) {
                this.xjO.xjK.e(multiTalkGroup);
            }
        }

        public final void Ed(int i) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i));
        }

        public final void aGO() {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onInitSeccess");
            if (com.tencent.pb.common.a.a.wKz) {
                Toast.makeText(com.tencent.pb.common.c.e.rof, "onInitSeccess ", 0).show();
            }
            if (this.xjO.xjK != null) {
                this.xjO.xjK.aMT();
            }
        }

        public final void g(MultiTalkGroup multiTalkGroup) {
            String str = a.chg().mwM;
            String str2 = null;
            if (multiTalkGroup != null) {
                str2 = multiTalkGroup.wPf;
            }
            com.tencent.pb.common.c.d.j("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
            if (com.tencent.pb.common.a.a.wKz) {
                Toast.makeText(com.tencent.pb.common.c.e.rof, "onMemberChange " + multiTalkGroup, 0).show();
            }
            if (i.fc(str2, str)) {
                c.chs();
                if (c.Wf(str) && a.chg().state != 3) {
                    int i;
                    int i2;
                    c.chs();
                    int Wg = c.Wg(str);
                    if (Wg == 104) {
                        i = -1602;
                        i2 = 325;
                    } else if (Wg == 2) {
                        i = -1603;
                        i2 = 326;
                    } else {
                        i = -1604;
                        i2 = 328;
                    }
                    com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(Wg));
                    h.Eg(i);
                    a.chg().xkj.Ek(i2);
                    f chg = a.chg();
                    Wg = a.chg().mUm;
                    long j = a.chg().xkb;
                    boolean z = a.chg().rhF;
                    chg.a(str2, Wg, j, false, false, false);
                }
            }
            if (this.xjO.xjK != null) {
                this.xjO.xjK.g(multiTalkGroup);
            }
        }

        public final void e(int i, Object obj) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i), " data: ", obj);
            if (this.xjO.xjK != null) {
                this.xjO.xjK.e(i, obj);
            }
        }

        public final void q(MultiTalkGroup multiTalkGroup) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
            if (this.xjO.xjK != null) {
                this.xjO.xjK.f(multiTalkGroup);
                if (com.tencent.pb.common.a.a.wKz) {
                    Toast.makeText(com.tencent.pb.common.c.e.rof, "onEnterRoom " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void bf(String str, boolean z) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onExitRoom", str, a.chg().mwM, Boolean.valueOf(z));
        }

        public final void onStateChanged(int i) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i));
        }

        public final void chy() {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onSelfHoldOnBegin");
        }

        public final void chz() {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onSelfHoldOnEnd");
        }

        public final void dm(String str, int i) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i));
        }

        public final void fN(boolean z) {
            com.tencent.pb.common.c.d.j("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
            if (this.xjO.xjK != null) {
                this.xjO.xjK.fN(z);
            }
        }

        public final void b(MultiTalkGroup multiTalkGroup) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
            if (this.xjO.xjK != null) {
                this.xjO.xjK.b(multiTalkGroup);
                if (com.tencent.pb.common.a.a.wKz) {
                    Toast.makeText(com.tencent.pb.common.c.e.rof, "onInviteMultiTalk " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void a(int i, MultiTalkGroup multiTalkGroup) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i));
            if (this.xjO.xjK != null) {
                this.xjO.xjK.d(multiTalkGroup);
                if (com.tencent.pb.common.a.a.wKz) {
                    Toast.makeText(com.tencent.pb.common.c.e.rof, "onMisscMultiTalk " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void dc(List<MultiTalkGroup> list) {
            com.tencent.pb.common.c.d.j("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
        }

        public final void chA() {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "onSendMsgSucc");
        }

        public final void z(String str, byte[] bArr) {
            int i = 0;
            String str2 = "TalkRoomSdkApi";
            Object[] objArr = new Object[4];
            objArr[0] = "onRcvMultiTalkMsg groupId: ";
            objArr[1] = str;
            objArr[2] = " datas size: ";
            if (bArr != null) {
                i = bArr.length;
            }
            objArr[3] = Integer.valueOf(i);
            com.tencent.pb.common.c.d.k(str2, objArr);
        }

        public final void Ee(int i) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i));
            if (this.xjO.xjK != null) {
                this.xjO.xjK.aMU();
            }
        }

        public final void aU(List<aj> list) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
            if (this.xjO.xjK != null) {
                this.xjO.xjK.aU(list);
            }
        }
    };

    public static e chx() {
        if (xjL == null) {
            synchronized (e.class) {
                if (xjL == null) {
                    xjL = new e();
                }
            }
        }
        return xjL;
    }

    private e() {
    }

    public static void hK(Context context) {
        com.tencent.pb.common.c.e.rof = context;
        com.tencent.e.i.hJ(context);
    }

    public final boolean a(a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        if (com.tencent.pb.common.c.e.rof == null) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "init fail context: ", com.tencent.pb.common.c.e.rof);
            return false;
        }
        try {
            this.xjK = aVar;
            f.a(eVar);
            f chg = a.chg();
            g.a aVar2 = this.xjN;
            g gVar = chg.xkr;
            synchronized (aVar2) {
                if (gVar.gJv.contains(aVar2)) {
                } else {
                    gVar.gJv.add(aVar2);
                }
            }
            f.ccT().wLm = eVar;
            a.chf();
            a.chh();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.tencent.pb.common.c.e.rof.registerReceiver(this.xjM, intentFilter);
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "init");
            return true;
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "init ", e);
            return false;
        }
    }

    public final void lY(boolean z) {
        f chg = a.chg();
        com.tencent.pb.common.c.d.k("TalkRoomService", "setMute isMute: ", Boolean.valueOf(z));
        chg.fAp = z;
        j.ac(new AnonymousClass12(chg.xkr, z));
    }

    public final void fT(boolean z) {
        boolean fP;
        a.chg();
        com.tencent.pb.talkroom.sdk.e chK = f.chK();
        if (chK != null) {
            fP = chK.fP(z);
        } else {
            fP = false;
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(fP), " realret: ", Boolean.valueOf(f.qN()), " wxCallBack: ", chK);
    }

    public final boolean cdo() {
        try {
            com.tencent.pb.common.c.d.v(true, 0);
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setOpenLog: isOpenSdkLog", Boolean.valueOf(true), " level: ", Integer.valueOf(0));
            return true;
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setOpenLog: ", th);
            return false;
        }
    }

    public final boolean f(String str, String str2, List<String> list) {
        f chg = a.chg();
        String[] dd = f.dd(list);
        if (dd.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (com.tencent.pb.b.a.a.cdm().hashCode() & 65535);
            } else {
                String str3 = null;
                String str4 = null;
                int charAt = str3.charAt(str4.length() - 1) * 256;
                int i = 0;
                String str5 = null;
                if (str5.length() > 1) {
                    str3 = null;
                    str5 = null;
                    i = str3.charAt(str5.length() - 2);
                }
                nextInt = i + charAt;
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(dd.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null);
            if (!com.tencent.pb.b.a.a.cdn()) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.b.a.a.cdn()), " isBindMobile: ", Boolean.valueOf(true));
                h.a("", str, 0, 0, "create", "req", "false", "noAuth");
            } else if (!h.isNetworkConnected()) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom isNetworkConnected is false");
                h.Ei(-4003);
                h.a("", str, 0, 0, "create", "req", "false", "noNetwork");
            } else if (chg.bpk()) {
                if (chg.bpk()) {
                    h.Ei(-4002);
                }
                h.a("", str, 0, 0, "create", "req", "false", "isBusy");
            } else if (TextUtils.isEmpty(str)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom cliendId is null");
                h.a("", str, 0, 0, "create", "req", "false", "cliendIdnull");
            } else if (j.Wo(str)) {
                if (c.chs().Wc(str) == null) {
                    c.chs().a(str, str2, 0, 0, dd);
                }
                chg.chE();
                chg.mk(false);
                chg.chB();
                if (chg.bnR()) {
                    chg.xkj.chM();
                    chg.mwM = str;
                    chg.xkv = str;
                    chg.wLa = nextInt;
                    chg.xka = str;
                    chg.setState(1);
                    chg.rhF = true;
                    a aVar = new a(chg);
                    aVar.groupId = chg.mwM;
                    aVar.xkT = dd;
                    aVar.xkU = null;
                    aVar.wLL = nextInt;
                    aVar.type = 0;
                    aVar.xkV = 0;
                    aVar.xkW = null;
                    aVar.xkX = false;
                    aVar.xkY = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = aVar;
                    chg.mHandler.removeMessages(2);
                    TalkRoom Wc = c.chs().Wc(chg.mwM);
                    if (Wc == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "isOnlyMySelfInGroup talkroom is null");
                    } else {
                        List chm = Wc.chm();
                        if (chm == null || chm.size() != 1) {
                            com.tencent.pb.common.c.d.k("TalkRoomManager", "isOnlyMySelfInGroup TalkRoomMember list is not match");
                        } else {
                            d dVar = (d) chm.get(0);
                            if (dVar == null) {
                                com.tencent.pb.common.c.d.k("TalkRoomManager", "isOnlyMySelfInGroup talkRoomMember is null");
                            } else {
                                boolean chw = dVar.chw();
                                com.tencent.pb.common.c.d.k("TalkRoomManager", "isOnlyMySelfInGroup ret: ", Boolean.valueOf(chw));
                            }
                        }
                    }
                    chg.mHandler.sendMessage(obtain);
                    chg.xkx = true;
                    com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.b.a.a.cdm(), " usrnameList: ", list);
                    return str == null;
                } else {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom initEngine fail");
                    h.a("", str, 0, 0, "create", "req", "false", "initEnginefail");
                    chg.mk(false);
                }
            } else {
                com.tencent.pb.common.c.d.k("TalkRoomService", "createTalkRoom groupId is not cliend id: ", str);
                h.a("", str, 0, 0, "create", "req", "false", "isnotcliendId");
            }
        }
        str = null;
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.b.a.a.cdm(), " usrnameList: ", list);
        if (str == null) {
        }
    }

    public final boolean dg(String str, int i) {
        f chg = a.chg();
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.valueOf(true), " routId: ", Integer.valueOf(i), " ret: ", chg.a(null, str, chg.mUm, chg.xkb, i, 1));
        if (chg.a(null, str, chg.mUm, chg.xkb, i, 1) == b.OK) {
            return true;
        }
        return false;
    }

    public final boolean a(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " ret: ", a.chg().a(null, str, i, j, i2, 100));
        return a.chg().a(null, str, i, j, i2, 100) == b.OK;
    }

    public final boolean r(String str, List<String> list) {
        if (i.fc(str, a.chg().mwM)) {
            boolean z;
            f chg = a.chg();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(chg.mUm);
            objArr[3] = Long.valueOf(chg.xkb);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            com.tencent.pb.common.c.d.k(str2, objArr);
            chg.xkx = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (h.isNetworkConnected()) {
                String[] dd = f.dd(list);
                if (dd.length <= 0) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "addTalkRoomMember users is null");
                    z = false;
                } else {
                    z = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.b(str, chg.mUm, chg.xkb, dd));
                    chg.xkj.N("add", "req", String.valueOf(z), String.valueOf(chg.state));
                }
            } else {
                com.tencent.pb.common.c.d.k("TalkRoomService", "addTalkRoomMember isNetworkConnected is false");
                z = false;
            }
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "addMultiTalkMember ret: ", Boolean.valueOf(z));
            return z;
        }
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.chg().mwM);
        return false;
    }

    public final boolean Bf(String str) {
        if (i.fc(str, a.chg().mwM)) {
            int i = a.chg().mUm;
            long j = a.chg().xkb;
            boolean W = a.chg().W(str, 1, 100);
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            return W;
        }
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.chg().mwM);
        if (!a.chg().Wj(str)) {
            return false;
        }
        int i2;
        e Wi = a.chg().Wi(str);
        f chg = a.chg();
        if (Wi == null) {
            i2 = 0;
        } else {
            i2 = Wi.mNL;
        }
        if (Wi == null) {
            j = 0;
        } else {
            j = Wi.mNM;
        }
        chg.b(str, i2, j, 1);
        return false;
    }

    public final List<String> UX(String str) {
        if (i.fc(str, a.chg().mwM)) {
            TalkRoom Wc = c.chs().Wc(str);
            if (Wc == null) {
                com.tencent.pb.common.c.d.k("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
                return null;
            }
            List<d> chn = Wc.chn();
            List<String> arrayList = new ArrayList();
            for (d dVar : chn) {
                if (dVar != null) {
                    int i;
                    f chg = a.chg();
                    int chv = dVar.chv();
                    if (chg.xkk != null) {
                        i = (com.tencent.pb.common.a.a.wKA && chg.xkk.xjC.GetVoiceActivity(chv) == 1) ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(dVar.chu());
                    }
                }
            }
            return arrayList;
        }
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.chg().mwM);
        return null;
    }

    public final boolean c(int i, int i2, int i3, byte[] bArr) {
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        com.tencent.pb.common.c.d.k(str, objArr);
        if (i == 0) {
            f.ccT().o(i2, bArr);
        } else {
            f ccT = f.ccT();
            a CO = ccT.CO(i2);
            if (CO != null) {
                com.tencent.pb.common.c.d.k("NETCMD", "CLTRCV FAIL", Integer.valueOf(i2), CO.wLp, Integer.valueOf(1), Integer.valueOf(i));
                ccT.a(CO, -1, null);
            }
        }
        return true;
    }

    public final boolean bv(byte[] bArr) {
        f.ccT();
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "handleMultiTalkNotify ret: ", Integer.valueOf(f.bu(bArr)));
        if (f.bu(bArr) == 0) {
            return true;
        }
        return false;
    }

    public final boolean lZ(boolean z) {
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "holadMultiTalk isHold", Boolean.valueOf(z));
        f chg;
        if (z) {
            chg = a.chg();
            com.tencent.pb.common.c.d.d("TalkRoomService", "syscall", "startHoldOn");
            chg.xkF = true;
            chg.ml(false);
            j.ac(new Runnable(chg.xkr) {
                final /* synthetic */ g xll;

                {
                    this.xll = r1;
                }

                public final void run() {
                    synchronized (this.xll.gJv) {
                        for (a chy : this.xll.gJv) {
                            chy.chy();
                        }
                    }
                }
            });
        } else {
            chg = a.chg();
            com.tencent.pb.common.c.d.d("TalkRoomService", "syscall", "endHoldOn");
            chg.xkF = false;
            chg.chC();
            if (chg.bpk() && chg.nea) {
                chg.ml(true);
                j.ac(new Runnable(chg.xkr) {
                    final /* synthetic */ g xll;

                    {
                        this.xll = r1;
                    }

                    public final void run() {
                        synchronized (this.xll.gJv) {
                            for (a chz : this.xll.gJv) {
                                chz.chz();
                            }
                        }
                    }
                });
            }
        }
        return true;
    }

    public final String cdp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(com.tencent.pb.b.a.a.cdm());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "genMultiTalkClientId clientId: ", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public final void aK(int i, String str) {
        com.tencent.pb.b.a.a.CP(i);
        com.tencent.pb.b.a.a.UW(str);
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str);
    }

    public final int a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        b bVar = a.chg().xkk;
        if (bVar == null) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setMultiTalkAppCmd talkRoomContext is null");
            return -100;
        }
        talk com_tencent_mm_plugin_multi_talk = bVar.xjC;
        if (com_tencent_mm_plugin_multi_talk == null) {
            com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setMultiTalkAppCmd engine is null");
            return -101;
        }
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "setMultiTalkAppCmd inputVolumeScale: ", Integer.valueOf(i), " inputVolumeScaleForSpeaker: ", Integer.valueOf(i2), " outputVolumeScale: ", Integer.valueOf(i3), " outputVolumeScaleForSpeaker: ", Integer.valueOf(i4), " ehanceHeadsetEC: ", Integer.valueOf(i5), " setECModeLevelForHeadSet: ", Integer.valueOf(i6), " setECModeLevelForSpeaker: ", Integer.valueOf(i7), " enableSpeakerEnhanceEC: ", Integer.valueOf(i8), " aecMode: ", Integer.valueOf(i9), " nsMode: ", Integer.valueOf(i10), " agcMode: ", Integer.valueOf(i11), " agctargetdb: ", Integer.valueOf(i12), " agcgaindb: ", Integer.valueOf(i13), " agcFlag: ", Integer.valueOf(i14));
        if (!com.tencent.pb.common.a.a.wKA) {
            return -200;
        }
        byte[] bArr;
        if (com.tencent.pb.a.a.a.wIu) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[1] = (byte) 2;
            bArr[0] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(419, 0);
            com_tencent_mm_plugin_multi_talk.cs(418, 4);
        } else if (com.tencent.pb.a.a.a.wIw || com.tencent.pb.a.a.a.wIv) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[1] = (byte) 4;
            bArr[0] = (byte) 4;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[1] = (byte) 6;
            bArr[0] = (byte) 6;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(416, 1);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wJJ) {
            com_tencent_mm_plugin_multi_talk.cs(416, 1);
        } else if (com.tencent.pb.a.a.a.wIx) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, new byte[]{(byte) 2, (byte) 2}, 2);
        } else if (com.tencent.pb.a.a.a.wIy) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, new byte[]{(byte) 2, (byte) 2}, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
            com_tencent_mm_plugin_multi_talk.cs(418, 4);
            com_tencent_mm_plugin_multi_talk.cs(416, 1);
        } else if (com.tencent.pb.a.a.a.wJV) {
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wIz) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wJK) {
            com_tencent_mm_plugin_multi_talk.cs(416, 1);
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = JceStruct.ZERO_TAG;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.cs(418, 4);
        } else if (com.tencent.pb.a.a.a.wIA) {
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wIB) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
            com_tencent_mm_plugin_multi_talk.cs(418, 4);
        } else if (com.tencent.pb.a.a.a.wIF) {
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        } else if (com.tencent.pb.a.a.a.wIC) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 1;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wID) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 1;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wIE) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 15;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wKe) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, new byte[]{(byte) 0, (byte) 6}, 2);
            com_tencent_mm_plugin_multi_talk.cs(408, 2);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wIG) {
            com_tencent_mm_plugin_multi_talk.cs(417, 1);
            com_tencent_mm_plugin_multi_talk.cs(418, 2);
        } else if (com.tencent.pb.a.a.a.wIK) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 3;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.cs(417, 3);
        } else if (com.tencent.pb.a.a.a.wIL) {
            com_tencent_mm_plugin_multi_talk.cs(419, 0);
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 3;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        } else if (com.tencent.pb.a.a.a.wIN) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 3;
            bArr[1] = (byte) 2;
            bArr[2] = JceStruct.ZERO_TAG;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
        } else if (com.tencent.pb.a.a.a.wIO) {
            com_tencent_mm_plugin_multi_talk.cs(419, 0);
        } else {
            boolean z = com.tencent.pb.a.a.a.wIM;
        }
        if (i >= 0 || i2 >= 0) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            if (i >= 0) {
                bArr[0] = (byte) i;
            }
            if (i2 >= 0) {
                bArr[1] = (byte) i2;
            }
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
        }
        if (i3 >= 0 || i4 >= 0) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            if (i3 >= 0) {
                bArr[0] = (byte) i3;
            }
            if (i4 >= 0) {
                bArr[1] = (byte) i4;
            }
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        }
        if (i5 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(416, i5);
        }
        if (i6 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(417, i6);
        }
        if (i7 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(418, i7);
        }
        if (i8 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(419, i8);
        }
        if (i9 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(406, i9);
        } else if (i9 == -2) {
            com_tencent_mm_plugin_multi_talk.pQ(407);
        }
        if (i10 >= 0) {
            com_tencent_mm_plugin_multi_talk.cs(408, i10);
        } else if (i10 == -2) {
            com_tencent_mm_plugin_multi_talk.pQ(409);
        }
        if (i11 >= 0) {
            if (i12 >= 0 && i13 >= 0) {
                bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
                bArr[0] = (byte) i14;
                bArr[1] = (byte) i11;
                bArr[2] = (byte) i12;
                bArr[3] = (byte) i13;
                com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
                com.tencent.pb.common.c.d.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
            }
        } else if (i11 == -2) {
            com_tencent_mm_plugin_multi_talk.pQ(405);
        } else if (com.tencent.pb.a.a.a.wJT) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, new byte[]{(byte) 3, (byte) 1, (byte) 6, (byte) 9}, 4);
            com.tencent.pb.common.c.d.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
        } else if (com.tencent.pb.a.a.a.wJU) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, new byte[]{(byte) 1, (byte) 2, (byte) 2, (byte) 9}, 4);
            com.tencent.pb.common.c.d.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
        }
        return 0;
    }

    public final boolean pS(int i) {
        if (a.chg().bpk()) {
            com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "switchMultiTalkVideo action: ", Integer.valueOf(i));
            f chg = a.chg();
            if (TextUtils.isEmpty(chg.mwM)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "switchMultiTalkVideo mGroupId is null");
                return false;
            }
            chg.xki = i;
            com.tencent.pb.common.c.d.d("TalkRoomService", "switchMultiTalkVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.ccQ().a(new k(chg.mwM, chg.mUm, chg.xkb, i))));
            return com.tencent.pb.common.b.e.ccQ().a(new k(chg.mwM, chg.mUm, chg.xkb, i));
        }
        com.tencent.pb.common.c.d.k("TalkRoomSdkApi", "switchMultiTalkVideo isWorking is false");
        return false;
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        int SendVideo;
        f chg = a.chg();
        if (chg.xkk != null) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "sendVideo ", Integer.valueOf(i), Integer.valueOf(i2));
            SendVideo = chg.xkk.xjC.SendVideo(bArr, s, i, i2, i3, i4);
        } else {
            SendVideo = -1;
        }
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Short.valueOf(s);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i4);
        com.tencent.pb.common.c.d.d(str, objArr);
        return SendVideo;
    }

    public final com.tencent.pb.talkroom.sdk.f s(int[] iArr) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int i = 0;
        f chg = a.chg();
        if (chg.xkk != null) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "receiveVideo");
            b bVar = chg.xkk;
            com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
            if (iArr == null) {
                com.tencent.pb.common.c.d.k("simon:TalkRoomContext", "receiveVideo imgBuffer is null");
                fVar = fVar2;
            } else {
                String str;
                String str2;
                Object[] objArr;
                fVar2.ret = bVar.xjC.videoDecode(iArr);
                fVar2.wPm = iArr;
                fVar2.wPn = bVar.xjC.field_remoteImgLength;
                fVar2.wPo = bVar.xjC.field_remoteImgWidth;
                fVar2.wPp = bVar.xjC.field_remoteImgHeight;
                fVar2.wPq = bVar.xjC.field_remoteImgChannel & 32767;
                c chs = c.chs();
                Object obj = a.chg().mwM;
                int i2 = fVar2.wPq;
                if (TextUtils.isEmpty(obj)) {
                    com.tencent.pb.common.c.d.k("TalkRoomManager", "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i2));
                } else {
                    TalkRoom Wc = chs.Wc(obj);
                    if (Wc == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "getUsrNameByMemberId talkRoom is null groupId: ", obj, " memberId: ", Integer.valueOf(i2));
                    } else {
                        for (as asVar : Wc.chp()) {
                            if (asVar != null && asVar.mOs == i2) {
                                com.tencent.pb.common.c.d.d("TalkRoomManager", "getUsrNameByMemberId wxUserName:", asVar.wNl, " groupId: ", obj, " memberId: ", Integer.valueOf(i2));
                                if (asVar.wNl != null) {
                                    str = asVar.wNl;
                                    fVar2.wPk = str;
                                    str2 = "simon:TalkRoomContext";
                                    objArr = new Object[4];
                                    objArr[0] = "receiveVideo imgBuffer size:";
                                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                    objArr[3] = fVar2;
                                    com.tencent.pb.common.c.d.d(str2, objArr);
                                    fVar = fVar2;
                                }
                            }
                        }
                    }
                }
                str = "";
                fVar2.wPk = str;
                str2 = "simon:TalkRoomContext";
                objArr = new Object[4];
                objArr[0] = "receiveVideo imgBuffer size:";
                if (iArr != null) {
                }
                objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                objArr[2] = " MultiTalkVideoDecodeInfo: ";
                objArr[3] = fVar2;
                com.tencent.pb.common.c.d.d(str2, objArr);
                fVar = fVar2;
            }
        } else {
            fVar = new com.tencent.pb.talkroom.sdk.f();
        }
        String str3 = "TalkRoomSdkApi";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = " MultiTalkVideoDecodeInfo: ";
        objArr2[3] = fVar;
        com.tencent.pb.common.c.d.d(str3, objArr2);
        return fVar;
    }

    public final g b(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        f chg = a.chg();
        g gVar = new g();
        if (chg.xkk != null) {
            b bVar = chg.xkk;
            int videoTrans = bVar.xjC.videoTrans(bArr, i, i2, i3, i4, iArr);
            gVar = new g();
            gVar.wPr = iArr;
            gVar.wPs = bVar.xjC.field_localImgWidth;
            gVar.wPt = bVar.xjC.field_localImgHeight;
            gVar.ret = videoTrans;
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), " multiTalkVideoRGBinfo: ", gVar, " engine: ", chg.xkk);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " localImg size: ";
        objArr[5] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = gVar;
        com.tencent.pb.common.c.d.d(str, objArr);
        return gVar;
    }

    public final int D(byte[] bArr, int i) {
        int i2;
        f chg = a.chg();
        if (chg.xkk == null) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "setAppCmd type: ", Integer.valueOf(10), " engine is null");
            i2 = -1;
        } else {
            i2 = chg.xkk.xjC.setAppCmd(10, bArr, i);
        }
        com.tencent.pb.common.c.d.d("TalkRoomSdkApi", "setAppCmd type: ", Integer.valueOf(10), " paramLen: ", Integer.valueOf(i), " ret: ", Integer.valueOf(i2));
        return i2;
    }
}
