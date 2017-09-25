package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class ba extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcb = "sourceType".hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int gfC = "xml".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int glS = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gpD = "localSeq".hashCode();
    private static final int gpE = "updateSeq".hashCode();
    private static final int gpF = "sourceId".hashCode();
    private static final int gpG = "itemStatus".hashCode();
    private static final int gpH = "sourceCreateTime".hashCode();
    private static final int gpI = "fromUser".hashCode();
    private static final int gpJ = "toUser".hashCode();
    private static final int gpK = "realChatName".hashCode();
    private static final int gpL = "favProto".hashCode();
    private static final int gpM = "ext".hashCode();
    private static final int gpN = "edittime".hashCode();
    private static final int gpO = "tagProto".hashCode();
    private static final int gpP = "sessionId".hashCode();
    private static final int gpQ = "datatotalsize".hashCode();
    private static final int gpn = "localId".hashCode();
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public rv field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public sd field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;
    private boolean gbE = true;
    private boolean gbF = true;
    private boolean gdn = true;
    private boolean gfG = true;
    private boolean gfy = true;
    private boolean glP = true;
    private boolean gpA = true;
    private boolean gpB = true;
    private boolean gpC = true;
    private boolean gpl = true;
    private boolean gpp = true;
    private boolean gpq = true;
    private boolean gpr = true;
    private boolean gps = true;
    private boolean gpt = true;
    private boolean gpu = true;
    private boolean gpv = true;
    private boolean gpw = true;
    private boolean gpx = true;
    private boolean gpy = true;
    private boolean gpz = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "localId";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.uxd.put(SlookAirButtonFrequentContactAdapter.ID, "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "localSeq";
        aVar.uxd.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "updateSeq";
        aVar.uxd.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "flag";
        aVar.uxd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "sourceId";
        aVar.uxd.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "itemStatus";
        aVar.uxd.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.uxd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "sourceCreateTime";
        aVar.uxd.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "fromUser";
        aVar.uxd.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "toUser";
        aVar.uxd.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "realChatName";
        aVar.uxd.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "favProto";
        aVar.uxd.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "xml";
        aVar.uxd.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "ext";
        aVar.uxd.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "edittime";
        aVar.uxd.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "tagProto";
        aVar.uxd.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[19] = "sessionId";
        aVar.uxd.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "datatotalsize";
        aVar.uxd.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.columns[21] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpn == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gpl = true;
                } else if (glS == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gpD == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (gpE == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gpF == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (gpG == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (gcb == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (gpH == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gpI == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (gpJ == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gpK == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (gpL == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_favProto = (rv) new rv().aD(r0);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (gfC == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (gpM == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (gpN == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (gpO == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_tagProto = (sd) new sd().aD(r0);
                        }
                    } catch (IOException e2) {
                        w.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (gpP == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (gpQ == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpl) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.glP) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gpp) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.gpq) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.gpr) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.gps) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.gbF) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.gpt) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gpu) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.gpv) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gpw) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.gpx && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.gfy) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.gpy) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.gpz) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.gpA && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                w.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.gpB) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.gpC) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
