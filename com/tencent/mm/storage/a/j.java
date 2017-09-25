package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class j extends i<i> implements com.tencent.mm.bj.f.a {
    public static final String[] gUx = new String[]{i.a(i.gTP, "EmotionDesignerInfo")};
    public e gUz;

    public enum a {
        DesignerSimpleInfo(0),
        PersonalDesigner(1),
        DesignerEmojiList(2);
        
        public int value;

        private a(int i) {
            this.value = i;
        }
    }

    public j(e eVar) {
        super(eVar, i.gTP, "EmotionDesignerInfo", null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final xk Sl(String str) {
        Cursor a;
        xk xkVar;
        Throwable e;
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            return null;
        }
        try {
            a = this.gUz.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.DesignerSimpleInfo.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        xkVar = new xk();
                        xkVar.aD(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return xkVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bg.g(e)});
                        if (a == null) {
                            xkVar = null;
                        } else {
                            a.close();
                            xkVar = null;
                        }
                        return xkVar;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            xkVar = null;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bg.g(e)});
            if (a == null) {
                a.close();
                xkVar = null;
            } else {
                xkVar = null;
            }
            return xkVar;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return xkVar;
    }

    public final xi Sm(String str) {
        Cursor a;
        xi xiVar;
        Throwable e;
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            return null;
        }
        try {
            a = this.gUz.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.DesignerEmojiList.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        xiVar = new xi();
                        xiVar.aD(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return xiVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bg.g(e)});
                        if (a == null) {
                            a.close();
                            xiVar = null;
                        } else {
                            xiVar = null;
                        }
                        return xiVar;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            xiVar = null;
            if (a != null) {
                a.close();
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bg.g(e)});
            if (a == null) {
                xiVar = null;
            } else {
                a.close();
                xiVar = null;
            }
            return xiVar;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return xiVar;
    }
}
