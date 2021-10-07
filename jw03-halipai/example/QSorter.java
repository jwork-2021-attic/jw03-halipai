package example;

public class QSorter implements Sorter {
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    public void quick(int left, int right){
        if(left >= right)    return;
        int base = a[left];
        int i = left, j = right;
        while(i < j){
            while(i < j && a[j] >= base){
                j--;
            }
            while(i < j && a[i] <= base){
                i++;
            }
            if(i < j){
                swap(i, j);
            }
        }
        if(i != left){
            swap(left, i);
        }
        quick(left, i-1);
        quick(i+1, right);
    }

    @Override
    public void sort() {
        int n = a.length;
        quick(0, n-1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}