package com.tencent.wecall.talkroom.model;

import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.c.i;

public final class d {
    private String qIB;
    as xjI;
    private at xjJ;

    public d(as asVar) {
        a(asVar);
    }

    public d(as asVar, at atVar) {
        a(asVar);
        if (atVar == null) {
            com.tencent.pb.common.c.d.k("tagorewang:TalkRoomMember", "set null profile");
            return;
        }
        this.xjJ = atVar;
    }

    public final void a(as asVar) {
        if (asVar == null) {
            com.tencent.pb.common.c.d.k("tagorewang:TalkRoomMember", "set null info");
            return;
        }
        this.xjI = asVar;
    }

    public final String chu() {
        if (this.xjI != null) {
            return this.xjI.wNl;
        }
        return "";
    }

    public final String getDisplayName() {
        try {
            String str = this.qIB;
            if (str == null || str.trim().length() == 0) {
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                i = c >= '¡' ? i + 2 : i + 1;
            }
            if (i <= 10) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                i = toCharArray[i2] >= '¡' ? i + 2 : i + 1;
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder.append(toCharArray[i2]);
            }
            stringBuilder.append('…');
            return stringBuilder.toString();
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("tagorewang:TalkRoomMember", "getDisplayName err: ", e);
            return this.qIB;
        }
    }

    public final int getState() {
        if (this.xjI == null) {
            return 0;
        }
        return this.xjI.status;
    }

    public final int chv() {
        if (this.xjI == null) {
            return -1;
        }
        return this.xjI.mOs;
    }

    public final String toString() {
        int i = 0;
        if (this.xjI != null) {
            i = this.xjI.taQ;
        } else if (this.xjJ != null) {
            i = this.xjJ.taQ;
        }
        if (this.xjI == null || this.xjJ == null) {
            return "invlaid TalkRoomMember which uuid is " + i;
        }
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        as asVar = this.xjI;
        if (asVar == null) {
            str = "null";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(asVar.taQ);
            stringBuilder.append(" openClientId:").append(asVar.wOi);
            stringBuilder.append(" invite uuid: ").append(asVar.wOe);
            stringBuilder.append(" member id:").append(asVar.mOs);
            stringBuilder.append(" status: ").append(asVar.status);
            stringBuilder.append(" reason: ").append(asVar.fOl);
            str = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(str).append(" ");
        at atVar = this.xjJ;
        if (atVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(atVar.taQ);
            stringBuilder3.append(" user name: ").append(atVar.username);
            stringBuilder3.append(" head url: ").append(atVar.oMt);
            str = stringBuilder3.toString();
        }
        stringBuilder.append(str);
        return stringBuilder2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return i.equals(chu(), ((d) obj).chu());
    }

    public final int hashCode() {
        String chu = chu();
        return chu == null ? 0 : chu.hashCode();
    }

    public final boolean chw() {
        return i.equals(a.cdm(), chu());
    }
}
