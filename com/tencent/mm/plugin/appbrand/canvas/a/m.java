package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;

public final class m implements c {
    public final String getMethod() {
        return FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION;
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        canvas.rotate((float) ((((double) ((float) jSONArray.optDouble(0))) / 3.141592653589793d) * 180.0d));
        return true;
    }
}
