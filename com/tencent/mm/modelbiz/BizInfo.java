package com.tencent.mm.modelbiz;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BizInfo extends y {
    protected static com.tencent.mm.sdk.e.c.a gTP;
    public static int hup = 1;
    public static int huq = 0;
    public static int hur = 1;
    private static int huu = 0;
    private static ExtInfo huv = null;
    private List<a> hus;
    public ExtInfo hut;

    public static class ExtInfo {
        public boolean huA = false;
        public boolean huB = false;
        private String huC;
        private String huD;
        private List<e> huE = null;
        private c huF = null;
        private b huG = null;
        private d huH = null;
        public a huI = null;
        private boolean huJ = false;
        boolean huK = false;
        int huL;
        public boolean huM = false;
        public int huN = 0;
        private int huO = 0;
        private String huP;
        private a huQ = null;
        private int huR = 0;
        private int huS = BizInfo.huq;
        private String huT;
        private boolean huU = false;
        public int huV;
        private f huW;
        private String huX;
        private String huY;
        private boolean huZ = false;
        public JSONObject hux = null;
        private boolean huy = true;
        public boolean huz = false;
        private List<WxaEntryInfo> hva;

        public static class WxaEntryInfo implements Parcelable {
            public static final Creator<WxaEntryInfo> CREATOR = new Creator<WxaEntryInfo>() {
                public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r1 = this;
                    r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo;
                    r0.<init>(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.1.createFromParcel(android.os.Parcel):java.lang.Object");
                }

                public final /* bridge */ /* synthetic */ java.lang.Object[] newArray(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r1 = this;
                    r0 = new com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo[r2];
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.1.newArray(int):java.lang.Object[]");
                }
            };
            public String hvx;
            public String iconUrl;
            public String title;
            public String username;

            protected WxaEntryInfo(android.os.Parcel r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = r2.readString();
                r1.username = r0;
                r0 = r2.readString();
                r1.title = r0;
                r0 = r2.readString();
                r1.hvx = r0;
                r0 = r2.readString();
                r1.iconUrl = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.<init>(android.os.Parcel):void");
            }

            public void writeToParcel(android.os.Parcel r2, int r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r0 = r1.username;
                r2.writeString(r0);
                r0 = r1.title;
                r2.writeString(r0);
                r0 = r1.hvx;
                r2.writeString(r0);
                r0 = r1.iconUrl;
                r2.writeString(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.writeToParcel(android.os.Parcel, int):void");
            }

            public int describeContents() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.describeContents():int");
            }
        }

        public static class a {
            public int hvb;
            public int hvc;
            public int hvd;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.a hI(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "HardwareBizInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$a;
                r0.<init>();
                if (r6 == 0) goto L_0x0023;
            L_0x001d:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0024;
            L_0x0023:
                return r0;
            L_0x0024:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0045 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0045 }
                r2 = "hardware_flag";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hvb = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "connect_status_display_mode";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hvc = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "special_internal_brand_type";	 Catch:{ JSONException -> 0x0045 }
                r1 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hvd = r1;	 Catch:{ JSONException -> 0x0045 }
                goto L_0x0023;
            L_0x0045:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                goto L_0x0023;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.hI(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$a");
            }

            public final boolean Dj() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r0 = r1.hvb;
                r0 = r0 & 1;
                if (r0 <= 0) goto L_0x0008;
            L_0x0006:
                r0 = 1;
            L_0x0007:
                return r0;
            L_0x0008:
                r0 = 0;
                goto L_0x0007;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.Dj():boolean");
            }
        }

        public static class b {
            public int hve;
            public List<i> hvf = null;
            public int type;

            public static class a {
                public long appid = 0;
                public String hvg;
                public String hvh;
                public int hvi;
                public String hvj;
                public String hvk;

                public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a hK(java.lang.String r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r0 = "MicroMsg.BizInfo";
                    r1 = new java.lang.StringBuilder;
                    r2 = "EnterpriseBizInfo = ";
                    r1.<init>(r2);
                    r1 = r1.append(r6);
                    r1 = r1.toString();
                    com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                    r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a;
                    r0.<init>();
                    if (r6 == 0) goto L_0x0023;
                L_0x001d:
                    r1 = r6.length();
                    if (r1 > 0) goto L_0x0024;
                L_0x0023:
                    return r0;
                L_0x0024:
                    r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r1.<init>(r6);	 Catch:{ JSONException -> 0x005e }
                    r2 = "belong";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hvg = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "freeze_wording";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hvh = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "child_type";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hvi = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "home_url";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hvj = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "exattr";	 Catch:{ JSONException -> 0x005e }
                    r1 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);	 Catch:{ JSONException -> 0x005e }
                    if (r2 == 0) goto L_0x0073;	 Catch:{ JSONException -> 0x005e }
                L_0x005a:
                    r1 = 0;	 Catch:{ JSONException -> 0x005e }
                    r0.hvk = r1;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                L_0x005e:
                    r1 = move-exception;
                    r2 = "MicroMsg.BizInfo";
                    r3 = "exception:%s";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];
                    r5 = 0;
                    r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                    r4[r5] = r1;
                    com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                    goto L_0x0023;
                L_0x0073:
                    r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r2.<init>(r1);	 Catch:{ JSONException -> 0x005e }
                    r1 = "chat_extension_url";	 Catch:{ JSONException -> 0x005e }
                    r1 = r2.optString(r1);	 Catch:{ JSONException -> 0x005e }
                    r0.hvk = r1;	 Catch:{ JSONException -> 0x005e }
                    r1 = "app_id";	 Catch:{ JSONException -> 0x005e }
                    r2 = r2.optLong(r1);	 Catch:{ JSONException -> 0x005e }
                    r0.appid = r2;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.hK(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a");
                }
            }

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.b hJ(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r5 = 0;
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "MenuInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b;
                r0.<init>();
                if (r6 == 0) goto L_0x0024;
            L_0x001e:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0025;
            L_0x0024:
                return r0;
            L_0x0025:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x004b }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x004b }
                r2 = "update_time";	 Catch:{ JSONException -> 0x004b }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x004b }
                r0.hve = r2;	 Catch:{ JSONException -> 0x004b }
                r2 = "type";	 Catch:{ JSONException -> 0x004b }
                r3 = 0;	 Catch:{ JSONException -> 0x004b }
                r2 = r1.optInt(r2, r3);	 Catch:{ JSONException -> 0x004b }
                r0.type = r2;	 Catch:{ JSONException -> 0x004b }
                r2 = "button_list";	 Catch:{ JSONException -> 0x004b }
                r1 = r1.optJSONArray(r2);	 Catch:{ JSONException -> 0x004b }
                r1 = com.tencent.mm.modelbiz.i.c(r1);	 Catch:{ JSONException -> 0x004b }
                r0.hvf = r1;	 Catch:{ JSONException -> 0x004b }
                goto L_0x0024;
            L_0x004b:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                goto L_0x0024;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.hJ(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$b");
            }
        }

        public static class c {
            public int hvl = 0;
            public String hvm;
            public String hvn;
            public String hvo;
            public String hvp;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.c hL(java.lang.String r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r6 = 1;
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
                if (r0 == 0) goto L_0x000a;
            L_0x0008:
                r0 = 0;
            L_0x0009:
                return r0;
            L_0x000a:
                r0 = "MicroMsg.BizInfo";
                r1 = "biz verify info is [%s]";
                r2 = new java.lang.Object[r6];
                r2[r5] = r7;
                com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$c;
                r0.<init>();
                r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071 }
                r1.<init>(r7);	 Catch:{ Exception -> 0x0071 }
                r2 = "Type";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optInt(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hvl = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Description";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hvm = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Name";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hvn = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "IntroUrl";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hvo = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "VerifySubTitle";	 Catch:{ Exception -> 0x0071 }
                r1 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hvp = r1;	 Catch:{ Exception -> 0x0071 }
            L_0x004e:
                r1 = "MicroMsg.BizInfo";
                r2 = "type[%d],desc[%s],name[%s],url[%s]";
                r3 = 4;
                r3 = new java.lang.Object[r3];
                r4 = r0.hvl;
                r4 = java.lang.Integer.valueOf(r4);
                r3[r5] = r4;
                r4 = r0.hvm;
                r3[r6] = r4;
                r4 = 2;
                r5 = r0.hvn;
                r3[r4] = r5;
                r4 = 3;
                r5 = r0.hvo;
                r3[r4] = r5;
                com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
                goto L_0x0009;
            L_0x0071:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r6];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                goto L_0x004e;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.c.hL(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$c");
            }
        }

        public static class d {
            public int hvq;
            public String hvr;
            public List<String> hvs;
            public String hvt;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.d hM(java.lang.String r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r0 = 0;
                r3 = 0;
                r1 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
                if (r1 == 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r1 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$d;	 Catch:{ Exception -> 0x005c }
                r1.<init>();	 Catch:{ Exception -> 0x005c }
                r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x005c }
                r2.<init>(r8);	 Catch:{ Exception -> 0x005c }
                r4 = "reputation_level";	 Catch:{ Exception -> 0x005c }
                r5 = -1;	 Catch:{ Exception -> 0x005c }
                r4 = r2.optInt(r4, r5);	 Catch:{ Exception -> 0x005c }
                r1.hvq = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "scope_of_business";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.hvr = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_detail_h5_url";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.hvt = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_info";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optJSONArray(r4);	 Catch:{ Exception -> 0x005c }
                if (r4 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0038:
                r5 = r4.length();	 Catch:{ Exception -> 0x005c }
                if (r5 <= 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x003e:
                r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x005c }
                r2.<init>();	 Catch:{ Exception -> 0x005c }
                r1.hvs = r2;	 Catch:{ Exception -> 0x005c }
                r2 = r3;	 Catch:{ Exception -> 0x005c }
            L_0x0046:
                if (r2 >= r5) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0048:
                r6 = r4.getString(r2);	 Catch:{ Exception -> 0x005c }
                r7 = com.tencent.mm.sdk.platformtools.bg.mA(r6);	 Catch:{ Exception -> 0x005c }
                if (r7 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x005c }
            L_0x0052:
                r7 = r1.hvs;	 Catch:{ Exception -> 0x005c }
                r7.add(r6);	 Catch:{ Exception -> 0x005c }
            L_0x0057:
                r2 = r2 + 1;
                goto L_0x0046;
            L_0x005a:
                r0 = r1;
                goto L_0x0008;
            L_0x005c:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r5[r3] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.d.hM(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$d");
            }
        }

        public static class e {
            public String description;
            public String hvu;
            public String iconUrl;

            public static java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.e> b(org.json.JSONArray r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r2 = 0;
                r0 = new java.util.LinkedList;
                r0.<init>();
                if (r7 != 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r3 = r7.length();	 Catch:{ Exception -> 0x003a }
                r1 = r2;	 Catch:{ Exception -> 0x003a }
            L_0x000e:
                if (r1 >= r3) goto L_0x0008;	 Catch:{ Exception -> 0x003a }
            L_0x0010:
                r4 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$e;	 Catch:{ Exception -> 0x003a }
                r4.<init>();	 Catch:{ Exception -> 0x003a }
                r5 = r7.optJSONObject(r1);	 Catch:{ Exception -> 0x003a }
                r6 = "icon";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.iconUrl = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.description = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description_key";	 Catch:{ Exception -> 0x003a }
                r5 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.hvu = r5;	 Catch:{ Exception -> 0x003a }
                r0.add(r4);	 Catch:{ Exception -> 0x003a }
                r1 = r1 + 1;
                goto L_0x000e;
            L_0x003a:
                r1 = move-exception;
                r3 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r5[r2] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.e.b(org.json.JSONArray):java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$e>");
            }
        }

        public static class f {
            public String hvv;
            public String hvw;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.f hN(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r4 = 1;
                r5 = 0;
                r0 = "MicroMsg.BizInfo";
                r1 = "RegisterSource = %s";
                r2 = new java.lang.Object[r4];
                r2[r5] = r6;
                com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$f;
                r0.<init>();
                if (r6 == 0) goto L_0x001c;
            L_0x0016:
                r1 = r6.length();
                if (r1 > 0) goto L_0x001d;
            L_0x001c:
                return r0;
            L_0x001d:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0035 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0035 }
                r2 = "RegisterBody";	 Catch:{ JSONException -> 0x0035 }
                r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x0035 }
                r0.hvv = r2;	 Catch:{ JSONException -> 0x0035 }
                r2 = "IntroUrl";	 Catch:{ JSONException -> 0x0035 }
                r1 = r1.optString(r2);	 Catch:{ JSONException -> 0x0035 }
                r0.hvw = r1;	 Catch:{ JSONException -> 0x0035 }
                goto L_0x001c;
            L_0x0035:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception in RegisterSource:%s";
                r4 = new java.lang.Object[r4];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                goto L_0x001c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.f.hN(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$f");
            }
        }

        public final java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo> CQ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r7 = this;
            r0 = 0;
            r1 = r7.hva;
            if (r1 != 0) goto L_0x0083;
        L_0x0005:
            r1 = new java.util.LinkedList;
            r1.<init>();
            r7.hva = r1;
            r1 = r7.hux;
            if (r1 == 0) goto L_0x0083;
        L_0x0010:
            r1 = r7.hux;
            r2 = "BindWxaInfo";
            r2 = r1.optString(r2);
            r1 = android.text.TextUtils.isEmpty(r2);
            if (r1 != 0) goto L_0x0081;
        L_0x001f:
            r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
            r1.<init>(r2);	 Catch:{ JSONException -> 0x0080 }
        L_0x0024:
            if (r1 == 0) goto L_0x0086;
        L_0x0026:
            r0 = "wxaEntryInfo";
            r0 = r1.optJSONArray(r0);
            r1 = r0;
        L_0x002e:
            if (r1 == 0) goto L_0x0083;
        L_0x0030:
            r0 = 0;
        L_0x0031:
            r2 = r1.length();
            if (r0 >= r2) goto L_0x0083;
        L_0x0037:
            r2 = r1.optJSONObject(r0);
            if (r2 == 0) goto L_0x007d;
        L_0x003d:
            r3 = "username";
            r3 = r2.optString(r3);
            r4 = "title";
            r4 = r2.optString(r4);
            r5 = "title_key";
            r5 = r2.optString(r5);
            r6 = "icon_url";
            r2 = r2.optString(r6);
            r6 = android.text.TextUtils.isEmpty(r3);
            if (r6 != 0) goto L_0x007d;
        L_0x005f:
            r6 = android.text.TextUtils.isEmpty(r4);
            if (r6 == 0) goto L_0x006b;
        L_0x0065:
            r6 = android.text.TextUtils.isEmpty(r5);
            if (r6 != 0) goto L_0x007d;
        L_0x006b:
            r6 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo;
            r6.<init>();
            r6.username = r3;
            r6.title = r4;
            r6.hvx = r5;
            r6.iconUrl = r2;
            r2 = r7.hva;
            r2.add(r6);
        L_0x007d:
            r0 = r0 + 1;
            goto L_0x0031;
        L_0x0080:
            r1 = move-exception;
        L_0x0081:
            r1 = r0;
            goto L_0x0024;
        L_0x0083:
            r0 = r7.hva;
            return r0;
        L_0x0086:
            r1 = r0;
            goto L_0x002e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CQ():java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo>");
        }

        public final boolean CR() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r2 = 1;
            r0 = r3.hux;
            if (r0 == 0) goto L_0x0024;
        L_0x0005:
            r0 = r3.hux;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            if (r0 == 0) goto L_0x0024;
        L_0x0010:
            r0 = r3.hux;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            r1 = "IsWXWiFi";
            r0 = r0.optInt(r1);
            if (r0 != r2) goto L_0x0024;
        L_0x0022:
            r3.huZ = r2;
        L_0x0024:
            r0 = r3.huZ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CR():boolean");
        }

        public final boolean CS() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0015;
        L_0x0004:
            r0 = r2.hux;
            r1 = "NotifyManage";
            r0 = r0.optString(r1);
            r1 = com.tencent.mm.modelbiz.BizInfo.huq;
            r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r1);
            r2.huS = r0;
        L_0x0015:
            r0 = r2.huS;
            r1 = com.tencent.mm.modelbiz.BizInfo.hup;
            if (r0 != r1) goto L_0x001d;
        L_0x001b:
            r0 = 1;
        L_0x001c:
            return r0;
        L_0x001d:
            r0 = 0;
            goto L_0x001c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CS():boolean");
        }

        public final java.lang.String CT() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "VerifyContactPromptTitle";
            r0 = r0.optString(r1);
            r2.huC = r0;
        L_0x000f:
            r0 = r2.huC;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CT():java.lang.String");
        }

        public final java.lang.String CU() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "TrademarkUrl";
            r0 = r0.optString(r1);
            r2.huX = r0;
        L_0x000f:
            r0 = r2.huX;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CU():java.lang.String");
        }

        public final java.lang.String CV() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "TrademarkName";
            r0 = r0.optString(r1);
            r2.huY = r0;
        L_0x000f:
            r0 = r2.huY;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CV():java.lang.String");
        }

        public final java.lang.String CW() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "ConferenceContactExpireTime";
            r0 = r0.optString(r1);
            r2.huD = r0;
        L_0x000f:
            r0 = r2.huD;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CW():java.lang.String");
        }

        public final java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.e> CX() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.huE;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hux;
            r1 = "Privilege";
            r0 = r0.optJSONArray(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.e.b(r0);
            r2.huE = r0;
        L_0x0017:
            r0 = r2.huE;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CX():java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$e>");
        }

        public final int CY() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "InteractiveMode";
            r0 = r0.optInt(r1);
            r2.huR = r0;
        L_0x000f:
            r0 = r2.huR;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CY():int");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.d CZ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.huH;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hux;
            r1 = "PayShowInfo";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.d.hM(r0);
            r2.huH = r0;
        L_0x0017:
            r0 = r2.huH;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CZ():com.tencent.mm.modelbiz.BizInfo$ExtInfo$d");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.a Da() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.huQ;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hux;
            r1 = "HardwareBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.hI(r0);
            r2.huQ = r0;
        L_0x0019:
            r0 = r2.huQ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Da():com.tencent.mm.modelbiz.BizInfo$ExtInfo$a");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.c Db() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.huF;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hux;
            r1 = "VerifySource";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.c.hL(r0);
            r2.huF = r0;
        L_0x0017:
            r0 = r2.huF;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Db():com.tencent.mm.modelbiz.BizInfo$ExtInfo$c");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.f Dc() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.huW;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hux;
            r1 = "RegisterSource";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.f.hN(r0);
            r2.huW = r0;
        L_0x0019:
            r0 = r2.huW;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Dc():com.tencent.mm.modelbiz.BizInfo$ExtInfo$f");
        }

        public final boolean CD() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = r3.hux;
            if (r1 == 0) goto L_0x0017;
        L_0x0005:
            r1 = r3.hux;
            r2 = "ReportLocationType";
            r1 = r1.optString(r2);
            r1 = com.tencent.mm.sdk.platformtools.bg.getInt(r1, r0);
            if (r1 <= 0) goto L_0x0015;
        L_0x0014:
            r0 = 1;
        L_0x0015:
            r3.huJ = r0;
        L_0x0017:
            r0 = r3.huJ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CD():boolean");
        }

        public final boolean Dd() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            r2 = r4.hux;
            if (r2 == 0) goto L_0x0017;
        L_0x0006:
            r2 = r4.hux;
            r3 = "IsTrademarkProtection";
            r2 = r2.optString(r3);
            r2 = com.tencent.mm.sdk.platformtools.bg.getInt(r2, r1);
            if (r2 != r0) goto L_0x001a;
        L_0x0015:
            r4.huU = r0;
        L_0x0017:
            r0 = r4.huU;
            return r0;
        L_0x001a:
            r0 = r1;
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Dd():boolean");
        }

        public final int De() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.hux;
            if (r0 == 0) goto L_0x0010;
        L_0x0004:
            r0 = r3.hux;
            r1 = "ServiceType";
            r2 = 0;
            r0 = r0.optInt(r1, r2);
            r3.huO = r0;
        L_0x0010:
            r0 = r3.huO;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.De():int");
        }

        public final java.lang.String Df() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "SupportEmoticonLinkPrefix";
            r0 = r0.optString(r1);
            r2.huP = r0;
        L_0x000f:
            r0 = r2.huP;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Df():java.lang.String");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.b Dg() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.huG;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hux;
            r1 = "MMBizMenu";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.hJ(r0);
            r2.huG = r0;
        L_0x0019:
            r0 = r2.huG;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Dg():com.tencent.mm.modelbiz.BizInfo$ExtInfo$b");
        }

        public final java.lang.String Dh() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hux;
            r1 = "ServicePhone";
            r0 = r0.optString(r1);
            r2.huT = r0;
        L_0x000f:
            r0 = r2.huT;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Dh():java.lang.String");
        }

        private ExtInfo() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r2 = 0;
            r1 = 0;
            r3.<init>();
            r3.hux = r2;
            r0 = 1;
            r3.huy = r0;
            r3.huz = r1;
            r3.huA = r1;
            r3.huB = r1;
            r3.huE = r2;
            r3.huF = r2;
            r3.huG = r2;
            r3.huH = r2;
            r3.huI = r2;
            r3.huJ = r1;
            r3.huK = r1;
            r3.huM = r1;
            r3.huN = r1;
            r3.huO = r1;
            r3.huQ = r2;
            r3.huR = r1;
            r0 = com.tencent.mm.modelbiz.BizInfo.huq;
            r3.huS = r0;
            r3.huU = r1;
            r3.huZ = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.<init>():void");
        }

        public static com.tencent.mm.modelbiz.BizInfo.ExtInfo hH(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo;
            r0.<init>();
            r1 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
            if (r1 == 0) goto L_0x000c;
        L_0x000b:
            return r0;
        L_0x000c:
            java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0017 }
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0017 }
            r1.<init>(r6);	 Catch:{ Exception -> 0x0017 }
            r0.hux = r1;	 Catch:{ Exception -> 0x0017 }
            goto L_0x000b;
        L_0x0017:
            r1 = move-exception;
            r2 = "MicroMsg.BizInfo";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
            r4[r5] = r1;
            com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
            goto L_0x000b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.hH(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a Di() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.hux;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.huI;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hux;
            r1 = "EnterpriseBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.hK(r0);
            r2.huI = r0;
        L_0x0019:
            r0 = r2.huI;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Di():com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a");
        }
    }

    public static class a {
        public String description;
        public String huw;
        public String title;
        public String url;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.uxd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "username";
        aVar.columns[1] = "brandList";
        aVar.uxd.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandListVersion";
        aVar.uxd.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandListContent";
        aVar.uxd.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandFlag";
        aVar.uxd.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "extInfo";
        aVar.uxd.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "brandInfo";
        aVar.uxd.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "brandIconURL";
        aVar.uxd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "hadAlert";
        aVar.uxd.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "acceptType";
        aVar.uxd.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "enterpriseFather";
        aVar.uxd.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "kfWorkerId";
        aVar.uxd.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "specialType";
        aVar.uxd.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrSyncVersion";
        aVar.uxd.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "incrementUpdateTime";
        aVar.uxd.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "bitFlag";
        aVar.uxd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[19] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final ExtInfo bd(boolean z) {
        if (this.hut == null || z) {
            System.currentTimeMillis();
            if (bg.mA(this.field_extInfo) || huu != this.field_extInfo.hashCode()) {
                ExtInfo hH = ExtInfo.hH(this.field_extInfo);
                this.hut = hH;
                huv = hH;
                huu = bg.mz(this.field_extInfo).hashCode();
            } else {
                this.hut = huv;
            }
        }
        return this.hut;
    }

    public final boolean Cz() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean CA() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean CB() {
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime >= instance.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public final void CC() {
        bd(false);
        ExtInfo extInfo = this.hut;
        if (extInfo.hux != null) {
            extInfo.huL = extInfo.hux.optInt("ConnectorMsgType");
        }
        this.field_acceptType = extInfo.huL;
        this.field_type = bd(false).De();
        if (CJ()) {
            fv(1);
        } else {
            this.field_bitFlag &= -2;
        }
    }

    public final boolean CD() {
        bd(false);
        w.i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.hut.CD()));
        return this.hut.CD();
    }

    public final boolean CE() {
        bd(false);
        if (this.field_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean CF() {
        bd(false);
        if (this.field_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean CG() {
        bd(false);
        if (this.field_type == 2 || this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean CH() {
        bd(false);
        if (this.field_type == 2) {
            return true;
        }
        return false;
    }

    public final boolean CI() {
        bd(false);
        if (this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean CJ() {
        bd(false);
        if (this.hut == null || this.hut.Di() == null) {
            return false;
        }
        boolean z = this.hut.huI.hvi == 1;
        if (z && !fu(1)) {
            fv(1);
            w.DH().e(this);
        }
        if (!z) {
            return z;
        }
        w.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
        return z;
    }

    public final boolean CK() {
        bd(false);
        if (this.hut == null || this.hut.Di() == null) {
            return false;
        }
        boolean z = this.hut.huI.hvi == 2;
        if (z && !fu(2)) {
            fv(2);
            w.DH().e(this);
        }
        if (!z) {
            return z;
        }
        w.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
        return z;
    }

    public final String CL() {
        bd(false);
        if (this.hut != null) {
            a Di = this.hut.Di();
            if (!(Di == null || Di.hvj == null || Di.hvj.isEmpty())) {
                return Di.hvj;
            }
        }
        return null;
    }

    public final long CM() {
        bd(false);
        if (this.hut == null) {
            return 0;
        }
        a Di = this.hut.Di();
        if (Di == null || Di.appid == 0) {
            return 0;
        }
        return Di.appid;
    }

    public final String CN() {
        bd(false);
        if (this.hut != null) {
            a Di = this.hut.Di();
            if (Di != null) {
                return Di.hvk;
            }
        }
        return null;
    }

    public final String CO() {
        String str = bd(false).Di().hvg;
        if (bg.mA(str)) {
            w.e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        return str;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }

    public final ContentValues pv() {
        return super.pv();
    }

    public final List<a> CP() {
        if (this.hus != null) {
            return this.hus;
        }
        this.hus = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            return this.hus;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.huw = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.hus.add(aVar);
            }
        } catch (Throwable e) {
            w.e("MicroMsg.BizInfo", "exception:%s", bg.g(e));
        }
        return this.hus;
    }

    private boolean fu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void fv(int i) {
        this.field_bitFlag |= i;
    }
}
