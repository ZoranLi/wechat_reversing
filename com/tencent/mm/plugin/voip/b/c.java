package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public int mState;
    public Map<Integer, Map<Integer, Integer>> roe;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void P(int i, int i2, int i3) {
        Map map;
        if (this.roe == null) {
            this.roe = new HashMap();
        }
        if (this.roe.containsKey(Integer.valueOf(i))) {
            map = (Map) this.roe.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.roe.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final boolean vl(int i) {
        if (this.roe == null || !this.roe.containsKey(Integer.valueOf(this.mState))) {
            w.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[]{b.vf(this.mState)});
            return false;
        } else if (((Map) this.roe.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            return true;
        } else {
            w.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[]{b.vf(this.mState), b.vf(i)});
            return false;
        }
    }
}
