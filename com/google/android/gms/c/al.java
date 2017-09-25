package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.HashMap;
import java.util.Map;

public final class al extends af<al> {
    public String aBe;
    public int aBf;
    public int aBg;
    public int aBh;
    public int aBi;
    public int aBj;

    public final /* synthetic */ void a(af afVar) {
        al alVar = (al) afVar;
        if (this.aBf != 0) {
            alVar.aBf = this.aBf;
        }
        if (this.aBg != 0) {
            alVar.aBg = this.aBg;
        }
        if (this.aBh != 0) {
            alVar.aBh = this.aBh;
        }
        if (this.aBi != 0) {
            alVar.aBi = this.aBi;
        }
        if (this.aBj != 0) {
            alVar.aBj = this.aBj;
        }
        if (!TextUtils.isEmpty(this.aBe)) {
            alVar.aBe = this.aBe;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.aBe);
        hashMap.put("screenColors", Integer.valueOf(this.aBf));
        hashMap.put("screenWidth", Integer.valueOf(this.aBg));
        hashMap.put("screenHeight", Integer.valueOf(this.aBh));
        hashMap.put("viewportWidth", Integer.valueOf(this.aBi));
        hashMap.put("viewportHeight", Integer.valueOf(this.aBj));
        return af.ac(hashMap);
    }
}
