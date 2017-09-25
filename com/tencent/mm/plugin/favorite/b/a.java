package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.b.ax;

public final class a extends ax {
    protected static com.tencent.mm.sdk.e.c.a gTP = ax.pw();

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final boolean atb() {
        if (this.field_dataType == 4) {
            return true;
        }
        return false;
    }

    public final boolean isFinished() {
        return this.field_status == 3;
    }

    public final float getProgress() {
        return Math.max(0.0f, Math.min(99.0f, ((float) this.field_offset) / ((float) this.field_totalLen)) * 100.0f);
    }
}
