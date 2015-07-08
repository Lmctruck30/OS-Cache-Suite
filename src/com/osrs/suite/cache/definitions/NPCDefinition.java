package com.osrs.suite.cache.definitions;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.store.Store;
import com.osrs.suite.cache.renderable.model.Model;
import com.osrs.suite.cache.renderable.model.ModelRasterizer;
import com.osrs.suite.utilities.StringUtilities;

/**
 * Created by Allen Kinzalow on 3/15/2015.
 */
public class NPCDefinition extends Definition {

    public final static int INDEX_ID = 2;
    public final static int ARCHIVE_ID = 9;

    public short[] recolorToFind;
    public int anInt2156 = 32;
    public String name = "null";
    public short[] recolorToReplace;
    public int[] models;
    public int[] models_2;
    public int stanceAnimation = -1;
    public int anInt2165 = -1;
    public int tileSpacesOccupied = 1;
    public int walkAnimation = -1;
    public short[] retextureToReplace;
    public int rotate90RightAnimation = -1;
    public boolean aBool2170 = true;
    public int resizeX = 128;
    public int contrast = 0;
    public int rotate180Animation = -1;
    public int anInt2174 = -1;
    public String[] options = new String[5];
    public boolean renderOnMinimap = true;
    public int combatLevel = -1;
    public int rotate90LeftAnimation = -1;
    public int resizeY = 128;
    public boolean hasRenderPriority = false;
    public int ambient = 0;
    public int headIcon = -1;
    public int anInt2184 = 30;
    public int[] anIntArray2185;
    public short[] retextureToFind;
    public int anInt2187 = -1;
    public boolean isClickable = true;
    public int anInt2189 = -1;
    public boolean aBool2190 = false;

    public NPCDefinition(int definitionID) {
        super(definitionID);
    }

    @Override
    OutputStream encode(OutputStream stream) {
        return null;
    }

    @Override
    void decodeValues(int opcode, InputStream stream) {
        int length;
        int index;
        if(1 == opcode) {
            length = stream.readUnsignedByte();
            this.models = new int[length];

            for(index = 0; index < length; ++index) {
                this.models[index] = stream.readUnsignedShort();
            }

        } else if(2 == opcode) {
            this.name = StringUtilities.readString_2(stream);
        } else if(12 == opcode) {
            this.tileSpacesOccupied = stream.readUnsignedShort();
        } else if(opcode == 13) {
            this.stanceAnimation = stream.readUnsignedShort();
        } else if(opcode == 14) {
            this.walkAnimation = stream.readUnsignedShort();
        } else if(15 == opcode) {
            this.anInt2165 = stream.readUnsignedShort();
        } else if(opcode == 16) {
            this.anInt2189 = stream.readUnsignedShort();
        } else if(17 == opcode) {
            this.walkAnimation = stream.readUnsignedShort();
            this.rotate180Animation = stream.readUnsignedShort();
            this.rotate90RightAnimation = stream.readUnsignedShort();
            this.rotate90LeftAnimation = stream.readUnsignedShort();
        } else if(opcode >= 30 && opcode < 35) {
            this.options[opcode - 30] = StringUtilities.readString_2(stream);
            if(this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
                this.options[opcode - 30] = null;
            }
        } else if(opcode == 40) {
            length = stream.readUnsignedByte();
            this.recolorToFind = new short[length];
            this.recolorToReplace = new short[length];

            for(index = 0; index < length; ++index) {
                this.recolorToFind[index] = (short)stream.readUnsignedShort();
                this.recolorToReplace[index] = (short)stream.readUnsignedShort();
            }

        } else if(opcode == 41) {
            length = stream.readUnsignedByte();
            this.retextureToFind = new short[length];
            this.retextureToReplace = new short[length];

            for(index = 0; index < length; ++index) {
                this.retextureToFind[index] = (short)stream.readUnsignedShort();
                this.retextureToReplace[index] = (short)stream.readUnsignedShort();
            }

        } else if(60 != opcode) {
            if(opcode == 93) {
                this.renderOnMinimap = false;
            } else if(95 == opcode) {
                this.combatLevel = stream.readUnsignedShort();
            } else if(97 == opcode) {
                this.resizeX = stream.readUnsignedShort();
            } else if(98 == opcode) {
                this.resizeY = stream.readUnsignedShort();
            } else if(opcode == 99) {
                this.hasRenderPriority = true;
            } else if(100 == opcode) {
                this.ambient = stream.readByte();
            } else if(101 == opcode) {
                this.contrast = stream.readByte();
            } else if(opcode == 102) {
                this.headIcon = stream.readUnsignedShort();
            } else if(103 == opcode) {
                this.anInt2156 = stream.readUnsignedShort();
            } else if(opcode == 106) {
                this.anInt2174 = stream.readUnsignedShort();
                if('\uffff' == this.anInt2174) {
                    this.anInt2174 = -1;
                }

                this.anInt2187 = stream.readUnsignedShort();
                if('\uffff' == this.anInt2187) {
                    this.anInt2187 = -40212193;
                }

                length = stream.readUnsignedByte();
                this.anIntArray2185 = new int[length + 1];

                for(index = 0; index <= length; ++index) {
                    this.anIntArray2185[index] = stream.readUnsignedShort();
                    if(this.anIntArray2185[index] == '\uffff') {
                        this.anIntArray2185[index] = -1;
                    }
                }

            } else if(107 == opcode) {
                this.isClickable = false;
            } else if(opcode == 109) {
                this.aBool2170 = false;
            } else if(opcode == 111) {
                this.aBool2190 = true;
            } else if(opcode == 112) {
                this.anInt2184 = stream.readUnsignedByte();
            }
        } else {
            length = stream.readUnsignedByte();
            this.models_2 = new int[length];

            for(index = 0; index < length; ++index) {
                this.models_2[index] = stream.readUnsignedShort();
            }

        }
    }

