package com.tencent.mm.plugin.record.a;

public final class b {
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;

    public final boolean isFinished() {
        return this.field_status == 3;
    }
}
