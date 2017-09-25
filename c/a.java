package c;

import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.wcdb.FileUtils;

public abstract class a {
    public final int height;
    public final int width;

    public abstract byte[] aYY();

    public abstract byte[] k(int i, byte[] bArr);

    public a(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        byte[] bArr = new byte[this.width];
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.height; i++) {
            bArr2 = k(i, bArr2);
            for (int i2 = 0; i2 < this.width; i2++) {
                char c;
                int i3 = bArr2[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < FileUtils.S_IWUSR) {
                    c = '+';
                } else if (i3 < bg.CTRL_INDEX) {
                    c = '.';
                } else {
                    c = ' ';
                }
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
