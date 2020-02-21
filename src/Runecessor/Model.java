package Runecessor;

import java.util.ArrayList;

public class Model extends SceneNode {

	/**
	 * Add pre-eoc models ids here that have visual bugs, to see if it fixes it.
	 */
	private final static int[] removeInvisibleFixFrom622Models = {
			// Vesta's plateskirt.
			42633,
			42649,
	};

	/**
	 * Add pre-eoc model ids here to make them work with the Osrs client.
	 */
    private final static int[] read622Models =
            {

                    44733, // Tormented demon pet inventory model
                    51847, // Ice strykewyrm model
                    51849, // Ice strykewyrm model

                    44629, // Tormented demon melee gfx model
                    44666, // Tormented demon magic projectile
                    65000, // Revenant dark beast
                    65003, // Revenant ork
                    44450, // Revenant dragon
                    44451, // Revenant werewolf
                    65270, // Completionist cape inventory model
                    65297, // Completionist cape male model
                    65316, // Completionist cape female model

                    // Veteran cape models
                    65261,
                    65305,
                    65318,

                    // Hood models
                    65292,
                    65310,
                    65271,
                    65289,
                    65314,

                    //PvP armour models
                    42591,
                    42627,
                    42642,
                    42588,
                    42634,
                    42645,
                    42604,
                    42638,
                    42653,
                    42578,
                    42626,
                    42643,
                    42603,
                    42631,
                    42646,
                    42583,
                    42636,
                    42652,
                    42602,
                    42625,
                    42641,
                    42593,
                    42624,
                    42644,
                    42590,
                    42632,
                    42647,
                    42581,
                    42633,
                    42649,
                    42596,
                    42639,
                    42655,

                    62714,
                    62699,
                    62701,
                    62710,
                    62704,
                    62700,
                    62692,
                    62693,
                    62709,
                    62695,
                    54286,
                    54367,
                    54331,
                    54358,
                    54197,
                    54204,
                    56779,
                    60831,
                    56294,
                    56252,
                    56038,
                    62750,
                    56286,
                    56307,
                    42623,
                    42577,
                    55825,
                    56505,
                    62738,
                    62754,
                    62746,
                    62762,
                    62743,
                    62760,
                    62755,
                    62736,
                    62748,
                    62764,
                    62742,
                    62758,
                    62739,
                    62756,
                    62744,
                    62765,
                    62757,
                    62741,
                    57780,
                    57784,
                    48512,
                    48465,
                    48589, // Hand cannon shot model

		42577,
		42599,
		42595,
		42582,
		42592,
		42597, // pvp weapon inventory models (because the osrs ones look terrible)
            };

	public final static boolean[] read622ModelsList = new boolean[66000];

	public final static boolean[] read622ModelsListRemoveInvisibileFix = new boolean[66000];

    public static boolean newModel[];
    public static int anInt1620;
    public static Model aModel_1621 = new Model(true);
    public static boolean aBoolean1684;
    public static int anInt1685;
    public static int anInt1686;
    public static int anInt1687;
    public static int anIntArray1688[] = new int[1000];
    public static int modelIntArray1[];
    public static int modelIntArray2[];
    static Class21 aClass21Array1661[];
    static OnDemandFetcherParent aOnDemandFetcherParent_1662;
    static boolean aBooleanArray1663[] = new boolean[8000];
    static boolean aBooleanArray1664[] = new boolean[8000];
    static int anIntArray1665[] = new int[8000];
    static int anIntArray1666[] = new int[8000];
    static int anIntArray1667[] = new int[8000];
    static int anIntArray1668[] = new int[8000];
    static int anIntArray1669[] = new int[8000];
    static int anIntArray1670[] = new int[8000];
    static int anIntArray1671[] = new int[1500];
    static int anIntArrayArray1672[][] = new int[1500][512];
    static int anIntArray1673[] = new int[12];
    static int anIntArrayArray1674[][] = new int[12][2000];
    static int anIntArray1675[] = new int[2000];
    static int anIntArray1676[] = new int[2000];
    static int anIntArray1677[] = new int[12];
    static int anIntArray1678[] = new int[10];
    static int anIntArray1679[] = new int[10];
    static int anIntArray1680[] = new int[10];
    static int anInt1681;
    static int anInt1682;
    static int anInt1683;
    static int modelIntArray3[];
    static int modelIntArray4[];
    private static int anIntArray1622[] = new int[2000];
    private static int anIntArray1623[] = new int[2000];
    private static int anIntArray1624[] = new int[2000];
    private static int anIntArray1625[] = new int[2000];

    static {
        modelIntArray1 = Rasterizer.sin;
        modelIntArray2 = Rasterizer.cos;
        modelIntArray3 = Rasterizer.palette;
        modelIntArray4 = Rasterizer.lightDecay;
    }

    public short[] texture;
    public byte[] texture_coordinates;
    public byte[] texture_type;
    public int vertexCount;
    public int anIntArray1627[];
    public int anIntArray1628[];
    public int anIntArray1629[];
    public int totalModelColors;
    public int anIntArray1631[];
    public int anIntArray1632[];
    public int anIntArray1633[];
    public int anIntArray1634[];
    public int anIntArray1635[];
    public int anIntArray1636[];
    public int anIntArray1637[];
    public byte anIntArray1638[];
    public int anIntArray1639[];
    public short currentModelColors[];
    public byte anInt1641;
    public int anInt1642;
    public short anIntArray1643[];
    public short anIntArray1644[];
    public short anIntArray1645[];
    public int anInt1646;
    public int anInt1647;
    public int anInt1648;
    public int anInt1649;
    public int anInt1650;
    public int anInt1651;
    public int anInt1652;
    public int anInt1653;
    public int anInt1654;
    public int anIntArray1655[];
    public int anIntArray1656[];
    public int anIntArrayArray1657[][];
    public int anIntArrayArray1658[][];
    public boolean aBoolean1659;
    Vertex aClass33Array1660[];
    private boolean aBoolean1618;

    public Model(int modelId) {
        if (Config.PRE_EOC) {
            byte[] is = aClass21Array1661[modelId].aByteArray368;
            if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
                read622Model(is, modelId);
            else
                readOldModel(is, modelId);
            if (newModel[modelId]) {
                scale2(4);// 2 is too big -- 3 is almost right

				// Fix for see-through issues.
                if (anIntArray1638 != null) {
                    for (int j = 0; j < anIntArray1638.length; j++)
                        anIntArray1638[j] = 10;
                }
            }
        } else {
            if (read622ModelsList[modelId]) {
                byte[] is = aClass21Array1661[modelId].aByteArray368;
                if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
                    read622Model(is, modelId);
                else
                    readOldModel(is, modelId);
                if (newModel[modelId]) {
                    scale2(4);// 2 is too big -- 3 is almost right

					if (!read622ModelsListRemoveInvisibileFix[modelId]) {
						// Fix for see-through issues.
						if (anIntArray1638 != null) {
							for (int j = 0; j < anIntArray1638.length; j++)
								anIntArray1638[j] = 10;
						}
					}
                }
            } else {
                byte[] is = aClass21Array1661[modelId].aByteArray368;
                if (is[is.length - 1] == -1 && is[is.length - 2] == -1) {
                    readNewModel(is, modelId);
                } else {
                    readOldModel(is, modelId);
                }
            }
        }
    }

    private Model(boolean flag) {
        aBoolean1618 = true;
        aBoolean1659 = false;
        if (!flag) {
            aBoolean1618 = !aBoolean1618;
        }
    }

