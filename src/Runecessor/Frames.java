package Runecessor;

public final class Frames {

	public static void method528(int i) {
		animationlist = new Frames[4100][0];
	}

	public static void nullLoader() {
		animationlist = null;
	}

	// Animations up to file id 2000 on 139 data.
	public static Frames get(int j) {
		// j is one of the primary variables in the Animation class.
		// So for Cerberus it is going to be any of the following:
		/*
		 * anims[13700].primary = new int[14];
		anims[13700].primary[0] = 117309461;
		anims[13700].primary[1] = 117309547;
		anims[13700].primary[2] = 117309462;
		anims[13700].primary[3] = 117309623;
		anims[13700].primary[4] = 117309548;
		anims[13700].primary[5] = 117309621;
		anims[13700].primary[6] = 117309454;
		anims[13700].primary[7] = 117309599;
		anims[13700].primary[8] = 117309473;
		anims[13700].primary[9] = 117309488;
		anims[13700].primary[10] = 117309559;
		anims[13700].primary[11] = 117309541;
		anims[13700].primary[12] = 117309588;
		anims[13700].primary[13] = 117309622;
		 */
		// if file == 1790, check if the j is equal to one of the primary arrays above, if it is, change file id to a different one.


		try {
			String s = "";
			int file = 0;
			int k = 0;
			s = Integer.toHexString(j);
			file = Integer.parseInt(s.substring(0, s.length() - 4), 16);
			k = Integer.parseInt(s.substring(s.length() - 4), 16);

			// On the osrs client, it uses 1790 file id for the animation, i got to change it to an unused id so it doesn't ruin my other animations.
			// It decrypts the file id from the primary array.
			// Some file ids can manage multiple animations.
      		file = customAnimationsOsrs(file, j);

			if (animationlist[file].length == 0) {
				Client.onDemandFetcher.sendImmediately(1, file);
				return null;
			}
			if (file > animationlist.length - 1) {
				return null;
			}
			if (k > animationlist[file].length - 1) {
				return null;
			}
			return animationlist[file][k];
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

  private static int customAnimationsOsrs(int file, int j) {
		if (Config.PRE_EOC) {
      return file;
		}
		boolean foundMatch = false;
		int newFileId = 0;
		int animationId = 0;
		if (file == 1887) {
			// Dark beast death animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11021;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// Dark beast attack
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11020;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// Dark beast walk
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11018;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// Dark beast stand
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11017;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// Dark beast block
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11026;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// hellhound walk animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11031;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// hellhound stand animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11030;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// hellhound block animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11029;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// hellhound death animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11028;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}

			// hellhound attack animation
			if (!foundMatch) {
				newFileId = 4000;
				animationId = 11027;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
		}
		else if (file == 1893) {
			// Ork death animation
			if (!foundMatch) {
				newFileId = 4002;
				animationId = 11019;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
			// Ork walk
			if (!foundMatch) {
				newFileId = 4002;
				animationId = 11025;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
			// Ork stand
			if (!foundMatch) {
				newFileId = 4002;
				animationId = 11024;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
			// ork death animation
			if (!foundMatch) {
				newFileId = 4002;
				animationId = 11023;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
			// ork attack animation
			if (!foundMatch) {
				newFileId = 4002;
				animationId = 11022;
				for (int index = 0; index < Sequences.anims[animationId].primary.length; index++) {
					if (Sequences.anims[animationId].primary[index] == j) {
						file = newFileId;
						foundMatch = true;
						break;
					}
				}
			}
		}
    return file;
	}

	public static boolean isNegativeZero(int i) {
		return i == -1;
	}

	private Frames() {
	}

	public static void loadPreEoc(int file, byte[] fileData) {
		try {
			final Stream ay = new Stream(fileData);
			final FramesBase b2 = new FramesBase(ay);
			final int n = ay.readUnsignedWord();
			animationlist[file] = new Frames[5000];
			final int[] array2 = new int[500];
			final int[] array3 = new int[500];
			final int[] array4 = new int[500];
			final int[] array5 = new int[500];
			for (int j = 0; j < n; ++j) {
				final int k = ay.readUnsignedWord();
				final Frames[] array6 = animationlist[file];
				final int n2 = k;
				final Frames q = new Frames();
				array6[n2] = q;
				final Frames q2 = q;
				q.skinlist = b2;
				final int f = ay.readUnsignedByte();
				int c2 = 0;
				int n3 = -1;
				for (int l = 0; l < f; ++l) {
					final int f2;
					if ((f2 = ay.readUnsignedByte()) > 0) {
						if (b2.opcode[l] != 0) {
							for (int n4 = l - 1; n4 > n3; --n4) {
								if (b2.opcode[n4] == 0) {
									array2[c2] = n4;
									array3[c2] = 0;
									array5[c2] = (array4[c2] = 0);
									++c2;
									break;
								}
							}
						}
						array2[c2] = l;
						int n4 = 0;
						if (b2.opcode[l] == 3) {
							n4 = 128;
						}
						if ((f2 & 0x1) != 0x0) {
							array3[c2] = ay.readShort2();
						}
						else {
							array3[c2] = n4;
						}
						if ((f2 & 0x2) != 0x0) {
							array4[c2] = ay.readShort2();
						}
						else {
							array4[c2] = n4;
						}
						if ((f2 & 0x4) != 0x0) {
							array5[c2] = ay.readShort2();
						}
						else {
							array5[c2] = n4;
						}
						n3 = l;
						++c2;
					}
				}
				q2.stepcount = c2;
				q2.opcodeLinkTable = new int[c2];
				q2.modifier1 = new int[c2];
				q2.modifier2 = new int[c2];
				q2.modifier3 = new int[c2];
				for (int l = 0; l < c2; ++l) {
					q2.opcodeLinkTable[l] = array2[l];
					q2.modifier1[l] = array3[l];
					q2.modifier2[l] = array4[l];
					q2.modifier3[l] = array5[l];
				}
			}
		}
		catch (Exception e) {
			if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
				e.printStackTrace();
			}
		}
	}

	public static void loadOsrs(int file, byte[] fileData) {
		try {
			final Stream ay = new Stream(fileData);
			final FramesBase b2 = new FramesBase(ay);
			final int n = ay.readUnsignedWord();
			animationlist[file] = new Frames[5000];
			final int[] array2 = new int[500];
			final int[] array3 = new int[500];
			final int[] array4 = new int[500];
			final int[] array5 = new int[500];
			for (int j = 0; j < n; ++j) {
				final int k = ay.readUnsignedWord();
				final Frames[] array6 = animationlist[file];
				final int n2 = k;
				final Frames q = new Frames();
				array6[n2] = q;
				final Frames q2 = q;
				q.skinlist = b2;
				final int f = ay.readUnsignedByte();
				int c2 = 0;
				int n3 = -1;
				for (int l = 0; l < f; ++l) {
					final int f2;
					if ((f2 = ay.readUnsignedByte()) > 0) {
						if (b2.opcode[l] != 0) {
							for (int n4 = l - 1; n4 > n3; --n4) {
								if (b2.opcode[n4] == 0) {
									array2[c2] = n4;
									array3[c2] = 0;
									array5[c2] = (array4[c2] = 0);
									++c2;
									break;
								}
							}
						}
						array2[c2] = l;
						int n4 = 0;
						if (b2.opcode[l] == 3) {
							n4 = 128;
						}
						if ((f2 & 0x1) != 0x0) {
							array3[c2] = ay.readShort2();
						}
						else {
							array3[c2] = n4;
						}
						if ((f2 & 0x2) != 0x0) {
							array4[c2] = ay.readShort2();
						}
						else {
							array4[c2] = n4;
						}
						if ((f2 & 0x4) != 0x0) {
							array5[c2] = ay.readShort2();
						}
						else {
							array5[c2] = n4;
						}
						n3 = l;
						++c2;
					}
				}
				q2.stepcount = c2;
				q2.opcodeLinkTable = new int[c2];
				q2.modifier1 = new int[c2];
				q2.modifier2 = new int[c2];
				q2.modifier3 = new int[c2];
				for (int l = 0; l < c2; ++l) {
					q2.opcodeLinkTable[l] = array2[l];
					q2.modifier1[l] = array3[l];
					q2.modifier2[l] = array4[l];
					q2.modifier3[l] = array5[l];
				}
			}
		}
		catch (Exception e) {
			if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
				e.printStackTrace();
			}
		}
	}


	public static Frames animationlist[][];

	public FramesBase skinlist;

	public int stepcount;

	public int opcodeLinkTable[];

	public int modifier1[];

	public int modifier2[];

	public int modifier3[];

}