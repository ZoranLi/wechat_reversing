package com.tencent.mm.plugin.photoedit.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager okM;
    public static HashMap<String, a> okN = new HashMap();
    private static HashSet<com.tencent.mm.plugin.photoedit.b.a> okO = new HashSet();

    class a {
        final /* synthetic */ ArtistCacheManager okP;
        HashMap<com.tencent.mm.plugin.photoedit.b.a, c> okQ = new HashMap();

        public a(ArtistCacheManager artistCacheManager) {
            this.okP = artistCacheManager;
            this.okQ.put(com.tencent.mm.plugin.photoedit.b.a.EMOJI_AND_TEXT, new c());
            ((c) this.okQ.get(com.tencent.mm.plugin.photoedit.b.a.EMOJI_AND_TEXT)).onCreate();
            this.okQ.put(com.tencent.mm.plugin.photoedit.b.a.MOSAIC, new d());
            ((c) this.okQ.get(com.tencent.mm.plugin.photoedit.b.a.MOSAIC)).onCreate();
            this.okQ.put(com.tencent.mm.plugin.photoedit.b.a.DOODLE, new b());
            ((c) this.okQ.get(com.tencent.mm.plugin.photoedit.b.a.DOODLE)).onCreate();
            this.okQ.put(com.tencent.mm.plugin.photoedit.b.a.CROP, new a());
            ((c) this.okQ.get(com.tencent.mm.plugin.photoedit.b.a.CROP)).onCreate();
        }
    }

    public static ArtistCacheManager aSf() {
        if (okM == null) {
            okM = new ArtistCacheManager();
        }
        return okM;
    }

    public static <T extends c> T a(String str, com.tencent.mm.plugin.photoedit.b.a aVar) {
        if (okN.containsKey(str)) {
            a aVar2 = (a) okN.get(str);
            if (aVar2.okQ.containsKey(aVar)) {
                return (c) aVar2.okQ.get(aVar);
            }
            w.e("MicroMsg.ArtistCacheManager.CacheFactory", "type:%s can't find this cache!", aVar);
            return null;
        }
        w.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains !");
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        w.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm..plugin.photoedit.action.clear")) {
            aSg();
        }
    }

    public final void aSg() {
        w.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
        for (Entry value : okN.entrySet()) {
            for (Entry value2 : ((a) value.getValue()).okQ.entrySet()) {
                ((c) value2.getValue()).onDestroy();
            }
        }
        okO.clear();
        okM = null;
        e.bKs();
        e.post(new Runnable(this) {
            final /* synthetic */ ArtistCacheManager okP;

            {
                this.okP = r1;
            }

            public final void run() {
                int i = 0;
                w.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", com.tencent.mm.compatible.util.e.gSy);
                File file = new File(r1);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        while (i < length) {
                            File file2 = listFiles[i];
                            if (file2.isFile() && !bg.mA(file2.getName()) && file2.getName().startsWith("wx_photo_edit_")) {
                                file2.delete();
                            }
                            i++;
                        }
                    }
                }
            }
        }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    }

    public static HashSet<com.tencent.mm.plugin.photoedit.b.a> aSh() {
        return okO;
    }
}
