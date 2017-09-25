package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> mEk;
    public boolean mGg = false;

    private static class a {
        public static a mGh = new a();
    }

    public final synchronized void clearCache() {
        if (this.mEk != null) {
            this.mEk.clear();
        }
        this.mGg = false;
    }

    public final synchronized void aCe() {
        if (this.mEk != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.mEk.values()) {
                aVar.mEj = false;
            }
        }
    }

    public final synchronized void aCf() {
        if (this.mEk == null) {
            this.mEk = new LinkedHashMap();
        }
        if (this.mEk.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = ab.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        w.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bg.g(e)});
                    }
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bg.g(e2)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (Throwable e22) {
                        w.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bg.g(e22)});
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        w.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{bg.g(e3)});
                    }
                }
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    w.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[]{split[r0]});
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.mEg = split2[0];
                    aVar.mEh = split2[1];
                    aVar.mEi = split2[2];
                    aVar.gkH = split2[3];
                    aVar.mEj = false;
                    aVar.isDefault = false;
                    this.mEk.put(aVar.gkH, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.mEk.get(e.aAD());
            if (aVar2 != null) {
                com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.mGh.aCg().get(e.aAD());
                StringBuffer stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.mEg);
                    stringBuffer.append(e.xO("zh_CN"));
                }
                aVar2.mEg = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.mGh.aCg().get(e.aAD());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.mEh);
                    stringBuffer.append(e.xO("zh_TW"));
                }
                aVar2.mEh = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.mGh.aCg().get(e.aAD());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.mEi);
                    stringBuffer.append(e.xO("en"));
                }
                aVar2.mEi = stringBuffer.toString();
                aVar2.isDefault = true;
            }
        }
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> aCg() {
        aCf();
        return this.mEk;
    }
}
