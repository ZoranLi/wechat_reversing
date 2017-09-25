package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d extends Thread {
    private static HashMap<String, b> svC = new HashMap();
    private static Object svD = new byte[0];
    private static ar svE;
    public boolean isStop;
    private String svA;
    private boolean svB = false;
    private List<String> svs;
    private List<Integer> svt;
    private List<String> svu;
    private List<String> svv;
    private List<Integer> svw;
    private a svx;
    private g svy;
    private String svz;

    public interface a {
        void a(String str, g gVar);

        void b(String str, g gVar);
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.ar.a {
        String fyF;
        String hXX;
        String svH;
        int svI;
        VideoTransPara svJ;
        private int svK;
        private int svL;
        private boolean svM;
        private int svN = 0;
        public a svx;
        g svy;

        public final boolean Bn() {
            synchronized (d.svD) {
                Object obj = !d.svC.containsKey(this.fyF) ? 1 : null;
            }
            if (obj == null) {
                obj = t.lH(this.fyF) == null ? 1 : null;
            }
            if (obj != null) {
                w.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[]{this.fyF});
                return true;
            }
            if (this.svJ == null || this.svJ.isDefault) {
                int[] iArr = new int[2];
                d.b(this.hXX, iArr);
                this.svK = iArr[0];
                this.svL = iArr[1];
            } else {
                this.svK = this.svJ.width;
                this.svL = this.svJ.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            ap.yY();
            if (c.wY().a(this.hXX, pString, pInt) && j.ex(pString.value, this.svH)) {
                w.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
                this.svI = pInt.value;
                this.svM = true;
                return true;
            }
            long NA = bg.NA();
            if (this.svJ != null) {
                w.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[]{this.svJ});
                if (com.tencent.mm.plugin.sight.base.b.pty) {
                    this.svJ.hzY = (int) (((double) this.svJ.hzY) * 0.915d);
                }
                this.svI = SightVideoJNI.remuxing(this.hXX, this.svH, this.svK, this.svL, this.svJ.hzY, this.svJ.hzO, 8, this.svJ.hzN, 25.0f, (float) this.svJ.gPE, null, 0, com.tencent.mm.plugin.sight.base.b.pty);
            } else {
                w.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[]{this.fyF});
                if (com.tencent.mm.plugin.sight.base.b.pty) {
                    com.tencent.mm.plugin.sight.base.b.ptA = (int) (((double) com.tencent.mm.plugin.sight.base.b.ptA) * 0.915d);
                }
                this.svI = SightVideoJNI.remuxing(this.hXX, this.svH, this.svK, this.svL, com.tencent.mm.plugin.sight.base.b.ptA, com.tencent.mm.plugin.sight.base.b.ptz, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.ptB, null, 0, com.tencent.mm.plugin.sight.base.b.pty);
            }
            this.svN = (int) bg.aB(NA);
            w.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{this.hXX, this.svH, Integer.valueOf(this.svI), Integer.valueOf(this.svK), Integer.valueOf(this.svL)});
            this.svM = this.svI >= 0;
            PInt pInt2 = new PInt();
            if (t.a(this.svH, pInt2, new PInt())) {
                this.svI = pInt2.value;
            }
            if (this.svM) {
                w.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
                try {
                    String name = new File(this.svH).getName();
                    String str = this.svH + ".tmp";
                    if (com.tencent.mm.plugin.a.d.b(this.svH, str, new PInt(0))) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.svH);
                        File file = new File(str);
                        boolean h = e.h(file.getParent() + File.separator, file.getName(), name);
                        w.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(h), file.getAbsolutePath(), this.svH});
                    } else {
                        w.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[]{Integer.valueOf(new PInt(0).value), this.hXX, this.svH});
                    }
                    ap.yY();
                    c.wY().H(this.hXX, this.svH, this.svI);
                } catch (Exception e) {
                    w.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[]{e.toString()});
                }
            } else {
                w.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
                com.tencent.mm.loader.stub.b.deleteFile(this.svH);
                j.p(this.hXX, this.svH, false);
            }
            return true;
        }

        public final boolean Bo() {
            synchronized (d.svD) {
                d.svC.remove(this.fyF);
            }
            if (this.svx != null) {
                this.svx.b(this.svH, this.svy);
            }
            return false;
        }
    }

    public d(List<String> list, String str, String str2, g gVar, a aVar) {
        this.svs = list;
        this.svt = new ArrayList();
        this.svu = new ArrayList();
        this.svw = new ArrayList();
        this.svv = new ArrayList();
        this.svx = aVar;
        this.svy = gVar;
        this.svA = str2;
        this.svz = str;
    }

    public final void run() {
        if (this.svs != null && this.svs.size() > 0) {
            for (int i = 0; i < this.svs.size() && !this.isStop; i++) {
                String lv;
                String str;
                w.i("MicroMsg.NoteVideoCompress", "start to import %s", new Object[]{this.svs.toString()});
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.svs.get(i))));
                Context context = ab.getContext();
                StringBuilder stringBuilder = new StringBuilder("note_");
                ap.yY();
                String stringBuilder2 = stringBuilder.append(s.lu((String) c.vr().get(2, ""))).toString();
                String lw;
                if (bg.mA(this.svz) || bg.mA(this.svA)) {
                    o.KV();
                    lw = s.lw(stringBuilder2);
                    o.KV();
                    lv = s.lv(stringBuilder2);
                    str = lw;
                } else {
                    lw = this.svz;
                    stringBuilder2 = this.svA.substring(this.svA.lastIndexOf("/") + 1, this.svA.length());
                    lv = this.svA;
                    str = lw;
                }
                boolean is2G = am.is2G(ab.getContext());
                String h = com.tencent.mm.compatible.i.a.h(context, intent);
                if (bg.mA(h)) {
                    w.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                    a(-50005, stringBuilder2, h, 0, null, context, null);
                } else {
                    VideoTransPara videoTransPara;
                    int i2;
                    Object obj;
                    int i3;
                    com.tencent.mm.compatible.i.a.a i4;
                    boolean mD = com.tencent.mm.plugin.a.c.mD(h);
                    int aN = e.aN(h);
                    if (mD) {
                        VideoTransPara videoTransPara2;
                        PInt pInt = new PInt();
                        if (com.tencent.mm.modelcontrol.d.Eu().iV(h)) {
                            w.i("MicroMsg.NoteVideoCompress", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[]{h});
                            pInt.value = 1;
                            videoTransPara2 = null;
                        } else {
                            VideoTransPara videoTransPara3 = new VideoTransPara();
                            PInt pInt2 = new PInt();
                            PInt pInt3 = new PInt();
                            PInt pInt4 = new PInt();
                            PInt pInt5 = new PInt();
                            PInt pInt6 = new PInt();
                            com.tencent.mm.plugin.sight.base.d.a(h, pInt2, pInt3, pInt4, pInt5, pInt6);
                            videoTransPara3.duration = pInt2.value / 1000;
                            videoTransPara3.width = pInt3.value;
                            videoTransPara3.height = pInt4.value;
                            videoTransPara3.gPE = pInt5.value;
                            videoTransPara3.hzY = pInt6.value;
                            w.d("MicroMsg.NoteVideoCompress", "check remuxing old para %s", new Object[]{videoTransPara3});
                            videoTransPara2 = com.tencent.mm.modelcontrol.d.Eu().a(videoTransPara3);
                            if (videoTransPara2 == null) {
                                w.i("MicroMsg.NoteVideoCompress", "get C2C album video para is null. old para %s", new Object[]{videoTransPara3});
                                pInt.value = -5;
                                videoTransPara2 = null;
                            } else {
                                w.d("MicroMsg.NoteVideoCompress", "check remuxing new para %s", new Object[]{videoTransPara2});
                                if (videoTransPara3.hzY <= 640000 || videoTransPara2.hzY > videoTransPara3.hzY) {
                                    w.i("MicroMsg.NoteVideoCompress", "new bitrate is bigger than old bitrate %s %s", new Object[]{videoTransPara2, videoTransPara3});
                                    pInt.value = 1;
                                    videoTransPara2 = null;
                                } else if (videoTransPara3.gPE < 45 || videoTransPara3.duration * 1000 < 180000) {
                                    boolean is2G2 = am.is2G(ab.getContext());
                                    pInt.value = SightVideoJNI.shouldRemuxing(h, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 20971520, is2G2 ? 60000.0d : 300000.0d, Constants.MAX_BUFFER_SIZE);
                                } else {
                                    pInt.value = -6;
                                    videoTransPara2 = null;
                                }
                            }
                        }
                        videoTransPara = videoTransPara2;
                        i2 = pInt.value;
                    } else {
                        if (aN > (is2G ? 10485760 : 20971520)) {
                            i2 = -5;
                            videoTransPara = null;
                        } else {
                            i2 = 1;
                            videoTransPara = null;
                        }
                    }
                    w.i("MicroMsg.NoteVideoCompress", "check remuxing, ret %d isMp4 %b length %d", new Object[]{Integer.valueOf(i2), Boolean.valueOf(mD), Integer.valueOf(aN)});
                    switch (i2) {
                        case -6:
                        case -4:
                        case -3:
                        case -2:
                            a(-50002, stringBuilder2, h, 0, null, context, null);
                            continue;
                        case -5:
                            a(-50008, stringBuilder2, h, 0, null, context, null);
                            continue;
                        case -1:
                            a(-50007, stringBuilder2, h, 0, null, context, null);
                            continue;
                        case 0:
                            obj = 1;
                            i3 = 0;
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            if (aN <= 20971520) {
                                obj = null;
                                i3 = 0;
                                break;
                            }
                            a(-50002, stringBuilder2, h, 0, null, context, null);
                            obj = null;
                            i3 = -50002;
                            break;
                        default:
                            w.e("MicroMsg.NoteVideoCompress", "unknown check type");
                            a(-50001, stringBuilder2, h, 0, null, context, null);
                            continue;
                    }
                    com.tencent.mm.compatible.i.a.a aVar = null;
                    try {
                        i4 = com.tencent.mm.compatible.i.a.i(context, intent);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "", new Object[0]);
                        i4 = aVar;
                    }
                    if (i4 == null) {
                        w.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                        a(-50005, stringBuilder2, h, 0, null, context, null);
                    } else {
                        Object obj2;
                        if (obj == null) {
                            j.p(h, lv, false);
                        } else {
                            i3 = -50006;
                        }
                        int ex = bg.ex((long) i4.duration);
                        if (i4.bitmap != null) {
                            try {
                                com.tencent.mm.sdk.platformtools.d.a(i4.bitmap, 60, CompressFormat.JPEG, str, true);
                                obj2 = null;
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.NoteVideoCompress", e2, "", new Object[0]);
                            }
                            if (obj2 != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                } catch (Throwable e22) {
                                    w.printErrStackTrace("MicroMsg.NoteVideoCompress", e22, "", new Object[0]);
                                }
                            }
                            if (obj == null && !e.aO(lv)) {
                                i3 = -50003;
                            }
                            if (!e.aO(str)) {
                                i3 = -50004;
                            }
                            a(i3, stringBuilder2, h, ex, videoTransPara, context, str);
                        }
                        int i5 = 1;
                        if (obj2 != null) {
                            com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                        }
                        i3 = -50003;
                        if (e.aO(str)) {
                            i3 = -50004;
                        }
                        a(i3, stringBuilder2, h, ex, videoTransPara, context, str);
                    }
                }
            }
        }
    }

    private void a(final int i, String str, String str2, int i2, VideoTransPara videoTransPara, Context context, final String str3) {
        w.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
        d(i, str, str2, i2);
        if (i == -50002) {
            aM(context, context.getString(R.l.fag));
        } else if (i == -50008) {
            aM(context, context.getString(R.l.fae));
        } else if (i == -50006) {
            if (bg.mA(str)) {
                w.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            } else {
                r rVar = new r();
                rVar.fyF = str;
                rVar.iap = 1;
                rVar.fSf = null;
                ap.yY();
                rVar.iah = (String) c.vr().get(2, "");
                rVar.iam = bg.Ny();
                rVar.ian = bg.Ny();
                rVar.iav = null;
                rVar.hXX = str2;
                if (!bg.mA(str2)) {
                    rVar.iat = 1;
                }
                rVar.hrs = 0;
                o.KV().a(rVar);
            }
            if (svE == null) {
                svE = new ar(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            com.tencent.mm.sdk.platformtools.ar.a bVar = new b();
            synchronized (svD) {
                svC.put(str, bVar);
            }
            bVar.fyF = str;
            bVar.hXX = str2;
            bVar.svH = this.svA;
            bVar.svJ = videoTransPara;
            bVar.svx = this.svx;
            bVar.svy = this.svy;
            svE.c(bVar);
        } else if (i < 0) {
            aM(context, context.getString(R.l.faf));
        } else {
            this.svB = true;
        }
        if (this.svx != null && !this.isStop) {
            af.v(new Runnable(this) {
                final /* synthetic */ d svF;

                public final void run() {
                    this.svF.svx.a(str3, this.svF.svy);
                    if (this.svF.svB || i != -50006) {
                        ap.vL().e(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 svG;

                            {
                                this.svG = r1;
                            }

                            public final void run() {
                                this.svG.svF.svx.b(this.svG.svF.svA, this.svG.svF.svy);
                            }
                        }, 80);
                    }
                }
            });
        }
    }

    private void aM(final Context context, final String str) {
        af.v(new Runnable(this) {
            final /* synthetic */ d svF;

            public final void run() {
                Toast.makeText(context, str, 0).show();
            }
        });
    }

    public static void b(String str, int[] iArr) {
        MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        Throwable th;
        Throwable e;
        int i2;
        int i3;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            } catch (Throwable e2) {
                th = e2;
                i2 = 0;
                try {
                    w.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    i = i2;
                    i2 = 0;
                    iArr[0] = i;
                    iArr[1] = i2;
                    i3 = i;
                    i = 0;
                    while (i < 3) {
                        if (i3 % 2 == 0) {
                            return;
                        }
                        return;
                    }
                    iArr[0] = i3;
                    iArr[1] = i2;
                } catch (Throwable th2) {
                    e2 = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw e2;
                }
            }
            try {
                i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
            } catch (Throwable e22) {
                Throwable th3 = e22;
                i2 = i;
                th = th3;
                w.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                i = i2;
                i2 = 0;
                iArr[0] = i;
                iArr[1] = i2;
                i3 = i;
                i = 0;
                while (i < 3) {
                    if (i3 % 2 == 0) {
                        return;
                    }
                    return;
                }
                iArr[0] = i3;
                iArr[1] = i2;
            }
        } catch (Throwable e222) {
            mediaMetadataRetriever = null;
            th = e222;
            i2 = 0;
            w.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            i = i2;
            i2 = 0;
            iArr[0] = i;
            iArr[1] = i2;
            i3 = i;
            i = 0;
            while (i < 3) {
                if (i3 % 2 == 0) {
                    return;
                }
                return;
            }
            iArr[0] = i3;
            iArr[1] = i2;
        } catch (Throwable th4) {
            e222 = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw e222;
        }
        iArr[0] = i;
        iArr[1] = i2;
        i3 = i;
        i = 0;
        while (i < 3) {
            if (i3 % 2 == 0 && i2 % 2 == 0) {
                if ((i3 >= i2 && (i3 <= 640 || i2 <= 480)) || (i3 <= i2 && (i3 <= 480 || i2 <= 640))) {
                    break;
                }
                i3 /= 2;
                i2 /= 2;
                i++;
            } else {
                return;
            }
        }
        iArr[0] = i3;
        iArr[1] = i2;
    }

    private synchronized void d(int i, String str, String str2, int i2) {
        this.svt.add(Integer.valueOf(i));
        this.svu.add(str);
        this.svv.add(str2);
        this.svw.add(Integer.valueOf(i2));
    }
}
