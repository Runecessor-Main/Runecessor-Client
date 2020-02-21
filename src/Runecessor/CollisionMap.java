package Runecessor;

final class CollisionMap {

	public CollisionMap() {
		anInt290 = 0;
		anInt291 = 0;
		sizeX = 104;
		sizeY = 104;
		flags = new int[sizeX][sizeY];
		reset();
	}

	public void reset() {
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++)
				if (i == 0 || j == 0 || i == sizeX - 1 || j == sizeY - 1)
					flags[i][j] = 0xffffff;
				else
					flags[i][j] = 0x1000000;

		}

	}

	public void addWall(int i, int j, int k, int l, boolean flag) {
		k -= anInt290;
		i -= anInt291;
		if (l == 0) {
			if (j == 0) {
				add(k, i, 128);
				add(k - 1, i, 8);
			}
			if (j == 1) {
				add(k, i, 2);
				add(k, i + 1, 32);
			}
			if (j == 2) {
				add(k, i, 8);
				add(k + 1, i, 128);
			}
			if (j == 3) {
				add(k, i, 32);
				add(k, i - 1, 2);
			}
		}
		if (l == 1 || l == 3) {
			if (j == 0) {
				add(k, i, 1);
				add(k - 1, i + 1, 16);
			}
			if (j == 1) {
				add(k, i, 4);
				add(k + 1, i + 1, 64);
			}
			if (j == 2) {
				add(k, i, 16);
				add(k + 1, i - 1, 1);
			}
			if (j == 3) {
				add(k, i, 64);
				add(k - 1, i - 1, 4);
			}
		}
		if (l == 2) {
			if (j == 0) {
				add(k, i, 130);
				add(k - 1, i, 8);
				add(k, i + 1, 32);
			}
			if (j == 1) {
				add(k, i, 10);
				add(k, i + 1, 32);
				add(k + 1, i, 128);
			}
			if (j == 2) {
				add(k, i, 40);
				add(k + 1, i, 128);
				add(k, i - 1, 2);
			}
			if (j == 3) {
				add(k, i, 160);
				add(k, i - 1, 2);
				add(k - 1, i, 8);
			}
		}
		if (flag) {
			if (l == 0) {
				if (j == 0) {
					add(k, i, 0x10000);
					add(k - 1, i, 4096);
				}
				if (j == 1) {
					add(k, i, 1024);
					add(k, i + 1, 16384);
				}
				if (j == 2) {
					add(k, i, 4096);
					add(k + 1, i, 0x10000);
				}
				if (j == 3) {
					add(k, i, 16384);
					add(k, i - 1, 1024);
				}
			}
			if (l == 1 || l == 3) {
				if (j == 0) {
					add(k, i, 512);
					add(k - 1, i + 1, 8192);
				}
				if (j == 1) {
					add(k, i, 2048);
					add(k + 1, i + 1, 32768);
				}
				if (j == 2) {
					add(k, i, 8192);
					add(k + 1, i - 1, 512);
				}
				if (j == 3) {
					add(k, i, 32768);
					add(k - 1, i - 1, 2048);
				}
			}
			if (l == 2) {
				if (j == 0) {
					add(k, i, 0x10400);
					add(k - 1, i, 4096);
					add(k, i + 1, 16384);
				}
				if (j == 1) {
					add(k, i, 5120);
					add(k, i + 1, 16384);
					add(k + 1, i, 0x10000);
				}
				if (j == 2) {
					add(k, i, 20480);
					add(k + 1, i, 0x10000);
					add(k, i - 1, 1024);
				}
				if (j == 3) {
					add(k, i, 0x14000);
					add(k, i - 1, 1024);
					add(k - 1, i, 4096);
				}
			}
		}
	}

	public void addObject(boolean flag, int j, int k, int l, int i1, int j1, int objectId) {
		int k1 = 256;
		if (flag)
			k1 += 0x20000;
		l -= anInt290;
		i1 -= anInt291;
		if (j1 == 1 || j1 == 3) {
			int l1 = j;
			j = k;
			k = l1;
		}
		for (int i2 = l; i2 < l + j; i2++) {
			if (i2 >= 0 && i2 < sizeX) {
				for (int j2 = i1; j2 < i1 + k; j2++) {
					if (j2 >= 0 && j2 < sizeY) {
						add(i2, j2, k1);
					}
				}

			}
		}

	}

	public void setSolid(int i, int k) {
		k -= anInt290;
		i -= anInt291;
		flags[k][i] |= 0x200000;
	}

	private void add(int i, int j, int k) {
		flags[i][j] |= k;
	}

	public void removeWall(int i, int j, boolean flag, int k, int l) {
		k -= anInt290;
		l -= anInt291;
		if (j == 0) {
			if (i == 0) {
				remove(128, k, l);
				remove(8, k - 1, l);
			}
			if (i == 1) {
				remove(2, k, l);
				remove(32, k, l + 1);
			}
			if (i == 2) {
				remove(8, k, l);
				remove(128, k + 1, l);
			}
			if (i == 3) {
				remove(32, k, l);
				remove(2, k, l - 1);
			}
		}
		if (j == 1 || j == 3) {
			if (i == 0) {
				remove(1, k, l);
				remove(16, k - 1, l + 1);
			}
			if (i == 1) {
				remove(4, k, l);
				remove(64, k + 1, l + 1);
			}
			if (i == 2) {
				remove(16, k, l);
				remove(1, k + 1, l - 1);
			}
			if (i == 3) {
				remove(64, k, l);
				remove(4, k - 1, l - 1);
			}
		}
		if (j == 2) {
			if (i == 0) {
				remove(130, k, l);
				remove(8, k - 1, l);
				remove(32, k, l + 1);
			}
			if (i == 1) {
				remove(10, k, l);
				remove(32, k, l + 1);
				remove(128, k + 1, l);
			}
			if (i == 2) {
				remove(40, k, l);
				remove(128, k + 1, l);
				remove(2, k, l - 1);
			}
			if (i == 3) {
				remove(160, k, l);
				remove(2, k, l - 1);
				remove(8, k - 1, l);
			}
		}
		if (flag) {
			if (j == 0) {
				if (i == 0) {
					remove(0x10000, k, l);
					remove(4096, k - 1, l);
				}
				if (i == 1) {
					remove(1024, k, l);
					remove(16384, k, l + 1);
				}
				if (i == 2) {
					remove(4096, k, l);
					remove(0x10000, k + 1, l);
				}
				if (i == 3) {
					remove(16384, k, l);
					remove(1024, k, l - 1);
				}
			}
			if (j == 1 || j == 3) {
				if (i == 0) {
					remove(512, k, l);
					remove(8192, k - 1, l + 1);
				}
				if (i == 1) {
					remove(2048, k, l);
					remove(32768, k + 1, l + 1);
				}
				if (i == 2) {
					remove(8192, k, l);
					remove(512, k + 1, l - 1);
				}
				if (i == 3) {
					remove(32768, k, l);
					remove(2048, k - 1, l - 1);
				}
			}
			if (j == 2) {
				if (i == 0) {
					remove(0x10400, k, l);
					remove(4096, k - 1, l);
					remove(16384, k, l + 1);
				}
				if (i == 1) {
					remove(5120, k, l);
					remove(16384, k, l + 1);
					remove(0x10000, k + 1, l);
				}
				if (i == 2) {
					remove(20480, k, l);
					remove(0x10000, k + 1, l);
					remove(1024, k, l - 1);
				}
				if (i == 3) {
					remove(0x14000, k, l);
					remove(1024, k, l - 1);
					remove(4096, k - 1, l);
				}
			}
		}
	}

	public void removeObject(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = 256;
		if (flag)
			j1 += 0x20000;
		k -= anInt290;
		l -= anInt291;
		if (i == 1 || i == 3) {
			int k1 = j;
			j = i1;
			i1 = k1;
		}
		for (int l1 = k; l1 < k + j; l1++)
			if (l1 >= 0 && l1 < sizeX) {
				for (int i2 = l; i2 < l + i1; i2++)
					if (i2 >= 0 && i2 < sizeY)
						remove(j1, l1, i2);

			}

	}

	private void remove(int i, int j, int k) {
		flags[j][k] &= 0xffffff - i;
	}

	public void method218(int j, int k) {
		k -= anInt290;
		j -= anInt291;
		flags[k][j] &= 0xdfffff;
	}

	public boolean atWall(int i, int j, int k, int i1, int j1, int k1) {
		if (j == i && k == k1)
			return true;
		j -= anInt290;
		k -= anInt291;
		i -= anInt290;
		k1 -= anInt291;
		if (j1 == 0)
			if (i1 == 0) {
				if (j == i - 1 && k == k1)
					return true;
				if (j == i && k == k1 + 1 && (flags[j][k] & 0x1280120) == 0)
					return true;
				if (j == i && k == k1 - 1 && (flags[j][k] & 0x1280102) == 0)
					return true;
			}
			else if (i1 == 1) {
				if (j == i && k == k1 + 1)
					return true;
				if (j == i - 1 && k == k1 && (flags[j][k] & 0x1280108) == 0)
					return true;
				if (j == i + 1 && k == k1 && (flags[j][k] & 0x1280180) == 0)
					return true;
			}
			else if (i1 == 2) {
				if (j == i + 1 && k == k1)
					return true;
				if (j == i && k == k1 + 1 && (flags[j][k] & 0x1280120) == 0)
					return true;
				if (j == i && k == k1 - 1 && (flags[j][k] & 0x1280102) == 0)
					return true;
			}
			else if (i1 == 3) {
				if (j == i && k == k1 - 1)
					return true;
				if (j == i - 1 && k == k1 && (flags[j][k] & 0x1280108) == 0)
					return true;
				if (j == i + 1 && k == k1 && (flags[j][k] & 0x1280180) == 0)
					return true;
			}
		if (j1 == 2)
			if (i1 == 0) {
				if (j == i - 1 && k == k1)
					return true;
				if (j == i && k == k1 + 1)
					return true;
				if (j == i + 1 && k == k1 && (flags[j][k] & 0x1280180) == 0)
					return true;
				if (j == i && k == k1 - 1 && (flags[j][k] & 0x1280102) == 0)
					return true;
			}
			else if (i1 == 1) {
				if (j == i - 1 && k == k1 && (flags[j][k] & 0x1280108) == 0)
					return true;
				if (j == i && k == k1 + 1)
					return true;
				if (j == i + 1 && k == k1)
					return true;
				if (j == i && k == k1 - 1 && (flags[j][k] & 0x1280102) == 0)
					return true;
			}
			else if (i1 == 2) {
				if (j == i - 1 && k == k1 && (flags[j][k] & 0x1280108) == 0)
					return true;
				if (j == i && k == k1 + 1 && (flags[j][k] & 0x1280120) == 0)
					return true;
				if (j == i + 1 && k == k1)
					return true;
				if (j == i && k == k1 - 1)
					return true;
			}
			else if (i1 == 3) {
				if (j == i - 1 && k == k1)
					return true;
				if (j == i && k == k1 + 1 && (flags[j][k] & 0x1280120) == 0)
					return true;
				if (j == i + 1 && k == k1 && (flags[j][k] & 0x1280180) == 0)
					return true;
				if (j == i && k == k1 - 1)
					return true;
			}
		if (j1 == 9) {
			if (j == i && k == k1 + 1 && (flags[j][k] & 0x20) == 0)
				return true;
			if (j == i && k == k1 - 1 && (flags[j][k] & 2) == 0)
				return true;
			if (j == i - 1 && k == k1 && (flags[j][k] & 8) == 0)
				return true;
			if (j == i + 1 && k == k1 && (flags[j][k] & 0x80) == 0)
				return true;
		}
		return false;
	}

	public boolean atDecoration(int i, int j, int k, int l, int i1, int j1) {
		if (j1 == i && k == j)
			return true;
		j1 -= anInt290;
		k -= anInt291;
		i -= anInt290;
		j -= anInt291;
		if (l == 6 || l == 7) {
			if (l == 7)
				i1 = i1 + 2 & 3;
			if (i1 == 0) {
				if (j1 == i + 1 && k == j && (flags[j1][k] & 0x80) == 0)
					return true;
				if (j1 == i && k == j - 1 && (flags[j1][k] & 2) == 0)
					return true;
			}
			else if (i1 == 1) {
				if (j1 == i - 1 && k == j && (flags[j1][k] & 8) == 0)
					return true;
				if (j1 == i && k == j - 1 && (flags[j1][k] & 2) == 0)
					return true;
			}
			else if (i1 == 2) {
				if (j1 == i - 1 && k == j && (flags[j1][k] & 8) == 0)
					return true;
				if (j1 == i && k == j + 1 && (flags[j1][k] & 0x20) == 0)
					return true;
			}
			else if (i1 == 3) {
				if (j1 == i + 1 && k == j && (flags[j1][k] & 0x80) == 0)
					return true;
				if (j1 == i && k == j + 1 && (flags[j1][k] & 0x20) == 0)
					return true;
			}
		}
		if (l == 8) {
			if (j1 == i && k == j + 1 && (flags[j1][k] & 0x20) == 0)
				return true;
			if (j1 == i && k == j - 1 && (flags[j1][k] & 2) == 0)
				return true;
			if (j1 == i - 1 && k == j && (flags[j1][k] & 8) == 0)
				return true;
			if (j1 == i + 1 && k == j && (flags[j1][k] & 0x80) == 0)
				return true;
		}
		return false;
	}

	public boolean atObject(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = (j + j1) - 1;
		int i2 = (i + l) - 1;
		if (k >= j && k <= l1 && k1 >= i && k1 <= i2)
			return true;
		if (k == j - 1 && k1 >= i && k1 <= i2 && (flags[k - anInt290][k1 - anInt291] & 8) == 0 && (i1 & 8) == 0)
			return true;
		if (k == l1 + 1 && k1 >= i && k1 <= i2 && (flags[k - anInt290][k1 - anInt291] & 0x80) == 0 && (i1 & 2) == 0)
			return true;
		return k1 == i - 1 && k >= j && k <= l1 && (flags[k - anInt290][k1 - anInt291] & 2) == 0 && (i1 & 4) == 0 || k1 == i2 + 1 && k >= j && k <= l1 && (flags[k - anInt290][k1 - anInt291] & 0x20) == 0 && (i1 & 1) == 0;
	}

	private final int anInt290;

	private final int anInt291;

	private final int sizeX;

	private final int sizeY;

	public final int[][] flags;
}