    public final ModelRasterizer getModelRasterizer(Store store, AnimationDefinition var1, int var2, AnimationDefinition var3, int var4, byte var5) {
        /*if(this.anIntArray2185 != null) {
            NPCDefinition def = this.method2290(1617209938);
            return null == def ? null : def.getModelRasterizer(var1, var2, var3, var4, (byte) 1);
        } else {*/
            ModelRasterizer rasterizer = /*(ModelRasterizer)npcRasterizerMap.get((long)(this.npcID * 140673707))*/null;
            if(rasterizer == null) {
                boolean hasModel = false;

                for(int var9 = 0; var9 < this.models.length; ++var9) {
                    if(!store.getIndexes()[7].fileExists(this.models[var9], 0)) {
                        hasModel = true;
                    }
                }

                if(hasModel) {
                    return null;
                }

                Model[] models = new Model[this.models.length];

                int index;
                for(index = 0; index < this.models.length; ++index) {
                    models[index] = Model.decodeModel(store, this.models[index], 0);
                }

                Model model;
                if(1 == models.length) {
                    model = models[0];
                } else {
                    model = new Model(models, models.length); // combine the models
                }

                if(this.recolorToFind != null) {
                    for(index = 0; index < this.recolorToFind.length; ++index) {
                        model.findReplaceColor(this.recolorToFind[index], this.recolorToReplace[index]);
                    }
                }

                if(null != this.retextureToFind) {
                    for(index = 0; index < this.retextureToFind.length; ++index) {
                        model.findReplaceTexture(this.retextureToFind[index], this.retextureToReplace[index]);
                    }
                }

                rasterizer = model.createModelRasterizer(64 + this.ambient * -611325299, this.contrast * -656507131 + 850, -30, -50, -30);
                //npcRasterizerMap.put(rasterizer, (long)(this.npcID * 140673707));
            }

            ModelRasterizer modifiedRasterizer;
            if(null != var1 && null != var3) {
                modifiedRasterizer = var1.method2265(store, rasterizer, var2, var3, var4, (byte)-62);
            } else if(null != var1) {
                modifiedRasterizer = var1.method2229(store, rasterizer, var2);
            } else if(var3 != null) {
                modifiedRasterizer = var3.method2229(store, rasterizer, var4);
            } else {
                modifiedRasterizer = rasterizer.method2852(true);
            }

            if(128 != this.resizeX * 1618316721 || 128 != this.resizeY * 1034256035) {
                modifiedRasterizer.resizeModel(this.resizeX * 1618316721, this.resizeY * 1034256035, this.resizeX * 1618316721);
            }

            return modifiedRasterizer;
        //}
    }
    
    @Override
    public void printDefinition() {

    }
}
