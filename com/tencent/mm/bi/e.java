package com.tencent.mm.bi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import java.util.ArrayList;

public class e {
    private static e uyu = null;
    private String[] uyv;
    private String[] uyw;
    private String[] uyx;
    private ArrayList<u> uyy = new ArrayList();
    private SparseArray<u> uyz = new SparseArray();

    public e(Context context) {
        this.uyv = context.getResources().getStringArray(a.aSi);
        this.uyw = context.getResources().getStringArray(a.aSj);
        this.uyx = context.getResources().getStringArray(a.aSk);
        this.uyy.clear();
        this.uyz.clear();
        bKC();
    }

    private void bKC() {
        int i = 0;
        if (this.uyv != null && this.uyw != null) {
            int length = this.uyv.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                u uVar = new u(i3, this.uyv[i2]);
                this.uyy.add(uVar);
                this.uyz.put(i3, uVar);
                i2++;
                i3++;
            }
            i2 = this.uyw.length;
            while (i < i2) {
                u uVar2 = new u(i3, this.uyw[i]);
                this.uyy.add(uVar2);
                this.uyz.put(i3, uVar2);
                i++;
                i3++;
            }
        }
    }

    public void YY() {
        w.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.uyy.clear();
        ArrayList alF = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().alF();
        if (alF == null || alF.isEmpty()) {
            bKC();
            return;
        }
        ArrayList alE = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().alE();
        int size = alF.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            u uVar = (u) alF.get(i);
            String str = uVar.field_key;
            if (!str.startsWith("[") || alE.contains(str)) {
                this.uyy.add(uVar);
                this.uyz.put(i2, uVar);
                i3 = i2 + 1;
            } else {
                w.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
    }

    public int YZ() {
        return this.uyy == null ? 0 : this.uyy.size();
    }

    public static e bKD() {
        if (uyu == null) {
            synchronized (e.class) {
                uyu = new e(ab.getContext());
            }
        }
        return uyu;
    }

    public Drawable iP(int i) {
        if (this.uyz == null) {
            w.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            return null;
        }
        u uVar = (u) this.uyz.get(i);
        if (uVar == null) {
            w.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            return null;
        }
        Drawable iP;
        s QB = f.bKE().QB(uVar.field_key);
        int i2;
        if (QB != null) {
            f.bKE();
            i2 = QB.field_position;
            iP = i2 >= 0 ? b.bKy().iP(i2) : f.QA(QB.field_fileName);
        } else {
            c cVar;
            b bKy = b.bKy();
            String str = uVar.field_key;
            if (bg.mA(str)) {
                w.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                cVar = bKy.yz(i2) != null ? bKy.yz(i2) : bKy.dO(i2, 0);
            }
            iP = b.bKy().a(cVar);
        }
        return iP;
    }

    public String getText(int i) {
        if (i < 0) {
            w.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        u uVar = (u) this.uyy.get(i);
        if (uVar == null) {
            return "";
        }
        s QB = f.bKE().QB(uVar.field_key);
        if (QB != null) {
            if (v.bIK() && !bg.mA(QB.field_cnValue)) {
                return QB.field_cnValue;
            }
            if (v.bIL() && !bg.mA(QB.field_twValue)) {
                return QB.field_twValue;
            }
        }
        return uVar.field_key;
    }

    public String iR(int i) {
        if (i < 0) {
            w.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        u uVar = (u) this.uyy.get(i);
        if (uVar != null) {
            return uVar.field_key;
        }
        return "";
    }

    public String iQ(int i) {
        if (i < 0) {
            w.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            return "";
        }
        b gyVar = new gy();
        com.tencent.mm.sdk.b.a.urY.m(gyVar);
        if ((gyVar.fMn.fFY == 1 ? 1 : 0) == 0) {
            return bKD().uyw[i];
        }
        String[] split = bKD().uyw[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        return stringBuilder.toString();
    }
}
