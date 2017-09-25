package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class o implements com.tencent.mm.ah.b.c {
    List<c> hHV = new LinkedList();
    public c hHW = null;
    public boolean hHX = false;

    public interface a {
        void g(String str, Bitmap bitmap);
    }

    private static class b {
        public Bitmap bitmap;
        public String path;

        public b(String str, Bitmap bitmap) {
            this.path = str;
            this.bitmap = bitmap;
        }
    }

    private static class c {
        public a hHZ;
        public String url;

        public c(String str, a aVar) {
            this.url = str;
            this.hHZ = aVar;
        }
    }

    public final void a(String str, a aVar) {
        if (bg.mA(str) || aVar == null) {
            w.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
        } else if (this.hHW != null && this.hHW.url.equals(str) && this.hHW.hHZ == aVar) {
            w.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        } else {
            for (c cVar : this.hHV) {
                if (cVar.url.equals(str) && cVar.hHZ == aVar) {
                    w.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    return;
                }
            }
            this.hHV.add(new c(str, aVar));
            GZ();
        }
    }

    public final void GZ() {
        while (this.hHW == null && this.hHV.size() != 0) {
            this.hHW = (c) this.hHV.get(0);
            this.hHV.remove(0);
            this.hHX = false;
            n.GR();
            Bitmap gS = b.gS(this.hHW.url);
            if (gS != null) {
                w.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.hHW.url);
                if (!this.hHX) {
                    this.hHW.hHZ.g(this.hHW.url, gS);
                }
                this.hHW = null;
            } else {
                new AsyncTask<String, Integer, Bitmap>(this) {
                    final /* synthetic */ o hHY;

                    {
                        this.hHY = r1;
                    }

                    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                        String[] strArr = (String[]) objArr;
                        if (strArr.length <= 0) {
                            return null;
                        }
                        String jC = o.jC(strArr[0]);
                        return new File(jC).exists() ? d.Pg(jC) : null;
                    }

                    protected final /* synthetic */ void onPostExecute(Object obj) {
                        Bitmap bitmap = (Bitmap) obj;
                        if (bitmap != null) {
                            w.d("MicroMsg.UrlImageCacheService", "load from sdcard");
                            if (!this.hHY.hHX) {
                                n.GR();
                                b.f(this.hHY.hHW.url, bitmap);
                                this.hHY.hHW.hHZ.g(this.hHY.hHW.url, bitmap);
                            }
                            this.hHY.hHW = null;
                            this.hHY.GZ();
                            return;
                        }
                        w.i("MicroMsg.UrlImageCacheService", "try load from " + this.hHY.hHW.url);
                        n.GR().a(this.hHY.hHW.url, this.hHY);
                    }
                }.execute(new String[]{this.hHW.url});
                return;
            }
        }
        w.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
    }

    public static String jC(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (bg.mA(encode)) {
                w.e("MicroMsg.UrlImageCacheService", "encode result is null: " + str);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.gSy);
            int length = encode.length();
            int i = 0;
            while (i < length) {
                stringBuilder.append('/');
                if (i + 20 < length) {
                    stringBuilder.append(encode.substring(i, i + 20));
                    i += 20;
                } else {
                    stringBuilder.append(encode.substring(i, length));
                    i = length;
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + str);
            return null;
        }
    }

    public final void l(Bitmap bitmap) {
        if (bitmap == null) {
            w.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.hHW.url);
            this.hHW = null;
            GZ();
            return;
        }
        w.i("MicroMsg.UrlImageCacheService", "load from %s successed", this.hHW.url);
        new AsyncTask<b, Integer, Integer>(this) {
            final /* synthetic */ o hHY;

            {
                this.hHY = r1;
            }

            protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                return AnonymousClass2.a((b[]) objArr);
            }

            private static Integer a(b... bVarArr) {
                if (bVarArr.length == 0 || bg.mA(bVarArr[0].path) || bVarArr[0].bitmap == null) {
                    w.e("MicroMsg.UrlImageCacheService", "nothing to save");
                } else {
                    try {
                        d.a(bVarArr[0].bitmap, 100, CompressFormat.PNG, bVarArr[0].path, false);
                    } catch (IOException e) {
                        w.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
                    }
                }
                return null;
            }
        }.execute(new b[]{new b(jC(this.hHW.url), bitmap)});
        if (!this.hHX) {
            n.GR();
            b.f(this.hHW.url, bitmap);
            this.hHW.hHZ.g(this.hHW.url, bitmap);
        }
        this.hHW = null;
        GZ();
    }
}