    public Model(int length, Model model_segments[]) {
        try {
            aBoolean1618 = true;
            aBoolean1659 = false;
            anInt1620++;
            boolean type_flag = false;
            boolean priority_flag = false;
            boolean alpha_flag = false;
            boolean tSkin_flag = false;
            boolean color_flag = false;
            boolean texture_flag = false;
            boolean coordinate_flag = false;
            vertexCount = 0;
            totalModelColors = 0;
            anInt1642 = 0;
            anInt1641 = -1;
            Model build;
            for (int segment_index = 0; segment_index < length; segment_index++) {
                build = model_segments[segment_index];
                if (build != null) {
                    vertexCount += build.vertexCount;
                    totalModelColors += build.totalModelColors;
                    anInt1642 += build.anInt1642;
                    type_flag |= build.anIntArray1637 != null;
                    alpha_flag |= build.anIntArray1639 != null;
                    if (build.anIntArray1638 != null) {
                        priority_flag = true;
                    } else {
                        if (anInt1641 == -1)
                            anInt1641 = build.anInt1641;

                        if (anInt1641 != build.anInt1641)
                            priority_flag = true;
                    }
                    tSkin_flag |= build.anIntArray1656 != null;
                    color_flag |= build.currentModelColors != null;
                    texture_flag |= build.texture != null;
                    coordinate_flag |= build.texture_coordinates != null;
                }
            }
            anIntArray1627 = new int[vertexCount];
            anIntArray1628 = new int[vertexCount];
            anIntArray1629 = new int[vertexCount];
            anIntArray1655 = new int[vertexCount];
            anIntArray1631 = new int[totalModelColors];
            anIntArray1632 = new int[totalModelColors];
            anIntArray1633 = new int[totalModelColors];
            if (color_flag)
                currentModelColors = new short[totalModelColors];

            if (type_flag)
                anIntArray1637 = new int[totalModelColors];

            if (priority_flag)
                anIntArray1638 = new byte[totalModelColors];

            if (alpha_flag)
                anIntArray1639 = new int[totalModelColors];

            if (tSkin_flag)
                anIntArray1656 = new int[totalModelColors];

            if (texture_flag)
                texture = new short[totalModelColors];

            if (coordinate_flag)
                texture_coordinates = new byte[totalModelColors];

            if (anInt1642 > 0) {
                texture_type = new byte[anInt1642];
                anIntArray1643 = new short[anInt1642];
                anIntArray1644 = new short[anInt1642];
                anIntArray1645 = new short[anInt1642];
            }
            vertexCount = 0;
            totalModelColors = 0;
            anInt1642 = 0;
            int texture_face = 0;
            for (int segment_index = 0; segment_index < length; segment_index++) {
                build = model_segments[segment_index];
                if (build != null) {
                    for (int face = 0; face < build.totalModelColors; face++) {
                        if (type_flag && build.anIntArray1637 != null)
                            anIntArray1637[totalModelColors] = build.anIntArray1637[face];

                        if (priority_flag)
                            if (build.anIntArray1638 == null)
                                anIntArray1638[totalModelColors] = build.anInt1641;
                            else
                                anIntArray1638[totalModelColors] = build.anIntArray1638[face];

                        if (alpha_flag && build.anIntArray1639 != null)
                            anIntArray1639[totalModelColors] = build.anIntArray1639[face];

                        if (tSkin_flag && build.anIntArray1656 != null)
                            anIntArray1656[totalModelColors] = build.anIntArray1656[face];

                        if (texture_flag) {
                            if (build.texture != null)
                                texture[totalModelColors] = build.texture[face];
                            else
                                texture[totalModelColors] = -1;
                        }
                        if (coordinate_flag) {
                            if (build.texture_coordinates != null && build.texture_coordinates[face] != -1) {
                                texture_coordinates[totalModelColors] = (byte) (build.texture_coordinates[face] + texture_face);
                            } else {
                                texture_coordinates[totalModelColors] = -1;
                            }
                        }
                        currentModelColors[totalModelColors] = build.currentModelColors[face];
                        anIntArray1631[totalModelColors] = method465(build, build.anIntArray1631[face]);
                        anIntArray1632[totalModelColors] = method465(build, build.anIntArray1632[face]);
                        anIntArray1633[totalModelColors] = method465(build, build.anIntArray1633[face]);
                        totalModelColors++;
                    }
                    for (int texture_edge = 0; texture_edge < build.anInt1642; texture_edge++) {
                        anIntArray1643[anInt1642] = (short) method465(build, build.anIntArray1643[texture_edge]);
                        anIntArray1644[anInt1642] = (short) method465(build, build.anIntArray1644[texture_edge]);
                        anIntArray1645[anInt1642] = (short) method465(build, build.anIntArray1645[texture_edge]);
                        anInt1642++;
                    }
                    texture_face += build.anInt1642;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Model(Model amodel[]) {
        int i = 2;
        aBoolean1618 = true;
        aBoolean1659 = false;
        anInt1620++;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean texture_flag = false;
        boolean coordinate_flag = false;
        vertexCount = 0;
        totalModelColors = 0;
        anInt1642 = 0;
        anInt1641 = -1;
        for (int k = 0; k < i; k++) {
            Model model = amodel[k];
            if (model != null) {
                vertexCount += model.vertexCount;
                totalModelColors += model.totalModelColors;
                anInt1642 += model.anInt1642;
                flag1 |= model.anIntArray1637 != null;
                if (model.anIntArray1638 != null) {
                    flag2 = true;
                } else {
                    if (anInt1641 == -1)
                        anInt1641 = model.anInt1641;
                    if (anInt1641 != model.anInt1641)
                        flag2 = true;
                }
                flag3 |= model.anIntArray1639 != null;
                flag4 |= model.currentModelColors != null;
                texture_flag |= model.texture != null;
                coordinate_flag |= model.texture_coordinates != null;
            }
        }
        anIntArray1627 = new int[vertexCount];
        anIntArray1628 = new int[vertexCount];
        anIntArray1629 = new int[vertexCount];
        anIntArray1631 = new int[totalModelColors];
        anIntArray1632 = new int[totalModelColors];
        anIntArray1633 = new int[totalModelColors];
        anIntArray1634 = new int[totalModelColors];
        anIntArray1635 = new int[totalModelColors];
        anIntArray1636 = new int[totalModelColors];
        anIntArray1643 = new short[anInt1642];
        anIntArray1644 = new short[anInt1642];
        anIntArray1645 = new short[anInt1642];
        if (flag1)
            anIntArray1637 = new int[totalModelColors];
        if (flag2)
            anIntArray1638 = new byte[totalModelColors];
        if (flag3)
            anIntArray1639 = new int[totalModelColors];
        if (flag4)
            currentModelColors = new short[totalModelColors];
        if (texture_flag)
            texture = new short[totalModelColors];

        if (coordinate_flag)
            texture_coordinates = new byte[totalModelColors];
        vertexCount = 0;
        totalModelColors = 0;
        anInt1642 = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < i; j1++) {
            Model model_1 = amodel[j1];
            if (model_1 != null) {
                int k1 = vertexCount;
                for (int l1 = 0; l1 < model_1.vertexCount; l1++) {
                    int x = model_1.anIntArray1627[l1];
                    int y = model_1.anIntArray1628[l1];
                    int z = model_1.anIntArray1629[l1];
                    anIntArray1627[vertexCount] = x;
                    anIntArray1628[vertexCount] = y;
                    anIntArray1629[vertexCount] = z;
                    ++vertexCount;
                }

                for (int i2 = 0; i2 < model_1.totalModelColors; i2++) {
                    anIntArray1631[totalModelColors] = model_1.anIntArray1631[i2] + k1;
                    anIntArray1632[totalModelColors] = model_1.anIntArray1632[i2] + k1;
                    anIntArray1633[totalModelColors] = model_1.anIntArray1633[i2] + k1;
                    anIntArray1634[totalModelColors] = model_1.anIntArray1634[i2];
                    anIntArray1635[totalModelColors] = model_1.anIntArray1635[i2];
                    anIntArray1636[totalModelColors] = model_1.anIntArray1636[i2];
                    if (flag1)
                        if (model_1.anIntArray1637 == null) {
                            anIntArray1637[totalModelColors] = 0;
                        } else {
                            int j2 = model_1.anIntArray1637[i2];
                            if ((j2 & 2) == 2)
                                j2 += i1 << 2;
                            anIntArray1637[totalModelColors] = j2;
                        }
                    if (flag2)
                        if (model_1.anIntArray1638 == null)
                            anIntArray1638[totalModelColors] = model_1.anInt1641;
                        else
                            anIntArray1638[totalModelColors] = model_1.anIntArray1638[i2];
                    if (flag3)
                        if (model_1.anIntArray1639 == null)
                            anIntArray1639[totalModelColors] = 0;
                        else
                            anIntArray1639[totalModelColors] = model_1.anIntArray1639[i2];
                    if (flag4 && model_1.currentModelColors != null)
                        currentModelColors[totalModelColors] = model_1.currentModelColors[i2];

                    if (texture_flag) {
                        if (model_1.texture != null) {
                            texture[totalModelColors] = model_1.texture[totalModelColors];
                        } else {
                            texture[totalModelColors] = -1;
                        }
                    }

                    if (coordinate_flag) {
                        if (model_1.texture_coordinates != null && model_1.texture_coordinates[totalModelColors] != -1)
                            texture_coordinates[totalModelColors] = (byte) (model_1.texture_coordinates[totalModelColors] + anInt1642);
                        else
                            texture_coordinates[totalModelColors] = -1;

                    }

                    totalModelColors++;
                }

                for (int k2 = 0; k2 < model_1.anInt1642; k2++) {
                    anIntArray1643[anInt1642] = (short) (model_1.anIntArray1643[k2] + k1);
                    anIntArray1644[anInt1642] = (short) (model_1.anIntArray1644[k2] + k1);
                    anIntArray1645[anInt1642] = (short) (model_1.anIntArray1645[k2] + k1);
                    anInt1642++;
                }

                i1 += model_1.anInt1642;
            }
        }

        method466();
    }

    public Model(boolean color_flag, boolean alpha_flag, boolean animated, Model model) {
        this(color_flag, alpha_flag, animated, false, model);
    }

    public Model(boolean color_flag, boolean alpha_flag, boolean animated, boolean texture_flag, Model model) {
        aBoolean1618 = true;
        aBoolean1659 = false;
        anInt1620++;
        vertexCount = model.vertexCount;
        totalModelColors = model.totalModelColors;
        anInt1642 = model.anInt1642;
        if (animated) {
            anIntArray1627 = model.anIntArray1627;
            anIntArray1628 = model.anIntArray1628;
            anIntArray1629 = model.anIntArray1629;
        } else {
            anIntArray1627 = new int[vertexCount];
            anIntArray1628 = new int[vertexCount];
            anIntArray1629 = new int[vertexCount];
            for (int point = 0; point < vertexCount; point++) {
                anIntArray1627[point] = model.anIntArray1627[point];
                anIntArray1628[point] = model.anIntArray1628[point];
                anIntArray1629[point] = model.anIntArray1629[point];
            }

        }

        if (color_flag) {
            currentModelColors = model.currentModelColors;
        } else {
            currentModelColors = new short[totalModelColors];
            for (int face = 0; face < totalModelColors; face++)
                currentModelColors[face] = model.currentModelColors[face];

        }

        if (!texture_flag && model.texture != null) {
            texture = new short[totalModelColors];
            for (int face = 0; face < totalModelColors; face++) {
                texture[face] = model.texture[face];
            }
        } else {
            texture = model.texture;
        }

        if (alpha_flag) {
            anIntArray1639 = model.anIntArray1639;
        } else {
            anIntArray1639 = new int[totalModelColors];
            if (model.anIntArray1639 == null) {
                for (int l = 0; l < totalModelColors; l++)
                    anIntArray1639[l] = 0;

            } else {
                for (int i1 = 0; i1 < totalModelColors; i1++)
                    anIntArray1639[i1] = model.anIntArray1639[i1];

            }
        }
        anIntArray1655 = model.anIntArray1655;
        anIntArray1656 = model.anIntArray1656;
        anIntArray1637 = model.anIntArray1637;
        anIntArray1631 = model.anIntArray1631;
        anIntArray1632 = model.anIntArray1632;
        anIntArray1633 = model.anIntArray1633;
        anIntArray1638 = model.anIntArray1638;
        texture_coordinates = model.texture_coordinates;
        texture_type = model.texture_type;
        anInt1641 = model.anInt1641;
        anIntArray1643 = model.anIntArray1643;
        anIntArray1644 = model.anIntArray1644;
        anIntArray1645 = model.anIntArray1645;
    }

    public Model(boolean adjust_elevation, boolean gouraud_shading, Model model) {
        aBoolean1618 = true;
        aBoolean1659 = false;
        anInt1620++;
        vertexCount = model.vertexCount;
        totalModelColors = model.totalModelColors;
        anInt1642 = model.anInt1642;
        if (adjust_elevation) {
            anIntArray1628 = new int[vertexCount];
            for (int point = 0; point < vertexCount; point++)
                anIntArray1628[point] = model.anIntArray1628[point];

        } else {
            anIntArray1628 = model.anIntArray1628;
        }
        if (gouraud_shading) {
            anIntArray1634 = new int[totalModelColors];
            anIntArray1635 = new int[totalModelColors];
            anIntArray1636 = new int[totalModelColors];
            for (int face = 0; face < totalModelColors; face++) {
                anIntArray1634[face] = model.anIntArray1634[face];
                anIntArray1635[face] = model.anIntArray1635[face];
                anIntArray1636[face] = model.anIntArray1636[face];
            }

            anIntArray1637 = new int[totalModelColors];
            if (model.anIntArray1637 == null) {
                for (int face = 0; face < totalModelColors; face++)
                    anIntArray1637[face] = 0;

            } else {
                for (int face = 0; face < totalModelColors; face++)
                    anIntArray1637[face] = model.anIntArray1637[face];

            }
            super.normals = new Vertex[vertexCount];
            for (int point = 0; point < vertexCount; point++) {
                Vertex class33 = super.normals[point] = new Vertex();
                Vertex class33_1 = model.normals[point];
                class33.x = class33_1.x;
                class33.y = class33_1.y;
                class33.z = class33_1.z;
                class33.w = class33_1.w;
            }
            aClass33Array1660 = model.aClass33Array1660;

        } else {
            anIntArray1634 = model.anIntArray1634;
            anIntArray1635 = model.anIntArray1635;
            anIntArray1636 = model.anIntArray1636;
            anIntArray1637 = model.anIntArray1637;
        }
        anIntArray1627 = model.anIntArray1627;
        anIntArray1629 = model.anIntArray1629;
        anIntArray1631 = model.anIntArray1631;
        anIntArray1632 = model.anIntArray1632;
        anIntArray1633 = model.anIntArray1633;
        anIntArray1638 = model.anIntArray1638;
        anIntArray1639 = model.anIntArray1639;
        texture_coordinates = model.texture_coordinates;
        currentModelColors = model.currentModelColors;
        texture = model.texture;
        anInt1641 = model.anInt1641;
        texture_type = model.texture_type;
        anIntArray1643 = model.anIntArray1643;
        anIntArray1644 = model.anIntArray1644;
        anIntArray1645 = model.anIntArray1645;
        super.modelHeight = model.modelHeight;
        anInt1650 = model.anInt1650;
        anInt1653 = model.anInt1653;
        anInt1652 = model.anInt1652;
        anInt1646 = model.anInt1646;
        anInt1648 = model.anInt1648;
        anInt1649 = model.anInt1649;
        anInt1647 = model.anInt1647;
    }

    public static void nullLoader() {
        aClass21Array1661 = null;
        aBooleanArray1663 = null;
        aBooleanArray1664 = null;
        anIntArray1666 = null;
        anIntArray1667 = null;
        anIntArray1668 = null;
        anIntArray1669 = null;
        anIntArray1670 = null;
        anIntArray1671 = null;
        anIntArrayArray1672 = null;
        anIntArray1673 = null;
        anIntArrayArray1674 = null;
        anIntArray1675 = null;
        anIntArray1676 = null;
        anIntArray1677 = null;
        modelIntArray1 = null;
        modelIntArray2 = null;
        modelIntArray3 = null;
        modelIntArray4 = null;
    }

    public static void initiate622ModelsList() {
        for (int index = 0; index < read622Models.length; index++) {
            read622ModelsList[read622Models[index]] = true;
        }
		for (int index = 0; index < removeInvisibleFixFrom622Models.length; index++) {
			read622ModelsListRemoveInvisibileFix[removeInvisibleFixFrom622Models[index]] = true;
		}
    }

    public static void method460(byte abyte0[], int j) {
        try {
            if (abyte0 == null) {
                Class21 class21 = aClass21Array1661[j] = new Class21();
                class21.anInt369 = 0;
                class21.anInt370 = 0;
                class21.anInt371 = 0;
                return;
            }
            Stream stream = new Stream(abyte0);
            stream.currentOffset = abyte0.length - 18;
            Class21 class21_1 = aClass21Array1661[j] = new Class21();
            class21_1.aByteArray368 = abyte0;
            class21_1.anInt369 = stream.readUnsignedWord();
            class21_1.anInt370 = stream.readUnsignedWord();
            class21_1.anInt371 = stream.readUnsignedByte();
            int k = stream.readUnsignedByte();
            int l = stream.readUnsignedByte();
            int i1 = stream.readUnsignedByte();
            int j1 = stream.readUnsignedByte();
            int k1 = stream.readUnsignedByte();
            int l1 = stream.readUnsignedWord();
            int i2 = stream.readUnsignedWord();
            int j2 = stream.readUnsignedWord();
            int k2 = stream.readUnsignedWord();
            int l2 = 0;
            class21_1.anInt372 = l2;
            l2 += class21_1.anInt369;
            class21_1.anInt378 = l2;
            l2 += class21_1.anInt370;
            class21_1.anInt381 = l2;
            if (l == 255)
                l2 += class21_1.anInt370;
            else
                class21_1.anInt381 = -l - 1;
            class21_1.anInt383 = l2;
            if (j1 == 1)
                l2 += class21_1.anInt370;
            else
                class21_1.anInt383 = -1;
            class21_1.anInt380 = l2;
            if (k == 1)
                l2 += class21_1.anInt370;
            else
                class21_1.anInt380 = -1;
            class21_1.anInt376 = l2;
            if (k1 == 1)
                l2 += class21_1.anInt369;
            else
                class21_1.anInt376 = -1;
            class21_1.anInt382 = l2;
            if (i1 == 1)
                l2 += class21_1.anInt370;
            else
                class21_1.anInt382 = -1;
            class21_1.anInt377 = l2;
            l2 += k2;
            class21_1.anInt379 = l2;
            l2 += class21_1.anInt370 * 2;
            class21_1.anInt384 = l2;
            l2 += class21_1.anInt371 * 6;
            class21_1.anInt373 = l2;
            l2 += l1;
            class21_1.anInt374 = l2;
            l2 += i2;
            class21_1.anInt375 = l2;
            l2 += j2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method459(int i, OnDemandFetcherParent onDemandFetcherParent) {
        aClass21Array1661 = new Class21[80000];
        newModel = new boolean[100000];
        aOnDemandFetcherParent_1662 = onDemandFetcherParent;
    }

    public static void method461(int j) {
        aClass21Array1661[j] = null;
    }

    public static Model getModel(int j) {
        if (aClass21Array1661 == null) {
            return null;
        }
        Class21 class21 = aClass21Array1661[j];
        if (class21 == null) {
            aOnDemandFetcherParent_1662.requestModel(j);
            return null;
        } else {
            return new Model(j);
        }
    }

    public static boolean isCached(int i) {
        if (aClass21Array1661 == null || i < 0 || i >= aClass21Array1661.length) {
            return false;
        }

        if (aClass21Array1661[i] != null) {
            return true;
        }
        aOnDemandFetcherParent_1662.requestModel(i);
        return false;
    }

    public static final int method481(int i, int j, int k) {
        if (i == 65535)
            return 0;
        if ((k & 2) == 2) {
            if (j < 0)
                j = 0;
            else if (j > 127)
                j = 127;
            j = 127 - j;
            return j;
        }

        j = j * (i & 0x7f) >> 7;
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public void printAllColours(int itemId) {
        ArrayList<Short> colours = new ArrayList<Short>();
        Utility.print("Start--------------" + itemId);
		/*
		if (currentModelColors != null)
		{
			for (int face = 0; face < totalModelColors; face++)
			{
				currentModelColors[face] = (short) replace;
			}
		}
		*/
        for (int i = 0; i < totalModelColors; i++) {
            boolean match = false;
            for (int index = 0; index < colours.size(); index++) {
                if (colours.get(index) == currentModelColors[i]) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                if (currentModelColors != null) {
                    colours.add(currentModelColors[i]);
                }
            }
        }

        Utility.print("itemDefinition.modelColourToEdit = new int[" + (colours.size()) + "];");
        Utility.print("itemDefinition.newModelColourProduced = new int[" + colours.size() + "];");
        for (int index = 0; index < colours.size(); index++) {
            Utility.print("colour = -1;");
            Utility.print("itemDefinition.modelColourToEdit[" + index + "] = " + colours.get(index) + ";");
            Utility.print("itemDefinition.newModelColourProduced[" + index + "] = colour == -1 ? " + colours.get(index) + " : colour;");
            Utility.print("");
        }
    }
    public void method1337(int j) {
		for (int k = 0; k < totalModelColors; k++) {
			anIntArray1639[k] = j;
		}
	}

	public void method1338(int j) {
		j += 100;
		int kcolor = 0;
		for (int k = 0; k < totalModelColors; k++) {
			kcolor = anIntArray1639[k];
			if (k + j >= 0)
				anIntArray1639[k] = kcolor + j;
		}
	}

	public void method1339(int j) {
		j += 1;
		for (int k = 0; k < totalModelColors; k++) {
			if (k + j >= 0)
				anIntArray1639[k] = k + j;
		}
	}
    public void scale2(int i) {
        for (int i1 = 0; i1 < vertexCount; i1++) {
            anIntArray1627[i1] = anIntArray1627[i1] / i;
            anIntArray1628[i1] = anIntArray1628[i1] / i;
            anIntArray1629[i1] = anIntArray1629[i1] / i;
        }
    }

    public void readNewModel(byte data[], int modelId) {
        if (read622ModelsList[modelId]) {
            read622Model(data, modelId);
            return;
        }
        Stream nc1 = new Stream(data);
        Stream nc2 = new Stream(data);
        Stream nc3 = new Stream(data);
        Stream nc4 = new Stream(data);
        Stream nc5 = new Stream(data);
        Stream nc6 = new Stream(data);
        Stream nc7 = new Stream(data);
        nc1.currentOffset = data.length - 23;
        vertexCount = nc1.readUnsignedWord();
        totalModelColors = nc1.readUnsignedWord();
        anInt1642 = nc1.readUnsignedByte();
        int flags = nc1.readUnsignedByte();
        int priority_opcode = nc1.readUnsignedByte();
        int alpha_opcode = nc1.readUnsignedByte();
        int tSkin_opcode = nc1.readUnsignedByte();
        int texture_opcode = nc1.readUnsignedByte();
        int vSkin_opcode = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int texture_id = 0;
        int texture_ = 0;
        int texture__ = 0;
        int face;
        currentModelColors = new short[totalModelColors];
        if (anInt1642 > 0) {
            texture_type = new byte[anInt1642];
            nc1.currentOffset = 0;
            for (face = 0; face < anInt1642; face++) {
                byte opcode = texture_type[face] = nc1.readSignedByte();
                if (opcode == 0) {
                    texture_id++;
                }

                if (opcode >= 1 && opcode <= 3) {
                    texture_++;
                }
                if (opcode == 2) {
                    texture__++;
                }
            }
        }
        int pos;
        pos = anInt1642;
        int vertexMod_offset = pos;
        pos += vertexCount;

        int drawTypeBasePos = pos;
        if (flags == 1)
            pos += totalModelColors;

        int faceMeshLink_offset = pos;
        pos += totalModelColors;

        int facePriorityBasePos = pos;
        if (priority_opcode == 255)
            pos += totalModelColors;

        int tSkinBasePos = pos;
        if (tSkin_opcode == 1)
            pos += totalModelColors;

        int vSkinBasePos = pos;
        if (vSkin_opcode == 1)
            pos += vertexCount;

        int alphaBasePos = pos;
        if (alpha_opcode == 1)
            pos += totalModelColors;

        int faceVPoint_offset = pos;
        pos += i4;

        int textureIdBasePos = pos;
        if (texture_opcode == 1)
            pos += totalModelColors * 2;

        int textureBasePos = pos;
        pos += j4;

        int color_offset = pos;
        pos += totalModelColors * 2;

        int vertexX_offset = pos;
        pos += j3;

        int vertexY_offset = pos;
        pos += k3;

        int vertexZ_offset = pos;
        pos += l3;

        int mainBuffer_offset = pos;
        pos += texture_id * 6;

        int firstBuffer_offset = pos;
        pos += texture_ * 6;

        int secondBuffer_offset = pos;
        pos += texture_ * 6;

        int thirdBuffer_offset = pos;
        pos += texture_ * 2;

        int fourthBuffer_offset = pos;
        pos += texture_;

        int fifthBuffer_offset = pos;
        pos += texture_ * 2 + texture__ * 2;
        anIntArray1627 = new int[vertexCount];
        anIntArray1628 = new int[vertexCount];
        anIntArray1629 = new int[vertexCount];
        anIntArray1631 = new int[totalModelColors];
        anIntArray1632 = new int[totalModelColors];
        anIntArray1633 = new int[totalModelColors];
        if (vSkin_opcode == 1)
            anIntArray1655 = new int[vertexCount];

        if (flags == 1)
            anIntArray1637 = new int[totalModelColors];

        if (priority_opcode == 255)
            anIntArray1638 = new byte[totalModelColors];
        else
            anInt1641 = (byte) priority_opcode;

        if (alpha_opcode == 1)
            anIntArray1639 = new int[totalModelColors];

        if (tSkin_opcode == 1)
            anIntArray1656 = new int[totalModelColors];

        if (texture_opcode == 1)
            texture = new short[totalModelColors];

        if (texture_opcode == 1 && anInt1642 > 0)
            texture_coordinates = new byte[totalModelColors];

        if (anInt1642 > 0) {
            anIntArray1643 = new short[anInt1642];
            anIntArray1644 = new short[anInt1642];
            anIntArray1645 = new short[anInt1642];
        }
        nc1.currentOffset = vertexMod_offset;
        nc2.currentOffset = vertexX_offset;
        nc3.currentOffset = vertexY_offset;
        nc4.currentOffset = vertexZ_offset;
        nc5.currentOffset = vSkinBasePos;
        int start_x = 0;
        int start_y = 0;
        int start_z = 0;
        for (int point = 0; point < vertexCount; point++) {
            int flag = nc1.readUnsignedByte();
            int x = 0;
            if ((flag & 1) != 0) {
                x = nc2.method421();
            }
            int y = 0;
            if ((flag & 2) != 0) {
                y = nc3.method421();

            }
            int z = 0;
            if ((flag & 4) != 0) {
                z = nc4.method421();
            }
            anIntArray1627[point] = start_x + x;
            anIntArray1628[point] = start_y + y;
            anIntArray1629[point] = start_z + z;
            start_x = anIntArray1627[point];
            start_y = anIntArray1628[point];
            start_z = anIntArray1629[point];
            if (anIntArray1655 != null)
                anIntArray1655[point] = nc5.readUnsignedByte();

        }
        nc1.currentOffset = color_offset;
        nc2.currentOffset = drawTypeBasePos;
        nc3.currentOffset = facePriorityBasePos;
        nc4.currentOffset = alphaBasePos;
        nc5.currentOffset = tSkinBasePos;
        nc6.currentOffset = textureIdBasePos;
        nc7.currentOffset = textureBasePos;
        for (face = 0; face < totalModelColors; face++) {
            currentModelColors[face] = (short) nc1.readUnsignedWord();
            if (flags == 1) {
                anIntArray1637[face] = nc2.readSignedByte();
            }
            if (priority_opcode == 255) {
                anIntArray1638[face] = nc3.readSignedByte();
            }
            if (alpha_opcode == 1) {
                anIntArray1639[face] = nc4.readSignedByte();
                if (anIntArray1639[face] < 0)
                    anIntArray1639[face] = (256 + anIntArray1639[face]);

            }
            if (tSkin_opcode == 1)
                anIntArray1656[face] = nc5.readUnsignedByte();

            if (texture_opcode == 1) {
                texture[face] = (short) (nc6.readUnsignedWord() - 1);
                if (texture[face] >= 0) {
                    if (anIntArray1637 != null) {
                        if (anIntArray1637[face] < 2 && currentModelColors[face] != 127 && currentModelColors[face] != -27075) {
                            texture[face] = -1;
                        }
                    }
                }
                if (texture[face] != -1)
                    currentModelColors[face] = 127;

            }
            if (texture_coordinates != null && texture[face] != -1) {
                texture_coordinates[face] = (byte) (nc7.readUnsignedByte() - 1);
            }
        }
        nc1.currentOffset = faceVPoint_offset;
        nc2.currentOffset = faceMeshLink_offset;
        int coordinate_a = 0;
        int coordinate_b = 0;
        int coordinate_c = 0;
        int last_coordinate = 0;
        for (face = 0; face < totalModelColors; face++) {
            int opcode = nc2.readUnsignedByte();
            if (opcode == 1) {
                coordinate_a = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_a;
                coordinate_b = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_b;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 2) {
                coordinate_b = coordinate_c;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 3) {
                coordinate_a = coordinate_c;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 4) {
                int l14 = coordinate_a;
                coordinate_a = coordinate_b;
                coordinate_b = l14;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
        }
        nc1.currentOffset = mainBuffer_offset;
        nc2.currentOffset = firstBuffer_offset;
        nc3.currentOffset = secondBuffer_offset;
        nc4.currentOffset = thirdBuffer_offset;
        nc5.currentOffset = fourthBuffer_offset;
        nc6.currentOffset = fifthBuffer_offset;
        for (face = 0; face < anInt1642; face++) {
            int opcode = texture_type[face] & 0xff;
            if (opcode == 0) {
                anIntArray1643[face] = (short) nc1.readUnsignedWord();
                anIntArray1644[face] = (short) nc1.readUnsignedWord();
                anIntArray1645[face] = (short) nc1.readUnsignedWord();
            }
            if (opcode == 1) {
                anIntArray1643[face] = (short) nc2.readUnsignedWord();
                anIntArray1644[face] = (short) nc2.readUnsignedWord();
                anIntArray1645[face] = (short) nc2.readUnsignedWord();
            }
            if (opcode == 2) {
                anIntArray1643[face] = (short) nc2.readUnsignedWord();
                anIntArray1644[face] = (short) nc2.readUnsignedWord();
                anIntArray1645[face] = (short) nc2.readUnsignedWord();
            }
            if (opcode == 3) {
                anIntArray1643[face] = (short) nc2.readUnsignedWord();
                anIntArray1644[face] = (short) nc2.readUnsignedWord();
                anIntArray1645[face] = (short) nc2.readUnsignedWord();
            }
        }
        nc1.currentOffset = pos;
        int faceTemp = nc1.readUnsignedByte();
        face = faceTemp;
    }

    public void read622Model(byte abyte0[], int modelId) {
        Stream nc1 = new Stream(abyte0);
        Stream nc2 = new Stream(abyte0);
        Stream nc3 = new Stream(abyte0);
        Stream nc4 = new Stream(abyte0);
        Stream nc5 = new Stream(abyte0);
        Stream nc6 = new Stream(abyte0);
        Stream nc7 = new Stream(abyte0);
        nc1.currentOffset = abyte0.length - 23;
        int numVertices = nc1.readUnsignedWord();
        int numTriangles = nc1.readUnsignedWord();
        int numTexTriangles = nc1.readUnsignedByte();
        Class21 ModelDef_1 = aClass21Array1661[modelId] = new Class21();
        ModelDef_1.aByteArray368 = abyte0;
        ModelDef_1.anInt369 = numVertices;
        ModelDef_1.anInt370 = numTriangles;
        ModelDef_1.anInt371 = numTexTriangles;
        int l1 = nc1.readUnsignedByte();
        boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
        boolean bool_26_ = (0x8 & l1) == 8;
        if (!bool_26_) {
            read525Model(abyte0, modelId);
            return;
        }
        int newformat = 0;
        if (bool_26_) {
            nc1.currentOffset -= 7;
            newformat = nc1.readUnsignedByte();
            nc1.currentOffset += 6;
        }
        if (newformat == 15) {
            newModel[modelId] = true;
        }
        int i2 = nc1.readUnsignedByte();
        int j2 = nc1.readUnsignedByte();
        int k2 = nc1.readUnsignedByte();
        int l2 = nc1.readUnsignedByte();
        int i3 = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        byte[] x = null;
        byte[] O = null;
        byte[] J = null;
        byte[] F = null;
        byte[] cb = null;
        byte[] gb = null;
        byte[] lb = null;
        int[] kb = null;
        int[] y = null;
        int[] N = null;
        short[] D = null;
        short[] triangleColours2 = new short[numTriangles];
        if (numTexTriangles > 0) {
            O = new byte[numTexTriangles];
            nc1.currentOffset = 0;
            for (int j5 = 0; j5 < numTexTriangles; j5++) {
                byte byte0 = O[j5] = nc1.readSignedByte();
                if (byte0 == 0)
                    k4++;
                if (byte0 >= 1 && byte0 <= 3)
                    l4++;
                if (byte0 == 2)
                    i5++;
            }
        }
        int k5 = numTexTriangles;
        int l5 = k5;
        k5 += numVertices;
        int i6 = k5;
        if (bool)
            k5 += numTriangles;
        if (l1 == 1)
            k5 += numTriangles;
        int j6 = k5;
        k5 += numTriangles;
        int k6 = k5;
        if (i2 == 255)
            k5 += numTriangles;
        int l6 = k5;
        if (k2 == 1)
            k5 += numTriangles;
        int i7 = k5;
        if (i3 == 1)
            k5 += numVertices;
        int j7 = k5;
        if (j2 == 1)
            k5 += numTriangles;
        int k7 = k5;
        k5 += i4;
        int l7 = k5;
        if (l2 == 1)
            k5 += numTriangles * 2;
        int i8 = k5;
        k5 += j4;
        int j8 = k5;
        k5 += numTriangles * 2;
        int k8 = k5;
        k5 += j3;
        int l8 = k5;
        k5 += k3;
        int i9 = k5;
        k5 += l3;
        int j9 = k5;
        k5 += k4 * 6;
        int k9 = k5;
        k5 += l4 * 6;
        int i_59_ = 6;
        if (newformat != 14) {
            if (newformat >= 15)
                i_59_ = 9;
        } else
            i_59_ = 7;
        int l9 = k5;
        k5 += i_59_ * l4;
        int i10 = k5;
        k5 += l4;
        int j10 = k5;
        k5 += l4;
        int k10 = k5;
        k5 += l4 + i5 * 2;
        int[] vertexX = new int[numVertices];
        int[] vertexY = new int[numVertices];
        int[] vertexZ = new int[numVertices];
        int[] facePoint1 = new int[numTriangles];
        int[] facePoint2 = new int[numTriangles];
        int[] facePoint3 = new int[numTriangles];
        anIntArray1655 = new int[numVertices];
        anIntArray1637 = new int[numTriangles];
        anIntArray1638 = new byte[numTriangles];
        anIntArray1639 = new int[numTriangles];
        anIntArray1656 = new int[numTriangles];
        if (i3 == 1)
            anIntArray1655 = new int[numVertices];
        if (bool)
            anIntArray1637 = new int[numTriangles];
        if (i2 == 255)
            anIntArray1638 = new byte[numTriangles];
        else {
        }
        if (j2 == 1)
            anIntArray1639 = new int[numTriangles];
        if (k2 == 1)
            anIntArray1656 = new int[numTriangles];
        if (l2 == 1)
            D = new short[numTriangles];
        if (l2 == 1 && numTexTriangles > 0)
            x = new byte[numTriangles];
        triangleColours2 = new short[numTriangles];
        int[] texTrianglesPoint1 = null;
        int[] texTrianglesPoint2 = null;
        int[] texTrianglesPoint3 = null;
        if (numTexTriangles > 0) {
            texTrianglesPoint1 = new int[numTexTriangles];
            texTrianglesPoint2 = new int[numTexTriangles];
            texTrianglesPoint3 = new int[numTexTriangles];
            if (l4 > 0) {
                kb = new int[l4];
                N = new int[l4];
                y = new int[l4];
                gb = new byte[l4];
                lb = new byte[l4];
                F = new byte[l4];
            }
            if (i5 > 0) {
                cb = new byte[i5];
                J = new byte[i5];
            }
        }
        nc1.currentOffset = l5;
        nc2.currentOffset = k8;
        nc3.currentOffset = l8;
        nc4.currentOffset = i9;
        nc5.currentOffset = i7;
        int l10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (int k11 = 0; k11 < numVertices; k11++) {
            int l11 = nc1.readUnsignedByte();
            int j12 = 0;
            if ((l11 & 1) != 0)
                j12 = nc2.method421();
            int l12 = 0;
            if ((l11 & 2) != 0)
                l12 = nc3.method421();
            int j13 = 0;
            if ((l11 & 4) != 0)
                j13 = nc4.method421();
            vertexX[k11] = l10 + j12;
            vertexY[k11] = i11 + l12;
            vertexZ[k11] = j11 + j13;
            l10 = vertexX[k11];
            i11 = vertexY[k11];
            j11 = vertexZ[k11];
            if (anIntArray1655 != null)
                anIntArray1655[k11] = nc5.readUnsignedByte();
        }
        nc1.currentOffset = j8;
        nc2.currentOffset = i6;
        nc3.currentOffset = k6;
        nc4.currentOffset = j7;
        nc5.currentOffset = l6;
        nc6.currentOffset = l7;
        nc7.currentOffset = i8;
        for (int i12 = 0; i12 < numTriangles; i12++) {
            triangleColours2[i12] = (short) nc1.readUnsignedWord();
            if (l1 == 1) {
                anIntArray1637[i12] = nc2.readSignedByte();
                if (anIntArray1637[i12] == 2)
                    triangleColours2[i12] = (short) 65535;
                anIntArray1637[i12] = 0;
            }
            if (i2 == 255) {
                anIntArray1638[i12] = nc3.readSignedByte();
            }
            if (j2 == 1) {
                anIntArray1639[i12] = nc4.readSignedByte();
                if (anIntArray1639[i12] < 0)
                    anIntArray1639[i12] = (256 + anIntArray1639[i12]);
            }
            if (k2 == 1)
                anIntArray1656[i12] = nc5.readUnsignedByte();
            if (l2 == 1)
                D[i12] = (short) (nc6.readUnsignedWord() - 1);
            if (x != null)
                if (D[i12] != -1)
                    x[i12] = (byte) (nc7.readUnsignedByte() - 1);
                else
                    x[i12] = -1;
        }
        nc1.currentOffset = k7;
        nc2.currentOffset = j6;
        int k12 = 0;
        int i13 = 0;
        int k13 = 0;
        int l13 = 0;
        for (int i14 = 0; i14 < numTriangles; i14++) {
            int j14 = nc2.readUnsignedByte();
            if (j14 == 1) {
                k12 = nc1.method421() + l13;
                l13 = k12;
                i13 = nc1.method421() + l13;
                l13 = i13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 2) {
                i13 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 3) {
                k12 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 4) {
                int l14 = k12;
                k12 = i13;
                i13 = l14;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
        }
        nc1.currentOffset = j9;
        nc2.currentOffset = k9;
        nc3.currentOffset = l9;
        nc4.currentOffset = i10;
        nc5.currentOffset = j10;
        nc6.currentOffset = k10;
        for (int k14 = 0; k14 < numTexTriangles; k14++) {
            int i15 = O[k14] & 0xff;
            if (i15 == 0) {
                texTrianglesPoint1[k14] = nc1.readUnsignedWord();
                texTrianglesPoint2[k14] = nc1.readUnsignedWord();
                texTrianglesPoint3[k14] = nc1.readUnsignedWord();
            }
            if (i15 == 1) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat < 15) {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat >= 14)
                        N[k14] = nc3.v(-1);
                    else
                        N[k14] = nc3.readUnsignedWord();
                    y[k14] = nc3.readUnsignedWord();
                } else {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
            if (i15 == 2) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat >= 15) {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                } else {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat < 14)
                        N[k14] = nc3.readUnsignedWord();
                    else
                        N[k14] = nc3.v(-1);
                    y[k14] = nc3.readUnsignedWord();
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
                cb[k14] = nc6.readSignedByte();
                J[k14] = nc6.readSignedByte();
            }
            if (i15 == 3) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat < 15) {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat < 14)
                        N[k14] = nc3.readUnsignedWord();
                    else
                        N[k14] = nc3.v(-1);
                    y[k14] = nc3.readUnsignedWord();
                } else {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
        }
        if (i2 != 255) {
            for (int i12 = 0; i12 < numTriangles; i12++) {
                anIntArray1638[i12] = (byte) i2;
            }
        }
        currentModelColors = triangleColours2;
        vertexCount = numVertices;
        totalModelColors = numTriangles;
        anIntArray1627 = vertexX;
        anIntArray1628 = vertexY;
        anIntArray1629 = vertexZ;
        anIntArray1631 = facePoint1;
        anIntArray1632 = facePoint2;
        anIntArray1633 = facePoint3;
        for (int id = 0; id < totalModelColors; id++) {
            int a = anIntArray1631[id];
            int b = anIntArray1632[id];
            int c = anIntArray1633[id];
            boolean filter = true;
            label2:
            for (int id2 = 0; id2 < totalModelColors; id2++) {
                if (id2 == id) {
                    continue label2;
                }
                if (anIntArray1631[id2] == a) {
                    filter = false;
                    break label2;
                }
                if (anIntArray1632[id2] == b) {
                    filter = false;
                    break label2;
                }
                if (anIntArray1633[id2] == c) {
                    filter = false;
                    break label2;
                }
            }
            if (filter) {
                if (anIntArray1637 != null) {
                    anIntArray1639[id] = 255;
                }
            }
        }
    }

    public void read525Model(byte abyte0[], int modelId) {
        Stream nc1 = new Stream(abyte0);
        Stream nc2 = new Stream(abyte0);
        Stream nc3 = new Stream(abyte0);
        Stream nc4 = new Stream(abyte0);
        Stream nc5 = new Stream(abyte0);
        Stream nc6 = new Stream(abyte0);
        Stream nc7 = new Stream(abyte0);
        nc1.currentOffset = abyte0.length - 23;
        int numVertices = nc1.readUnsignedWord();
        int numTriangles = nc1.readUnsignedWord();
        int numTexTriangles = nc1.readUnsignedByte();
        Class21 ModelDef_1 = aClass21Array1661[modelId] = new Class21();
        ModelDef_1.aByteArray368 = abyte0;
        ModelDef_1.anInt369 = numVertices;
        ModelDef_1.anInt370 = numTriangles;
        ModelDef_1.anInt371 = numTexTriangles;
        int l1 = nc1.readUnsignedByte();
        boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
        int i2 = nc1.readUnsignedByte();
        int j2 = nc1.readUnsignedByte();
        int k2 = nc1.readUnsignedByte();
        int l2 = nc1.readUnsignedByte();
        int i3 = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        byte[] x = null;
        byte[] O = null;
        byte[] J = null;
        byte[] F = null;
        byte[] cb = null;
        byte[] gb = null;
        byte[] lb = null;
        int[] kb = null;
        int[] y = null;
        int[] N = null;
        short[] D = null;
        short[] triangleColours2 = new short[numTriangles]; // 03-07-2017 changed int to short
        if (numTexTriangles > 0) {
            O = new byte[numTexTriangles];
            nc1.currentOffset = 0;
            for (int j5 = 0; j5 < numTexTriangles; j5++) {
                byte byte0 = O[j5] = nc1.readSignedByte();
                if (byte0 == 0)
                    k4++;
                if (byte0 >= 1 && byte0 <= 3)
                    l4++;
                if (byte0 == 2)
                    i5++;
            }
        }
        int k5 = numTexTriangles;
        int l5 = k5;
        k5 += numVertices;
        int i6 = k5;
        if (l1 == 1)
            k5 += numTriangles;
        int j6 = k5;
        k5 += numTriangles;
        int k6 = k5;
        if (i2 == 255)
            k5 += numTriangles;
        int l6 = k5;
        if (k2 == 1)
            k5 += numTriangles;
        int i7 = k5;
        if (i3 == 1)
            k5 += numVertices;
        int j7 = k5;
        if (j2 == 1)
            k5 += numTriangles;
        int k7 = k5;
        k5 += i4;
        int l7 = k5;
        if (l2 == 1)
            k5 += numTriangles * 2;
        int i8 = k5;
        k5 += j4;
        int j8 = k5;
        k5 += numTriangles * 2;
        int k8 = k5;
        k5 += j3;
        int l8 = k5;
        k5 += k3;
        int i9 = k5;
        k5 += l3;
        int j9 = k5;
        k5 += k4 * 6;
        int k9 = k5;
        k5 += l4 * 6;
        int l9 = k5;
        k5 += l4 * 6;
        int i10 = k5;
        k5 += l4;
        int j10 = k5;
        k5 += l4;
        int k10 = k5;
        k5 += l4 + i5 * 2;
        int[] vertexX = new int[numVertices];
        int[] vertexY = new int[numVertices];
        int[] vertexZ = new int[numVertices];
        int[] facePoint1 = new int[numTriangles];
        int[] facePoint2 = new int[numTriangles];
        int[] facePoint3 = new int[numTriangles];
        anIntArray1655 = new int[numVertices];
        anIntArray1637 = new int[numTriangles];
        anIntArray1638 = new byte[numTriangles]; // 03-07-2017 changed int to byte
        anIntArray1639 = new int[numTriangles];
        anIntArray1656 = new int[numTriangles];
        if (i3 == 1)
            anIntArray1655 = new int[numVertices];
        if (bool)
            anIntArray1637 = new int[numTriangles];
        if (i2 == 255)
            anIntArray1638 = new byte[numTriangles]; // 03-07-2017 changed int to byte
        else {
        }
        if (j2 == 1)
            anIntArray1639 = new int[numTriangles];
        if (k2 == 1)
            anIntArray1656 = new int[numTriangles];
        if (l2 == 1)
            D = new short[numTriangles];
        if (l2 == 1 && numTexTriangles > 0)
            x = new byte[numTriangles];
        triangleColours2 = new short[numTriangles]; // 03-07-2017 changed int to short
        int[] texTrianglesPoint1 = null;
        int[] texTrianglesPoint2 = null;
        int[] texTrianglesPoint3 = null;
        if (numTexTriangles > 0) {
            texTrianglesPoint1 = new int[numTexTriangles];
            texTrianglesPoint2 = new int[numTexTriangles];
            texTrianglesPoint3 = new int[numTexTriangles];
            if (l4 > 0) {
                kb = new int[l4];
                N = new int[l4];
                y = new int[l4];
                gb = new byte[l4];
                lb = new byte[l4];
                F = new byte[l4];
            }
            if (i5 > 0) {
                cb = new byte[i5];
                J = new byte[i5];
            }
        }
        nc1.currentOffset = l5;
        nc2.currentOffset = k8;
        nc3.currentOffset = l8;
        nc4.currentOffset = i9;
        nc5.currentOffset = i7;
        int l10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (int k11 = 0; k11 < numVertices; k11++) {
            int l11 = nc1.readUnsignedByte();
            int j12 = 0;
            if ((l11 & 1) != 0)
                j12 = nc2.method421();
            int l12 = 0;
            if ((l11 & 2) != 0)
                l12 = nc3.method421();
            int j13 = 0;
            if ((l11 & 4) != 0)
                j13 = nc4.method421();
            vertexX[k11] = l10 + j12;
            vertexY[k11] = i11 + l12;
            vertexZ[k11] = j11 + j13;
            l10 = vertexX[k11];
            i11 = vertexY[k11];
            j11 = vertexZ[k11];
            if (anIntArray1655 != null)
                anIntArray1655[k11] = nc5.readUnsignedByte();
        }
        nc1.currentOffset = j8;
        nc2.currentOffset = i6;
        nc3.currentOffset = k6;
        nc4.currentOffset = j7;
        nc5.currentOffset = l6;
        nc6.currentOffset = l7;
        nc7.currentOffset = i8;
        for (int i12 = 0; i12 < numTriangles; i12++) {
            triangleColours2[i12] = (short) nc1.readUnsignedWord(); // 03-07-2017 added short
            if (l1 == 1) {
                anIntArray1637[i12] = nc2.readSignedByte();
                if (anIntArray1637[i12] == 2)
                    triangleColours2[i12] = (short) 65535; // 03-07-2017 added short
                anIntArray1637[i12] = 0;
            }
            if (i2 == 255) {
                anIntArray1638[i12] = nc3.readSignedByte();
            }
            if (j2 == 1) {
                anIntArray1639[i12] = nc4.readSignedByte();
                if (anIntArray1639[i12] < 0)
                    anIntArray1639[i12] = (256 + anIntArray1639[i12]);
            }
            if (k2 == 1)
                anIntArray1656[i12] = nc5.readUnsignedByte();
            if (l2 == 1)
                D[i12] = (short) (nc6.readUnsignedWord() - 1);
            if (x != null)
                if (D[i12] != -1)
                    x[i12] = (byte) (nc7.readUnsignedByte() - 1);
                else
                    x[i12] = -1;
        }
        nc1.currentOffset = k7;
        nc2.currentOffset = j6;
        int k12 = 0;
        int i13 = 0;
        int k13 = 0;
        int l13 = 0;
        for (int i14 = 0; i14 < numTriangles; i14++) {
            int j14 = nc2.readUnsignedByte();
            if (j14 == 1) {
                k12 = nc1.method421() + l13;
                l13 = k12;
                i13 = nc1.method421() + l13;
                l13 = i13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 2) {
                i13 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 3) {
                k12 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 4) {
                int l14 = k12;
                k12 = i13;
                i13 = l14;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
        }
        nc1.currentOffset = j9;
        nc2.currentOffset = k9;
        nc3.currentOffset = l9;
        nc4.currentOffset = i10;
        nc5.currentOffset = j10;
        nc6.currentOffset = k10;
        for (int k14 = 0; k14 < numTexTriangles; k14++) {
            int i15 = O[k14] & 0xff;
            if (i15 == 0) {
                texTrianglesPoint1[k14] = nc1.readUnsignedWord();
                texTrianglesPoint2[k14] = nc1.readUnsignedWord();
                texTrianglesPoint3[k14] = nc1.readUnsignedWord();
            }
            if (i15 == 1) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
            if (i15 == 2) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
                cb[k14] = nc6.readSignedByte();
                J[k14] = nc6.readSignedByte();
            }
            if (i15 == 3) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
        }
        if (i2 != 255) {
            for (int i12 = 0; i12 < numTriangles; i12++) {
                anIntArray1638[i12] = (byte) i2; // 03-07-2017 added (byte)
            }
        }
        currentModelColors = triangleColours2;
        vertexCount = numVertices;
        totalModelColors = numTriangles;
        anIntArray1627 = vertexX;
        anIntArray1628 = vertexY;
        anIntArray1629 = vertexZ;
        anIntArray1631 = facePoint1;
        anIntArray1632 = facePoint2;
        anIntArray1633 = facePoint3;
        for (int id = 0; id < totalModelColors; id++) {
            int a = anIntArray1631[id];
            int b = anIntArray1632[id];
            int c = anIntArray1633[id];
            boolean filter = true;
            label2:
            for (int id2 = 0; id2 < totalModelColors; id2++) {
                if (id2 == id) {
                    continue label2;
                }
                if (anIntArray1631[id2] == a) {
                    filter = false;
                    break label2;
                }
                if (anIntArray1632[id2] == b) {
                    filter = false;
                    break label2;
                }
                if (anIntArray1633[id2] == c) {
                    filter = false;
                    break label2;
                }
            }
            if (filter) {
                if (anIntArray1637 != null) {
                    anIntArray1639[id] = 255;
                }
            }
        }
    }

    public void readOldModel(byte[] data, int modelId) {
        boolean has_face_type = false;
        boolean has_texture_type = false;
        Stream stream = new Stream(data);
        Stream stream1 = new Stream(data);
        Stream stream2 = new Stream(data);
        Stream stream3 = new Stream(data);
        Stream stream4 = new Stream(data);
        stream.currentOffset = data.length - 18;
        vertexCount = stream.readUnsignedWord();
        totalModelColors = stream.readUnsignedWord();
        anInt1642 = stream.readUnsignedByte();
        int type_opcode = stream.readUnsignedByte();
        int priority_opcode = stream.readUnsignedByte();
        int alpha_opcode = stream.readUnsignedByte();
        int tSkin_opcode = stream.readUnsignedByte();
        int vSkin_opcode = stream.readUnsignedByte();
        int i_254_ = stream.readUnsignedWord();
        int i_255_ = stream.readUnsignedWord();
        int i_256_ = stream.readUnsignedWord();
        int i_257_ = stream.readUnsignedWord();
        int i_258_ = 0;

        int i_259_ = i_258_;
        i_258_ += vertexCount;

        int i_260_ = i_258_;
        i_258_ += totalModelColors;

        int i_261_ = i_258_;
        if (priority_opcode == 255)
            i_258_ += totalModelColors;

        int i_262_ = i_258_;
        if (tSkin_opcode == 1)
            i_258_ += totalModelColors;

        int i_263_ = i_258_;
        if (type_opcode == 1)
            i_258_ += totalModelColors;

        int i_264_ = i_258_;
        if (vSkin_opcode == 1)
            i_258_ += vertexCount;

        int i_265_ = i_258_;
        if (alpha_opcode == 1)
            i_258_ += totalModelColors;

        int i_266_ = i_258_;
        i_258_ += i_257_;

        int i_267_ = i_258_;
        i_258_ += totalModelColors * 2;

        int i_268_ = i_258_;
        i_258_ += anInt1642 * 6;

        int i_269_ = i_258_;
        i_258_ += i_254_;

        int i_270_ = i_258_;
        i_258_ += i_255_;

        int i_271_ = i_258_;
        i_258_ += i_256_;

        anIntArray1627 = new int[vertexCount];
        anIntArray1628 = new int[vertexCount];
        anIntArray1629 = new int[vertexCount];
        anIntArray1631 = new int[totalModelColors];
        anIntArray1632 = new int[totalModelColors];
        anIntArray1633 = new int[totalModelColors];
        if (anInt1642 > 0) {
            texture_type = new byte[anInt1642];
            anIntArray1643 = new short[anInt1642];
            anIntArray1644 = new short[anInt1642];
            anIntArray1645 = new short[anInt1642];
        }

        if (vSkin_opcode == 1)
            anIntArray1655 = new int[vertexCount];

        if (type_opcode == 1) {
            anIntArray1637 = new int[totalModelColors];
            texture_coordinates = new byte[totalModelColors];
            texture = new short[totalModelColors];
        }

        if (priority_opcode == 255)
            anIntArray1638 = new byte[totalModelColors];
        else
            anInt1641 = (byte) priority_opcode;

        if (alpha_opcode == 1)
            anIntArray1639 = new int[totalModelColors];

        if (tSkin_opcode == 1)
            anIntArray1656 = new int[totalModelColors];

        currentModelColors = new short[totalModelColors];
        stream.currentOffset = i_259_;
        stream1.currentOffset = i_269_;
        stream2.currentOffset = i_270_;
        stream3.currentOffset = i_271_;
        stream4.currentOffset = i_264_;
        int start_x = 0;
        int start_y = 0;
        int start_z = 0;
        for (int point = 0; point < vertexCount; point++) {
            int flag = stream.readUnsignedByte();
            int x = 0;
            if ((flag & 0x1) != 0)
                x = stream1.method421();
            int y = 0;
            if ((flag & 0x2) != 0)
                y = stream2.method421();
            int z = 0;
            if ((flag & 0x4) != 0)
                z = stream3.method421();

            anIntArray1627[point] = start_x + x;
            anIntArray1628[point] = start_y + y;
            anIntArray1629[point] = start_z + z;
            start_x = anIntArray1627[point];
            start_y = anIntArray1628[point];
            start_z = anIntArray1629[point];
            if (vSkin_opcode == 1)
                anIntArray1655[point] = stream4.readUnsignedByte();

        }
        stream.currentOffset = i_267_;
        stream1.currentOffset = i_263_;
        stream2.currentOffset = i_261_;
        stream3.currentOffset = i_265_;
        stream4.currentOffset = i_262_;
        for (int face = 0; face < totalModelColors; face++) {
            currentModelColors[face] = (short) stream.readUnsignedWord();
            if (type_opcode == 1) {
                int flag = stream1.readUnsignedByte();
                if ((flag & 0x1) == 1) {
                    anIntArray1637[face] = 1;
                    has_face_type = true;
                } else {
                    anIntArray1637[face] = 0;
                }

                if ((flag & 0x2) != 0) {
                    texture_coordinates[face] = (byte) (flag >> 2);
                    texture[face] = currentModelColors[face];
                    currentModelColors[face] = 127;
                    if (texture[face] != -1)
                        has_texture_type = true;
                } else {
                    texture_coordinates[face] = -1;
                    texture[face] = -1;
                }
            }
            if (priority_opcode == 255)
                anIntArray1638[face] = stream2.readSignedByte();

            if (alpha_opcode == 1) {
                anIntArray1639[face] = stream3.readSignedByte();
                if (anIntArray1639[face] < 0)
                    anIntArray1639[face] = (256 + anIntArray1639[face]);

            }
            if (tSkin_opcode == 1)
                anIntArray1656[face] = stream4.readUnsignedByte();

        }
        stream.currentOffset = i_266_;
        stream1.currentOffset = i_260_;
        int coordinate_a = 0;
        int coordinate_b = 0;
        int coordinate_c = 0;
        int offset = 0;
        int coordinate;
        for (int face = 0; face < totalModelColors; face++) {
            int opcode = stream1.readUnsignedByte();
            if (opcode == 1) {
                coordinate_a = (stream.method421() + offset);
                offset = coordinate_a;
                coordinate_b = (stream.method421() + offset);
                offset = coordinate_b;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 2) {
                coordinate_b = coordinate_c;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 3) {
                coordinate_a = coordinate_c;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
            if (opcode == 4) {
                coordinate = coordinate_a;
                coordinate_a = coordinate_b;
                coordinate_b = coordinate;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                anIntArray1631[face] = coordinate_a;
                anIntArray1632[face] = coordinate_b;
                anIntArray1633[face] = coordinate_c;
            }
        }
        stream.currentOffset = i_268_;
        for (int face = 0; face < anInt1642; face++) {
            texture_type[face] = 0;
            anIntArray1643[face] = (short) stream.readUnsignedWord();
            anIntArray1644[face] = (short) stream.readUnsignedWord();
            anIntArray1645[face] = (short) stream.readUnsignedWord();
        }
        if (texture_coordinates != null) {
            boolean textured = false;
            for (int face = 0; face < totalModelColors; face++) {
                coordinate = texture_coordinates[face] & 0xff;
                if (coordinate != 255) {
                    if (((anIntArray1643[coordinate] & 0xffff) == anIntArray1631[face]) && ((anIntArray1644[coordinate] & 0xffff) == anIntArray1632[face]) && ((anIntArray1645[coordinate] & 0xffff) == anIntArray1633[face])) {
                        texture_coordinates[face] = -1;
                    } else {
                        textured = true;
                    }
                }
            }
            if (!textured)
                texture_coordinates = null;
        }
        if (!has_texture_type)
            texture = null;

        if (!has_face_type)
            anIntArray1637 = null;

    }

    public void method464(Model model, boolean flag) {
        vertexCount = model.vertexCount;
        totalModelColors = model.totalModelColors;
        anInt1642 = model.anInt1642;
        if (anIntArray1622.length < vertexCount) {
            anIntArray1622 = new int[vertexCount + 10000];
            anIntArray1623 = new int[vertexCount + 10000];
            anIntArray1624 = new int[vertexCount + 10000];
        }
        anIntArray1627 = anIntArray1622;
        anIntArray1628 = anIntArray1623;
        anIntArray1629 = anIntArray1624;
        for (int k = 0; k < vertexCount; k++) {
            anIntArray1627[k] = model.anIntArray1627[k];
            anIntArray1628[k] = model.anIntArray1628[k];
            anIntArray1629[k] = model.anIntArray1629[k];
        }

        if (flag) {
            anIntArray1639 = model.anIntArray1639;
        } else {
            if (anIntArray1625.length < totalModelColors) {
                anIntArray1625 = new int[totalModelColors + 100];
            }
            anIntArray1639 = anIntArray1625;
            if (model.anIntArray1639 == null) {
                for (int l = 0; l < totalModelColors; l++) {
                    anIntArray1639[l] = 0;
                }

            } else {
                for (int i1 = 0; i1 < totalModelColors; i1++) {
                    anIntArray1639[i1] = model.anIntArray1639[i1];
                }

            }
        }
        anIntArray1637 = model.anIntArray1637;
        currentModelColors = model.currentModelColors;
        anIntArray1638 = model.anIntArray1638;
        anInt1641 = model.anInt1641;
        anIntArrayArray1658 = model.anIntArrayArray1658;
        anIntArrayArray1657 = model.anIntArrayArray1657;
        anIntArray1631 = model.anIntArray1631;
        anIntArray1632 = model.anIntArray1632;
        anIntArray1633 = model.anIntArray1633;
        anIntArray1634 = model.anIntArray1634;
        anIntArray1635 = model.anIntArray1635;
        anIntArray1636 = model.anIntArray1636;
        anIntArray1643 = model.anIntArray1643;
        anIntArray1644 = model.anIntArray1644;
        anIntArray1645 = model.anIntArray1645;
        texture_coordinates = model.texture_coordinates;
        texture_type = model.texture_type;
        texture = model.texture;
    }

    private final int method465(Model model, int i) {
        int j = -1;
		if (i > model.anIntArray1627.length - 1) {
			i = 0;
		}
        int k = model.anIntArray1627[i];
        int l = model.anIntArray1628[i];
        int i1 = model.anIntArray1629[i];
        for (int j1 = 0; j1 < vertexCount; j1++) {
            if (k != anIntArray1627[j1] || l != anIntArray1628[j1] || i1 != anIntArray1629[j1]) {
                continue;
            }
            j = j1;
            break;
        }

        if (j == -1) {
            anIntArray1627[vertexCount] = k;
            anIntArray1628[vertexCount] = l;
            anIntArray1629[vertexCount] = i1;
            if (model.anIntArray1655 != null) {
                anIntArray1655[vertexCount] = model.anIntArray1655[i];
            }
            j = vertexCount++;
        }
        return j;
    }

    public void method466() {
        super.modelHeight = 0;
        anInt1650 = 0;
        anInt1651 = 0;
        for (int i = 0; i < vertexCount; i++) {
            int j = anIntArray1627[i];
            int k = anIntArray1628[i];
            int l = anIntArray1629[i];
            if (-k > super.modelHeight) {
                super.modelHeight = -k;
            }
            if (k > anInt1651) {
                anInt1651 = k;
            }
            int i1 = j * j + l * l;
            if (i1 > anInt1650) {
                anInt1650 = i1;
            }
        }
        anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
        anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        anInt1652 = anInt1653 + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
    }

    public void method467() {
        super.modelHeight = 0;
        anInt1651 = 0;
        for (int i = 0; i < vertexCount; i++) {
            int j = anIntArray1628[i];
            if (-j > super.modelHeight)
                super.modelHeight = -j;
            if (j > anInt1651)
                anInt1651 = j;
        }

        anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight) + 0.98999999999999999D);
        anInt1652 = anInt1653 + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
    }

    public void method468(int i) {
        super.modelHeight = 0;
        anInt1650 = 0;
        anInt1651 = 0;
        anInt1646 = 0xf423f;
        anInt1647 = 0xfff0bdc1;
        anInt1648 = 0xfffe7961;
        anInt1649 = 0x1869f;
        for (int j = 0; j < vertexCount; j++) {
            int k = anIntArray1627[j];
            int l = anIntArray1628[j];
            int i1 = anIntArray1629[j];
            if (k < anInt1646)
                anInt1646 = k;
            if (k > anInt1647)
                anInt1647 = k;
            if (i1 < anInt1649)
                anInt1649 = i1;
            if (i1 > anInt1648)
                anInt1648 = i1;
            if (-l > super.modelHeight)
                super.modelHeight = -l;
            if (l > anInt1651)
                anInt1651 = l;
            int j1 = k * k + i1 * i1;
            if (j1 > anInt1650)
                anInt1650 = j1;
        }

        anInt1650 = (int) Math.sqrt(anInt1650);
        anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight);
        if (i != 21073) {
            return;
        } else {
            anInt1652 = anInt1653 + (int) Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651);
            return;
        }
    }

    public void method469() {
        if (anIntArray1655 != null) {
            int ai[] = new int[256];
            int j = 0;
            for (int l = 0; l < vertexCount; l++) {
                int j1 = anIntArray1655[l];
                ai[j1]++;
                if (j1 > j)
                    j = j1;
            }

            anIntArrayArray1657 = new int[j + 1][];
            for (int k1 = 0; k1 <= j; k1++) {
                anIntArrayArray1657[k1] = new int[ai[k1]];
                ai[k1] = 0;
            }

            for (int j2 = 0; j2 < vertexCount; j2++) {
                int l2 = anIntArray1655[j2];
                anIntArrayArray1657[l2][ai[l2]++] = j2;
            }

            anIntArray1655 = null;
        }
        if (anIntArray1656 != null) {
            int ai1[] = new int[256];
            int k = 0;
            for (int i1 = 0; i1 < totalModelColors; i1++) {
                int l1 = anIntArray1656[i1];
                ai1[l1]++;
                if (l1 > k)
                    k = l1;
            }

            anIntArrayArray1658 = new int[k + 1][];
            for (int i2 = 0; i2 <= k; i2++) {
                anIntArrayArray1658[i2] = new int[ai1[i2]];
                ai1[i2] = 0;
            }

            for (int k2 = 0; k2 < totalModelColors; k2++) {
                int i3 = anIntArray1656[k2];
                anIntArrayArray1658[i3][ai1[i3]++] = k2;
            }

            anIntArray1656 = null;
        }
    }

    public void method470(int i) {
        if (anIntArrayArray1657 == null)
            return;
        if (i == -1)
            return;
        Frames class36 = Frames.get(i);
        if (class36 == null)
            return;
        FramesBase class18 = class36.skinlist;
        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        for (int k = 0; k < class36.stepcount; k++) {
            int l = class36.opcodeLinkTable[k];
            method472(class18.opcode[l], class18.skinlist[l], class36.modifier1[k], class36.modifier2[k], class36.modifier3[k]);
        }

    }

    public void method470(int frame, int nextFrame, int end, int cycle) {
        if (!Client.tweening) {
            method470(frame);
            return;
        }
        if (Client.newTweening && Client.tweening) {
            if (anIntArrayArray1657 == null) {
                return;
            }
            if (frame == -1) {
                return;
            }
            final Frames currAnim = Frames.get(frame);
            if (currAnim == null) {
                return;
            }
            final FramesBase skinList = currAnim.skinlist;
            Frames nextAnim = null;
            if (nextFrame != -1) {
                nextAnim = Frames.get(nextFrame);
                if (nextAnim.skinlist != skinList) {
                    nextAnim = null;
                }
            }
            anInt1681 = 0;
            anInt1682 = 0;
            anInt1683 = 0;
            if (nextAnim == null) {
                for (int index = 0; index < currAnim.stepcount; index++) {
                    int anim = currAnim.opcodeLinkTable[index];
                    method472(skinList.opcode[anim], skinList.skinlist[anim], currAnim.modifier1[index], currAnim.modifier2[index], currAnim.modifier3[index]);
                }
            } else {
                int currFrameId = 0;
                int nextFrameId = 0;
                for (int index = 0; index < skinList.length; index++) {
                    boolean interpolate = false;
                    if (currFrameId < currAnim.stepcount && currAnim.opcodeLinkTable[currFrameId] == index) {
                        interpolate = true;
                    }
                    boolean interpolate2 = false;
                    if (nextFrameId < nextAnim.stepcount && nextAnim.opcodeLinkTable[nextFrameId] == index) {
                        interpolate2 = true;
                    }
                    if (interpolate || interpolate2) {
                        int defaultModifier = 0;
                        int opcode = skinList.opcode[index];
                        if (opcode == 3) {
                            defaultModifier = 128;
                        }
                        int currAnimX;
                        int currAnimY;
                        int currAnimZ;
                        if (interpolate) {
                            currAnimX = currAnim.modifier1[currFrameId];
                            currAnimY = currAnim.modifier2[currFrameId];
                            currAnimZ = currAnim.modifier3[currFrameId];
                            currFrameId++;
                        } else {
                            currAnimX = defaultModifier;
                            currAnimY = defaultModifier;
                            currAnimZ = defaultModifier;
                        }
                        int nextAnimX;
                        int nextAnimY;
                        int nextAnimZ;
                        if (interpolate2) {
                            nextAnimX = nextAnim.modifier1[nextFrameId];
                            nextAnimY = nextAnim.modifier2[nextFrameId];
                            nextAnimZ = nextAnim.modifier3[nextFrameId];
                            nextFrameId++;
                        } else {
                            nextAnimX = defaultModifier;
                            nextAnimY = defaultModifier;
                            nextAnimZ = defaultModifier;
                        }
                        int interpolatedX;
                        int interpolatedY;
                        int interpolatedZ;
                        if (opcode == 2) {
                            int deltaX = nextAnimX - currAnimX & 0x7ff;
                            int deltaY = nextAnimY - currAnimY & 0x7ff;
                            int deltaZ = nextAnimZ - currAnimZ & 0x7ff;
                            if (deltaX >= 1024) {
                                deltaX -= 2048;
                            }
                            if (deltaY >= 1024) {
                                deltaY -= 2048;
                            }
                            if (deltaZ >= 1024) {
                                deltaZ -= 2048;
                            }
                            interpolatedX = currAnimX + deltaX * cycle / end & 0x7ff;
                            interpolatedY = currAnimY + deltaY * cycle / end & 0x7ff;
                            interpolatedZ = currAnimZ + deltaZ * cycle / end & 0x7ff;
                        } else {
                            interpolatedX = currAnimX + (nextAnimX - currAnimX) * cycle / end;
                            interpolatedY = currAnimY + (nextAnimY - currAnimY) * cycle / end;
                            interpolatedZ = currAnimZ + (nextAnimZ - currAnimZ) * cycle / end;
                        }
                        method472(opcode, skinList.skinlist[index], interpolatedX, interpolatedY, interpolatedZ);
                    }
                }
            }
        } else {
            if (anIntArrayArray1657 != null && frame != -1) {
                Frames currentAnimation = Frames.get(frame);
                if (currentAnimation == null) {
                    return;
                }
                FramesBase list1 = currentAnimation.skinlist;
                anInt1681 = 0;
                anInt1682 = 0;
                anInt1683 = 0;
                Frames nextAnimation = null;
                FramesBase list2 = null;
                if (nextFrame != -1) {
                    nextAnimation = Frames.get(nextFrame);
                    if (nextAnimation.skinlist != list1) {
                        nextAnimation = null;
                    }
                    list2 = nextAnimation.skinlist;
                }
                if (nextAnimation == null || list2 == null) {
                    for (int i_263_ = 0; i_263_ < currentAnimation.stepcount; i_263_++) {
                        int i_264_ = currentAnimation.opcodeLinkTable[i_263_];
                        method472(list1.opcode[i_264_], list1.skinlist[i_264_], currentAnimation.modifier1[i_263_], currentAnimation.modifier2[i_263_], currentAnimation.modifier3[i_263_]);

                    }
                } else {
                    for (int i1 = 0; i1 < currentAnimation.stepcount; i1++) {
                        int n1 = currentAnimation.opcodeLinkTable[i1];
                        int opcode = list1.opcode[n1];
                        int[] skin = list1.skinlist[n1];
                        int x = currentAnimation.modifier1[i1];
                        int y = currentAnimation.modifier2[i1];
                        int z = currentAnimation.modifier3[i1];
                        boolean found = false;
                        for (int i2 = 0; i2 < nextAnimation.stepcount; i2++) {
                            int n2 = nextAnimation.opcodeLinkTable[i2];
                            if (list2.skinlist[n2].equals(skin)) {
                                if (opcode != 2) {
                                    x += (nextAnimation.modifier1[i2] - x) * cycle / end;
                                    y += (nextAnimation.modifier2[i2] - y) * cycle / end;
                                    z += (nextAnimation.modifier3[i2] - z) * cycle / end;
                                } else {
                                    x &= 0xff;
                                    y &= 0xff;
                                    z &= 0xff;
                                    int dx = nextAnimation.modifier1[i2] - x & 0xff;
                                    int dy = nextAnimation.modifier2[i2] - y & 0xff;
                                    int dz = nextAnimation.modifier3[i2] - z & 0xff;
                                    if (dx >= 128) {
                                        dx -= 256;
                                    }
                                    if (dy >= 128) {
                                        dy -= 256;
                                    }
                                    if (dz >= 128) {
                                        dz -= 256;
                                    }
                                    x = x + dx * cycle / end & 0xff;
                                    y = y + dy * cycle / end & 0xff;
                                    z = z + dz * cycle / end & 0xff;
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            if (opcode != 3 && opcode != 2) {
                                x = x * (end - cycle) / end;
                                y = y * (end - cycle) / end;
                                z = z * (end - cycle) / end;
                            } else if (opcode == 3) {
                                x = (x * (end - cycle) + (cycle << 7)) / end;
                                y = (y * (end - cycle) + (cycle << 7)) / end;
                                z = (z * (end - cycle) + (cycle << 7)) / end;
                            } else {
                                x &= 0xff;
                                y &= 0xff;
                                z &= 0xff;
                                int dx = -x & 0xff;
                                int dy = -y & 0xff;
                                int dz = -z & 0xff;
                                if (dx >= 128) {
                                    dx -= 256;
                                }
                                if (dy >= 128) {
                                    dy -= 256;
                                }
                                if (dz >= 128) {
                                    dz -= 256;
                                }
                                x = x + dx * cycle / end & 0xff;
                                y = y + dy * cycle / end & 0xff;
                                z = z + dz * cycle / end & 0xff;
                            }
                        }
                        method472(opcode, skin, x, y, z);
                    }
                }
            }
        }
    }

    public void method471(int ai[], int j, int k) {
        if (k == -1)
            return;
        if (ai == null || j == -1) {
            method470(k);
            return;
        }
        Frames class36 = Frames.get(k);
        if (class36 == null)
            return;
        Frames class36_1 = Frames.get(j);
        if (class36_1 == null) {
            method470(k);
            return;
        }
        FramesBase class18 = class36.skinlist;
        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        int l = 0;
        int i1 = ai[l++];
        for (int j1 = 0; j1 < class36.stepcount; j1++) {
            int k1;
            for (k1 = class36.opcodeLinkTable[j1]; k1 > i1; i1 = ai[l++])
                ;
            if (k1 != i1 || class18.opcode[k1] == 0)
                method472(class18.opcode[k1], class18.skinlist[k1], class36.modifier1[j1], class36.modifier2[j1], class36.modifier3[j1]);
        }

        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        l = 0;
        i1 = ai[l++];
        for (int l1 = 0; l1 < class36_1.stepcount; l1++) {
            int i2;
            for (i2 = class36_1.opcodeLinkTable[l1]; i2 > i1; i1 = ai[l++])
                ;
            if (i2 == i1 || class18.opcode[i2] == 0)
                method472(class18.opcode[i2], class18.skinlist[i2], class36_1.modifier1[l1], class36_1.modifier2[l1], class36_1.modifier3[l1]);
        }

    }

    private void method472(int i, int ai[], int j, int k, int l) {

        int i1 = ai.length;
        if (i == 0) {
            int j1 = 0;
            anInt1681 = 0;
            anInt1682 = 0;
            anInt1683 = 0;
            for (int k2 = 0; k2 < i1; k2++) {
                int l3 = ai[k2];
                if (l3 < anIntArrayArray1657.length) {
                    int ai5[] = anIntArrayArray1657[l3];
                    for (int i5 = 0; i5 < ai5.length; i5++) {
                        int j6 = ai5[i5];
                        anInt1681 += anIntArray1627[j6];
                        anInt1682 += anIntArray1628[j6];
                        anInt1683 += anIntArray1629[j6];
                        j1++;
                    }

                }
            }

            if (j1 > 0) {
                anInt1681 = anInt1681 / j1 + j;
                anInt1682 = anInt1682 / j1 + k;
                anInt1683 = anInt1683 / j1 + l;
                return;
            } else {
                anInt1681 = j;
                anInt1682 = k;
                anInt1683 = l;
                return;
            }
        }
        if (i == 1) {
            for (int k1 = 0; k1 < i1; k1++) {
                int l2 = ai[k1];
                if (l2 < anIntArrayArray1657.length) {
                    int ai1[] = anIntArrayArray1657[l2];
                    for (int i4 = 0; i4 < ai1.length; i4++) {
                        int j5 = ai1[i4];
                        anIntArray1627[j5] += j;
                        anIntArray1628[j5] += k;
                        anIntArray1629[j5] += l;
                    }

                }
            }

            return;
        }
        if (Client.newTweening && Client.tweening) {
            if (i == 2) {
                for (int l1 = 0; l1 < i1; l1++) {
                    int i3 = ai[l1];
                    if (i3 < anIntArrayArray1657.length) {
                        int ai2[] = anIntArrayArray1657[i3];
                        for (int j4 = 0; j4 < ai2.length; j4++) {
                            int k5 = ai2[j4];
                            anIntArray1627[k5] -= anInt1681;
                            anIntArray1628[k5] -= anInt1682;
                            anIntArray1629[k5] -= anInt1683;
                            if (l != 0) {
                                int j7 = modelIntArray1[l];
                                int i8 = modelIntArray2[l];
                                int l8 = anIntArray1628[k5] * j7 + anIntArray1627[k5] * i8 >> 16;
                                anIntArray1628[k5] = anIntArray1628[k5] * i8 - anIntArray1627[k5] * j7 >> 16;
                                anIntArray1627[k5] = l8;
                            }
                            if (j != 0) {
                                int k7 = modelIntArray1[j];
                                int j8 = modelIntArray2[j];
                                int i9 = anIntArray1628[k5] * j8 - anIntArray1629[k5] * k7 >> 16;
                                anIntArray1629[k5] = anIntArray1628[k5] * k7 + anIntArray1629[k5] * j8 >> 16;
                                anIntArray1628[k5] = i9;
                            }
                            if (k != 0) {
                                int l7 = modelIntArray1[k];
                                int k8 = modelIntArray2[k];
                                int j9 = anIntArray1629[k5] * l7 + anIntArray1627[k5] * k8 >> 16;
                                anIntArray1629[k5] = anIntArray1629[k5] * k8 - anIntArray1627[k5] * l7 >> 16;
                                anIntArray1627[k5] = j9;
                            }
                            anIntArray1627[k5] += anInt1681;
                            anIntArray1628[k5] += anInt1682;
                            anIntArray1629[k5] += anInt1683;
                        }

                    }
                }
                return;
            }
        } else {
            if (i == 2) {
                for (int l1 = 0; l1 < i1; l1++) {
                    int i3 = ai[l1];
                    if (i3 < anIntArrayArray1657.length) {
                        int ai2[] = anIntArrayArray1657[i3];
                        for (int j4 = 0; j4 < ai2.length; j4++) {
                            int k5 = ai2[j4];
                            anIntArray1627[k5] -= anInt1681;
                            anIntArray1628[k5] -= anInt1682;
                            anIntArray1629[k5] -= anInt1683;
                            int k6 = (j & 0xff) * 8;
                            int l6 = (k & 0xff) * 8;
                            int i7 = (l & 0xff) * 8;
                            if (i7 != 0) {
                                int j7 = modelIntArray1[i7];
                                int i8 = modelIntArray2[i7];
                                int l8 = anIntArray1628[k5] * j7 + anIntArray1627[k5] * i8 >> 16;
                                anIntArray1628[k5] = anIntArray1628[k5] * i8 - anIntArray1627[k5] * j7 >> 16;
                                anIntArray1627[k5] = l8;
                            }
                            if (k6 != 0) {
                                int k7 = modelIntArray1[k6];
                                int j8 = modelIntArray2[k6];
                                int i9 = anIntArray1628[k5] * j8 - anIntArray1629[k5] * k7 >> 16;
                                anIntArray1629[k5] = anIntArray1628[k5] * k7 + anIntArray1629[k5] * j8 >> 16;
                                anIntArray1628[k5] = i9;
                            }
                            if (l6 != 0) {
                                int l7 = modelIntArray1[l6];
                                int k8 = modelIntArray2[l6];
                                int j9 = anIntArray1629[k5] * l7 + anIntArray1627[k5] * k8 >> 16;
                                anIntArray1629[k5] = anIntArray1629[k5] * k8 - anIntArray1627[k5] * l7 >> 16;
                                anIntArray1627[k5] = j9;
                            }
                            anIntArray1627[k5] += anInt1681;
                            anIntArray1628[k5] += anInt1682;
                            anIntArray1629[k5] += anInt1683;
                        }

                    }
                }
                return;
            }
        }
        if (i == 3) {
            for (int i2 = 0; i2 < i1; i2++) {
                int j3 = ai[i2];
                if (j3 < anIntArrayArray1657.length) {
                    int ai3[] = anIntArrayArray1657[j3];
                    for (int k4 = 0; k4 < ai3.length; k4++) {
                        int l5 = ai3[k4];
                        anIntArray1627[l5] -= anInt1681;
                        anIntArray1628[l5] -= anInt1682;
                        anIntArray1629[l5] -= anInt1683;
                        anIntArray1627[l5] = (anIntArray1627[l5] * j) / 128;
                        anIntArray1628[l5] = (anIntArray1628[l5] * k) / 128;
                        anIntArray1629[l5] = (anIntArray1629[l5] * l) / 128;
                        anIntArray1627[l5] += anInt1681;
                        anIntArray1628[l5] += anInt1682;
                        anIntArray1629[l5] += anInt1683;
                    }
                }
            }
            return;
        }
        if (i == 5 && anIntArrayArray1658 != null && anIntArray1639 != null) {
            for (int j2 = 0; j2 < i1; j2++) {
                int k3 = ai[j2];
                if (k3 < anIntArrayArray1658.length) {
                    int ai4[] = anIntArrayArray1658[k3];
                    for (int l4 = 0; l4 < ai4.length; l4++) {
                        int i6 = ai4[l4];
                        anIntArray1639[i6] += j * 8;
                        if (anIntArray1639[i6] < 0)
                            anIntArray1639[i6] = 0;
                        if (anIntArray1639[i6] > 255)
                            anIntArray1639[i6] = 255;
                    }
                }
            }
        }
    }

    public void method473() {
        for (int j = 0; j < vertexCount; j++) {
            int k = anIntArray1627[j];
            anIntArray1627[j] = anIntArray1629[j];
            anIntArray1629[j] = -k;
        }
    }

    public void method474(int i) {
        int k = modelIntArray1[i];
        int l = modelIntArray2[i];
        for (int i1 = 0; i1 < vertexCount; i1++) {
            int j1 = anIntArray1628[i1] * l - anIntArray1629[i1] * k >> 16;
            anIntArray1629[i1] = anIntArray1628[i1] * k + anIntArray1629[i1] * l >> 16;
            anIntArray1628[i1] = j1;
        }
    }

    public void method475(int x, int positionFromBody, int height) {
        for (int i1 = 0; i1 < vertexCount; i1++) {
            anIntArray1627[i1] += x;
            anIntArray1628[i1] += positionFromBody;
            anIntArray1629[i1] += height;
        }
    }

    public void setColour(int found, int replace) {
        if (currentModelColors != null) {
            for (int face = 0; face < totalModelColors; face++) {
                if (currentModelColors[face] == (short) found) {
                    currentModelColors[face] = (short) replace;
                }
            }
        }
    }

    public void retexture(short found, short replace) {
        if (texture != null)
            for (int face = 0; face < totalModelColors; face++)
                if (texture[face] == found)
                    texture[face] = replace;
    }

    public void method477() {
        for (int j = 0; j < vertexCount; j++)
            anIntArray1629[j] = -anIntArray1629[j];
        for (int k = 0; k < totalModelColors; k++) {
            int l = anIntArray1631[k];
            anIntArray1631[k] = anIntArray1633[k];
            anIntArray1633[k] = l;
        }
    }

    /**
     * method478
     */
    public void scaleModel(int i, int j, int l) {
        for (int i1 = 0; i1 < vertexCount; i1++) {
            anIntArray1627[i1] = (anIntArray1627[i1] * i) / 128;
            anIntArray1628[i1] = (anIntArray1628[i1] * l) / 128;
            anIntArray1629[i1] = (anIntArray1629[i1] * j) / 128;
        }

    }

    public void scaleModel(int relative) {
        for (int i1 = 0; i1 < vertexCount; i1++) {
            anIntArray1627[i1] = (anIntArray1627[i1] * relative) / 128;
            anIntArray1628[i1] = (anIntArray1628[i1] * relative) / 128;
            anIntArray1629[i1] = (anIntArray1629[i1] * relative) / 128;
        }

    }

    public void method479(int i, int j, int k, int l, int i1, boolean flag) {
        method479(i, j, k, l, i1, flag, false);
    }

    public void method479(int i, int j, int k, int l, int i1, boolean flag, boolean player) {
        int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
        int k1 = j * j1 >> 8;
        anIntArray1634 = new int[totalModelColors];
        anIntArray1635 = new int[totalModelColors];
        anIntArray1636 = new int[totalModelColors];
        if (super.normals == null) {
            super.normals = new Vertex[vertexCount];
            for (int index = 0; index < vertexCount; index++)
                super.normals[index] = new Vertex();

        }
        for (int face = 0; face < totalModelColors; face++) {
            int j2 = anIntArray1631[face];
            int l2 = anIntArray1632[face];
            int i3 = anIntArray1633[face];
            int j3 = anIntArray1627[l2] - anIntArray1627[j2];
            int k3 = anIntArray1628[l2] - anIntArray1628[j2];
            int l3 = anIntArray1629[l2] - anIntArray1629[j2];
            int i4 = anIntArray1627[i3] - anIntArray1627[j2];
            int j4 = anIntArray1628[i3] - anIntArray1628[j2];
            int k4 = anIntArray1629[i3] - anIntArray1629[j2];
            int l4 = k3 * k4 - j4 * l3;
            int i5 = l3 * i4 - k4 * j3;
            int j5;
            for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192 || j5 < -8192; j5 >>= 1) {
                l4 >>= 1;
                i5 >>= 1;
            }
            int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
            if (k5 <= 0)
                k5 = 1;

            l4 = (l4 * 256) / k5;
            i5 = (i5 * 256) / k5;
            j5 = (j5 * 256) / k5;

            short texture_id;
            int type;
            if (anIntArray1637 != null)
                type = anIntArray1637[face];
            else
                type = 0;

            if (texture == null) {
                texture_id = -1;
            } else {
                texture_id = texture[face];
            }

            if (anIntArray1637 == null || (anIntArray1637[face] & 1) == 0) {
                Vertex class33_2 = super.normals[j2];
                class33_2.x += l4;
                class33_2.y += i5;
                class33_2.z += j5;
                class33_2.w++;
                class33_2 = super.normals[l2];
                class33_2.x += l4;
                class33_2.y += i5;
                class33_2.z += j5;
                class33_2.w++;
                class33_2 = super.normals[i3];
                class33_2.x += l4;
                class33_2.y += i5;
                class33_2.z += j5;
                class33_2.w++;
            } else {
                if (texture_id != -1) {
                    type = 2;
                }
                int light = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
                anIntArray1634[face] = method481(currentModelColors[face], light, type);
            }
        }
        if (flag) {
            method480(i, k1, k, l, i1, player);
            method466();
        } else {
            aClass33Array1660 = new Vertex[vertexCount];
            for (int point = 0; point < vertexCount; point++) {
                Vertex class33 = super.normals[point];
                Vertex class33_1 = aClass33Array1660[point] = new Vertex();
                class33_1.x = class33.x;
                class33_1.y = class33.y;
                class33_1.z = class33.z;
                class33_1.w = class33.w;
            }
            method468(21073);
        }
    }

    public final void method480(int i, int j, int k, int l, int i1) {
        method480(i, j, k, l, i1, false);
    }

    public final void method480(int i, int j, int k, int l, int i1, boolean player) {
        for (int j1 = 0; j1 < totalModelColors; j1++) {
            int k1 = anIntArray1631[j1];
            int i2 = anIntArray1632[j1];
            int j2 = anIntArray1633[j1];
            short texture_id;
            if (texture == null) {
                texture_id = -1;
            } else {
                texture_id = texture[j1];
				/*
				if (player)
				{
						if (anIntArray1639 != null && currentModelColors != null)
						{
								if (currentModelColors[j1] == 0 && anIntArray1638[j1] == 0)
								{
										if (anIntArray1637[j1] == 2 && texture[j1] == -1)
										{
												anIntArray1639[j1] = 255;
										}
								}
						}
						else if (anIntArray1639 == null)
						{
								if (currentModelColors[j1] == 0 && anIntArray1638[j1] == 0)
								{
										if (texture[j1] == -1)
										{
												anIntArray1639 = new int[totalModelColors];
												if (anIntArray1637[j1] == 2)
												{
														anIntArray1639[j1] = 255;
												}
										}
								}
						}
				}
				*/
            }

            if (anIntArray1637 == null) {
                int type;
                if (texture_id != -1) {
                    type = 2;
                } else {
                    type = 1;
                }
                int hsl = currentModelColors[j1] & 0xffff;
                Vertex vertex = super.normals[k1];
                int light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1634[j1] = method481(hsl, light, type);
                vertex = super.normals[i2];
                light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1635[j1] = method481(hsl, light, type);
                vertex = super.normals[j2];
                light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1636[j1] = method481(hsl, light, type);
            } else if ((anIntArray1637[j1] & 1) == 0) {
                int type = anIntArray1637[j1];
                if (texture_id != -1) {
                    type = 2;
                }
                int hsl = currentModelColors[j1] & 0xffff;
                Vertex vertex = super.normals[k1];
                int light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1634[j1] = method481(hsl, light, type);
                vertex = super.normals[i2];
                light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1635[j1] = method481(hsl, light, type);
                vertex = super.normals[j2];
                light = i + (k * vertex.x + l * vertex.y + i1 * vertex.z) / (j * vertex.w);
                anIntArray1636[j1] = method481(hsl, light, type);
            }
        }

        super.normals = null;
        aClass33Array1660 = null;
        anIntArray1655 = null;
        anIntArray1656 = null;
        currentModelColors = null;
    }

    public final void method482(int j, int k, int l, int i1, int j1, int k1, boolean forceHd) {
        int i = 0;
        int l1 = Rasterizer.centerX;
        int i2 = Rasterizer.centerY;
        int j2 = modelIntArray1[i];
        int k2 = modelIntArray2[i];
        int l2 = modelIntArray1[j];
        int i3 = modelIntArray2[j];
        int j3 = modelIntArray1[k];
        int k3 = modelIntArray2[k];
        int l3 = modelIntArray1[l];
        int i4 = modelIntArray2[l];
        int j4 = j1 * l3 + k1 * i4 >> 16;
        for (int k4 = 0; k4 < vertexCount; k4++) {
            int l4 = anIntArray1627[k4];
            int i5 = anIntArray1628[k4];
            int j5 = anIntArray1629[k4];
            if (k != 0) {
                int k5 = i5 * j3 + l4 * k3 >> 16;
                i5 = i5 * k3 - l4 * j3 >> 16;
                l4 = k5;
            }
            if (i != 0) {
                int l5 = i5 * k2 - j5 * j2 >> 16;
                j5 = i5 * j2 + j5 * k2 >> 16;
                i5 = l5;
            }
            if (j != 0) {
                int i6 = j5 * l2 + l4 * i3 >> 16;
                j5 = j5 * i3 - l4 * l2 >> 16;
                l4 = i6;
            }
            l4 += i1;
            i5 += j1;
            j5 += k1;
            int j6 = i5 * i4 - j5 * l3 >> 16;
            j5 = i5 * l3 + j5 * i4 >> 16;
            i5 = j6;
            anIntArray1667[k4] = j5 - j4;
            anIntArray1665[k4] = l1 + (l4 << 9) / j5;
            anIntArray1666[k4] = i2 + (i5 << 9) / j5;
            if (anInt1642 > 0) {
                anIntArray1668[k4] = l4;
                anIntArray1669[k4] = i5;
                anIntArray1670[k4] = j5;
            } else {
                anIntArray1670[k4] = j5;
            }
        }

        try {
            method483(false, false, 0, true);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public final void draw(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
        int j2 = l1 * i1 - j1 * l >> 16;
        int k2 = k1 * j + j2 * k >> 16;
        int l2 = anInt1650 * k >> 16;
        int i3 = k2 + l2;
        if (i3 <= 50 || k2 >= 3500)
            return;
        int j3 = l1 * l + j1 * i1 >> 16;
        int entityXBegin = j3 - anInt1650 << Client.viewDistance;
        if (entityXBegin / i3 >= DrawingArea.centerY)
            return;
        int entityXEnd = j3 + anInt1650 << Client.viewDistance;
        if (entityXEnd / i3 <= -DrawingArea.centerY)
            return;
        int i4 = k1 * k - j2 * j >> 16;
        int j4 = anInt1650 * j >> 16;
        int entityYEnd = i4 + j4 << Client.viewDistance;
        if (entityYEnd / i3 <= -DrawingArea.anInt1387)
            return;
        int l4 = j4 + (super.modelHeight * k >> 16);
        int entityYStart = i4 - l4 << Client.viewDistance;
        if (entityYStart / i3 >= DrawingArea.anInt1387)
            return;
        int j5 = l2 + (super.modelHeight * j >> 16);
        boolean flag = false;
        if (k2 - j5 <= 50)
            flag = true;
        boolean flag1 = false;
        if (i2 > 0 && aBoolean1684) {
            int k5 = k2 - l2;
            if (k5 <= 50)
                k5 = 50;
            if (j3 > 0) {
                entityXBegin /= i3;
                entityXEnd /= k5;
            } else {
                entityXEnd /= i3;
                entityXBegin /= k5;
            }
            if (i4 > 0) {
                entityYStart /= i3;
                entityYEnd /= k5;
            } else {
                entityYEnd /= i3;
                entityYStart /= k5;
            }
            // TODO #TIP model hover/click offset.
            int mouseX = anInt1685 - Rasterizer.centerX;
            int mouseY = anInt1686 - Rasterizer.centerY;
            int xBeginOffset = 0;
            int xEndOffset = 0;
            int yStartOffset = 0;
            boolean enable = true;
            if (enable) {
                if (Client.instance.chaseCameraPitch >= 150) {

                    // X offsets.
                    boolean negative = entityXBegin <= 0 ? true : false;
                    int cameraYMultiplier = Client.instance.chaseCameraPitch - 150;
                    cameraYMultiplier /= 36;
                    int value = Math.abs(entityXBegin);
                    value /= 40;
                    if (negative) {
                        xBeginOffset = value * (3 + cameraYMultiplier);
                        if (Client.isFixedScreen()) {
                            xBeginOffset -= 20;
                            if (xBeginOffset < 0) {
                                xBeginOffset = 0;
                            }
                        }
                    } else {
                        xEndOffset = value * (3 + cameraYMultiplier);
                        if (Client.isFixedScreen()) {
                            xEndOffset -= 20;
                            if (xEndOffset < 0) {
                                xEndOffset = 0;
                            }
                        }
                    }

                    // Y offsets.
                    negative = entityYStart <= 0 ? true : false;
                    cameraYMultiplier = Client.instance.chaseCameraPitch - 150;
                    cameraYMultiplier /= 36;
                    value = Math.abs(entityYStart);
                    value /= 60;
                    if (negative) {
                        yStartOffset = value * (3 + cameraYMultiplier);
                    }

                }
            }
            if (mouseX > (entityXBegin - xBeginOffset) && mouseX < (entityXEnd + xEndOffset) && mouseY > (entityYStart - yStartOffset) && mouseY < (entityYEnd + 0)) {
                if (aBoolean1659) {
                    anIntArray1688[anInt1687++] = i2;
                } else {
                    flag1 = true;
                }
            }
        }
        int l5 = Rasterizer.centerX;
        int j6 = Rasterizer.centerY;
        int l6 = 0;
        int i7 = 0;
        if (i != 0) {
            l6 = modelIntArray1[i];
            i7 = modelIntArray2[i];
        }
        for (int j7 = 0; j7 < vertexCount; j7++) {
            int k7 = anIntArray1627[j7];
            int l7 = anIntArray1628[j7];
            int i8 = anIntArray1629[j7];
            if (i != 0) {
                int j8 = i8 * l6 + k7 * i7 >> 16;
                i8 = i8 * i7 - k7 * l6 >> 16;
                k7 = j8;
            }
            k7 += j1;
            l7 += k1;
            i8 += l1;
            int k8 = i8 * l + k7 * i1 >> 16;
            i8 = i8 * i1 - k7 * l >> 16;
            k7 = k8;
            k8 = l7 * k - i8 * j >> 16;
            i8 = l7 * j + i8 * k >> 16;
            l7 = k8;
            anIntArray1667[j7] = i8 - k2;
            if (i8 >= 50) {
                anIntArray1665[j7] = l5 + (k7 << Client.viewDistance) / i8;
                anIntArray1666[j7] = j6 + (l7 << Client.viewDistance) / i8;
            } else {
                anIntArray1665[j7] = -5000;
                flag = true;
            }
            if (flag || anInt1642 > 0) {
                anIntArray1668[j7] = k7;
                anIntArray1669[j7] = l7;
                anIntArray1670[j7] = i8;
            } else {
                anIntArray1670[j7] = i8;
            }
        }

        try {
            method483(flag, flag1, i2, false);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private final void method483(boolean flag, boolean flag1, int i, boolean forceHd) {
        for (int j = 0; j < anInt1652; j++) {
            if (j > anIntArray1671.length - 1) {
                continue;
            }
            anIntArray1671[j] = 0;
        }

        for (int k = 0; k < totalModelColors; k++)
            if (anIntArray1637 == null || anIntArray1637[k] != -1) {
                int l = anIntArray1631[k];
                int k1 = anIntArray1632[k];
                int j2 = anIntArray1633[k];
                int i3 = anIntArray1665[l];
                int l3 = anIntArray1665[k1];
                int k4 = anIntArray1665[j2];
                if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
                    aBooleanArray1664[k] = true;
                    int j5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2]) / 3 + anInt1653;
                    anIntArrayArray1672[j5][anIntArray1671[j5]++] = k;
                } else {
                    if (flag1 && method486(anInt1685, anInt1686, anIntArray1666[l], anIntArray1666[k1], anIntArray1666[j2], i3, l3, k4)) {
                        anIntArray1688[anInt1687++] = i;
                        flag1 = false;
                    }
                    if ((i3 - l3) * (anIntArray1666[j2] - anIntArray1666[k1]) - (anIntArray1666[l] - anIntArray1666[k1]) * (k4 - l3) > 0) {
                        aBooleanArray1664[k] = false;
                        if (i3 < 0 || l3 < 0 || k4 < 0 || i3 > DrawingArea.centerX || l3 > DrawingArea.centerX || k4 > DrawingArea.centerX) {
                            if (k <= aBooleanArray1663.length - 1) {
                                aBooleanArray1663[k] = true;
                            }
                        } else {
                            if (k <= aBooleanArray1663.length - 1) {
                                aBooleanArray1663[k] = false;
                            }
                        }
                        int k5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2]) / 3 + anInt1653;
                        anIntArrayArray1672[k5][anIntArray1671[k5]++] = k;
                    }
                }
            }

        if (anIntArray1638 == null) {
            for (int i1 = anInt1652 - 1; i1 >= 0; i1--) {
                if (i1 <= anIntArray1671.length - 1) {
                    int l1 = anIntArray1671[i1];
                    if (l1 > 0) {
                        int ai[] = anIntArrayArray1672[i1];
                        for (int j3 = 0; j3 < l1; j3++)
                            method484(ai[j3], forceHd);

                    }
                }
            }

            return;
        }
        for (int j1 = 0; j1 < 12; j1++) {
            anIntArray1673[j1] = 0;
            anIntArray1677[j1] = 0;
        }

        for (int i2 = anInt1652 - 1; i2 >= 0; i2--) {
            if (i2 <= anIntArray1671.length - 1) {
                int k2 = anIntArray1671[i2];
                if (k2 > 0) {
                    int ai1[] = anIntArrayArray1672[i2];
                    for (int i4 = 0; i4 < k2; i4++) {
                        int l4 = ai1[i4];
                        int l5 = anIntArray1638[l4];
                        int j6 = anIntArray1673[l5]++;

                        if (l5 > anIntArrayArray1674.length - 1) {
                            continue;
                        }
                        if (j6 > anIntArrayArray1674[l5].length - 1) {
                            continue;
                        }
                        anIntArrayArray1674[l5][j6] = l4;
                        if (l5 < 10)
                            anIntArray1677[l5] += i2;
                        else if (l5 == 10)
                            anIntArray1675[j6] = i2;
                        else
                            anIntArray1676[j6] = i2;
                    }

                }
            }
        }

        int l2 = 0;
        if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
            l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
        int k3 = 0;
        if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
            k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
        int j4 = 0;
        if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
            j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
        int i6 = 0;
        int k6 = anIntArray1673[10];
        int ai2[] = anIntArrayArray1674[10];
        int ai3[] = anIntArray1675;
        if (i6 == k6) {
            i6 = 0;
            k6 = anIntArray1673[11];
            ai2 = anIntArrayArray1674[11];
            ai3 = anIntArray1676;
        }
        int i5;
        if (i6 < k6)
            i5 = ai3[i6];
        else
            i5 = -1000;
        for (int l6 = 0; l6 < 10; l6++) {
            while (l6 == 0 && i5 > l2) {
                method484(ai2[i6++], forceHd);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 3 && i5 > k3) {
                method484(ai2[i6++], forceHd);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 5 && i5 > j4) {
                method484(ai2[i6++], forceHd);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            int i7 = anIntArray1673[l6];
            int ai4[] = anIntArrayArray1674[l6];
            for (int j7 = 0; j7 < i7; j7++)
                method484(ai4[j7], forceHd);

        }

        while (i5 != -1000) {
            method484(ai2[i6++], forceHd);
            if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                i6 = 0;
                ai2 = anIntArrayArray1674[11];
                k6 = anIntArray1673[11];
                ai3 = anIntArray1676;
            }
            if (i6 < k6)
                i5 = ai3[i6];
            else
                i5 = -1000;
        }
    }

    private final void method484(int i, boolean forceHd) {
        if (aBooleanArray1664[i]) {
            method485(i);
            return;
        }
        int j = anIntArray1631[i];
        int k = anIntArray1632[i];
        int l = anIntArray1633[i];
        Rasterizer.checkBounds = aBooleanArray1663[i];
        if (anIntArray1639 == null)
            Rasterizer.transparency = 0;
        else
            Rasterizer.transparency = anIntArray1639[i] & 0xff;

        int type;
        if (anIntArray1637 == null)
            type = 0;
        else
            type = anIntArray1637[i] & 3;

        if (texture != null && texture[i] != -1) {
            int texture_a = j;
            int texture_b = k;
            int texture_c = l;
            if (texture_coordinates != null && texture_coordinates[i] != -1) {
                int coordinate = texture_coordinates[i] & 0xff;
                texture_a = anIntArray1643[coordinate];
                texture_b = anIntArray1644[coordinate];
                texture_c = anIntArray1645[coordinate];
            }
            if (anIntArray1636[i] == -1 || type == 3) {
                Rasterizer.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l]);
            } else {
                if (texture_b >= 0) {
                    Rasterizer.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l]);
                }
            }
        } else {
            if (type == 0) {
                Rasterizer.drawGouraudTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l], forceHd);
                return;
            }
            if (type == 1) {
                Rasterizer.drawTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], modelIntArray3[anIntArray1634[i]], anIntArray1670[j], anIntArray1670[k], anIntArray1670[l]);
                return;
            }
        }
    }

    private final void method485(int i) {
        if (currentModelColors != null)
            if (currentModelColors[i] == 65535)
                return;
        int j = Rasterizer.centerX;
        int k = Rasterizer.centerY;
        int l = 0;
        int i1 = anIntArray1631[i];
        int j1 = anIntArray1632[i];
        int k1 = anIntArray1633[i];
        int l1 = anIntArray1670[i1];
        int i2 = anIntArray1670[j1];
        int j2 = anIntArray1670[k1];

        if (l1 >= 50) {
            anIntArray1678[l] = anIntArray1665[i1];
            anIntArray1679[l] = anIntArray1666[i1];
            anIntArray1680[l++] = anIntArray1634[i];
        } else {
            int k2 = anIntArray1668[i1];
            int k3 = anIntArray1669[i1];
            int k4 = anIntArray1634[i];
            if (j2 >= 50) {
                int k5 = (50 - l1) * modelIntArray4[j2 - l1];
                anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (k3 + ((anIntArray1669[k1] - k3) * k5 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = k4 + ((anIntArray1636[i] - k4) * k5 >> 16);
            }
            if (i2 >= 50) {
                int l5 = (50 - l1) * modelIntArray4[i2 - l1];
                anIntArray1678[l] = j + (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (k3 + ((anIntArray1669[j1] - k3) * l5 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = k4 + ((anIntArray1635[i] - k4) * l5 >> 16);
            }
        }
        if (i2 >= 50) {
            anIntArray1678[l] = anIntArray1665[j1];
            anIntArray1679[l] = anIntArray1666[j1];
            anIntArray1680[l++] = anIntArray1635[i];
        } else {
            int l2 = anIntArray1668[j1];
            int l3 = anIntArray1669[j1];
            int l4 = anIntArray1635[i];
            if (l1 >= 50) {
                int i6 = (50 - i2) * modelIntArray4[l1 - i2];
                anIntArray1678[l] = j + (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (l3 + ((anIntArray1669[i1] - l3) * i6 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = l4 + ((anIntArray1634[i] - l4) * i6 >> 16);
            }
            if (j2 >= 50) {
                int j6 = (50 - i2) * modelIntArray4[j2 - i2];
                anIntArray1678[l] = j + (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (l3 + ((anIntArray1669[k1] - l3) * j6 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = l4 + ((anIntArray1636[i] - l4) * j6 >> 16);
            }
        }
        if (j2 >= 50) {
            anIntArray1678[l] = anIntArray1665[k1];
            anIntArray1679[l] = anIntArray1666[k1];
            anIntArray1680[l++] = anIntArray1636[i];
        } else {
            int i3 = anIntArray1668[k1];
            int i4 = anIntArray1669[k1];
            int i5 = anIntArray1636[i];
            if (i2 >= 50) {
                int k6 = (50 - j2) * modelIntArray4[i2 - j2];
                anIntArray1678[l] = j + (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (i4 + ((anIntArray1669[j1] - i4) * k6 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = i5 + ((anIntArray1635[i] - i5) * k6 >> 16);
            }
            if (l1 >= 50) {
                int l6 = (50 - j2) * modelIntArray4[l1 - j2];
                anIntArray1678[l] = j + (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16) << Client.viewDistance) / 50;
                anIntArray1679[l] = k + (i4 + ((anIntArray1669[i1] - i4) * l6 >> 16) << Client.viewDistance) / 50;
                anIntArray1680[l++] = i5 + ((anIntArray1634[i] - i5) * l6 >> 16);
            }
        }
        int j3 = anIntArray1678[0];
        int j4 = anIntArray1678[1];
        int j5 = anIntArray1678[2];
        int i7 = anIntArray1679[0];
        int j7 = anIntArray1679[1];
        int k7 = anIntArray1679[2];
        if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
            Rasterizer.checkBounds = false;
            int texture_a = i1;
            int texture_b = j1;
            int texture_c = k1;
            if (l == 3) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX)
                    Rasterizer.checkBounds = true;

                int l7;
                if (anIntArray1637 == null)
                    l7 = 0;
                else
                    l7 = anIntArray1637[i] & 3;

                if (texture != null && texture[i] != -1) {
                    if (texture_coordinates != null && texture_coordinates[i] != -1) {
                        int coordinate = texture_coordinates[i] & 0xff;
                        texture_a = anIntArray1643[coordinate];
                        texture_b = anIntArray1644[coordinate];
                        texture_c = anIntArray1645[coordinate];
                    }
                    if (anIntArray1636[i] == -1) {
                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                    } else {
                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                    }
                } else {
                    if (l7 == 0)
                        Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], -1f, -1f, -1f, true);

                    else if (l7 == 1)
                        Rasterizer.drawTriangle(i7, j7, k7, j3, j4, j5, modelIntArray3[anIntArray1634[i]], -1f, -1f, -1f);
                }
            }
            if (l == 4) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX || anIntArray1678[3] < 0 || anIntArray1678[3] > DrawingArea.centerX)
                    Rasterizer.checkBounds = true;
                int type;
                if (anIntArray1637 == null)
                    type = 0;
                else
                    type = anIntArray1637[i] & 3;

                if (texture != null && texture[i] != -1) {
                    if (texture_coordinates != null && texture_coordinates[i] != -1) {
                        int coordinate = texture_coordinates[i] & 0xff;
                        texture_a = anIntArray1643[coordinate];
                        texture_b = anIntArray1644[coordinate];
                        texture_c = anIntArray1645[coordinate];
                    }
                    if (anIntArray1636[i] == -1) {
                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                        Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                    } else {
                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                        Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], texture[i], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                        return;
                    }
                } else {
                    if (type == 0) {
                        Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], -1f, -1f, -1f, true);
                        Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1], true);
                        return;
                    }
                    if (type == 1) {
                        int l8 = modelIntArray3[anIntArray1634[i]];
                        Rasterizer.drawTriangle(i7, j7, k7, j3, j4, j5, l8, -1f, -1f, -1f);
                        Rasterizer.drawTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8, anIntArray1670[i1], anIntArray1670[j1], anIntArray1670[k1]);
                        return;
                    }
                }
            }
        }
    }

    private final boolean method486(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        if (j < k && j < l && j < i1)
            return false;
        if (j > k && j > l && j > i1)
            return false;
        if (i < j1 && i < k1 && i < l1)
            return false;
        return i <= j1 || i <= k1 || i <= l1;
    }

    public void setTexture(int fromColor, int tex) {
        int foundAmt = 0;
        int set2 = 0;
        for (int i = 0; i < currentModelColors.length; i++) {
            if (fromColor == currentModelColors[i]) {
                foundAmt++;
            }
        }
        anInt1642 = foundAmt;
        if (anIntArray1637 == null) {
            anIntArray1637 = new int[foundAmt];
        }
        if (currentModelColors == null) {
            currentModelColors = new short[foundAmt];
        }
        anIntArray1643 = new short[foundAmt];
        anIntArray1644 = new short[foundAmt];
        anIntArray1645 = new short[foundAmt];
        int assigned = 0;
        for (int i = 0; i < totalModelColors; i++) {
            if (fromColor == currentModelColors[i]) {
                currentModelColors[i] = (short) tex;
                anIntArray1637[i] = 3 + set2;
                set2 += 4;
                anIntArray1643[assigned] = (short) anIntArray1631[i];
                anIntArray1644[assigned] = (short) anIntArray1632[i];
                anIntArray1645[assigned] = (short) anIntArray1633[i];
                assigned++;
            }
        }
    }
}