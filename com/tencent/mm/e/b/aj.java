package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class aj extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int ggi = "unReadCount".hashCode();
    private static final int ggm = "digest".hashCode();
    private static final int ggn = "digestUser".hashCode();
    private static final int ggo = "atCount".hashCode();
    private static final int ggp = "editingMsg".hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int ggs = "msgType".hashCode();
    private static final int ggt = "msgCount".hashCode();
    private static final int glA = "hasTrunc".hashCode();
    private static final int glB = "parentRef".hashCode();
    private static final int glC = "attrflag".hashCode();
    private static final int glD = "sightTime".hashCode();
    private static final int glE = "unReadMuteCount".hashCode();
    private static final int glF = "lastSeq".hashCode();
    private static final int glG = "UnDeliverCount".hashCode();
    private static final int glH = "UnReadInvite".hashCode();
    private static final int glI = "firstUnDeliverSeq".hashCode();
    private static final int glw = "chatmode".hashCode();
    private static final int glx = "conversationTime".hashCode();
    private static final int gly = "customNotify".hashCode();
    private static final int glz = "showTips".hashCode();
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;
    private boolean gaW = false;
    private boolean gbJ = false;
    private boolean gds = false;
    private boolean gfG = false;
    private boolean gfU = false;
    private boolean gfY = false;
    private boolean gfZ = false;
    private boolean gga = false;
    private boolean ggb = false;
    private boolean ggd = false;
    private boolean gge = false;
    private boolean ggf = false;
    private boolean glj = false;
    private boolean glk = false;
    private boolean gll = false;
    public boolean glm = false;
    private boolean gln = false;
    private boolean glo = false;
    private boolean glp = false;
    public boolean glq = false;
    private boolean glr = false;
    private boolean gls = false;
    private boolean glt = false;
    private boolean glu = false;
    private boolean glv = false;

    public final void ds(int i) {
        this.field_msgCount = i;
        this.ggf = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.gds = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void dt(int i) {
        this.field_unReadCount = i;
        this.gfU = true;
    }

    public final void du(int i) {
        this.field_chatmode = i;
        this.glj = true;
    }

    public final void dv(int i) {
        this.field_status = i;
        this.gaW = true;
    }

    public final void dw(int i) {
        this.field_isSend = i;
        this.ggd = true;
    }

    public final void s(long j) {
        this.field_conversationTime = j;
        this.glk = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.gbJ = true;
    }

    public final void ct(String str) {
        this.field_msgType = str;
        this.gge = true;
    }

    public final void t(long j) {
        this.field_flag = j;
        this.gfG = true;
    }

    public final void cu(String str) {
        this.field_digest = str;
        this.gfY = true;
    }

    public final void cv(String str) {
        this.field_digestUser = str;
        this.gfZ = true;
    }

    public final void dx(int i) {
        this.field_hasTrunc = i;
        this.gln = true;
    }

    public final void cw(String str) {
        this.field_parentRef = str;
        this.glo = true;
    }

    public final void dy(int i) {
        this.field_attrflag = i;
        this.glp = true;
    }

    public final void cx(String str) {
        this.field_editingMsg = str;
        this.ggb = true;
    }

    public final void dz(int i) {
        this.field_atCount = i;
        this.gga = true;
    }

    public final void dA(int i) {
        this.field_unReadMuteCount = i;
        this.glr = true;
    }

    public final void u(long j) {
        this.field_lastSeq = j;
        this.gls = true;
    }

    public final long pE() {
        return this.field_lastSeq;
    }

    public final void dB(int i) {
        this.field_UnDeliverCount = i;
        this.glt = true;
    }

    public final int pF() {
        return this.field_UnDeliverCount;
    }

    public final void dC(int i) {
        this.field_UnReadInvite = i;
        this.glu = true;
    }

    public final void v(long j) {
        this.field_firstUnDeliverSeq = j;
        this.glv = true;
    }

    public final long pG() {
        return this.field_firstUnDeliverSeq;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggt == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (ggi == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (glw == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (glx == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ggs == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (gly == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (glz == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (ggm == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (ggn == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (glA == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (glB == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (glC == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (ggp == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (ggo == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (glD == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (glE == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (glF == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (glG == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (glH == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (glI == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.ggf) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gfU) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.glj) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ggd) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.glk) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.gge) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.gll) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.glm) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.gfG) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.gfY) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.gfZ) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.gln) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.glo) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.glp) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.ggb) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.gga) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.glq) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.glr) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.gls) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.glt) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.glu) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.glv) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
