import java.util.Arrays;


class ArraySet {

	protected boolean set[]; //true if the element is in the set
	private int size;

	ArraySet () {
		size = 50;
		set = new boolean[size];
		for(int i = 0; i<size; i++)
			set[i] = false;
	}
	
	//return true if add is changing the arraySet
	public boolean add(int i) {

		if(i>=size) {
			//enlarge the set
			boolean temp[] = new boolean[size*2];
			Arrays.fill(temp, false); //set all the elements to false
			System.arraycopy(set, 0, temp, 0, size); //copy the old set
			set = temp;
		}	

		boolean added = set[i];
		set[i] = true;
		if(i>=size)
			size = i+1; 

		return !added; 
		/*
		 * inizialmente set[] sono tutti false quindi se dopo la riga28 set[i] diventa true, allora restituisce true (add a buon fine),
		 * se set[i] è gia true, allora la riga28 non cambia lo stato di set, quindi restituisce false
		 */
	}
	
	public boolean delete(int i) {

		if(i<size) {
			boolean deleted = set[i];
			set[i]=false;

			if(i==size-1) {
				//update size
				int j;
				for(j = size-1; j>=0 && !set[j]; j--)
				size=j+1;
			}
			return deleted;
		}

		return false;
	}
	
	public boolean get(int i) {
		return set[i];
	}
	
	/*
	 * dove arraySet è true allora int a[i] = i
	 */
	public int[] toArray() { 

		int a[] = new int[0];
		for(int i = 0; i<size; i++) 
		{
			if(get(i)) 
			{
				int temp[] = new int[a.length+1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a = temp; 
				a[a.length-1] = i;
			}
		}
		return a;
	}
}
