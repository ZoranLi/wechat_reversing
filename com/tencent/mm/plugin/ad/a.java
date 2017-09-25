package com.tencent.mm.plugin.ad;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;

public final class a extends ContentObserver {
    private boolean htv = false;
    private Context mContext;
    private boolean pyA = false;
    private boolean pyB = false;
    public a pyC;
    private long pyD = 0;
    public String[] pyE;
    private ContentResolver pyz;

    public interface a {
        void pl(String str);
    }

    public a(Context context) {
        super(ae.fetchFreeHandler());
        this.mContext = context;
    }

    public final void start() {
        this.pyA = false;
        this.pyB = false;
        this.htv = false;
        boolean a = com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
        w.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this.mContext});
        try {
            long j;
            Uri parse = Uri.parse("content://sms/inbox");
            this.pyz = this.mContext.getContentResolver();
            String str = "( ";
            if (this.pyE != null) {
                int i = 0;
                while (i < this.pyE.length) {
                    String str2 = i == this.pyE.length + -1 ? str + " body like \"%" + this.pyE[i] + "%\" ) " : str + "body like \"%" + this.pyE[i] + "%\" or ";
                    i++;
                    str = str2;
                }
                w.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
            } else {
                str = "";
            }
            Cursor query = this.pyz.query(parse, new String[]{FFmpegMetadataRetriever.METADATA_KEY_DATE}, str, null, "date desc limit 1");
            if (query == null || query.getCount() <= 0) {
                j = 0;
            } else {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                query.close();
            }
            this.pyD = j;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    public final void stop() {
        if (this.mContext != null) {
            try {
                this.mContext.getContentResolver().unregisterContentObserver(this);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
            }
        }
        this.htv = true;
    }

    public final void onChange(boolean z) {
        String str = null;
        super.onChange(z);
        try {
            if (!this.pyA && !this.htv && !this.pyB) {
                Uri parse = Uri.parse("content://sms/inbox");
                this.pyz = this.mContext.getContentResolver();
                String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
                String str2 = "( ";
                if (this.pyE != null) {
                    int i = 0;
                    while (i < this.pyE.length) {
                        str2 = i == this.pyE.length + -1 ? str2 + " body like \"%" + this.pyE[i] + "%\" ) " : str2 + "body like \"%" + this.pyE[i] + "%\" or ";
                        i++;
                    }
                    str = str2 + " and date > " + this.pyD + " ";
                    w.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
                }
                if (str != null && !str.equals("")) {
                    Cursor query = this.pyz.query(parse, strArr, str, null, "date desc");
                    if (query != null) {
                        int i2 = -1;
                        long j = 0;
                        while (query.moveToNext()) {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        }
                        if (i2 >= 0) {
                            query.moveToPosition(i2);
                            str2 = am(0, query.getString(query.getColumnIndex("body")));
                            if (!bg.mA(str2) && str2.length() == 6) {
                                if (this.pyC != null) {
                                    this.pyC.pl(str2);
                                }
                                this.pyB = true;
                            }
                        }
                        query.close();
                    }
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    private String am(int i, String str) {
        while (i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            int i2 = i + 1;
            while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            String substring = str.substring(i, i2);
            w.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + substring);
            if (substring.length() == 6) {
                return substring;
            }
            i = i2 + 1;
        }
        return null;
    }
}
