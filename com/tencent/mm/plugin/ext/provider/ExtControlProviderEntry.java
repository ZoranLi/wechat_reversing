package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.wcdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher lqF;
    private boolean lqG;
    private Context lqH;
    private String[] lqq;
    private int lqr;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lqF = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        lqF.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        lqF.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        lqF.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        lqF.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.lqG = false;
        this.lqq = null;
        this.lqr = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.lqG = false;
        this.lqq = null;
        this.lqr = -1;
        this.lqG = true;
        this.lqq = strArr;
        this.lqr = i;
        this.lqH = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.lqG);
        if (this.lqG) {
            a(uri, this.lqH, this.lqr, this.lqq);
            if (bg.mA(this.lqz)) {
                w.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                bS(3, 7);
                return ExtContentProviderBase.me(7);
            } else if (bg.mA(aqX())) {
                w.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                bS(3, 6);
                return ExtContentProviderBase.me(6);
            } else {
                int aqY = aqY();
                if (aqY != 1) {
                    w.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + aqY);
                    bS(2, aqY);
                    return ExtContentProviderBase.me(aqY);
                }
            }
        }
        this.lqH = getContext();
        a(uri, this.lqH, lqF);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return ExtContentProviderBase.me(3);
        } else if (!acK()) {
            md(1);
            return this.jPp;
        } else if (!bW(this.lqH)) {
            w.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            md(2);
            return null;
        }
        String mz = bg.mz(uri.getQueryParameter("source"));
        if (!this.lqG) {
            this.lqr = lqF.match(uri);
        }
        switch (this.lqr) {
            case 2:
                return k(strArr2);
            case 3:
                return b(strArr2, mz);
            case 4:
                if (this.lqH == null) {
                    md(4);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.lqH.startActivity(intent);
                md(0);
                return ExtContentProviderBase.me(1);
            case 5:
                return l(strArr2);
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    w.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    md(3);
                    return null;
                } else if (this.lqH == null) {
                    md(4);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? "" : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.lqH.startActivity(intent2);
                    md(0);
                    return ExtContentProviderBase.me(1);
                }
            default:
                bS(3, 15);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor k(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            w.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            md(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            w.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            md(3);
            return null;
        }
        try {
            ap.yY();
            af ez = c.wR().ez(a.vA(str));
            if (ez == null || ((int) ez.gTQ) <= 0 || this.lqH == null) {
                md(3);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", ez.field_username);
            d.b(this.lqH, "profile", ".ui.ContactInfoUI", intent);
            md(0);
            return ExtContentProviderBase.me(1);
        } catch (Throwable e) {
            w.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            md(3);
            return null;
        }
    }

    private Cursor b(String[] strArr, String str) {
        w.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            w.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            bS(3, 3601);
            return ExtContentProviderBase.me(3601);
        } else if (bg.mA(str)) {
            w.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            bS(3, 3602);
            return ExtContentProviderBase.me(3602);
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                w.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                bS(3, 3603);
                return ExtContentProviderBase.me(3603);
            }
            af Rc;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bd RZ = b.aqM().RZ(str2);
                    if (RZ == null || bg.mA(RZ.field_openId) || bg.mA(RZ.field_username)) {
                        w.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        bS(3, 3604);
                        return ExtContentProviderBase.me(3604);
                    }
                    ap.yY();
                    Rc = c.wR().Rc(RZ.field_username);
                } catch (Throwable e) {
                    w.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    z(5, 4, 12);
                    return ExtContentProviderBase.me(12);
                }
            }
            ap.yY();
            Rc = c.wR().ez(a.vA(str2));
            if (Rc == null || ((int) Rc.gTQ) <= 0 || this.lqH == null) {
                w.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                bS(3, 3605);
                return ExtContentProviderBase.me(3605);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.En_5b8fbb1e"));
            intent.putExtra("Chat_User", Rc.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(67108864);
            this.lqH.startActivity(intent);
            z(4, 0, 1);
            return ExtContentProviderBase.me(1);
        }
    }

    private Cursor l(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            w.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            md(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            w.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            md(3);
            return null;
        }
        try {
            long vA = a.vA(str);
            if (vA <= 0) {
                md(3);
                return null;
            } else if (this.lqH == null) {
                md(4);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) vA);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.lqH.startActivity(intent);
                md(0);
                return ExtContentProviderBase.me(1);
            }
        } catch (Throwable e) {
            w.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            md(3);
            return null;
        }
    }
}
