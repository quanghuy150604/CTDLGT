public class PriorityQueue {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueue(int K) {
        this.capacity = K;
        this.queue = new int[K];
        this.size = 0;
    }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot insert.");
            return;
        }

        int index = size;
        queue[index] = val;
        size++;
        heapifyUp(index);
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return -1;
        }

        int minValue = queue[0];
        queue[0] = queue[size - 1];
        size--;
        heapifyDown(0);
        return minValue;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        while (index > 0 && queue[index] < queue[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < size && queue[leftChild] < queue[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < size && queue[rightChild] < queue[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    private void swap(int a, int b) {
        int temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }
}
