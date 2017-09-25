package com.tencent.mm.ui.account;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j extends ContentObserver {
    private final Context context;
    private Pattern mlF = Pattern.compile("\\d{4,8}");
    private final String[] pyE;
    private ContentResolver pyz;
    private final a vcc;

    public interface a {
        void SP(String str);

        void bQX();
    }

    public j(Context context, a aVar) {
        super(ae.fetchFreeHandler());
        if (context == null || aVar == null) {
            throw new NullPointerException("SmsContentObserver Construction");
        }
        this.context = context;
        this.pyE = context.getResources().getStringArray(R.c.aSp);
        this.vcc = aVar;
    }

    public final void bRk() {
        this.context.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
    }

    public final void bRl() {
        this.context.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.context instanceof Activity) {
            w.i("MicroMsg.SmsContentObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")), bg.bJZ(), this.context);
            if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")) {
                return;
            }
        }
        bRm();
    }

    public final void bRm() {
        Cursor query;
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.pyz = this.context.getContentResolver();
        String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
        String str2 = "( ";
        int i = 0;
        while (i < this.pyE.length) {
            str2 = i == this.pyE.length + -1 ? str2 + " body like \"%" + this.pyE[i] + "%\" ) " : str2 + "body like \"%" + this.pyE[i] + "%\" or ";
            i++;
        }
        String str3 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        w.v("MicroMsg.SmsContentObserver", "sql where:" + str3);
        if (str3 != null && !str3.equals("")) {
            try {
                query = this.pyz.query(parse, strArr, str3, null, null);
                int i2 = -1;
                long j = 0;
                while (query.moveToNext()) {
                    try {
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
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (i2 >= 0) {
                    query.moveToPosition(i2);
                    Matcher matcher = this.mlF.matcher(query.getString(query.getColumnIndex("body")));
                    if (matcher.find()) {
                        str = matcher.group();
                    }
                    this.vcc.SP(str);
                } else {
                    this.vcc.bQX();
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    w.e("MicroMsg.SmsContentObserver", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    query.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                throw th;
            }
        }
    }
}
