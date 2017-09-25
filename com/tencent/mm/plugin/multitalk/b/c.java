package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class c extends i<b> {
    public static final String[] gUx = new String[]{i.a(b.gTP, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )"};

    public c(e eVar) {
        super(eVar, b.gTP, "MultiTalkMember", null);
    }

    public final b cV(String str, String str2) {
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "' and userName ='" + str2 + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.field_memberUuid = (long) rawQuery.getInt(0);
                    bVar.field_wxGroupId = rawQuery.getString(1);
                    bVar.field_userName = rawQuery.getString(2);
                    bVar.field_inviteUserName = rawQuery.getString(3);
                    bVar.field_memberId = rawQuery.getLong(4);
                    bVar.field_status = rawQuery.getInt(5);
                    bVar.field_createTime = rawQuery.getLong(6);
                    w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[]{Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime)});
                    if (rawQuery == null) {
                        return bVar;
                    }
                    rawQuery.close();
                    return bVar;
                }
            } catch (Exception e) {
                w.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return null;
    }

    public final LinkedList<b> Bm(String str) {
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "'", new String[0]);
        LinkedList<b> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                b bVar = new b();
                bVar.field_memberUuid = (long) rawQuery.getInt(0);
                bVar.field_wxGroupId = rawQuery.getString(1);
                bVar.field_userName = rawQuery.getString(2);
                bVar.field_inviteUserName = rawQuery.getString(3);
                bVar.field_memberId = rawQuery.getLong(4);
                bVar.field_status = rawQuery.getInt(5);
                bVar.field_createTime = rawQuery.getLong(6);
                w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[]{Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime)});
                linkedList.add(bVar);
            } catch (Exception e) {
                w.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(b bVar) {
        boolean b;
        long j = bVar.field_memberUuid;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where memberUuid = '" + j + "' and wxGroupId = '" + bVar.field_wxGroupId + "'", new String[0]);
        try {
            if (rawQuery.getCount() == 0) {
                b = b(bVar);
                w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + b + " for memberUuid = " + j);
                return b;
            }
            b = c(bVar, new String[0]);
            w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + b + " for memberUuid = " + j);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e.toString();
            w.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }

    public final boolean bv(String str, String str2) {
        w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str + ",member = " + str2);
        try {
            super.eE("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\" and userName = \"" + str2 + "\"");
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str + ",member = " + str2);
            return false;
        }
    }

    public final boolean gR(String str) {
        w.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str);
        try {
            super.eE("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\"");
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str);
            return false;
        }
    }
}
