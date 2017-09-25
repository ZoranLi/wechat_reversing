package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class c {
    private static int aMU = 0;
    private static c mek = null;
    public static boolean mel = false;
    public static boolean mem = false;
    public static boolean men = false;
    public static boolean meo = false;
    private l mef;
    private a meg;
    private e meh;
    private ArrayList<MediaItem> mei = null;
    private LinkedHashSet<MediaItem> mej = new LinkedHashSet();
    private HashSet<MediaItem> mep = new HashSet();
    private ArrayList<Bundle> meq = new ArrayList();
    private HashMap<Integer, Boolean> mer = new HashMap();

    public static MediaItem xm(String str) {
        MediaItem a = MediaItem.a(0, 0, str, "", "");
        if (ayi().mei != null) {
            int indexOf = ayi().mei.indexOf(a);
            if (indexOf >= 0) {
                return (MediaItem) ayi().mei.get(indexOf);
            }
        }
        return null;
    }

    private c() {
        if (this.meg == null) {
            this.meg = new a();
        }
        if (this.mef == null) {
            this.mef = new l();
        }
        if (this.meh == null) {
            this.meh = new e();
        }
    }

    private static c ayi() {
        if (mek == null) {
            mek = new c();
        }
        return mek;
    }

    public static a ayj() {
        return ayi().meg;
    }

    public static l ayk() {
        return ayi().mef;
    }

    public static e ayl() {
        return ayi().meh;
    }

    public static void initialize() {
        synchronized (c.class) {
            aMU++;
        }
    }

    public static void er(boolean z) {
        synchronized (c.class) {
            if (aMU > 0) {
                aMU--;
            }
            if (z && aMU == 0) {
                ayi().mef = null;
                if (ayi().meg != null) {
                    b bVar = ayi().meg.mdQ;
                    if (bVar.meb != null) {
                        bVar.meb.a(new a<String, a>(bVar) {
                            final /* synthetic */ b mee;

                            {
                                this.mee = r1;
                            }
                        });
                        bVar.meb = null;
                    }
                    if (bVar.mec != null) {
                        d dVar = bVar.mec;
                        dVar.ayt();
                        dVar.ayu();
                        dVar.ayw();
                        bVar.mec = null;
                    }
                    ayi().meg = null;
                }
                e eVar = ayi().meh;
                if (eVar.mew != null) {
                    eVar.mew.quit();
                    eVar.mew = null;
                }
                eVar.mez = null;
                if (eVar.mex != null) {
                    eVar.mex.quit();
                    eVar.mex = null;
                }
                eVar.meA = null;
                if (eVar.mey != null) {
                    eVar.mey.quit();
                    eVar.mey = null;
                }
                eVar.meB = null;
                ayi().meh = null;
                mek = null;
            }
        }
    }

    public static ArrayList<MediaItem> aym() {
        return ayi().mei;
    }

    public static HashSet<MediaItem> ayn() {
        return ayi().mep;
    }

    public static ArrayList<Bundle> ayo() {
        return ayi().meq;
    }

    public static LinkedHashSet<MediaItem> ayp() {
        return ayi().mej;
    }

    public static void z(ArrayList<MediaItem> arrayList) {
        ayi().mei = arrayList;
    }

    public static void mW(int i) {
        ayi().mer.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public static void ayq() {
        ayi().mer.clear();
    }

    public static int ayr() {
        return ayi().mer.size();
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, int i, boolean z) {
        w.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (aVar == null) {
            w.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        int i2;
        int size;
        if (ayi().mef.ayM() == 3) {
            i2 = 1;
        } else if (ayi().mef.ayM() == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (ayi().mep != null) {
            size = ayi().mep.size();
        } else {
            size = 0;
        }
        w.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size)});
        if (size > 0) {
            aVar.aa(13858, i2 + "," + i + "," + size + ",0");
        }
        w.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[]{Boolean.valueOf(aVar.es(true))});
        Iterator it = ayi().meq.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!r4) {
                w.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[]{string});
                FileOp.deleteFile(string);
                d.b(string, ab.getContext());
            }
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z2 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z3 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.GalleryCore";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z2 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(z3 ? 1 : 0);
            w.i(str, str2, objArr);
            if (size > 0) {
                try {
                    aVar.aa(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z2 ? 1 : 0) + "," + i7 + ",2" + (z3 ? 1 : 0));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        switch (ayi().mef.ayM()) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!bg.mA(str) && str.equals(ab.getContext().getString(R.l.ehy))) {
                    i = 6;
                    break;
                }
            case 7:
            case 8:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        w.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[]{Integer.valueOf(r4)});
        if (aVar == null) {
            w.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        try {
            aVar.aa(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + mel + "," + mem + "," + men + "," + meo);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        mel = false;
        mem = false;
        men = false;
        meo = false;
    }
}
