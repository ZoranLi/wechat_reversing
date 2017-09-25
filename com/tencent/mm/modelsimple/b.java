package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements Runnable {
    private String fNQ;
    private Account hRB;
    private a hRC;
    private Looper hRD;
    public Context mContext;
    private String username;

    public class a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver hRE;
        ArrayList<ContentProviderOperation> hRF;
        final /* synthetic */ b hRG;

        public a(b bVar, ContentResolver contentResolver) {
            this.hRG = bVar;
            this.hRE = contentResolver;
            this.hRF = new ArrayList();
        }

        public final void a(ContentProviderOperation contentProviderOperation) {
            this.hRF.add(contentProviderOperation);
        }

        public final void execute() {
            if (this.hRF.size() == 0) {
                w.d("MicroMsg.BatchOperation", "no batch operation");
            } else if (com.tencent.mm.pluginsdk.i.a.aT(this.hRG.mContext, "android.permission.READ_CONTACTS")) {
                try {
                    this.hRE.applyBatch("com.android.contacts", this.hRF);
                } catch (OperationApplicationException e) {
                    w.e("MicroMsg.BatchOperation", "apply batch operation failed", e.toString());
                } catch (RemoteException e2) {
                    w.e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (Exception e3) {
                    w.e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                }
                this.hRF.clear();
            } else {
                w.e("MicroMsg.BatchOperation", "no contact permission");
            }
        }
    }

    public b(Context context, Account account) {
        this(context, account, null, null);
    }

    public b(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public b(Context context, Account account, String str, String str2) {
        this.mContext = context;
        this.hRB = account;
        this.username = str;
        this.fNQ = str2;
        w.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
    }

    public final void run() {
        Looper.prepare();
        this.hRD = Looper.myLooper();
        w.i("MicroMsg.ContactsOperations", "start time:" + System.currentTimeMillis());
        if (bg.mA(this.username) && bg.mA(this.fNQ)) {
            IM();
        } else if (bg.mA(this.fNQ)) {
            r0 = af.FY().iZ(this.username);
            if (!(r0 == null || bg.mA(r0.hAC))) {
                kw(r0.hAC);
            }
            quit();
        } else {
            r0 = af.FY().iZ(this.username);
            com.tencent.mm.modelfriend.b iZ = (r0 == null || bg.mA(r0.hAC)) ? af.FY().iZ(this.fNQ) : r0;
            if (iZ == null || bg.mA(iZ.hAC)) {
                w.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (com.tencent.mm.pluginsdk.i.a.aT(this.mContext, "android.permission.READ_CONTACTS")) {
                        Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hRB.name).appendQueryParameter("account_type", this.hRB.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + iZ.hAC + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String EU = bg.mA(iZ.ER()) ? iZ.EU() : iZ.ER();
                            this.hRC = new a(this, this.mContext.getContentResolver());
                            c(EU, iZ.EX(), iZ.hAC, this.username);
                            this.hRC.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        w.e("MicroMsg.ContactsOperations", "no contact permission");
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                }
            }
            quit();
        }
        w.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        Looper.loop();
    }

    private void quit() {
        if (this.hRD != null) {
            this.hRD.quit();
        }
    }

    private synchronized void IM() {
        Throwable e;
        Object obj;
        if (ap.zb()) {
            List<com.tencent.mm.modelfriend.b> jb = af.FY().jb("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bg.my("") + "\" )");
            if (jb.size() == 0) {
                w.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
            } else {
                Map hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hRB.name).appendQueryParameter("account_type", this.hRB.type).build();
                if (com.tencent.mm.pluginsdk.i.a.aT(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    String username;
                    com.tencent.mm.e.b.af Rc;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                w.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                w.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                                if (query != null) {
                                    query.close();
                                }
                                if (!kx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.hRC = new a(this, this.mContext.getContentResolver());
                                for (com.tencent.mm.modelfriend.b bVar : jb) {
                                    username = bVar.getUsername();
                                    ap.yY();
                                    Rc = c.wR().Rc(username);
                                    if (Rc == null) {
                                    }
                                    kw(bVar.hAC);
                                }
                                this.hRC.execute();
                                quit();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (kx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || kx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.hRC = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar2 : jb) {
                                username = bVar2.getUsername();
                                ap.yY();
                                Rc = c.wR().Rc(username);
                                if (Rc == null && com.tencent.mm.j.a.ez(Rc.field_type)) {
                                    String EU = bg.mA(bVar2.ER()) ? bVar2.EU() : bVar2.ER();
                                    String EX = bVar2.EX();
                                    String str = bVar2.hAC;
                                    String str2 = Rc.signature;
                                    if (hashMap.get(str) == null || r2 != null) {
                                        if (hashMap.get(str) != null) {
                                            kw(str);
                                        }
                                        c(EU, EX, str, username);
                                    }
                                    this.hRC.execute();
                                } else {
                                    kw(bVar2.hAC);
                                }
                            }
                            this.hRC.execute();
                            quit();
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (kx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.hRC = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar22 : jb) {
                                username = bVar22.getUsername();
                                ap.yY();
                                Rc = c.wR().Rc(username);
                                if (Rc == null) {
                                }
                                kw(bVar22.hAC);
                            }
                            this.hRC.execute();
                            quit();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                        w.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                        if (query != null) {
                            query.close();
                        }
                        if (kx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                        }
                        obj = null;
                        this.hRC = new a(this, this.mContext.getContentResolver());
                        for (com.tencent.mm.modelfriend.b bVar222 : jb) {
                            username = bVar222.getUsername();
                            ap.yY();
                            Rc = c.wR().Rc(username);
                            if (Rc == null) {
                            }
                            kw(bVar222.hAC);
                        }
                        this.hRC.execute();
                        quit();
                    }
                }
                w.e("MicroMsg.ContactsOperations", "no contact permission");
            }
        } else {
            w.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
        }
    }

    private void c(String str, String str2, String str3, String str4) {
        w.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue("account_name", this.hRB.name);
        newInsert.withValue("account_type", this.hRB.type);
        newInsert.withValue("sync1", str3);
        this.hRC.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.hRC.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.bpJ));
        newInsert.withValue("data3", this.mContext.getString(R.l.eay));
        newInsert.withValue("data4", str3);
        this.hRC.a(newInsert.build());
        if ("1".equals(g.sV().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.bpJ));
            newInsert.withValue("data3", this.mContext.getString(R.l.eaA));
            newInsert.withValue("data4", str3);
            this.hRC.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.bpJ));
            newInsert.withValue("data3", this.mContext.getString(R.l.eaz));
            newInsert.withValue("data4", str3);
            this.hRC.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.bpJ));
        newInsert.withValue("data3", this.mContext.getString(R.l.eaB));
        newInsert.withValue("data4", str3);
        this.hRC.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.bpJ));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.hRC.a(newInsert.build());
    }

    private void kw(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
        } else if (com.tencent.mm.pluginsdk.i.a.aT(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Throwable e) {
                w.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), bg.g(e));
                query = null;
            }
            if (query == null) {
                w.e("MicroMsg.ContactsOperations", "get null cursor");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(bg.mA(string) || bg.mA(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                w.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
        } else {
            w.e("MicroMsg.ContactsOperations", "no contact permission");
        }
    }

    private boolean kx(String str) {
        Exception e;
        boolean z = false;
        if (com.tencent.mm.pluginsdk.i.a.aT(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            w.d("MicroMsg.ContactsOperations", "has minetype:" + str);
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        w.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
                w.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                z = true;
                if (query != null) {
                    query.close();
                }
                return z;
            }
            if (query != null) {
                query.close();
            }
        } else {
            w.e("MicroMsg.ContactsOperations", "no contact permission");
        }
        return z;
    }
}
