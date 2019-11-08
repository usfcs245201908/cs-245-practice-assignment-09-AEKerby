public class BinaryHeap{

    private int [] arr;
	private int size;

	public BinaryHeap(){
		arr = new int [10];
		size = 0;
	}

	public void add(int priority) {
		if (size == arr.length){
			growArray();
		}
		arr[size] = priority;
		size++;
		int index = size - 1;
		int parent = (index - 1)/2;
		while (index > 0 && arr[index] < arr[parent]){
			swap(index, parent, arr);
			index = parent;
			parent = (index - 1)/2;
		}
	}

	public int remove(){
		int temp = arr[0];
		arr[0] = arr[size - 1];
		size--;
		shiftdown(0);
		return temp;
	}

	void shiftdown(int parent){
		int child = parent * 2 + 1;
		if (child >= size){
			return;
		}
		if (arr[child + 1] < arr[child]){
			child++;
		}
		if (arr[parent] > arr[child]){
			swap(child, parent, arr);
			shiftdown(child);
		}
	}

    public void growArray(){
        int [] newArr = new int [arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void swap(int a, int b, int [] array){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
