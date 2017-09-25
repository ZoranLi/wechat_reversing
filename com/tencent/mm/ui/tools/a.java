package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.q;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class a {

    static class AnonymousClass1 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        final /* synthetic */ Intent jPF;
        final /* synthetic */ int nK;
        private Uri uri;
        final /* synthetic */ q vBq;
        final /* synthetic */ Intent val$intent;
        private ProgressDialog wkI;
        private boolean wkJ;
        final /* synthetic */ String wkK;
        final /* synthetic */ a wkL = null;

        public AnonymousClass1(Intent intent, q qVar, String str, a aVar, Intent intent2, int i) {
            this.jPF = intent;
            this.vBq = qVar;
            this.wkK = str;
            this.val$intent = intent2;
            this.nK = aq.CTRL_INDEX;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return bZz();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (!(this.wkJ || bg.mA(this.filePath))) {
                if (this.wkL != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.wkL.GP(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.vBq.startActivityForResult(this.val$intent, this.nK);
            }
            this.wkI.dismiss();
        }

        protected final void onPreExecute() {
            try {
                this.uri = this.jPF.getData();
                this.wkJ = false;
                Context context = this.vBq.uSU.uTo;
                this.vBq.getString(k.dIO);
                this.wkI = g.a(context, this.vBq.getString(k.hfd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 wkM;

                    {
                        this.wkM = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.wkM.wkJ = true;
                    }
                });
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
        }

        private Integer bZz() {
            try {
                if (this.uri != null) {
                    this.filePath = a.u(this.wkK, d.k(this.uri));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
            return null;
        }
    }

    public interface a {
        String GP(String str);
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        b(activity, intent, intent2, str, i, null);
    }

    public static void b(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar) {
        if (intent == null || intent.getData() == null) {
            boolean z;
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.e(str2, str3, objArr);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final a aVar2 = aVar;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private Uri uri;
                private ProgressDialog wkI;
                private boolean wkJ;

                protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return bZz();
                }

                protected final /* synthetic */ void onPostExecute(Object obj) {
                    if (this.wkJ || bg.mA(this.filePath)) {
                        w.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (aVar2 != null) {
                            intent4.putExtra("CropImage_OutputPath", aVar2.GP(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.wkI.dismiss();
                }

                protected final void onPreExecute() {
                    try {
                        this.uri = intent3.getData();
                        this.wkJ = false;
                        Context context = activity2;
                        activity2.getString(k.dIO);
                        this.wkI = g.a(context, activity2.getString(k.hfd), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 wkO;

                            {
                                this.wkO = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.wkO.wkJ = true;
                            }
                        });
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                    }
                }

                private Integer bZz() {
                    try {
                        if (this.uri != null) {
                            this.filePath = a.u(str4, d.k(this.uri));
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                    return null;
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
        } else {
            String c = c(activity, intent, str);
            w.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", c);
            if (!bg.mA(c)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.GP(c));
                }
                intent2.putExtra("CropImage_ImgPath", c);
                activity.startActivityForResult(intent2, i);
            }
        }
    }

    public static String c(Context context, Intent intent, String str) {
        String str2 = null;
        if (context == null || intent == null || str == null) {
            w.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                w.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = u(str, d.k(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        w.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:" + str2);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!new File(path).exists()) {
                    path = null;
                }
                w.i("MicroMsg.AsyncObtainImage", "photo file from data, path:" + path);
                if (path == null) {
                    path = intent.getData().getHost();
                    if (new File(path).exists()) {
                        str2 = path;
                    }
                    w.i("MicroMsg.AsyncObtainImage", "photo file from data, host:" + str2);
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                w.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
            } else {
                str2 = u(str, (Bitmap) intent.getExtras().get(SlookAirButtonFrequentContactAdapter.DATA));
                w.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
        }
        return str2;
    }

    public static String u(String str, Bitmap bitmap) {
        try {
            String str2 = str + (com.tencent.mm.a.g.n(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg");
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            w.i("MicroMsg.AsyncObtainImage", "photo image from data, path:" + str2);
            return str2;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            return null;
        }
    }
}
