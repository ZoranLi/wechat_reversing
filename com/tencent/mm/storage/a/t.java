package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class t extends i<s> implements a {
    public static final String[] gUx = new String[]{i.a(s.gTP, "SmileyInfo")};
    private static final String[] uLu = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] uLv = new String[]{"key"};
    public e gUz;

    public t(e eVar) {
        this(eVar, s.gTP, "SmileyInfo");
    }

    private t(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final ArrayList<String> alE() {
        Cursor a;
        Throwable e;
        ArrayList<String> arrayList = new ArrayList();
        try {
            a = this.gUz.a("SmileyInfo", uLv, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            arrayList.add(a.getString(0));
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.NewSmileyInfoStorage", bg.g(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.NewSmileyInfoStorage", bg.g(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }

    public final ArrayList<s> alD() {
        Throwable e;
        ArrayList<s> arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.gUz.a("SmileyInfo", uLu, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            s sVar = new s();
                            sVar.b(a);
                            sVar.field_position = -1;
                            arrayList.add(sVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.NewSmileyInfoStorage", bg.g(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.NewSmileyInfoStorage", bg.g(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}
