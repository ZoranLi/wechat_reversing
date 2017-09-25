package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.e.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f extends com.tencent.mm.plugin.fts.a.b {
    public k gTU;
    private com.tencent.mm.plugin.fts.c lYx;
    public com.tencent.mm.sdk.b.c mcc = new com.tencent.mm.sdk.b.c<e>(this) {
        final /* synthetic */ f mcf;

        {
            this.mcf = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((e) bVar).fCm.fCn) {
                af.f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 mcg;

                    {
                        this.mcg = r1;
                    }

                    public final void run() {
                        if (!this.mcg.mcf.lYS) {
                            this.mcg.mcf.gTU.a(Integer.MAX_VALUE, new b(this.mcg.mcf));
                        }
                    }
                }, 10000);
                this.mcf.mcc.dead();
            }
            return false;
        }
    };
    public String[] mcd;
    public List<String> mce;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ f mcf;

        public a(f fVar) {
            this.mcf = fVar;
        }

        public final boolean execute() {
            throw new SQLiteDatabaseCorruptException("For Test");
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ f mcf;

        public b(f fVar) {
            this.mcf = fVar;
        }

        public final boolean execute() {
            Throwable th;
            Cursor cursor;
            StringBuffer stringBuffer = new StringBuffer();
            long length = new File(h.vI().cachePath, "FTS5IndexMicroMsg.db").length();
            stringBuffer.append("[DBSize] ");
            stringBuffer.append(bg.ew(length));
            stringBuffer.append("\n");
            stringBuffer.append("[TableInfo]");
            stringBuffer.append("\n");
            Collection axR = axR();
            Collection axS = axS();
            List<String> arrayList = new ArrayList();
            arrayList.addAll(axR);
            arrayList.addAll(axS);
            for (String str : arrayList) {
                try {
                    Cursor rawQuery = ((l) h.j(l.class)).getFTSIndexDB().rawQuery("SELECT count(*) FROM " + str + ";", null);
                    try {
                        if (rawQuery.moveToNext()) {
                            stringBuffer.append(str);
                            stringBuffer.append("=");
                            stringBuffer.append(rawQuery.getLong(0));
                            stringBuffer.append("\n");
                        }
                        rawQuery.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            com.tencent.mm.plugin.fts.c.a aVar = (com.tencent.mm.plugin.fts.c.a) ((l) h.j(l.class)).getFTSIndexStorage(3);
            long j = aVar.j(new int[]{131075});
            length = aVar.j(new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT});
            stringBuffer.append("[Contact.Chatroom]=" + j);
            stringBuffer.append("\n");
            stringBuffer.append("[Contact.WXContact]=" + length);
            stringBuffer.append("\n");
            String stringBuffer2 = stringBuffer.toString();
            w.i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
            File file = new File(com.tencent.mm.plugin.fts.a.c.lZw, "FTS5IndexMicroMsgInfo.txt");
            if (file.exists()) {
                file.delete();
            }
            FileOp.k(file.getAbsolutePath(), stringBuffer2.getBytes());
            return true;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }

        private static LinkedList<String> axR() {
            LinkedList<String> linkedList = new LinkedList();
            Cursor rawQuery = ((l) h.j(l.class)).getFTSIndexDB().rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?;", new String[]{"FTS5Index%"});
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(0);
                    if (!string.contains("_")) {
                        linkedList.add(string);
                    }
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return linkedList;
        }

        private static LinkedList<String> axS() {
            LinkedList<String> linkedList = new LinkedList();
            Cursor rawQuery = ((l) h.j(l.class)).getFTSIndexDB().rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?;", new String[]{"FTS5Meta%"});
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return linkedList;
        }

        public final String getName() {
            return "FTS5DBInfoTask";
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private int count;
        final /* synthetic */ f mcf;

        public c(f fVar, int i) {
            this.mcf = fVar;
            this.count = i;
        }

        public final boolean execute() {
            InputStream fileInputStream;
            Throwable th;
            if (this.mcf.mcd == null) {
                try {
                    fileInputStream = new FileInputStream("/sdcard/test_insert_msg_words.txt");
                    try {
                        String str = new String(com.tencent.mm.loader.stub.b.c(fileInputStream));
                        this.mcf.mcd = str.split(",");
                        com.tencent.mm.a.e.b(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.mm.a.e.b(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    com.tencent.mm.a.e.b(fileInputStream);
                    throw th;
                }
            }
            if (this.mcf.mce == null) {
                this.mcf.mce = new ArrayList();
                Cursor bLr = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().bLr();
                while (bLr.moveToNext()) {
                    this.mcf.mce.add(bLr.getString(0));
                }
                bLr.close();
            }
            if (this.mcf.mcd != null) {
                for (int i = 0; i < this.count; i++) {
                    String u = u(this.mcf.mcd);
                    ce auVar = new au();
                    auVar.setType(1);
                    auVar.dw(1);
                    auVar.dv(4);
                    auVar.setContent(u);
                    List list = this.mcf.mce;
                    auVar.cH((String) list.get(new Random().nextInt(list.size() - 1)));
                    auVar.z(System.currentTimeMillis() - 250327040);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().L(auVar);
                    w.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(u.length()), Long.valueOf(auVar.field_msgId)});
                }
            }
            return true;
        }

        private static String u(String[] strArr) {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            return stringBuffer.toString();
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ f mcf;

        public d(f fVar, com.tencent.mm.plugin.fts.a.a.f fVar2) {
            this.mcf = fVar;
            super(fVar2);
        }

        protected final List<i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            if ("tophitscore".equals(strArr[0])) {
                Cursor rawQuery = r0.lYU.rawQuery(String.format("Select docid, aux_index, query, score, scene from %s", new Object[]{((com.tencent.mm.plugin.fts.c.e) ((l) h.j(l.class)).getFTSIndexStorage(1)).axE()}), null);
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(1);
                    w.d("MicroMsg.FTS.FTS5TopHitsStorage", "rowid=%d aux_index=%s, query=%s, score=%d, scene=%d displayName=%s", new Object[]{Long.valueOf(rawQuery.getLong(0)), string, rawQuery.getString(2), Long.valueOf(rawQuery.getLong(3)), Long.valueOf(rawQuery.getLong(4)), string});
                }
                rawQuery.close();
            } else {
                bg.mA(fVar.fRM);
            }
            return new ArrayList();
        }

        public final String getName() {
            return "SearchTestTask";
        }
    }

    public final String getName() {
        return "SearchTestLogic";
    }

    protected final boolean onCreate() {
        if (((l) h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.gTU = ((l) h.j(l.class)).getFTSTaskDaemon();
            this.lYx = (com.tencent.mm.plugin.fts.c) ((l) h.j(l.class)).getFTSIndexDB();
            this.mcc.bIy();
            return true;
        }
        w.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        return false;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        com.tencent.mm.plugin.fts.a.a.a cVar;
        switch (fVar.lZZ) {
            case 65521:
                cVar = new c(this, fVar.mad);
                break;
            case 65522:
                cVar = new a(this);
                break;
            default:
                cVar = new d(this, fVar);
                break;
        }
        return this.gTU.a(-65536, cVar);
    }

    protected final boolean tT() {
        return false;
    }
}
