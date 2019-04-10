class Brett {
	private int[][] brett;
	int n;

	public Brett(int storrelse) {
		n = storrelse;
		brett = new int[n][n];
	}
	public static void main(String[] args) {
		System.out.println(" Merk at, startposisjonen til hesten er fra tallet 10 i utskriften");
		System.out.print("\n");
		// brettstørrelsen
		int storrelse= 6;
		// start posisjonen til hesten
		int startX= 2;
		int startY=2;
		//System.out.print("Hva er storrelsen paa brettet ?: ");
		//int storrelse = Integer.parseInt(System.console().readLine());
		
		//System.out.print("Angi radnr hesten skal plasseres i: ");
		//int startX = Integer.parseInt(System.console().readLine());
		//System.out.print("angi kolonnenr hesten skal plasseres i ");
		
		//int startY = Integer.parseInt(System.console().readLine());
		Brett hest = new Brett(storrelse);
		boolean OK = hest.prov(startX, startY, 0);
		if (OK) System.out.println(hest);
		else System.out.println("Fant ingen løsning");
	}
	public String toString() {
		String res = "";
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				res += brett[i][j] + " ";
			}
			res += '\n';
		}
		return res;
	}

	public boolean prov(int x, int y, int nr) {
		if (nr == n * n) return true;   // Ferdig
		if (x < 0 || x >= n || y < 0 || y >= n) return false;  // Ulovlig posisjon
		if (brett[x][y] > 0) return false; // Her har vi vært før
		brett[x][y] = 10 + nr;  // + 10 for å få alle tall tosifret (enklere ved utskrift)
		if (prov(x + 2, y + 1, nr + 1)) return true;
		if (prov(x + 2, y - 1, nr + 1)) return true;
		if (prov(x - 2, y + 1, nr + 1)) return true;
		if (prov(x - 2, y - 1, nr + 1)) return true;
		if (prov(x + 1, y + 2, nr + 1)) return true;
		if (prov(x + 1, y - 2, nr + 1)) return true;
		if (prov(x - 1, y + 2, nr + 1)) return true;
		if (prov(x - 1, y - 2, nr + 1)) return true;
		// Kom ikke fram på noen måter, må gå et skritt tilbake
		brett[x][y] = 0;
		return false;
	}

	
}