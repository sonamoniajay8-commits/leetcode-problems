class ProductOfNumbers {
    private List<Integer> pref;

    public ProductOfNumbers() {
        pref = new ArrayList<>();
        pref.add(1);
        
    }
    
    public void add(int num) {
        if (num == 0) {
            pref.clear();
            pref.add(1);
        } else {
            int last = pref.get(pref.size() - 1);
            pref.add(last * num);
        }
        
    }
    
    public int getProduct(int k) {
        int n = pref.size() - 1;
        if (k > n) {
            return 0;
        }
        return pref.get(n) / pref.get(n - k);
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */