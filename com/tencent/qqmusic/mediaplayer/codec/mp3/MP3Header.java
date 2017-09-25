package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;

class MP3Header {
    public static final int MPEG1 = 3;
    public static final int MPEG2 = 2;
    public static final int MPEG25 = 0;
    private int[][][] bitrate;
    private int bitrate_index;
    private int framesize;
    private int layer;
    private int lsf;
    private int mode;
    private int mode_extension;
    private int padding;
    private int protection_bit;
    private int[][] samplingRate = new int[][]{new int[]{11025, 12000, 8000, 0}, new int[]{0, 0, 0, 0}, new int[]{22050, 24000, 16000, 0}, new int[]{44100, 48000, 32000, 0}};
    private int sampling_frequency;
    private int sideinfosize;
    private int verID;

    MP3Header() {
        r0 = new int[2][][];
        r0[0] = new int[][]{new int[]{0, 32, 64, 96, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, bg.CTRL_INDEX, 224, 256, 288, 320, 352, 384, 416, FileUtils.S_IRWXU}, new int[]{0, 32, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, bg.CTRL_INDEX, 224, 256, 320, 384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, bg.CTRL_INDEX, 224, 256, 320}};
        r0[1] = new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, f.CTRL_INDEX, JsApiSetBackgroundAudioState.CTRL_INDEX, 176, bg.CTRL_INDEX, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, f.CTRL_INDEX, JsApiSetBackgroundAudioState.CTRL_INDEX}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, f.CTRL_INDEX, JsApiSetBackgroundAudioState.CTRL_INDEX}};
        this.bitrate = r0;
    }

    protected void initialize() {
        this.framesize = 0;
        this.sideinfosize = 0;
        this.layer = 0;
        this.verID = 1;
    }

    protected void decode(int i) {
        int i2 = 17;
        this.verID = (i >> 19) & 3;
        this.layer = 4 - ((i >> 17) & 3);
        this.protection_bit = (i >> 16) & 1;
        this.bitrate_index = (i >> 12) & 15;
        this.sampling_frequency = (i >> 10) & 3;
        this.padding = (i >> 9) & 1;
        this.mode = (i >> 6) & 3;
        this.mode_extension = (i >> 4) & 3;
        this.lsf = this.verID == 3 ? 0 : 1;
        switch (this.layer) {
            case 1:
                this.framesize = this.bitrate[this.lsf][0][this.bitrate_index] * 12000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
                this.framesize += this.padding;
                this.framesize <<= 2;
                return;
            case 2:
                this.framesize = this.bitrate[this.lsf][1][this.bitrate_index] * 144000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
                this.framesize += this.padding;
                return;
            case 3:
                this.framesize = this.bitrate[this.lsf][2][this.bitrate_index] * 144000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency] << this.lsf;
                this.framesize += this.padding;
                if (this.verID == 3) {
                    this.sideinfosize = this.mode == 3 ? 17 : 32;
                    return;
                }
                if (this.mode == 3) {
                    i2 = 9;
                }
                this.sideinfosize = i2;
                return;
            default:
                return;
        }
    }

    public int getFrameSize() {
        return this.framesize;
    }

    public boolean isProtected() {
        return this.protection_bit == 0;
    }
}
