public class LiveProgramming {

	public static void main(String[] args) {
		
		int y = 0;
		while(y < 5) {
			int x = 0;
			while(x < 5) {
				
				if(x == y) {
					System.out.print(1 + " ");
				}
				else {
					System.out.print(0 + " ");
				}

				x++;
			}
			System.out.print("\n");
			y++;
		}

	}

}
