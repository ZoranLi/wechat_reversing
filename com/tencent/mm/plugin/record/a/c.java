package com.tencent.mm.plugin.record.a;

import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.sd;

public final class c {
    public long field_edittime;
    public rv field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public sd field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;

    public final boolean ati() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean atj() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean atk() {
        return this.field_itemStatus == 7;
    }

    public final boolean atl() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }
}
