package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bo;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.g;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class c implements a {
    private d kEU;

    c(d dVar) {
        this.kEU = dVar;
    }

    private boolean bO(final Context context) {
        if (h.vI().vn() == null) {
            Toast.makeText(context, R.l.eIS, 1).show();
        } else {
            context.getString(R.l.dIO);
            final ProgressDialog a = g.a(context, context.getString(R.l.eIR), false, null);
            final bo bCi = ((b) h.h(b.class)).bCi();
            bCi.O(1800000);
            this.kEU.b(new b(this) {
                final /* synthetic */ c kEX;

                public final void kZ(final int i) {
                    bCi.zU();
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 kEZ;

                        public final void run() {
                            int i;
                            if (a != null) {
                                a.dismiss();
                            }
                            switch (i) {
                                case -3:
                                    i = R.l.eIS;
                                    break;
                                case -2:
                                    i = R.l.eIT;
                                    break;
                                case 0:
                                    i = R.l.eIU;
                                    break;
                                default:
                                    i = R.l.eIQ;
                                    break;
                            }
                            Toast.makeText(context, i, 1).show();
                        }
                    });
                }
            });
        }
        return true;
    }

    private boolean b(final Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        String str = h.vI().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = new String[]{"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (FileOp.aO(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        return true;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wO().bNN().close();
                    FileOp.kl(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        FileOp.aj(str3 + str6, str4 + str6);
                        i2++;
                    }
                    MMAppMgr.a(context, true);
                    return true;
                case 1:
                    if (FileOp.aO(str2)) {
                        final Context context2 = context;
                        g.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener(this) {
                            final /* synthetic */ c kEX;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ap.yY();
                                com.tencent.mm.u.c.wO().bNN().close();
                                for (String str : strArr2) {
                                    FileOp.deleteFile(str3 + str);
                                    FileOp.aj(str4 + str, str3 + str);
                                }
                                FileOp.y(str2, false);
                                MMAppMgr.a(context2, true);
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                case 2:
                    if (FileOp.aO(str2)) {
                        g.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new OnClickListener(this) {
                            final /* synthetic */ c kEX;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                FileOp.y(str2, false);
                                Toast.makeText(context, "Corruption test database cleared.", 0).show();
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                default:
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        str3 = h.vI().vn();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(FileOp.ki(str3));
            stringBuilder.append("\nSaved master exists: ").append(FileOp.aO(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(FileOp.aO(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(R.f.aXt);
        textView.setPadding(i, i, i, i);
        g.a(context, null, textView, null);
        return true;
    }

    private static boolean bP(Context context) {
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (!(lastIOTraceStats == null || lastIOTraceStats.isEmpty())) {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                ap.yY();
                str = com.tencent.mm.a.g.n((p.rA() + com.tencent.mm.u.c.uH()).getBytes()).substring(0, 7);
            } catch (Exception e) {
            }
            CharSequence format = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str, iOTraceStats.toString()});
            Object obj = "";
            if (iOTraceStats.lastReadPage != null) {
                obj = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            String str2 = "";
            if (iOTraceStats.lastJournalReadPage != null) {
                encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                String str3 = str2;
            }
            Map hashMap = new HashMap();
            hashMap.put("lastReadPage", obj);
            hashMap.put("lastJournalReadPage", encodeToString);
            com.tencent.mm.plugin.report.service.g.oUh.d("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.aXt);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            g.a(context, null, textView, null);
        }
        return true;
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1955673212:
                if (str.equals("//recover")) {
                    z = false;
                    break;
                }
                break;
            case -1870250080:
                if (str.equals("//backupdb")) {
                    z = true;
                    break;
                }
                break;
            case -1648083177:
                if (str.equals("//post-recover")) {
                    z = true;
                    break;
                }
                break;
            case -896707907:
                if (str.equals("//iotracedb")) {
                    z = true;
                    break;
                }
                break;
            case -398050965:
                if (str.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case -137452885:
                if (str.equals("//repairdb")) {
                    z = true;
                    break;
                }
                break;
            case 1793722114:
                if (str.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
        }
        final long nanoTime;
        final Context context2;
        String str2;
        final ProgressDialog a;
        switch (z) {
            case false:
                return bO(context);
            case true:
                ap.yY();
                d.akJ();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final ProgressDialog a2 = g.a(context, "Backing database up. Please wait...", false, null);
                    context2 = context;
                    if (this.kEU.a(z2, new b(this) {
                        final /* synthetic */ c kEX;

                        public final void kZ(final int i) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 kFb;

                                public final void run() {
                                    CharSequence format;
                                    if (a2 != null) {
                                        a2.dismiss();
                                    }
                                    if (i == 0) {
                                        String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z2 ? "incremental" : "new";
                                        objArr[1] = Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f);
                                        format = String.format(str, objArr);
                                    } else if (i == 1) {
                                        format = "Database backup canceled.";
                                    } else {
                                        format = "Database backup failed.";
                                    }
                                    Toast.makeText(context2, format, 0).show();
                                }
                            });
                        }
                    })) {
                        return true;
                    }
                    if (a2 != null) {
                        a2.dismiss();
                    }
                    Toast.makeText(context, "Database is busy.", 0).show();
                    return true;
                }
                ap.yY();
                t vr = com.tencent.mm.u.c.vr();
                if (strArr.length > 2) {
                    str = strArr[2];
                    z = true;
                    switch (str.hashCode()) {
                        case 48:
                            if (str.equals("0")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3521:
                            if (str.equals("no")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3551:
                            if (str.equals("on")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109935:
                            if (str.equals("off")) {
                                z = true;
                                break;
                            }
                            break;
                        case 119527:
                            if (str.equals("yes")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                            vr.setInt(237571, 0);
                            vr.jY(true);
                            break;
                        case true:
                        case true:
                        case true:
                            vr.setInt(237571, 1);
                            vr.jY(true);
                            break;
                    }
                }
                Toast.makeText(context, "Database backup with cipher: " + (vr.getInt(237571, 0) == 0), 0).show();
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dIO);
                a = g.a(context, context.getString(R.l.eIR), false, null);
                context2 = context;
                this.kEU.a(str2, new b(this) {
                    final /* synthetic */ c kEX;

                    public final void kZ(final int i) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 kFc;

                            public final void run() {
                                CharSequence format;
                                if (a != null) {
                                    a.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                            }
                        });
                    }
                });
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dIO);
                a = g.a(context, context.getString(R.l.eIR), false, null);
                context2 = context;
                int b = this.kEU.b(str2, new b(this) {
                    final /* synthetic */ c kEX;

                    public final void kZ(final int i) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 kFd;

                            public final void run() {
                                CharSequence format;
                                if (a != null) {
                                    a.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                            }
                        });
                    }
                });
                if (b == 0) {
                    return true;
                }
                if (a != null) {
                    a.dismiss();
                }
                switch (b) {
                    case -3:
                        b = R.l.eIS;
                        break;
                    case -2:
                        b = R.l.eIT;
                        break;
                    default:
                        b = R.l.eIQ;
                        break;
                }
                Toast.makeText(context, b, 1).show();
                return true;
            case true:
                return b(context, strArr);
            case true:
                return bP(context);
            default:
                return false;
        }
    }
}
