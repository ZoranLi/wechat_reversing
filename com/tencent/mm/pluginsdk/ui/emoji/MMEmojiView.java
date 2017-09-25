package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.m.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import java.io.IOException;

public class MMEmojiView extends MMGIFImageView {
    private c kPz;
    private int mScreenWidth;
    private int sRu;
    private int sRv;
    boolean sRw = true;

    public MMEmojiView(Context context) {
        this(context, null);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sRw = false;
        init(context);
    }

    private void init(Context context) {
        this.sRu = context.getResources().getDimensionPixelSize(a.c.kDz);
        this.sRv = context.getResources().getDimensionPixelSize(a.c.lab);
        this.mScreenWidth = com.tencent.mm.bg.a.dO(context);
    }

    public final void a(c cVar, String str) {
        this.kPz = cVar;
        String eN = cVar.eN(cVar.field_groupId, cVar.EP());
        if ((cVar.field_reserved4 & c.uLn) != c.uLn) {
            cs(eN, str);
        } else if (b.aCV().yh(str) != null) {
            setImageDrawable(b.aCV().yh(str));
        } else {
            a(this.kPz, ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().g(this.kPz), str);
        }
    }

    public final void a(c cVar, byte[] bArr, String str) {
        this.kPz = cVar;
        try {
            if (!bg.bm(bArr)) {
                Drawable aVar;
                if (bg.mA(str)) {
                    aVar = new com.tencent.mm.plugin.gif.a(bArr);
                } else {
                    this.kHX = str;
                    aVar = b.aCV().p(this.kHX, bArr);
                }
                setImageDrawable(aVar);
                return;
            }
        } catch (MMGIFException e) {
            MMGIFImageView.a(e);
            if (e.getErrorCode() == 103) {
                w.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bd = d.bd(bArr);
                if (bd != null) {
                    bd.setDensity(320);
                    setImageBitmap(bd);
                    return;
                }
                w.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                if (this.kPz != null) {
                    this.kPz.bNs();
                    w.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
                init();
                return;
            }
            w.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
            if (this.kPz != null) {
                this.kPz.bNs();
                w.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
        } catch (IOException e2) {
            w.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
        }
        if (this.kPz != null) {
            this.kPz.bNs();
            w.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        }
        init();
    }

    protected void onMeasure(int i, int i2) {
        float f;
        int i3 = 0;
        super.onMeasure(i, i2);
        int intrinsicWidth = getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
        if (getDrawable() != null) {
            i3 = getDrawable().getIntrinsicHeight();
        }
        if (this.kPz != null && intrinsicWidth == 0 && r1 == 0) {
            intrinsicWidth = (int) (((float) this.kPz.field_width) * aCU());
            i3 = (int) (((float) this.kPz.field_height) * aCU());
        }
        if (i3 < this.sRv || intrinsicWidth < this.sRv) {
            if (intrinsicWidth < i3) {
                f = ((float) this.sRv) / ((float) intrinsicWidth);
                intrinsicWidth = this.sRv;
                i3 = (int) (((float) i3) * f);
            } else if (i3 < intrinsicWidth) {
                f = ((float) this.sRv) / ((float) i3);
                i3 = this.sRv;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                i3 = this.sRv;
                intrinsicWidth = this.sRv;
            }
        }
        if (this.sRw) {
            if (intrinsicWidth > this.sRu || i3 > this.sRu) {
                if (intrinsicWidth > i3) {
                    f = ((float) this.sRu) / ((float) intrinsicWidth);
                    intrinsicWidth = this.sRu;
                    i3 = (int) (((float) i3) * f);
                } else if (i3 > intrinsicWidth) {
                    f = ((float) this.sRu) / ((float) i3);
                    i3 = this.sRu;
                    intrinsicWidth = (int) (((float) intrinsicWidth) * f);
                } else {
                    intrinsicWidth = this.sRu;
                    i3 = this.sRu;
                }
            }
        } else if (intrinsicWidth > this.mScreenWidth || i3 > this.mScreenWidth) {
            if (intrinsicWidth > i3) {
                f = ((float) this.mScreenWidth) / ((float) intrinsicWidth);
                intrinsicWidth = this.mScreenWidth;
                i3 = (int) (((float) i3) * f);
            } else if (i3 > intrinsicWidth) {
                f = ((float) this.mScreenWidth) / ((float) i3);
                i3 = this.mScreenWidth;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.mScreenWidth;
                i3 = this.mScreenWidth;
            }
        }
        setMeasuredDimension(intrinsicWidth, i3);
    }
}
